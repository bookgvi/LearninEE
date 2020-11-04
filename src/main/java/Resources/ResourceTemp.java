package Resources;

import EJB.LocalWithResource.DummyModelBean;
import EJB.LocalWithResource.SerializeDeserialize;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/temp")
public class ResourceTemp {
  private DummyModelBean dummyModelBean = DummyModelBean.getInstance();

  @EJB
  SerializeDeserialize serializeDeserialize;

  @GET
  @Path("dummytext")
  public Response getDummyText() {
    return Response.ok().entity("This is dummy text").build();
  }

  @GET
  public Response getDummy() {
    // TODO релазиовать JSON
    return Response.ok().entity(dummyModelBean.getDummyMap()).build();
  }

  @POST

  public Response addDummy(InputStream payload) {
    String msg = "default";

    BufferedReader buffer = new BufferedReader(new InputStreamReader(payload));
    JsonObject payloadJson = JsonParser.parseReader(buffer).getAsJsonObject();
    msg = payloadJson.get("msg").getAsString();

    Map<Integer, String> currentObj = dummyModelBean.setMsg(msg);

    // TODO релазиовать JSON

    return Response.status(Response.Status.CREATED).entity(currentObj).build();
  }
}

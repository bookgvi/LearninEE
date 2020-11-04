package Resources;

import EJB.LocalWithResource.SerializeDeserialize;
import com.google.gson.Gson;
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
  private Map<Integer, Object> dummy = new ConcurrentHashMap<>();
  private AtomicInteger id = new AtomicInteger();

  @EJB
  SerializeDeserialize serializeDeserialize;

  @GET
  @Path("dummytext")
  public Response getDummyText() {
    return Response.ok().entity("This is dummy text").build();
  }

  @GET
  public Response getDummy() {
    return Response.ok().entity(dummy).build();
  }

  @POST

  public Response addDummy(InputStream payload) {
    int id = this.id.incrementAndGet();
    String msg = "default";

    BufferedReader buffer = new BufferedReader(new InputStreamReader(payload));
    JsonObject payloadJson = JsonParser.parseReader(buffer).getAsJsonObject();
    msg = payloadJson.get("msg").getAsString();

    dummy.put(id, msg);

    System.out.print(serializeDeserialize.jsonSerialize(dummy));
    return Response.status(Response.Status.CREATED).entity(dummy.get(id)).build();
  }
}

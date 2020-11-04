package Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/temp")
public class ResourceTemp {
  @GET
  public Response getDummyText() {
    return Response.ok().entity("This is dummy text").build();
  }
}

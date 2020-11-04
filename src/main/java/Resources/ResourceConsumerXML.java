package Resources;

import EJB.Consumers.ConsumerXML;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/consumer/xml")
public class ResourceConsumerXML {
  private Map<Integer, ConsumerXML> consumerXMLHashMap = new HashMap<>();
  private AtomicInteger id = new AtomicInteger();

  @GET
  @Path("{id}")
  @Consumes("application/xml")
  public ConsumerXML getConsumerById(@PathParam("id") int id) {
    return consumerXMLHashMap.get(id);
  }

  @DELETE
  @Path("{id}")
  @Consumes("application/xml")
  public void deleteConsumerById(@PathParam("id") int id) {
    ConsumerXML removedConsumer = consumerXMLHashMap.remove(id);
    if (removedConsumer == null)
      throw new WebApplicationException(
        Response.status(Response.Status.NOT_FOUND).build()
      );
  }

  @PUT
  @Path("{id}")
  @Consumes("application/xml")
  public void updateConsumerById(@PathParam("id") int id,ConsumerXML updatedConsumer) {
    ConsumerXML currentConsumer = consumerXMLHashMap.get(id);
    currentConsumer.firstName = updatedConsumer.firstName;
    currentConsumer.lastName = updatedConsumer.lastName;
    currentConsumer.email = updatedConsumer.email;
    consumerXMLHashMap.put(id, currentConsumer);
  }

  @POST
  @Consumes("application/xml")
  public ConsumerXML addConsumer(ConsumerXML newConsumer) {
    newConsumer.id = this.id.incrementAndGet();
    consumerXMLHashMap.put(newConsumer.id, newConsumer);
    return newConsumer;
  }
}

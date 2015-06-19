package demo.client.shared;

import javax.ws.rs.Path;
import demo.client.shared.AddressFormModel;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

@Path("address")
public interface AddressRestService
{

   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public AddressFormModel create(AddressFormModel model);

   @Path("load")
   @GET
   @Produces("application/json")
   public List<AddressFormModel> load();

   @Path("update")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Boolean update(AddressFormModel model);

   @Path("delete")
   @DELETE
   @Consumes("application/json")
   @Produces("application/json")
   public Boolean delete(AddressFormModel model);
}
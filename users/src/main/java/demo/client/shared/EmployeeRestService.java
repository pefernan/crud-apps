package demo.client.shared;

import javax.ws.rs.Path;
import demo.client.shared.EmployeeFormModel;
import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

@Path("employee")
public interface EmployeeRestService
{

   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public EmployeeFormModel create(EmployeeFormModel model);

   @Path("load")
   @GET
   @Produces("application/json")
   public List<EmployeeFormModel> load();

   @Path("update")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Boolean update(EmployeeFormModel model);

   @Path("delete")
   @DELETE
   @Consumes("application/json")
   @Produces("application/json")
   public Boolean delete(EmployeeFormModel model);
}
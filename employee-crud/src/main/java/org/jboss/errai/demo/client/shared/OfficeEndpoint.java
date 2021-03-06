package org.jboss.errai.demo.client.shared;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/office")
public interface OfficeEndpoint {

  @GET
  @Produces("application/json")
  public Office get( Long id );
  
  @GET
  @Path("/list")
  @Produces("application/json")
  public List<Office> listAll();
  
  @POST
  @Consumes("application/json")
  public Response create( Office entity );

  @PUT
  @Path("/{id:[0-9]+}")
  @Consumes("application/json")
  public Response update( @PathParam("id") Long id, Office entity );

  @DELETE
  @Path("/{id:[0-9]+}")
  public Response delete( @PathParam("id") Long id );
  
}

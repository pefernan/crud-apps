package org.jboss.errai.demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.errai.demo.client.shared.Office;
import org.jboss.errai.demo.client.shared.OfficeEndpoint;
import org.jboss.errai.demo.client.shared.OfficeEvent;

@Stateless
public class OfficeEndpointImpl implements OfficeEndpoint {

  @Inject
  private Event<OfficeEvent> officeEvent;

  @Inject
  private OfficeService officeService;

  @Override
  public Office get(Long id) {
    return officeService.getById(id);
  }

  @Override
  public List<Office> listAll() {
    return officeService.listAll();
  }
  
  @Override
  public Response create(Office entity) {
    officeService.create( entity );
    officeEvent.fire( new OfficeEvent() );
    return Response.created(
            UriBuilder.fromResource(OfficeEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
  }

  @Override
  public Response update(Long id, Office entity) {
    officeService.update( id, entity );
    officeEvent.fire( new OfficeEvent() );
    return Response.ok().build();
  }

  @Override
  public Response delete(Long id) {
    officeService.delete( id );
    officeEvent.fire( new OfficeEvent() );
    return Response.noContent().build();
  }
}
package org.jboss.errai.demo.server;

import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import org.jboss.errai.demo.client.shared.Department;
import org.jboss.errai.demo.client.shared.DepartmentEndpoint;
import org.jboss.errai.demo.client.shared.DepartmentEvent;

@Stateless
public class DepartmentEndpointImpl implements DepartmentEndpoint {

  @Inject
  private Event<DepartmentEvent> departmentEvent;

  @Inject
  private DepartmentService departmentService;

  @Override
  public Department get(Long id) {
    return departmentService.getById(id);
  }

  @Override
  public List<Department> listAll() {
    return departmentService.listAll();
  }
  
  @Override
  public Response create(Department entity) {
    departmentService.create( entity );
    departmentEvent.fire( new DepartmentEvent() );
    return Response.created(
            UriBuilder.fromResource(DepartmentEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
  }

  @Override
  public Response update(Long id, Department entity) {
    departmentService.update( id, entity );
    departmentEvent.fire( new DepartmentEvent() );
    return Response.ok().build();
  }

  @Override
  public Response delete(Long id) {
    departmentService.delete( id );
    departmentEvent.fire( new DepartmentEvent() );
    return Response.noContent().build();
  }
}
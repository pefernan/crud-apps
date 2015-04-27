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
  private Event<DepartmentEvent> DepartmentEvent;

  @Inject
  private DepartmentService DepartmentService;

  @Override
  public Department get(Long id) {
    return DepartmentService.getById(id);
  }

  @Override
  public List<Department> listAll() {
    return DepartmentService.listAll();
  }
  
  @Override
  public Response create(Department entity) {
    DepartmentService.create(entity);
    DepartmentEvent.fire(new DepartmentEvent());
    return Response.created(
            UriBuilder.fromResource(DepartmentEndpoint.class).path(String.valueOf(entity.getId())).build()).build();
  }

  @Override
  public Response update(Long id, Department entity) {
    DepartmentService.update(id, entity);
    DepartmentEvent.fire(new DepartmentEvent());
    return Response.ok().build();
  }

  @Override
  public Response delete(Long id) {
    DepartmentService.delete(id);
    DepartmentEvent.fire(new DepartmentEvent());
    return Response.noContent().build();
  }
}
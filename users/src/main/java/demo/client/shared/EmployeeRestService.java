package demo.client.shared;

import javax.ws.rs.Path;

import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;

@Path("employee")
public interface EmployeeRestService extends LiveSparkRestService<EmployeeFormModel> {

}
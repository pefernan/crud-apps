package demo.client.shared;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;

@Path("children")
public interface ChildrenRestService extends LiveSparkRestService<ChildrenFormModel>
{
}
package demo.client.shared;

import javax.ws.rs.Path;
import demo.client.shared.AddressFormModel;
import org.livespark.formmodeler.rendering.client.shared.LiveSparkRestService;

import java.util.List;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

@Path("address")
public interface AddressRestService extends LiveSparkRestService<AddressFormModel>
{
}
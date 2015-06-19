package demo.client.local;

import org.jboss.errai.databinding.client.api.DataBinder;
import org.livespark.formmodeler.rendering.client.view.FormView;
import demo.client.shared.AddressFormModel;
import demo.client.shared.AddressRestService;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import javax.inject.Named;
import com.github.gwtbootstrap.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import com.github.gwtbootstrap.client.ui.IntegerBox;
import org.jboss.errai.common.client.api.RemoteCallback;

@Templated
@Named("AddressFormView")
public class AddressFormView extends FormView<AddressFormModel>
{

   @Inject
   @Bound(property = "address.street")
   @DataField
   private TextBox address_street;
   @Inject
   @Bound(property = "address.number")
   @DataField
   private IntegerBox address_number;
   @Inject
   @Bound(property = "address.door")
   @DataField
   private TextBox address_door;
   @Inject
   @Bound(property = "address.cp")
   @DataField
   private TextBox address_cp;
   @Inject
   @Bound(property = "address.city")
   @DataField
   private TextBox address_city;

   @Override
   public void initInputNames()
   {
      inputNames.add("address_street");
      inputNames.add("address_number");
      inputNames.add("address_door");
      inputNames.add("address_cp");
      inputNames.add("address_city");
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
   }

   protected void createModel(AddressFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            AddressRestService.class, callback).create(model);
   }

   protected void updateModel(AddressFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            AddressRestService.class, callback).update(model);
   }
}
package demo.client.local;

import demo.client.shared.AddressFormModel;
import demo.client.shared.AddressRestService;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.ListView;

@Templated
public class AddressListView extends ListView<AddressFormModel, AddressListItemView>
{

   @Override
   protected void loadData(RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            AddressRestService.class, callback).load();
   }

   @Override
   protected void remoteDelete(AddressFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            AddressRestService.class, callback).delete(model);
   }

   @Override
   protected Class<AddressFormView> getFormType()
   {
      return AddressFormView.class;
   }

   @Override
   protected String getFormTitle()
   {
      return "AddressForm";
   }

   @Override
   protected String getFormId()
   {
      return "Address Form";
   }

   @Override
   public AddressFormModel getCreationFormModel() {
      return new AddressFormModel(  );
   }

   @Override
   public Class<AddressRestService> getRemoteServiceClass() {
      return AddressRestService.class;
   }
}
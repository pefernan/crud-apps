package demo.client.local;

import demo.client.shared.ChildrenFormModel;
import demo.client.shared.ChildrenRestService;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.ListView;

@Templated
public class ChildrenListView extends ListView<ChildrenFormModel, ChildrenListItemView>
{

   @Override
   protected void loadData(RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            ChildrenRestService.class, callback).load();
   }

   @Override
   protected void remoteDelete(ChildrenFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            ChildrenRestService.class, callback).delete(model);
   }

   @Override
   protected Class<ChildrenFormView> getFormType()
   {
      return ChildrenFormView.class;
   }

   @Override
   protected String getFormTitle()
   {
      return "ChildrenForm";
   }

   @Override
   protected String getFormId()
   {
      return "Children Form";
   }

   @Override
   public ChildrenFormModel getCreationFormModel() {
      return new ChildrenFormModel(  );
   }

   @Override
   public Class<ChildrenRestService> getRemoteServiceClass() {
      return ChildrenRestService.class;
   }
}
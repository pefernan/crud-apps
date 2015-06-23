package demo.client.local;

import org.livespark.formmodeler.rendering.client.view.ListView;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import demo.client.shared.EmployeeFormModel;
import demo.client.local.EmployeeFormView;
import demo.client.local.EmployeeListItemView;
import demo.client.shared.EmployeeRestService;
import org.jboss.errai.common.client.api.RemoteCallback;
import java.lang.Override;

@Templated
public class EmployeeListView extends ListView<EmployeeFormModel, EmployeeListItemView>
{

   @Override
   protected void loadData(RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            EmployeeRestService.class, callback).load();
   }

   @Override
   protected void remoteDelete(EmployeeFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            EmployeeRestService.class, callback).delete(model);
   }

   @Override
   protected Class<EmployeeFormView> getFormType()
   {
      return EmployeeFormView.class;
   }

   @Override
   protected String getFormTitle()
   {
      return "EmployeeForm";
   }

   @Override
   protected String getFormId()
   {
      return "Employee Form";
   }

   @Override
   public EmployeeFormModel getCreationFormModel() {
      return new EmployeeFormModel(  );
   }
}
package demo.client.local;

import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import org.livespark.formmodeler.rendering.client.shared.components.EmbeddedForm;
import org.livespark.formmodeler.rendering.client.view.FormView;
import demo.client.shared.EmployeeFormModel;
import demo.client.shared.EmployeeRestService;
import org.jboss.errai.ui.shared.api.annotations.Templated;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import com.github.gwtbootstrap.client.ui.TextBox;
import javax.inject.Inject;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.github.gwtbootstrap.client.ui.CheckBox;
import org.jboss.errai.common.client.api.RemoteCallback;

@Templated
@Named("EmployeeFormView")
public class EmployeeFormView extends FormView<EmployeeFormModel>
{

   @Inject
   @Bound(property = "employee.name")
   @DataField
   private TextBox employee_name;
   @Inject
   @Bound(property = "employee.lastName")
   @DataField
   private TextBox employee_lastName;
   @Bound(property = "employee.birthday")
   @DataField
   private DatePicker employee_birthday = new DatePicker();
   @Inject
   @Bound(property = "employee.married")
   @DataField
   private CheckBox employee_married;
   @Inject
   @Bound(property = "employee.address.street")
   @DataField
   private TextBox employee_address_street;

   @DataField
   @Bound(property = "employee.address")
   private EmbeddedForm<Address, AddressFormModel> employee_address = new EmbeddedForm<Address, AddressFormModel>( new AddressEmbeddedFormAdapter() );

   @Inject
   private AddressFormView employee_address_formView;

   @PostConstruct
   public void init() {
      employee_address.setFormView( employee_address_formView );
   }

   @Override
   public void initInputNames()
   {
      inputNames.add("employee_name");
      inputNames.add("employee_lastName");
      inputNames.add("employee_birthday");
      inputNames.add("employee_married");
      inputNames.add("employee_address_street");
      inputNames.add("employee_address");
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
   }

   protected void createModel(EmployeeFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            EmployeeRestService.class, callback).create(model);
   }

   protected void updateModel(EmployeeFormModel model, RemoteCallback callback)
   {
      org.jboss.errai.enterprise.client.jaxrs.api.RestClient.create(
            EmployeeRestService.class, callback).update(model);
   }

   public class AddressEmbeddedFormAdapter implements EmbeddedForm.EmbeddedFormModelAdapter<Address, AddressFormModel> {
      public AddressFormModel getFormModelForModel( Address model ) {
         if (model == null) return new AddressFormModel(  );
         return new AddressFormModel( model );
      }
   }
}
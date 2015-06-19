package demo.client.local;

import com.google.gwt.user.client.Window;
import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import org.jboss.errai.databinding.client.api.PropertyChangeEvent;
import org.jboss.errai.databinding.client.api.PropertyChangeHandler;
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

   @DataField
   @Bound(property = "employee.address")
   private SubForm<Address, AddressFormModel> employee_address = new SubForm<Address, AddressFormModel>("employee.address", new SubForm.FormModelProvider<Address, AddressFormModel>() {
      public AddressFormModel getFormModelForModel( Address model ) {
         binder.addPropertyChangeHandler( "employee.address", new PropertyChangeHandler<Address>() {
            public void onPropertyChange( PropertyChangeEvent<Address> propertyChangeEvent ) {
               Window.alert("change!");
            }
         } );
         if (model == null) return new AddressFormModel(  );
         return new AddressFormModel( model );
      }
   } );

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
}
package demo.client.local;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import com.github.gwtbootstrap.client.ui.CheckBox;
import com.github.gwtbootstrap.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import demo.client.shared.Address;
import demo.client.shared.AddressFormModel;
import demo.client.shared.Children;
import demo.client.shared.ChildrenFormModel;
import demo.client.shared.EmployeeFormModel;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.shared.components.EmbeddedForm;
import org.livespark.formmodeler.rendering.client.shared.components.MultipleEmbeddedForm;
import org.livespark.formmodeler.rendering.client.view.FormView;
import org.livespark.formmodeler.rendering.client.view.ListItemView;
import org.livespark.formmodeler.rendering.client.view.ListView;

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
   private EmbeddedForm<Address, AddressFormModel> employee_address = new EmbeddedForm<Address, AddressFormModel>( new AddressEmbeddedFormAdapter() );

   @DataField
   @Bound(property = "employee.children")
   private MultipleEmbeddedForm<List<Children>, Children, ChildrenFormModel> employee_children = new MultipleEmbeddedForm<List<Children>, Children, ChildrenFormModel>(new EmployeeChildrenMultipleEmbeddedFormModelAdapter());

   @Inject
   private ChildrenListView employee_children_listView;

   @Inject
   private AddressFormView employee_address_formView;

   @PostConstruct
   public void init() {
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
      inputNames.add( "employee_children" );
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
   }

   public class AddressEmbeddedFormAdapter implements EmbeddedForm.EmbeddedFormModelAdapter<Address, AddressFormModel> {
      public AddressFormModel getFormModelForModel( Address model ) {
         if (model == null) return new AddressFormModel(  );
         return new AddressFormModel( model );
      }

      public FormView<AddressFormModel> getFormView() {
         return employee_address_formView;
      }
   }

   public class EmployeeChildrenMultipleEmbeddedFormModelAdapter implements MultipleEmbeddedForm.MultipleEmbeddedFormModelAdapter<List<Children>, Children, ChildrenFormModel> {
      public List<ChildrenFormModel> getListModelsForModel( List<Children> model ) {
         List <ChildrenFormModel> result = new ArrayList<ChildrenFormModel>(  );

         if (model != null) {
            for ( Children children : model ) {
               result.add( new ChildrenFormModel( children ) );
            }
         }

         return result;
      }

      public ListView<ChildrenFormModel, ? extends ListItemView<ChildrenFormModel>> getParentView() {
         return employee_children_listView;
      }
   }
}
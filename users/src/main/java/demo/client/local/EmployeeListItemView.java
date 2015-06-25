package demo.client.local;

import com.google.gwt.user.client.Element;
import demo.client.shared.EmployeeFormModel;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.ListItemView;

@Templated("EmployeeListView.html#Employee-row")
public class EmployeeListItemView extends ListItemView<EmployeeFormModel>
{

   @Bound(property = "employee.id")
   @DataField
   private Element employee_id = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "employee.name")
   @DataField
   private Element employee_name = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "employee.lastName")
   @DataField
   private Element employee_lastName = com.google.gwt.user.client.DOM
         .createTD();
   @Bound(property = "employee.birthday")
   @DataField
   private Element employee_birthday = com.google.gwt.user.client.DOM
         .createTD();
   @Bound(property = "employee.married")
   @DataField
   private Element employee_married = com.google.gwt.user.client.DOM
         .createTD();

   @Override
   public void initInputNames()
   {
      inputNames.add("employee_id");
      inputNames.add("employee_name");
      inputNames.add("employee_lastName");
      inputNames.add("employee_birthday");
      inputNames.add("employee_married");
   }
}
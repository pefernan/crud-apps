package org.jboss.errai.demo.client.local.employee.forms.edit;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import org.jboss.errai.demo.client.local.FormView;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class EditEmployeeForm extends FormView<EditEmployeeFormModel> {

  @Inject
  @Bound(property = "employee.id")
  @DataField
  private TextBox employee_id;

  @Inject
  @Bound(property = "employee.firstName")
  @DataField
  private TextBox employee_firstName;

  @Inject
  @Bound(property = "employee.lastName")
  @DataField
  private TextBox employee_lastName;
  
  @Inject
  @Bound(property = "employee.email")
  @DataField
  private TextBox employee_email;

  @Inject
  @Bound(property = "employee.department")
  @DataField
  private TextBox employee_department;
  
  @Inject
  @Bound(property = "employee.hireDate")
  @DataField
  private DatePicker employee_hireDate;


  private List inputNames = new ArrayList(  );

  @PostConstruct
  protected void init() {
    inputNames.add( "employee_firstName" );
    inputNames.add( "employee_lastName" );
    inputNames.add( "employee_email" );
    inputNames.add( "employee_department" );
    inputNames.add( "employee_hireDate" );
  }

  @Override
  public List<String> getInputNames() {
    return inputNames;
  }
}
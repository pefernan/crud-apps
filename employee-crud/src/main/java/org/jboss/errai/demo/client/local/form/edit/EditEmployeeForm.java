package org.jboss.errai.demo.client.local.form.edit;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.datepicker.client.DatePicker;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.local.form.FormView;
import org.jboss.errai.demo.client.shared.EmployeeEndpoint;
import org.jboss.errai.demo.client.shared.form.EditEmployeeFormModel;
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
  @Bound(property = "employee.hireDate")
  @DataField
  private DatePicker employee_hireDate;


  private List inputNames = new ArrayList(  );


  @Inject
  private Caller<EmployeeEndpoint> endpoint;

  @PostConstruct
  protected void init() {
    inputNames.add( "employee_firstName" );
    inputNames.add( "employee_lastName" );
    inputNames.add( "employee_email" );
    inputNames.add( "employee_hireDate" );
  }

  @Override
  public List<String> getInputNames() {
    return inputNames;
  }

  
}
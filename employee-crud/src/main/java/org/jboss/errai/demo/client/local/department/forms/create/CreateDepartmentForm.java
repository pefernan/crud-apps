package org.jboss.errai.demo.client.local.department.forms.create;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.user.client.ui.TextBox;
import org.gwtbootstrap3.client.ui.TextArea;
import org.jboss.errai.demo.client.local.FormView;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class CreateDepartmentForm extends FormView<CreateDepartmentFormModel> {

  @Inject
  @Bound(property = "department.name")
  @DataField
  private TextBox department_name;

  @Inject
  @Bound(property = "department.description")
  @DataField
  private TextArea department_description;

  private List inputNames = new ArrayList(  );

  @PostConstruct
  protected void init() {
    inputNames.add( "department_name" );
    inputNames.add( "department_description" );
  }

  @Override
  public List<String> getInputNames() {
    return inputNames;
  }
}
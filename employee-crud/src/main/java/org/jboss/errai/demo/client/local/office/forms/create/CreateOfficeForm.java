package org.jboss.errai.demo.client.local.office.forms.create;

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
public class CreateOfficeForm extends FormView<CreateOfficeFormModel> {

  @Inject
  @Bound(property = "office.name")
  @DataField
  private TextBox office_name;

  @Inject
  @Bound(property = "office.address")
  @DataField
  private TextArea office_address;

  private List inputNames = new ArrayList(  );

  @PostConstruct
  protected void init() {
    inputNames.add( "office_name" );
    inputNames.add( "office_address" );
  }

  @Override
  public List<String> getInputNames() {
    return inputNames;
  }
}
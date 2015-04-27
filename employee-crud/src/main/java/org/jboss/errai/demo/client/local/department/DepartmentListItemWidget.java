package org.jboss.errai.demo.client.local.department;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.databinding.client.api.DataBinder;
import org.jboss.errai.demo.client.local.department.forms.edit.EditDepartmentModalForm;
import org.jboss.errai.demo.client.shared.Department;
import org.jboss.errai.demo.client.shared.DepartmentEndpoint;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.ui.client.widget.HasModel;
import org.jboss.errai.ui.shared.api.annotations.AutoBound;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated("DepartmentCrud.html#department")
public class DepartmentListItemWidget extends Composite implements HasModel<Department> {

  @Inject
  @AutoBound
  private DataBinder<Department> binder;

  @Bound
  @DataField
  private final Element id = DOM.createTD();

  @Bound
  @DataField
  private final Element name = DOM.createTD();
  
  @Bound
  @DataField
  private final Element description = DOM.createTD();

  @Inject
  @DataField
  private Button edit;
  
  @Inject
  @DataField
  private Button delete;
  
  @Inject
  private EditDepartmentModalForm form;
  
  @Inject
  private Caller<DepartmentEndpoint> endpoint;
  
  @EventHandler("edit")
  private void onEdit(ClickEvent e) {
    form.startEdit( binder.getModel() );
  }
  
  @EventHandler("delete")
  private void onDelete(ClickEvent e) {
    endpoint.call(new ResponseCallback() {
      @Override
      public void callback(Response response) {
        if (response.getStatusCode() != Response.SC_NO_CONTENT) {
          Window.alert("Server returned wrong status code:" + response.getStatusCode());
        }
      }
    }).delete(binder.getModel().getId());
  }
  
  @Override
  public Department getModel() {
    return binder.getModel();
  }

  @Override
  public void setModel(Department model) {
    binder.setModel(model);
  }

}
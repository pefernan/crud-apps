package org.jboss.errai.demo.client.local.department;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.department.forms.create.CreateDepartmentModalForm;
import org.jboss.errai.demo.client.shared.Department;
import org.jboss.errai.demo.client.shared.DepartmentEndpoint;
import org.jboss.errai.demo.client.shared.DepartmentEvent;
import org.jboss.errai.ui.client.widget.ListWidget;
import org.jboss.errai.ui.client.widget.Table;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class DepartmentCrud extends Composite {

  @Inject
  private CreateDepartmentModalForm createModal;

  @Inject @DataField
  private Button create;
  
  @Inject @DataField @Table(root="tbody") 
  private ListWidget<Department, DepartmentListItemWidget> departments;

  @Inject
  private Caller<DepartmentEndpoint> endpoint;
  
  @PostConstruct
  private void loadData() {
    endpoint.call(new RemoteCallback<List<Department>>() {
      @Override
      public void callback(List<Department> data) {
        departments.setValue( data, true );
      }
    }).listAll();
  }
  
  @EventHandler("create")
  private void onCreate(ClickEvent e) {
    createModal.show();
  }
  
  @SuppressWarnings("unused")
  private void onDepartmentEvent( @Observes DepartmentEvent e ) {
    loadData();
  }
  
}
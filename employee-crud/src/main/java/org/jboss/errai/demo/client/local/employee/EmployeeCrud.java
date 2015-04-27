package org.jboss.errai.demo.client.local.employee;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.employee.forms.create.CreateEmployeeModalForm;
import org.jboss.errai.demo.client.shared.Employee;
import org.jboss.errai.demo.client.shared.EmployeeEndpoint;
import org.jboss.errai.demo.client.shared.EmployeeEvent;
import org.jboss.errai.ui.client.widget.ListWidget;
import org.jboss.errai.ui.client.widget.Table;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class EmployeeCrud extends Composite {

  @Inject
  private CreateEmployeeModalForm createModal;

  @Inject @DataField
  private Button create;
  
  @Inject @DataField @Table(root="tbody") 
  private ListWidget<Employee, EmployeeListItemWidget> employees;

  @Inject
  private Caller<EmployeeEndpoint> endpoint;
  
  @PostConstruct
  private void loadData() {
    endpoint.call(new RemoteCallback<List<Employee>>() {
      @Override
      public void callback(List<Employee> data) {
        employees.setValue(data, true);
      }
    }).listAll();
  }
  
  @EventHandler("create")
  private void onCreate(ClickEvent e) {
    createModal.show();
  }
  
  @SuppressWarnings("unused")
  private void onEmployeeEvent(@Observes EmployeeEvent e) {
    loadData();
  }
  
}
package org.jboss.errai.demo.client.local.office;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.common.client.api.RemoteCallback;
import org.jboss.errai.demo.client.local.office.forms.create.CreateOfficeModalForm;
import org.jboss.errai.demo.client.shared.Office;
import org.jboss.errai.demo.client.shared.OfficeEndpoint;
import org.jboss.errai.demo.client.shared.OfficeEvent;
import org.jboss.errai.ui.client.widget.ListWidget;
import org.jboss.errai.ui.client.widget.Table;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class OfficeCrud extends Composite {

  @Inject
  private CreateOfficeModalForm createModal;

  @Inject @DataField
  private Button create;
  
  @Inject @DataField @Table(root="tbody") 
  private ListWidget<Office, OfficeItemWidget> offices;

  @Inject
  private Caller<OfficeEndpoint> endpoint;
  
  @PostConstruct
  private void loadData() {
    endpoint.call(new RemoteCallback<List<Office>>() {
      @Override
      public void callback(List<Office> data) {
        offices.setValue( data, true );
      }
    }).listAll();
  }
  
  @EventHandler("create")
  private void onCreate(ClickEvent e) {
    createModal.show();
  }
  
  @SuppressWarnings("unused")
  private void onDepartmentEvent( @Observes OfficeEvent e ) {
    loadData();
  }
  
}
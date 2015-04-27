package org.jboss.errai.demo.client.local.office.forms.create;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import org.gwtbootstrap3.client.ui.Modal;
import org.gwtbootstrap3.client.ui.ModalBody;
import org.gwtbootstrap3.client.ui.ModalSize;
import org.gwtbootstrap3.client.ui.constants.ModalBackdrop;
import org.jboss.errai.common.client.api.Caller;
import org.jboss.errai.demo.client.shared.OfficeEndpoint;
import org.jboss.errai.enterprise.client.jaxrs.api.ResponseCallback;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.EventHandler;
import org.jboss.errai.ui.shared.api.annotations.Templated;

@Templated
public class CreateOfficeModalForm extends Composite {

  @Inject
  @DataField
  private CreateOfficeForm createOfficeForm;

  @Inject
  @DataField
  private Button save;

  @Inject
  private Caller<OfficeEndpoint> endpoint;

  private Modal m = new Modal();

  @PostConstruct

  public void init() {
    m.setSize( ModalSize.MEDIUM );
    m.setHideOtherModals( true );
    m.setClosable( true );
    
    ModalBody b = new ModalBody();
    b.add( this );
    
    m.setTitle( "Create new Office" );
    m.add( b );
    
    m.setFade( true );
    m.setDataBackdrop( ModalBackdrop.FALSE );
  }

  @EventHandler("save")
  private void onSave(ClickEvent e) {
    if ( createOfficeForm.validate())
      endpoint.call(new ResponseCallback() {
        @Override
        public void callback(Response response) {
          if (response.getStatusCode() != Response.SC_CREATED) {
            Window.alert( "Server returned wrong status code:" + response.getStatusCode() );
          }
          hide();
        }
      }).create( createOfficeForm.getModel().getOffice());
  }

  public void show() {
    createOfficeForm.setModel( new CreateOfficeFormModel() );
    m.show();
  }
  
  public void hide() {
    m.hide();
  }


}

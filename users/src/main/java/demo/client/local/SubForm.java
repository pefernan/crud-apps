package demo.client.local;

import java.lang.annotation.Documented;

import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.DomEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.SimplePanel;
import org.jboss.errai.databinding.client.PropertyChangeHandlerSupport;
import org.jboss.errai.databinding.client.api.PropertyChangeEvent;
import org.jboss.errai.databinding.client.api.PropertyChangeHandler;
import org.livespark.formmodeler.rendering.client.shared.FormModel;
import org.livespark.formmodeler.rendering.client.view.FormView;

/**
 * Created by pefernan on 6/18/15.
 */

public class SubForm<M, F extends FormModel> extends SimplePanel implements HasValue<M>, PropertyChangeHandler {

    public interface FormModelProvider<M, F> {
        public F getFormModelForModel(M model);
    }
    private FormModelProvider<M, F> formModelProvider;
    private FormView formView;
    private M model;
    private String propertyName;

    PropertyChangeHandlerSupport propertyChangeHandlerSupport = new PropertyChangeHandlerSupport();

    public SubForm(String propertyName, FormModelProvider<M, F> provider) {
        super();
        if (provider == null) throw new IllegalArgumentException( "FormModelProvider cannot be null" );
        formModelProvider = provider;
        this.propertyName = propertyName;

        DOM.setEventListener(this.getElement(), this );
    }


    public void onPropertyChange( PropertyChangeEvent propertyChangeEvent ) {
        Window.alert( propertyChangeEvent.getPropertyName() + " changed to:" + propertyChangeEvent.getNewValue() );
        propertyChangeHandlerSupport.notifyHandlers( new PropertyChangeEvent<M>(this, propertyName, model, model ) );
    }

    public M getValue() {
        return model;
    }

    public void setValue( M model ) {
        doSetValue( model );
    }

    public void setValue( M model, boolean b ) {
        doSetValue( model );
    }

    public void setModel( M model ) {
        this.model = model;
    }

    protected void doSetValue(M model) {
        this.model = model;
        if (formView != null) formView.setModel( formModelProvider.getFormModelForModel( model ) );
    }

    public void setFormView( FormView formView ) {
        this.clear();
        this.add( formView );
        this.formView = formView;
        this.formView.getBinder().addPropertyChangeHandler( this );
        if (model != null) formView.setModel( formModelProvider.getFormModelForModel( model ) );
    }

    public HandlerRegistration addValueChangeHandler( ValueChangeHandler<M> valueChangeHandler ) {
        return this.addHandler(valueChangeHandler, ValueChangeEvent.getType());
    }
}
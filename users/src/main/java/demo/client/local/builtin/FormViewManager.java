package demo.client.local.builtin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import demo.client.shared.FormMeta;
import org.jboss.errai.ioc.client.container.IOCBeanDef;
import org.jboss.errai.ioc.client.container.SyncBeanManager;
import org.livespark.formmodeler.rendering.client.shared.FormModel;
import org.livespark.formmodeler.rendering.client.view.FormView;
import org.slf4j.Logger;

/**
 * Created by pefernan on 6/18/15.
 */
@ApplicationScoped
public class FormViewManager {
    @Inject
    private Logger logger;

    @Inject
    private SyncBeanManager beanManager;

    private List<FormMeta> formMetas = new ArrayList<FormMeta>(  );

    @PostConstruct
    private void showing() {
        logger.debug( "Initializing FormManager" );
        final Collection<IOCBeanDef<FormMeta>> metaBeans = beanManager.lookupBeans( FormMeta.class );
        logger.debug( "Found " + metaBeans.size() + " FormMeta beans" );

        for ( IOCBeanDef<FormMeta> metaBean : metaBeans ) {
            logger.debug( "Processing " + metaBean.getBeanClass().getName() );
            final FormMeta instance = metaBean.getInstance();
            formMetas.add( instance );
            getFormView( instance.getFormName() );
        }
    }

    public FormView getFormView(String formName) {
        for ( FormMeta meta : formMetas ) {
            if ( meta.getFormName().equals( formName ) ) {
                IOCBeanDef<? extends FormView> formView = beanManager.lookupBean( meta.getFormViewClass() );
                if ( formView != null ) {
                    return formView.getInstance();
                }
            }
        }
        return null;
    }

    public FormModel getFormModel(String formName) {
        for ( FormMeta meta : formMetas ) {
            if ( meta.getFormName().equals( formName ) ) {
                IOCBeanDef<? extends FormModel> formModel = beanManager.lookupBean( meta.getFormModelClass() );
                if ( formModel != null ) {
                    return formModel.getInstance();
                }
            }
        }
        return null;
    }
}

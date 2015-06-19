package demo.client.shared;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.Dependent;

import demo.client.local.EmployeeFormView;
import org.jboss.errai.common.client.api.annotations.Portable;

/**
 * Created by pefernan on 6/18/15.
 */
@Dependent
@Portable
public class EmployeeFormMeta implements FormMeta {

    public String getFormName() {
        return "EmployeeForm";
    }

    public Class getFormModelClass() {
        return EmployeeFormModel.class;
    }

    public Class getFormViewClass() {
        return EmployeeFormView.class;
    }

    public Map<String, String> getDataModels() {
        Map<String, String> dataModels = new HashMap<String, String>(  );
        dataModels.put( "employee", Employee.class.getName() );
        return dataModels;
    }
}


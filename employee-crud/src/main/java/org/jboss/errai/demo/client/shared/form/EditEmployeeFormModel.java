package org.jboss.errai.demo.client.shared.form;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Employee;

@Bindable
@Portable
public class EditEmployeeFormModel {

    @Valid
    Employee employee;

    public EditEmployeeFormModel() {
    }

    public EditEmployeeFormModel( @MapsTo("employee") Employee employee ) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee( Employee employee ) {
        this.employee = employee;
    }
}

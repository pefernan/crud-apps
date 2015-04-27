package org.jboss.errai.demo.client.local.employee.forms.create;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Employee;

@Bindable
@Portable
public class CreateEmployeeFormModel {

    @Valid
    Employee employee;

    public CreateEmployeeFormModel() {
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee( Employee employee ) {
        this.employee = employee;
    }
}

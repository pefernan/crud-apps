package org.jboss.errai.demo.client.local.department.forms.create;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Department;

@Bindable
@Portable
public class CreateDepartmentFormModel {

    @Valid
    Department department;

    public CreateDepartmentFormModel() {
        department = new Department();
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment( Department department ) {
        this.department = department;
    }
}

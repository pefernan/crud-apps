package org.jboss.errai.demo.client.local.department.forms.edit;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Department;

@Bindable
@Portable
public class EditDepartmentFormModel {
    @Valid
    Department department;

    public EditDepartmentFormModel() {
    }

    public EditDepartmentFormModel( @MapsTo( "department" ) Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment( Department department ) {
        this.department = department;
    }
}

package org.jboss.errai.demo.client.local.office.forms.create;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Office;

@Bindable
@Portable
public class CreateOfficeFormModel {

    @Valid
    Office office;

    public CreateOfficeFormModel() {
        office = new Office();
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice( Office office ) {
        this.office = office;
    }
}

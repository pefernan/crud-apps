package org.jboss.errai.demo.client.local.office.forms.edit;

import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.jboss.errai.demo.client.shared.Office;

@Bindable
@Portable
public class EditOfficeFormModel {
    @Valid
    Office office;

    public EditOfficeFormModel() {
    }

    public EditOfficeFormModel( @MapsTo("office") Office office ) {
        this.office = office;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice( Office office ) {
        this.office = office;
    }
}

package org.jboss.errai.demo.client.local;

import javax.inject.Inject;

import com.google.gwt.user.client.ui.Composite;
import org.jboss.errai.demo.client.local.department.DepartmentCrud;
import org.jboss.errai.demo.client.local.employee.EmployeeCrud;
import org.jboss.errai.ui.nav.client.local.DefaultPage;
import org.jboss.errai.ui.nav.client.local.Page;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;

/**
 * Created by pefernan on 4/27/15.
 */
@Page(role = DefaultPage.class)
@Templated
public class HomePage extends Composite {

    @Inject
    @DataField
    private DepartmentCrud deparmentCrud;

    @Inject
    @DataField
    private EmployeeCrud employeeCrud;
}

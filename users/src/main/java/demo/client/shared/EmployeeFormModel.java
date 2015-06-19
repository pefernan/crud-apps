package demo.client.shared;

import org.livespark.formmodeler.rendering.client.shared.FormModel;
import java.util.List;
import java.util.Arrays;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import javax.inject.Named;
import javax.validation.Valid;
import org.jboss.errai.common.client.api.annotations.MapsTo;
import java.lang.Override;

@Portable
@Bindable
@Named("EmployeeFormModel")
public class EmployeeFormModel extends FormModel
{

   @Valid
   private Employee employee;

   public Employee getEmployee()
   {
      return employee;
   }

   public void setEmployee(Employee employee)
   {
      this.employee = employee;
   }

   public EmployeeFormModel()
   {
   }

   public EmployeeFormModel(@MapsTo("employee") Employee employee)
   {
      this.employee = employee;
   }

   @Override
   public List<Object> getDataModels()
   {
      return Arrays.<Object> asList(employee);
   }
}
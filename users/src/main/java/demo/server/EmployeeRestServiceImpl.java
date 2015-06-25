package demo.server;

import demo.client.shared.Address;
import demo.client.shared.Children;
import demo.client.shared.Employee;
import demo.client.shared.EmployeeFormModel;

import java.util.Date;
import java.util.List;
import demo.client.shared.EmployeeRestService;
import demo.server.EmployeeEntityService;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.ejb.Stateless;
import java.lang.Override;

@Stateless
public class EmployeeRestServiceImpl implements EmployeeRestService
{

   @Inject
   private EmployeeEntityService entityService;

   @PostConstruct
   protected void init() {
      /*List<Children> childrens = new ArrayList<Children>(  );

      childrens.add( new Children( null, "Pol", "Fernandez" ) );
      childrens.add( new Children( null, "Roc", "Fernandez" ) );

      Employee emp = new Employee( null, "Pere", "Fernandez", new Date(  ), true, new Address( null, "Lluna", 10, "B", "08870", "Sitges"), childrens );
      EmployeeFormModel fm = new EmployeeFormModel( emp );

      entityService.createFromFormModel( fm );
       */
   }

   public EmployeeFormModel create(EmployeeFormModel model)
   {
      entityService.createFromFormModel(model);
      return model;
   }

   public List<EmployeeFormModel> load()
   {
      List<demo.client.shared.Employee> dataModels = entityService
            .listAll(demo.client.shared.Employee.class);
      List<EmployeeFormModel> formModels = new ArrayList(dataModels.size());
      for (demo.client.shared.Employee dataModel : dataModels)
      {
         formModels.add(new EmployeeFormModel(dataModel));
      }
      return formModels;
   }

   public Boolean update(EmployeeFormModel model)
   {
      entityService.updateFromFormModel(model);
      return true;
   }

   public Boolean delete(EmployeeFormModel model)
   {
      entityService.deleteFromFormModel(model);
      return true;
   }
}
package demo.server;

import demo.client.shared.EmployeeFormModel;
import java.util.List;
import demo.client.shared.EmployeeRestService;
import demo.server.EmployeeEntityService;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.ejb.Stateless;
import java.lang.Override;

@Stateless
public class EmployeeRestServiceImpl implements EmployeeRestService
{

   @Inject
   private EmployeeEntityService entityService;

   @Override
   public EmployeeFormModel create(EmployeeFormModel model)
   {
      entityService.createFromFormModel(model);
      return model;
   }

   @Override
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

   @Override
   public Boolean update(EmployeeFormModel model)
   {
      entityService.updateFromFormModel(model);
      return true;
   }

   @Override
   public Boolean delete(EmployeeFormModel model)
   {
      entityService.deleteFromFormModel(model);
      return true;
   }
}
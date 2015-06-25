package demo.server;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

import demo.client.shared.ChildrenFormModel;
import demo.client.shared.ChildrenRestService;

@Stateless
public class ChildrenRestServiceImpl implements ChildrenRestService
{

   @Inject
   private ChildrenEntityService entityService;

   @Override
   public ChildrenFormModel create(ChildrenFormModel model)
   {
      entityService.createFromFormModel(model);
      return model;
   }

   @Override
   public List<ChildrenFormModel> load()
   {
      List<demo.client.shared.Children> dataModels = entityService
            .listAll(demo.client.shared.Children.class);
      List<ChildrenFormModel> formModels = new ArrayList(dataModels.size());
      for (demo.client.shared.Children dataModel : dataModels)
      {
         formModels.add(new ChildrenFormModel(dataModel));
      }
      return formModels;
   }

   @Override
   public Boolean update(ChildrenFormModel model)
   {
      entityService.updateFromFormModel(model);
      return true;
   }

   @Override
   public Boolean delete(ChildrenFormModel model)
   {
      entityService.deleteFromFormModel(model);
      return true;
   }
}
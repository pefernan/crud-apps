package demo.client.shared;

import java.util.Arrays;
import java.util.List;
import javax.inject.Named;
import javax.validation.Valid;

import org.jboss.errai.common.client.api.annotations.MapsTo;
import org.jboss.errai.common.client.api.annotations.Portable;
import org.jboss.errai.databinding.client.api.Bindable;
import org.livespark.formmodeler.rendering.client.shared.FormModel;

@Portable
@Bindable
@Named("ChildrenFormModel")
public class ChildrenFormModel extends FormModel
{

   @Valid
   private Children children;

   public Children getChildren()
   {
      return children;
   }

   public void setChildren(Children children)
   {
      this.children = children;
   }

   public ChildrenFormModel()
   {
   }

   public ChildrenFormModel(@MapsTo("children") Children children)
   {
      this.children = children;
   }

   @Override
   public List<Object> getDataModels()
   {
      return Arrays.<Object> asList(children);
   }
}
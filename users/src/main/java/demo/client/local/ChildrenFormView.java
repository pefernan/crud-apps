package demo.client.local;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.gwtbootstrap.client.ui.TextBox;
import demo.client.shared.ChildrenFormModel;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.FormView;

@Templated
@Named("ChildrenFormView")
public class ChildrenFormView extends FormView<ChildrenFormModel>
{

   @Inject
   @Bound(property = "children.name")
   @DataField
   private TextBox children_name;
   @Inject
   @Bound(property = "children.lastName")
   @DataField
   private TextBox children_lastName;

   @Override
   public void initInputNames()
   {
      inputNames.add("children_name");
      inputNames.add("children_lastName");
   }

   @Override
   public void setReadOnly(boolean readOnly)
   {
   }
}
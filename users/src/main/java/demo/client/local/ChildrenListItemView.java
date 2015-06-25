package demo.client.local;

import com.google.gwt.user.client.Element;
import demo.client.shared.ChildrenFormModel;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import org.livespark.formmodeler.rendering.client.view.ListItemView;

@Templated("ChildrenListView.html#Children-row")
public class ChildrenListItemView extends ListItemView<ChildrenFormModel>
{

   @Bound(property = "children.id")
   @DataField
   private Element children_id = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "children.name")
   @DataField
   private Element children_name = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "children.lastName")
   @DataField
   private Element children_lastName = com.google.gwt.user.client.DOM
         .createTD();

   @Override
   public void initInputNames()
   {
      inputNames.add("children_id");
      inputNames.add("children_name");
      inputNames.add("children_lastName");
   }
}
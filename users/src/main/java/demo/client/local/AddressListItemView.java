package demo.client.local;

import org.livespark.formmodeler.rendering.client.view.ListItemView;
import demo.client.shared.AddressFormModel;
import org.jboss.errai.ui.shared.api.annotations.Templated;
import com.google.gwt.user.client.Element;
import org.jboss.errai.ui.shared.api.annotations.Bound;
import org.jboss.errai.ui.shared.api.annotations.DataField;

@Templated("AddressListView.html#Address-row")
public class AddressListItemView extends ListItemView<AddressFormModel>
{

   @Bound(property = "address.id")
   @DataField
   private Element address_id = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "address.street")
   @DataField
   private Element address_street = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "address.number")
   @DataField
   private Element address_number = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "address.door")
   @DataField
   private Element address_door = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "address.cp")
   @DataField
   private Element address_cp = com.google.gwt.user.client.DOM.createTD();
   @Bound(property = "address.city")
   @DataField
   private Element address_city = com.google.gwt.user.client.DOM.createTD();

   @Override
   public void initInputNames()
   {
      inputNames.add("address_id");
      inputNames.add("address_street");
      inputNames.add("address_number");
      inputNames.add("address_door");
      inputNames.add("address_cp");
      inputNames.add("address_city");
   }
}
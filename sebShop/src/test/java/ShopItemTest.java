import controller.ItemsController;
import model.ShopItem;
import org.junit.Test;

import java.util.List;

public class ShopItemTest {

    @Test
    public void printItems(){
        ItemsController itemsController = new ItemsController();
        List<ShopItem> shopItems = itemsController.getShopItems();

        for(ShopItem shopItem : shopItems){
            System.out.println(shopItem.toString());
        }
        System.out.println("Number of Shop Items: " +shopItems.size());

    }
}

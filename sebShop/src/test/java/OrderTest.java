import controller.OrderController;
import model.Article;
import model.Order;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderTest {

    @Test
    public void saveOrder(){
        Order order = new Order();

        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String strDate = sdfDate.format(new Date());
        order.setDate(strDate);

        order.setTotalprice(99.99);
        order.setUser("TestUser");

        List<Article> articles = new ArrayList<>();
        Article article = new Article();
        article.setItemName("Test Tshirt");
        article.setPrice(99.99);
        article.setQuantity(1);
        article.setSize("M");
        articles.add(article);
        order.setArticles(articles);

        OrderController orderController = new OrderController();
        orderController.saveOrders(order);


    }
}

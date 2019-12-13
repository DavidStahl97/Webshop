package servlets;

import controller.ItemsController;
import controller.LoginController;
import model.ShopItem;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/shopItemsServlet")
public class ShopItemsServlet extends HttpServlet {


    private static final long serialVersionUID = -1635505967689299584L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopItemsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            ItemsController itemsController = new ItemsController();
            List<ShopItem> shopItems = itemsController.getShopItems();

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();

            String jsonResponse = mapper.writeValueAsString(shopItems);
            pw.print(jsonResponse);
            pw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

package servlets;

import controller.LoginController;
import controller.OrderController;
import model.Order;
import model.OrderBackend;
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

@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet {

    private static final long serialVersionUID = 4286940923785367241L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String orderJSON = request.getParameter("order");
            ObjectMapper mapper = new ObjectMapper();
            Order order = mapper.readValue(orderJSON, Order.class);

            OrderController orderController = new OrderController();
            int orderNo = orderController.saveOrders(order);


            PrintWriter pw  = response.getWriter();
            Map<String, Integer> responseObject = new HashMap<>();
            responseObject.put("orderNo", orderNo);
            String jsonResponse = mapper.writeValueAsString(responseObject);
            pw.print(jsonResponse);
            pw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            String name = request.getParameter("user");

            OrderController orderController = new OrderController();
            List<OrderBackend> userOrders = orderController.getUserOrders(name);

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();
            String jsonResponse = mapper.writeValueAsString(userOrders);
            pw.print(jsonResponse);
            pw.flush();

        }catch (Exception e){
            e.printStackTrace();
            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();
            Map<String, Boolean> responseObject = new HashMap<>();
            responseObject.put("success", false);

            String jsonResponse = mapper.writeValueAsString(responseObject);
            pw.print(jsonResponse);
            pw.flush();
        }

    }


}

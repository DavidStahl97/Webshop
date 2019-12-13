package servlets;

import controller.ItemsController;
import model.ShopItem;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/paymentServlet")
public class PaymentServlet extends HttpServlet {


    private static final long serialVersionUID = -8027824372952250515L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            List<String> paymentMethods = new ArrayList();
            paymentMethods.add("Paypal");
            paymentMethods.add("Credit Card");
            paymentMethods.add("Klarna");
            paymentMethods.add("Bitcoin");
            paymentMethods.add("Invoice");

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();

            String jsonResponse = mapper.writeValueAsString(paymentMethods);
            pw.print(jsonResponse);
            pw.flush();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
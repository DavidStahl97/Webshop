package servlets;

import controller.LoginController;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 4286940923785367241L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("passwort");

            LoginController loginController = new LoginController();
            loginController.registerAccount(name, password);

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();
            Map<String, Boolean> responseObject = new HashMap<>();
            responseObject.put("success", true);

            String jsonResponse = mapper.writeValueAsString(responseObject);
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



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        try {
            String name = request.getParameter("name");
            String password = request.getParameter("passwort");

            LoginController loginController = new LoginController();
            boolean success = loginController.login(name, password);

            ObjectMapper mapper = new ObjectMapper();
            PrintWriter pw  = response.getWriter();
            Map<String, Boolean> responseObject = new HashMap<>();
            responseObject.put("success", success);

            String jsonResponse = mapper.writeValueAsString(responseObject);
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

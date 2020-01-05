import controller.LoginController;
import org.junit.Test;

public class LoginTest {

    @Test
    public void registerTest(){
        LoginController loginController = new LoginController();
        //loginController.registerAccount("TestUser", "1234");
        //loginController.registerAccount("b1","b1");
        System.out.println(loginController.login("b1dsadsad","b1dasdas"));
    }

}

import controller.LoginController;
import org.junit.Test;

public class LoginTest {

    @Test
    public void registerTest(){
        LoginController loginController = new LoginController();
        loginController.registerAccount("TestUser", "1234");
    }

}

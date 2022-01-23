package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login extends TesteBase {
    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogOutPresent()) {
            app.getUserHelper().logout();
        }
         }

    @Test
    public void loginSuccessTest() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com", "Bobdil12345$");
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test
    public void loginSuccessModel() {
        User user = new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


}

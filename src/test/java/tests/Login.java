package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Login extends TesteBase {
    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logout();
        }
    }

    @Test(groups = {"web"})
    public void loginSuccessTest() {

        logger.info("The user start login process with email : 'bobdilan@gmail.com'  && password : 'Bobdil12345$'");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com", "Bobdil12345$");
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test (dataProvider = "loginValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void loginSuccessTestDataProvider(String email, String password) {

        logger.info("The user start login process with email : "+email+" && password:" +password);

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com", "Bobdil12345$");
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test
    public void loginSuccessModel() {

        User user = new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$");
        logger.info("The user start login process with data:---> "+user.toString());

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }

    @Test (dataProvider = "loginValidDataModel", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModelDataProvider(User user) {
        logger.info("The user start login process with data:---> "+user.toString());

        //User user = new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        app.getUserHelper().pause(2000);
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }


    @Test
    public void loginNegativeTestWrongPassword() {
        User user = new User().withEmail("bobdilangmail.com").withPassword("Bdil1235$");
        logger.info("The user start negative login process with data : --->"+ user.toString());

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(user);
        app.getUserHelper().submitLogin();
        Assert.assertTrue(app.getUserHelper().IsAlertDisplayed());
        Assert.assertTrue(app.getUserHelper().isErrorWrongEmailOrPasswordPormat());
        Assert.assertFalse(app.getUserHelper().isLogged());
    }

}

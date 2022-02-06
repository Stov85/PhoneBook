package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Registration extends TesteBase {
    @BeforeMethod
    public void preCondition() {
        // if logged [logout present???] ---> logout

        if (app.getUserHelper().isLogged()) {
            app.getUserHelper().logout();
        }
    }

    @Test
    public void registrationSuccessTest() {
        int index = (int) (System.currentTimeMillis() / 100) % 3600;

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan1" + index + "@gmail.com", "Bobdil12345$");
        app.getUserHelper().submitReg();
        app.getUserHelper().pause(2000);


    }

    @Test
    public void registrationSuccessTestModel() {
        int index = (int) (System.currentTimeMillis() / 100) % 3600;

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(new User().withEmail("bobdilan1" + index + "@gmail.com").withPassword("Bobdil12345$"));
        app.getUserHelper().submitReg();
        app.getUserHelper().pause(2000);


    }

}

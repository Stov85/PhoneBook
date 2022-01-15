package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Registration extends TesteBase{


    @Test
    public void registrationSuccessTest() {

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan1@gmail.com","Bobdil12345$" );
        app.getUserHelper().submitReg();


    }

}

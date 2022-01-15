package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends TesteBase{


     @Test
    public void loginSuccessTest(){

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("bobdilan@gmail.com","Bobdil12345$" );
        app.getUserHelper().submitLogin();

    }






}

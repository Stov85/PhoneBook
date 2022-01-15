package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }




    public void openLoginForm(){
        click(By.cssSelector("[href='/login']"));

    }
    public void fillLoginForm(String email, String password){
        type(By.cssSelector("[placeholder='Email']"),email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }


    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }
    public void submitReg() {
        click(By.xpath("//button[2]"));
    }

    public void fillRegForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    }


package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserHelper extends HelperBase {


    public UserHelper(WebDriver wd) {
        super(wd);
    }


    public boolean isLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.xpath("//*[text()='Sign Out']"))));
        return wd.findElement(By.xpath("//*[text()='Sign Out']")).isDisplayed();
    }

    public void openLoginForm() {
        click(By.cssSelector("[href='/login']"));

    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("[placeholder='Email']"), email);
        type(By.cssSelector("[placeholder='Password']"), password);
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("[placeholder='Email']"), user.getEmail());
        type(By.cssSelector("[placeholder='Password']"), user.getPassword());
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

    public boolean isLogged() {
        return wd.findElements(By.xpath("//button[text()='Sign Out']")).size() > 0;
    }


    public void logout() {
        click(By.xpath("//*[text()='Sign Out']"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginForm(user);
        submitLogin();
    }

    public boolean IsAlertDisplayed() {
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());
        if (alert == null) {
            return false;
        } else {
            wd.switchTo().alert();
            System.out.println(alert.getText());
            alert.accept(); //click ok button
            //alert.dismiss();// click cancel
            //alert.sendKeys("email");

            return true;
        }

    }
    public boolean isErrorWrongEmailOrPasswordPormat(){
        Alert alert = new WebDriverWait(wd, 10)
                .until(ExpectedConditions.alertIsPresent());

        wd.switchTo().alert();

        String error = alert.getText();
        alert.accept();
        //alert.dismiss(); // cancel
        //alert.sendKeys("email");

        return error.contains("Wrong email or password format");
    }
}


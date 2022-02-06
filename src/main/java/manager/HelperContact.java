package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
         click(By.cssSelector("[href='/add']"));
        pause(2000);

    }

    public void fillContactForm(Contact contact) {
        pause(2000);

        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDecription());
        pause(2000);

    }

    public void saveConact() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }
    public void pause(){
        pause(2000);
    }
}

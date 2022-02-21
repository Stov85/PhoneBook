package manager;

import lombok.extern.flogger.Flogger;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperContact extends HelperBase {
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.cssSelector("[href='/add']"));
        pause(2000);
    }

    public void fillContactForm(Contact contact) {
        pause(1000);
        type(By.cssSelector("[placeholder='Name']"), contact.getName());
        type(By.cssSelector("[placeholder='Last Name']"), contact.getLastName());
        type(By.cssSelector("[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector("[placeholder='email']"), contact.getEmail());
        type(By.cssSelector("[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector("[placeholder='description']"), contact.getDecription());
        //  zoomout();
        // type2(By.cssSelector("[placeholder='description']"));

    }

    public void saveContact() {
        click(By.cssSelector(".add_form__2rsm2 button"));
    }

    public int countOfContacts() {

        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public boolean isContactCreateByName(String name) {
        List<WebElement> list = wd.findElements(By.cssSelector("h2"));
        for (WebElement el : list) {
            if (el.getText().equals(name))
                return true;
        }
        return false;
    }


    public boolean isContactCreateByPhone(String phone) {
        List<WebElement> list = wd.findElements(By.cssSelector("h3"));
        for (WebElement el : list) {
            if (el.getText().equals(phone))
                return true;
        }
        return false;
    }

    public void removeOneContact() {

        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        contact.click();
        click(By.xpath("//button[.='Remove']"));
    }

    public void provideOfContacts() {
        if (countOfContacts() < 3) {
            int index = (int) (System.currentTimeMillis() / 1000) % 3600;
            for (int i = 0; i < 3; i++) {

                Contact contact = Contact.builder()
                        .name("Bobi")
                        .lastName("Ibob")
                        .phone("1212" + i + index)
                        .email("bob" + index + "@gmail.com")
                        .address("Rehovot")
                        .decription("wiefgsdhfbv").build();
                openContactForm();
                fillContactForm(contact);
                saveContact();
                pause(1000);
            }

        }
    }

    public int removeOneContactCount() {
        int countBefore = countOfContacts();

        logger.info("Before remove 'One contact test' count was -->" + countBefore);

        if (!isContactsListEmpty()) {
            String phone = wd.findElement(By.cssSelector(".contact-item_card__2SOIM h3")).getText();
            logger.info("The phone number of removed contact was ===>" + phone);

            wd.findElement(By.cssSelector(".contact-item_card__2SOIM")).click();
            wd.findElement(By.xpath("//button[.='Remove']")).click();
            pause(1000);
        }
        int countAfter = countOfContacts();
        logger.info("After removed one contact the count is: ====>" + countAfter);

        return countBefore-countAfter;
    }

    public boolean isContactsListEmpty() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).isEmpty();
    }

    public void removeAllContactsNotWork() {
        List<WebElement> list = wd.findElements(By.cssSelector(".contact-item_card__2SOIM"));
        for (WebElement el : list)
            wd.findElement(By.xpath("//button[.='Remove']")).click();
        pause(500);
    }

    public void removeAllContacts() {
        while (wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size() != 0) {
            removeOneContactCount();
        }
    }
}

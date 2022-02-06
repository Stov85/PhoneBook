package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TesteBase{

    @BeforeMethod
    public void preCondition(){
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$"));
        }
    }
@Test
    public void addNewContactSuccess(){

        int index = (int)(System.currentTimeMillis()/100)%3600;
    app.contact().pause(2000);
    Contact contact = Contact.builder()
            .name("Bob")
            .lastName("Dil")
            .phone("12345678")
            .email("bobdilan" +index+"@gmail.com")
            .address("Rehovot")
            .decription("friend").build();

    app.contact().openContactForm();

    app.contact().fillContactForm(contact);
    app.contact().pause(2000);
    app.contact().saveConact();

    }


}

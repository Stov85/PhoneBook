package tests;

import manager.MyDataProvider;
import models.Contact;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContact extends TesteBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$"));
            app.contact().pause(2000);
//        app.contact().type3(By.cssSelector(".navbar-logged_nav__2Hx7M"));
        }
    }
@Test(groups = {"web"})
    public void addNewContactSuccess(){

        int index = (int)(System.currentTimeMillis()/100)%3600;
    app.contact().pause(2000);
    Contact contact = Contact.builder()
            .name("Bobbbbbbb")
            .lastName("Dil")
            .phone("12345678")
            .email("bobdilan" +index+"@gmail.com")
            .address("Rehovot")
            .decription("friend").build();

    app.contact().openContactForm();
//app.contact().zoomout();
    app.contact().fillContactForm(contact);
    app.contact().pause(1000);
   app.contact().saveContact();

    }

    @Test (dataProvider = "addContactValidDataCSV",dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessNew(Contact contact){

        int countStart = app.contact().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);

        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());
        app.contact().openContactForm();
        app.contact().zoomout();
        app.contact().fillContactForm(contact);
        app.contact().pause(1000);
        app.contact().saveContact();
        int countEnd = app.contact().countOfContacts();

        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);
        // if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        // if list contact with name + phone
//new commit for jenkins
        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));
    }
    @Test (dataProvider = "addContactValidDataModel",dataProviderClass = MyDataProvider.class)
    public void addNewContactSuccessDT(Contact contact){


        int countStart = app.contact().countOfContacts();

        logger.info("The test 'Add new contact' start with count of contact in start --->"+countStart);

        logger.info("The test 'Add new contact' start with data ---->" +contact.toString());
        app.contact().openContactForm();
        app.contact().fillContactForm(contact);
        app.contact().saveContact();


        int countEnd = app.contact().countOfContacts();

        logger.info("The test 'Add new contact' end with count of contact in the end --->"+countEnd);

        // if countStart - countEnd = -1
        Assert.assertEquals(countEnd-countStart,1);
        // if list contact with name + phone

        Assert.assertTrue(app.contact().isContactCreateByName(contact.getName()));
        Assert.assertTrue(app.contact().isContactCreateByPhone(contact.getPhone()));
    }
}

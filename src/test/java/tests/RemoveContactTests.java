package tests;


import manager.UserHelper;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TesteBase {
    @BeforeMethod
    public void preCondition(){
        if (!app.getUserHelper().isLogged()) {
            app.getUserHelper().login(new User().withEmail("bobdilan@gmail.com").withPassword("Bobdil12345$"));
        }
        //provideContact===>3
        app.contact().provideOfContacts();
    }
@Test
    public void removeOneContact(){
   app.contact().removeOneContact();
}

    @Test
    public void removeOneContactCount(){
        Assert.assertEquals(app.contact().removeOneContactCount(),1);
      // int count =  app.contact().removeOneContactCount();
     //   Assert.assertEquals(count, -1);
    }

    @Test
    public void removeAllcontacts(){
        app.contact().removeAllContacts();
        Assert.assertTrue(app.contact().isContactsListEmpty() );
    }
}

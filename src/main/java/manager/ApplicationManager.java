package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {
    WebDriver wd;
    UserHelper userHelper;
HelperContact contact;

    public void init(){
        wd= new ChromeDriver();
        wd.manage().window().maximize();
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

        userHelper = new UserHelper(wd);
        contact = new HelperContact(wd);
    }
    public void stop(){
        wd.quit();
    }


    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HelperContact contact() {
        return contact;
    }
}

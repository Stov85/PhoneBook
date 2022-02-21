package manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    EventFiringWebDriver wd;
   // WebDriver wd;
    UserHelper userHelper;
    HelperContact contact;
    String browser;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests starts in 'Chrome' browser ");
        }
        else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests starts in 'FIREFOX' browser ");
        }
        else if (browser.equals((BrowserType.EDGE))){
            wd = new EventFiringWebDriver(new EdgeDriver());
            logger.info("All tests starts in 'Edge' browser ");
        }


       wd.manage().window().maximize();

        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

       // wd.register(new MyListener());
        //wd.register(new MyListener());

        userHelper = new UserHelper(wd);
        contact = new HelperContact(wd);
    }

    public void stop() {
        wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public HelperContact contact() {
        return contact;
    }
}

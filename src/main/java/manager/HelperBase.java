package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {
    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);



    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void type(By locator, String text) {
        if (text != null && !text.isEmpty()) {
            WebElement element = wd.findElement(locator);
            element.click();
            element.clear();
            element.sendKeys(text);
        }

    }
    public void type2(By locator) {

        WebElement element = wd.findElement(locator);
      //  element.click();
        element.sendKeys(Keys.TAB);
        pause(1000);
      // element.sendKeys(Keys.ENTER);
    }
    public void type3(By locator) {

        WebElement element = wd.findElement(locator);
        element.click();
      //  element.sendKeys(Keys.TAB);
      pause(1000);
        element.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
        pause(1000);
        element.sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
    }

public void zoomout(){

    wd.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
    wd.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.SUBTRACT));
}
    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }
}

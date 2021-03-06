package pageObjects.base;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver() {
        return driver;
    }


    // Get Page Title
    public String getPageTitle() {
        return driver.getTitle();
    }

}



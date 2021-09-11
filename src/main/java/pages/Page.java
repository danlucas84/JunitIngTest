package pages;

import drivers.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    private static String URL;
    protected final WebDriver driver;

    public Page() {
        driver = DriverProvider.getDriver();
        PageFactory.initElements(driver, this);
    }

    public abstract void open();
}

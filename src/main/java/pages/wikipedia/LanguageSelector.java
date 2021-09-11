package pages.wikipedia;

import org.openqa.selenium.By;
import pages.Page;

public class LanguageSelector extends Page {
    private static String URL = "https://www.wikipedia.org/";

    private By englishLangButton = new By.ByXPath("//div[@lang='en']");

    @Override
    public void open() {
        driver.get(URL);
    }

    public void openEnglishMainPage() {
        driver.findElement(englishLangButton).click();
    }
}

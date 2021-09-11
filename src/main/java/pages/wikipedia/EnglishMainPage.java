package pages.wikipedia;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Page;

public class EnglishMainPage extends Page {
    private static String URL = "https://en.wikipedia.org/wiki/Main_Page";

    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(id = "articlecount")
    private WebElement articleCountSentence;

    @Override
    public void open() {
        driver.get(URL);
    }

    public void searchFor(final String query) {
        searchFor(query, true);
    }

    public void searchFor(final String query, final boolean shouldSubmit) {
        searchInput.sendKeys(query);
        if (shouldSubmit) searchInput.submit();
    }

    public int getCurrentArticleCount() {
        return Integer.parseInt(articleCountSentence.getText().replaceAll("\\D+",""));
    }
}

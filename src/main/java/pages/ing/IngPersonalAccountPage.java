package pages.ing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import pages.Page;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import utils.Tools;

import java.math.BigDecimal;
import java.util.List;

public class IngPersonalAccountPage extends Page {
    private static String URL = "https://login.ingbank.pl/mojeing/demo/#home";

    @FindBy(css = "*.ing-product-group-C span.ing-balance")
    private WebElement accountBalanceConcrete;

    @FindBy(css = "*.ing-product-group-S span.ing-balance")
    private WebElement savingsBalanceConcrete;

    //to samo co niżej: @FindBy(css = "*.ing-product-group-C span.ing-balance")
    @FindBys({@FindBy(css = "*.ing-product-group-CARD"), @FindBy(css = "span.ing-balance")})
    private WebElement cardBalanceConcrete;

    @FindBy(css = "*.ing-product-group-INVESTMENT span.ing-balance")
    private List<WebElement> investmentsBalanceConcrete;

    @FindBy(xpath = "//span[contains(@class, 'ing-rotator-item ing-balance')]")
    private WebElement balance;

    @Override
    public void open() {
        driver.get(URL);
    }

    public BigDecimal getPersonalAccountBalance() {
        final String balanceWholeText = accountBalanceConcrete.getText();
        return Tools.getBigDecimalFromString(balanceWholeText);
    }

    public BigDecimal getPersonalSavingsBalance() {
        // poniższa linia wywali błąd 'NotImplementedException' przy próbie użycia -> czyli trzeba ją zastąpić właściwą implementacją ;)
        throw new NotImplementedException();
    }

    public BigDecimal getPersonalCardBalance() {
        throw new NotImplementedException();
    }

    public BigDecimal getPersonalInvestmentLocalBalance() {
        final String balanceWholeText = investmentsBalanceConcrete.get(0).getText();
        return Tools.getBigDecimalFromString(balanceWholeText);
    }

    public BigDecimal getPersonalInvestmentForeignBalance() {
        throw new NotImplementedException();
    }

    public BigDecimal getPersonalInvestmentBalanceOfGivenCurrency(final String currency) {
        // to co wspominałem -> ze strony mamy liste dwóch bilansów, np 1000 PLN, 250 USD
        // robimy metodę taką, żeby zwróciła nam ten właśnie bilans, który zawiera podaną w argumencie tej metody currency
        // szkolne rozwiązanie - pętla for np na zasadzie mixu przykładów z https://www.w3schools.com/java/java_break.asp
        throw new NotImplementedException();
    }
}

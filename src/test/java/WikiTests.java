import drivers.DriverProvider;
import org.junit.*;
import pages.wikipedia.EnglishMainPage;
import pages.wikipedia.LanguageSelector;

public class WikiTests {

    @BeforeClass
    public static void init() {
        System.out.println("Starting all from this class tests...");
    }

    @Before
    public void initEachTest() {
        System.out.println("Starting test...");
    }

    @Test
    public void wikipediaSearchTest() {
        LanguageSelector selectionPage = new LanguageSelector();
        selectionPage.open();
        selectionPage.openEnglishMainPage();
        EnglishMainPage enPage = new EnglishMainPage();
        enPage.searchFor("Yeti");
        final String actualTitle = DriverProvider.getDriver().getCurrentUrl();
        final String expectedTitle = "https://en.wikipedia.org/wiki/Yeti";
        Assert.assertEquals("Unexpected page title.", actualTitle, expectedTitle);
    }

    @Test
    public void wikipediaArticleCountNotHigher() {
        EnglishMainPage enPage = new EnglishMainPage();
        enPage.open();
        int currentArticleCount = enPage.getCurrentArticleCount();
        final int expectedCount = 6317021;
        Assert.assertTrue("Article count smaller than expected.", expectedCount <= currentArticleCount);
    }


    @After
    public void after() {
        System.out.println("Test finished, closing driver...");
        DriverProvider.flush();
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("All tests finished.");
    }
}

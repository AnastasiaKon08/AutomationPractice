import io.github.bonigarcia.wdm.WebDriverManager;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchItemTest {

    MainPage mainPage;

    WebDriver driver;

    private WebDriver driverSetUp()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        return driver;
    }

    @BeforeEach
    public void setUp()
    {
        driver = driverSetUp();
        mainPage = new MainPage(driver);
    }


    @Test
    public void VerifySearchResults()
    {
        mainPage.searchItem("dress");
        String results = mainPage.returnSearchResults();
        assertThat(results, containsString("7 results have been found."));
    }

    @AfterEach
    public void shutDown()
    {
        driver.quit();
    }
}

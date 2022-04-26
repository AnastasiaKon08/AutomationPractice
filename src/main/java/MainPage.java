import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class MainPage {

    private static By SEARCH_BAR = By.cssSelector("input#search_query_top");
    private static By SUBMIT_SEARCH = By.cssSelector("button[name=submit_search]");
    private static By RESULTS = By.cssSelector("span.heading-counter");

    private WebDriver driver;

    public MainPage(WebDriver webDriver){
        this.driver = webDriver;
    }

    public void searchItem(String item)
    {
        driver.findElement(SEARCH_BAR).sendKeys(item);
        driver.findElement(SUBMIT_SEARCH).click();
    }

    public String returnSearchResults()
    {
        return driver.findElement(RESULTS).getText();
    }
}

package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class YahooTest {

    WebDriver driver;

    By compPaginationBy = By.className("compPagination");
    WebElement resultsAmountElement;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testYahooSearch() {
        String queryString = "wikipedia";

        openMainPage();
        typeQuery(queryString);
        submitSearch();
        waitForResultPage();
        assertResultPage();
    }

    private void waitForResultPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(compPaginationBy));
        WebElement compPaginationEl = driver.findElement(compPaginationBy);
        resultsAmountElement = compPaginationEl.findElement(By.tagName("span"));
    }

    private void assertResultPage() {
        boolean isResultsVisible = resultsAmountElement.isDisplayed();
        assertTrue(isResultsVisible);
    }

    private void submitSearch() {
        WebElement inputTextField = driver.findElement(By.cssSelector("#uh-search-box"));
        inputTextField.submit();
    }

    private void typeQuery(String textToType) {

        WebElement inputTextField = driver.findElement(By.cssSelector("#uh-search-box"));
        inputTextField.sendKeys(textToType);
    }

    private void openMainPage() {
        String url = "https://www.yahoo.com";
        driver.get(url);

    }
}

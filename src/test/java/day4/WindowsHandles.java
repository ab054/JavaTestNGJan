package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowsHandles {

    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    //TODO: Homework: make a different scenario using windowHandles
    @Test
    public void testHW() {

    }

    @Test
    public void test001() {
        String url = "http://the-internet.herokuapp.com/windows";

        openMainPage(url);
        clickOnLink("Click Here");
        //TODO: create an explicit wait here
        mySleep(2);
        assertTwoWindows();
        switchToNewWindow();
        assertTextOnPage();
    }

    private void assertTextOnPage() {
        Assert.assertTrue(driver.getPageSource().contains("New Window"));
    }

    private void switchToNewWindow() {
        Object[] array = driver.getWindowHandles().toArray();
        String windowHandle1 = (String) array[1];
        driver.switchTo().window(windowHandle1);
        String actualWindowTitle = driver.getTitle();
        String expectedWindowTitle = "New Window";
        Assert.assertEquals(actualWindowTitle, expectedWindowTitle);
    }

    private void mySleep(int timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void assertTwoWindows() {
       Set<String> windowHandles = driver.getWindowHandles();

       int size = windowHandles.size();
       int expectedSize = 2;

       Assert.assertEquals(size, expectedSize);
    }

    private void clickOnLink(String linkText) {
        WebElement element = driver.findElement(By.partialLinkText(linkText));
        element.click();
    }

    private void openMainPage(String url) {
        driver.get(url);
    }
}

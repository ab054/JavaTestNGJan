package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class IFrameTests {
    WebDriver driver;

    By textEditorInput = By.id("tinymce");

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }


    @Test
    public void test001() {
        String url = "http://the-internet.herokuapp.com/tinymce";
        String textToType = "Text typed from Webdriver";


        driver.get(url);
        switchToiFrame();
        clearEditor();
        typeText(textToType);

        assertTextTyped(textToType);
    }

    private void assertTextTyped(String expectedText) {
        String actualTextFromElement = driver.findElement(textEditorInput).getText();
        Assert.assertEquals(actualTextFromElement, expectedText);
    }

    private void typeText(String textToType) {
        driver.findElement(textEditorInput).sendKeys(textToType);
    }

    private void clearEditor() {
        driver.findElement(textEditorInput).clear();
    }

    private void switchToiFrame() {
        WebElement webelement = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(webelement);
    }

    @Test
    public void test002() {
        String url = "http://the-internet.herokuapp.com/nested_frames";
        String topFrame = "frame-top";
        String middleFrame = "frame-middle";
        String expectedText = "MIDDLE";

        driver.get(url);

        switchToFrameByName(topFrame);
        switchToFrameByName(middleFrame);

        assertMiddleText(expectedText);
    }

    @Test
    public void test003() {
        String url = "http://the-internet.herokuapp.com/nested_frames";
        String topFrame = "frame-top";
        String middleFrame = "frame-middle";
        String leftFrame = "frame-left";
        String expectedText = "LEFT";

        driver.get(url);

        switchToFrameByName(topFrame);
        switchToFrameByName(leftFrame);

        assertLeftText(expectedText);
    }

    private void assertMiddleText(String expectedText) {
        String actualMiddleText = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(actualMiddleText, expectedText);
    }

    private void assertLeftText(String expectedText) {
        boolean result = driver.getPageSource().contains(expectedText);
        Assert.assertTrue(result);
    }

    private void switchToFrameByName(String frameName) {
        driver.switchTo().frame(frameName);
    }
}

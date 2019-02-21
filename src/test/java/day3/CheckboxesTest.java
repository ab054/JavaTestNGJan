package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        String url = "https://the-internet.herokuapp.com/checkboxes";

        driver.get(url);

        WebElement checkbox1 = driver.findElements(By.tagName("input")).get(0);
        WebElement checkbox2 = driver.findElements(By.tagName("input")).get(1);

        String checkbox1Attribute = checkbox1.getAttribute("checked");

        Assert.assertNull(checkbox1Attribute);

        checkbox1.click();

        String checkbox1Attribute2 = checkbox1.getAttribute("checked");

        Assert.assertEquals(checkbox1Attribute2, "true");


    }
}

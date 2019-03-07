package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTests {

    WebDriver driver;

    By textEditorInput = By.id("tinymce");

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test001() {
        String xpath = "html/body/div[1]/div[2]/div[2]/div[1]/form/div[1]/div/div[1]/div/div/input[1]";
        String xpath2 = "//form/div[1]/div/div[1]/div/div/input[1]";
        String xpath3 = "//*[@name='restaurant_id']";
        String xpath4 = "//*[@name='restaurant_id'][@type='text']";
        String xpath5 = "//*[@name='restaurant_id' and @type='text']";
        String xpath6 = "//*[@name='restaurant_id' or @type='adfadsfasdfdasfsd']";
        String xpath7 = "//*[contains(@name,'aurant_id')]";
        String xpath8 = "//*[starts-with(@name,'rest')]";
        String xpath9 = "//*[text()='Log In']";
        //TODO: why we found email input using following locator
        String xpath10= "//input[@type='text'])[last()]";

        //TODO: find email text input with position() xpath method
        String xpath11= "//input[@type='text'][2]";
        String xpath12= "//input[@type='text'][position()=2]";
        String xpath13= "//*[@id='FirstName']/following::input[@type='text']";
        String xpath14= "//*[@id='LastName']//preceding::input[@type='text']";










    }
}

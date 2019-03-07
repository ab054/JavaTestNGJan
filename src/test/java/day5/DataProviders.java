package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviders {

    WebDriver driver;

    By textEditorInput = By.id("tinymce");

    @BeforeSuite
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\barab\\IdeaProjects\\JavaTestNGJan\\src\\test\\resources\\drivers\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void beforeMethod() {
        //TODO: before each method prepare environment for the test
    }

    @AfterMethod
    public void tearDownCleaningTheState() {
        //TODO: after each test clean the state so next test is not affected
    }

    @Test
    public void test001() {
        String url = "the-internet.herokuapp.com/basic_auth";
        String login = "admin";
        String password = "admin";
        String url2 = "https://" + login + ":" + password + "@" + url;

        driver.get(url2);

        boolean isCongratsInSource = driver.getPageSource().contains("Congratulations!");

        Assert.assertTrue(isCongratsInSource);
    }

    @Parameters({ "loginParamFromXML", "passwordParamFromXML" })
    @Test
    public void test002(String loginParam, String passwordParam) {
        String url = "the-internet.herokuapp.com/basic_auth";
        String login = loginParam;
        String password = passwordParam;
        String url2 = "https://" + login + ":" + password + "@" + url;

        driver.get(url2);

        boolean isCongratsInSource = driver.getPageSource().contains("Congratulations!");

        Assert.assertTrue(isCongratsInSource);
    }


    @Test(dataProvider = "myDataProvider001")
    public void test003(String loginParam, String passwordParam) {
        String url = "the-internet.herokuapp.com/basic_auth";
        String login = loginParam;
        String password = passwordParam;
        String url2 = "https://" + login + ":" + password + "@" + url;

        driver.get(url2);

        boolean isCongratsInSource = driver.getPageSource().contains("Congratulations!");

        Assert.assertTrue(isCongratsInSource);
    }

    @DataProvider(name = "myDataProvider001")
    public Object[][] createData1() {
        return new Object[][] {
                { "admin", "admin" },
                { "admin", "ItypeWrongPasswordHere"},
        };
    }


}

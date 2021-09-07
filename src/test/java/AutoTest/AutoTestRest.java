package AutoTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class AutoTestRest {

    public static GetClientSex getClientSex;
    public static Responses responses;
    public static WebDriver driver;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver.exe");
        driver = new ChromeDriver();
        getClientSex = new GetClientSex(driver);
        responses = new Responses(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("Page"));
    }

    @Test
    public void SexIdTest(){
        getClientSex.clickTryItOut();
        getClientSex.inputClientId(ConfProperties.getProperty("UserId"));
        getClientSex.clickExecute();
        String id = responses.getUserId();
        String sex = responses.getUserSex();
        Assertions.assertEquals(ConfProperties.getProperty("ExpectedId"), id);
        Assertions.assertEquals(ConfProperties.getProperty("ExpectedSex"), sex);
        responses.getDownload();
    }

    @AfterAll
    public static void SetDown(){
        driver.close();
        driver.quit();
    }
}
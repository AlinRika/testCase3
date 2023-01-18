import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

public class testCase3 {
    public static WebDriver driver;

    private String startLink = "http://u920152e.beget.tech/# ";
    private String correctMail = "correctMail@mail.ru";
    private String correctPassword = "correctPassword";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() {
        driver.get(startLink);
        WebElement loginInput = driver.findElement(By.cssSelector("input[name^='auth_email']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name^='auth_pass']"));
        WebElement submitButton = driver.findElement(By.cssSelector("button[name^='form_auth_submit']"));
        String expectedUrl = "http://u920152e.beget.tech/page1.html?auth_email=correctMail%40mail.ru&auth_pass=correctPassword&form_auth_submit=";

        loginInput.sendKeys(correctMail);
        passwordInput.sendKeys(correctPassword);
        submitButton.click();

        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }

    @After
    public void closeTest(){
        driver.quit();
    }
}

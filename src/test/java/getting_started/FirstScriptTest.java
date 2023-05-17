package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.invoke.MethodHandles;
import java.security.PrivateKey;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.ofSeconds;


public class FirstScriptTest {
    public WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterClass
    public void teardown() {
        System.out.println("test run successful");
        driver.quit();
    }

    @Test
    public void firstTest() {

        WebElement username = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='username']")));
        WebElement password = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
        WebElement loginButton = driver.findElement(By.xpath("//i[contains(text(),'Login')]"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        loginButton.click();


        WebElement loginText = driver.findElement(By.xpath("//div[@id='flash']"));
        String value = loginText.getText().trim().replaceAll("\n", "").replace("×", "");

        Assert.assertEquals("You logged into a secure area!", value);

        WebElement logoutButton = driver.findElement(By.xpath("//i[contains(text(),'Logout')]"));
        logoutButton.click();

        WebElement logoutText = driver.findElement(By.xpath("//div[@id='flash']"));
        String valueLogout = logoutText.getText().trim().replaceAll("\n", "").replace("×", "");

        Assert.assertEquals("You logged out of the secure area!", valueLogout);


    }
}

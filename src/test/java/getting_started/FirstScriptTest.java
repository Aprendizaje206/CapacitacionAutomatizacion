package getting_started;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

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
    public void firstTest() throws InterruptedException {

        WebElement user = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        user.sendKeys("tomsmith");

        WebElement password = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        password.sendKeys("SuperSecretPassword!");

        WebElement button = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/button")));
        button.click();

        Thread.sleep(5000);

        WebElement result = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'You logged into a secure area!')]")));
        String resultText = result.getText().trim();
        resultText = resultText.replaceAll("\n","");
        resultText = resultText.replaceAll("×","");
        //result.getText();
        System.out.println(resultText);

        Thread.sleep(5000);

        String textoValidacion = "You logged into a secure area!";
        Assert.assertEquals(textoValidacion,resultText);

    }
}

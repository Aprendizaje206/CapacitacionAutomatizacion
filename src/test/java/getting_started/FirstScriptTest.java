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

        WebElement usuario = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("username")));
        usuario.sendKeys("tomsmith");
        Thread.sleep(1000);

        WebElement password = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
        password.sendKeys("SuperSecretPassword!");
        Thread.sleep(1000);

        WebElement loggin = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/button")));
        loggin.click();
        Thread.sleep(1000);

        WebElement tittle = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"You logged into a secure area!\")]")));
        String tittleIni =tittle.getText().trim();
        tittleIni=tittleIni.replaceAll("\n","");
        tittleIni=tittleIni.replaceAll("'*'","");
        System.out.println(tittleIni);
        Thread.sleep(1000);

        String comparativo = "You logged into a secure area!×";

        Assert.assertEquals(comparativo,tittleIni);

        WebElement loggout = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/a")));
        loggout.click();
        Thread.sleep(1000);

        /*
        String title = driver.getTitle();
        Assert.assertEquals("Página de inicio de sesión", title);

        WebElement searchBox = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        WebElement searchButton = driver.findElement(By.name("btnK"));

        searchBox.sendKeys("Selenium");
        searchButton.click();

        searchBox = driver.findElement(By.name("q"));
        String value = searchBox.getAttribute("value");
        Assert.assertEquals("Selenium", value);

         */
    }
}

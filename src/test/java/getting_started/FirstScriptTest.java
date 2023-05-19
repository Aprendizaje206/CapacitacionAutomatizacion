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


        WebElement usuario = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"username\"]")));
         usuario.sendKeys("tomsmith");

        WebElement pass = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        pass.sendKeys("SuperSecretPassword!");

        WebElement boton = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"login\"]/button/i")));
        boton.click();

         Thread.sleep(2000);


        WebElement titulo = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'You logged into a secure area!')]")));
        String textoInicial = titulo.getText().trim();
        textoInicial=textoInicial.replaceAll("\n", "");
        textoInicial=textoInicial.replace("×","");
        textoInicial=textoInicial.trim();
        System.out.println(textoInicial);

        Thread.sleep(1000);

       String textoComparar1 = "You logged into a secure area!";
        Assert.assertEquals(textoComparar1,textoInicial);


        WebElement BotonSalir = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"content\"]/div/a")));
        BotonSalir.click();

        Thread.sleep(2000);

        WebElement tituloFinal = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.id("flash")));


        String textoFinal = tituloFinal.getText().trim();
        textoFinal=textoFinal.replaceAll("\n", "");
        textoFinal=textoFinal.replace("×","");
        textoFinal=textoFinal.trim();
        System.out.println(textoFinal);



        String textoComparar2 = "You logged out of the secure area!";
        Assert.assertEquals(textoComparar2,textoFinal);


    }
}

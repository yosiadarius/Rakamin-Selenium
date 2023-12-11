package kasirAja;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test
    public void success_login_case(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();
        //ChromeOptions opt = new ChromeOptions();
        // Apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        // Membuka halaman login
        driver.get(baseUrl);

        // Assert
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");

        // Input Email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");

        // Input Password
        driver.findElement(By.id("password")).sendKeys("test321");

        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Assert nama toko di dashboard page
         String namaToko = driver.findElement(By.xpath("//*[@id=\'root\']/div/div/div[2]/div[2]/div/div[1]/div[1]/div/dl/dt")).getText();
//        String namaToko = driver.findElement(By.xpath("//dt[contains(text(),'Sel Ventures')]")).getText();
        Assert.assertEquals(namaToko,"Sel Ventures");

        // Quit
        // driver.close();
    }


    @Test
    public void failed_login_case(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();
        //ChromeOptions opt = new ChromeOptions();
        // Apply chrome driver setup
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Membuka halaman login
        driver.get(baseUrl);

        // Assert
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");

        // Input Email
        driver.findElement(By.id("email")).sendKeys("admin@sel.com");

        // Input Password
        driver.findElement(By.id("password")).sendKeys("12345");

        // Click Login
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        String ErrorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(ErrorLogin,"Kredensial yang Anda berikan salah");
    }


}

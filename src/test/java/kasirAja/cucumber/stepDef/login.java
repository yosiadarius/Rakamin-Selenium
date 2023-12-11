package kasirAja.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

// Script didapat dengan menonton video
// 6. Topik 6 - Integrasi Gherkin dan test case - (5) Cucumber Step
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55895


public class login {
    WebDriver driver;
    String baseUrl = "https://kasirdemo.belajarqa.com/";

    @Given("Halaman Login KasirAja")
    public void halamanLoginKasirAja() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        // Assert
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'hai, kasirAja')]")).getText();
        Assert.assertEquals(loginPageAssert,"hai, kasirAja");
    }

    @When("Input Username")
    public void inputUsername() {
        driver.findElement(By.id("email")).sendKeys("tdd-selenium@gmail.com");
    }

    @And("Input Password")
    public void inputPassword() {
        driver.findElement(By.id("password")).sendKeys("tdd-selenium");

    }

    @And("Click Login Button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
            }

    @Then("User In On Dashboard Page")
    public void userInOnDashboardPage() {
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
        driver.close();
    }

    @And("Input Invalid Password")
    public void inputInvalidPassword() {
        driver.findElement(By.id("password")).sendKeys("12345");
    }

    @Then("User Get Error Message")
    public void userGetErrorMessage() {
        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "Kredensial yang Anda berikan salah");
        driver.close();
    }

    // Start Pindahan dari LoginTDD

    @When("I input (.*) as email$")
    public void userInputTddSeleniumGmailComAsEmail(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @And("I Input (.*) as password$")
    public void userInputTddSeleniumGmailComAsPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }
    @When("click login button")
    public void click_login_button() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Then("I verify (.*) login result$")
    public void userInputTddSeleniumGmailComAsStatus(String status) {
        if (status.equals("success")) { // Jika sukses
            driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
            String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
            Assert.assertEquals(username, "tdd-selenium");
        } else { // Jika gagal
            String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
            Assert.assertEquals(errorLogin, "Kredensial yang Anda berikan salah");
        }
        driver.close();
    }

}

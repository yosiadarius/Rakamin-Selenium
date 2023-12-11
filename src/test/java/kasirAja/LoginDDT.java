package kasirAja;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Script didapat dengan menonton video
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55888

public class LoginDDT {
    // Login menggunakan Data Driven Test / DDT

    @Test
    public void login_ddt(){
        WebDriver driver;
        String baseUrl = "https://kasirdemo.belajarqa.com/";

        WebDriverManager.chromedriver().setup();
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        String csvDir = System.getProperty("user.dir")+"/src/test/data/test-data.csv";

        try(CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String email = nextLine[0]; // Read Column 1 for email
                String password = nextLine[1]; // Read Column 2 for password
                String status = nextLine[2]; // Read Column 3 for expected login status

                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); // Set Timeout for webdriver on waiting element
                driver.manage().window().maximize(); // Maximize Windows
                driver.get(baseUrl);

                // Pengisian Form
                driver.findElement(By.id("email")).sendKeys(email);
                driver.findElement(By.id("password")).sendKeys(password);
                driver.findElement(By.xpath("//button[@type='submit']")).click();

                // Assertion
                if (status.equals("success")) { // Jika sukses
                    driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
                    String username = driver.findElement(By.xpath("//dd[contains(text(),'hai')]/preceding-sibling::dt")).getText();
                    Assert.assertEquals(username, "tdd-selenium");
                } else { // Jika gagal
                    String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
                    Assert.assertEquals(errorLogin, "Kredensial yang Anda berikan salah");
                }
                //driver.close();
            } // End Of While

        }   catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }  // End Of Try
    }
}

package mobile.login;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Script didapat dengan menonton video
// 5. Topik 5 - Appium automation testing - (6) Page Object Model
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55856

public class loginDDT {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub";
    @Test
    public void login_mobile_ddt() {
        ChromeOptions opt = new ChromeOptions();
        opt.setHeadless(false);

        String csvDir = System.getProperty("user.dir") + "/src/test/data/test-data.csv";

        try (CSVReader reader = new CSVReader(new FileReader(csvDir))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String email = nextLine[0]; // Read Column 1 for email
                String password = nextLine[1]; // Read Column 2 for password
                String status = nextLine[2]; // Read Column 3 for expected login status

                capabilities = new DesiredCapabilities();
                capabilities.setCapability("udid", "emulator-5554");
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("platformVersion", "13");
                capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/java/mobile/apk/KasirAja.apk");
                capabilities.setCapability("autoGrantPermission", true); // set auto accept permission request setting
                capabilities.setCapability("autoAcceptAlerts", true); // set auto accept all possible appearing alert

                // Open Apps
                URL url = new URL(baseUrl);
                driver = new AndroidDriver(url, capabilities);
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

                driver.findElement(By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).sendKeys(email);;
                driver.findElement(By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys(password);;
                driver.findElement(By.xpath("//android.widget.Button")).click();

                // Assertion
                if (status.equals("success")) { // Jika sukses
                    driver.findElement(By.xpath("//android.widget.TextView[@text='kasirAja']")).isDisplayed();
                } else { // Jika gagal
                    driver.findElement(By.xpath("//android.widget.TextView[@text='Kredensial yang Anda berikan salah']")).isDisplayed();
                }



        /*
        Script dari video tapi failed
                driver.findElement(By.xpath("//*[contains(@text,'email')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys(email);
                driver.findElement(By.xpath("//*[contains(@text,'password')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys(password);
                driver.findElement(By.xpath("//*[contains(@text,'login')]/parent::android..widget.Button")).click();
                // Assertion
                if (status.equals("success")) { // Jika sukses
                    driver.findElement(By.xpath("//*[contains(@text,'kasirAja')]")).isEnabled();
                } else { // Jika gagal
                    driver.findElement(By.xpath("//*[contains(@text,'Kredensial yang Anda berikan salah')]")).isDisplayed();
                    driver.quit();
                }
         */
                System.out.println("Run '" + status + " case' done!");
            } // End Of While

        } catch (CsvValidationException | IOException e) {
            throw new RuntimeException(e);
        }  // End Of Try
    }
}

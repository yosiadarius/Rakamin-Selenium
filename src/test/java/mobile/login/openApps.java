package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Script didapat dengan menonton video
// 5. Topik 5 - Appium automation testing - (3) Setup Device Capabiliites
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55890

public class openApps {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void main() throws MalformedURLException {
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("udid","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("app",System.getProperty("user.dir")+"/src/test/java/mobile/apk/KasirAja.apk");
        capabilities.setCapability("autoGrantPermission",true); // set auto accept permission request setting
        capabilities.setCapability("autoAcceptAlerts",true); // set auto accept all possible appearing alert

        // Open Apps
        URL url = new URL(baseUrl);
        driver = new AndroidDriver(url,capabilities);
        // Set Timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Script didapat dengan menonton video
        // 5. Topik 5 - Appium automation testing - (4) Mendapatkan Mobile Element
        // https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55855

        /* Trial
        driver.findElement(By.xpath("//*[@text='email']"));//.sendKeys("tdd-selenium@gmail.com"); // passed
        driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("tdd-selenium"); // passed
        driver.findElement(By.xpath("//*[contains(@text,'email')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.TextView"));
        */

        driver.findElement(By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")).sendKeys("tdd-selenium@gmail.com");;
        driver.findElement(By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")).sendKeys("tdd-selenium");;
        driver.findElement(By.xpath("//android.widget.Button")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@text='kasirAja']")).isEnabled();

        /*
        Script dari video tapi failed
        driver.findElement(By.xpath("//*[contains(@text,'password')]/parent::android.view.ViewGroup/following-sibling::android.view.ViewGroup/android.widget.EditText")).sendKeys("tdd-selenium");
        driver.findElement(By.xpath("//*[contains(@text,'login')]/parent::android.widget.Button")).click();
        driver.findElement(By.xpath("//*[contains(@text,'kasirAja')]")).isEnabled();
        */
    }
}






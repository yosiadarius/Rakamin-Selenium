package mobile.login;

import io.appium.java_client.android.AndroidDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

// Import Function User Defined
import mobile.pageObjects.loginPage;
import mobile.pageObjects.dashboardPage;

// Script didapat dengan menonton video
// 5. Topik 5 - Appium automation testing - (6) Page Object Model
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55919

public class loginPOM {
    public static AndroidDriver driver;
    public static DesiredCapabilities capabilities;
    public static String baseUrl = "http://127.0.0.1:4723/wd/hub";

    @Test
    public void login_success() throws MalformedURLException {
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
        // Set Timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Define
        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        // Get element & Input Username
        loginPage.inputUsername("tdd-selenium@gmail.com");
        // Get element & Input Password
        loginPage.inputPassword("tdd-selenium");
        // Get element & Click Login Button
        loginPage.clickLoginBtn();
        // Assert KasirAja Title
        dashboardPage.assertDashboardPageTitle();
    }

    public void failed_login() throws MalformedURLException {
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
        // Set Timeout
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Define
        loginPage loginPage = new loginPage(driver);
        dashboardPage dashboardPage = new dashboardPage(driver);

        // Get element & Input Username
        loginPage.inputUsername("tdd-selenium@gmail.com");
        // Get element & Input Password
        loginPage.inputPassword("tdd-selenium");
        // Get element & Click Login Button
        loginPage.clickLoginBtn();
        // Assert KasirAja Title Error Login
        loginPage.assertFailedLoginErrMsg();
    }
}

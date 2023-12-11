package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

// Script didapat dengan menonton video
// 5. Topik 5 - Appium automation testing - (5) DDT Mobile
// https://www.rakamin.com/dashboard/my-class/2876/module/8127/session/55919
public class loginPage {
    AndroidDriver driver;

    // Construct Android Driver
    public loginPage(AndroidDriver driver){
        this.driver=driver;
    }

    // Locator
    By usernameField = By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]");
    By passwordField = By.xpath("//androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]");
    By loginBtn = By.xpath("//android.widget.Button");
    By failedLoginErrMsg = By.xpath("//android.widget.TextView[@text='Kredensial yang Anda berikan salah']");

    // Method or Function to do the task
    public void inputUsername(String email){
        driver.findElement(usernameField).sendKeys(email);
    }

    public void inputPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void assertFailedLoginErrMsg(){
        driver.findElement(failedLoginErrMsg).isDisplayed();
    }
}

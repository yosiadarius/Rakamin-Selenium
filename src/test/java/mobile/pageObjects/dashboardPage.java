package mobile.pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class dashboardPage {
    AndroidDriver driver;

    // Construct Android Driver
    public dashboardPage(AndroidDriver driver){
        this.driver=driver;
    }

    // Locator
    By pageTitle = By.xpath("//android.widget.TextView[@text='kasirAja']");

    // Method or Function to do the task
public void assertDashboardPageTitle(){
    driver.findElement(pageTitle).isDisplayed();

}

}

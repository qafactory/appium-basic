import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumTest {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        //Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        //caps.setCapability("deviceName", "GT-I9300I");
        caps.setCapability("deviceName", "192.168.1.125:5555");
        caps.setCapability("udid", "0b6614c1"); //Give Device ID of your mobile phone
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "4.4.4");
        caps.setCapability("appPackage", "com.android.vending");
        caps.setCapability("appActivity", "com.android.vending.AssetBrowserActivity");
        caps.setCapability("noReset", "true");

        //Instantiate Appium Driver
//        try {
////            AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
////
////
////        } catch (MalformedURLException e) {
////            System.out.println(e.getMessage());
////        }
        //AppiumDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),caps);
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

        Thread.sleep(5000);
        driver.findElement(By.id("com.android.vending:id/search_box_idle_text")).click();

        MobileElement searchFiled = (MobileElement) driver.findElement(By.id("com.android.vending:id/search_box_text_input"));
        searchFiled.sendKeys("English");

        //driver.findElement(By.id("com.android.vending:id/search_box_text_input")).sendKeys(Keys.ENTER);
        ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

    }
}




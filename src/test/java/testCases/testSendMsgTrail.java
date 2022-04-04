package testCases;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class test_sendMsgTrail {
    public static void main(String[] args) throws MalformedURLException {
        String url = "http://127.0.0.1:4732/wd/hub";

        var dc = new DesiredCapabilities();
        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName","android");
        dc.setCapability("appPackage","");
        dc.setCapability("appActivity","");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL(url),dc);

        //send msg out
        MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("Messages");
        el1.click();
        MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Start new conversation");
        el2.click();
        MobileElement el3 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
        el3.click();
        MobileElement el4 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/recipient_text_view");
        el4.sendKeys("10086");
        MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
        el5.click();
        MobileElement el6 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
        el6.click();
        MobileElement el7 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
        el7.click();
        MobileElement el8 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout");
        el8.click();
        MobileElement el9 = (MobileElement) driver.findElementById("android:id/button1");
        el9.click();
        MobileElement el10 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/compose_message_text");
        el10.sendKeys("1");
        MobileElement el11 = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/send_message_button_icon");
        el11.click();

        //back to msg-sent box
        driver.navigate().back();


        MobileElement recipient = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/conversation_name");
        MobileElement txt = (MobileElement) driver.findElementById("com.google.android.apps.messaging:id/conversation_snippet");


        Assert.assertEquals(recipient.getText(),"10086");
        Assert.assertEquals(txt.getText(),"1");
    }
}

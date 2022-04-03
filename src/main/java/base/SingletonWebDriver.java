package base;

import enums.AppType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;


public class SingletonWebDriver {
    private static AndroidDriver<AndroidElement> driver;
    private static AppType appType = ReadConfigFile.getInstance().getAppType();
    private static SingletonWebDriver instance;
    private static String url = "http://127.0.0.1:4732/wd/hub";

    private SingletonWebDriver(){driver=createDriver();}

    public static SingletonWebDriver getInstance(){
        if(instance==null){
            instance = new SingletonWebDriver();
        }
        return instance;
    }

    //expose to user
    public AndroidDriver<AndroidElement>  getDriver(){
        return driver;
    }

    private AndroidDriver<AndroidElement> createDriver(){
        var dc = new DesiredCapabilities();

        dc.setCapability(MobileCapabilityType.DEVICE_NAME,"emulator-5554");
        dc.setCapability("platformName","android");

        switch(appType){
            case Contact -> {
                dc.setCapability("appPackage","com.android.contacts");
                dc.setCapability("appActivity",".activities.PeopleActivity");
            }
            case Settings -> {
                dc.setCapability("appPackage","com.android.settings");
                dc.setCapability("appActivity",".accounts.AddAccountSettings");
            }
            default -> {
                dc.setCapability("appPackage","com.google.android.apps.messaging");
                dc.setCapability("appActivity",".ui.ConversationListActivity");
            }
        }



        try{
            driver = new AndroidDriver<AndroidElement>(new URL(url),dc);
        } catch(MalformedURLException e){
            e.printStackTrace();
        }
        return driver;
    }
}

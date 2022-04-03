package Utils;

import base.SingletonWebDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


public abstract class TestInit {
    public static AndroidDriver<AndroidElement> driver;
    public static Logger logger = null;

    public TestInit(){
        logger = LogManager.getLogger();
        driver = SingletonWebDriver.getInstance().getDriver();
    }


    /**
     * Actions
     */
    //js script execution
    protected void jsExe(String script, WebElement element){
        ((JavascriptExecutor) driver).executeScript(script, element);
    }


    /**
     * Assert
     */
    //assert string equals
    protected void assertStrEqual(String actual, String expect){
        logger.info("expect result : " + expect);
        logger.info("actual result : " + actual);
        Assert.assertEquals(actual, expect);
    }

    //assert string contains
    protected void assertStrContains(String actual, String expect){
        logger.info("expect result : " + expect);
        logger.info("actual result : " + actual);
        Assert.assertTrue(actual.contains(expect));
    }

    //assertEqual int
    protected void assertEqualInt(int actual, int expect){
        logger.info("expect result : " + expect + "; actual result : " + actual);
        Assert.assertEquals(actual, expect);
    }

    //assertMoreThan int
    protected void assertMoreThanInt(int actual, int benchmark){
        logger.info("benchmark : " + benchmark + "; actual result : " + actual);
        Assert.assertTrue(actual>benchmark);
    }

    //assertLessThan int
    protected void assertLessThanInt(int actual, int benchmark){
        logger.info("benchmark : " + benchmark + "; actual result : " + actual);
        Assert.assertTrue(actual<benchmark);
    }

    /**
     * Snapshot
     */
    //take screenshot
    protected void takeScreenshot() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(new Date());
        String screenshotFilePath = System.getProperty("user.dir")+"//screenshots//" + date + ".png";

        try{
            File SrcFile = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotFilePath);
            FileUtils.copyFile(SrcFile,destFile);
            logger.info("Snapshot captured " + screenshotFilePath);
        } catch (Exception e){
            throw new RuntimeException("Failed to capture snapshot");
        }
    }

    protected String takeScreenshot(String methodName) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String date = sdf.format(new Date());
        String screenshotFilePath = System.getProperty("user.dir")+"//testResult//screenshots//" + methodName + date + ".png";

        try{
            File SrcFile = driver.getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotFilePath);
            FileUtils.copyFile(SrcFile,destFile);
            logger.info("Snapshot captured " + screenshotFilePath);
        } catch (Exception e){
            throw new RuntimeException("Failed to capture snapshot");
        }
        return screenshotFilePath;
    }

    /**
     * Tear down
     */
    //driver quit
    public void tearDown() {
        driver.close();
        //may throw exception: "org.openqa.selenium.os.ProcessUtils killWinProcess
        if(driver!=null){
            driver.quit();
        }
    }
}

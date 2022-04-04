package testCases;

import Pages.ContactList;
import Pages.Message;
import Utils.Listeners.Retry;
import Utils.TestInit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class test_scroll extends TestInit{
    ContactList contactList;
    Message msg;

    @Test(retryAnalyzer = Retry.class)
    public void send(){
        contactList.person1.click();
        contactList.txtToPerson1.click();
        PointOption pointStart = PointOption.point(2359,2334);
        PointOption pointEnd = PointOption.point(1272,424);
        (new TouchAction(driver))
                .press(pointStart)
                .moveTo(pointEnd)
                .release()
                .perform();


        msg.assertEqualStr(msg.targetMsg.getText(),"10086");

    }

    @AfterClass(description = "tear down")
    public void quit(){
        tearDown();
    }
}

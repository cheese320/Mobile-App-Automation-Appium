package Pages;

import Utils.TestInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ContactList extends TestInit {
    /**
     * Elements
     */
    @AndroidBy(accessibility = "Apps list")
    AndroidElement appList;

    @AndroidBy(accessibility = "person1")
    public AndroidElement person1;

    @AndroidBy(accessibility = "text 1008-6")
    public AndroidElement txtToPerson1;

    @AndroidBy(id = "com.google.android.apps.messaging:id/compose_message_text")
    AndroidElement msgToSend;

    @AndroidBy(id= "com.google.android.apps.messaging:id/send_message_button_icon")
    AndroidElement sendBtn;


    @AndroidBy(xpath="//android.widget.RelativeLayout[@content-desc=\"Call Mobile 1008-6\"]/android.widget.TextView[1]")
    AndroidElement receipientInSentBox;

    @AndroidBy(id="com.google.android.apps.messaging:id/conversation_snippet")
    AndroidElement txtInSentBox;

    /**
     * Actions
     */
    //send message
    public void sendMessageText(String txt) {
        appList.click();
        person1.click();
        msgToSend.sendKeys(txt);
        sendBtn.click();
    }

    /**
     * Assert
     */
    public void assertMsgSent(String txt){
        assertStrEqual("10086",receipientInSentBox.getText());
        logger.info("recipient expected result: " + "10086" +
                " ,  actual result: " +
                receipientInSentBox.getText());
        logger.info("sendTxt expected result: " + txtInSentBox.getText() +
                " ,  actual result: " +
                txt);
    }
}
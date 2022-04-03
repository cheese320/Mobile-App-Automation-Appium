package Pages;

import Utils.TestInit;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;

public class Message extends TestInit {
    /**
     * Elements
     */
    @AndroidBy(accessibility="Messages")
    AndroidElement message;

    @AndroidBy(accessibility="Start new conversation")
    AndroidElement startNewConversation;

    @AndroidBy(xpath="/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout")
    AndroidElement confirmInput;

    @AndroidBy(id="/com.google.android.apps.messaging:id/recipient_text_view")
    AndroidElement receipient;

    @AndroidBy(id="com.google.android.apps.messaging:id/compose_message_text")
    AndroidElement msgText;

    @AndroidBy(id="com.google.android.apps.messaging:id/send_message_button_icon")
    AndroidElement sendBtn;

    @AndroidBy(id="com.google.android.apps.messaging:id/conversation_name")
    AndroidElement receipientInSentBox;

    @AndroidBy(id="com.google.android.apps.messaging:id/conversation_snippet")
    AndroidElement txtInSentBox;

    //selector, all msg sent
    //@FindBy(xpath="//android.widget.FrameLayout[@content-desc=\"You said, 1, 37 minutes, SMS\"])[5]")
    @FindBy(xpath="//*[contains(@content-desc, \"You said\")][0]")
    public AndroidElement targetMsg;




    /**
     * Actions
      */
    //send message
    public void sendMessageText(String recipientNum, String txt){
        message.click();
        startNewConversation.click();
        receipient.sendKeys(recipientNum);
        msgText.sendKeys(txt);
        sendBtn.click();
    }

    /**
     * Assert
     */
    public void assertEqualStr(String recipientNum, String txt){
        assertStrEqual(recipientNum,receipientInSentBox.getText());
        logger.info("recipient expected result: " + receipientInSentBox.getText() +
                " ,  actual result: " +
                recipientNum);
        logger.info("sendTxt expected result: " + txtInSentBox.getText() +
                " ,  actual result: " +
                txt);
    }
}

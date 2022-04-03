package testCases;

import Pages.ContactList;
import Utils.Listeners.Retry;
import Utils.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class selectContactSendMsg extends TestInit {
    ContactList contactList;

    @Test(retryAnalyzer = Retry.class)
    public void send(){
        String txt = "1";
        contactList.sendMessageText(txt);
        driver.navigate().back();
        contactList.assertMsgSent(txt);
    }

    @AfterClass(description = "tear down")
    public void quit(){
        tearDown();
    }
}

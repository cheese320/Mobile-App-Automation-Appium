package testCases;

import Pages.Message;
import Utils.Listeners.Retry;
import Utils.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class sendMessageOut extends TestInit{
    Message msg;

    @Test(retryAnalyzer = Retry.class)
    public void send(){
        String[] list = {"10086","1"};
        msg.sendMessageText(list[0],list[1]);
        driver.navigate().back();
        assertStrEqual(list[0],list[1]);
    }

    @AfterClass(description = "tear down")
    public void quit(){
        tearDown();
    }
}

package Zenfolio;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class delete_Pending_orders extends SeleneseTestCase {
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://secure.b.zenfolio.us/");
		selenium.start();
	}

	@Test
	public void testDelete_Pending_orders() throws Exception {
		
		String name = "denismtest";
		String[] label = {"WaitingPayment", "WaitingApproval",  "Placed", "Assembled", "Uploading", "UploadRetrying", "Executing", "Shipped"};
				
		
		selenium.open("/zf/admin");
		selenium.windowMaximize();
		selenium.type("id=ctl00_Frame_LoginForm-username", "admin");
		selenium.type("id=ctl00_Frame_LoginForm-password", "welcome");
		selenium.click("id=ctl00_Frame_LoginForm-send");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Orders");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		
		for (int i=0; i<label.length; i++){
		
		selenium.select("name=state", "label=" + label[i]);
		selenium.type("name=plogin", name);
		selenium.click("link=Search");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		
		while(selenium.isElementPresent("css=span.nowrap"))
			{		
		selenium.click("css=span.nowrap");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.click("//a[contains(text(),'Cancel...')]");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.click("id=refundOrder");
		selenium.click("id=sendEmail");
		selenium.click("//a[contains(text(),'Apply')]");
		Thread.sleep(2000);
		selenium.click("//a[contains(text(),'Continue')]");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.click("link=Orders");
		selenium.waitForPageToLoad("30000");
		selenium.select("name=state", "label=" + label[i]);
		selenium.type("name=plogin", name);
		selenium.click("link=Search");
		selenium.waitForPageToLoad("30000");
			}
		
		}
		
	}
	
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

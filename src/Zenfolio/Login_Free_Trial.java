package Zenfolio;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Login_Free_Trial extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		//selenium.start("captureNetworkTraffic=true");
		// create TestUtils objectselenium.start("captureNetworkTraffic=true");
		utils = new TestUtils(selenium);
	}

	@Test
	public void testLogin_Free_Trial() throws Exception {
	try
	{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		selenium.open("/");
		selenium.click("//a[contains(text(),'Free Trial')]");
		selenium.waitForPageToLoad("30000");
		selenium.type("ctl00_SignupForm-displayName", "test");
		selenium.type("ctl00_SignupForm-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("ctl00_SignupForm-password", "password");
		selenium.type("ctl00_SignupForm-confirmPassword", "password");
		selenium.click("link=Start Free Trial");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.signup-url > a");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Back to Edit View");
		selenium.waitForPageToLoad("30000");
		selenium.click("GettingStarted_Dialog_b0");
		verifyTrue(selenium.isTextPresent("Organizer"));
		utils.CheckText("Organizer", "//div[@id='ctl01-left']/h2", "Login_Free_Trial Fail");
		utils.CheckElement("link=Logout", "Login_Free_Trial Fail");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		utils.CheckNotElement("link=Logout", "Login_Free_Trial Fail");
		
		// write to file
		Log.print("Free Trial email: AutomationTest"+random+"@zenfolio.com");
	}
	catch(Exception ex)
	{
		selenium.captureEntirePageScreenshot("c:\\temp\\FreeTrial.jpg", "");
		throw ex;
	}
	}


	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
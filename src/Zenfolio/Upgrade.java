package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Upgrade extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testUpgrade() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("//a[contains(text(),'Free Trial')]");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=ctl00_SignupForm-displayName", "test");
		selenium.type("id=ctl00_SignupForm-email", "AutomationTest"+random+"@zenfolio.com");
		Log.print("AutomationTest"+random+"@zenfolio.com");
		selenium.type("id=ctl00_SignupForm-password", "qwerty");
		selenium.type("id=ctl00_SignupForm-confirmPassword", "qwerty");
		selenium.click("id=ctl00_SignupForm-submit");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=div.signup-url > a")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		selenium.click("css=div.signup-url > a");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.header-logo");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("link=Upgrade", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Continue")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		selenium.clickAt("//div[contains(@class,'sp-body')]//div[contains(@class,'sp-buttons')]//a[contains(text(),'Continue')]", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[contains(@data-category,'tsm')]//a[contains(text(),'Show details »')]", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@data-ref,'tsm-all')]//a[contains(@class,'pushbutton')]", "");
		Thread.sleep(2000);
		selenium.click("id=continue");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=ctl00_Frame_PaymentForm-street", "asdfggfd");
		selenium.type("id=ctl00_Frame_PaymentForm-city", "adffad");
		selenium.type("id=ctl00_Frame_PaymentForm-state", "ca");
		selenium.type("id=ctl00_Frame_PaymentForm-zipCode", "94040");
		selenium.type("id=ctl00_Frame_PaymentForm-phone", "1234567890");
		selenium.type("id=ctl00_Frame_PaymentForm-cardNumber", "4111111111111111");
		selenium.fireEvent("id=ctl00_Frame_PaymentForm-cardNumber", "blur");
		selenium.select("id=ctl00_Frame_PaymentForm-expMonth", "label=02");
		selenium.select("id=ctl00_Frame_PaymentForm-expYear", "label=2016");
		selenium.type("id=ctl00_Frame_PaymentForm-cardCvv", "123");
		selenium.type("id=ctl00_Frame_PaymentForm-cardName", "test");
		selenium.click("id=ctl00_Frame_PaymentForm-submit");
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Continue to My Account");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='GettingStarted_Dialog__body']/div[2]/div/div");
		selenium.click("id=GettingStarted_Dialog_b0");
		utils.CheckElement("link=Basic", "Upgrade fail");
		/*if (selenium.isElementPresent("link=Basic"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Manage Add-ons");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//h4/span","");
		Thread.sleep(1000);
		utils.CheckText("Purchased","//div[2]/div[2]/div[2]","Upgrade fail");
		Thread.sleep(1000);
		/*if (selenium.isTextPresent("Purchased"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Upgrade");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/h4/span", "");
		selenium.clickAt("//div[2]/div[2]/div/div[2]/a", "");
		selenium.click("id=continue");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Continue to My Account");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='GettingStarted_Dialog__body']/div[2]/div/div");
		selenium.click("id=GettingStarted_Dialog_b0");
		utils.CheckElement("link=Unlimited","Upgrade fail");
		/*if (selenium.isElementPresent("link=Unlimited"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Manage Add-ons");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[2]/h4/span","");
		Thread.sleep(1000);
		utils.CheckText("Purchased", "//div[2]/h4/span", "Upgrade fail");
		/*if (selenium.isTextPresent("Purchased"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Upgrade");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[3]/h4/span/em", "");
		selenium.clickAt("//div[3]/div[2]/div/div[2]/a", "");
		selenium.click("id=continue");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Continue to My Account");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='GettingStarted_Dialog__body']/div[2]/div/div");
		selenium.click("id=GettingStarted_Dialog_b0");
		utils.CheckElement("link=Premium", "Upgrade fail");
		/*if (selenium.isElementPresent("link=Premium"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Manage Add-ons");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[3]/h4/span","");
		Thread.sleep(1000);
		utils.CheckText("Purchased", "//div[3]/h4/span", "Upgrade fail");
		/*if (selenium.isTextPresent("Purchased"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Upgrade");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[4]/h4", "");
		selenium.clickAt("//div[4]/div[2]/div/div[2]/a", "");
		selenium.click("id=continue");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Continue to My Account");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='GettingStarted_Dialog__body']/div[2]/div/div");
		selenium.click("id=GettingStarted_Dialog_b0");
		utils.CheckElement("link=Premium Business", "Upgrade fail");
	/*	if (selenium.isElementPresent("link=Premium Business"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Manage Add-ons");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//div[4]/h4/span","");
		Thread.sleep(1000);
		utils.CheckText("Purchased", "//div[4]/h4/span", "Upgrade fail");
		/*if (selenium.isTextPresent("Purchased"))
		{} else
		{
			Log.print("Upgrade fail");
			throw new Exception();
			};
			*/
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.header-logo");
		selenium.waitForPageToLoad("30000");
	}
	catch(Exception ex)
	{
		selenium.captureEntirePageScreenshot("c:\\temp\\Upgrade.jpg", "");
		throw ex;
	}
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

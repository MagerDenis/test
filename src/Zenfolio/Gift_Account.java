package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
//import java.lang.String;

public class Gift_Account extends SeleneseTestCase {

	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testGift_Account() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		selenium.open("/");
		// Clear cookies
		selenium.deleteAllVisibleCookies();
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		
		//get price
		
		String s = selenium.getText("//div[7]/div[2]/div/em");
		String st = s.substring(1);
		int i = Integer.parseInt(st);
		
		selenium.click("//div[7]/div[2]/div[2]/a");
		selenium.waitForPageToLoad("30000");
		
		utils.CheckText("$" + i + ".00", "//div[2]/div/div[4]/span", "Gift fail");
		
		selenium.type("id=ctl00_Frame_InfoForm-name", "test");
		selenium.type("id=ctl00_Frame_InfoForm-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.clickAt("id=ctl00_Frame_InfoForm-submit", "");
		selenium.type("id=ctl00_Frame_PaymentForm-street", "dghdfgh");
		selenium.type("id=ctl00_Frame_PaymentForm-city", "dfghhgf");
		selenium.type("id=ctl00_Frame_PaymentForm-state", "ca");
		selenium.type("id=ctl00_Frame_PaymentForm-zipCode", "94040");
		selenium.type("id=ctl00_Frame_PaymentForm-phone", "1234567890");
		selenium.type("id=ctl00_Frame_PaymentForm-cardNumber", "4111111111111111");
		selenium.fireEvent("id=ctl00_Frame_PaymentForm-cardNumber", "blur");
		selenium.select("id=ctl00_Frame_PaymentForm-expMonth", "label=02");
		selenium.select("id=ctl00_Frame_PaymentForm-expYear", "label=2016");
		selenium.type("id=ctl00_Frame_PaymentForm-cardCvv", "123");
		selenium.type("id=ctl00_Frame_PaymentForm-cardName", "test");
		Thread.sleep(2000);
		selenium.click("id=ctl00_Frame_PaymentForm-submit");
		utils.CheckText("$" + i + ".00", "//div[@id='ctl00_Frame_ConfirmationForm_Balance']/div[5]/span", "Gift fail");
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=ctl00_ctl02_EmailForm-to", "denism@zenfolio.com");
		selenium.click("id=send");
		//Get Gift code
		String code = selenium.getText("css=strong");
		selenium.click("link=Go to Zenfolio Homepage");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Sign up')])[2]");
		selenium.waitForPageToLoad("30000");
		//Enter gift code
		selenium.type("name=coupon", code);
		selenium.click("link=Apply");
		Thread.sleep(2000);
		utils.CheckText("$0.00", "//div[@id='ctl00_Frame_ctl01_ctl00_Balance']/div[7]/span", "Gift fail");
		selenium.click("id=continue");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=ctl00_Frame_AccountForm-displayName", "test");
		selenium.type("ctl00_Frame_AccountForm-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("id=ctl00_Frame_AccountForm-password", "qwerty");
		selenium.type("id=ctl00_Frame_AccountForm-confirmPassword", "qwerty");
		Thread.sleep(2000);
		selenium.clickAt("id=ctl00_Frame_AccountForm-submit", "");
		Thread.sleep(2000);
		selenium.type("id=ctl00_Frame_PaymentForm-street", "sdfggdf");
		selenium.type("id=ctl00_Frame_PaymentForm-city", "sdfgdfg");
		selenium.type("id=ctl00_Frame_PaymentForm-state", "ca");
		selenium.type("id=ctl00_Frame_PaymentForm-zipCode", "94040");
		selenium.type("id=ctl00_Frame_PaymentForm-phone", "1234567890");
		selenium.type("id=ctl00_Frame_PaymentForm-cardNumber", "4111111111111111");
		selenium.fireEvent("ctl00_Frame_PaymentForm-cardNumber", "blur");
		Thread.sleep(1000);
		selenium.select("id=ctl00_Frame_PaymentForm-expMonth", "label=02");
		selenium.select("id=ctl00_Frame_PaymentForm-expYear", "label=2016");
		selenium.type("id=ctl00_Frame_PaymentForm-cardCvv", "123");
		selenium.type("id=ctl00_Frame_PaymentForm-cardName", "test");
		selenium.click("id=ctl00_Frame_PaymentForm-submit");
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (("$" + i + "/yr").equals(selenium.getText("css=div.balance-item.balance-total > span.balance-price"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		utils.CheckText("$" + i + "/yr", "css=div.balance-item.balance-total > span.balance-price", "Gift fail");
		utils.CheckText("$0.00", "//div[@id='ctl00_Frame_ConfirmationForm_Balance']/div[8]/span", "Gift fail");
		
		selenium.clickAt("id=signup", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("//form[2]/div/div/a");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.zenbar-account-link.zenbar-color2 > span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='GettingStarted_Dialog__body']/div[2]/div/div");
		selenium.click("id=GettingStarted_Dialog_b0");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img");
		selenium.waitForPageToLoad("30000");
		// selenium.();
	}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Gift_Account.jpg", "");
			throw ex;
		}
		}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

package Zenfolio;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class create_paid_user_EUR_FF extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testCreate_paid_user_EUR() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		// Clear cookies
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("link=Sign Up");
		selenium.waitForPageToLoad("30000");
		utils.CheckText("$25", "//div[6]/div[2]/div/em", "Create_paid_account_eur_FF Fail");
		selenium.click("signup-currency");
		selenium.click("//div[@id='signup-currency']/div/a[3]/tt");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isTextPresent("€50/year"));
		Thread.sleep(1000);
		
		//get price
		
		String s = selenium.getText("//div[7]/div[2]/div/em");
		String st = s.substring(1);
		int i = Integer.parseInt(st);
		
		utils.CheckText(s, "//div[7]/div[2]/div/em", "Create_paid_account_eur_FF Fail");
		selenium.click("//div[contains(@class,'signup-plan') and contains(@data-ref,'unlimited')]//a[contains(@class,'pushbutton')]");
		selenium.waitForPageToLoad("30000");
		utils.CheckText("€" + i + "/yr", "//div[4]/span", "Create_paid_account_eur_FF Fail");
		selenium.clickAt("//tt", "");
		selenium.clickAt("link=Add", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[contains(@class,'addon-item addon-item-a')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//verifyTrue(selenium.isTextPresent("TSM - All Collections"));
		Thread.sleep(2000);
		utils.CheckText("€"+ (i+40) +"/yr", "//div[6]/span", "Create_paid_account_eur_FF Fail");
		selenium.click("continue");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isTextPresent("Account"));
		selenium.type("ctl00_Frame_AccountForm-displayName", "test");
		// Change email!!!!
		selenium.type("ctl00_Frame_AccountForm-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("ctl00_Frame_AccountForm-password", "password");
		selenium.type("ctl00_Frame_AccountForm-confirmPassword", "password");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("ctl00_Frame_AccountForm-submit")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.clickAt("ctl00_Frame_AccountForm-submit", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("ctl00_Frame_PaymentForm-submit")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//verifyTrue(selenium.isTextPresent("Payment Information"));
		Thread.sleep(3000);
		//utils.CheckText("€65", "//div[7]/span", "Create_paid_account_eur_FF Fail");
		selenium.type("ctl00_Frame_PaymentForm-street", "test");
		selenium.type("ctl00_Frame_PaymentForm-city", "test");
		selenium.type("ctl00_Frame_PaymentForm-state", "ca");
		selenium.type("ctl00_Frame_PaymentForm-zipCode", "12345");
		selenium.type("ctl00_Frame_PaymentForm-phone", "1234567890");
		Thread.sleep(1000);
		selenium.type("ctl00_Frame_PaymentForm-cardNumber", "4111111111111111");
		selenium.fireEvent("ctl00_Frame_PaymentForm-cardNumber", "blur");
		Thread.sleep(1000);
		selenium.clickAt("//div[9]/div/input", "");
		selenium.select("ctl00_Frame_PaymentForm-expMonth", "label=02");
		selenium.select("ctl00_Frame_PaymentForm-expYear", "label=2014");
		selenium.type("ctl00_Frame_PaymentForm-cardCvv", "123");
		//selenium.type("//div[9]/div/input", "123");
		selenium.fireEvent("ctl00_Frame_PaymentForm-cardCvv", "blur");
		Thread.sleep(3000);
		selenium.fireEvent("//div[9]/div/input", "blur");
		selenium.type("//input[contains(@id, '_PaymentForm-cardName')]", "test");
		Thread.sleep(1000);
		//verifyEquals("XXXX XXXX XXXX 1111", selenium.getValue("ctl00_Frame_PaymentForm-cardNumber"));
		utils.CheckValue("XXXX XXXX XXXX 1111", "document.forms[2].elements[6]", "Create_paid_account_eur_FF Fail");
		//verifyTrue(selenium.isTextPresent("Payment Information"));
		//verifyTrue(selenium.isTextPresent("Summary"));
		selenium.click("ctl00_Frame_PaymentForm-submit");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("signup")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		verifyTrue(selenium.isTextPresent("Summary"));
		verifyTrue(selenium.isTextPresent("Payment Information"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("signup")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		utils.CheckText("€"+(i+40)+".00", "//div[7]/span", "Create_paid_account_eur_FF Fail");
		selenium.clickAt("link=Create Account", "");
		//selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
		 
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//form[@id='ctl00_ctl02_WelcomeForm']/div[1]/div[1]/a")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Log.print("FF EUR email: AutomationTest"+random+"@zenfolio.com");
		//verifyTrue(selenium.isTextPresent("Welcome to Zenfolio!"));
		selenium.click("//form[@id='ctl00_ctl02_WelcomeForm']/div[1]/div[1]/a");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("ctl02_ctl16_View-img")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//verifyTrue(selenium.isTextPresent("All Photographs"));
		utils.CheckText("All Photographs", "//div[4]/span", "Create_paid_account_eur_FF Fail");
		selenium.click("//div[@id='zenbar']/div/a[2]/span");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isElementPresent("//div[@id='GettingStarted_Dialog__body']/div[2]/div[2]/div[1]/p[2]"));
		utils.CheckElement("//div[@id='GettingStarted_Dialog__body']/div[2]/div[2]/div[1]/p[2]", "Create_paid_account_eur_FF Fail");
		selenium.click("GettingStarted_Dialog_b0");
		utils.CheckText("Organizer", "//div[@id='ctl01-left']/h2", "Create_paid_account_eur_FF Fail");
		//verifyTrue(selenium.isTextPresent("Organizer"));
		selenium.click("link=Edit view");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isElementPresent("//div[@id='GettingStarted_Dialog__body']/div[2]/div[2]/div[1]/p[2]"));
		utils.CheckElement("//div[@id='GettingStarted_Dialog__body']/div[2]/div[2]/div[1]/p[2]", "Create_paid_account_eur_FF Fail");
		selenium.click("//a[@id='GettingStarted_Dialog_b0']/span");
		//verifyTrue(selenium.isTextPresent("Organizer"));
		utils.CheckText("Organizer", "//div[@id='ctl01-left']/h2", "Create_paid_account_eur_FF Fail");
		selenium.click("link=My Home Page");
		selenium.waitForPageToLoad("30000");
		//verifyTrue(selenium.isTextPresent("All Photographs"));
		utils.CheckText("All Photographs", "//div[4]/span", "Create_paid_account_eur_FF Fail");
		utils.CheckElement("link=Logout", "Create_paid_account_eur_FF Fail");
		//verifyTrue(selenium.isElementPresent("link=Logout"));
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@id, 'zenbar')]//a[contains(text(),'Logout')]","");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		utils.CheckNotElement("//div[contains(@id, 'zenbar')]//a[contains(text(),'Logout')]", "Create_paid_account_eur_FF Fail");
		//verifyFalse(selenium.isElementPresent("link=Logout"));
		selenium.click("link=About Zenfolio");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\AccountEurFF.jpg", "");
			throw ex;
		}
		}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

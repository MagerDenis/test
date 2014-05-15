package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Email_Communications extends SeleneseTestCase {

	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testEmail_Communications() throws Exception {
		try
		{
		selenium.windowMaximize();
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denismtest");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.click("id=NewFeatures_Dialog_b0");
		Thread.sleep(1000);
		selenium.clickAt("//div[@id='ctl02_Organizer-comments']/div/h4","");
		Thread.sleep(2000);
		selenium.clickAt("//div[@id='ctl02_Organizer_CommentsTree-i--emails']/div[3]/a/span","");
		Thread.sleep(2000);
		
		//Delete all e-mails
		while (selenium.isElementPresent("//a[contains(@class,'email-delete')]")){
			selenium.click("//a[contains(@class,'email-delete')]");
			Thread.sleep(1000);
			selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
			Thread.sleep(3000);
		}
		
		//Create new e-mail
		selenium.click("link=New E-mail");
		selenium.click("id=Compose-send-now");
		selenium.type("id=Compose-to", "denism@zenfolio.com");
		selenium.type("id=Compose-subject", "automationtest");
		Thread.sleep(2000);
		
		
		
		// start working with RichEdit iframe 
		selenium.selectFrame("id=Compose_Dialog_RichEdit-iframe");
		
		selenium.typeKeys("//body/div", "bla-bla");
		
		// roll back to main frame
		selenium.selectFrame("relative=parent");
		
		
		
		Thread.sleep(2000);

		selenium.click("//a[contains(@id, 'Compose_Dialog') and contains(text(), 'Continue to Preview')]");
		Thread.sleep(1000);
		selenium.click("id=Compose-thumbs");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[contains(text(),'View Photos')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=Compose_Dialog_b1");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[contains(@class,'email-delete')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		utils.CheckText("Sent", "//div[contains(@class,'ae-nonempty ae-emails')]//td[contains(@class,'email-status')]", "E-mail Communications fail");
		selenium.click("css=a.email-delete");
		selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
		Thread.sleep(2000);
		selenium.click("link=New E-mail");
		selenium.click("id=Compose-send-now");
		selenium.click("id=Compose-send-save");
		selenium.type("id=Compose-to", "denism@zenfolio.com");
		selenium.type("id=Compose-subject", "automationtest");
		Thread.sleep(2000);
		
		
		
		// start working with RichEdit iframe 
		selenium.selectFrame("id=Compose_Dialog_RichEdit-iframe");
		
		selenium.typeKeys("//body/div", "bla-bla");
		
		// roll back to main frame
		selenium.selectFrame("relative=parent");
		
		
		
		Thread.sleep(2000);

		selenium.click("//a[contains(@id, 'Compose_Dialog') and contains(text(), 'Continue to Preview')]");
		selenium.click("id=Compose-thumbs");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[contains(text(),'View Photos')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=Compose_Dialog_b1");
		Thread.sleep(2000);
		
		utils.CheckText("Draft", "//div[contains(@class,'ae-nonempty ae-emails')]//td[contains(@class,'email-status')]", "E-mail Communications fail");
		
		selenium.click("link=Duplicate");
		selenium.click("id=Compose-send-now");
		selenium.click("id=Compose-send-later");
		Thread.sleep(1000);
		selenium.click("//a[contains(@id, 'Compose_Dialog') and contains(text(), 'Continue to Preview')]");
		Thread.sleep(1000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[contains(text(),'View Photos')]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		Thread.sleep(2000);
		selenium.click("//a[contains(text(),'Schedule E-mail')]");
		Thread.sleep(2000);
		selenium.click("css=a.email-delete");
		selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
		Thread.sleep(3000);
				
		utils.CheckText("Scheduled", "//div[contains(@class,'ae-nonempty ae-emails')]//td[contains(@class,'email-status')]", "E-mail Communications fail");
		
		while (selenium.isElementPresent("//a[contains(@class,'email-delete')]")){
			selenium.click("//a[contains(@class,'email-delete')]");
			Thread.sleep(1000);
			selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
			Thread.sleep(3000);
		}
		
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Email_Communications.jpg", "");
			throw ex;
		}
	}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

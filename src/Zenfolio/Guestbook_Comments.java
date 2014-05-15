package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Guestbook_Comments extends SeleneseTestCase {

	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL_private);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}
	@Test
	public void testGuestbook_Comments() throws Exception {
		try
		{
		selenium.windowMaximize();
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		String random = new RandomStr().get(10);
		
		//Guestbook comment
		selenium.click("link=Add entry");
		selenium.type("id=ctl02_ctl04_GuestbookBin_Guestbook_MessageEdit-name", "denismtest");
		selenium.type("id=ctl02_ctl04_GuestbookBin_Guestbook_MessageEdit-body", "bla-bla-guest");
		selenium.type("id=ctl02_ctl04_GuestbookBin_Guestbook_MessageEdit-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("id=ctl02_ctl04_GuestbookBin_Guestbook_MessageEdit-url", "www.bla.com");
		Thread.sleep(3000);
		selenium.click("id=ctl02_ctl04_GuestbookBin_Guestbook_MessageEdit-add");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("bla-bla-guest".equals(selenium.getText("//div[contains(@id, 'GuestbookBin_Guestbook_MessageList')]/div[contains(text(), 'bla-bla-guest')]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		//Check guest comment
		utils.CheckText("bla-bla-guest", "//div[contains(@id, 'GuestbookBin_Guestbook_MessageList')]/div[contains(text(), 'bla-bla-guest')]", "Guestbook_Comments_fail");
		Thread.sleep(2000);
		
		//Comment to photo
		selenium.click("id=ctl02_ctl04_RootBin_Grid_i1-img");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=ctl02_PhotoGrid_i1-img");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=ctl02_RecentComments-add");
		selenium.type("id=ctl02_Comments_MessageEdit-name", "denismtest");
		Thread.sleep(1000);
		selenium.type("//div[@id='ctl02_Comments_MessageEdit-body-field']/div[2]/div/textarea", "bla-bla-comment");
		selenium.type("id=ctl02_Comments_MessageEdit-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("id=ctl02_Comments_MessageEdit-url", "www.bla.com");
		Thread.sleep(3000);
		selenium.click("id=ctl02_Comments_MessageEdit-add");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("bla-bla-comment".equals(selenium.getText("//div[contains(@id, 'Comments_MessageList')]/div[contains(text(),'bla-bla-comment')]"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		selenium.click("id=ctl02_Comments-close");
		
		//Private comment
		Thread.sleep(3000);
		selenium.click("id=ctl02_RecentComments-add");
		selenium.click("css=#ctl02_Comments_MessageEdit-access-private > input[name=\"me-access\"]");
		selenium.type("id=ctl02_Comments_MessageEdit-name", "denismtest");
		Thread.sleep(1000);
		selenium.type("id=ctl02_Comments_MessageEdit-body", "bla-bla-private");
		selenium.type("id=ctl02_Comments_MessageEdit-email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("id=ctl02_Comments_MessageEdit-url", "www.bla.com");
		Thread.sleep(3000);
		selenium.click("id=ctl02_Comments_MessageEdit-add");
		selenium.click("id=ctl02_Comments_MessageEdit-continue");
		Thread.sleep(2000);
		selenium.click("id=ctl02_Comments-close");
		
		//Login
		selenium.click("link=denismtest");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=user", "denismtest");
		selenium.type("name=password", "qwerty");
		selenium.click("css=#ctl02_LoginSubmit-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='zenbar']/div/a[2]/span");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.click("id=NewFeatures_Dialog_b0");
		selenium.clickAt("//div[contains(@id, 'Organizer-comments')]/div/h4", "");
		Thread.sleep(2000);
		selenium.clickAt("css=#ctl02_Organizer_CommentsTree-i--comments > div.tree-item > a > span","");
		selenium.waitForPageToLoad("30000");
		
		//Checking messages
		Thread.sleep(2000);
		utils.CheckText("bla-bla-private", "//div[contains(@class, 'aemd-msg private')]//div[contains(text(),'bla-bla-private')]", "Comments Fail");
		utils.CheckText("bla-bla-comment", "//div[contains(@class, 'aemd-msg')]//div[contains(text(),'bla-bla-comment')]", "Comments Fail");
		utils.CheckText("bla-bla-guest", "//div[contains(@class, 'aemd-msg')]//div[contains(text(),'bla-bla-guest')]", "Comments Fail");
		
		//Delete messages
		selenium.click("css=input.aemd-checkbox");
		selenium.click("//a[contains(text(),'Delete')]");
		selenium.click("id=msgbox1_b0");
		
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("No messages meet your search criteria".equals(selenium.getText("css=div.aemd-empty"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(3000);
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=About Zenfolio");
		selenium.waitForPageToLoad("30000");
	}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Comments.jpg", "");
			throw ex;
		}
	}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

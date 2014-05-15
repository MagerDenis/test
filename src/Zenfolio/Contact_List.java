package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Contact_List extends SeleneseTestCase {

	protected TestUtils utils;
	
	@Before
	
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testContact_List() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		selenium.open("/");
		// Clear cookies
		selenium.deleteAllVisibleCookies();
		
		
		//Contact list must be empty!
		
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denismtest");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.click("id=NewFeatures_Dialog_b0");
		selenium.clickAt("//div[contains(@id, 'Organizer-comments')]/div/h4", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id, 'Organizer_CommentsTree-i--contacts')]/div/a/span", "");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(2000);
		selenium.click("//div[@id='ctl03_ContactList']/table/thead/tr/th/input");
		Thread.sleep(2000);
		if (selenium.isElementPresent("//div[contains(@id, 'Frame-middle')]//a[contains(@class, 'ae-contacts-cmd ae-contacts-cmd-delete disabled')]"))
		{}
		else{
			selenium.clickAt("//div[contains(@id, 'Frame-middle')]//a[contains(@class, 'ae-contacts-cmd ae-contacts-cmd-delete')]", "");
			selenium.clickAt("id=msgbox1_b0","");
			}
		Thread.sleep(2000);
		selenium.click("link=Add Contact");
		selenium.type("name=email", "AutomationTest"+random+"@zenfolio.com");
		selenium.type("name=name", "denismtest");
		Thread.sleep(2000);
		selenium.click("id=ctl03_ctl03");
		selenium.clickAt("//div[3]/div/span", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id, '_TagPopup')]//div[contains(@class, 'tree-branch')]//span[contains(text(), 'test')]", "");
		selenium.click("id=ctl03_TagPopup_ctl01");
		utils.CheckText("denismtest", "//tr[2]/td[2]", "Contact list Fail");

		Thread.sleep(2000);
		selenium.click("css=#ctl03_TagFilter > div.aectf-arrow");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id, '_TagPopup')]//div[contains(@class, 'tree-branch')]//span[contains(text(), 'price')]", "");
		Thread.sleep(2000);
		selenium.clickAt("//a[contains(text(),'Apply')]", "");
		Thread.sleep(3000);
		utils.CheckText("No contacts match your search criteria.", "//div[3]/p", "Contact list Fail");

		selenium.click("css=#ctl03_TagFilter > div.aectf-arrow");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id, '_TagPopup')]//div[contains(@class, 'tree-branch')]//span[contains(text(), 'price')]", "");
		Thread.sleep(2000);
		selenium.clickAt("//a[contains(text(),'Apply')]", "");
		Thread.sleep(2000);
		utils.CheckText("denismtest", "//tr[2]/td[2]", "Contact list Fail");
		
		selenium.clickAt("//tr[2]/td/input","");
		selenium.click("css=a.ae-contacts-cmd.ae-contacts-cmd-delete");
		selenium.clickAt("link=Yes","");
		Thread.sleep(2000);
		utils.CheckText("Your account has no contacts.", "//p", "Contact list Fail");
		
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Contact_List.jpg", "");
			throw ex;
		}
		}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

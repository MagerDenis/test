package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PDF_Upload extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testPDF_Upload() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		// Clear cookies
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denismtest");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.click("id=NewFeatures_Dialog_b0");
		Thread.sleep(2000);
		selenium.clickAt("//div[@id='ctl02_Organizer-files']/div/h4", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("PDF Documents".equals(selenium.getText("css=#ctl02_Organizer_FilesTree-i--documents > div.tree-item > a > span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		selenium.clickAt("css=#ctl02_Organizer_FilesTree-i--documents > div.tree-item > a > span", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("PDF Documents".equals(selenium.getText("css=span.aeh-title"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		
		while (selenium.isElementPresent("css=a.doc-delete")){
			selenium.click("css=a.doc-delete");
			Thread.sleep(1000);
			selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
			Thread.sleep(3000);
		}
		
		selenium.clickAt("//a[@id='addNew']/span[2]", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Friendly Link (URL):".equals(selenium.getText("css=label"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		selenium.type("id=Edit_Dialog-file", "C:\\ForUpload\\Create Android Sample App.pdf");
		selenium.click("id=Edit_Dialog_b0");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Create Android Sample App.pdf".equals(selenium.getText("link=Create Android Sample App.pdf"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		selenium.click("link=Edit");
		Thread.sleep(1000);
		selenium.type("id=Edit_Dialog-url", "create-android-sample-app" + random + ".pdf");
		selenium.type("id=Edit_Dialog-name", "Create Android Sample App" + random + ".pdf");
		Thread.sleep(1000);
		selenium.click("id=Edit_Dialog_b1");
		Thread.sleep(4000);
		utils.CheckText("Create Android Sample App" + random + ".pdf", "css=a.doc-edit", "PDF upload fail");
		//utils.CheckText("http://.../create-android-sample-app" + random + ".pdf", "//td[contains(@class,'doc-url')]/a", "PDF upload fail");
	
		selenium.click("css=a.doc-delete");
		Thread.sleep(1000);
		selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
		Thread.sleep(3000);
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\PDF_Upload.jpg", "");
			throw ex;
		}
		}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

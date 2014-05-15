package Zenfolio;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Recently_Added extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testRecently_Added() throws Exception {
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
		selenium.clickAt("id=NewFeatures_Dialog_b0", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id, 'Organizer_PhotoTree-i-gal')]//span[contains(text(),'price')]", "");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[@id='photoUpload']/span[2]");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=hidden-files", "C:\\ForUpload\\DSC_8202.jpg");
		selenium.click("id=ctl03_Start");
		Thread.sleep(1000);
		selenium.clickAt("//a[contains(text(),'Upload Duplicates')]","");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=#ctl03_Grid_i2 > div.pv-outer > a.pv-inner > div.pv-iborder")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.clickAt("//div[contains(@id, 'Organizer_PhotoTree-i--recent')]/div/a/span", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("css=div.pv-title-o", "");
		utils.CheckText("price", "//div[contains(@id,'Grid_i1')]//div[contains(@id, 'Grid_i1-title')]", "Recently added fail");
		/*if (selenium.isTextPresent("test"))
		{} else
		{
			Log.print("Recently added fail");
			throw new Exception();
			};
		*/
		selenium.doubleClick("css=div.pv-iborder");
		selenium.waitForPageToLoad("30000");
		selenium.click("id=ctl03_Grid_i1_menu");
		selenium.click("//a[@id='listContextDelete']/span[2]");
		selenium.click("css=#msgbox1_b0 > span.btn-confirm");
		selenium.clickAt("//div[contains(@id, 'Organizer_PhotoTree-i-gal')]//span[contains(text(),'test')]", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='photoUpload']/span[2]", "");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=hidden-files", "C:\\ForUpload\\DSC_8201.jpg");
		selenium.clickAt("id=ctl03_Start", "");
		Thread.sleep(1000);
		selenium.clickAt("//a[contains(text(),'Upload Duplicates')]","");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=div.pv-iborder")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.clickAt("//div[contains(@id, 'Organizer_PhotoTree-i--recent')]/div/a/span", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("css=div.pv-title-o", "");
		utils.CheckText("test", "//div[contains(@id,'Grid_i1')]//div[contains(@id, 'Grid_i1-title')]", "Recently added fail");
		/*if (selenium.isTextPresent("price"))
		{} else
		{
			Log.print("Recently added fail");
			throw new Exception();
			};
			*/
		selenium.doubleClick("css=div.pv-iborder");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//a[@id='photoUpload']/span[2]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=ctl03_Grid_i1_menu");
		selenium.click("//a[@id='listContextDelete']/span[2]");
		selenium.click("id=msgbox1_b0");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	}
	catch(Exception ex)
	{
		selenium.captureEntirePageScreenshot("c:\\temp\\Recently_added.jpg", "");
		throw ex;
	}
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Soundtracks extends SeleneseTestCase {
	
	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}
	@Test
	public void testSoundtracks() throws Exception {
		try
		{
		selenium.windowMaximize();
		// Clear cookies
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denismtest");
		selenium.click("id=ctl00_SiteHeader_Login-password");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.clickAt("id=NewFeatures_Dialog_b0", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[@id='ctl02_Organizer-files']/div/h4", "");
		Thread.sleep(1000);
		selenium.clickAt("//div[@id='ctl02_Organizer_FilesTree-i--soundtracks']/div[3]/a/span", "");
		Thread.sleep(1000);
		
		while (selenium.isElementPresent("css=a.strack-delete")){
			selenium.click("css=a.strack-delete");
			Thread.sleep(1000);
			selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
			Thread.sleep(3000);
		}
		
		selenium.click("//a[@id='addNew']/span[2]");
		selenium.type("id=Edit_Dialog-file", "C:\\ForUpload\\wrx_sti_mix_96_kbps.mp3");
		selenium.click("id=Edit_Dialog-confirm");
		Thread.sleep(1000);
		selenium.click("id=Edit_Dialog_b0");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (!selenium.isElementPresent("//div[@id='Edit_Dialog__progress']/div/h5")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		utils.CheckText("wrx_sti_mix_96_kbps", "css=td.strack-filename", "Soundtrack_fail");
		
		selenium.click("css=td.strack-play > a");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=a.strack-playing")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(2000);
		selenium.click("css=a.strack-playing");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("css=td.strack-play > a")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(1000);
		selenium.click("css=td.strack-play > a");
		selenium.click("css=a.strack-delete");
		selenium.click("//a[contains(@id, 'msgbox') and contains(text(),'Yes')]");
		Thread.sleep(3000);
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Soundtracks.jpg", "");
			throw ex;
		}
		}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Watermark extends SeleneseTestCase {

protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}


	@Test
	public void testWatermark() throws Exception {
		try
		{
		selenium.windowMaximize();
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		
		//Login
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denismtest");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("//div[@id='NewFeatures_Dialog__body']/div[2]/div/div");
		selenium.click("id=NewFeatures_Dialog_b0");
		Thread.sleep(2000);
		
		//Upload watermark
		selenium.clickAt("//div[@id='ctl02_Organizer-files']/div/h4", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[@id='ctl02_Organizer_FilesTree-i--watermarks']/div[3]/a/span", "");
		Thread.sleep(2000);
		
		//Delete unused watermark
		if (selenium.isElementPresent("id=ctl04_Grid_i1_menu")) {
			selenium.click("id=ctl04_Grid_i1_menu");
			selenium.click("//a[@id='listContextDelete']/span[2]");
			selenium.click("id=msgbox1_b0");
			Thread.sleep(4000);			
		}
		
		//Upload
		selenium.click("//a[@id='addNew']/span[2]");
		selenium.click("id=Upload-custom");
		selenium.click("//form[@id='Upload']/div[3]/div/label");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("".equals(selenium.getText("//div[@id='Upload-list']/a/img"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		selenium.type("id=Upload-file", "C:\\ForUpload\\Watermark.png");
		Thread.sleep(2000);
		selenium.clickAt("id=Upload_Dialog_b0", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (!selenium.isElementPresent("id=Upload_Dialog__progress")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		//open gallery
		selenium.click("css=h4");
		Thread.sleep(2000);
		selenium.doubleClickAt("//div[contains(@id, 'Organizer_PhotoTree-i')]//a/span[contains(text(),'test')]", "");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("test".equals(selenium.getText("css=span.aeh-title"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		Thread.sleep(2000);
		
		//Apply watermark to gallery
		selenium.clickAt("//div[contains(@class,'tb-watermark')]//a[contains(@class, 'tb-edit')]","");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@id,'Edit_Dialog_List')]//div[contains(@id,'Edit_Dialog')][2]//td[contains(@class, 'preview')]//a","");
		Thread.sleep(1000);
		selenium.clickAt("//a[contains(@id, 'ctl04_ctl07_Edit_Dialog_b0')]","");
		Thread.sleep(4000);
		
		//Check first photo for watermark
		utils.CheckElement("//div[contains(@id,'Grid_i1')][1]//div[contains(@class, 'pve-icons')]/img[contains(@class,'watermark')]", "Watermark Filed");
	
		//Watch photo
		selenium.doubleClickAt("css=div.pv-iborder", "");
		Thread.sleep(3000);
		
		//removing watermark
		selenium.doubleClickAt("//div[contains(@id, 'Organizer_PhotoTree-i')]//a/span[contains(text(),'test')]", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[contains(@class,'tb-watermark')]//a[contains(@class, 'tb-edit')]","");
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@id,'Edit_Dialog_List')]//div[contains(@id,'Edit_Dialog')][1]//td[contains(@class, 'preview')]//a","");
		Thread.sleep(1000);
		selenium.clickAt("//a[contains(@id, 'ctl04_ctl07_Edit_Dialog_b0')]","");
		Thread.sleep(2000);
		
		//Check for no watermark
		utils.CheckNotElement("//div[contains(@id,'Grid_i1')][1]//div[contains(@class, 'pve-icons')]/img[contains(@class,'watermark')]", "Watermark Filed");
		
		//Delete Watermark
		selenium.clickAt("//div[@id='ctl02_Organizer-files']/div/h4", "");
		Thread.sleep(2000);
		selenium.clickAt("//div[@id='ctl02_Organizer_FilesTree-i--watermarks']/div[3]/a/span", "");
		Thread.sleep(2000);
		selenium.click("id=ctl04_Grid_i1_menu");
		selenium.click("//a[@id='listContextDelete']/span[2]");
		selenium.click("id=msgbox1_b0");
		Thread.sleep(4000);
		
		//Logout
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Watermark.jpg", "");
			throw ex;
		}
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

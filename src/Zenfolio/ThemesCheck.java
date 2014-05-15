package Zenfolio;

import java.lang.Number;
import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThemesCheck extends SeleneseTestCase {
protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testThemesCheck() throws Exception {
		int p = 0;
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
		selenium.click("link=My Home Page");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Customize Visitor View");
		selenium.waitForPageToLoad("30000");
				
		Number n = selenium.getXpathCount("//div[contains(@id, 'ThemeEdit-list')]/div[contains(@class, 'item-outer')]/div[contains(@id, 'ThemeEdit')]");
				
		for (int element = 0; element <= (n.intValue() + 2); element++) {
			p = element;
			selenium.click("link=Page Theme");
			//Log.print("element "+element);
					
			String themeEditLink = "//div[contains(@id, 'ThemeEdit-list')]/div[contains(@class, 'item-outer')][" + element + "]/div[contains(@id, 'ThemeEdit')]";
			
			if (selenium.isElementPresent(themeEditLink)){
				selenium.click(themeEditLink); 
			Thread.sleep(1000);
			selenium.clickAt("id=ctl02_ThemeEdit_Dialog_b0", "");
			Thread.sleep(1000);
			for (int second = 0;; second++) {
				if (second >= 60) throw new Exception();
				try { if ("denismtest".equals(selenium.getText("//div[@id='ctl04_Main']/div/div/h1/span"))) break; } catch (Exception e) {}
				Thread.sleep(1000);
				}
			Thread.sleep(2000);
			selenium.click("id=ctl04_ctl04_RootBin_Grid_i1-img");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(1000);
			selenium.click("//div[@id='ctl04_ControlBox_Share-state']/div[3]/div");
			Thread.sleep(2000);
			selenium.click("id=ctl04_PhotoGrid_i1-img");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(1000);
			selenium.click("//div[@id='ctl04_ControlBox_Share-state']/div[3]/div");
			Thread.sleep(2000);
			selenium.click("link=denismtest");
			selenium.waitForPageToLoad("30000");
			Thread.sleep(3000);		
							
			}
							
		}
		
		// Load Standard theme
		
		selenium.click("link=Page Theme");
		selenium.click("css=img.standard");
		selenium.clickAt("id=ctl02_ThemeEdit_Dialog_b0", "");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("denismtest".equals(selenium.getText("//div[@id='ctl04_Main']/div/div/h1/span"))) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		
		// Logout
		
		selenium.click("id=ctl02_Done");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.header-logo2");
		selenium.waitForPageToLoad("30000");
	}
	
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\ThemeCheck.jpg", "");
			Log.print("Theme Check error on "+ p +" div");
			throw ex;
		}
	}
	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

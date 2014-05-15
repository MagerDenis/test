package Zenfolio;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Add_Delete_Featured extends SeleneseTestCase {

	protected TestUtils utils;
	
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, ALL_Paid_users.BROWSER, ALL_Paid_users.SITE_URL);
		selenium.start();
		// create TestUtils object
		utils = new TestUtils(selenium);
	}

	@Test
	public void testAdd_Delete_Featured() throws Exception {
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
		
		//Select Featured
		selenium.clickAt("id=NewFeatures_Dialog_b0", "");
		selenium.clickAt("//div[@id='ctl02_Organizer_PhotoTree-i--featured']/div[3]/a/span", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("//a[@id='contAdd']/span[2]", "");
		Thread.sleep(1000);
		selenium.doubleClickAt("//div[contains(@id, 'ctl03_Organizer_SelectGallery_Dialog_Tree-i')]//a/span[contains(text(),'test')]", "");
		
		selenium.click("css=#ctl03_Organizer_SelectGallery_Dialog_b0 > span.btn-confirm");
		Thread.sleep(2000);
		
		//Featured must be EMPTY!
		
		//Check it added
		utils.CheckElement("css=#ctl04_Grid_i1 > div.pv-outer > a.pv-inner > div.pv-iborder", "Add Delete Featured fail");
		selenium.click("link=My Home Page");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(5000);
		
		//Check on home page
		utils.CheckText("test", "//div[contains(@id, 'FeaturedBin_Grid')]/div/div/h4", "Add Delete Featured fail");
		selenium.click("link=Back to Edit View");
		selenium.waitForPageToLoad("30000");
		
		//Remove from featured
		selenium.clickAt("id=NewFeatures_Dialog_b0", "");
		selenium.clickAt("//div[@id='ctl02_Organizer_PhotoTree-i--featured']/div[3]/a/span", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("css=#ctl04_Grid_i1 > div.pv-outer > a.pv-inner > div.pv-iborder", "");
		selenium.clickAt("//a[@id='itemRemove']/span[2]", "");
		Thread.sleep(2000);
		selenium.click("link=My Home Page");
		selenium.waitForPageToLoad("30000");
	
		//Check Home page
		utils.CheckNotElement("//div[@id='ctl02_ctl04_FeaturedBin_Grid_i1']/div/div[2]/h4", "Add Delete Featured fail");
		
		//Logout
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.header-logo2");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\Add_Delete_Featured.jpg", "");
			throw ex;
		}
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}

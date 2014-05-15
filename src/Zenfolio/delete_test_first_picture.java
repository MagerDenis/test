package Zenfolio;

import com.thoughtworks.selenium.*;

public class delete_test_first_picture extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp(ALL_Paid_users.SITE_URL, ALL_Paid_users.BROWSER);
	}
	public void testDelete_test_first_picture() throws Exception {
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
		//selenium.clickAt("css=#ctl02_Organizer_Tree-i-gal377958849 > div.tree-item > a > span", "");
		selenium.clickAt("//div[2]/a/span", "");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		selenium.click("id=ctl03_Grid_i1_menu");
		selenium.click("//a[@id='listContextOpen']/span[2]");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		selenium.click("id=ctl03_Grid_i1_menu");
		selenium.click("//a[@id='listContextDelete']/span[2]");
		Thread.sleep(1000);
		selenium.click("id=msgbox1_b0");
		Thread.sleep(1000);
		//selenium.click("id=ctl03_Grid_i1_menu");
		//selenium.click("//a[@id='listContextDelete']/span[2]");
		//selenium.click("id=msgbox2_b0");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\DeleteFirstPicture.jpg", "");
			throw ex;
		}
	}
}

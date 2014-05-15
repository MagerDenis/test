package Zenfolio;

import com.thoughtworks.selenium.*;

public class upload_photo extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp(ALL_Paid_users.SITE_URL, ALL_Paid_users.BROWSER);
	}
	public void testUpload_photo() throws Exception {
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
		//Thread.sleep(300000);
		//selenium.clickAt("css=#ctl02_Organizer_Tree-i-gal377958849 > div.tree-item > a > span", "");
		selenium.clickAt("css=a.ae-ql-upload > span", "");
		selenium.waitForPageToLoad("30000");
		//selenium.click("id=ctl03_Grid_i1_menu");
		selenium.click("id=galleryOld");
		//selenium.click("//a[@id='listContextOpen']/span[2]");
		selenium.click("id=ctl03_ctl00");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		//selenium.click("//a[@id='photoUpload']/span[2]");
		selenium.doubleClickAt("//div[2]/div/div[3]/a/span", "");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=hidden-files", "C:\\ForUpload\\DSC_8225.jpg");
		Thread.sleep(1000);
		selenium.click("id=ctl03_Start");
		Thread.sleep(2000);
		selenium.clickAt("//a[contains(text(),'Upload Duplicates')]","");
		selenium.waitForPageToLoad("300000");
		Thread.sleep(3000);
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\UploadPhoto.jpg", "");
			throw ex;
		}
	}
}

package Zenfolio;

import com.thoughtworks.selenium.*;

public class create_price_list1 extends SeleneseTestCase {
	public void setUp() throws Exception {
		setUp(ALL_Paid_users.SITE_URL, ALL_Paid_users.BROWSER);
	}
	public void testCreate_price_list1() throws Exception {
		try
		{
		selenium.windowMaximize();
		String random = new RandomStr().get(10);
		selenium.open("/");
		// Clear cookies
		selenium.deleteAllVisibleCookies();
		selenium.click("css=span.sh-z > a");
		selenium.type("id=ctl00_SiteHeader_Login-username", "denism@zenfolio.com");
		selenium.type("id=ctl00_SiteHeader_Login-password", "qwerty");
		selenium.click("link=Login");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Selling");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Price Lists");
		selenium.waitForPageToLoad("30000");
		selenium.click("//a[@id='addNew']/span[2]");
		selenium.waitForPageToLoad("30000");
		selenium.type("id=__Page-title-edit", random);
		selenium.fireEvent("id=__Page-title-edit", "blur");
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@class,'ple-products-buttons')]/a", "");
		selenium.fireEvent("//div[contains(@class,'ple-products-buttons')]/a", "blur");
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@class,'pc-frame')]//a[contains(@class,'pc-hdr-close')]", "");
		selenium.fireEvent("//div[contains(@class,'pc-frame')]//a[contains(@class,'pc-hdr-close')]", "blur");
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@class,'ple-products-buttons')]/a", "");
		selenium.fireEvent("//div[contains(@class,'ple-products-buttons')]/a", "blur");
		Thread.sleep(1000);
		//selenium.clickAt("//div[contains(@id,'_TopMenu')]//a[contains(@id,'addNew')]", "");
		Thread.sleep(5000);
		selenium.clickAt("//div[2]/div/div[2]/div/div/div/div[3]/div/div[2]", "");
		selenium.fireEvent("//div[2]/div/div[2]/div/div/div/div[3]/div/div[2]", "blur");
		Thread.sleep(1000);
		selenium.clickAt("//div[contains(@id,'_TableView')]//div[contains(@class,'pc-pb-products-section')]//div[contains(@data,'mpixpro_4x5')]//input", "");
		Thread.sleep(3000);
		
		
		String xpAddSelectedProducts = "//div[contains(@id, '_AddToCart')]//div[contains(@class, 'pc-frame pc-bgcolor1 pc-border1 pc-font1 pc-color1')]//div[contains(@class, 'pc-body')]//div[contains(@id,'-footer')]/a[contains(text(),'Add Selected Products')]"; 
		
		selenium.fireEvent(xpAddSelectedProducts, "blur");
		
	    //selenium.click("link=Add Selected Products");
		//div[2]/div/div[5]/a"  //a[contains(text(),'Add Selected Products')]  //div[@id='zfdp219_ctl00_ctl00-footer']/a
		
		//"div[contains(@id, '_AddToCart') and contains(@style, 'display: block')]/descendant:a[contains(text(), 'Add Selected Products')]"
		
		//selenium.selectWindow("name=Select Product");
		
	     //   selenium.selectWindow(_AddToCart);
	       
		
		

		verifyTrue(selenium.isElementPresent(xpAddSelectedProducts));
		
		selenium.clickAt(xpAddSelectedProducts,"");
		
		selenium.fireEvent(xpAddSelectedProducts, "blur");
		
		Thread.sleep(3000);
	    verifyTrue(selenium.isTextPresent("Small Format Prints by MpixPro Lab"));
		selenium.click("id=ctl03_SaveTop");
		Thread.sleep(3000);
		selenium.clickAt("//div[2]/input", "");
		//selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		selenium.clickAt("css=#ctl03_SaveBottom > span.btn-confirm", "");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		selenium.clickAt("id=ctl03_SaveBottom", "");
		Thread.sleep(3000);
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("id=ctl03_SaveTop", "");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.clickAt("//a/span[contains(text(),'price')]", "");
		Thread.sleep(1000);
		//selenium.clickAt("//div[@id='ctl03_ctl01']/div[2]/div[2]/div/input", "");
		selenium.clickAt("id=ctl03_SaveBottom", "");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		//selenium.clickAt("css=#ctl03_SaveBottom > span.btn-confirm", "");
		//Thread.sleep(3000);
		//selenium.waitForPageToLoad("30000");
		//Thread.sleep(3000);
		selenium.clickAt("link=Products, Prices, and Currencies", "");
		//selenium.clickAt("//div[2]/div/div[3]/a/span", "");
		Thread.sleep(3000);
		selenium.clickAt("css=#ctl03_SaveBottom > span.btn-confirm", "");
		selenium.waitForPageToLoad("30000");
		//Thread.sleep(3000);
		selenium.click("link=Products, Prices, and Currencies");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		selenium.clickAt("//span[@onclick=\"zf_edit._toggleGroup('prints','mpixpro:group-small-prints');\"]", "");
		Thread.sleep(10000);
		selenium.click("id=ctl03_SaveBottom");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=« Back to all Price Lists");
		selenium.waitForPageToLoad("30000");
		verifyTrue(selenium.isTextPresent(random));
		//Thread.sleep(3000);
		selenium.click("//div[@id='ctl02-middle']/table/tbody/tr/td/div/a");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(10000);
		selenium.click("id=__Page-title-edit-icon");
		selenium.type("id=__Page-title-edit", random+"111");
		selenium.fireEvent("id=__Page-title-edit", "blur");
		Thread.sleep(1000);
		selenium.clickAt("id=ctl03_SaveTop","");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		verifyTrue(selenium.isTextPresent(random+"111"));
		selenium.click("link=Duplicate");
		Thread.sleep(3000);
		selenium.click("id=ctl03_SaveTop");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(3000);
		verifyTrue(selenium.isTextPresent(random+"111 - Copy"));
		selenium.clickAt("//div[@id='ctl02-middle']/table/tbody/tr/td[4]/div/a[2]","");
		selenium.click("css=#msgbox1_b0 > span.btn-confirm");
		Thread.sleep(3000);
		selenium.clickAt("//div[@id='ctl02-middle']/table/tbody/tr/td[4]/div/a[2]","");
		Thread.sleep(1000);
		selenium.clickAt("link=Yes","");
		Thread.sleep(3000);
		verifyFalse(selenium.isTextPresent(random));
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
		
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\price.jpg", "");
			throw ex;
		}
		
	}
}

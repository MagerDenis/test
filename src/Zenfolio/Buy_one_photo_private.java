package Zenfolio;

import com.thoughtworks.selenium.*;

public class Buy_one_photo_private extends SeleneseTestCase {
	protected TestUtils utils;
	public void setUp() throws Exception {
		setUp(ALL_Paid_users.SITE_URL_private, ALL_Paid_users.BROWSER);
		// create TestUtils object
		utils = new TestUtils(selenium);
	}
	public void testBuy_one_photo_private() throws Exception {
		try
		{
		selenium.windowMaximize();
		selenium.open("/");
		selenium.deleteAllVisibleCookies();
		selenium.click("id=ctl02_ctl04_RootBin_Grid_i1-img");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=ctl02_PhotoGrid_i1-img")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("id=ctl02_PhotoGrid_i2-img");
		selenium.waitForPageToLoad("30000");
		Thread.sleep(1000);
		selenium.click("css=div.icon");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[2]/div/div[2]/div/div/div/div[3]/div/div[2]")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		Thread.sleep(5000);
		//selenium.clickAt("div[2]/div/div/div/div[3]/div/div[2]", "");
		selenium.clickAt("//div[4]/div[2]/div/div/div/div/div/div[2]/div", "");
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("link=Add to Cart")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.clickAt("link=Add to Cart", "");
		Thread.sleep(2000);
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[14]/div[2]/a")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("//div[contains(@class, 'pc-ac-rbar')]//a[contains(text(),'Checkout Now')]");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=user", "denism@zenfolio.com");
		selenium.type("name=password", "qwerty");
		selenium.click("css=#ctl02_ctl01_LoginSubmit-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=name");
		selenium.type("name=name", "dsfgdf");
		selenium.type("name=street1", "sdfgd");
		selenium.type("name=street2", "dfg");
		selenium.type("name=city", "dfg");
		selenium.type("name=state", "ca");
		selenium.type("name=zip", "94040");
		selenium.click("css=#ctl02_ctl01_Form_ctl15-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=#ctl02_ctl01_ctl04-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("name=paymentMethod");
		selenium.clickAt("css=#ctl02_ctl01_Form_ctl11-state > div.middle > div.label.button-font2", "");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("css=#ctl02_ctl01_PlaceOrders-state > div.middle > div.label.button-font2", "");
		selenium.waitForPageToLoad("30000");
		utils.CheckText("Order Total", "//div[contains(@class,'co-ob-lineitems co-font')]//div[contains(@class,'co-ob-lineitem co-ob-total')]//div[contains(@class,'co-ob-pricelabel')]", "Buy_one_photo_private fail");
		//verifyTrue(selenium.isTextPresent("Receipt"));
		selenium.click("css=#ctl02_ctl01_Continue-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=a.header-logo");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Logout");
		selenium.waitForPageToLoad("30000");
	
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\BuyPhotoBalance.jpg", "");
			throw ex;
		}
		}

	}


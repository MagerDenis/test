package Zenfolio;

import com.thoughtworks.selenium.*;

public class Buy_one_photo extends SeleneseTestCase {
	
	protected TestUtils utils;
	public void setUp() throws Exception {
		setUp(ALL_Paid_users.SITE_URL_private, ALL_Paid_users.BROWSER);
		// create TestUtils object
		utils = new TestUtils(selenium);
	}
	public void testBuy_one_photo() throws Exception {
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
			//try { if (selenium.isElementPresent("//div[4]/div[2]/div/div/div/div/div/div[2]/div")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		//Thread.sleep(5000);
		//selenium.clickAt("//div[2]/div/strong", "");
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

		selenium.clickAt("//div[contains(@class, 'pc-ac-rbar')]//a[contains(text(),'Checkout Now')]","");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.clickAt("css=#ctl02_ctl01_ctl08-state > div.middle > div.label.button-font2", "");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=name", "denis");
		selenium.type("name=street1", "aaa111");
		selenium.type("name=city", "bbb222");
		selenium.type("name=state", "ca");
		selenium.type("name=zip", "94040");
		selenium.type("name=email", "denism@zenfolio.com");
		selenium.type("name=email2", "denism@zenfolio.com");
		selenium.click("css=#ctl02_ctl01_Form_ctl15-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=#ctl02_ctl01_ctl04-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=cardNumber", "4111111111111111");
		selenium.select("name=cardMonth", "label=02 - February");
		selenium.select("name=cardYear", "label=2016");
		selenium.type("name=cvv", "123");
		selenium.type("name=name", "denis");
		selenium.type("name=phone", "6503643423");
		selenium.type("name=street1", "aaa111");
		selenium.type("name=street2", "ddd222");
		selenium.type("name=city", "qqq222");
		selenium.type("name=state", "ca");
		selenium.type("name=zip", "94040");
		selenium.click("css=#ctl02_ctl01_Form_ctl11-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=#ctl02_ctl01_PlaceOrders-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		utils.CheckText("Order Total", "//div[contains(@class,'co-ob-lineitems co-font')]//div[contains(@class,'co-ob-lineitem co-ob-total')]//div[contains(@class,'co-ob-pricelabel')]", "Buy_one_photo fail");
		selenium.click("css=#ctl02_ctl01_Continue-state > div.middle > div.label.button-font2");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Home");
		selenium.waitForPageToLoad("30000");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if ("Zenfolio | denismtest".equals(selenium.getTitle())) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}
		}
		catch(Exception ex)
		{
			selenium.captureEntirePageScreenshot("c:\\temp\\BuyPhoto.jpg", "");
			throw ex;
		}
		
	}
}

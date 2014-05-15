package Zenfolio;

public class TestUtils {
	
	protected com.thoughtworks.selenium.Selenium selenium;
	
	public TestUtils(com.thoughtworks.selenium.Selenium s)
	{
		selenium = s;
	}
	
	public void CheckText(String Text, String URL, String FailText) throws Exception
	{
	 if (Text.equals(selenium.getText(URL)))
	 {} else
		{
		Log.print(FailText);
		throw new Exception();
		};
	}
	
	public void CheckNotText(String Text, String URL, String FailText) throws Exception
	{
	 if (Text.equals(selenium.getText(URL)))
	 {Log.print(FailText);
		throw new Exception();} else {
		};
	}
	
	public void CheckElement(String URL, String FailText) throws Exception
	{
	 if (selenium.isElementPresent(URL))
	 {} else
		{
		Log.print(FailText);
		throw new Exception();
		};
	}
	
	public void CheckNotElement(String URL, String FailText) throws Exception
	{
	 if (selenium.isElementPresent(URL))
	 {Log.print(FailText);
		throw new Exception();
		} else {};
	}
	
	public void CheckValue(String Text, String URL, String FailText) throws Exception
	{
	 if (Text.equals(selenium.getValue(URL)))
	 {} else
		{
		Log.print(FailText);
		throw new Exception();
		};
	}
}
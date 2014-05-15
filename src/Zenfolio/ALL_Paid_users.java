package Zenfolio;

import junit.framework.Test;
import junit.framework.TestSuite;

public class ALL_Paid_users {

	//Setup:
	//URL's:
	//for global testing
	public static String SITE_URL = "http://www.a.zenfolio.us/";
	//for private 
	public static String SITE_URL_private = "http://denismtest.a.zenfolio.us/";
	
	//Browsers:
	//Firefox
	public static String BROWSER = "*chrome";
	//Internet Explorer
	//public static String BROWSER = "*iexplore";
	//Safari
	//public static String BROWSER = "*safari C:\\Program Files (x86)\\Safari\\safari.exe";
	
	public static Test suite() {
		
		TestSuite suite = new TestSuite("Test for Zenfolio");
		//$JUnit-BEGIN$
		
		//------------------------------------------------------
		//Creating and Upgrade users
		suite.addTestSuite(Login_Free_Trial.class);
		suite.addTestSuite(Create_paid_account_usd_FF.class);
		suite.addTestSuite(create_paid_user_EUR_FF.class);
		suite.addTestSuite(create_paid_user_GBR_FF.class);
		suite.addTestSuite(Upgrade.class);
		suite.addTestSuite(Gift_Account.class);		
		
		//------------------------------------------------------
		
		//Themes
		suite.addTestSuite(ThemesCheck.class);
				
		
		//------------------------------------------------------
		//Selling
		
		suite.addTestSuite(Buy_one_photo.class);
		suite.addTestSuite(Buy_one_photo.class);
		suite.addTestSuite(Buy_one_photo_private.class);
		suite.addTestSuite(create_price_list1.class);
		
		//Organizer---------------------------------------------
		//------------------------------------------------------
		
		//Photographs-----------
		suite.addTestSuite(Add_Delete_Featured.class);
		suite.addTestSuite(Recently_Added.class);
		//Shared favorites
		
		//All Photographs--
		suite.addTestSuite(upload_photo.class);
		suite.addTestSuite(upload_photo.class);
		suite.addTestSuite(upload_photo.class);
		suite.addTestSuite(delete_test_first_picture.class);
		suite.addTestSuite(delete_test_first_picture.class);
		suite.addTestSuite(delete_test_first_picture.class);
		
		//-----------------------------------------------------
		
		//Client Communication--------
		suite.addTestSuite(Contact_List.class);
		suite.addTestSuite(Email_Communications.class);
		suite.addTestSuite(Guestbook_Comments.class);
		
		//-----------------------------------------------------
		
		//Website Pages----------
		//Built-in Pages
		//Custom Pages
		//Blog
		
		//-----------------------------------------------------
		
		//Files & Resources---------
		suite.addTestSuite(PDF_Upload.class);
		suite.addTestSuite(Soundtracks.class);
		suite.addTestSuite(Watermark.class);
		//Custom Themes
		
		//-----------------------------------------------------
				
		//$JUnit-END$
		return suite;
	}

}

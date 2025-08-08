package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.Login;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Login login;
	public AddcustomerPage customPage;
	public SearchCustomerPage srchCstmrPage;
	
	 public static String generateRandomString() {
	        return RandomStringUtils.randomAlphabetic(5);
	    }
	 public static String email=generateRandomString()+"@gmail.com";;
			 
			
}

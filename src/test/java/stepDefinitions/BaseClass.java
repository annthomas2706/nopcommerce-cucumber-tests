package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;

import pageObjects.AddcustomerPage;
import pageObjects.Login;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Login login;
	public AddcustomerPage customPage;
	public SearchCustomerPage srchCstmrPage;
	public static Logger logger;
	
	static {
        logger = LogManager.getLogger(BaseClass.class);
    }
	
	
	 public static String generateRandomString() {
		
	        return RandomStringUtils.randomAlphabetic(5);
	        
	    }
	 public static String email=generateRandomString()+"@gmail.com";
	 
	 
			 
			
}

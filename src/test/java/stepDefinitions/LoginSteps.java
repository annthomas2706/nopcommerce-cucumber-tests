package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.Login;


public class LoginSteps extends BaseClass{
	
	@Before//cucumber hooks, runs befre evry scenario
	public void setup() {
		

		 ChromeOptions options = new ChromeOptions();
	        options.addArguments("--disable-blink-features=AutomationControlled");
	        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	        options.setExperimentalOption("useAutomationExtension", false);

	        driver = new ChromeDriver(options);

	        // Mask navigator.webdriver
	        ((JavascriptExecutor) driver).executeScript(
	            "Object.defineProperty(navigator, 'webdriver', {get: () => undefined})"
	        );
	        
	        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36");

		
	}
	

	@Given("User launches Chrome Browser")
	public void user_launches_chrome_browser() {
		

		login=new Login(driver);
    
}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
    
}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String pass) {
		
		login.setEmail(email);
		login.setPassword(pass);
    
}

	@When("User clicks the login button")
	public void user_clicks_the_login_button() throws InterruptedException {
		login.clickLogin();
		try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

   
}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.fail("Login was unsuccessful.");}
		else {
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        wait.until(ExpectedConditions.titleIs(title));
			Assert.assertEquals(driver.getTitle(), title);
			  
		}}

	@When("User clicks out Logout button")
	public void user_clicks_out_logout_button() {
		
		login.clickLogout();    
}

	@Then("Login title should be {string}")
	public void login_title_should_be(String title) {
		
		Assert.assertEquals(driver.getTitle(), title);
    
}

	@Then("Close browser")
	public void close_browser() {
		
		driver.close();
   
}


}

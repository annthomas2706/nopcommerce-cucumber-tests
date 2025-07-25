package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pageObjects.Login;


public class LoginSteps {
	
	public WebDriver driver;
	public Login login;
	
	

	@Given("User launches Chrome Browser")
	public void user_launches_chrome_browser() {
		driver=new ChromeDriver();
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
	public void user_clicks_the_login_button() {
		login.clickLogin();
   
}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) {
		
		if(driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.fail("Login was unsuccessful.");}
		else {
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

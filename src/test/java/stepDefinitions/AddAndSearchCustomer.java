package stepDefinitions;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pageObjects.AddcustomerPage;
import pageObjects.SearchCustomerPage;

public class AddAndSearchCustomer extends BaseClass{

	@When("User click on customer menu")
	public void user_click_on_customer_menu() throws InterruptedException {
		customPage=new AddcustomerPage(driver);
		Thread.sleep(3000);
		customPage.clickOnCustomersMenu();
	   
	}

	@When("clicks on Customer Menu Item")
	public void clicks_on_customer_menu_item() throws InterruptedException {
		customPage.clickOnCustomersItem();
		Thread.sleep(3000);

	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		customPage.clickOnAddNew();
		Thread.sleep(3000);
	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
		
		Assert.assertEquals(driver.getTitle(), "Add a new customer / nopCommerce administration");
		Thread.sleep(1000);
	    
	}

	@When("User enters customer Info")
	public void user_enters_customer_info() throws InterruptedException {
		//email=generateRandomString()+"@gmail.com";
		customPage.setEmail(email);
		Thread.sleep(1000);
		
		customPage.setPassword("test123");
		Thread.sleep(1000);
		
		customPage.setFirstName("Ann");
		Thread.sleep(1000);
		
		customPage.setLastName("Thomas");
		Thread.sleep(1000);
		

		customPage.setGender("Female");
		Thread.sleep(1000);
		
		
		customPage.setCompanyName("ABC");
		Thread.sleep(1000);
		
		customPage.setAdminComment("Admin 123");
		Thread.sleep(1000);
		
		
	   
	}

	@When("click on save button")
	public void click_on_save_button() {
		customPage.clickOnSave();
	    
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	   
	}
	
	
	//search customer by email
	
	@When("Enter Customer Email")
	public void enter_customer_email() {
		srchCstmrPage=new SearchCustomerPage(driver);
		srchCstmrPage.setEmail(email);
	}
	@When("click on Search button")
	public void click_on_search_button() throws InterruptedException {
		srchCstmrPage.clickOnSearch();
		Thread.sleep(5000);
	}
	@Then("User should found email on search table")
	public void user_should_found_email_on_search_table() {
		boolean status=srchCstmrPage.searchCustomerByEmail(email);
		Assert.assertEquals(true, status);
	}






		

}

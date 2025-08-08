package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
	WebDriver driver;
	//Initializing the Page Objects:
			public AddcustomerPage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver, this);
			}
			
			
			//li[@class='nav-item has-treeview menu-is-opening menu-open']/a
			
			@FindBy(xpath="//a[@class='nav-link']/i[@class='nav-icon far fa-user']")
			WebElement customersLink;
			
			@FindBy(xpath="//a[@href='/Admin/Customer/List']")
			WebElement customersItem;
			
			@FindBy(xpath="//a[@class='btn btn-primary']")
			WebElement addNewButton;
			
			
			
			@FindBy(id="Email")
			WebElement email;
			
			@FindBy(id="Password")
			WebElement password;
			
			
			@FindBy(name="FirstName")
			WebElement firstName;
			
			@FindBy(name="LastName")
			WebElement lastName ;

			
			@FindBy(xpath="//input[@id='Gender_Male']")
			WebElement mGender;
			
			@FindBy(xpath="//input[@id='Gender_Female']")
			WebElement fGender;
			
			@FindBy(id="Company")
			WebElement companyName;
			
			@FindBy(id="IsTaxExempt")
			WebElement taxExempt;
			
			@FindBy(xpath="//input[@aria-controls='select2-SelectedNewsletterSubscriptionStoreIds-results']")
			WebElement newLetterField;
			
			@FindBy(xpath="//li[@role='option' and text()='Forum Moderators']")
			WebElement roleForum;
			
			@FindBy(xpath="//li[@role='option' and text()='Registered']")
			WebElement roleRegistered;
			
			@FindBy(xpath="//li[@role='option' and text()='Guests']")
			WebElement roleGuests;
			
			@FindBy(xpath="//li[@role='option' and text()='Vendors']")
			WebElement roleVendors;
			
			@FindBy(xpath="//li[@role='option' and text()='Administrators']")
			WebElement roleAdmin;

			@FindBy(xpath="//select[@id='VendorId']")
			WebElement vendor;
			

			@FindBy(id="MustChangePassword")
			WebElement changePassword;
			

			@FindBy(name="AdminComment")
			WebElement adminComment;
			

			@FindBy(xpath="//button[@name='save']")
			WebElement saveButton;
			
			

			@FindBy(xpath="//button[@name='save-continue']")
			WebElement saveAndContinue;
			
			@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
			WebElement cnfrmMsg;
			
			
			
			//Action methods:
			
			public void clickOnCustomersMenu() {
		        customersLink.click();
		    }

		    public void clickOnCustomersItem() {
		        customersItem.click();
		    }

		    public void clickOnAddNew() {
		        addNewButton.click();
		    }

		    public void setEmail(String emailText) {
		        email.sendKeys(emailText);
		    }

		    public void setPassword(String pwd) {
		        password.sendKeys(pwd);
		    }

		    public void setFirstName(String fName) {
		        firstName.sendKeys(fName);
		    }

		    public void setLastName(String lName) {
		        lastName.sendKeys(lName);
		    }

		    public void setGender(String gender) {
		        if (gender.equalsIgnoreCase("Male")) {
		            mGender.click();
		        } else if (gender.equalsIgnoreCase("Female")) {
		            fGender.click();
		        }
		    }

		    public void setCompanyName(String compName) {
		        companyName.sendKeys(compName);
		    }

		    public void setIsTaxExempt(boolean flag) {
		        if (flag != taxExempt.isSelected()) {
		            taxExempt.click();
		        }
		    }

		    public void selectVendor(String vendorValue) {
		        Select select = new Select(vendor);
		        select.selectByVisibleText(vendorValue);
		    }

		    public void setAdminComment(String comment) {
		        adminComment.sendKeys(comment);
		    }

		    public void clickOnSave() {
		        saveButton.click();
		    }

		    public void clickOnSaveAndContinue() {
		        saveAndContinue.click();
		    }

		    public void clickChangePasswordCheckbox(boolean flag) {
		        if (flag != changePassword.isSelected()) {
		            changePassword.click();
		        }
		    }

		    // Newsletter and Role Selection can be enhanced using JavaScriptExecutor due to the custom dropdown
		    // Here's a placeholder for role selection logic – update as per your utility methods or script behavior
		    public void selectCustomerRole(String role) {
		        if (role.equalsIgnoreCase("Administrators")) {
		            roleAdmin.click();
		        } else if (role.equalsIgnoreCase("Guests")) {
		            roleGuests.click();
		        } else if (role.equalsIgnoreCase("Registered")) {
		            roleRegistered.click();
		        } else if (role.equalsIgnoreCase("Vendors")) {
		            roleVendors.click();
		        } else if (role.equalsIgnoreCase("Forum Moderators")) {
		            roleForum.click();
		        } else {
		            System.out.println("Invalid customer role: " + role);
		        }
		    }
		    
		    public String verifyCnfrmMsg() {
		    	String msg=cnfrmMsg.getText();
				return msg;

		        }

		}



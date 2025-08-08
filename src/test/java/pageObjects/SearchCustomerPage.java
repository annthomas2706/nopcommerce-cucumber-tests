package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	WebDriver driver;
	WaitHelper waitHelper;
	//Initializing the Page Objects:
			public SearchCustomerPage(WebDriver driver){
				this.driver=driver;
				PageFactory.initElements(driver, this);
				waitHelper=new WaitHelper(this.driver);
			}
			
			
			@FindBy(id = "SearchEmail")
			WebElement txtEmail;

			@FindBy(id = "SearchFirstName")
			WebElement txtFirstName;

			@FindBy(id = "SearchLastName")
			WebElement txtLastName;

			@FindBy(id = "SearchCompany")
			WebElement txtCompany;

			@FindBy(id = "SearchIpAddress")
			WebElement txtIpAddress;


			// Customer Roles dropdown container
			@FindBy(xpath = "//div[@class='input-group-append input-group-required']//div[@role='listbox']")
			WebElement customerRolesDropdown;
			
			@FindBy(id = "search-customers")
			WebElement btnSearch;
			
			@FindBy(xpath = "//table[@id='customers-grid']")
			WebElement customerTable;
			
			@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr")
			List<WebElement> tableRows;
			
			@FindBy(xpath = "//table[@id='customers-grid']//tbody/tr/td")
			List<WebElement> tableColumns;
			
			
			//actions
			
			public void setEmail(String email) {
				waitHelper.waitForElement(txtEmail, 10);
				txtEmail.clear();
				txtEmail.sendKeys(email);
			}
			
			public void setFirstName(String fName) {
				//waitHelper.waitForElement(txtEmail, 10);
				txtFirstName.clear();
				txtFirstName.sendKeys(fName);
			}
			
			public void setLastName(String lName) {
				//waitHelper.waitForElement(txtEmail, 10);
				txtLastName.clear();
				txtLastName.sendKeys(lName);
			}

			
			public void clickOnSearch() {
				btnSearch.click();
				waitHelper.waitForElement(txtEmail, 5);
				
			}
			
			public int getNoOfRows() {
				return tableRows.size();
			}
			
			public int getNoOfColumns() {
				return tableColumns.size();
			}
			
			
			public boolean searchCustomerByEmail(String email) {
				boolean flag=false;
				
				for(int i=1;i<=getNoOfRows();i++) {
					
					String emailId=customerTable.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
					System.out.println("Email is "+emailId);
					
					if(emailId.equals(email)) {
						flag=true;
					}
					
				}
				return flag;
			}


}

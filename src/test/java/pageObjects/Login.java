package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	public WebDriver driver;
	
	@FindBy(name="Email")
	WebElement email;
	
	@FindBy(name="Password")
	WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logOut;
	
	
	//Initializing the Page Objects:
		public Login(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public void setEmail(String Address){
			email.clear();
			email.sendKeys(Address);
		
		}

	
		public void setPassword(String pass) {
			password.clear();
			password.sendKeys(pass);
		}

		public void clickLogin(){
			submitButton.click();
		}
		
		public void clickLogout(){
			logOut.click();
		}
		

}

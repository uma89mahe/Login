package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.BaseClass;

public class LoginObjects extends BaseClass{
	
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(id="txtPassword")
	private WebElement password;
	
	@FindBy(id="btnLogin")
	private WebElement login;
	
	@FindBy(id="welcome")
	private WebElement welcome;
	
	public LoginObjects() {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void setCredentials() {
		
		//String uname = readExcel(2,1);
		username.sendKeys("Admin");
		password.sendKeys("admin123");
	}

	public void clickLogin() {
		login.click();
	}	
	
	public String validate() {
		return welcome.getText();
	}
	
	
}

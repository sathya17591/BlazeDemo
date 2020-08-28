package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(id="captcha")
	WebElement captcha;
	
	@FindBy(id="captchaRefresh")
	WebElement captchaRefresh;
	
	@FindBy(xpath="//*[text()='LOG IN']")
	WebElement loginBtn;
	
	// initialize the web elements of LoginPage
	public LoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Get Page Title
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	// Login with username password
	public HomePage login(String uname,String pwd) throws IOException {
		username.sendKeys(uname);
		password.sendKeys(pwd);
	//	captcha.sendKeys("Captcha value");
		loginBtn.click();
		return new HomePage();
	}
	
	
}

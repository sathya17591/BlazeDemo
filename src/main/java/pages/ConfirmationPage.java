package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class ConfirmationPage extends BaseClass {
	
	@FindBy(xpath="//td[text()='Id']//following-sibling::td")
	WebElement Idval;
	
	@FindBy(xpath="//td[text()='Status']//following-sibling::td")
	WebElement Statusval;
	
	@FindBy(xpath="//td[text()='Amount']//following-sibling::td")
	WebElement amountval;
	
	@FindBy(xpath="//td[text()='Card Number']//following-sibling::td")
	WebElement cardnumval;
	
	@FindBy(xpath="//td[text()='Expiration']//following-sibling::td")
	WebElement expirationval;
	
	@FindBy(xpath="//td[text()='Auth Code']//following-sibling::td")
	WebElement authcodeval;
	
	@FindBy(xpath="//td[text()='Date']//following-sibling::td")
	WebElement dateval;
	
	// initialize the web elements of LoginPage
	public ConfirmationPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Get Page Title
	public String validateConfirmationPageTitle() {
		return driver.getTitle();
	}
	
	public String validateConfirmationPageHeader() {
		return driver.findElement(By.xpath("//h1")).getText();
	}
	
	public String verifyStatus() {
		return Statusval.getText();
	}
	
	public String getBookingId() {
		return Idval.getText();
	}
}

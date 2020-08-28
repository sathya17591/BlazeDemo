package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath="//h2//following-sibling::p[1]")
	WebElement airline;
	
	@FindBy(xpath="//h2//following-sibling::p[2]")
	WebElement flightNumber;
	
	@FindBy(xpath="//h2//following-sibling::p[3]")
	WebElement price;
	
	@FindBy(xpath="//h2//following-sibling::p[4]")
	WebElement arbitraryfees;
	
	@FindBy(xpath="//h2//following-sibling::p[5]")
	WebElement totalCost;
	
	@FindBy(id="inputName")
	WebElement nametxt;
	
	@FindBy(id="address")
	WebElement addresstxt;
	
	@FindBy(id="city")
	WebElement citytxt;
	
	@FindBy(id="state")
	WebElement statetxt;
	
	@FindBy(id="zipCode")
	WebElement zipCodetxt;
	
	@FindBy(id="cardType")
	WebElement cardTypedd;
	
	@FindBy(id="creditCardNumber")
	WebElement creditCardNumbertxt;
	
	@FindBy(id="creditCardMonth")
	WebElement creditCardMonthtxt;
	
	@FindBy(id="creditCardYear")
	WebElement creditCardYeartxt;
	
	@FindBy(id="nameOnCard")
	WebElement nameOnCardtxt;
	
	@FindBy(xpath="//input[@value='Purchase Flight']")
	WebElement purchaseFlightbtn;
	
	@FindBy(id="rememberMe")
	WebElement rememberMechkbox;
	
	
	public PaymentPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Get Page Title
	public String validatePaymentPageTitle() {
		return driver.getTitle();
	}
	
		
	public void chooseCardType(String cardType)
	{
		Select dd= new Select(cardTypedd);
		dd.selectByValue(cardType);
	}
	
	//Make payment
	public ConfirmationPage makePayment(String name,String address,String city,String state,String zipcode,String cardType,String cardNumber,
							String month,String year,String nameOnCard) throws IOException {
		nametxt.sendKeys(name);
		addresstxt.sendKeys(address);
		citytxt.sendKeys(city);
		statetxt.sendKeys(state);
		zipCodetxt.sendKeys(zipcode);
		chooseCardType(cardType);
		creditCardNumbertxt.sendKeys(cardNumber);
		creditCardMonthtxt.sendKeys(month);
		creditCardYeartxt.sendKeys(year);
		nameOnCardtxt.sendKeys(nameOnCard);
		rememberMechkbox.click();
		purchaseFlightbtn.click();
		return new ConfirmationPage();
	}
	
	//verigy page Header
	public void verifyPaymentPageHeader() {
		String pageHeader = driver.findElement(By.xpath("//h2")).getText();
		String expectedHeader = "Your flight from TLV to SFO has been reserved.";
		Assert.assertEquals(pageHeader, expectedHeader);
	}
	
	
	
}

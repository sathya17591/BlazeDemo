package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class FlightsReservePage extends BaseClass {
	
	// initialize the web elements of LoginPage
	public FlightsReservePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	// Get Page Title
	public String validateReservePageTitle() {
		return driver.getTitle();
	}
	
	//verify desired flight is available for booking
	public boolean verifyDesiredFlightAvailability(String flightnum) {
		return driver.findElement(By.xpath("//td[text()='"+flightnum+"']")).isDisplayed();
	}
	
	public PaymentPage clickDesiredFlight(String flightnum) throws IOException {
		driver.findElement(By.xpath("//td[text()='"+flightnum+"']//preceding-sibling::td//input")).click();
		return new PaymentPage();
	}
	
	
}

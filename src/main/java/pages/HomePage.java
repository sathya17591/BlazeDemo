package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	@FindBy(name="fromPort")
	WebElement departureCity;
	
	@FindBy(name="toPort")
	WebElement destinationCity;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement findFlights;
	
	// initialize the web elements of LoginPage
	public HomePage() throws IOException{
		PageFactory.initElements(driver, this);
	}
	
	// Get Page Title
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	//choose fromPort
	public void chooseDepartureCity(String depCity)
	{
		Select dd= new Select(departureCity);
		dd.selectByValue(depCity);
	}
	
	//choose toPort
		public void chooseDestinationCity(String destCity)
		{
			Select dd= new Select(destinationCity);
			dd.selectByValue(destCity);
		}
		
		//click find flights button
		public FlightsReservePage clickFindFlights() throws IOException
		{
			findFlights.click();
			return new FlightsReservePage();
		}
		
		
}

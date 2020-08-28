package testScripts;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ConfirmationPage;
import pages.FlightsReservePage;
import utilities.ExcelUtility;

public class FlightsBooking extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	PaymentPage paymentpage;
	ConfirmationPage confirmationpage;
	FlightsReservePage flightsreservepage;
	ExcelUtility excel;
	String bookingId;
	String bookingStatus;
	
	
	public FlightsBooking() throws IOException {
		super();
	}
	
      @BeforeClass
	  public void beforeMethod() throws IOException {	
	  launchBrowser();
	  homepage=new HomePage();
	  excel=new ExcelUtility("src/test/resources/testdata/Data.xlsx");
	  }
	
	  @AfterClass
	    public void afterMethod() {
//		driver.quit();
	   }
	
	  @Test(priority=0)
	  public void verifyLoginPageTitle() {
		  String actualtitle=homepage.validateHomePageTitle();
		  String expectedTitle="BlazeDemo";
		  Assert.assertEquals (actualtitle,expectedTitle);	    
	  }
	  
	  
	  @Test(priority=1)
	  public void searchFlights() throws IOException, InterruptedException {
		  
		  String depCity=excel.getData("Sheet1",1,0);		  
		  String destCity=excel.getData("Sheet1",1,1);
		  String desiredFlightNum=excel.getData("Sheet1",1,2);
		  
		  homepage.chooseDepartureCity(depCity);
		  homepage.chooseDestinationCity(destCity);
		  flightsreservepage=homepage.clickFindFlights();
		  boolean flightavailable=flightsreservepage.verifyDesiredFlightAvailability(desiredFlightNum);
		  if (flightavailable)
		  {
			  paymentpage=flightsreservepage.clickDesiredFlight(desiredFlightNum);
		  }
		  	    
	  }

	  @Test(priority=2)
	  public void bookFlight() throws IOException, InterruptedException {
//		  excel=new ExcelUtility("src/test/resources/testdata/Data.xlsx");
		  String name=excel.getData("Sheet1",1,3);		  
		  String address=excel.getData("Sheet1",1,4);
		  String city=excel.getData("Sheet1",1,5);
		  String state=excel.getData("Sheet1",1,6);
		  String zipcode=excel.getData("Sheet1",1,7);
		  String cardType=excel.getData("Sheet1",1,8);
		  String cardNumber=excel.getData("Sheet1",1,9);
		  String month=excel.getData("Sheet1",1,10);
		  String year=excel.getData("Sheet1",1,11);
		  String nameOnCard=excel.getData("Sheet1",1,12);		  
		  Assert.assertEquals(paymentpage.validatePaymentPageTitle(),"BlazeDemo Purchase");
		  confirmationpage=paymentpage.makePayment(name, address, city, state, zipcode, cardType, cardNumber, month, year, nameOnCard);
	  }

	  @Test(priority=3)
	  public void verifyBookingConfirmation() throws IOException, InterruptedException {
		  bookingId= confirmationpage.getBookingId();
		  bookingStatus=confirmationpage.verifyStatus();
		  Assert.assertEquals(confirmationpage.validateConfirmationPageTitle(),"BlazeDemo Confirmation");
		  Assert.assertEquals(confirmationpage.validateConfirmationPageHeader(),"Thank you for your purchase today!");
		  System.out.println("Booking ID is: "+bookingId);
		  System.out.println("Booking Status is: "+bookingStatus);
	  }

}

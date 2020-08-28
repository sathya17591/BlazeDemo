package testScripts;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;


public class RestAPILaunches {
	
	String response;
	JsonPath js;

	@Test(priority=0)
	public void getLaunches()
	{
		RestAssured.baseURI="https://api.spacexdata.com";		
		response=given().log().all()
		.when().get("/v4/launches/latest")
		.then().log().all().assertThat().statusCode(200)
		.contentType("application/json; charset=utf-8")
		.header("Server", "cloudflare")
		.extract().response().asString();
	}
	
	@Test(priority=1)
	public void getLaunchDetails()
	{
		js= new JsonPath(response);
		String ID=js.getString("id");
		String launchpad = js.getString("launchpad");
		String details = js.getString("details");
		
		System.out.println("Id of the Launch: "+ID);
		System.out.println("LaunchPad: "+launchpad);
		System.out.println("Details of the Launch: "+details);
		
		int Cores=js.get("cores.size()");
		System.out.println("Number of cores: "+ Cores);
		for(int i =0;i<Cores;i++)
		{
			String core = js.getString("cores["+i+"].core");
			System.out.println("core: " +core);
		}
	
	}

	
	@Test(priority=-1)
	public void verifyStatusCode_negative()
	{
		RestAssured.baseURI="https://api.spacexdata.com";		
		response=given().log().all()
		.when().get("/v4/launches/latest/123")
		.then().log().all().assertThat().statusCode(404)
		.extract().response().asString();
	}
	

}

package sample;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;

public class sample extends base{

	@BeforeTest
	public void dsad() {
		getuserlist();
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("groupId","asds");
		httpRequest = RestAssured.given();
		//sample();
		//headerforListOfuser1();
		response=httpRequest.request(Method.GET);
		
	}
	
	@Test(enabled=true)
	public void TC_7_verify_whether_user__able_to_get_userinformation_with_sameUSERID_with_different_group() {
		
		String a=response.asString();
		System.out.println("Actual result is :"+a);
	}
}

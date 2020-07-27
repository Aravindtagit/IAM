package mobeixServer.userManagement_Create_User;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;

public class TC_03_Create_a_user_with_existing_userId extends base {

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createUserDetails();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.userId");
		//RestAssured.baseURI="http://172.17.2.28:8081/mobeixadmin/api/merchants/"+object;
		//httpRequest=RestAssured.given();
		//header();
		//response=httpRequest.request(Method.DELETE);
		
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", object);
		requestParams.put("userName", userId);
		requestParams.put("userType", userType);
		requestParams.put("merchantId", "1");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_03_Create_a_user_with_existing_user_Id() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("USER_ALREADY_EXIST"), true);
		logger.info("Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 400);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

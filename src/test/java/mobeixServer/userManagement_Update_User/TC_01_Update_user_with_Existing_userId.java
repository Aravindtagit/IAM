package mobeixServer.userManagement_Update_User;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;

public class TC_01_Update_user_with_Existing_userId extends base {

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		getAllUserDetails();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[1].dto.userId");
		Object version = jsonPath.get("_embedded.hateoasResourceList[0].dto.version");
		System.out.println("dsdsd"+object);
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", object);
		requestParams.put("userName", userName);
		requestParams.put("userType", userType);
		requestParams.put("merchantId", "1");
		requestParams.put("version", version);
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.PUT);
	}
	
	@Test
	public void TC_01__Update_user_with_Existing_userId() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("INTERNAL_SERVER_ERROR"), true);
		logger.info("Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 400);
		String s=String.valueOf(statusCode);  
		//test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

package mobeixServer.userManagement_Create_User;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_04_Create_user_without_userId extends base{
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userName", userId);
		requestParams.put("userType", userType);
		requestParams.put("merchantId", "1");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_04__Create_user_without_userId() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("userId length must not null"));
		//Assert.assertEquals(responseBody.contains(userId), true);
		logger.info("Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

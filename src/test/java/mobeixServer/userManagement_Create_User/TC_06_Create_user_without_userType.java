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

public class TC_06_Create_user_without_userType extends base{

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", userId);
		requestParams.put("userName", userId);
		requestParams.put("merchantId", "1");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_06__Create_user_without_userType() {
		String responseBody = response.getBody().asString();
		Assert.assertTrue(responseBody.contains("USER_TYPE_MANDATORY"));
		//Assert.assertEquals(responseBody.contains(userId), true);
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

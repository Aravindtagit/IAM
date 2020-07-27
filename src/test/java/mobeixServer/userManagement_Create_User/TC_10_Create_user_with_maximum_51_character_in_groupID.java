package mobeixServer.userManagement_Create_User;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_10_Create_user_with_maximum_51_character_in_groupID extends base {

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", userId);
		requestParams.put("userName", userId);
		requestParams.put("userType", userType);
		requestParams.put("merchantId", "1");
		requestParams.put("groupId", RandomStringUtils.randomNumeric(51));
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_10__Create_user_with_maximum_51_character_in_groupID() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("groupId length must not"), true);
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

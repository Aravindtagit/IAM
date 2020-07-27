package iam.USER_create_user;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_31__create_user_with_username_field_as_only_numeric extends base {
	String userId1 = RestUtil.userId();
	String username3 = RestUtil.username();
	String userType = RestUtil.userType();
	String pass;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createUser() throws InterruptedException {
		pass = (String) base.encrypt(userId1);
		System.out.println("Anbu :" + pass);

		createuser();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", userId1);
		requestParams.put("userName", username3);
		requestParams.put("userType", "ADMIN");
		requestParams.put("Email", "sudhakar.tangellapalli@tagitmobile.com");
		requestParams.put("merchantId", "1");
		requestParams.put("flag", "0");
		requestParams.put("version", "1");
		//requestParams.put("twoFactorStatus", "123456");
		requestParams.put("groupId", "MOBEIX");
		requestParams.put("createdBy", "ADMIN");
		requestParams.put("pswd", pass);
		header();
		Thread.sleep(1000);
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		}
		//updateProfile();

	
	
	@Test
	public void TC_31_create_user_with_username_field_as_only_numeric() {
		System.out.println("userId" + userId);
		System.out.println("userName" + userId);
		System.out.println("userType" + userType);
		// System.out.println("userId"+userId);
		String responseBody = response.getBody().asString();
		logger.info("Response Body is==> " + responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		Assert.assertEquals(responseBody.contains(username3), true);
		//Assert.assertEquals(responseBody.contains("INTERNAL_SERVER_ERROR"), true);

		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		test.log(LogStatus.INFO, "Status Code is==> "+s);
		}
		}
package iam.USER_create_user;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_24_user_able_to_create_new_withuserID_field_with_maximum_51_characters2 extends base {
	String userId2 = RestUtil.userId2();
	String username = RestUtil.userName();
	String userType = RestUtil.userType();
	//String pass;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createUser() throws InterruptedException {
		//pass = (String) base.encrypt(userId1);
		//System.out.println("Anbu :" + pass);

		createuser();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", userId2);
		requestParams.put("userName", username);
		requestParams.put("userType", "ADMIN");
		requestParams.put("Email", "sudhakar.tangellapalli@tagitmobile.com");
		requestParams.put("merchantId", "1");
		requestParams.put("flag", "0");
		requestParams.put("version", "1");
		//requestParams.put("twoFactorStatus", "123456");
		requestParams.put("groupId", "MOBEIX");
		requestParams.put("createdBy", "ADMIN");
		requestParams.put("setPasswordLater", "false");
		//requestParams.put("pswd", pass);
		header();
		Thread.sleep(1000);
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		}
		//updateProfile();

	
	
	@Test
	public void TC__24_user_able_to_create_new_withuserID_field_with_maximum_51_characters2() {
		System.out.println("userId" + userId);
		System.out.println("userName" + userId);
		System.out.println("userType" + userType);
		// System.out.println("userId"+userId);
		String responseBody = response.getBody().asString();
		logger.info("Response Body is==> " + responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		Assert.assertEquals(responseBody.contains("USER_ID_MANDATORY_WITH_50_CHAR"), true);

		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		test.log(LogStatus.INFO, "Status Code is==> "+s);
		}
		}
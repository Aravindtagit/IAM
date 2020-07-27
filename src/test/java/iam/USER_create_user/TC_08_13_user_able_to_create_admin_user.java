package iam.USER_create_user;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_08_13_user_able_to_create_admin_user extends base {
	String userId1 = RestUtil.userId();
	String username = RestUtil.userName();
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
		requestParams.put("userName", username);
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
	public void TC_08__13_user_able_to_create_admin_user() {
		System.out.println("userId" + userId);
		System.out.println("userName" + userId);
		System.out.println("userType" + userType);
		// System.out.println("userId"+userId);
		String responseBody = response.getBody().asString();
		logger.info("Response Body is==> " + responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		Assert.assertEquals(responseBody.contains(userId1), true);

		// Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 200);
		String s = String.valueOf(statusCode);
		test.log(LogStatus.INFO, "Status Code is==> "+s);
		}
		}
package iam.USER_create_user;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_51_To_verify_MPIN_field_with_invalid_MPIN extends base {
	String userId1 = RestUtil.userId();
	String username = RestUtil.userName();
	String userType = RestUtil.userType();
	String pass;
	String pin1;

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createUser() throws InterruptedException {
		pass = (String) base.encrypt(userId1);
		pin1 = (String) base.mpinencrypt2(userId1);

		System.out.println("Anbu :" + pass);
	

		System.out.println("Anbu :" + pin1);
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
		requestParams.put("securityQuesLoginAttemptCnt", "5");
		//requestParams.put("twoFactorStatus", "12345");
		requestParams.put("MPIN", pin1);


		header();
		Thread.sleep(1000);
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		}
		//updateProfile();

	
	
	@Test
	public void TC__51_To_verify_MPIN_field_with_invalid_MPIN() {
		System.out.println("userId" + userId);
		System.out.println("userName" + userId);
		System.out.println("userType" + userType);
		// System.out.println("userId"+userId);
		String responseBody = response.getBody().asString();
		logger.info("Response Body is==> " + responseBody);
		//test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//Assert.assertEquals(responseBody.contains("pin1"), true);

		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> " + statusCode);
		Assert.assertEquals(statusCode, 400);
		String s = String.valueOf(statusCode);
		//test.log(LogStatus.INFO, "Status Code is==> "+s);
		}
		}
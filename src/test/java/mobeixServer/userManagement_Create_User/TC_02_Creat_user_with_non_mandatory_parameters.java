package mobeixServer.userManagement_Create_User;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_02_Creat_user_with_non_mandatory_parameters extends base {

	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("flag", "");
		requestParams.put("status", "ACTIVE");
		requestParams.put("statusChangeDate", "2020-03-30T17:08:55+05:30");
		requestParams.put("createdDate", "2020-03-30T17:08:55+05:30");
		requestParams.put("createdBy", "Admin");
		requestParams.put("accessEndTime", "");
		requestParams.put("accessExpiryDt", "");
		requestParams.put("accessStartTime", "");
		requestParams.put("authSignLevel", "");
		requestParams.put("flexiField1", "");
		requestParams.put("flexiField2", "");
		requestParams.put("flexiField3", "");
		requestParams.put("flexiField4", "");
		requestParams.put("groupId", "MOBEIX");
		requestParams.put("lastAction", "");
		requestParams.put("lastLoginAttemptCnt", "");
		requestParams.put("passwordExpiryMessage", "");
		requestParams.put("lastLoginAttemptDt", "");
		requestParams.put("lastLoginAttemptIp", "");
		requestParams.put("lastLoginDt", "");
		requestParams.put("lastLoginIp", "");
		requestParams.put("pswdStatus", "");
		requestParams.put("pswdStatusChangeDate", "2020-03-30T17:08:55+05:30");
		requestParams.put("userMobileNo", "");
		requestParams.put("userEmail", "");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_02_Creat_user_with_non_mandatory_parameter() {
		String responseBody = response.getBody().asString();
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

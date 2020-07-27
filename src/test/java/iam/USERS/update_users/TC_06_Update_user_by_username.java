package iam.USERS.update_users;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_06_Update_user_by_username extends base {
	
	String userId1 = RestUtil.userId();
	String username = RestUtil.userName();

	Object uName;
	@BeforeClass
	public void updateUser() {
		getuserlist();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath();
		JSONObject requestParams = new JSONObject();
		Object uID = jsonPath.get("[3].userId");
		uName = jsonPath.get("[3].userName");
		Object uType = jsonPath.get("[3].userType");
		Object eMa = jsonPath.get("[3].Email");
		Object merId = jsonPath.get("[3].merchantId");
		Object ver = jsonPath.get("[3].version");
		Object fl = jsonPath.get("[3].flag");
		Object creBy = jsonPath.get("[3].createdBy");
		
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", uID);
		requestParams1.put("userName", userName);
		requestParams1.put("userType", uType);
		requestParams1.put("Email", eMa);
		requestParams1.put("merchantId",merId);
		requestParams1.put("flag",fl);
		requestParams1.put("version",ver);
		requestParams1.put("groupId", "MOBEIX");
		requestParams1.put("createdBy", creBy);
		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
		
		

	@Test
	public void TC__06_Update_user_by_username() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		test.log(LogStatus.INFO, "Before update userName==> "+uName);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "After update userName==> "+userName);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

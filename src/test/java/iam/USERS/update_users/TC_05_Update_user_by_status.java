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

public class TC_05_Update_user_by_status extends base {
	
	String userId1 = RestUtil.userId();
	Object sta;
	@BeforeClass
	public void updateUser() {
		getuserlist();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath();
		JSONObject requestParams = new JSONObject();
		Object uID = jsonPath.get("[3].userId");
		Object uName = jsonPath.get("[3].userName");
		Object uType = jsonPath.get("[3].userType");
		Object eMa = jsonPath.get("[3].Email");
		Object merId = jsonPath.get("[3].merchantId");
		Object ver = jsonPath.get("[3].version");
		sta = jsonPath.get("[3].status");
		Object fl = jsonPath.get("[3].flag");
		Object creBy = jsonPath.get("[3].createdBy");
		
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", uID);
		requestParams1.put("userName", uName);
		requestParams1.put("userType", uType);
		requestParams1.put("Email", eMa);
		requestParams1.put("merchantId",merId);
		requestParams1.put("flag",fl);
		requestParams1.put("version",ver);
		requestParams1.put("groupId", "MOBEIX");
		requestParams1.put("status", "INACTIVE");

		requestParams1.put("createdBy", creBy);
		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
		
		

	@Test
	public void TC__05_Update_user_by_status() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		test.log(LogStatus.INFO, "Before update status==> "+sta);
		
		test.log(LogStatus.INFO, "After update status==> "+"INACTIVE");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

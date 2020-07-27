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

public class TC_04_Update_user_by_MerchantID extends base {
	
	String userId1 = RestUtil.userId();
	Object merId;
	@BeforeClass
	public void updateUser() {
		getuserlist();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath();
		JSONObject requestParams = new JSONObject();
		Object uID = jsonPath.get("[2].userId");
		Object uName = jsonPath.get("[2].userName");
		Object uType = jsonPath.get("[2].userType");
		Object eMa = jsonPath.get("[2].Email");
		merId = jsonPath.get("[2].merchantId");
		Object ver = jsonPath.get("[2].version");
		Object fl = jsonPath.get("[2].flag");
		Object creBy = jsonPath.get("[2].createdBy");
		
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", userId1);
		requestParams1.put("userName", uName);
		requestParams1.put("userType", uType);
		requestParams1.put("Email", eMa);
		requestParams1.put("merchantId","4");
		requestParams1.put("flag",fl);
		requestParams1.put("version",ver);
		requestParams1.put("groupId", "MOBEIX");
		requestParams1.put("createdBy", creBy);
		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
		
		

	@Test
	public void TC__04_Update_user_by_MerchantID() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		test.log(LogStatus.INFO, "Before update merchantId==> "+merId);
		Assert.assertEquals(responseBody.contains("USER_NOT_EXIST"), true);		
		test.log(LogStatus.INFO, "After update merchantId==> "+"4");
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 404);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

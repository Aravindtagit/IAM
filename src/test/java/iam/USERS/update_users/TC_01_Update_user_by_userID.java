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

public class TC_01_Update_user_by_userID extends base {
	
	String userId1 = RestUtil.userId();
	Object uID;
	@BeforeClass
	public void updateUser() {
		getuserlist();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath();
		JSONObject requestParams = new JSONObject();
		uID = jsonPath.get("[5].userId");
		Object uName = jsonPath.get("[5].userName");
		Object uType = jsonPath.get("[5].userType");
		Object eMa = jsonPath.get("[5].Email");
		Object merId = jsonPath.get("[5].merchantId");
		Object ver = jsonPath.get("[5].version");
		Object fl = jsonPath.get("[5].flag");
		Object creBy = jsonPath.get("[5].createdBy");
		//System.out.println("user id :"+uID);
		
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", userId1);
		requestParams1.put("userName", "Aravind");
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
	public void TC__01_Update_user_by_userID() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		//System.out.println("RESULT="+object);
		//test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//test.log(LogStatus.INFO, "Before update userId==> "+uID);
		Assert.assertEquals(responseBody.contains("USER_NOT_EXIST"), true);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		
		//test.log(LogStatus.INFO, "After update userId==> "+userId1);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 404);
		String s=String.valueOf(statusCode);  
		//test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

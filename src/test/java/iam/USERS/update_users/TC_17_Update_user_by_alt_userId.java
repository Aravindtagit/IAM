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

public class TC_17_Update_user_by_alt_userId extends base {
	
	String userId1 = RestUtil.userId();
	String username = RestUtil.userName();

	
	Object auId;

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
		Object lact = jsonPath.get("[3].lastAction");
		Object ver = jsonPath.get("[3].version");
		Object fl = jsonPath.get("[3].flag");
		
		auId = jsonPath.get("[3].altUserId");
		Object creBy = jsonPath.get("[3].createdBy");
		
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", uID);
		requestParams1.put("userName", userName);
		requestParams1.put("userType", uType);
		requestParams1.put("Email", eMa);
		requestParams1.put("merchantId",merId);
		requestParams1.put("flag","2");
		requestParams1.put("lastAction","EMAIL UPDATED");
		
		requestParams1.put("altUserId","008");
		
		requestParams1.put("version",ver);
		requestParams1.put("groupId", "MOBEIX");
		requestParams1.put("createdBy", creBy);
		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	

	@Test
	public void TC__17_Update_user_by_alt_userId() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		//System.out.println("RESULT="+object);
		
		test.log(LogStatus.INFO, "Before update altUserId==> "+auId);
		//Assert.assertEquals(responseBody.contains("INTERNAL_SERVER_ERROR"), true);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		
		test.log(LogStatus.INFO, "After update altUserId==> "+"008");
		

		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

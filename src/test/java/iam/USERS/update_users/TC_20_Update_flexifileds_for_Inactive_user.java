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

public class TC_20_Update_flexifileds_for_Inactive_user extends base {
	
	String userId1 = RestUtil.userId();
	String username = RestUtil.userName();

	

	@BeforeClass
	public void updateUser() {
		getuserlist();
		header2();
		response = httpRequest.request(Method.GET);
		String a = response.asString();
		String filterValue=base.getFilter("INACTIVE");
		System.out.println("YES I CAN :"+filterValue);
		getuserId(filterValue);
		header2();
		response = httpRequest.request(Method.GET);
		String responseBody = response.getBody().asString();
		System.out.println("RESPONSE :"+responseBody);
		JsonPath jsonPath = response.jsonPath();
		Object ver = jsonPath.get("version");
		System.out.println("Ver : "+ver);
	
		updateuser();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("userId", filterValue);
		requestParams1.put("userName", filterValue);
		requestParams1.put("userType", "CHECKER");
		requestParams1.put("Email", "mobile@tagit.com");
		requestParams1.put("merchantId","1");
		requestParams1.put("flag","0");
		requestParams1.put("flexiField1","new user");
		requestParams1.put("version",ver);
		requestParams1.put("groupId", "MOBEIX");
		requestParams1.put("createdBy", "ADMIN");
		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	@Test
	public void TC__20_Update_flexifileds_for_Inactive_user() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		//System.out.println("RESULT="+object);
		//test.log(LogStatus.INFO, "Before update flexiField1==> "+flex1);
		//test.log(LogStatus.INFO, "Before update flexiField2==> "+flex2);

		//Assert.assertEquals(responseBody.contains("INTERNAL_SERVER_ERROR"), true);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//test.log(LogStatus.INFO, "After update flexiField1==> "+"new user");
		//test.log(LogStatus.INFO, "After update flexiField1==> "+"admin user");
		
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

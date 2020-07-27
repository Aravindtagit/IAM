package iam.USER_Validate_Userdata;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_01_Validate_user_with_valid_userdata extends base {
	
	
	
	@BeforeClass
	public void validateUser() {
		getuserlist();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath();
		JSONObject requestParams = new JSONObject();
		Object creBy = jsonPath.get("[5].createdBy");
		Object credate = jsonPath.get("[5].createdDate");		
		Object fl = jsonPath.get("[5].flag");
		Object sts = jsonPath.get("[5].status");
		Object stschangedate = jsonPath.get("[5].statusChangeDate");
		Object ver = jsonPath.get("[5].version");
		Object ukey = jsonPath.get("[5].userKey");
		Object gid = jsonPath.get("[5].groupId");
		Object frcchangepwd = jsonPath.get("[5].isForceChangePswd");
		Object pwdchangedate = jsonPath.get("[5].pswdChangeDate");
		Object pwdstatus = jsonPath.get("[5].pswdStatus");
		Object pwdstschangedate = jsonPath.get("[5].pswdStatusChangeDate");
		Object eMa = jsonPath.get("[5].Email");
		Object uid = jsonPath.get("[5].userId");
		Object uName = jsonPath.get("[5].userName");
		Object uType = jsonPath.get("[5].userType");
		Object merId = jsonPath.get("[5].merchantId");
		Object twofacsts = jsonPath.get("[5].twoFactorStatus");
	
		
		validateuserdata();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("createdBy", creBy);
		requestParams1.put("createdDate", credate);
		requestParams1.put("flag", fl);
		requestParams1.put("statusChangeDate", stschangedate);
		requestParams1.put("version",ver);
		requestParams1.put("userKey",ukey);
		requestParams1.put("groupId",gid);
		requestParams1.put("isForceChangePswd",frcchangepwd);
		requestParams1.put("pswdChangeDate",pwdchangedate);
		requestParams1.put("pswdStatus",pwdstatus);
		requestParams1.put("pswdStatusChangeDate", pwdstschangedate);
		requestParams1.put("Email", eMa);
		requestParams1.put("userId", uid);
		requestParams1.put("userName", uName);
		requestParams1.put("userType", uType);
		requestParams1.put("merchantId", merId);
		requestParams1.put("twoFactorStatus", twofacsts);

		header();
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}


	@Test
	public void TC__01_Validate_user_with_valid_userdata() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);

		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

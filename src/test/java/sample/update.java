package sample;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class update extends base {

	//String flag1 = RestUtil.flag1();//
	String flag2 = RestUtil.flag1();
	String groupId1 = RestUtil.groupId1();
	String merchantid1 = RestUtil.merchantId1();
	String a;
	String b;
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createGroup() {
		creategroup();
		JSONObject requestParams = new JSONObject();
		requestParams.put("flag", "0"); 
		requestParams.put("groupId",groupId1);
		requestParams.put("merchantId",merchantid1);
		requestParams.put("createdBy", "ADMIN");
		
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
		System.out.println("CREATED");
		updategroup();
		JSONObject requestParams1 = new JSONObject();
		requestParams1.put("updatedBy", "ADMIN");
		requestParams1.put("flag", "1"); 
		requestParams1.put("groupId",groupId1);
		requestParams1.put("version","1");
		header();
		b=flag2;
		httpRequest.body(requestParams1.toJSONString());
		response=httpRequest.request(Method.POST);
	}
	
	@Test
	public void TC_01__create_update_access_with_mandatory_Fileds() {
		/*System.out.println("configCode"+configCode);
		System.out.println("configKey"+configKey);
		System.out.println("configValue"+configValue);
		System.out.println("configRuletype"+configRuletype);
		System.out.println("configComptype"+configComptype);*/
		String responseBody = response.getBody().asString();
		//Assert.assertEquals(responseBody.contains(merchantName), true);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Before update flag ==> 0");
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "After update flag ==> "+b);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

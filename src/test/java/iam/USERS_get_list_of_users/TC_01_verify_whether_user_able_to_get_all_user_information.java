package iam.USERS_get_list_of_users;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_01_verify_whether_user_able_to_get_all_user_information extends base {
	/*String flag1 = RestUtil.flag1();
	String groupId1 = RestUtil.groupId1();
	String merchantid1 = RestUtil.merchantId1();*/
	Object object;
	//@SuppressWarnings("unchecked")
	@BeforeClass
	public void getuserList() {
		getuserlist();
		
		JSONObject requestParams = new JSONObject();
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("[0].userId");
		System.out.println("RESULT :"+object);
		response = httpRequest.request(Method.GET,"/"+object);
		JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.merchantId");
		 System.out.println(object);*/
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath(); 
		object = jsonPath.get("[2].userId");
		System.out.println("RESULT :"+object);
	}
		
		

	@Test
	public void TC__01_verify_whether_user_able_to_get_all_user_information() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		System.out.println("RESULT="+object);
	
		Assert.assertEquals(responseBody.contains("ACTIVE"), true);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

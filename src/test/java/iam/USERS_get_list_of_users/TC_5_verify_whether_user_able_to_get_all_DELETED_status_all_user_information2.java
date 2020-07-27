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

public class TC_5_verify_whether_user_able_to_get_all_DELETED_status_all_user_information2 extends base {
	/*String flag1 = RestUtil.flag1();
	String groupId1 = RestUtil.groupId1();
	String merchantid1 = RestUtil.merchantId1();*/

	//@SuppressWarnings("unchecked")
	@BeforeClass
	public void getuserList() {
		getuserlist();
		
		JSONObject requestParams = new JSONObject();
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("[0].userId");
		System.out.println("RESULT :"+object);
		response = httpRequest.request(Method.GET,"/"+object);*/
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.merchantId");
		 System.out.println(object);*/
		//requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.GET);
	}
		
		

	@Test
	public void TC__5_verify_whether_user_able_to_get_all_DELETED_status_all_user_information2() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		
	
		Assert.assertEquals(responseBody.contains("DELETED"), false);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

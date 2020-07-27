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

public class TC_7_verify_whether_user_able_to_get_userinformation_with_sameUSERID_with_different_group extends base {
	/*String flag1 = RestUtil.flag1();
	String groupId1 = RestUtil.groupId1();
	String merchantid1 = RestUtil.merchantId1();*/

	//@SuppressWarnings("unchecked")
	@BeforeClass
	public void getuserList1() {
		getuserlist();
		headerforListOfuser("wwEC");
		response=httpRequest.request(Method.GET);
	}
	
	@Test
	public void TC_7_verify_whether_user__able_to_get_userinformation_with_sameUSERID_with_different_group() {
		String responseBody = response.getBody().asString();
		System.out.println("res"+responseBody);
		
	
		//Assert.assertEquals(responseBody.contains("DELETED"), false);		
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

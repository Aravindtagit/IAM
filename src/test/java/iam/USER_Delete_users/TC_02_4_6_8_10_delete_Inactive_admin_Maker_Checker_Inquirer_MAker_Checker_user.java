package iam.USER_Delete_users;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_02_4_6_8_10_delete_Inactive_admin_Maker_Checker_Inquirer_MAker_Checker_user extends base {
	

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void deleteUser() {
		getuserlist();
		header2();
		response = httpRequest.request(Method.GET);
		String a = response.asString();
		String filterValue=base.getFilter("INACTIVE");
		System.out.println("YES I CAN :"+filterValue);
		
		deleteuserbyID(filterValue);
		header2();
		//httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.DELETE);
	}
		
	@Test
	public void TC__02_delete_Inactive_admin_user() {
		
		//String responseBody = response.getBody().asString();
		//Assert.assertEquals(responseBody.contains(merchantName), true);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		//test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}

}

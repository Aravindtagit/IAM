package iam.USER_Delete_users;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_11_delete_a_user_not_exist extends base {

	@BeforeClass
	public void deleteUserbyID1() throws Throwable {
		deleteuserbyID1();
		header();
		response = httpRequest.request(Method.DELETE);
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("[0].confKey");
		System.out.println("RESULT :"+object);
		getconfigwithconfgkey();*/
		header();
		response = httpRequest.request(Method.DELETE);
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.merchantId");
		 System.out.println(object);*/
	}
	
	

	@Test
	public void TC_11_delete_a_user_not_exist() {
		String responseBody = response.getBody().asString();
		logger.info("Response Body==>" + responseBody);
		//Assert.assertTrue(responseBody != null);
		System.out.println("RES="+responseBody);
		
		 test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		////response.getBody()._embedded
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 500);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

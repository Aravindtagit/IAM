package mobeixServer.userManagement_Update_User;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;

public class TC_08_Update_userMobileNo_as_14_Char extends base {

	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		getAllUserDetails();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.userId");
		Object version = jsonPath.get("_embedded.hateoasResourceList[0].dto.version");
		createUserDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", object);
		requestParams.put("userName", userName);
		requestParams.put("userType", userType);
		requestParams.put("version", version);
		requestParams.put("merchantId", "1");
		requestParams.put("groupId", "MOBEIX");
		requestParams.put("userMobileNo", RandomStringUtils.randomNumeric(14));
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.PUT);
	}
	
	@Test
	public void TC_08__Update_userMobileNo_as_14_Char() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("MOBEIX"), true);
		logger.info("Response Body is==> "+responseBody);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		//Assert.assertEquals(responseBody.contains(contactPhone), true);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

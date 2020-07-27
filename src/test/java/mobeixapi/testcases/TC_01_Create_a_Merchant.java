package mobeixapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import io.restassured.http.Method;
import mobeixapi.base.base;

public class TC_01_Create_a_Merchant extends base{
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void createMerchant() {
		CreateMerchantdetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("merchantName", merchantName);
		requestParams.put("contactEmail", contactEmail);
		requestParams.put("contactPhone", contactPhone);
		requestParams.put("contactName", contactName);
		requestParams.put("merchantAppKeyword", merchantName);
		requestParams.put("merchantAppLongKeyword", merchantAppLongKeyword);
		requestParams.put("contactAddress", contactAddress);  
		requestParams.put("country", "0"); 
		requestParams.put("createdDate", "2020-03-18T09:56:08.967Z");
		requestParams.put("productCategory", productCategory);
		requestParams.put("registrationCode", registrationCode);
		requestParams.put("tenantId", "1");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.POST);
		//postReq()
	}
	
	@Test
	public void TC_01__Create_a_Merchant() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(merchantName), true);
		Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

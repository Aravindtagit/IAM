package mobeixapi.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import mobeixapi.base.base;
import mobeixapi.utilities.RestUtil;

public class TC_03_Update_a_Merchant extends base{

	String merchantName = RestUtil.merchantName();
	String contactEmail = RestUtil.contactEmail();
	String contactPhone = RestUtil.contactPhone();
	String contactName = RestUtil.contactName();
	String merchantAppLongKeyword = RestUtil.merchantAppLongKeyword();
	String contactAddress = RestUtil.contactAddress();
	String registrationCode = RestUtil.registrationCode();
	String productCategory = RestUtil.productCategory();
	
	@SuppressWarnings("unchecked")
	@BeforeClass
	public void updateMerchant() {
		updateMerchantDetails();
		JSONObject requestParams = new JSONObject();
		requestParams.put("merchantId", "70");
		requestParams.put("merchantName", "T7");
		requestParams.put("contactEmail", contactEmail);
		requestParams.put("contactPhone", contactPhone);
		requestParams.put("contactName", contactName);
		requestParams.put("merchantAppKeyword", "T6");
		requestParams.put("merchantAppLongKeyword", merchantAppLongKeyword);
		requestParams.put("contactAddress", contactAddress);  
		requestParams.put("country", "0"); 
		requestParams.put("modifiedBy", "2020-03-18T09:56:08.967Z");
		requestParams.put("productCategory", productCategory);
		requestParams.put("registrationCode", registrationCode);
		requestParams.put("tenantId", "1");
		header();
		httpRequest.body(requestParams.toJSONString());
		response=httpRequest.request(Method.PUT);
	}
	
	@Test
	public void TC_03__Update_a_Merchantt() {
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("T6"), true);
		Assert.assertEquals(responseBody.contains(contactPhone), true);
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

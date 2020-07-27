package mobeixapi.testcases;

import java.util.Collection;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.relevantcodes.extentreports.LogStatus;

import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;

public class TC_02_Get_all_Merchant extends base {

	@BeforeClass
	public void getAllMerchant() throws Throwable {
		getAllMerchantdetails();
		header();
		response = httpRequest.request(Method.GET);
		/*JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.merchantId");
		 System.out.println(object);*/
	}

	@Test
	public void TC_02__Get_all_Merchant() {
		String responseBody = response.getBody().asString();
		logger.info("Response Body==>" + responseBody);
		Assert.assertTrue(responseBody != null);
		System.out.println("RES="+responseBody);
		 test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		////response.getBody()._embedded
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
}

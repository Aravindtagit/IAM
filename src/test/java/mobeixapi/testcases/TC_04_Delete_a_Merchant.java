package mobeixapi.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import mobeixapi.base.base;

public class TC_04_Delete_a_Merchant extends base{

	@BeforeClass
	public void deleteMerchant() {
		deleteMerchantDetails();
		header();
		response = httpRequest.request(Method.GET);
		JsonPath jsonPath = response.jsonPath(); 
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.merchantId");
		RestAssured.baseURI="http://172.17.2.28:8081/mobeixadmin/api/merchants/"+object;
		httpRequest=RestAssured.given();
		header();
		response=httpRequest.request(Method.DELETE);
		}
	@Test(retryAnalyzer=mobeixapi.utilities.RetryAnalyzer.class)
	public void TC_04__Delete_a_Merchant() {
		String responseBody = response.getBody().asString();
		//Assert.assertTrue(responseBody!=null);
		//Assert.assertTrue(responseBody.contains("merchantAppLongKeyword"));
		test.log(LogStatus.INFO, "Response Body is==> "+responseBody);
		int statusCode = response.getStatusCode();
		logger.info("Status Code is==> "+statusCode);
		Assert.assertEquals(statusCode, 200);
		String s=String.valueOf(statusCode);  
		test.log(LogStatus.INFO, "Status Code is==> "+s);
	}
	
	
}

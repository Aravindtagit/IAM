package mobeixServer.userManagement_Get_User;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import mobeixapi.base.base;

public class TC_01_Get_active_user_details extends base {

	@Test
	public void getAllMerchant() throws Throwable {
		getAllUserDetails();
		header();
		response = httpRequest.request(Method.GET);
		 
		 JsonPath jsonPath = response.jsonPath();
		Object object = jsonPath.get("_embedded.hateoasResourceList[0].dto.userId");
		System.out.println(object);
		
		Object jsonObject = jsonPath.getJsonObject("$..dto.['status','userId']");
		
		//Object object2 = jsonPath.get("$..[?(@['status']=='INACTIVE')]['userId']");
		System.out.println(jsonObject);
		Object object3 = jsonPath.get("_embedded.hateoasResourceList[0].dto.status");
		System.out.println(object3);
		
	}
}

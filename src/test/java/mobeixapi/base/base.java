package mobeixapi.base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import mobeixapi.utilities.RestUtil;


public class base {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public Logger logger;
	public static ExtentReports reports;
	public static ExtentTest test;
	public static String SystemURl = "http://172.17.2.28:8081/"; // MERCHANT
																	// MANAGEMENT
																	// ENVIORMENT
	public static String SystemURL1 = "http://172.17.1.96:9896/"; // USER
																	// MANAGEMENT
																	// ENVIORMENT
	public static String SystemURl3 = "http://172.17.1.116:8880/"; // IAM//

	public static String merchantName = RestUtil.merchantName();
	public static String contactEmail = RestUtil.contactEmail();
	public static String contactPhone = RestUtil.contactPhone();
	public static String contactName = RestUtil.contactName();
	public static String merchantAppLongKeyword = RestUtil.merchantAppLongKeyword();
	public static String contactAddress = RestUtil.contactAddress();
	public static String registrationCode = RestUtil.registrationCode();
	public static String productCategory = RestUtil.productCategory();
	public static String userId = RestUtil.userId();
	public static String userName = RestUtil.userName();
	public static String userType = RestUtil.userType();
	public static String alphaNumcontactPhone = RestUtil.alphaNumcontactPhone();
	public static JSONObject requestParams;

	/* CONFIGURATION */

	public static String configCode = RestUtil.configCode();
	public static String configKey = RestUtil.configkey();
	public static String configValue = RestUtil.configValue();
	public static String configRuletype = RestUtil.configRuletype();
	public static String configComptype = RestUtil.configComptype();

	@BeforeClass
	public void setup() {
		logger = Logger.getLogger("MOBEIX API");
		PropertyConfigurator.configure("log4j.properties");
		logger.setLevel(Level.DEBUG);
	}

	public static void postReq() {
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
	}

	public static void CreateMerchantdetails() {
		RestAssured.baseURI = SystemURl + "mobeixadmin/api/merchants/";
		httpRequest = RestAssured.given();
	}

	public static void updateMerchantDetails() {
		RestAssured.baseURI = SystemURl + "mobeixadmin/api/merchants/";
		httpRequest = RestAssured.given();
	}

	public static void deleteMerchantDetails() {
		RestAssured.baseURI = SystemURl + "mobeixadmin/api/merchants/";
		httpRequest = RestAssured.given();
	}

	public static void getAllMerchantdetails() throws Throwable {
		RestAssured.baseURI = SystemURl + "mobeixadmin/api/merchants/";
		httpRequest = RestAssured.given();
	}

	public static void header() {
		httpRequest.header("Content-Type", "application/json");
		/*
		 * httpRequest.header("X-Request-By","Admin");
		 * httpRequest.header("groupId","MOBEIX");
		 * httpRequest.header("X-Request-ID","Admin");
		 */

	}

	public static void header2() {
		httpRequest.header("Content-Type", "application/json");

		// httpRequest.header("X-Request-By","Admin");
		httpRequest.header("groupId", "MOBEIX");
		// httpRequest.header("X-Request-ID","Admin");

	}

	/*
	 * private HttpHeaders constructHeaders(Map<String, String> headermap) {
	 * HttpHeaders headers = new HttpHeaders();
	 * headers.setContentType(MediaType.APPLICATION_JSON); if (headermap != null
	 * && headermap.size() > 0) { headermap.entrySet().stream().forEach(entrySet
	 * -> { headers.set(entrySet.getKey(), entrySet.getValue());
	 * 
	 * });
	 * 
	 * } httpRequest.header("Content-Type","application/json");
	 * httpRequest.header("X-Request-By","Admin");
	 * httpRequest.header("groupId","MOBEIX");
	 * httpRequest.header("X-Request-ID","Admin"); return headers; }
	 */
	public static void createUserDetails() {
		RestAssured.baseURI = SystemURL1 + "mobeixadmin/api/users/";
		httpRequest = RestAssured.given();
	}

	public static void getAllUserDetails() {
		RestAssured.baseURI = SystemURL1 + "mobeixadmin/api/users/";
		httpRequest = RestAssured.given();
	}

	public static void updateconfiguration() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/update";
		httpRequest = RestAssured.given();
	}

	public static void saveconfiguration() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/save";
		httpRequest = RestAssured.given();
	}

	public static void getconfiguration() throws Throwable {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/configurations";
		httpRequest = RestAssured.given();
	}

	// GET CONFIG FOR INVALID MERCHAT ID
	public static void getconfiguration1() throws Throwable {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MD/configurations";
		httpRequest = RestAssured.given();

	}

	public static void getconfigwithconfgkey() throws Throwable {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/retriveById";
		httpRequest = RestAssured.given();

	}

	// GET config with compytpe code merchant ID
	public static void getconfigwithcompytpe() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/Anbu/MPIN";
		httpRequest = RestAssured.given();
	}

	public static void deleteconfiguration() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/configuration/merchants/MX/26";
		httpRequest = RestAssured.given();
	}

	public static void creategroup() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/groupaccess/create";
		httpRequest = RestAssured.given();
	}

	public static void updategroup() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/groupaccess/update";
		httpRequest = RestAssured.given();
	}

	public static void getgroup() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/groupaccess/EgAKyE";
		httpRequest = RestAssured.given();
	}

	public static void deletegroup() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/groupaccess/MOBEIX/delete";
		httpRequest = RestAssured.given();
	}

	// Profile

	public static void createprofile() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/profiles/create";
		httpRequest = RestAssured.given();
	}

	public static void updateprofile() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/profiles/update";
		httpRequest = RestAssured.given();
	}

	public static void getlistofprofiles() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/profiles";
		httpRequest = RestAssured.given();
	}
	
	// GET PROFILE DETAILS BY PROFILE ID
	
	
	public static void getprofiledetailsbyid(String s) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/profiles"+s;
		httpRequest = RestAssured.given();
	}
	
	public String getprofileidFilter(String param, String filtervalue) {
		String a = response.asString();
		System.out.println("Full body :"+a);
		String b="";
		String c="";

		String a1 = "";
		String a2 = "";
		String a4 = ":";
		char d1='"';
		char d2='"';
		String e1=String.valueOf(d1);
		String e2=String.valueOf(d2);
		String param1=e1.concat(param.concat(e2).concat(a4));
		System.out.println(param1);
		// String a3 = "\"status\"";


		char c1='"';
		char c2='"';
		String b1=String.valueOf(c1);
		String b2=String.valueOf(c2);
		String a5=b1.concat(filtervalue.concat(b2));
		String a6 = param1.concat(a5);
		System.out.println("Altered :"+a6);

		String[] split = a.split("tenantId");
		System.out.println(split.length);
		for(int i=0;i<split.length;i++)
		{
		if(split[i].contains(a6))
		{
		System.out.println("first sprit :" + split[i]);
		b=split[i];
		break;
		}
		}

		String[] split2 = b.split(",");
		for(int i=0;i<split2.length;i++)
		{
		if(split2[i].contains("profileId"))
		{
		c= split2[i];
		break;
		}
		}
		System.out.println("FINAL :"+c);
		String[] split3 = c.split(":");
		String res=split3[1];
		System.out.println("profileId"+res);
		return res ;
		}
	

	
	

	// USER

	public static void createuser() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/create";
		httpRequest = RestAssured.given();
	}

	// PASSWORD
	public static Object encrypt(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("emailId", "abcdefghq");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	// PIN
	public static Object mpinencrypt(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("MPIN", "abcdef");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public static Object mpinencrypt2(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("MPIN", "abcdefghjikl");
		requestParams.put("groupId", "MOBEIX");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	// Different Group ID

	public static Object encrypt1(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("emailId", "abcdefghq");
		requestParams.put("groupId", "MOBEIX1");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public static Object encrypt2(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("emailId", "abcdefghq");
		requestParams.put("groupId", "TEST");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public static Object encrypt3(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("emailId", "abcdefghq");
		requestParams.put("groupId", "asdfghjklzxcvbnmpoiuytrewqasdfghjklmnbvccxzasdfghjkl");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public static Object encrypt4(Object ob) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/encrypt";
		httpRequest = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", ob);
		requestParams.put("emailId", "abcdefghq");
		requestParams.put("groupId", "    ");
		header();
		httpRequest.body(requestParams.toJSONString());
		response = httpRequest.request(Method.POST);
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	// getuserlist

	public static void getuserlist() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users";
		httpRequest = RestAssured.given();
	}

	public static void getuserId(String id) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/" + id;
		httpRequest = RestAssured.given();
	}

	public static void headerforListOfuser1() {
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("groupId", "asds");
		httpRequest = RestAssured.given();
	}

	public static void sample() {
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("groupId", "asds");
		httpRequest = RestAssured.given();
	}

	public static void headerforListOfuser(String uID) {
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("searchParam", "USER_ID");
		httpRequest.header("searchvalue", uID);
		httpRequest = RestAssured.given();

	}

	// Create PROGRAM
	public static void createprogram() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/create";
		httpRequest = RestAssured.given();
	}

	// GET PROGRAM
	public static void getprogramlist() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs";
		httpRequest = RestAssured.given();
	}
	
	// UPDATE PROGRAM
	
	public static void updateprogram1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/update";
		httpRequest = RestAssured.given();
	}
	
	// DELETE PROGRAM (VALID)
	
	public static void deleteprogram1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/removeProgram/74";
		httpRequest = RestAssured.given();
	}
	
	// DELETE PROGRAM (VALID)
	public static void deleteprogram2() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/removeProgram/0098";
		httpRequest = RestAssured.given();
	}
	public static void deleteprogram3(String a) {
		RestAssured.baseURI = "http://172.17.1.116:8480/mxcomponentapi/accessmanagement/merchants/MX/programs/removeProgram/"+a;
		
		httpRequest = RestAssured.given();
	}
	
	// LINK PROFILE AND PROGRAM
	
	public static void linkprofileprogram() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/linkProfileAndProgram";
		httpRequest = RestAssured.given();
	}
	
	public String getprofileidFilter2(String param, String filtervalue) {
		String a = response.asString();
		System.out.println("Full body :"+a);
		String b="";
		String c="";

		String a1 = "";
		String a2 = "";
		String a4 = ":";
		char d1='"';
		char d2='"';
		String e1=String.valueOf(d1);
		String e2=String.valueOf(d2);
		String param1=e1.concat(param.concat(e2).concat(a4));
		System.out.println(param1);
		// String a3 = "\"status\"";

		String replace="";
		char c1='"';
		char c2='"';
		String b1=String.valueOf(c1);
		String b2=String.valueOf(c2);
		String a5=b1.concat(filtervalue.concat(b2));
		String a6 = param1.concat(a5);
		System.out.println("Altered :"+a6);

		String[] split = a.split("profileProgramDTOs");
		System.out.println(split.length);
		for(int i=0;i<split.length;i++)
		{
		if(split[i].contains(a6))
		{
		System.out.println("first sprit :" + split[i]);
		b=split[i];
		break;
		}
		}

		String[] split2 = b.split(",");
		for(int i=0;i<split2.length;i++)
		{
		if(split2[i].contains("profileId"))
		{
		c= split2[i];
		break;
		}
		}
		System.out.println("FINAL :"+c);
		String[] split3 = c.split(":");
		String res=split3[1];
		if(res.contains(b1))
		{
			replace = res.replace(b2, "");
		}
		else
		{
			replace=res;
		}
		System.out.println("profileId"+replace);
		return replace ;
		}

	
	//getlistofprofilesforprofandprg
	public static void getlistofprofilesforprofandprg() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/linkProfileAndProgram";
		httpRequest = RestAssured.given();
	}
	
	
	// GET PROGRAM DETAILS BY PROGRAM ID
	public static void getprogramdetails(String a) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/"+a;
		httpRequest = RestAssured.given();
	}
	
	public static void getprogramdetails1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/1098";
		httpRequest = RestAssured.given();
	}
	
	public static void getprogramdetails2() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programs/TAGIT";
		httpRequest = RestAssured.given();
	}
	
	
	public static String getprgKeyFilter(String param, String filtervalue) {
		String a = response.asString();
		System.out.println("Full body :"+a);
		String b="";
		String c="";

		String a1 = "";
		String a2 = "";
		String a4 = ":";
		char d1='"';
		char d2='"';
		String e1=String.valueOf(d1);
		String e2=String.valueOf(d2);
		String param1=e1.concat(param.concat(e2).concat(a4));
		System.out.println(param1);
		// String a3 = "\"status\"";


		char c1='"';
		char c2='"';
		String b1=String.valueOf(c1);
		String b2=String.valueOf(c2);
		String a5=b1.concat(filtervalue.concat(b2));
		String a6 = param1.concat(a5);
		System.out.println("Altered :"+a6);

		String[] split = a.split("mxMsgCode");
		System.out.println(split.length);
		for(int i=0;i<split.length;i++)
		{
		if(split[i].contains(a6))
		{
		System.out.println("first sprit :" + split[i]);
		b=split[i];
		break;
		}
		}

		String[] split2 = b.split(",");
		for(int i=0;i<split2.length;i++)
		{
		if(split2[i].contains("prgId"))
		{
		c= split2[i];
		break;
		}
		}
		System.out.println("FINAL :"+c);
		String[] split3 = c.split(":");
		String res=split3[1];
		System.out.println("PrgKey"+res);
		return res;
		}
	
	
	// RETRIVE A PROGRAM USING INVALID PROGRAM ID
	
	public static void retriveprogramuisngprgid1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/retriveprogram/ABCD1000";
		httpRequest = RestAssured.given();
	}
	// RETRIVE A PROGRAM USING DELETED PROGRAM ID
	public static void retriveprogramuisngprgid2() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/retriveprogram/ABCDEFGHI";
		httpRequest = RestAssured.given();
	}
	// RETRIVE A PROGRAM USING PROGRAM ID
	public static void retriveprogramuisngprgid(String s) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/retriveprogram/"+s;
		httpRequest = RestAssured.given();
	}
		
		public static String getprgidFilter(String param, String filtervalue) {
		String a = response.asString();
		System.out.println("Full body :"+a);
		String b="";
		String c="";

		String a1 = "";
		String a2 = "";
		String a4 = ":";
		char d1='"';
		char d2='"';
		String e1=String.valueOf(d1);
		String e2=String.valueOf(d2);
		String param1=e1.concat(param.concat(e2).concat(a4));
		System.out.println(param1);
		// String a3 = "\"status\"";

		char c1='"';
		char c2='"';
		String b1=String.valueOf(c1);
		String b2=String.valueOf(c2);
		String a5=b1.concat(filtervalue.concat(b2));
		String a6 = param1.concat(a5);
		System.out.println("Altered :"+a6);

		String[] split = a.split("mxMsgCode");
		System.out.println(split.length);
		for(int i=0;i<split.length;i++)
		{
		if(split[i].contains(a6))
		{
		System.out.println("first sprit :" + split[i]);
		b=split[i];
		break;
		}
		}

		String[] split2 = b.split(",");
		for(int i=0;i<split2.length;i++)
		{
		if(split2[i].contains("prgId"))
		{
		c= split2[i];
		break;
		}
		}
		System.out.println("FINAL :"+c);
		String[] split3 = c.split(":");
		String res=split3[1];
		System.out.println("PrgKey"+res);
		return res;
		}

	
	
	
			
	// CREATE PROGRAM GROUP
	public static void createprogramgroup() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/programgroups/create";
		httpRequest = RestAssured.given();
	}
	
	// INVALID MERCHANT ID
	public static void getprogramlist1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MA/programs";
		httpRequest = RestAssured.given();
	}
	// retriveallprogramList

	public static void retriveallprogramlist() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/retrivePrograms";
		httpRequest = RestAssured.given();
	
	}
	
	// retriveallprogramdataList
	public static void retriveallprogramdatalist() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/accessmanagement/merchants/MX/retriveProgramList";
		httpRequest = RestAssured.given();
	
	}

	public static String getFilter3(String sta) {
		String a = response.asString();
		String b = "";
		String c = "";
		char RR='"';
		String hhh=RR+"ACTIVE"+RR;
		System.out.println("hhh"+hhh);
		
		String d = "\"status\"";
		String e = ":";
		String f = d.concat(e).concat(hhh);
		System.out.println(f);
		
		String[] split = a.split("mxMsgCode");
		System.out.println(split.length);
		System.out.println("SPLIT[1] :" + split[1]);
		for (int i = 0; i < split.length; i++) {
			boolean contains = split[i].contains(hhh);
			System.out.println(contains);
			if (split[i].contains(hhh)) {
				System.out.println("RES :" + split[i]);
				b = split[i];
				break;
			} 
				  else { System.out.println("No Inactive Records"); break; }
				 
		}
		String[] split2 = b.split(",");
		for (int i = 0; i < split2.length; i++) {
			if (split2[i].contains("prgKey")) {
				System.out.println("prgKey :" + split2[i]);
				c = split2[i];
				break;
			}
		}
		String substring = c.substring(10);
		System.out.println(substring);
		int length = substring.length();
		String substring2 = substring.substring(0, length - 1);
		System.out.println(substring2);
		return substring2;
	}
	// UPDATE USER
	public static void updateuser() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/update";
		httpRequest = RestAssured.given();
	}

	public static String getFilter(String filter) {

		String a = response.asString();
		String b = "";
		String c = "";
		String[] split = a.split("isPrimary");
		System.out.println(split[1].length());
		System.out.println("SPLIT[1] :" + split[1]);
		for (int i = 0; i < split.length; i++) {
			if (split[i].contains(filter)) {
				System.out.println("RES :" + split[i]);
				b = split[i];
				break;
			} else {
				System.out.println("No Inactive Records");
				// break;
			}
		}
		String[] split2 = b.split(",");
		for (int i = 0; i < split2.length; i++) {
			if (split2[i].contains("userId")) {
				System.out.println("USERID :" + split2[i]);
				c = split2[i];
				break;
			}
		}
		String substring = c.substring(10);
		System.out.println(substring);
		int length = substring.length();
		String substring2 = substring.substring(0, length - 1);
		System.out.println(substring2);
		return substring2;
	}
	
	// DELETE USER
	public static void deleteuserbyID(String id) {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/"+id;
		httpRequest = RestAssured.given();
	}
	public static void deleteuserbyID1() {
		RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/1111";
		httpRequest = RestAssured.given();
	}

	

public static void headerdelete(String uID) {
		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("searchParam", "USER_ID");
		httpRequest.header("searchvalue", uID);
		httpRequest = RestAssured.given();
}

	// VALIDATE USER DATA


	public static void validateuserdata() {
	RestAssured.baseURI = SystemURl3 + "mxcomponentapi/usermanagement/merchants/MX/users/validateUser";
	httpRequest = RestAssured.given();
	}
}
	
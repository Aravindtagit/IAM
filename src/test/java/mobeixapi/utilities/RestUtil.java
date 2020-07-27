package mobeixapi.utilities;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {

	public static String merchantName() {
		String generatedString = RandomStringUtils.randomAlphabetic(2);
		return (generatedString);
	}
	
	public static String contactEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString+"mobeix@tagitmobile.com");
	}
	
	public static String contactPhone() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	}
	
	public static String contactName() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return (generatedString+"mobeix@tagitmobile.com");
	}
	
	public static String merchantAppLongKeyword() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString+"Merchant");
	}
	
	public static String contactAddress() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString+"_ADDRESS");
	}
	
	public static String productCategory() {
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
	
	public static String registrationCode() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString+"456");
	}
	
	public static String userId() {
		String generatedString = RandomStringUtils.randomAlphabetic(4);
		return (generatedString);
	}
	
	public static String userName() {
		String generatedString = RandomStringUtils.randomAlphabetic(8);
		return (generatedString);
	}
	
	public static String userType() {
		Random rn = new Random();
		int max=3,min=0;
		  int range = max - min + 1;
		  int randomNum =  rn.nextInt(range) + min;
		  String type[]={"ADMIN", "MAKER","CHECKER", "INQUIRER"};
		  String string = type[randomNum];
		  return (string);
	}
	
	public static String alphaNumcontactPhone() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	
	/*__________________________________________*/
/*	CONFIGURATION*/	
	
	
	public static String configCode() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	public static String configValue() 
	{
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
	
	public static String configRuletype() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	
	public static String configComptype() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
	
	/*public static String configCreatedby() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
*/
	public static String configkey()
	{
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	}
	
	public static String flag1()
	{
		Random rn = new Random();
		int max=8,min=0;
		  int range = max - min + 1;
		  int randomNum =  rn.nextInt(range) + min;
		  String type[]={"1", "2","3", "4", "5", "6", "7", "8", "9"};
		  String string = type[randomNum];
		  return (string);
	}
	
	public static String groupId1()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(6);
		return (generatedString);
	}
	public static String merchantId1()
	{
		String generatedString = RandomStringUtils.randomNumeric(1);
		return (generatedString);
	}
	//profile
	
	public static String profileDesc1()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(12);
		return (generatedString);
	}
	public static String profileDesc199()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(199);
		return (generatedString);
	}
	public static String profileDesc200()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(200);
		return (generatedString);
	}
	public static String profileDesc201()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(201);
		return (generatedString);
	}
	
	public static String profileId1()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(12);
		return (generatedString);
	}
	public static String profileId49()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(49);
		return (generatedString);
	}
	public static String profileId50()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(50);
		return (generatedString);
	}
	public static String profileId51()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(51);
		return (generatedString);
	}
	
	public static String createdby50()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(50);
		return (generatedString);
	}
	public static String createdby51()
	{
		String generatedString = RandomStringUtils.randomAlphanumeric(51);
		return (generatedString);
	}

	public static String createdby49() {
		String generatedString = RandomStringUtils.randomAlphanumeric(49);
		return (generatedString);
	
	}
	//USER
	
	public static String userId1() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return (generatedString);
	
	}
	public static String userId2() {
		String generatedString = RandomStringUtils.randomAlphanumeric(51);
		return (generatedString);
	
	}
	public static String userId3() {
		String generatedString = RandomStringUtils.randomNumeric(10);
		return (generatedString);
	
	}
	

	public static String username() {
		String generatedString = RandomStringUtils.randomAlphanumeric(10);
		return (generatedString);
	
	}
	public static String username1() {
		String generatedString = RandomStringUtils.randomAlphanumeric(52);
		return (generatedString);
	
	}
	public static String username3() {
		String generatedString = RandomStringUtils.randomNumeric(5);
		return (generatedString);
	
	}
	public static String userkey() {
		String generatedString = RandomStringUtils.randomNumeric(2);
		return (generatedString);
	
	}
	
	public static String programID() {
		String generatedString = RandomStringUtils.randomAlphanumeric(4);
		return (generatedString);
	
	}
	public static String programID1() {
		String generatedString = RandomStringUtils.randomAlphanumeric(50);
		return (generatedString);
	
	}
	public static String programID2() {
		String generatedString = RandomStringUtils.randomAlphanumeric(52);
		return (generatedString);
	
	}
	public static String programNAME() {
		String generatedString = RandomStringUtils.randomAlphanumeric(15);
		return (generatedString);
	
	}

	public static String programURL() {
		String generatedString = RandomStringUtils.randomAlphanumeric(199);
		return (generatedString);
	
	}
	public static String programURL1() {
		String generatedString = RandomStringUtils.randomAlphanumeric(200);
		return (generatedString);
	
	}
	public static String programURL2() {
		String generatedString = RandomStringUtils.randomAlphanumeric(201);
		return (generatedString);
	
	}
	
	public static String Flexifield() {
		String generatedString = RandomStringUtils.randomAlphanumeric(100);
		return (generatedString);
	
	}
	public static String Flexifield99() {
		String generatedString = RandomStringUtils.randomAlphanumeric(99);
		return (generatedString);
	
	}
	public static String Flexifield101() {
		String generatedString = RandomStringUtils.randomAlphanumeric(101);
		return (generatedString);
	
	}
	public static String created() {
		String generatedString = RandomStringUtils.randomAlphanumeric(49);
		return (generatedString);
	
	}
	public static String created1() {
		String generatedString = RandomStringUtils.randomAlphanumeric(50);
		return (generatedString);
	
	}
	public static String created2() {
		String generatedString = RandomStringUtils.randomAlphanumeric(51);
		return (generatedString);
	
	}
	public static String MID() {
		String generatedString = RandomStringUtils.randomNumeric(37);
		return (generatedString);
	
	}
	public static String MID1() {
		String generatedString = RandomStringUtils.randomNumeric(38);
		return (generatedString);
	
	}
	public static String MID2() {
		String generatedString = RandomStringUtils.randomNumeric(39);
		return (generatedString);
	
	}
	
	
	public static String prtprogkey() {
		String generatedString = RandomStringUtils.randomNumeric(37);
		return (generatedString);
	
	}
	public static String prtprogkey1() {
		String generatedString = RandomStringUtils.randomNumeric(38);
		return (generatedString);
	
	}
	public static String prtprogkey2() {
		String generatedString = RandomStringUtils.randomNumeric(39);
		return (generatedString);
	
	}
	
	
	
	
	
}
	

	
	


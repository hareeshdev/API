package practies_GetAPI;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import RestClient.practies_RestClient;
import TestBases.practies_TestBases;
import TestUtil.TestUtils;

public class practies_getAPI extends practies_TestBases{
	practies_TestBases testBases;
	String ServiceUrl;
	String APIUrl;
	String URL;
	CloseableHttpResponse closeableHttpResponse;
	practies_RestClient restClient;
	@BeforeMethod
public void setUp() {
	testBases=new practies_TestBases();
	ServiceUrl=prop.getProperty("URL");
	APIUrl=prop.getProperty("serviceURL");
	//https://reqres.in/api/users
	URL=ServiceUrl+APIUrl;
}
@Test(priority = 0)
public void getAPITestwithoutHeader() throws ClientProtocolException, IOException{
	restClient=new practies_RestClient();
	closeableHttpResponse=restClient.practiceGetCall(URL);
	//status code
int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
System.out.println(statuscode);
	//JSon String
String responceString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
JSONObject responcejson=new JSONObject(responceString);
System.out.println("responce jsonObject:\t"+responcejson);


//per_page
String per_pagevalue=TestUtils.getValueByJPath(responcejson, "/per_page");
System.out.println(per_pagevalue);

//total
String totalValue=TestUtils.getValueByJPath(responcejson, "/total");
System.out.println(totalValue);
//dataArrayObject
//get the value from JSON ARRAY:
		String lastName = TestUtils.getValueByJPath(responcejson, "/data[0]/last_name");
		String id = TestUtils.getValueByJPath(responcejson, "/data[0]/id");
		String avatar = TestUtils.getValueByJPath(responcejson, "/data[0]/avatar");
		String firstName = TestUtils.getValueByJPath(responcejson, "/data[0]/first_name");

		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
	//get All Headers values
		Header [] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String , String> allHeader=new HashMap<String ,String>();
		for(Header header:headersArray) {
			
			allHeader.put(header.getName(), header.getValue());
			
		}
		System.out.println("Headers Array"+allHeader);
		
	
	
	
}

@Test(priority =1)
public void getAPITestwithHeader() throws ClientProtocolException, IOException{
	restClient=new practies_RestClient();
	
	HashMap<String, String> hadermap=new HashMap<String,String>();
	hadermap.put("User-Agent", "PostmanRuntime/7.26.10");
	
	closeableHttpResponse=restClient.practiceGetCallwithHeader(URL,hadermap);
	System.out.println(closeableHttpResponse+"Hareesh");
	//status code
int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
System.out.println(statuscode);
	//JSon String
String responceString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
JSONObject responcejson=new JSONObject(responceString);
System.out.println("responce jsonObject:\t"+responcejson);


//per_page
String per_pagevalue=TestUtils.getValueByJPath(responcejson, "/per_page");
System.out.println(per_pagevalue);

//total
String totalValue=TestUtils.getValueByJPath(responcejson, "/total");
System.out.println(totalValue);
//dataArrayObject
//get the value from JSON ARRAY:
		String lastName = TestUtils.getValueByJPath(responcejson, "/data[0]/last_name");
		String id = TestUtils.getValueByJPath(responcejson, "/data[0]/id");
		String avatar = TestUtils.getValueByJPath(responcejson, "/data[0]/avatar");
		String firstName = TestUtils.getValueByJPath(responcejson, "/data[0]/first_name");

		System.out.println(lastName);
		System.out.println(id);
		System.out.println(avatar);
		System.out.println(firstName);
		
	//get All Headers values
		Header [] headersArray=closeableHttpResponse.getAllHeaders();
		HashMap<String , String> allHeader=new HashMap<String ,String>();
		for(Header header:headersArray) {
			
			allHeader.put(header.getName(), header.getValue());
			
		}
		System.out.println("Headers Array"+allHeader);
		
	
	
	
}


}

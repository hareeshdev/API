package practies_GetAPI;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import RestClient.practies_RestClient;
import TestBases.practies_TestBases;
import Userdata.Userdata;

public class practies_PostAPI extends practies_TestBases{
	practies_TestBases testBases;
   String ServiceURl;
   String PostCallUrl;
   String URL;
   practies_RestClient practies_restclient;
   CloseableHttpResponse closeableHttpResponse;
@BeforeMethod	
public void setUp() {
	testBases=new practies_TestBases();
	ServiceURl=prop.getProperty("URL");
	PostCallUrl=prop.getProperty("serviceURL");
		
		URL=ServiceURl+PostCallUrl;
		}
@Test
public void postAPI() throws JsonGenerationException, JsonMappingException, IOException {
	practies_restclient=new practies_RestClient();
	HashMap<String, String> allHeaders=new HashMap<String, String>();
	allHeaders.put("Content-Type", "application/json");
	System.out.println(allHeaders);
	//jackson API
	ObjectMapper mapper=new ObjectMapper();
	Userdata userdata=new Userdata("Hareesh", "softwareEngineer");
	//object to json file
	mapper.writeValue(new File("\\Users\\Lenovo\\databasesTesting\\practiceGetCall\\src\\main\\java\\Userdata\\Userdata.json"), userdata);
	//java object to json in String:
	
	String userjsonString=mapper.writeValueAsString(userdata);
	System.out.println(userjsonString);
	closeableHttpResponse=practies_restclient.PostCall(URL, userjsonString, allHeaders);
	
	////validate response from API:
	//1. status code:
	
	
	int statuscode=closeableHttpResponse.getStatusLine().getStatusCode();
	System.out.println(statuscode);
	Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_201);
	
	
	//2. JsonString:
	//String responceString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
	String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	JSONObject jsonresponce=new JSONObject(responseString);
	System.out.println("The response from API is\t"+jsonresponce);
	
	//json to java object:
	Userdata userResObj=mapper.readValue(responseString, Userdata.class);//actual users object
	
	System.out.println(userResObj);
	
	Assert.assertTrue(userdata.getName().equals(userdata.getName()));
	
	Assert.assertTrue(userdata.getJob().equals(userdata.getJob()));
	
	System.out.println(userdata.getId());
	System.out.println(userdata.getCreatedAt());
}

}

package RestClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class practies_RestClient {

	public CloseableHttpResponse practiceGetCall(String url) throws ClientProtocolException, IOException {
	CloseableHttpClient closeableHttpClient=HttpClients.createDefault();
	HttpGet httpGet=new HttpGet(url);//http get request
	CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet);
	
	return closeableHttpResponse;
		
	}
	
	public CloseableHttpResponse practiceGetCallwithHeader(String url,HashMap<String, String>hashmap) throws ClientProtocolException, IOException {
		
		
		CloseableHttpClient closeableHttpClient=HttpClients.createDefault();
		HttpGet httpGet=new HttpGet(url);
		
		for(Map.Entry<String,String> entry:hashmap.entrySet()) {
			httpGet.addHeader(entry.getKey(), entry.getValue());
			
		}
		CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpGet);//hit URL
		return closeableHttpResponse;
		
		
	}
	
public CloseableHttpResponse PostCall(String url,String entityString,HashMap<String, String>headers) throws ClientProtocolException, IOException {

	CloseableHttpClient closeableHttpClient=HttpClients.createDefault();		
	
	HttpPost httpPost=new HttpPost(url);
	
	httpPost.setEntity(new StringEntity(entityString));//for payload
	//for header
	
	for(Map.Entry<String , String> entry: headers.entrySet()) {
		httpPost.addHeader(entry.getKey(), entry.getValue());
		
	}
		CloseableHttpResponse closeableHttpResponse=closeableHttpClient.execute(httpPost);
		return closeableHttpResponse;
		
	}

}

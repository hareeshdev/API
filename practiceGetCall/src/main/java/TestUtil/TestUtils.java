package TestUtil;

import org.json.JSONArray;
import org.json.JSONObject;

public class TestUtils {
	public static String getValueByJPath(JSONObject responcejson,String jpath) {
		Object object=responcejson;
		for(String s : jpath.split("/"))
			if(!s.isEmpty())
				if(!(s.contains("[")||s.contains("]")))
					object=((JSONObject)object).get(s);
				else if(s.contains("[") || s.contains("]"))
					object= ((JSONArray) ((JSONObject) object).get(s.split("\\[")[0])).get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		
		return object.toString();
		
	}
}

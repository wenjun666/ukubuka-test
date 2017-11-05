package comparator;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;

public class compareJSON {

	public static boolean compare(File first, File second) throws IOException, JSONException {
		
	    String content = FileUtils.readFileToString(first);
	    
	    // Convert JSON string to JSONObject
	    JSONObject tomJsonObject = new JSONObject(content); 
	    JSONCompareResult result = JSONCompare.compareJSON(tomJsonObject, tomJsonObject, JSONCompareMode.LENIENT);
			
		return !result.failed();
	}
	
}

package comparator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class CompareCSV {
	private static final  String cvsSplitBy = ",";
	
	public boolean compare(File first, File second) {
 
        
        String original_path = first.getPath();
        String output_files = second.getPath();
        HashMap<String, Integer> map = new HashMap<>();
        hash(map, original_path);
        remove(map,output_files);

        Collection<Entry<String, Integer>> values = map.entrySet();
        Iterator<Entry<String, Integer>> iterator = values.iterator();
      
        while(iterator.hasNext()) {
        	Entry<String, Integer> v = iterator.next();
        	if(v.getValue()!=0) {
  		
        		return false;
        	}
        }
        
        return true;

    }
	
	public void hash (HashMap<String, Integer> map, String original_path) {
		String line = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(original_path), "UTF-8"))) {
            while ((line = br.readLine()) != null) {
            	String[] csvRead = line.split(cvsSplitBy);
            	String r="";
            	for(int i =0; i< csvRead.length;i++) {
            		r+=csvRead[i];
            	}
            	r = r.replaceAll("\"","");
                map.put(r, map.getOrDefault(r, 0)+1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	
	
	public void remove(HashMap<String, Integer> map, String original_path) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(original_path), "UTF-8"))) {
        	String line = "";
            while ((line = br.readLine()) != null) {
            	//System.out.println(line);
            	String[] csvRead = line.split(cvsSplitBy);
            	String r="";
            	for(int i =0; i< csvRead.length;i++) {
            		r+=csvRead[i];
            	}
            	r = r.replaceAll("\"","");   
                map.put(r, map.getOrDefault(r, 0)-1);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
		
		
	}
	
	
	
	
	}
	
	

	
	


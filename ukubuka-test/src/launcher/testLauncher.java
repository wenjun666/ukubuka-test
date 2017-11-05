package launcher;
import java.io.File;
import java.util.HashMap;
import comparator.CompareCSV;
import comparator.CompareXML;
import comparator.compareJSON;

public class testLauncher {
	
	public static void main(String[] args) throws Exception {
		//give the path of the test cases folder
	    File[] files = new File("C:\\Users\\wenjun\\Desktop\\Ukubuka\\simpletest").listFiles();
	    new testLauncher().showFiles(files);
	}
	
	
	public void showFiles(File[] files) throws Exception {
		HashMap<Integer, File> map = new HashMap<Integer, File>();
		
	    for (File file : files) {
	        if (file.isDirectory()) {
	            System.out.println("Directory: " + file.getName());
	            showFiles(file.listFiles());
	        } else {
	        	String fileName = file.getName();
	        	String extension = fileName.substring(fileName.lastIndexOf(".")+1);
	        	int number = Integer.parseInt( fileName.substring(0,(fileName.indexOf("_"))));
	        	if(!map.containsKey(number)) {
	        	System.out.println("File: " + file.getName());
	        	map.put(number,file);
	        	}else {
	        	File second = map.get(number);
	            System.out.println("File: " + file.getName());
	            //System.out.println("Extension: " + extension);
	            boolean isEqual = statement(file, second,extension);
	            if(isEqual) {
	            	System.out.println("test case: pass\n");
	            	
	            }else {
	            	System.out.println("test case: fail\n");
	            }
	            
	        	}
	        }
	    }
	    
	    
	}
	
	
	public  boolean statement(File first, File second, String extension) throws Exception{
        switch(extension) {
    	case "csv":
    		return(new CompareCSV().compare(first,second));
		case "xml":
    		return (CompareXML.compare(first, second));
		case "json":
    		return(compareJSON.compare(first, second));
    }
		return false;	
	}
}

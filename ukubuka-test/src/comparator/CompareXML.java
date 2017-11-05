package comparator;

import java.io.File; 
import javax.xml.transform.Source;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.builder.Input;
import org.xmlunit.diff.Diff;


public class CompareXML {

	
	public static boolean compare(File original, File output) throws Exception {
		Source control = Input.fromFile(output).build();
		Source test = Input.fromFile(original).build();
		Diff d = DiffBuilder.compare(control).withTest(test).build();
		
		return !d.hasDifferences();
		
	}
}




/*
DifferenceEngine diff = new DOMDifferenceEngine();
diff.addDifferenceListener(new ComparisonListener() {
        public void comparisonPerformed(Comparison comparison, ComparisonResult outcome) {
           //Assert.fail("found a difference: " + comparison);
        	System.out.println(comparison);
        }
    });
*/
package aggregateOperationsOracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interference {

	public static void main(String[] args) {
		/*Interference
		Lambda expressions in stream operations should not interfere. Interference occurs when the source of a stream is modified while a pipeline processes the stream. For example, the following code attempts to concatenate the strings contained in the List listOfStrings. However, it throws a ConcurrentModificationException:

		*/try {
		    List<String> listOfStrings =
		        new ArrayList<>(Arrays.asList("one", "two"));
		         
		    // This will fail as the peek operation will attempt to add the
		    // string "three" to the source after the terminal operation has
		    // commenced. 
		             
		    String concatenatedString = listOfStrings
		        .stream()
		        
		        // Don't do this! Interference occurs here.
		        .peek(s -> listOfStrings.add("three"))
		        
		        .reduce((a, b) -> a + " " + b)
		        .get();
		                 
		    System.out.println("Concatenated string: " + concatenatedString);
		         
		} catch (Exception e) {
		    System.out.println("Exception caught: " + e.toString());
		}

	}

}

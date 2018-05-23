package streams.filter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Renjith
 * http://www.mkyong.com/java8/java-8-streams-filter-examples/
 * 
 *In this tutorial, we will show you few Java 8 examples
 * to demonstrate the use of Streams filter(), 
 *collect(), findAny() and orElse()
 */
public class BeforeJava8 {

    public static void main(String[] args) {

        List<String> lines = Arrays.asList("spring", "node", "mkyong");
        List<String> result = getFilterOutput(lines, "mkyong");
        for (String temp : result) {
            System.out.println(temp);    //output : spring, node
        }

    }

    private static List<String> getFilterOutput(List<String> lines, String filter) {
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (!"mkyong".equals(line)) { // we dont like mkyong
                result.add(line);
            }
        }
        return result;
    }

}
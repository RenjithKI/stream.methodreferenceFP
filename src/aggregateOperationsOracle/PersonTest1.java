
package aggregateOperationsOracle;
import java.util.List;

public class PersonTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Person> roster  = Person.createRoster();
		
		for (Person p : roster) {
		    System.out.println(p.getName());
		}
		
		System.out.println("__________________________________-");
		
		for (Person p : Person.createRoster()   ) {
		    System.out.println(p.getName());
		}
		
		// stream 
		System.out.println("_________________stream_________________-");
		
		roster
	    .stream()
	    .forEach(e -> System.out.println(e.getName()) );

	}

}

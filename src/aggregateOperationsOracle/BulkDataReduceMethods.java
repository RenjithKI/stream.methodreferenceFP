package aggregateOperationsOracle;
/*
 *https://docs.oracle.com/javase/tutorial/collections/streams/
 */ 

import java.lang.Iterable;
import java.lang.Number;
import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Renjith
 *The JDK contains many terminal operations (such as average, sum, min, max, and count) that return one value by combining the contents of a stream. 
 *These operations are called reduction operations. The JDK also contains reduction operations that return a collection instead of a single value.
 * Many reduction operations perform a specific task, such as finding the average of values or grouping elements into categories. 
 *However, the JDK provides you with the general-purpose reduction operations reduce and collect, which this section describes in detail.
 *
 *
 */
public class BulkDataReduceMethods {






	public static void main(String... args) {

		// Create sample data

		List<Person> roster = Person.createRoster();

		// 1. Print names of members, for-each loop

		System.out.println(" such as average, sum, min, max, and count  ");
		double average = roster
				.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.mapToInt(Person::getAge)
				.average()
				.getAsDouble();     

		System.out.println(
				"Male members age average:________________>"+average);

		// 2. Print total age 
		Integer totalAge = roster
				.stream()
				.mapToInt(Person::getAge)
				.sum();

		System.out.println("totalAge using sum method _____>"+ totalAge );

		// 3. reduce method 

		Integer totalAgeReduce = roster
				.stream()
				.map(Person::getAge)
				.reduce(0, (a, b) -> a + b);// 0 is offset initial valuue

		System.out.println("totalAge using reduce method _____>"+ totalAgeReduce );

		Integer totalAgeReduce2 = roster
				.stream()
				.map(Person::getAge)
				.reduce(1, (a, b) -> a + b);// 0 is offset initial valuue

		System.out.println("totalAge using reduce method _____>"+ totalAgeReduce2 );
		////////////////////////////////////////

		// The following pipeline uses the Averager class and the collect method to calculate the average age of all male members:

		Averager averageCollect = roster.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(Person::getAge)
				.collect(Averager::new, Averager::accept, Averager::combine);

		System.out.println("Average age of male members: " +
				averageCollect.average());

		//The collect operation is best suited for collections. The following example puts the names of the male members in a collection with the collect operation:

		List<String> namesOfMaleMembersCollect = roster
				.stream()
				.filter(p -> p.getGender() == Person.Sex.MALE)
				.map(p -> p.getName())
				.collect(Collectors.toList());


		System.out.println("collect to a collection here male names only: " +
				namesOfMaleMembersCollect);
		//The following example groups members of the collection roster by gender:

		Map<Person.Sex, List<Person>> byGender = roster
				.stream()
				.collect(
						Collectors.groupingBy(Person::getGender));

		System.out.println("groups members of the collection roster by gender to a MAP: " +
				byGender.keySet());
		List<Person>  xx = byGender.get(Person.Sex.MALE);
		xx.forEach(System.out::println);
		xx.forEach(x -> x.toString());
		
		//
		/*The following example retrieves the names of each member in the collection roster and groups them by gender:*/
		
		System.out.println("__________________________Level up ______________________________");

			Map<Person.Sex, List<String>> namesByGender =
			    roster
			        .stream()
			        .collect(
			            Collectors.groupingBy(
			                Person::getGender,                      
			                Collectors.mapping(Person::getName, Collectors.toList())
			                ));
			
			namesByGender.entrySet().forEach(System.out::println);


	}
}
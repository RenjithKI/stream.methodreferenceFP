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
import java.util.concurrent.ConcurrentMap;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Renjith
 *The following is the parallel equivalent:
ConcurrentMap<Person.Sex, List<Person>> byGender =
    roster
        .parallelStream()
        .collect(
            Collectors.groupingByConcurrent(Person::getGender));
This is called a concurrent reduction. The Java runtime performs a concurrent reduction if all of the the following are true for
 a particular pipeline that contains the collect operation:

The stream is parallel.
The parameter of the collect operation, the collector, has the characteristic Collector.Characteristics.CONCURRENT. 
To determine the characteristics of a collector, invoke the Collector.characteristics method.
Either the stream is unordered, or the collector has the characteristic Collector.Characteristics.UNORDERED. 
To ensure that the stream is unordered, invoke the BaseStream.unordered operation.
 *
 */
public class BulkDataReducePareallelism {

	public static void main(String... args) {

		// Create sample data

		List<Person> roster = Person.createRoster();

		//2. The following example groups members of the collection roster by gender:

		Map<Person.Sex, List<Person>> byGender = roster
				.stream()
				.collect(
						Collectors.groupingBy(Person::getGender));

		System.out.println("groups members of the collection roster by gender to a MAP: serial way " +
				byGender.keySet());
		byGender.entrySet().forEach(System.out::println);
		/*List<Person>  xx = byGender.get(Person.Sex.MALE);
		xx.forEach(System.out::println);
		xx.forEach(x -> x.toString());*/
		
		//
		/*The following example retrieves the names of each member in the collection roster and groups them by gender:*/
		
		System.out.println("______________________PArallism____________________________");

		ConcurrentMap<Person.Sex, List<Person>> byGenderParellel =
			    roster
			        .parallelStream()
			        .collect(
			            Collectors.groupingByConcurrent(Person::getGender));
			
		byGenderParellel.entrySet().forEach(System.out::println);


	}
}
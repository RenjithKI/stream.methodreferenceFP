package aggregateOperationsOracle;
/*
 *https://docs.oracle.com/javase/tutorial/collections/streams/
 */ 

import java.lang.Iterable;
import java.lang.Number;
import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Renjith
 *A stream is a sequence of elements. Unlike a collection, 
 *it is not a data structure that stores elements. Instead, 
 *a stream carries values from a source through a pipeline. This example creates 
 *a stream from the collection roster by invoking the method stream.
 */
public class BulkDataOperationsExamples2 {
    
    public static void main(String... args) {
        
        // Create sample data

        List<Person> roster = Person.createRoster();
        
        // 1. Print names of members, for-each loop
        
        System.out.println("Members of the collection (for-each loop):");
        for (Person p : roster) {
            System.out.println(p.getName());
        }
        
        // 2. Print names of members, forEach operation
        
        System.out.println("Members of the collection (bulk data operations):");
        roster
            .stream()
            .forEach(e -> System.out.println(e.getName()));
            
        // 3. Print names of male members, forEach operation

        System.out.println(
            "Male members of the collection (bulk data operations):________________");
        roster
            .stream()
            .filter(e -> true)//e.getGender() == Person.Sex.MALE
            .forEach(e -> System.out.println(e.getName()));
            
        // 4. Print names of male members, for-each loop 

        System.out.println("Male members of the collection (for-each loop):");
        for (Person p : roster) {
            if (p.getGender() == Person.Sex.MALE) {
                System.out.println(p.getName());
            }
        }
         
        // 5. Get average age of male members of the collection:
        
        double average = roster
            .stream()
            .filter(p -> p.getGender() == Person.Sex.MALE)
            .mapToInt(Person::getAge)
            .average()
            .getAsDouble();
        
        double average2 = roster
                .stream()
                .filter(p -> p.getGender() == Person.Sex.MALE)
                .mapToInt(Person::getAge)
                .average()
                .getAsDouble();
            
        System.out.println(
            "Average age of male members (bulk data operations): " +
            average);
    }
}
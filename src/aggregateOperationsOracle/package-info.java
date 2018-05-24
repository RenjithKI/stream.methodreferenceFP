/**
 * 
 */
/**
 * @author Renjith
 *https://docs.oracle.com/javase/tutorial/collections/streams/
 */
package aggregateOperationsOracle;


/*A pipeline contains the following components:

A source: This could be a collection, an array, a generator function, or an I/O channel. In this example, the source is the collection roster.

Zero or more intermediate operations. An intermediate operation, such as filter, produces a new stream.

A stream is a sequence of elements. Unlike a collection, it is not a data structure that stores elements. Instead, a stream carries values from a source through a pipeline. This example creates a stream from the collection roster by invoking the method stream.

The filter operation returns a new stream that contains elements that match its predicate (this operation's parameter). In this example, the predicate is the lambda expression e -> e.getGender() == Person.Sex.MALE. It returns the boolean value true if the gender field of object e has the value Person.Sex.MALE. Consequently, the filter operation in this example returns a stream that contains all male members in the collection roster.

A terminal operation. A terminal operation, such as forEach, produces a non-stream result, such as a primitive value (like a double value), a collection, or in the case of forEach, no value at all. In this example, the parameter of the forEach operation is the lambda expression e -> System.out.println(e.getName()), which invokes the method getName on the object e. (The Java runtime and compiler infer that the type of the object e is Person.)

*/

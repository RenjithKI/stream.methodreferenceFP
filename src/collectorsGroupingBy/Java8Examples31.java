package collectorsGroupingBy;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Renjith
 * >>>>>>>>>>>counting>
{papaya=1, banana=2, apple=3, orang=1, watermelon=1}
>>>>>>>>>>>sum>
{papaya=20, banana=30, apple=40, orang=10, watermelon=10}
 *
 */
public class Java8Examples31 {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item2> items = Arrays.asList(
                new Item2("apple", 10, new Long("9.99")),
                new Item2("banana", 20, new Long("19.99")),
                new Item2("orang", 10, new Long("29.99")),
                new Item2("watermelon", 10, new Long("29.99")),
                new Item2("papaya", 20, new Long("9.99")),
                new Item2("apple", 10, new Long("9.99")),
                new Item2("banana", 10, new Long("19.99")),
                new Item2("apple", 20, new Long("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item2::getName, Collectors.counting()));
        System.out.println(">>>>>>>>>>>counting>");
        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item2::getName, Collectors.summingInt(Item2::getQty)));
        System.out.println(">>>>>>>>>>>sum>");
        System.out.println(sum);
        
        //Long
        Map<String, Long> price = 
        items.stream().collect(
                Collectors.groupingBy(Item2::getName, Collectors.summingLong(Item2::getPrice)));
        System.out.println(">>>>>>>>>>>price>");
        System.out.println(price);

    }
}
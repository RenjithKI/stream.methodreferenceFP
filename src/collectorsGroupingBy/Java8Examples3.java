package collectorsGroupingBy;

import java.math.BigDecimal;
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
public class Java8Examples3 {

    public static void main(String[] args) {

        //3 apple, 2 banana, others 1
        List<Item> items = Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99") ),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orang", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );

        Map<String, Long> counting = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.counting()));
        System.out.println(">>>>>>>>>>>counting>");
        System.out.println(counting);

        Map<String, Integer> sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println(">>>>>>>>>>>sum>");
        System.out.println(sum);
        
        
       /* Map<String, Integer> price = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingLong(Item::getPrice)));
        System.out.println(">>>>>>>>>>>price>");
        System.out.println(price);*/

    }
}
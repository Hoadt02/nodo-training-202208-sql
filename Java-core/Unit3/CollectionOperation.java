package main.java;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(4,7,1,3,8,9,2,6,1,10));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(listOfIntegers, comparator);

        listOfIntegers.stream()
                .filter(v -> v > 5)
                .forEach(v -> System.out.println(v));

        /*Collector<Integer, ? , IntSummaryStatistics> collector = Collectors.summarizingInt(Integer::intValue);*/

        List list = new ArrayList();
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value = " +n);
            if (n < 5){
                System.out.println("Invalid value!");
                return;
            }
            list.add(n);
            System.out.println("values: " + list.get(list.size() - 1));
            listOfIntegers.forEach(x -> System.out.println(x + "-"));
        };
        myConsumer.accept(12);

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("PLease input a number: ");
            Integer value = scanner.nextInt();
            myConsumer.accept(value);
            System.out.println();
        }

       /* Predicate<Integer> tester = v -> v > 5;
        Consumer<Integer> myConsumer2 = n -> listOfIntegers.add(n);
        while(true){
            System.out.println("PLease input a number: ");
            int value = scanner.nextInt();
            if (value < 0){
                break;
            }
            if (tester.test(value)){
                myConsumer2.accept(value);
            }
        }
        listOfIntegers.forEach(x -> System.out.println(x + "-"));*/
    }
}

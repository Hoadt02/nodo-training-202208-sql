package Chuong3_Collection;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectionOperation {
    public static void main(String[] args) {
        example5();
    }

    private static void example5() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        Predicate<Integer> tester = v -> v > 5;
        Consumer<Integer> myConsumer = n -> listOfIntegers.add(n);

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("Please input a number: ");
            int value = scanner.nextInt();
            if (value < 0){
                break;
            }
            if (tester.test(value)){
                myConsumer.accept(value);
            }
        }
        listOfIntegers.forEach(x -> System.out.print(x + "-"));
    }

    private static void example4() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value!");
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: " + listOfIntegers.get(listOfIntegers.size() - 1));
            listOfIntegers.forEach(x -> System.out.print(x + "-"));
        };
        myConsumer.accept(12);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("PLease input a number: ");
            Integer value = scanner.nextInt();
            myConsumer.accept(value);
            System.out.println();
        }
    }

    private static void example3() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11));
        Consumer<Integer> myConsumer = n -> {
            System.out.println("user input value = " + n);
            if (n < 5) {
                System.out.println("Invalid value!");
                return;
            }
            listOfIntegers.add(n);
            System.out.println("values: " + listOfIntegers.get(listOfIntegers.size() - 1));
            listOfIntegers.forEach(x -> System.out.print(x + "-"));
        };
        myConsumer.accept(12);
    }

    private static void example1() {
        List<Integer> listOfIntegers = new ArrayList<>(Arrays.asList(4, 7, 1, 3, 8, 9, 2, 6, 1, 10));
        Comparator<Integer> comparator = Integer::compare;
        Collections.sort(listOfIntegers, comparator);

        listOfIntegers.stream()
                .filter(v -> v > 5)
                .forEach(v -> System.out.println(v));
    }
}

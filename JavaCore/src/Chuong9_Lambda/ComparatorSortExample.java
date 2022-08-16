package Chuong9_Lambda;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorSortExample {
    public static void main(String[] args) {
        example2();
    }

    private static void example2() {
        Integer[] values = {12,345,34,7,9,12,9};

        Arrays.sort(values,(Integer o1, Integer o2) -> {
            return o2-o1;
        });
        for (Integer x: values) {
            System.out.print(x + ", ");
        }
    }

    private static void example1() {
        Integer[] values = {12,345,34,7,9,12,9};

        Arrays.sort(values, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        for (Integer x: values) {
            System.out.print(x + ", ");
        }
    }
}

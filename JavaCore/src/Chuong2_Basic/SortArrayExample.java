package Chuong2_Basic;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayExample {
    public static void main(String[] args) {
        Integer[] mang = {1,5,8,9,3,2};
        Arrays.sort(mang);
        for (Integer x : mang) {
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println("=====================");

        Arrays.sort(mang, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer x : mang) {
            System.out.print(x + " ");
        }
    }
}

package main.java;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample2 {
    public static void main(String[] args) {
        String[] mang = {"vinh", "hòa", "phương", "thụy", "hiên", "sơn"};
        List<String> list = new LinkedList<>(Arrays.asList(mang));

        list.forEach(value -> {
            System.out.println(value);
        });
    }
}

package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExamole1 {
    public static void main(String[] args) {
        Short[] values = {1,2,3,4,5,6,7,8,9};
        List<Short> list = new ArrayList<>();
        Collections.addAll(list, values);
        Collections.reverse(list);
        list.toArray(values);
        for (Short s: values) {
            System.out.println( s +", ");
        }
    }
}

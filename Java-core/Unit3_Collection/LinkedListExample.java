package main.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        String[] mang = {"vinh", "hòa", "phương", "thụy", "hiên", "sơn"};

        for (String ele:mang) {
            list.add(ele);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println("===> " + iterator.next());
        }
    }
}

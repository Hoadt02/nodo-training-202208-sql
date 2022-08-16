package Chuong3_Collection;

import java.util.Hashtable;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new Hashtable<>();
        map.put(3, "Nguyen Van A");
        map.put(1,"Nguyen Van B");
        map.put(2,"Nguyen Van C");
        map.put(4, "Nguyen Van X");

        System.out.println(map.get(3));

        map.put(3, "Nguyen Thi A");
        System.out.println(map.get(3));

        map.forEach( (k,v) -> {
            System.out.println(k + "," + v);
        });
    }
}

package Chuong10_collection;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class SynchronizedExample {

    public static void main(String[] args) {
        List<List<Integer>> values = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<Integer> list = new ArrayList<>();
            new Thread(() -> addData(list)).start();
            new Thread(() -> addData(list)).start();
            values.add(list);
        }
        try {
            Thread.sleep(5000);
            values.forEach(list -> {
                System.out.println("Number items of list ---> " + list.size());
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addData(List<Integer> list){
        IntStream.range(0,1000).forEach(index ->{
            try {
                list.add(index);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }
}

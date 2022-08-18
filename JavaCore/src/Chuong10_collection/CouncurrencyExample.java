package Chuong10_collection;

import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.List;

public class CouncurrencyExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        new Thread(() -> addData(list)).start();
        new Thread(() -> println(list)).start();
    }

    public static void println(List<Integer> list){
        while (true){
            try {
                System.out.println("===============================");
                list.forEach(value -> System.out.println("value = " + value));
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
                return;
            }
        }
    }

     public static void addData(List<Integer> list){
        while (true){
            int random = (int) (Math.random() * 100);
            list.add(random);
            System.out.println("Add new data: " + random);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
     }
}

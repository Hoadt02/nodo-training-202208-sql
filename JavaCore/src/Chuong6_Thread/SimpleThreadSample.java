package Chuong6_Thread;

import java.util.Arrays;

public class SimpleThreadSample {
    public static void main(String[] args) {
        Integer[] numbers = {1,4,7,9,2,4,5,6,7,2,3};
        new Thread(
                () -> {
                    Arrays.stream(numbers).forEach(ele ->{
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.println(ele);
                    });
                }
        ).start();
    }
}

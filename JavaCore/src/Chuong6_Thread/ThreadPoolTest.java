package Chuong6_Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ThreadPoolTest {
    public static void main(String[] args) {
        PrintNumber3 number3 = new PrintNumber3();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        IntStream.range(0,6).forEach(i -> executorService.submit(number3));
    }
}

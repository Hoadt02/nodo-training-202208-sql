package Chuong6_Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class ExecuteServiceTest {
    public static void main(String[] args) throws Exception {
        PrintNumber3 number3 = new PrintNumber3();
        Callable<Object> value = Executors.callable(number3);
        System.out.println(" main say hello");
        value.call();
        System.out.println(" main say goodbye");
    }
}

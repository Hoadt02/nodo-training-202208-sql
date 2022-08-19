package Chuong6_Thread;

import java.util.concurrent.TimeUnit;

public class ThreadNumberTest {
    public static void main(String[] args) throws InterruptedException {
       example3();
    }

    private static void example3() {
        PrintNumber3 number = new PrintNumber3();

        Thread thread = new Thread(number);
        thread.setName("FSoft_Thread 1");
        thread.start();

        Thread thread2 = new Thread(number);
        thread2.setName("FSoft_Thread 2");
        thread2.start();
    }

    private static void example2() throws InterruptedException {
        PrintNumber2 number = new PrintNumber2();

        Thread thread = new Thread(number);
        thread.setName("Hanoi_Thread");
        thread.start();

        Thread.currentThread().join();
        System.out.println("Main Thread say hello");
        System.out.println("Main Thread say goodbye");
    }

    private static void example1() throws InterruptedException {
        PrintNumber number = new PrintNumber();

        Thread thread = new Thread(number);
        thread.setName("Hanoi_Thread");
        thread.start();

        Thread.currentThread().join();

        while (thread.isAlive()){
            if (number.getNumber()%10 == 0) number.setAlive(false);
//            Thread.sleep(1000);
            TimeUnit.SECONDS.sleep(1);
        }
    }
}

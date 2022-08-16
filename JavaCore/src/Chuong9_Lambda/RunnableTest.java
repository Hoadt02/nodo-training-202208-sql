package Chuong9_Lambda;

public class RunnableTest {
    public static void main(String[] args) {
        example3();
    }

    private static void example3() {
        new Thread(
                () -> {
                    System.out.println(Thread.currentThread().getName() + " say hello Java class!");
                    System.out.println("1 + 1 = " + (1 + 1));
                }
        ).start();
    }

    private static void example2() {
        new Thread(
                () -> System.out.println(Thread.currentThread().getName() + " say hello Java class!")
        ).start();
    }

    private static void example1() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " say hello Java class!");
            }
        };
        new Thread(runnable).start();
    }
}

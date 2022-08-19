package Chuong6_Thread;

public class PrintNumber2 implements Runnable{
    private int number = 1;

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (number < 10){
            number++;
            System.out.println(current.getName() + " number is \"" + number + "\"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(current.getName() + " is stoped!");
    }
}

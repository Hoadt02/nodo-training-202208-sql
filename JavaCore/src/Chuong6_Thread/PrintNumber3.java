package Chuong6_Thread;

public class PrintNumber3 implements Runnable{

    private  Integer number = Integer.valueOf(1);

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (true){
            number++;
            System.out.println(current.getName() + " number is \"" + number + "\"");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (number % 10 == 0) break;
        }
        System.out.println(current.getName() + " is stoped!");
    }
}

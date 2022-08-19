package Chuong6_Thread;

public class PrintNumber implements Runnable{
    private int number = 1;
    private boolean alive = true;

    public int getNumber(){
        return number;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

    @Override
    public void run() {
        Thread current = Thread.currentThread();
        while (alive){
            number++;
            System.out.println(current.getName() + " number is \"" + number + "\"");
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(current.getName() + " is stoped!");
    }
}

package Chuong1_Basic.controller;

public class SwitchExample {
    public static void main(String[] args) {
        demo(new String[]{"0"});
    }

    private static void demo(String[] args) {
        int value = Integer.parseInt(args[0]);
        switch (value){
            case 0:
                System.out.println("bad");
                break;
            case 1:
                System.out.println("ok");
                break;
            default:
                System.out.println("invalid");
                break;
        }
    }
}

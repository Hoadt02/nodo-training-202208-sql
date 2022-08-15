package main.controller;

public class IfElseExample {
    public static void main(String[] args) {
      demo(new String[]{"6"});
    }

    private static void demo(String[] args) {
        int value = Integer.parseInt(args[0]);
        if (value < 5){
            System.out.println("bad");
        }else {
            System.out.println("ok");
        }
    }
}

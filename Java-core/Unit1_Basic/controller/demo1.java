package main.controller;

import java.util.Arrays;

public class demo1 {
    public static class HelloJava {
        public static void main(String[] args) {
    //        myProgram();
    //        myPrgram(new String[]{"say", "goodbye","to","you"});
    //        streamPrgram(new String[]{"Hòa","Hiên","Vinh","Phương"});
    //        numberExample(new String[]{"8","3"});
        }

        private static void numberExample(String[] args) {
            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);

            System.out.println("Subtraction example: " + (number1 - number2));
            System.out.println("Relational example: " + "number1 > number2 = " + (number1 > number2));
        }

        private static void streamPrgram(String args[]) {
            Arrays.stream(args).forEach((String value) ->{
                System.out.println("value is " + value);
            });
        }

        public static void myPrgram(String[] args){
            System.out.println("The number of arguments is " + args.length);
            for (int i = 0; i < args.length; i++) {
                System.out.println("Value at " + i + " is " + args[i]);
            }
        }

        public static void myProgram() {
            System.out.println("Say hello to Java");
            System.out.println("Total = " + "5" + "7");
        }
    }
}

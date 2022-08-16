package Chuong1_Basic.controller;

public class StringExample1 {
    public static void main(String[] args) {
        String text = "say hello to everyone";
        System.out.println("length of text is " + text.length());
        System.out.println("Vị trí của từ hello là: " + text.indexOf("hello"));
        System.out.println("Cắt từ: " + text.substring(4,8));

        int i = 0;
        while (i < text.length()){
            char c = text.charAt(i);
            if (c == ' '){
                i++;
                continue;
            }
            System.out.println("Character at " + i + " is " + c);
            i++;
        }
    }
}

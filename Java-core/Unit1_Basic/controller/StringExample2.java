package main.controller;

public class StringExample2 {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        String text = new String(chars);
        System.out.println(text);

        text = text.concat(" ");
        text = text.concat("java");
        System.out.println("new value is " + text);

        System.out.println(new String("hello java").equals(text));
    }
}

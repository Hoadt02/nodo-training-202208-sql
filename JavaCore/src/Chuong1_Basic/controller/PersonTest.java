package Chuong1_Basic.controller;

import main.model.Person;

public class PersonTest {
    public static void main(String[] args) {
        test(new String[]{"Hòa","Vinh"});
    }

    private static void test(String[] args) {
        Person person1 = new Person(args[0]);
        Person person2 = new Person(args[1]);

        System.out.println("Person1's name is " + person1.getName());
        System.out.println("Person2's name is " + person2.getName());
    }
}

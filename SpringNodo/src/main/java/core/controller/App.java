package controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
        obj.printMessage();
        System.out.println(obj);

        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
        obj2.printMessage();
        System.out.println(obj2 == obj2);
    }
}

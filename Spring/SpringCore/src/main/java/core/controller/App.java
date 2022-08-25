package core.controller;

import core.model.HelloClazz;
import core.model.HelloWorld;
import core.model.JavaClazz;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final static Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

//        HelloClazz obj = (HelloClazz) context.getBean("helloJavaClazz");
//        obj.printMessage();
////        System.out.println(obj);
//
//        HelloClazz obj2 = (HelloClazz) context.getBean("helloJavaClazz");
//        obj2.printMessage();
////        System.out.println(obj == obj2);
//
//        HelloClazz obj3 = (HelloClazz) context.getBean("helloJavaClazz2");
//        obj3.printMessage();

//        HelloWorld obj4 = (HelloWorld) context.getBean("helloWorld");
//        obj4.sayHello();

//        JavaClazz clazz = (JavaClazz) context.getBean("jee01");
//        LOGGER.info("Map implement is " + clazz.getStudents().getClass());
//        LOGGER.info("There are " + clazz.getStudents().size() + " in the class");

//        HelloClazz clazz = (HelloClazz) context.getBean("helloJavaClazz");
//        LOGGER.info("Total classes is " + clazz.getClazzes().size());

        context.start();
    }
}

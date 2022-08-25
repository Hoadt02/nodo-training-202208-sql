package core.controller;

import core.config.AppConfig;
import core.model.HelloClazz;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App2 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();
        HelloClazz myBean = (HelloClazz) context.getBean("bean2");
        myBean.printMessage();

        HelloClazz myBean2 = (HelloClazz) context.getBean("bean2");
        myBean.printMessage();

        System.out.println(myBean2 == myBean);
    }
}

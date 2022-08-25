package core.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
    @Bean(name="bean2")
    @Scope("prototype")
    public HelloClazz getHelloBean(){
        HelloClazz bean = new HelloClazz();
        bean.message = "Xin chao lop hoc Java";
        return bean;
    }
}

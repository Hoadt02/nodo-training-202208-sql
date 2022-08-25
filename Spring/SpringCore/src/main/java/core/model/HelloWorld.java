package core.model;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

public class HelloWorld {
    private final static Logger LOGGER = Logger.getLogger(HelloWorld.class);
    private String message;

    @Autowired(required = true)
    @Qualifier("helloJavaClazz2")
    private HelloClazz clazz;

    public void sayHello(){
        clazz.printMessage();
        LOGGER.info("From HelloWorld: " + message);
    }

    public String getMessage() {
        return message;
    }

    @Required
    public void setMessage(String message) {
        this.message = message;
    }

    public HelloWorld(String name, HelloClazz clazz){
        this.message = "From HelloWorld contructor: " + name + " : " + clazz.getMessage();
    }

    public HelloWorld(){}

    public HelloClazz getClazz() {
        return clazz;
    }

    public void setClazz(HelloClazz clazz) {
        this.clazz = clazz;
    }
}

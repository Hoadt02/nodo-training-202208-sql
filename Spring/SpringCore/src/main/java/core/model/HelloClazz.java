package core.model;

import java.util.List;

public class HelloClazz {

    public String message;

    public void printMessage(){
        System.out.println("Your Message: " + message);
    }

    public void initMessage(){
        System.out.println("Calling init method....");
        message = "From init method: Say hello bean!";
    }

    public HelloClazz() {
        this.message = "From Contructor: Say hello everyone!";
    }

    public HelloClazz(int person) {
        this.message = "From Contructor: Say hello to " + person + " person(s)";
    }

    public HelloClazz(HelloClazz clazz) {
        this.message = clazz.message;
    }

    public HelloClazz(String message) {
        this.message = message;
    }

    private void release(){
        this.message = null;
        System.out.println("Message is null");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message){
        this.message = "Call From Setter: " + message;
    }

    private List<JavaClazz> clazzes;

    public List<JavaClazz> getClazzes() {
        return clazzes;
    }

    public void setClazzes(List<JavaClazz> clazzes) {
        this.clazzes = clazzes;
    }
}

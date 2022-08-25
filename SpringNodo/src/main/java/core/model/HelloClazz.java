package core.controller;

public class HelloClazz {
    String message;

    public void setMessage(String message){
        this.message = message;
    }

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
}

package Chuong2_Basic;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThrowableExample {

    public static class SaiSoException extends Exception{
        private String so;

        public SaiSoException(String value){
            this.so = value;
        }

        public String getMessage(){
            return "Gia tri \'" +  so  +"\'khong phai la so!";
        }
    }

    public static void main(String[] args) {
//        try {
//            System.out.println("Number = " + toNumber("dddd"));
//        }catch (SaiSoException e){
//            System.err.println(e.getMessage());
//        }
        try {
            System.out.println("Number= " + toNumber("tret"));
        }catch (SaiSoException e){
            LOGGER.log(Level.WARNING,e.getMessage());
        }
    }

    private static int toNumber(String value) throws SaiSoException{
        try {
            Integer integer = Integer.parseInt(value);
            return integer.intValue();
        }catch (NumberFormatException e){
            throw new SaiSoException(value);
        }
    }

    private final static Logger LOGGER = Logger.getLogger(ThrowableExample.class.getName());

}

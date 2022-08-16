package Chuong2_Basic;

import org.w3c.dom.css.Counter;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class CharacterExample {
    public static void main(String[] args) {
        System.out.println("There are " + countDigit2("Đỗ Tất Hòa 1235") + " digits in the text");
    }

    private static int countDigit(String value){
        int i = 0;
        int counter = 0;
        while (i < value.length()){
            char c = value.charAt(i);
            if (Character.isDigit(c)){
                counter++;
            }
            i++;
        }
        return counter;
    }

    private static int countDigit2(String value){
        AtomicInteger counter = new AtomicInteger(0);
        IntStream stream = value.chars();
        stream.forEach(c -> {
            if (Character.isDigit(c)){
                counter.incrementAndGet();
            }
        });
        return counter.get();
    }
}

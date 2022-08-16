package Chuong2_Basic;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamArrayExample {
    public static void main(String[] args) {
        example3();
    }

    public static void example3(){
        Integer[] values = {2,4,7,1,3,5,9,11,3};
        Stream<Integer> stream = Arrays.stream(values);

        Predicate<Integer> predicate = (Integer value) -> {
            return value > 5;
        };

        stream.filter(predicate)
              .forEach((Integer value) -> {
            System.out.println(value);
        });
    }

    public static void example2(){
        Integer[] values = {2,4,7,1,3,5,9,11,3};
        Stream<Integer> stream = Arrays.stream(values);
        // max value
        Optional<Integer> max = stream.max((Integer o1, Integer o2) -> {
            return o1-o2;
        });
        System.out.println(max.get());
    }

    public static void example1(){
        Integer[] values = {2,4,7,1,3,5,9,11,3};
        Arrays.sort(values, (Integer o1, Integer o2) -> {
            return o2-o1;
        });
        //xuất dữ liệu bằng steam
        Stream<Integer> stream = Arrays.stream(values);
//        stream.forEach(value -> System.out.println(value));

        //lưu thao tác vào consumer rồi gọi ra thực thi
        Consumer<Integer> c = (Integer value) -> {
            System.out.println(value);
        };
//        stream.forEach(c);
    }
}

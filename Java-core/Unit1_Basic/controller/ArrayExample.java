package main.controller;

public class ArrayExample {
    public static void main(String[] args) {
        float[] values = {4.5f, 5.5f};
        float total = 0;
        for (float value:values) {
            total += value;
        }
        System.out.println("The total value of array is " + total);
        System.out.println("Average value: " + (total/values.length));

        float max = values[0];
        for (int i = 0; i < values.length; i++) {
            if (max < values[i]) {
                max = values[i];
            }
        }
        System.out.println("Giá trị lớn nhất = " + max);
    }
}

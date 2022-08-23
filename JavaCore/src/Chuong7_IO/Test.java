package Chuong7_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\Test.txt");

        if (!file.exists()) file.createNewFile();

        FileInputStream input = new FileInputStream(file);
        FileOutputStream output = new FileOutputStream(file);

        String write = "Do Tat Hoa 3";
        output.write(write.getBytes());
        output.close();

        int c = input.read();
        while (input.read() != -1){
            System.out.print((char) c);
             c = input.read();
        }
        input.close();
    }
}

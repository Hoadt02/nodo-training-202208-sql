package Chuong7_IO;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessExample {
    public static void main(String[] args) {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\io_sample.txt");
        try(RandomAccessFile randomAccess = new RandomAccessFile(file,"rw")) {
            randomAccess.seek(3);
            byte[] bytes = new byte[4*1024];
            int read = randomAccess.read(bytes);
            System.out.println(new String(bytes,0,read,"utf8"));

            randomAccess.seek(file.length());
            randomAccess.write("\r\n".getBytes());
            randomAccess.writeChars("Hello Co Can");

            Desktop.getDesktop().open(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

package Chuong7_IO;

import java.awt.*;
import java.io.*;

public class ReaderWriterExample {
    public static void main(String[] args) {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\io_sample.txt");
        try (FileWriter writer = new FileWriter(file)){
            writer.write("\r\n");
            writer.write("Tran Thi B");
            Desktop.getDesktop().open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        try {
            FileReader reader = new FileReader(file);
            char[] buffer = new char[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = reader.read(buffer)) != -1){
                builder.append(buffer,0,read);
            }
            System.out.println(builder);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

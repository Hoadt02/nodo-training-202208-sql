package Chuong7NIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;

public class LinkFileExample {
    public static void main(String[] args) throws IOException{
        Path soure = Paths.get( "D:\\Nodo - Work\\Java core\\Temp\\hanoijava.txt");
        Path target = Paths.get("D:\\Nodo - Work\\Java core\\Temp2\\hanoijava.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(soure,Charset.defaultCharset(), StandardOpenOption.APPEND)){
            writer.write("Java NIO 2 example \r\n");
        }

        try(BufferedReader reader = Files.newBufferedReader(target,Charset.defaultCharset())) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}

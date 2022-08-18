package Chuong7NIO;

import javax.xml.transform.Source;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class CopingAndMovingExample {
    public static void main(String[] args) throws IOException {
        create();
    }

    private static void create() throws IOException {
        Path soure = Paths.get( "D:\\Nodo - Work\\Java core\\Temp\\hanoijava.txt");
        Path target = Paths.get("D:\\Nodo - Work\\Java core\\Temp2\\hanoijava.txt");
        Files.createLink(target,soure);
    }

    private static void delete() throws IOException {
        Path target = Paths.get("D:\\Nodo - Work\\Java core\\Temp2\\hanoijava.txt");
        Files.delete(target);
    }

    private static void coping() throws IOException {
        Path soure = Paths.get( "D:\\Nodo - Work\\Java core\\Temp\\hanoijava.txt");
        Path target = Paths.get("D:\\Nodo - Work\\Java core\\Temp2\\hanoijava.txt");

        Files.copy(soure,target, StandardCopyOption.REPLACE_EXISTING);
    }
}

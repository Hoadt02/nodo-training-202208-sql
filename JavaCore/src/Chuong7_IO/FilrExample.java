package Chuong7_IO;

import java.io.File;

public class FilrExample {
    public static void main(String[] args) {
        //example 1
        File file = new File("D:\\Nodo - Work\\Java core\\Temp");
        if (!file.isFile()){
            System.out.println("This is folder");
        }else {
            System.out.println("This is file");
        }

        file = new File("D:\\Nodo - Work\\Java core\\Temp");
        System.out.println("This is " + (file.isFile() ? "file":"folder") + "!");
        System.out.println();

        //example 2
        file = new File(("D:\\Nodo - Work\\Java core\\Unit16.2"));
        File[] files = file.listFiles();
        for (File f: files) {
            System.out.println(f.getName());
        }

        System.out.println();
        for (File f: files) {
            System.out.println(f.getName() + ": " + f.length() + " bytes");
        }
    }
}

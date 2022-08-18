package Chuong7NIO;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) throws IOException{
       example2();
    }

    private static void example2() throws IOException{
        Path path = Paths.get("D:\\Nodo - Work\\Java core\\Temp");
        Path path2 = path.resolve("hanoijava.txt");

        Charset charset = Charset.forName("utf-8");
        try(BufferedReader reader = Files.newBufferedReader(path2,charset)) {
            String line = null;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }
    }

    private static void example1() throws IOException{
        Path path = Paths.get("D:\\Nodo - Work\\Java core\\Temp");
        System.out.println("This is " + (Files.isDirectory(path) ? "file":"folder"));

        System.out.println(Files.exists(path));

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)){
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
        }

        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
            @Override
            public boolean accept(Path entry) throws IOException {
                return Files.isDirectory(entry);
            }
        };

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path,filter)){
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
            }
        }
    }
}

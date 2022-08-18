package Chuong7NIO;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.FileVisitResult.CONTINUE;

public class FileFinderExample {

    static class Finder extends SimpleFileVisitor{
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{txt}");

        public FileVisitResult visitFile(Path path){
            if (matcher.matches(path.getFileName())){
                System.out.println("found: " + path);
            };
            return CONTINUE;
        }
    }

    public static void main(String[] args) throws IOException {
        Finder finder = new Finder();
        Files.walkFileTree(Path.of("D:\\Nodo - Work\\Java core\\Temp"),finder);
    }
}

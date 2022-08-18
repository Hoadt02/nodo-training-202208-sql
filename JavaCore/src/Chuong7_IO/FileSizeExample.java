package Chuong7_IO;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

public class FileSizeExample {
    private static long getSize(File file){
        if (file.isFile()) return file.length();
        File[] files = file.listFiles();
        int length = 0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()){
                length += getSize(files[i]);
                continue;
            }
            length += files[i].length();
        }
        return length;
    }

    private static long getSize2(File file){
        if (file.isFile()) return file.length();

        AtomicLong length = new AtomicLong(0);
        Arrays.stream(file.listFiles()).forEach(f -> {
            length.getAndSet(length.longValue() + (f.isFile() ? f.length():getSize2(f)));
        });
        return length.longValue();
    }

    public static void main(String[] args) {
        File file = new File("C:\\xampp");
        System.out.println("Size: " + getSize2(file)/(1024 * 1024) + "MB");
    }
}

package Chuong7NIO;

import javax.print.DocFlavor;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RandomAccessFileExample {
    public static void main(String[] args) throws IOException{
        Path path = Paths.get("D:\\Nodo - Work\\Java core\\Temp\\hanoijava2.txt");

        ByteBuffer buffer = ByteBuffer.allocate(20);
        try (FileChannel fc = FileChannel.open(path)){
            fc.read(buffer);
            System.out.println(new String(buffer.array()));

//            fc.position(0);
//            byte[] bytes = "Trần Đức Bo ".getBytes();
//            fc.write(ByteBuffer.wrap(bytes));
        }
    }
}

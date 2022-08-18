package Chuong7_IO;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFileNIOExample{
    public static void main(String[] args) throws Exception{
        FileInputStream fileInputStream = null;
        FileChannel fileChannel = null;

        try {
            File file = new File("D:\\Nodo - Work\\Java core\\Temp\\my_object");
            fileInputStream = new FileInputStream(file);
            fileChannel = fileInputStream.getChannel();

            long size = fileChannel.size();
            ByteBuffer buff = ByteBuffer.allocate((int) size);
            fileChannel.read(buff);
            buff.rewind();

            System.out.println(new String(buff.array(),"utf8"));
        }finally {
            if (fileChannel != null) fileChannel.close();
            if (fileInputStream != null) fileInputStream.close();
        }
    }
}

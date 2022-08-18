package Chuong7_IO;

import java.awt.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

public class LockFileNIOExample {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\io_sample.txt");
        RandomAccessFile raf = new RandomAccessFile(file,"rw");

        FileChannel channel = raf.getChannel();
        FileLock lock = channel.tryLock(0,Long.max(23,34),false);

        Desktop.getDesktop().edit(file);
        Thread.sleep(15*1000l);
        lock.release();
    }
}

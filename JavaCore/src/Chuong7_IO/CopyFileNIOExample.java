package Chuong7_IO;

import java.awt.*;
import java.io.*;
import java.nio.channels.FileChannel;

public class CopyFileNIOExample {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("D:\\\\Nodo - Work\\\\Java core\\\\Unit7\\\\io_sample.txt");
        File desFile = new File(sourceFile.getParentFile(),"sample2.txt");
        FileChannel srcChannel = null;
        FileChannel desChannel = null;

        srcChannel = new FileInputStream(sourceFile).getChannel();
        desChannel = new FileOutputStream(desFile).getChannel();
        srcChannel.transferTo(0,srcChannel.size(),desChannel);

        Desktop.getDesktop().open(sourceFile.getParentFile());
    }
}

package Chuong7_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerachFileNIOExample {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("[0-9]", Pattern.CASE_INSENSITIVE);

        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\io_sample.txt");
        FileInputStream stream = new FileInputStream(file);
        FileChannel channel = stream.getChannel();

        ByteBuffer bytes = channel.map(FileChannel.MapMode.READ_ONLY,0,channel.size());
        CharBuffer chars =  Charset.defaultCharset().decode(bytes);

        Matcher matcher = pattern.matcher(chars);
        if (matcher.find()){
            System.out.println("Found at " + Integer.toString(matcher.start()));
            System.out.println("value " + chars.subSequence(matcher.start(), matcher.end()) + "''");
        }else {
            System.out.println("Not found");
        }
    }
}

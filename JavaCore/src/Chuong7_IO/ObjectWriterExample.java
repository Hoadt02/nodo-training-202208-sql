package Chuong7_IO;

import java.io.*;

public class ObjectWriterExample {
    public static void main(String[] args) throws IOException {
        File folder = new File("D:\\Nodo - Work\\Java core\\Temp");
        ObjectOutputStream output = null;

        FileOutputStream fileOutput = new FileOutputStream(new File(folder,"my_object"));
        output = new ObjectOutputStream(fileOutput);

        PrintMessage printMessage = new PrintMessage("Can Noi La");
        output.writeObject(printMessage);
        output.close();
    }
}

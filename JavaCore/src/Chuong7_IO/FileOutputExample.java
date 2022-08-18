package Chuong7_IO;

import java.io.*;

public class FileOutputExample {

    public static void main(String[] args) throws IOException {
       example3();
    }

    private static void example3() {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\hanoijava.txt");
        try (FileInputStream inputStream = new FileInputStream(file)){
            byte[] bytes = new byte[4*1024];
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = inputStream.read(bytes)) != -1){
                builder.append(new String(bytes, 0, read));
            }
            System.out.println("[ " + builder + " ]");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void example2() {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\hanoijava.txt");
        try(FileInputStream inputStream = new FileInputStream(file)) {
            byte[] bytes = new byte[23];
            inputStream.read(bytes);
            System.out.println(new String(bytes));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void example1() throws IOException {
        File file = new File("D:\\Nodo - Work\\Java core\\Unit7\\hanoijava.txt");
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            byte[] bytes = ("Hello Ha Noi Java Class").getBytes();
            outputStream.write(bytes);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (outputStream != null) outputStream.close();
        }
    }
}

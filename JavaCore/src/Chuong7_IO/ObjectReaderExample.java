package Chuong7_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectReaderExample {
    public static void main(String[] args) {
        try {
            ObjectInputStream inputStream = new ObjectInputStream(
                                                new FileInputStream(
                                                        new File("D:\\Nodo - Work\\Java core\\Temp","my_object")));
            Object obj = inputStream.readObject();
            Method method = obj.getClass().getMethod("run", new Class[0]);
            method.invoke(obj,new Object[0]);

            inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

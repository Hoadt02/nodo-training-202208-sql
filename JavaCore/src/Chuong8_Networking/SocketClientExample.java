package Chuong8_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("CLIENT start sending ...");
        try (DataInputStream inputStream = (DataInputStream) socket.getInputStream();
             DataOutputStream output = (DataOutputStream) socket.getOutputStream()){
             output.writeUTF("Hello Server");
             System.out.println("Server Say: " + inputStream.readUTF());
        }finally {
            socket.close();
        }
    }
}

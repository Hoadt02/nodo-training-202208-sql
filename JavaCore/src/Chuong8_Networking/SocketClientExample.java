package Chuong8_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketClientExample {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        System.out.println("CLIENT start sending ...");
        try (DataInputStream inputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {
            output.writeUTF("Start");

            while (true) {
                System.out.println("Server Say: " + inputStream.readUTF());
                Scanner sc = new Scanner(System.in);
                System.out.print("Client sending: ");
                String message = sc.nextLine();
                output.writeUTF(message);
                System.out.println();
            }
        }
    }
}

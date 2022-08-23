package Chuong8_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketServerExample {

    public SocketServerExample(int serverPort) throws IOException {
        ServerSocket serverSocket = new ServerSocket(serverPort);
        System.out.println("SERVER Listening ...");
        Socket socket = serverSocket.accept();
        try (DataInputStream input = new DataInputStream(socket.getInputStream());
             DataOutputStream output = new DataOutputStream(socket.getOutputStream())) {

            while (true) {
                System.out.println("Client Say: " + input.readUTF());
                Scanner sc = new Scanner(System.in);
                System.out.print("Server sending: ");
                String message = sc.nextLine();
                output.writeUTF(message);
                System.out.println();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        new SocketServerExample(8080);
    }
}

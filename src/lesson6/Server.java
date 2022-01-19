package lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static ServerSocket server;
    private static Socket socket;
    private static final int PORT = 8191;
    private static Scanner sc;
    private static PrintWriter out;

    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = new Scanner(System.in);
        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started!");
            socket = server.accept();
            System.out.println("Client connected!");

            DataInputStream inputStream  = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

            Thread reading = new Thread(() -> {
                try {
                    while (true) {
                        outputStream.writeUTF(sc.nextLine());
                    }
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                }
            });
            reading.start();

            while (true) {
                String str = inputStream.readUTF();
                if (str.equals("/end")) {
                    System.out.println("Client disconnected");
                    outputStream.writeUTF("/end");
                    break;
                } else {
                    System.out.println("Client: " + str);
                }
            }

    } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}

package lesson6.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleServer {

    private static final int SERVER_PORT = 8189;

    public static void main(String[] args) {
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Сервер запущен, ожидаем подключения...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread1 = new Thread(() -> {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("Клиент: /end")) {
                            System.out.println("Клиент отключился.");
                            System.exit(1);
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    System.out.println("Клиент отключился.");
                    System.exit(1);
                }
            });
            thread1.setDaemon(true);
            thread1.start();
            Thread thread2 = new Thread(() -> {
                try {
                    while (true) {
                        String message = scanner.nextLine();
                        if (!message.isBlank()) {
                            out.writeUTF("Клиент: " + message);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            thread2.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

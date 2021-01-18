package lesson6.client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ConsoleClient {

    private static final int SERVER_PORT = 8189;
    private static final String SERVER_HOST = "localhost";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Socket socket;


        try {
            socket = new Socket(SERVER_HOST, SERVER_PORT);
            System.out.println("Вы подключились");
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            Thread thread1 = new Thread(() -> {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("Сервер: /end")) {
                            System.out.println("Сервер отключился.");
                            System.exit(1);
                            break;
                        }
                        System.out.println(strFromServer);
                    }
                } catch (Exception e) {
                    System.out.println("Сервер отключился.");
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
            System.out.println("Не удалось подключиться к серверу.");
            System.exit(1);
        }


    }


}


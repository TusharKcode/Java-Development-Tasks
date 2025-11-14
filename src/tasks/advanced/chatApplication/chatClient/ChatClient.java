package tasks.advanced.chatApplication.chatClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to chat server!");
            System.out.println("Enter your name: ");
            String name = userInput.readLine();

            // Thread to listen for incoming messages
            Thread recieveThread = new Thread(() -> {
                try {
                    String response;
                    while ((response = in.readLine()) != null){
                        System.out.println(response);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server");
                }
            });
            recieveThread.start();

            // Send user messages to the server
            String message;
            while ((message = userInput.readLine()) != null){
                out.println(name + ": " + message);
                if (message.equalsIgnoreCase("exit")){
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Disconnected from server");
        }
    }
}

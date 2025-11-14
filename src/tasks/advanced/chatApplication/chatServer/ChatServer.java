package tasks.advanced.chatApplication.chatServer;

import tasks.advanced.chatApplication.clientHandler.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer {
    private static final int PORT = 12345;
    private static final Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.out.println("Chat server started on port " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true){
                Socket socket = serverSocket.accept();
                System.out.println("New Client connected: " + socket);

                ClientHandler clientHandler = new ClientHandler(socket, clientHandlers);
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
            }
        } catch (IOException e){
            System.out.println("Server error: " + e.getMessage());
        }
    }

    // Broadcast message to all clients
    public static synchronized void broadcast (String message, ClientHandler sender){
        for (ClientHandler client : clientHandlers){
            if (client != sender){
                client.sendMessage(message);
            }
        }
    }

    // Remove disconnected clients
    public static synchronized void removeClient(ClientHandler clientHandler){
        clientHandlers.remove(clientHandler);
        System.out.println("Client disconnected");
    }
}

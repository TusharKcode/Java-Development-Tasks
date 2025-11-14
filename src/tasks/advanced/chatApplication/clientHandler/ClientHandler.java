package tasks.advanced.chatApplication.clientHandler;

import tasks.advanced.chatApplication.chatServer.ChatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Set;

public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Set<ClientHandler> clients;
    private PrintWriter out;
    private BufferedReader in;

    public ClientHandler(Socket socket, Set<ClientHandler> clients){
        this.socket = socket;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            out.println("Welcome to the Chat! Type 'exit' to leave.");

            String message;
             while ((message = in.readLine()) != null){
                 if (message.equalsIgnoreCase("exit")){
                     break;
                 }
                 System.out.println(" " + message);
                 ChatServer.broadcast(message, this);
             }
        } catch (Exception e) {
            System.out.println("Client connection error: " + e.getMessage());
        } finally {
            closeConnection();
        }
    }

    public void sendMessage(String message){
        out.println(message);
    }

    private void closeConnection(){
        try {
            clients.remove(this);
            socket.close();
        } catch (IOException e){
            System.out.println("Error closing client connection: " + e.getMessage());
        }
        ChatServer.removeClient(this);
    }
}

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client to connect...");

            try (Socket clientSocket = serverSocket.accept()) {
                System.out.println("Client connected.");

                BufferedReader clientIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                BufferedWriter clientOut = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

                String msgFromClient, msgFromServer;

                // Separate threads or loop to read and write alternatively
                while (true) {
                    // Read message from client
                    msgFromClient = clientIn.readLine();
                    if (msgFromClient == null || msgFromClient.equalsIgnoreCase("bye")) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                    System.out.println("Client: " + msgFromClient);

                    // Read message from server console to send to client
                    System.out.print("Server: ");
                    msgFromServer = consoleReader.readLine();
                    if (msgFromServer.equalsIgnoreCase("bye")) {
                        clientOut.write(msgFromServer);
                        clientOut.newLine();
                        clientOut.flush();
                        System.out.println("Connection closed by server.");
                        break;
                    }

                    clientOut.write(msgFromServer);
                    clientOut.newLine();
                    clientOut.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

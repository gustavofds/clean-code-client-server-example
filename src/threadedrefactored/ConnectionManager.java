package threadedrefactored;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ConnectionManager {
    static ServerSocket serverSocket;

    public ConnectionManager(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    public ClientConnection awaitClient() throws IOException {
        System.out.printf("accepting client\n");
        Socket socket = serverSocket.accept();
        System.out.printf("got client\n");
        return new ClientConnection(socket);
    }

    public static void closeIgnoringException() {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch(IOException ignore) {

            }
        }
    }
}

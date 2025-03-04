package threadedrefactored;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class Server implements Runnable {
    ServerSocket serverSocket;
    volatile boolean keepProcessing = true;
    ClientScheduler clientScheduler;

    ConnectionManager connectionManager;
    public Server(int port, int millisecondsTimeout, ClientScheduler clientScheduler) throws IOException {
        this.clientScheduler = clientScheduler;
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(millisecondsTimeout);
        connectionManager = new ConnectionManager(serverSocket);
    }

    public void run() {
        System.out.println("Server Starting");

        while (keepProcessing) {
            try {
                ClientConnection clientConnection = connectionManager.awaitClient();
                ClientRequestProcessor requestProcessor = new ClientRequestProcessor((clientConnection));
                clientScheduler.schedule(requestProcessor);
            } catch(Exception e ) {
                handle(e);
            }
        }
    }

    private void handle(Exception e) {
        if (!(e instanceof SocketException)) {
            e.printStackTrace();
        }
    }

    public void stopProcessing() {
        keepProcessing = false;
        ConnectionManager.closeIgnoringException();
    }
}

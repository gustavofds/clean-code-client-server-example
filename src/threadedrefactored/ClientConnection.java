package threadedrefactored;

import java.net.Socket;

public class ClientConnection {


    Socket socket;
    public ClientConnection(Socket socket) {
            this.socket = socket;
    }

    public void closeIgnoringException () {
        ConnectionManager.closeIgnoringException();
    }

    public Socket getSocket() {
        return socket;
    }
}

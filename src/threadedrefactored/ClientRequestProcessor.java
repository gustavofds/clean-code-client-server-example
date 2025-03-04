package threadedrefactored;

import common.MessageUtils;

public class ClientRequestProcessor {
    private ClientConnection clientConnection;
    public ClientRequestProcessor(ClientConnection clientConnection) {
        this.clientConnection = clientConnection;
    }

    public void process() {
        try {
            System.out.printf("Server: getting message\n");
            String message = MessageUtils.getMessage(clientConnection.getSocket());
            System.out.printf("Server: got message: %s\n", message);
            Thread.sleep(1000);
            System.out.printf("Server: sending reply: %s\n", message);
            MessageUtils.sendMessage(clientConnection.getSocket(), "Processed: " + message);
            System.out.printf("Server: sent\n");
            clientConnection.closeIgnoringException();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

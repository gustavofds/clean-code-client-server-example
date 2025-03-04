package threadedrefactored;

public interface ClientScheduler {
    void schedule(ClientRequestProcessor requestProcessor);
}

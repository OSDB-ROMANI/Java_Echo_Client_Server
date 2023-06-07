
import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 6666;
        new Client(new Socket(host, port)).start();
    }
}
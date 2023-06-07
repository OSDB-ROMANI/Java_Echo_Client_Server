import java.io.IOException;
import java.net.ServerSocket;

public class Main {
    public static void main(String[] args) {
        int port = 6666;
        if(args.length != 0){
            port = Integer.parseInt(args[0]);
        }
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server Attivato");
            while(true){
                System.out.println("sono in attesa di un client");
                new Client(ss.accept()).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
import java.io.*;
import java.net.Socket;

public class Client extends Thread{
    private Socket s;
    private BufferedReader in = null;
    private PrintWriter out = null;
    public Client(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        System.out.println("Connessione con il client avvenuta:\n"+s.getInetAddress()+" : "+s.getPort());
    }

    public void run(){
        String sms = null;
        boolean stato = true;
        try {
            while(stato){

                sms = in.readLine();
                System.out.println("Client "+s.getPort()+" sms: "+sms);
                if(sms.equals("exit")) stato = false;
                out.println("SERVER - ricevuto messassaggio: "+sms);
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

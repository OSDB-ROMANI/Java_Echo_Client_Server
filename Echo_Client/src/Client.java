import java.io.*;
import java.net.Socket;

public class Client extends Thread{
    private Socket s;
    private BufferedReader in = null;
    private BufferedReader inTastiera = null;
    private PrintWriter out = null;
    public Client(Socket s) throws IOException {
        this.s = s;
        in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        inTastiera = new BufferedReader(new InputStreamReader(System.in));
        out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
        System.out.println("Oggetto creato");
    }
    public void run(){
        String sms = null;
        boolean stato = true;
        try {
            System.out.println("sono connessesso al Server");
            while(stato){
                System.out.println("inserisci il messaggio");
                sms = inTastiera.readLine();
                if(sms.equals("exit")) stato = false;
                out.println(sms);
                System.out.println(in.readLine());
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


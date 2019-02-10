import java.io.*;
import java.net.*;

public class Server {

    public static final int PORT = 8080;

    public static void main(String[] args)
            throws IOException {
        while (true) {
            ServerSocket s = new ServerSocket(PORT);
            System.out.println("Started: " + s);
            try {
                // Блокируем пока не произойдет соединение:
                Socket socket = s.accept();
                try {
                    System.out.println(
                            "Connection accepted: " + socket);
                    BufferedReader in =
                            new BufferedReader(
                            new InputStreamReader(
                            socket.getInputStream()));
                  
                    PrintWriter out =
                            new PrintWriter(
                            new BufferedWriter(
                            new OutputStreamWriter(
                            socket.getOutputStream())), true);

                    out.println("ID");
                    String h;
                    h = in.readLine();
                    int i, a, b;
                    boolean fail = false;
                    for (i = 0; i <=10; i++) {
                        a = (int) (Math.random() * 100);
                        b = (int) a % 2047;
                        out.println(a);                                               
                        out.println(b);  
                    }

                    out.println("END");
                    h = in.readLine();

                    if (fail) {
                        out.println("Fail");
                    } else {
                        out.println("Ok");
                    }
                    h = in.readLine();
                  
                } finally {
                    System.out.println("closing...");
                    socket.close();
                }
            } finally {
                s.close();
            }
        }
    }
}
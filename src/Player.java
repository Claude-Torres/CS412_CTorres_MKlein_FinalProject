import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class Player extends User{

    Player(){
        isHost = false;
        boolean connected = false;

        while(1==1) {
            try {
                System.out.println("Player> Attempting to connect...");
                socket = new Socket("127.0.0.1", 5000);
                System.out.println("Player> Successfully connected to localhost!");

                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                printWriter = new PrintWriter(socket.getOutputStream());
                break;
            } catch (IOException e) {
                System.out.println("No host to connect to.\nTrying again...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}

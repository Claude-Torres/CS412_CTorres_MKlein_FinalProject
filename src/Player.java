import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.lang.Thread.sleep;

@SuppressWarnings("BusyWait")
public class Player extends User{

    Player(){
        isHost = false;

        while(true) {
                try {
                    System.out.println("Player> Attempting to connect...");
                    socket = new Socket("127.0.0.1", 5000);
                    System.out.println("Player> Successfully connected to localhost!");

                    bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printWriter = new PrintWriter(socket.getOutputStream());
                    break;

                } catch (IOException e) {
                    System.out.println("No host to connect to. Trying again\n");
                    try {
                        sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
    }
}
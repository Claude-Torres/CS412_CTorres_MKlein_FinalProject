import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;

import static java.lang.System.exit;

public class User{

    boolean isHost;
    public java.net.Socket socket;
    public BufferedReader bufferedReader;
    public PrintWriter printWriter;
    public ServerSocket serverSocket;

    boolean isSocketActive(){
        return socket.isConnected();
    }

    void sendData(String s){
        //System.out.println("Sending Data: " + s);

        printWriter.println(s);
        printWriter.flush();
    }

    String waitForData(){
        String input;

        while(true) {
            try {
                if ((input = bufferedReader.readLine()) != null) break;
            } catch (IOException e) {
                System.out.println("Other Player Disconnected!");
                exit(1);
            }
        }
        //System.out.println("Received data: " + input + "\nData Length: " + input.length());

        return input;
    }

    boolean getIsHost(){
        return isHost;
    }
}
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.exit;

public class Host extends User{

    Host(){
        isHost = true;

        try {
            serverSocket = new ServerSocket(5000);
            System.out.println("Host> Waiting for connection...");

            socket = serverSocket.accept();
            System.out.println("Host> Connection Successful!");

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            System.out.println("Someone is Already Hosting a Game!");
            exit(1);
        }

    }
}

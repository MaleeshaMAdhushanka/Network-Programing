package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {


        try {
            ServerSocket serverSocket =   new ServerSocket(5000);

            Socket socket = serverSocket.accept();

            //data writting


            Scanner scanner = new Scanner(System.in);
               String message   =    scanner.nextLine();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(message);


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String bb = dataInputStream.readUTF();
            System.out.println(bb);



            //send the data
            dataOutputStream.flush();


            //connection close
            socket.close();





        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

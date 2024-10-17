package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {

        //craete s server socket
        try {
            ServerSocket serverSocket = new ServerSocket(5000);


            //create a local socket
                Socket socket = serverSocket.accept();


                //data reading
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             String message  = dataInputStream.readUTF();
            System.out.println(message);

            //data writting

           DataOutputStream dataOutputStream =  new DataOutputStream(socket.getOutputStream());
           dataOutputStream.writeUTF("Hello i am from server side");

              //send the data

           dataOutputStream.flush();


            socket.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

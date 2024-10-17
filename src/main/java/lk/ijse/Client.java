package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Client {
    public static void main(String[] args) {


        //request to server
        try {
            Socket socket = new Socket("localhost",5000);

            //data writting

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("hello i am from client side");

            //send the data
            dataOutputStream.flush();

            //data reading


            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
           String message1 = dataInputStream.readUTF();
            System.out.println(message1);


           socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
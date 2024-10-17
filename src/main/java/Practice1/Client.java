package Practice1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 5000);


            //data Writting
            Scanner scanner = new Scanner(System.in);
            String BB = scanner.nextLine();
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF(BB);

            //send the data
            dataOutputStream.flush();





            //data reading
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            String   message  =  dataInputStream.readUTF();
            System.out.println(message);

            socket.close();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

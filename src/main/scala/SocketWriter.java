 import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class SocketWriter {
    public static void main(String[] args) throws Exception {
        System.out.println("Begin");
        ServerSocket server = new ServerSocket(9999);
        Socket socket = server.accept();
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        System.out.println("Start writing data. Enter close when finish");
        Scanner sc = new Scanner(System.in);
        String str;
        while (sc.hasNextLine())
        { outputStream.writeUTF(sc.nextLine());
        }
    }
}
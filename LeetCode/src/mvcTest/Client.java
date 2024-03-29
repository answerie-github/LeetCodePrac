package mvcTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by HYDYD.
 * 2019/7/8 21:43
 */
public class Client {
    public static void main(String[] args) {
        String msg = "Client Data";
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println(msg);
            pw.flush();
            String line = is.readLine();
            System.out.println("received from server " + line);
            pw.close();
            is.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

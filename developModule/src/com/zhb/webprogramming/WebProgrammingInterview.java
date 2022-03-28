package com.zhb.webprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zhb
 * @create 2022-02-11 12:38
 */

class Server {
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public Server() {
        try {
            ss = new ServerSocket(10000);
            while (true) {
                socket = ss.accept();
                String RemoteIP = socket.getInetAddress().getHostAddress();
                String RemotePort = ":" + socket.getLocalPort();
                System.out.println("A client come in!IP:" + RemoteIP + RemotePort);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line = in.readLine();
                System.out.println("Cleint send is :" + line);
                out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Your Message Received!");
                out.close();
                in.close();
                socket.close();
            }
        } catch (IOException e) {
            out.println("wrong");
        }
    }
    public static void main(String[] args) {
        new Server();
    }
};
class Client {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public Client() {
        try {
            System.out.println("Try to Connect to 127.0.0.1:10000");
            socket = new Socket("127.0.0.1", 10000);
            System.out.println("The Server Connected!");
            System.out.println("Please enter some Character:");
            BufferedReader line = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(line.readLine());
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(in.readLine());
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            out.println("Wrong");
        }
    }

    public static void main(String[] args) {
        new Client();
    }
};
public class WebProgrammingInterview {
}

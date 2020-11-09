package practice19;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;


public class Client {
    static DatagramSocket socket;
    static {
        try {
            socket = new DatagramSocket(9087);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
    static Runnable receiveThread = () -> {
        try {
            receiveMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    static Runnable sendThread = () -> {
        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();
        while(true){
            try {
                sendMessage(message,"255.255.255.255",9087);
            } catch (IOException e) {
                e.printStackTrace();
            }
            message = sc.nextLine();
        }
    };

    public static void main(String[] args) throws IOException {
        Thread send = new Thread(sendThread);
        Thread receive = new Thread(receiveThread);
        send.start();
        receive.start();
    }

    public static void sendMessage(String message, String address, int port) throws IOException {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getByName(address),port);
        socket.send(packet);
        System.out.println("message sent");
    }
    public static void receiveMessage() throws IOException {
        byte[] buffer = new byte[2024];
        DatagramPacket packet = new DatagramPacket(
                buffer,
                0,
                buffer.length);
        System.out.println("listening on 9877");
        socket.receive(packet);
        String message = new String(buffer, 0, packet.getLength());
        System.out.println(message);
    }
}

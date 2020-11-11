package practice19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Server {
    public static int port = 9888;
    public static int sendPort = 9889;
    static Map<InetAddress,String> users = new HashMap<>();
    static DatagramSocket socket;
    static PrintWriter pw;
    static File file;


    static {
        try {
            socket = new DatagramSocket(port);
            pw = new PrintWriter("History.txt");
            file = new File("History.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Server() throws IOException {

    }

    public static void sendMessage(String message, String address, int port) throws IOException {
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data,0,data.length, InetAddress.getByName(address.substring(1)),port);
        socket.send(packet);
        //System.out.println("message sent");
    }

    public static void executeCommand(String command, InetAddress ip){
        try {
        switch (command) {
            case "getUsers":
                for (InetAddress i : users.keySet()) {
                    sendMessage("Server: Username: " + users.get(i) + " | IP: " + i, ip.toString(), sendPort);
                }
                break;
            case "leave":
                for (InetAddress add:users.keySet()) {
                    sendMessage("User '"+users.get(ip)+"' left the chat.",add.toString(),sendPort);
                }
                users.remove(ip);
                System.out.println("User '"+ip.toString()+"' left the chat.");
                break;
            default:
                sendMessage("Server: Invalid command", ip.toString(), sendPort);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Host: "+InetAddress.getLocalHost());
        Thread receive = new Thread(() -> {
            System.out.println("Listening for "+port);

            while(true) {
                byte[] messageData = new byte[2048];
                DatagramPacket packet = new DatagramPacket(messageData, 0, messageData.length);

                try {
                    socket.receive(packet);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String data = new String(packet.getData(), 0, packet.getLength());
                if(!users.containsKey(packet.getAddress())){
                    users.put(packet.getAddress(),data);
                    System.out.println("User registered: Name: "+data+", IP: "+packet.getAddress());
                } else if(data.startsWith("//")){
                    executeCommand(data.substring(2),packet.getAddress());
                } else {
                    data = new SimpleDateFormat("HH:mm:ss").format(new Date())+" | "+users.get(packet.getAddress())+": "+data;
                    pw.write(data+"\n");
                    pw.flush();
                    for (InetAddress add:users.keySet()) {
                        if(!add.toString().equals(packet.getAddress().toString())){
                            try { sendMessage(users.get(packet.getAddress())+": "+data,add.toString(),sendPort); }
                            catch (IOException e) { e.printStackTrace(); }
                        }
                    }
                }
            }
        });
        receive.start();
    }
}

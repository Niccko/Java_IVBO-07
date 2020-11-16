package practice21;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        JsonServer JServer = new JsonServer();
        String command;
        Scanner sc = new Scanner(System.in);
        while (true){
            command = sc.nextLine();
            switch (command){
                case "add":
                    int id;
                    String data, description;
                    boolean isGood;
                    System.out.print("Item id: ");
                    id = sc.nextInt();
                    System.out.print("Item data: ");
                    data = sc.next();
                    System.out.print("Is this item good: ");
                    isGood = sc.nextBoolean();
                    System.out.print("Item description: ");
                    description = sc.nextLine();
                    JServer.addItem(new Item(id,data,isGood,description));
                    break;
                case "get":
                    System.out.print("Enter item id: ");
                    int getId = sc.nextInt();
                    Item respond = JServer.get(getId);
                    System.out.println(respond);
                    break;
                case "getAll":

                    break;
                case "edit":
                    System.out.print("Enter item id: ");
                    int editId = sc.nextInt();

                    break;
                case "delete":
                    System.out.print("Enter item id: ");
                    int deleteId = sc.nextInt();
                    JServer.deleteItem(deleteId);
                    break;

            }
        }
    }
}

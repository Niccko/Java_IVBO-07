package practice21;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
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
                    description = sc.next();
                    System.out.println(JServer.addItem(new Item(id, data, isGood, description)));
                    break;
                case "get":
                    System.out.print("Enter item id: ");
                    int getId = sc.nextInt();
                    Item respond = JServer.get(getId);
                    System.out.println(respond);
                    break;
                case "getAll":
                    List<Item> items = JServer.getAll();
                    for (Object i: items) {
                        System.out.println(i);
                    }
                    break;
                case "edit":
                    System.out.print("Enter item id: ");
                    int editId = sc.nextInt();
                    Item currItem = JServer.get(editId);
                    int e_id;
                    String e_data, e_description;
                    boolean e_isGood;
                    System.out.println(currItem);
                    System.out.print("Enter new item id: ");
                    e_id = sc.nextInt();
                    System.out.print("Enter new item data: ");
                    e_data = sc.next();
                    System.out.print("Is this item good: ");
                    e_isGood = sc.nextBoolean();
                    System.out.print("Enter new item description: ");
                    e_description = sc.next();
                    JServer.editItem(new Item(e_id,e_data,e_isGood,e_description),editId);
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

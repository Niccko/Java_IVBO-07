package practice2122;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ItemsStore storage;
        String command;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose storage type\n-Server\n-File");
        command = sc.next();
        command = command.toLowerCase();
        while(!command.equals("server")&&!command.equals("file"))
        {
            System.out.println("Invalid type!");
            System.out.println("Choose storage type\n-Server\n-File");
            command = sc.next();
            command = command.toLowerCase();
        }
        if(command.equals("server")){
            storage = new JsonServer();
        } else {
            storage = new JsonFile();
        }
        System.out.println("Chosen storage type: "+command);
        System.out.println("Type 'help' to see a list of available commands");
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
                    System.out.println("Item added: "+storage.addItem(new Item(id, data, isGood, description)));
                    break;
                case "get":
                    System.out.print("Enter item id: ");
                    int getId = sc.nextInt();
                    Item respond = storage.get(getId);
                    if (respond==null) {
                        System.out.println("Item not found");
                    } else {
                        System.out.println(respond+" Description: "+respond.getDescription());
                    }
                    break;
                case "getAll":
                    List<Item> items = storage.getAll();
                    for (Object i: items) {
                        System.out.println(i);
                    }
                    break;
                case "edit":
                    System.out.print("Enter item id: ");
                    int editId = sc.nextInt();
                    Item currItem = storage.get(editId);
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
                    storage.editItem(new Item(e_id,e_data,e_isGood,e_description),editId);
                    break;
                case "delete":
                    System.out.print("Enter item id: ");
                    int deleteId = sc.nextInt();
                    if(storage.get(deleteId)!=null)
                        System.out.println("Item with id "+deleteId+" was deleted");
                    storage.deleteItem(deleteId);
                    break;
                case "help":
                    System.out.println("Available commands\n" +
                            "get - returns a specified item\n" +
                            "getAll - return all items in the storage\n" +
                            "add - add new item to the storage\n" +
                            "edit - edit the specified item\n" +
                            "delete - delete a specified item");
                    break;
            }
        }

    }
}

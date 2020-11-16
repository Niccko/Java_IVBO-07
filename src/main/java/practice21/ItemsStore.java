package practice21;

import java.io.IOException;
import java.util.List;

public interface ItemsStore {
    List<Item> getAll();
    Item get(int id) throws IOException, InterruptedException;
    Item addItem(Item item) throws IOException, InterruptedException;
    Item editItem(Item item,int id) throws IOException, InterruptedException;
    void deleteItem(int id) throws IOException, InterruptedException;

}

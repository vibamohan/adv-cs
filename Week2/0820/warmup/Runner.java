
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        Item item1 = new Item("Apple", 0.99);
        Item item2 = new Item("Banana", 0.59);

        ArrayList<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);

        Item[] itemArray = {item1, item2};

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
        
        System.out.println("-------------");
        
        for (int i = 0; i < itemArray.length; i++) {
            System.out.println(itemArray[i]);
        }
    }
}
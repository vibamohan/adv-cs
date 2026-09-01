
import java.util.ArrayList;


public class Runner {
    public static void main(String[] args) {
        ArrayList<MyItems> items = new ArrayList<>();
        items.add(new MyItems<>("Apple", 1.50));
        items.add(new MyItems<>("Bananas (12 count)", 3.20));
        items.add(new MyItems<>("Cherry (1lb)", 3.50));

        for (MyItems<String, Integer> item : items) {
            System.out.println(item);
        }
    }
}
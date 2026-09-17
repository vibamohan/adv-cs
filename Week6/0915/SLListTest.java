import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SLListTest {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        SLList<Integer> list = new SLList<>();

        for (int i = 0; i < 5000; i++) {
            int value = rand.nextInt(9999) + 1;
            int index = rand.nextInt(list.size() + 1);
            list.add(index, value);
        }

        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());

        boolean running = true;
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Display the list");
            System.out.println("2. Scramble");
            System.out.println("3. Sort");
            System.out.println("4. Remove until empty");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            if (choice == 1) {
                System.out.println("List: " + list);
                System.out.println("Size: " + list.size());
            } else if (choice == 2) {
                list.scramble();
                System.out.println("Scrambled.");
            } else if (choice == 3) {
                sort(list);
                System.out.println("Sorted.");
            } else if (choice == 4) {
                while (!list.isEmpty()) {
                    int index = rand.nextInt(list.size());
                    System.out.println("Removed " + list.remove(index));
                }
                System.out.println("List is empty.");
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        input.close();
    }

    private static void sort(SLList<Integer> list) {
        Integer[] values = new Integer[list.size()];
        for (int i = 0; i < list.size(); i++) {
            values[i] = list.get(i);
        }
        Arrays.sort(values);
        for (int i = 0; i < list.size(); i++) {
            list.set(i, values[i]);
        }
    }
}
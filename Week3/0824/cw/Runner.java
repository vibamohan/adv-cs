import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Item<Food>> foodItems = new ArrayList<Item<Food>>();
        foodItems.add(new Item<Food>(new Food("Apple"), 0.99));
        foodItems.add(new Item<Food>(new Food("Pizza"), 3.50));
        foodItems.add(new Item<Food>(new Food("Sandwich"), 5.25));
        foodItems.add(new Item<Food>(new Food("Cookie"), 1.75));
        foodItems.add(new Item<Food>(new Food("Pasta"), 6.00));

        ArrayList<Item<Toy>> toyItems = new ArrayList<Item<Toy>>();
        toyItems.add(new Item<Toy>(new Toy("Puzzle", 6), 9.99));
        toyItems.add(new Item<Toy>(new Toy("Action Figure", 8), 12.50));
        toyItems.add(new Item<Toy>(new Toy("Building Blocks", 4), 15.00));
        toyItems.add(new Item<Toy>(new Toy("Board Game", 10), 19.99));
        toyItems.add(new Item<Toy>(new Toy("Stuffed Bear", 3), 7.25));

        System.out.println("Food Items:");
        System.out.println(foodItems);
        System.out.println();

        System.out.println("Toy Items:");
        System.out.println(toyItems);
        System.out.println();

        Scanner input = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("What do you want to view?");
            System.out.println("1. Food");
            System.out.println("2. Toys");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                running = itemMenu(input, "Food Items", foodItems);
            } else if (choice == 2) {
                running = itemMenu(input, "Toy Items", toyItems);
            } else if (choice == 3) {
                running = false;
            } else {
                System.out.println("Invalid choice.");
            }

            System.out.println();
        }

        System.out.println("Goodbye!");
        input.close();
    }

    public static <T> boolean itemMenu(Scanner input, String title, ArrayList<Item<T>> items) {
        boolean viewingItems = true;

        while (viewingItems) {
            System.out.println();
            System.out.println(title + ":");
            System.out.println(items);
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println("1. Display list again");
            System.out.println("2. Return to Food/Toys menu");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                viewingItems = true;
            } else if (choice == 2) {
                viewingItems = false;
            } else if (choice == 3) {
                return false;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        return true;
    }
}

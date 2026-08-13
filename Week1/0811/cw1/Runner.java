import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Animal animal = null;
        boolean running = true;

        while (running) {
            System.out.println();
            System.out.println("1. Create Animal");
            System.out.println("2. Print Animal");
            System.out.println("3. Change Name");
            System.out.println("4. Change Age");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter animal type: ");
                String type = input.nextLine();

                System.out.print("Enter animal name: ");
                String name = input.nextLine();

                System.out.print("Enter animal age: ");
                int age = input.nextInt();
                input.nextLine();

                animal = new Animal(type, name, age);
            } else if (choice == 2) {
                if (animal == null) {
                    System.out.println("No animal is present.");
                } else {
                    System.out.println(animal);
                }
            } else if (choice == 3) {
                if (animal == null) {
                    System.out.println("No animal is present.");
                } else {
                    System.out.print("Enter new animal name: ");
                    String name = input.nextLine();
                    animal.setName(name);
                }
            } else if (choice == 4) {
                if (animal == null) {
                    System.out.println("No animal is present.");
                } else {
                    System.out.print("Enter new animal age: ");
                    int age = input.nextInt();
                    input.nextLine();
                    animal.setAge(age);
                }
            } else if (choice == 5) {
                running = false;
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}

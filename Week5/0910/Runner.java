import java.util.Scanner;

public class Runner {
    private static final int NUMBER_COUNT = 5000;
    private static final int MAX_NUMBER = 10000;

    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();
        for (int i = 0; i < NUMBER_COUNT; i++) {
            numbers.add((int) (Math.random() * MAX_NUMBER));
        }

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.println(numbers);
                    break;
                case "2":
                    Sort.scramble(numbers);
                    System.out.println("The list has been scrambled.");
                    break;
                case "3":
                    Sort.bubbleSort(numbers);
                    System.out.println("The list has been sorted with Bubble Sort.");
                    break;
                case "4":
                    Sort.mergeSort(numbers);
                    System.out.println("The list has been sorted with Merge Sort.");
                    break;
                case "5":
                    runBinarySearch(scanner, numbers);
                    break;
                case "6":
                    running = false;
                    break;
                default:
                    System.out.println("Please choose an option from 1 to 6.");
            }
        }

        scanner.close();
        System.out.println("Goodbye.");
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("1. Display the list");
        System.out.println("2. Scramble the list");
        System.out.println("3. Apply Bubble Sort");
        System.out.println("4. Apply Merge Sort");
        System.out.println("5. Binary Search");
        System.out.println("6. Quit");
        System.out.print("Choose an option: ");
    }

    private static void runBinarySearch(
        Scanner scanner, MyArrayList<Integer> numbers
    ) {
        System.out.print("Enter a number to search for: ");
        if (!scanner.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            scanner.nextLine();
            return;
        }

        int target = scanner.nextInt();
        scanner.nextLine();
        int location = Sort.binarySearch(numbers, target);
        if (location == -1) {
            System.out.println(target + " was not found.");
        } else {
            System.out.println(target + " was found at index " + location + ".");
        }
        System.out.println(
            "Recursive calls: " + Sort.getBinarySearchCalls()
        );
        System.out.println(
            "At most 13 calls are needed because 2^12 = 4096 and 2^13 = 8192."
        );
    }
}

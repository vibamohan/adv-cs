import java.util.ArrayList;
import java.util.Scanner;

public class ToDoRunner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<Task>();

        System.out.println("ToDo List");

        while (true) {
            System.out.println();
            System.out.println("1. Add a task");
            System.out.println("2. Delete a task");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            int choice = readInt(input);
            input.nextLine();

            if (choice == 1) {
                addTask(input, tasks);
                sortTasks(tasks);
                printTasks(tasks);
            } else if (choice == 2) {
                deleteTask(input, tasks);
                printTasks(tasks);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Please enter 1, 2, or 3.");
            }
        }

        input.close();
    }

    public static void addTask(Scanner input, ArrayList<Task> tasks) {
        System.out.print("Enter the task name: ");
        String taskName = input.nextLine();

        System.out.print("Enter the rank: ");
        int rank = readInt(input);
        input.nextLine();

        while (rank < 1) {
            System.out.print("Rank must be 1 or higher. Enter the rank: ");
            rank = readInt(input);
            input.nextLine();
        }

        tasks.add(new Task(taskName, rank));
    }

    public static void deleteTask(Scanner input, ArrayList<Task> tasks) {
        System.out.print("Enter the task name to delete: ");
        String taskName = input.nextLine();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getTask().equalsIgnoreCase(taskName)) {
                tasks.remove(i);
                System.out.println("Task deleted.");
                return;
            }
        }

        System.out.println("Task not found.");
    }

    public static void sortTasks(ArrayList<Task> tasks) {
        for (int i = 0; i < tasks.size() - 1; i++) {
            for (int j = 0; j < tasks.size() - 1 - i; j++) {
                if (tasks.get(j).getRank() > tasks.get(j + 1).getRank()) {
                    Task temp = tasks.get(j);
                    tasks.set(j, tasks.get(j + 1));
                    tasks.set(j + 1, temp);
                }
            }
        }
    }

    public static void printTasks(ArrayList<Task> tasks) {
        System.out.println();
        System.out.println("Current ToDo List:");

        if (tasks.size() == 0) {
            System.out.println("No tasks yet.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.next();
        }

        return input.nextInt();
    }
}

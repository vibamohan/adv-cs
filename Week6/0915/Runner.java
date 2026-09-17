import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        SLList<Student> students = new SLList<>();

        students.add(new Student("Alice", 1));
        students.add(new Student("Bob", 2));
        students.add(new Student("Carol", 3));
        students.add(new Student("David", 4));
        students.add(new Student("Eve", 5));

        boolean running = true;
        while (running) {
            System.out.println("\nCurrent list: " + students);
            System.out.println("1. Add a student at an index");
            System.out.println("2. Remove a student at an index");
            System.out.println("3. Remove a student by id");
            System.out.println("4. Sort by name");
            System.out.println("5. Scramble");
            System.out.println("6. Quit");
            System.out.print("Choose an option: ");

            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                System.out.print("Enter index: ");
                int index = input.nextInt();
                input.nextLine();
                System.out.print("Enter name: ");
                String name = input.nextLine();
                System.out.print("Enter id: ");
                int id = input.nextInt();
                input.nextLine();

                Student student = new Student(name, id);
                if (students.contains(student)) {
                    System.out.println("A student with that id already exists. Not added.");
                } else {
                    students.add(index, student);
                    System.out.println("Added.");
                }

            } else if (choice == 2) {
                System.out.print("Enter index to remove: ");
                int index = input.nextInt();
                input.nextLine();
                try {
                    Student removed = students.remove(index);
                    System.out.println("Removed " + removed);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }

            } else if (choice == 3) {
                System.out.print("Enter id to remove: ");
                int id = input.nextInt();
                input.nextLine();
                Student dummy = new Student("", id);
                boolean removed = students.remove(dummy);
                System.out.println(removed ? "Removed student with id " + id : "No student with id " + id);

            } else if (choice == 4) {
                sortByName(students);
                System.out.println("Sorted by name.");

            } else if (choice == 5) {
                students.scramble();
                System.out.println("Scrambled.");

            } else if (choice == 6) {
                running = false;

            } else {
                System.out.println("Invalid choice.");
            }
        }
        input.close();
    }

    private static void sortByName(SLList<Student> students) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < students.size() - 1; i++) {
                if (students.get(i).getName().compareTo(students.get(i + 1).getName()) > 0) {
                    Student temp = students.get(i);
                    students.set(i, students.get(i + 1));
                    students.set(i + 1, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
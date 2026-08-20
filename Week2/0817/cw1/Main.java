import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Profile[] profiles = {
            new Profile("Ava", 16),
            new Profile("Liam", 14),
            new Profile("Mia", 18),
            new Profile("Noah", 15),
            new Profile("Sophia", 17),
            new Profile("Ethan", 13),
            new Profile("Isabella", 19),
            new Profile("Mason", 12),
            new Profile("Olivia", 16),
            new Profile("Lucas", 15)
        };

        int choice = 0;

        while (choice != 5) {
            System.out.println();
            System.out.println("Profile List");
            System.out.println("1. Display profiles");
            System.out.println("2. Sort by age");
            System.out.println("3. Sort by name");
            System.out.println("4. Scramble list");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            choice = input.nextInt();
            System.out.println();

            if (choice == 1) {
                displayProfiles(profiles);
            } else if (choice == 2) {
                sortByAge(profiles);
                displayProfiles(profiles);
            } else if (choice == 3) {
                sortByName(profiles);
                displayProfiles(profiles);
            } else if (choice == 4) {
                scrambleProfiles(profiles);
                displayProfiles(profiles);
            } else if (choice == 5) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }

    public static void displayProfiles(Profile[] profiles) {
        for (int i = 0; i < profiles.length; i++) {
            System.out.println((i + 1) + ". " + profiles[i]);
        }
    }

    public static void sortByAge(Profile[] profiles) {
        for (int i = 0; i < profiles.length - 1; i++) {
            for (int j = 0; j < profiles.length - 1 - i; j++) {
                if (profiles[j].getAge() > profiles[j + 1].getAge()) {
                    Profile temp = profiles[j];
                    profiles[j] = profiles[j + 1];
                    profiles[j + 1] = temp;
                }
            }
        }
    }

    public static void sortByName(Profile[] profiles) {
        for (int i = 0; i < profiles.length - 1; i++) {
            for (int j = 0; j < profiles.length - 1 - i; j++) {
                if (profiles[j].getName().compareTo(profiles[j + 1].getName()) > 0) {
                    Profile temp = profiles[j];
                    profiles[j] = profiles[j + 1];
                    profiles[j + 1] = temp;
                }
            }
        }
    }

    public static void scrambleProfiles(Profile[] profiles) {
        for (int i = 0; i < profiles.length; i++) {
            int randomIndex = (int) (Math.random() * profiles.length);
            Profile temp = profiles[i];
            profiles[i] = profiles[randomIndex];
            profiles[randomIndex] = temp;
        }
    }
}

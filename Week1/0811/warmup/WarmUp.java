import java.util.Scanner;

public class WarmUp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your partner's name: ");
        String name = input.nextLine();

        System.out.println("Hello " + name);
    }
}

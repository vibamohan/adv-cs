import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GameManager game = new GameManager();

        System.out.println("Tic-Tac-Toe");
        System.out.println("You are X. The computer is O.");
        game.printGrid();

        while (game.getWinner().equals("") && !game.isFull()) {
            boolean validMove = false;

            while (!validMove) {
                System.out.print("Enter row: ");
                int row = readInt(input);
                System.out.print("Enter column: ");
                int col = readInt(input);

                validMove = game.enterMove(row, col, "X");

                if (!validMove) {
                    System.out.println("That location is not available. Try again.");
                }
            }

            game.printGrid();

            if (!game.getWinner().equals("") || game.isFull()) {
                break;
            }

            game.computerMove();
            game.printGrid();
        }

        String winner = game.getWinner();

        if (winner.equals("X")) {
            System.out.println("X wins!");
        } else if (winner.equals("O")) {
            System.out.println("O wins!");
        } else {
            System.out.println("Tie game!");
        }

        input.close();
    }

    public static int readInt(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.print("Please enter a number: ");
            input.next();
        }

        return input.nextInt();
    }
}

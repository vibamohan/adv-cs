public class GameManager {
    private String[][] grid;

    public GameManager() {
        grid = new String[3][3];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                grid[row][col] = " ";
            }
        }
    }

    public boolean enterMove(int row, int col, String player) {
        row--;
        col--;

        if (row < 0 || row >= 3 || col < 0 || col >= 3) {
            return false;
        }

        if (!grid[row][col].equals(" ")) {
            return false;
        }

        grid[row][col] = player;
        return true;
    }

    public boolean computerMove() {
        for (int row = 1; row <= 3; row++) {
            for (int col = 1; col <= 3; col++) {
                if (enterMove(row, col, "O")) {
                    System.out.println("Computer chose row " + row + ", column " + col + ".");
                    return true;
                }
            }
        }

        return false;
    }

    public void printGrid() {
        System.out.println();
        System.out.println("  1   2   3");

        for (int row = 0; row < grid.length; row++) {
            System.out.println((row + 1) + " " + grid[row][0] + " | " + grid[row][1] + " | " + grid[row][2]);

            if (row < grid.length - 1) {
                System.out.println(" ---+---+---");
            }
        }

        System.out.println();
    }

    public String getWinner() {
        for (int i = 0; i < 3; i++) {
            if (!grid[i][0].equals(" ") && grid[i][0].equals(grid[i][1]) && grid[i][1].equals(grid[i][2])) {
                return grid[i][0];
            }

            if (!grid[0][i].equals(" ") && grid[0][i].equals(grid[1][i]) && grid[1][i].equals(grid[2][i])) {
                return grid[0][i];
            }
        }

        if (!grid[0][0].equals(" ") && grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2])) {
            return grid[0][0];
        }

        if (!grid[0][2].equals(" ") && grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0])) {
            return grid[0][2];
        }

        return "";
    }

    public boolean isFull() {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col].equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }
}

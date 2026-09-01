public class Task {
    private String name;
    private int rank;

    public Task(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return name + " - Rank: " + rank;
    }
}

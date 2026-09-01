public class Toy {
    private String name;
    private int ageGroup;

    public Toy(String name, int ageGroup) {
        this.name = name;
        this.ageGroup = ageGroup;
    }

    public String toString() {
        return name + " (Ages " + ageGroup + "+)";
    }
}

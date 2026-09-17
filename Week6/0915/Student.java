public class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Student) {
            Student other = (Student) o;
            return this.id == other.getID();
        }
        return false;
    }

    public String toString() {
        return name + " [" + id + "]";
    }
}
public class Animal {
    private String type;
    private String name;
    private int age;

    public Animal(String type, String name, int age) {
        this.type = type;
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Type: " + type + ", Name: " + name + ", Age: " + age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

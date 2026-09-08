
public class Runner {
    public static void main(String[] args) {
        MyArrayList<Integer> numbers = new MyArrayList<>();

        for (int i = 0; i < 3000; i++) {
            numbers.add((int) (Math.random() * 1000));
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (i > 0) {
                System.out.print(",");
            }
            System.out.print(numbers.get(i));
        }
    }
}

public class WarmUp {
    public static void main(String[] args) {
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 99) + 1;
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }
}

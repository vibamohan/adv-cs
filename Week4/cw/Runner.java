public class Runner {
    public static void main(String[] args) {
        MyArrayList<Task> tasks = new MyArrayList<>();

        for (int i = 1; i <= 100; i++) {
            int rank = (int) (Math.random() * 30) + 1;

            Task task = new Task("task" + i, rank);

            tasks.add(task);
        }

        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }
}

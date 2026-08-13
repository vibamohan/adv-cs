import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame window = new JFrame("My Calculator");

        window.setSize(400, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        window.add(new Screen());
        window.setVisible(true);
    }
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Screen extends JPanel {
    private ArrayList<Costume> costumes;

    public Screen() {
        costumes = new ArrayList<Costume>();
        costumes.add(new Cat(40, 80));
        costumes.add(new Dog(210, 80));
        costumes.add(new Bird(380, 80));
        costumes.add(new Rabbit(550, 80));

        setPreferredSize(new Dimension(720, 320));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Costume costume : costumes) {
            costume.drawMe(g);
        }
    }
}

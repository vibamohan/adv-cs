import java.awt.Color;
import java.awt.Graphics;

public class Dog extends Costume {
    public Dog(int x, int y) {
        super(x, y);
    }

    public void drawNose(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(Color.BLACK);
        g.fillOval(x + 52, y + 72, 18, 15);
        g.drawLine(x + 61, y + 87, x + 61, y + 97);
        g.drawArc(x + 48, y + 88, 13, 12, 180, 180);
        g.drawArc(x + 61, y + 88, 13, 12, 180, 180);
    }

    public void drawEars(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(new Color(120, 75, 45));
        g.fillOval(x - 2, y + 35, 32, 75);
        g.fillOval(x + 90, y + 35, 32, 75);
        g.setColor(Color.BLACK);
        g.drawOval(x - 2, y + 35, 32, 75);
        g.drawOval(x + 90, y + 35, 32, 75);
    }
}

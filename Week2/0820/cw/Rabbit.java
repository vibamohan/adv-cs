import java.awt.Color;
import java.awt.Graphics;

public class Rabbit extends Costume {
    public Rabbit(int x, int y) {
        super(x, y);
    }

    public void drawNose(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(Color.PINK);
        g.fillOval(x + 55, y + 75, 12, 9);
        g.setColor(Color.BLACK);
        g.drawOval(x + 55, y + 75, 12, 9);
        g.drawLine(x + 61, y + 84, x + 61, y + 94);
        g.drawArc(x + 48, y + 88, 13, 13, 180, 180);
        g.drawArc(x + 61, y + 88, 13, 13, 180, 180);
    }

    public void drawEars(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(new Color(245, 210, 160));
        g.fillOval(x + 25, y - 35, 22, 70);
        g.fillOval(x + 73, y - 35, 22, 70);
        g.setColor(Color.PINK);
        g.fillOval(x + 31, y - 23, 10, 52);
        g.fillOval(x + 79, y - 23, 10, 52);
        g.setColor(Color.BLACK);
        g.drawOval(x + 25, y - 35, 22, 70);
        g.drawOval(x + 73, y - 35, 22, 70);
    }
}

import java.awt.Color;
import java.awt.Graphics;

public class Cat extends Costume {
    public Cat(int x, int y) {
        super(x, y);
    }

    public void drawNose(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(Color.PINK);
        int[] noseX = {x + 55, x + 65, x + 60};
        int[] noseY = {y + 75, y + 75, y + 84};
        g.fillPolygon(noseX, noseY, 3);

        g.setColor(Color.BLACK);
        g.drawLine(x + 60, y + 84, x + 60, y + 93);
        g.drawLine(x + 58, y + 93, x + 50, y + 90);
        g.drawLine(x + 62, y + 93, x + 70, y + 90);

        g.drawLine(x + 42, y + 78, x + 15, y + 72);
        g.drawLine(x + 42, y + 84, x + 14, y + 84);
        g.drawLine(x + 42, y + 90, x + 15, y + 96);
        g.drawLine(x + 78, y + 78, x + 105, y + 72);
        g.drawLine(x + 78, y + 84, x + 106, y + 84);
        g.drawLine(x + 78, y + 90, x + 105, y + 96);
    }

    public void drawEars(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(new Color(245, 210, 160));
        int[] leftX = {x + 25, x + 45, x + 10};
        int[] leftY = {y + 35, y + 5, y + 15};
        int[] rightX = {x + 95, x + 75, x + 110};
        int[] rightY = {y + 35, y + 5, y + 15};
        g.fillPolygon(leftX, leftY, 3);
        g.fillPolygon(rightX, rightY, 3);

        g.setColor(Color.BLACK);
        g.drawPolygon(leftX, leftY, 3);
        g.drawPolygon(rightX, rightY, 3);
    }
}

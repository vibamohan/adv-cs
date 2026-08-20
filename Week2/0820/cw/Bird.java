import java.awt.Color;
import java.awt.Graphics;

public class Bird extends Costume {
    public Bird(int x, int y) {
        super(x, y);
    }

    public void drawNose(Graphics g) {
        int x = getX();
        int y = getY();

        g.setColor(Color.ORANGE);
        int[] beakX = {x + 57, x + 80, x + 57};
        int[] beakY = {y + 73, y + 82, y + 91};
        g.fillPolygon(beakX, beakY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(beakX, beakY, 3);
    }

    public void drawEars(Graphics g) {
        // Birds do not have visible ears in this costume.
    }
}

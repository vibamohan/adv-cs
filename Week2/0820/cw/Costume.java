import java.awt.Color;
import java.awt.Graphics;

public abstract class Costume {
    private int x;
    private int y;

    public Costume(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void drawNose(Graphics g);

    public abstract void drawEars(Graphics g);

    public void drawBody(Graphics g) {
        g.setColor(new Color(130, 190, 230));
        g.fillRect(x + 20, y + 95, 80, 95);
        g.setColor(Color.BLACK);
        g.drawRect(x + 20, y + 95, 80, 95);
    }

    public void drawHead(Graphics g) {
        g.setColor(new Color(245, 210, 160));
        g.fillOval(x + 10, y + 20, 100, 90);
        g.setColor(Color.BLACK);
        g.drawOval(x + 10, y + 20, 100, 90);

        g.fillOval(x + 40, y + 55, 8, 8);
        g.fillOval(x + 72, y + 55, 8, 8);
    }

    public void drawMe(Graphics g) {
        drawBody(g);
        drawEars(g);
        drawHead(g);
        drawNose(g);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

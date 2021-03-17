import java.awt.*;


public class Paddle extends Structure implements Constants {

    public Paddle(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
//Work on this method for bullet point 3 in discussion notes tab
    public void reset() {
        x = PADDLE_X_START;
        y = PADDLE_Y_START;
    }

    public boolean hitPaddle(int ballX, int ballY) {
        if ((ballX >= x) && (ballX <= x + width) && ((ballY >= y) && (ballY <= y + height))) {
            return true;
        }
        return false;
    }

    public boolean caughtItem(Item i) {
        if ((i.getX() < x + width) && (i.getX() + i.getWidth() > x) && (y == i.getY() || y == i.getY() - 1)) {
            i.resizePaddle(this);
            return true;
        }
        return false;
    }
}
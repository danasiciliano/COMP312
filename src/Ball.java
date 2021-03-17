import java.awt.*;


public class Ball extends Structure implements Constants {

    private int xDir = 1, yDir = -1;


    public Ball(int x, int y, int width, int height, Color color) {
        super(x, y, width, height, color);
    }

    //Draw the ball
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }

    //Moves the ball
    public void move() {
        x += xDir;
        y += yDir;
    }

    //Resets the ball to original position at center of screen
    public void reset() {
        x = BALL_X_START;
        y = BALL_Y_START;
        xDir = 1;
        yDir = -1;
    }


    public void setXDir(int xDir) {
        this.xDir = xDir;
    }

    public void setYDir(int yDir) {
        this.yDir = yDir;
    }

    //Accessor methods
    public int getXDir() {
        return xDir;
    }

}
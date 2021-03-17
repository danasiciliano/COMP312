

//Imports
import java.awt.Color;

//Class definition
public interface Constants {
    //Window Size
    int WINDOW_WIDTH = 500;
    int WINDOW_HEIGHT = 500;

    //Lives
    int MAX_LIVES = 3;
    int MIN_LIVES = 0;

    //Ball
    int BALL_WIDTH = 10;
    int BALL_HEIGHT = 10;
    int BALL_X_START = 250;
    int BALL_Y_START = 250;

    //Paddle
    int PADDLE_WIDTH = 70;
    int PADDLE_HEIGHT = 10;
    int PADDLE_X_START = 225;
    int PADDLE_Y_START = 450;
    int PADDLE_MIN = 35;
    int PADDLE_MAX = 140;

    //Bricks
    int BRICK_WIDTH = 50;
    int BRICK_HEIGHT = 25;
    int MAX_BRICKS = 50;
    int NO_BRICKS = 0;

    //Brick Colors
    Color BLUE_BRICK_ONE = new Color(0,0,139);
    Color BLUE_BRICK_TWO = new Color(0,0,255);
    Color BLUE_BRICK_THREE = new Color(0,191,255);
    Color RED_BRICK_ONE = new Color(255,0,0);
    Color RED_BRICK_TWO = new Color(250, 100, 100);
    Color RED_BRICK_THREE = new Color(238,180,180);
    Color PURPLE_BRICK_ONE = new Color(221, 0, 250);
    Color PURPLE_BRICK_TWO = new Color(231, 92, 255);
    Color PURPLE_BRICK_THREE = new Color(235, 161, 247);
    Color YELLOW_BRICK_ONE = new Color(255,215,0);
    Color YELLOW_BRICK_TWO = new Color(255,255,0);
    Color YELLOW_BRICK_THREE = new Color(255,246,143);
    Color PINK_BRICK_ONE = new Color(250, 0, 196);
    Color PINK_BRICK_TWO = new Color(255, 94, 220);
    Color PINK_BRICK_THREE = new Color(255, 150, 232);
    Color ORANGE_BRICK_ONE = new Color(255,127,80);
    Color ORANGE_BRICK_TWO = new Color(255,140,0);
    Color ORANGE_BRICK_THREE = new Color(255,165,0);
    Color GREEN_BRICK_ONE = new Color(0,139,0);
    Color GREEN_BRICK_TWO = new Color(0,205,0);
    Color GREEN_BRICK_THREE = new Color(0,255,0);

    //Items
    int ITEM_WIDTH = 20;
    int ITEM_HEIGHT = 10;

}
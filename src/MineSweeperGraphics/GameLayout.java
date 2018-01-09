package MineSweeperGraphics;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class GameLayout {

    //Window Size
    public int WIDTH;
    public int HEIGHT;

    //Boundaries
    private int X = 20;
    private int Y = 50;
    private int Y2;
    private int X2;

    private int TILE_SIZE = 20;
    private int ROWS;
    private int COLUMNS;
    public Group ROOT;

    //Colors
    private final Color BACKGROUND_COLOR = Color.rgb(25, 25, 25);
    private final Color EMPTY_TILE_COLOR = Color.LIGHTGRAY;

    //Rectangles
    public Rectangle game_rectangle;

    //Lines
    private Line[] vLines;
    private Line[] hLines;

    public GameLayout() {
        ROOT = new Group();
        game_rectangle = new Rectangle();
    }

    public void setLayout(int rows, int columns) {
        WIDTH = (columns * TILE_SIZE) + (2 * X);
        HEIGHT = (rows * TILE_SIZE) + X + Y;
        ROWS = rows;
        COLUMNS = columns;

        Y2 = HEIGHT - 20;
        X2 = WIDTH - 20;

        setGameRectangle();
        setVerticalLines();
        setHorizontalLines();
    }

    private Text getTimeText(long currentTime) {
        Text timeText = new Text();
        double timeTextX = timeText.getLayoutBounds().getWidth();
        return timeText;
    }

    public void addTile(double cordX, double cordY) {
        if ((cordX - X) % TILE_SIZE != 0 && (cordY - Y) % TILE_SIZE != 0) {
            Rectangle tile = new Rectangle();
            tile.setWidth(TILE_SIZE - 2);
            tile.setHeight(TILE_SIZE - 2);
            tile.setX((((int) (cordX) - X) / TILE_SIZE) * TILE_SIZE + X + 1);
            tile.setY((((int) (cordY) - Y) / TILE_SIZE) * TILE_SIZE + Y + 1);
            System.out.println(tile.getX() + "," + tile.getY());
            ROOT.getChildren().add(tile);
        }

    }

    private void setGameRectangle() {
        game_rectangle.setX(X);
        game_rectangle.setY(Y);
        game_rectangle.setWidth(WIDTH - (2 * X));
        game_rectangle.setHeight(HEIGHT - X - Y);
        game_rectangle.setFill(Color.GRAY);
        ROOT.getChildren().add(game_rectangle);
    }

    private void setVerticalLines() {
        vLines = new Line[COLUMNS + 1];
        for (int i = 0; i < vLines.length; i++) {
            vLines[i] = new Line();
            vLines[i].setStartX((i * TILE_SIZE) + X);
            vLines[i].setStartY(Y);
            vLines[i].setEndX((i * TILE_SIZE) + X);
            vLines[i].setEndY(Y2);
            ROOT.getChildren().add(vLines[i]);
        }

    }

    private void setHorizontalLines() {
        hLines = new Line[ROWS + 1];
        for (int i = 0; i < hLines.length; i++) {
            hLines[i] = new Line();
            hLines[i].setStartX(X);
            hLines[i].setStartY((i * TILE_SIZE) + Y);
            hLines[i].setEndX(X2);
            hLines[i].setEndY((i * TILE_SIZE) + Y);
            ROOT.getChildren().add(hLines[i]);
        }
    }

}

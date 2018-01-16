package MineSweeperGraphics;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameLayout {

    //Window Size
    public int WIDTH;
    public int HEIGHT;

    //Boundaries
    private int X = 20;
    private int Y = 50;
    private int Y2;
    private int X2;

    public final int TILE_SIZE = 20;
    private int ROWS;
    private int COLUMNS;
    public Group root;
    public Scene gameScene;

    //Rectangles
    public Rectangle game_rectangle;

    //Lines
    private Line[] vLines;
    private Line[] hLines;

    //Time
    private Text timeText;
    public TimeCount time;

    public GameLayout() {
        root = new Group();
        game_rectangle = new Rectangle();
        timeText = new Text();
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
        setTime();
        gameScene = new Scene(root, WIDTH, HEIGHT, Color.rgb(150, 150, 150));
    }

    private void setTime() {
        timeText.setText("00:00:00");
        timeText.setLayoutX(X);
        timeText.setLayoutY(Y / 2);
        time = new TimeCount(timeText);
        time.countTime();
        root.getChildren().add(timeText);
    }

    private void setGameRectangle() {
        game_rectangle.setX(X);
        game_rectangle.setY(Y);
        game_rectangle.setWidth(WIDTH - (2 * X));
        game_rectangle.setHeight(HEIGHT - X - Y);
        game_rectangle.setFill(Color.rgb(99, 99, 99));
        root.getChildren().add(game_rectangle);
    }

    private void setVerticalLines() {
        vLines = new Line[COLUMNS + 1];
        for (int i = 0; i < vLines.length; i++) {
            vLines[i] = new Line();
            vLines[i].setStartX((i * TILE_SIZE) + X);
            vLines[i].setStartY(Y);
            vLines[i].setEndX((i * TILE_SIZE) + X);
            vLines[i].setEndY(Y2);
            root.getChildren().add(vLines[i]);
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
            root.getChildren().add(hLines[i]);
        }
    }

    //Returns X coordinates given a column index
    public int getX(int col) {
        return col * TILE_SIZE + X;
    }

    //Returns Y coordinates given a row index
    public int getY(int row) {
        return row * TILE_SIZE + Y;
    }

    //Returns a row index given a Y coordinate
    public int getRow(double cordY) {
        return ((int) (cordY) - Y) / TILE_SIZE;
    }

    //Returns a column index given an X coordinate
    public int getColumn(double cordX) {
        return ((int) (cordX) - X) / TILE_SIZE;
    }

    //Returns the amount of row indexes
    public int getRows() {
        return ROWS;
    }

    //Returns the amount of column indexes
    public int getColumns() {
        return COLUMNS;
    }

    public void newGame(Stage primaryStage, PromptLayout prompt, boolean gameLost) {
        root.getChildren().clear();
        time.gameEnded = true;
        primaryStage.setScene(prompt.PROMPT_SCENE);
        prompt.errors.setText("");
        gameScene.setRoot(new Group());
        timeText.setText("00:00:00");
    }

}

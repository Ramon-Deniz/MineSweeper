/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeperGraphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class WindowLayout {

    //Window Size
    public final int WIDTH;
    public final int HEIGHT;

    //Boundaries
    public final int X = 20;
    public final int Y = 50;
    public final int Y2;
    public final int X2;

    public final int TILE_SIZE = 20;
    public final int ROWS;
    public final int COLUMNS;

    public WindowLayout(int rows, int columns) {
        WIDTH = (columns * TILE_SIZE) + (2 * X);
        HEIGHT = (rows * TILE_SIZE) + X + Y;
        ROWS = rows;
        COLUMNS = columns;

        Y2 = HEIGHT - 20;
        X2 = WIDTH - 20;
    }

    public int getTimeLocationX(Text timeText) {
        double timeTextX = timeText.getLayoutBounds().getWidth();
        return (int) (WIDTH / 2 - timeTextX / 2);
    }

    public Rectangle gameRectangle() {
        Rectangle r = new Rectangle();
        r.setX(X);
        r.setY(Y);
        r.setWidth(WIDTH - (2 * X));
        r.setHeight(HEIGHT - X - Y);
        r.setFill(Color.GRAY);
        return r;
    }
    
    public Rectangle tileRectangle(int cordX , int cordY){
        Rectangle r = new Rectangle();
        r.setX(cordX);
        r.setY(cordY);
        r.setWidth(TILE_SIZE-1);
        r.setHeight(TILE_SIZE-1);
        r.setFill(Color.LIGHTGRAY);
        return r;
    }

    public Line[] getVerticalLines() {
        Line[] verticalLines = new Line[COLUMNS + 1];
        for (int i = 0; i < verticalLines.length; i++) {
            verticalLines[i].setStartX((i * TILE_SIZE) + X);
            verticalLines[i].setStartY(Y);
            verticalLines[i].setEndX((i * TILE_SIZE) + X);
            verticalLines[i].setEndY(Y2);
        }
        return verticalLines;

    }

    public Line[] getHorizontalLines() {
        Line[] horizontalLines = new Line[ROWS + 1];
        for (int i = 0; i < horizontalLines.length; i++) {
            horizontalLines[i].setStartX(X);
            horizontalLines[i].setStartY((i * TILE_SIZE) + Y);
            horizontalLines[i].setEndX(X2);
            horizontalLines[i].setEndY((i * TILE_SIZE) + Y);
        }
        return horizontalLines;
    }

    public Color getBackGroundColor() {
        return Color.rgb(25, 25, 25);
    }

    public int getTileWidth() {
        return WIDTH * 10;
    }

    public int getTileHeight() {
        return HEIGHT * 10;
    }

    public Color getEmptyTile() {
        return Color.LIGHTGRAY;
    }

}

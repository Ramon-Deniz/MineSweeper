package MineSweeperGraphics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GraphicsAppender {

    public static final Color[] tileType = {Color.rgb(39, 71, 43), Color.rgb(37, 54, 71),
        Color.rgb(160, 4, 4), Color.rgb(2, 133, 142), Color.rgb(129, 27, 150), Color.rgb(124, 53, 8), Color.rgb(0, 0, 0)};

    public static void addTileNumber(GameLayout game, int tileValue, int row, int col) {
        Text tileText = new Text("" + tileValue);
        tileText.setX(game.getX(col) + 7);
        tileText.setY(game.getY(row) + 15);
        tileText.setFill(tileType[tileValue - 1]);
        tileText.setFont(Font.font("Verdana", FontWeight.BOLD, 13));
        game.root.getChildren().add(tileText);
    }

    public static void addTile(GameLayout game, int row, int col) {
        Rectangle tile = new Rectangle();
        tile.setHeight(game.TILE_SIZE - 2);
        tile.setWidth(game.TILE_SIZE - 2);
        tile.setY(game.getY(row) + 1);
        tile.setX(game.getX(col) + 1);
        tile.setFill(Color.DARKGRAY);
        game.root.getChildren().add(tile);
    }
}

package MineSweeperGameLogic;

import MineSweeperGraphics.GameLayout;
import MineSweeperGraphics.GraphicsAppender;
import MineSweeperGraphics.PromptLayout;
import javafx.scene.Group;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class GameLogic {

    public static boolean isValidDimension(int rows, int columns, int bomb_count) {
        if (rows < 1 || columns < 1 || bomb_count < 1) {
            return false;
        }

        if (rows > 47 || columns > 94 || bomb_count > (rows * columns * 10) / 6) {
            return false;
        }

        return true;
    }

    public static boolean isValidDimension(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            return false;
        }

        if (rows > 47 || columns > 94) {
            return false;
        }

        return true;
    }

    public static void revealTiles(Stage primaryStage, PromptLayout prompt, GameLayout game, MapCreator map, double cordX, double cordY) {
        int col = game.getColumn(cordX);
        int row = game.getRow(cordY);
        if (map.getBombLocations()[row][col] == -1) {
            JOptionPane.showMessageDialog(null,
                    "You clicked on a bomb",
                    "Game Over",
                    JOptionPane.ERROR_MESSAGE);
            game.root.getChildren().clear();
            prompt.errors.setText("");
            primaryStage.setScene(prompt.PROMPT_SCENE);
            game.gameScene.setRoot(new Group());
        }
        revealNearbyTiles(game, map, row, col);
    }

    private static void revealNearbyTiles(GameLayout game, MapCreator map, int row, int col) {
        int tileValue = map.getBombLocations()[row][col];
        game.addTile(col, row);
        if (tileValue == -1) {
            game.addBombTile(col, row);
        }
        if (tileValue > 0) {
            GraphicsAppender.addTileNumber(game, tileValue, row, col);
        }
        map.revealed[row][col] = true;
        if (tileValue != 0) {
            return;
        }

        //Goes through every possible scenario
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isInMap(game, map, row + i, col + j)) {
                    revealNearbyTiles(game, map, row + i, col + j);
                }
            }
        }
    }

    public static boolean isInMap(GameLayout game, MapCreator map, int row, int col) {
        return !(game.getRows() <= row || game.getColumns() <= col || row < 0 || col < 0 || map.revealed[row][col]
                || map.getBombLocations()[row][col] == -1);
    }

}

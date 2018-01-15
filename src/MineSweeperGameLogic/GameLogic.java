package MineSweeperGameLogic;

import MineSweeperGraphics.Flag;
import MineSweeperGraphics.GameLayout;
import MineSweeperGraphics.GraphicsAppender;
import MineSweeperGraphics.PromptLayout;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class GameLogic {

    //Boundaries
    private static final int ROW_MIN = 10, ROW_MAX = 47, COL_MIN = 10, COL_MAX = 94;

    public static boolean setErrors(PromptLayout prompt, int rows, int columns, int bombCount) {
        boolean valid = true;
        prompt.errors.setText("");
        if (rows < ROW_MIN || rows > ROW_MAX) {
            prompt.setRowError(ROW_MIN, ROW_MAX);
            valid = false;
        }
        if (columns < COL_MIN || columns > COL_MAX) {
            prompt.setColumnError(COL_MIN, COL_MAX);
            valid = false;
        }
        if (bombCount < 1 || bombCount > (rows * columns * 10) / 6) {
            prompt.setBombCountError((rows * columns * 10) / 6);
            valid = false;
        }
        return valid;
    }

    public static void toggleFlag(Stage stage, GameLayout game, MapCreator map, double coordY, double coordX) {
        Flag tempFlag = new Flag(game, coordY, coordX);
        int row = game.getRow(coordY);
        int col = game.getColumn(coordX);
        if (map.flagPos[row][col]) {
            game.root.getChildren().set(game.root.getChildren().indexOf(tempFlag), new ImageView());
            
            map.flagPos[row][col] = false;
            System.out.println("Removed");
        } else {
            game.root.getChildren().add(tempFlag);
            map.flagPos[row][col] = true;
        }
    }

    public static void revealTiles(Stage primaryStage, PromptLayout prompt, GameLayout game, MapCreator map, double coordY, double coordX) {
        int row = game.getRow(coordY);
        int col = game.getColumn(coordX);
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
        GraphicsAppender.addTile(game, row, col);
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

    private static boolean isInMap(GameLayout game, MapCreator map, int row, int col) {
        return !(game.getRows() <= row || game.getColumns() <= col || row < 0 || col < 0 || map.revealed[row][col]
                || map.getBombLocations()[row][col] == -1);
    }

}

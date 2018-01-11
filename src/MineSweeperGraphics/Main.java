package MineSweeperGraphics;

import MineSweeperGameLogic.GameLogic;
import MineSweeperGameLogic.MapCreator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MineSweeper");

        PromptLayout prompt = new PromptLayout();
        GameLayout game = new GameLayout();
        primaryStage.setScene(prompt.PROMPT_SCENE);
        MapCreator map = new MapCreator();

        prompt.CREATE_GAME.setOnAction((ActionEvent event) -> {
            try {
                if (GameLogic.isValidDimension(prompt.getInput(), prompt.getInput2(), prompt.getInput3())) {
                    game.setLayout(prompt.getInput(), prompt.getInput2());
                    primaryStage.setScene(game.gameScene);
                    map.setMap(prompt.getInput(), prompt.getInput2(), prompt.getInput3());
                } else if (GameLogic.isValidDimension(prompt.getInput(), prompt.getInput2())) {
                    prompt.setBombError();
                } else {
                    prompt.setError();
                }
            } catch (NumberFormatException e) {
                prompt.setInvalidInputError();
            }
        });

        game.game_rectangle.setOnMouseClicked((MouseEvent event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                GameLogic.revealTiles(primaryStage, prompt, game, map, event.getX(), event.getY());
            }
        });

        primaryStage.show();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeperGraphics;

import MineSweeperGameLogic.GameLogic;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MineSweeper");
        
        PromptLayout prompt = new PromptLayout();
        GridPane grid = prompt.GRID;
        GameLayout game = new GameLayout();
        
        prompt.CREATE_GAME.setOnAction((ActionEvent event) -> {
            try {
                int inputToInt = Integer.parseInt(prompt.input.getText());
                int inputToInt2 = Integer.parseInt(prompt.input2.getText());
                int inputToInt3 = Integer.parseInt(prompt.input3.getText());
                if (GameLogic.isValidDimension(inputToInt, inputToInt2, inputToInt3)) {
                    game.setLayout(inputToInt, inputToInt2);
                    primaryStage.setScene(new Scene(game.ROOT,game.WIDTH,game.HEIGHT));
                }
                else if(GameLogic.isValidDimension(inputToInt, inputToInt2)){
                    prompt.errors.setText("Bomb count must be\nbetween 1 and "+(inputToInt*inputToInt2/2));
                }
                else {
                    prompt.errors.setText("Invalid Numbers");
                }
            } catch (NumberFormatException e) {
                prompt.errors.setText("Invalid Input");
            }
        });
        
        game.game_rectangle.setOnMouseClicked((MouseEvent event) -> {
            System.out.println(event.getX()+","+event.getY());
            game.addTile(event.getX(), event.getY());
        });

        primaryStage.setScene(new Scene(grid));
        primaryStage.show();
    }

}

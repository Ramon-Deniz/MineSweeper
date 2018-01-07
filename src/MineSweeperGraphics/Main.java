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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author miguel
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MineSweeper");

        GridPane grid = new GridPane();
        Text instructions = new Text("Enter Column Count");
        TextField input = new TextField();
        Text instructions2 = new Text("Enter Row Count");
        TextField input2 = new TextField();
        Text instructions3 = new Text("Enter Bomb Count");
        TextField input3 = new TextField();
        Button confirmInput = new Button("Create Game");
        final Text error = new Text("None so far");

        confirmInput.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                try {
                    int inputToInt = Integer.parseInt(input.getText());
                    int inputToInt2 = Integer.parseInt(input2.getText());
                    int inputToInt3 = Integer.parseInt(input3.getText());
                    if (GameLogic.isValidDimension(inputToInt, inputToInt2, inputToInt3)) {
                        error.setText("Nice");
                    } else {
                        error.setText("Invalid Numbers");
                    }
                } catch (NumberFormatException e) {
                    error.setText("Invalid Input");
                }
            }

        });

        grid.setVgap(15);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(instructions, 0, 0);
        grid.add(input, 0, 1);
        grid.add(instructions2, 0, 2);
        grid.add(input2, 0, 3);
        grid.add(instructions3, 0, 4);
        grid.add(input3, 0, 5);
        grid.add(confirmInput, 0, 6);
        grid.add(error, 0, 7);

        Scene primaryScene = new Scene(grid);
        primaryStage.setScene(primaryScene);
        primaryStage.show();
    }

}

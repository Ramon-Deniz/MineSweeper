package MineSweeperGraphics;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class PromptLayout {

    private final GridPane GRID;
    public final Button CREATE_GAME;
    public final Scene PROMPT_SCENE;

    public Text errors;
    private TextField input;
    private TextField input2;
    private TextField input3;

    public PromptLayout() {
        GRID = new GridPane();
        CREATE_GAME = new Button("Create Game");
        errors = new Text();
        input = new TextField();
        input2 = new TextField();
        input3 = new TextField();

        setPromptLayout();

        PROMPT_SCENE = new Scene(GRID);
    }

    private void setPromptLayout() {
        GRID.setVgap(15);
        GRID.setPadding(new Insets(25, 25, 25, 25));

        GRID.add(input, 0, 1);
        GRID.add(input2, 0, 3);
        GRID.add(input3, 0, 5);
        GRID.add(errors, 0, 7);
        GRID.add(new Text("Enter Row Count (1-47)"), 0, 0);
        GRID.add(new Text("Enter Column Count (1-94)"), 0, 2);
        GRID.add(new Text("Enter Bomb Count"), 0, 4);
        GRID.add(CREATE_GAME, 0, 6);
        GRID.setStyle("-fx-background-color: #969696;");
    }

    //Only called when two or more inputs are invalid.
    public void setError() {
        errors.setText("Invalid Numbers.");
    }

    //Only called when bomb count input is invalid.
    public void setBombError() {
        errors.setText("Bomb count must be\nbetween 1 and " + (getInput() * getInput2() * 10 / 6));
    }

    public void setInvalidInputError() {
        errors.setText("Invalid input. Only type in integers");
    }

    public int getInput() {
        return Integer.parseInt(input.getText());
    }

    public int getInput2() {
        return Integer.parseInt(input2.getText());
    }

    public int getInput3() {
        return Integer.parseInt(input3.getText());
    }
}

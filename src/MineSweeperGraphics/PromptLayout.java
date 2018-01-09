/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MineSweeperGraphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class PromptLayout {
    
    public final GridPane GRID;
    public final Button CREATE_GAME;
    
    public Text errors;
    public TextField input;
    public TextField input2;
    public TextField input3;
    
    
    public PromptLayout(){
        GRID = new GridPane();
        CREATE_GAME = new Button("Create Game");
        errors = new Text();
        input = new TextField();
        input2 = new TextField();
        input3 = new TextField();
        
        setPromptLayout();
    }
    
    private void setPromptLayout(){
        GRID.setVgap(15);
        GRID.setPadding(new Insets(25,25,25,25));
        
        GRID.add(input, 0, 1);
        GRID.add(input2, 0, 3);
        GRID.add(input3, 0, 5);
        GRID.add(errors, 0, 7);
        GRID.add(new Text("Enter Column Count (10-40)"), 0, 0);
        GRID.add(new Text("Enter Row Count (10-40)"), 0, 2);
        GRID.add(new Text("Enter Bomb Count"), 0, 4);
        GRID.add(CREATE_GAME, 0, 6);
    }
}

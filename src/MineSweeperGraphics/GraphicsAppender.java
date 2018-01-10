/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeperGraphics;


import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class GraphicsAppender {

    public static final Color[] tileType = {Color.rgb(39, 71, 43), Color.rgb(55, 80, 104),
        Color.rgb(160, 4, 4), Color.rgb(2, 133, 142), Color.rgb(129, 27, 150), Color.rgb(124, 53, 8),Color.rgb(0,0,0)};

    public static void addTileNumber(GameLayout game, int tileValue, int row, int col) {
        Text tileText = new Text(""+tileValue);
        tileText.setX(game.getX(col)+7);
        tileText.setY(game.getY(row)+15);
        tileText.setFill(tileType[tileValue-1]);
        tileText.setFont(Font.font("Verdana",FontWeight.BOLD,13));
        game.root.getChildren().add(tileText);
    }
    
    public static void addBombTile(GameLayout game, int row, int col){
        
    }
}

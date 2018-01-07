/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MineSweeperGameLogic;

public class GameLogic {
    
    public static boolean isValidDimension(int rows, int columns, int bomb_count) {
        if (rows < 10 || columns < 10 || bomb_count < Math.sqrt(rows * columns) / 2) {
            return false;
        }

        if (rows > 40 || columns > 40 || bomb_count > (rows * columns) / 2) {
            return false;
        }
        
        return true;
    }
}

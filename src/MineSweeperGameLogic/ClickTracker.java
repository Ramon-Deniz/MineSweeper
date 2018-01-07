/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MineSweeperGameLogic;

import java.awt.Point;
import java.util.HashSet;

public class ClickTracker {
    
    private final HashSet<Point> clicks;
    
    public ClickTracker(){
        clicks = new HashSet<>();
    }
    
    public boolean clickedOnBefore(Point location){
        if(clicks.contains(location)){
            return false;
        }
        clicks.add(location);
        return true;
    }
    
}

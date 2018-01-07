package MineSweeperGameLogic;

import java.awt.Point;

public class Main{
    public static void main(String args[]){
        ClickTracker test = new ClickTracker();
        System.out.println(test.clickedOnBefore(new Point(5,5)));
        System.out.println(test.clickedOnBefore(new Point(5,100)));
        
            
    }
}
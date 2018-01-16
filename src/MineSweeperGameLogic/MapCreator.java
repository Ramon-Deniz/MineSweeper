package MineSweeperGameLogic;

import java.util.Random;

public class MapCreator {

    private int ROWS;
    private int COLUMNS;
    private int BOMB_COUNT;

    private int[][] BOMB_LOCATIONS;
    public boolean[][] revealed;
    public boolean[][] flagPos;
    public int tilesRevealed;
    
    public void setMap(int rows, int columns, int bombCount){
        ROWS = rows;
        COLUMNS = columns;
        BOMB_COUNT = bombCount;
        BOMB_LOCATIONS = new int[ROWS][COLUMNS];
        revealed = new boolean[ROWS][COLUMNS];
        flagPos = new boolean[ROWS][COLUMNS];
        tilesRevealed=ROWS*COLUMNS;
        setBombs();
    }

    /**
     * Places bombs at random indexes and updates nearby indexes until the
     * number of bombs placed is equal to BOMBCOUNT.
     */
    private void setBombs() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced != BOMB_COUNT) {
            int row = rand.nextInt(ROWS);
            int col = rand.nextInt(COLUMNS);

            if (BOMB_LOCATIONS[row][col] != -1) {
                BOMB_LOCATIONS[row][col] = -1;
                bombsPlaced++;
                updateNearby(row, col);
            }

        }
    }
    /**
     * Updates indexes next to bombs.
     * 
     * @param row
     * @param col 
     */
    private void updateNearby(int row, int col) {
        if (row - 1 > -1 && col - 1 > -1 && BOMB_LOCATIONS[row - 1][col - 1] != -1) {
            BOMB_LOCATIONS[row - 1][col - 1]++;
        }

        if (row - 1 > -1 && BOMB_LOCATIONS[row - 1][col] != -1) {
            BOMB_LOCATIONS[row - 1][col]++;
        }

        if (row - 1 > -1 && col + 1 < COLUMNS && BOMB_LOCATIONS[row - 1][col + 1] != -1) {
            BOMB_LOCATIONS[row - 1][col + 1]++;
        }

        if (col - 1 > -1 && BOMB_LOCATIONS[row][col - 1] != -1) {
            BOMB_LOCATIONS[row][col - 1]++;
        }

        if (col + 1 < COLUMNS && BOMB_LOCATIONS[row][col + 1] != -1) {
            BOMB_LOCATIONS[row][col + 1]++;
        }

        if (row + 1 < ROWS && col - 1 > -1 && BOMB_LOCATIONS[row + 1][col - 1] != -1) {
            BOMB_LOCATIONS[row + 1][col - 1]++;
        }

        if (row + 1 < ROWS && BOMB_LOCATIONS[row + 1][col] != -1) {
            BOMB_LOCATIONS[row + 1][col]++;
        }

        if (row + 1 < ROWS && col + 1 < COLUMNS && BOMB_LOCATIONS[row + 1][col + 1] != -1) {
            BOMB_LOCATIONS[row + 1][col + 1]++;
        }

    }
    
    /**
     * Returns map as a String.
     * 
     * @return String
     */
    @Override
    public String toString(){
        String map = "";
        
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLUMNS;j++){
                map+=String.format("%4d", BOMB_LOCATIONS[i][j]);
            }
            map+="\n";
        }
        
        return map;
    }
    
    /**
     * Returns the locations of bombs.
     * 
     * @return int[][]
     */
    public int[][] getBombLocations() {
        return BOMB_LOCATIONS;
    }
    
    public int getBombCount(){
        return BOMB_COUNT;
    }

}

package MineSweeperMapCreation;

import java.util.Random;

public class MapCreator {

    private final int ROWS;
    private final int COLUMNS;
    private final int BOMBCOUNT;

    private final int[][] BOMB_LOCATIONS;

    /**
     * Constructor
     *
     * @param rows
     * @param columns
     * @param bombCount
     */
    public MapCreator(int rows, int columns, int bombCount) {

        if (rows < 1 || columns < 1 || bombCount < 1) {
            throw new InvalidValuesException("Rows, columns, or bomb count not high enough");
        }

        ROWS = rows;
        COLUMNS = columns;
        BOMBCOUNT = bombCount;
        BOMB_LOCATIONS = new int[ROWS][COLUMNS];
        setBombs();
    }

    /**
     * Places bombs at random indexes and updates nearby indexes until the
     * number of bombs placed is equal to BOMBCOUNT.
     */
    private void setBombs() {
        Random rand = new Random();
        int bombsPlaced = 0;

        while (bombsPlaced != BOMBCOUNT) {
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

}

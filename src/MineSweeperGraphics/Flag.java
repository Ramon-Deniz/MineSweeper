package MineSweeperGraphics;

import javafx.scene.image.ImageView;

public class Flag extends ImageView {

    private final int Y, X;

    public Flag(GameLayout game, double coordY, double coordX) {
        super("/flag.png");
        Y = game.getY(game.getRow(coordY)) + 2;
        X = game.getX(game.getColumn(coordX)) + 2;
        super.setLayoutX(X);
        super.setLayoutY(Y);
        super.setMouseTransparent(true);
    }

    public Flag(double coordY, double coordX) {
        super("/flag.png");
        Y = (int) coordY;
        X = (int) coordX;
        super.setLayoutX(X);
        super.setLayoutY(Y);
    }

    @Override
    public int hashCode() {
        return X * 12007 + Y;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Flag)) {
            return false;
        }
        Flag tempFlag = (Flag) o;
        return (tempFlag.X == X && tempFlag.Y == Y);
    }

}

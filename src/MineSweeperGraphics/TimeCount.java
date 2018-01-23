package MineSweeperGraphics;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author ramon
 */
public class TimeCount {

    private long startTime;
    private Text timeText;
    public boolean gameEnded;

    public TimeCount(Text timeText) {
        startTime = System.currentTimeMillis();
        this.timeText = timeText;
    }

    public void countTime() {
        new Timeline(new KeyFrame(
                Duration.millis(1000),
                ae -> updateTime()))
                .play();
    }

    public void updateTime() {
        if (gameEnded) {
            return;
        }
        long currentTime = System.currentTimeMillis() - startTime;
        int hour = (int) (currentTime / 3600000);
        int minute = (int) (currentTime / 60000) % 60;
        int second = (int) (currentTime / 1000) % 60;
        timeText.setText(String.format("%02d:%02d:%02d", hour, minute, second));
        countTime();
    }
    
    public String getTime(){
        long currentTime = System.currentTimeMillis() - startTime;
        int hour = (int) (currentTime / 3600000);
        int minute = (int) (currentTime / 60000) % 60;
        int second = (int) (currentTime / 1000) % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

}

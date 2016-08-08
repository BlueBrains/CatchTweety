package score;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author AMER-HY
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {

    private String Name;
    private int NumberOfStep;
    private int Time;

    /**
     *
     * @param Name:Type(string) Contains the Player Name
     * @param NumberOfStep:Type(integer)Contains the number of step
     * @param Time :type(integer)contains the time of player
     */
    public Player(String Name, int NumberOfStep, int Time) {
        this.Name = Name;
        this.NumberOfStep = NumberOfStep;
        this.Time = Time;
    }

    /**
     *
     * @param Name :Type(string) Contains the Player Name the function assign
     * the name to this.Name
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     *
     * @param NumberOfStep :Type(integer)Contains the number of step the
     * function assign the NumberOfStep to this.numberofsetp;
     */
    public void setNumberOfStep(int NumberOfStep) {
        this.NumberOfStep = NumberOfStep;
    }

    /**
     *
     * @param Time :Type(integer)Contains the Time of play
     */
    public void setTime(int Time) {
        this.Time = Time;
    }

    /**
     *
     * @return the player name
     */
    public String getName() {
        return Name;
    }

    /**
     *
     * @return the number of step for this player
     */
    public int getNumberOfStep() {
        return NumberOfStep;
    }

    /**
     *
     * @return the time of game for this player
     */
    public int getTime() {
        return Time;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    /**
     * the function compare tow player by there steps
     *
     * @return
     */
    public static PlayStepComparator getTimeComparator() {
        return new PlayStepComparator();
    }

    @Override
    /**
     * the function compare tow player by three times if they had the same time
     * the function called the getStepComparator
     */
    public int compareTo(Player t) {
        if (this.Time - t.getTime() == 0) {
            return getTimeComparator().compare(this, t);
        }
        return this.Time - t.getTime();
    }
}

class PlayStepComparator implements Comparator<Player> {

    @Override
    public int compare(Player t, Player t1) {
        return t.getNumberOfStep() - t1.getNumberOfStep();
    }

}

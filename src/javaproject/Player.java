package javaproject;

/**
 *
 * @author AMER-HY
 */
import java.util.Comparator;
import java.io.Serializable;

public class Player implements Comparable<Player>, Serializable {

    private String Name;
    private int NumberOfStep;
    private int Time;

    public Player(String Name, int NumberOfStep, int Time) {
        this.Name = Name;
        this.NumberOfStep = NumberOfStep;
        this.Time = Time;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setNumberOfStep(int NumberOfStep) {
        this.NumberOfStep = NumberOfStep;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public String getName() {
        return Name;
    }

    public int getNumberOfStep() {
        return NumberOfStep;
    }

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

    public static PlayStepComparator getTimeComparator() {
        return new PlayStepComparator();
    }

    @Override
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

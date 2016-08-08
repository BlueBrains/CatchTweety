package replay;

import javaproject.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Luay
 */
public class SavedGame implements Serializable {

    public Controller Manage;

    public ArrayList<Cell> BaseArray = new ArrayList<>();

    public ArrayList<Cell> getBaseArray() {
        return BaseArray;
    }

    /**
     *
     * @param Manage : Controller Type to Save All player Moves And Features
     */
    public SavedGame(Controller Manage) {
        this.Manage = Manage;
    }

    /**
     *
     * @param Manage : Controller Type to Save All player Moves And Features
     * @param basArrayList : To save the Stage prepartories
     */
    public SavedGame(Controller Manage, ArrayList<Cell> basArrayList) {
        this.Manage = Manage;

        for (Cell m1 : BaseArray) {
            this.BaseArray.add(m1);
        }
    }

}

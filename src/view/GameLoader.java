
package view;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Luay
 */
public class GameLoader implements Serializable{
    ArrayList <String> xName = new ArrayList<String>();
   static int i=0;
   public GameLoader() {}
   /**
    * 
    * @param xName : String (type) contains the name of game you want to load
    * in this constructor we check if the name is added before we save same name by adding static number of game player
    */
    public GameLoader(String xName) {        
      
        if (this.xName.isEmpty())
               this.xName.add(xName);
        else
        {
           if (this.xName.contains(xName))
           {
               i++;
               this.xName.add(xName+i);
           }
           else
               this.xName.add(xName+i);
        }
        
      
    }
    
}

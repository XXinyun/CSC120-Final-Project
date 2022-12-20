import java.util.ArrayList;

/** Room map class */
public class Room{
    
    ArrayList<String> playerRecord;
    
    /** Constructor for the Room class */
    public Room(){
        playerRecord = new ArrayList<String>();
    }
    
    /**
     * adding coordinates to the map method
     * @param x
     * @param y
     */
    public void addMap(int x, int y){ 
        playerRecord.add( "[ " + x + ", " + y + " ]");
    }

    /**
     * printing out the map method or the coordinates you have been to
     */
    public void printMap(){
        System.out.println("You have been to : ");
        System.out.println(playerRecord);
    }

}
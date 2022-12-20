import java.util.ArrayList;

/** Bag class */
public class Bag {
    int size;
    ArrayList<String> items;

    /** Constructor */
    public Bag(int size){
        this.size= size;
        items = new ArrayList<String>(this.size);
        
    }

}

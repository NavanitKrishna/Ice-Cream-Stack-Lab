/**
 * 
 */
package icecream;

import java.util.Stack;

/**
 * 
 * @author Navanit Krishna Satish Kumar
 * @version 2024.09.26
 */
public class IceCreamCone implements IceCreamConeADT {
    private Stack<String> flavors;
    private int numScoops;
    
    /**
     * Constructor for Ice Cream Cone
     */
    public IceCreamCone() {
        this.flavors = new Stack<String>();
        this.numScoops = 0;
    }
    
    /**
     * @return The flavor of scoop removed/eaten
     */
    public String eatScoop() {
        String scoop = null;
        if (!flavors.empty()) {
            scoop = flavors.pop();
            this.numScoops--;
        }
        return scoop;
    }
    
    /**
     * @param flavor
     *            flavor of ice cream that is added
     */
    public void addScoop(String flavor) {
        if (flavor != null) {
            flavors.push(flavor);
            this.numScoops++;
        }
    }
    
    /**
     * @return number of scoops on cone
     */
    public int numScoops() {
        return this.numScoops;
    }
    
    /**
     * @param flavor
     *            Flavor that needs to be checked
     * @return true if the cone already contains flavor
     */
    public boolean contains(String flavor) {
        Stack<String> duplicateStack = new Stack<String>();
        boolean contains = false;
        while (!this.flavors.isEmpty()) {
            String currentFlavor = flavors.peek();
            if (currentFlavor.equals(flavor)) {
                contains = true;
                break;
            }
            duplicateStack.push(flavors.pop());
        }
        while (!duplicateStack.isEmpty()) {
            this.flavors.push(duplicateStack.pop());
        }
        return contains;
    }
    
    /**
     * @return true if there are no ice cream scoops on cone
     */
    public boolean emptyCone() {
        return this.numScoops == 0;
    }
    
    /**
     * @return Flavor of the top of Cone
     */
    public String currentScoop() {
        if (this.flavors.isEmpty()) {
            return null;
        }
        return flavors.peek();
    }
    
    /**
     * 
     * @return String of ice cream flavors
     */
    public String toString() {
        String tsString = "";
        Stack<String> temp = new Stack<String>();
        while (!flavors.isEmpty()) {
            String popFlavor = flavors.pop();
            tsString = popFlavor + ", " + tsString;
            temp.push(popFlavor);
        }
        while (!temp.isEmpty()) {
            flavors.push(temp.pop());
        }
        if (tsString.length() != 0) {
            tsString = tsString.substring(0, tsString.length() - 2);
        }
        return "[" + tsString + "]";
    }
    
    /**
     * Testing if the object is equal to another
     * @param other
     *          other object to check if equal
     * @return boolean that tells us if equal or not
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other == null) || (other.getClass() != this.getClass())) {
            return false;
        }
        return flavors.equals(((IceCreamCone) other).flavors);
    } 
}

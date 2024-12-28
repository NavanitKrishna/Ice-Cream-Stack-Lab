/**
 * 
 */
package icecream;

/**
 * @author Navanit Krishna Satish Kumar
 * @version 2024.09.26
 */
public class IceCreamConeTest extends student.TestCase {
    private IceCreamCone origCone;
    private IceCreamCone idenCone;
    private IceCreamCone otherCone;
    private IceCreamCone emptyCone;
    private IceCreamCone nullCone;
    private String addFlavor;
    
    /**
     * setUp for testing methods in IceCreamCone
     */
    public void setUp() {
        origCone = new IceCreamCone();
        origCone.addScoop("Chocolate");
        origCone.addScoop("Strawberry");
        origCone.addScoop("Cookies and Cream");
        
        idenCone = new IceCreamCone();
        idenCone.addScoop("Chocolate");
        idenCone.addScoop("Strawberry");
        idenCone.addScoop("Cookies and Cream");
        
        otherCone = new IceCreamCone();
        otherCone.addScoop("Mint Chocolate Chip");
        otherCone.addScoop("Mango");
        otherCone.addScoop("Vanilla");
        
        emptyCone = new IceCreamCone();
        
        nullCone = null;
        
        addFlavor = "Blackberry";
    }
    
    /**
     * Test eatScoop Method
     */
    public void testEatScoop() {
        assertEquals(origCone.numScoops(), 3, 0.01);
        origCone.eatScoop();
        assertEquals(origCone.numScoops(), 2, 0.001);
        assertNull(emptyCone.eatScoop());
    }
    
    /**
     * test addScoop Method
     */
    public void testAddScoop() {
        assertEquals(origCone.numScoops(), 3, 0.01);
        origCone.addScoop(addFlavor);
        assertEquals(origCone.numScoops(), 4, 0.01);
        origCone.addScoop(null);
        assertEquals(origCone.numScoops(), 4, 0.01);
    }
    
    /**
     * test numScoops method
     */
    public void testNumScoops() {
        assertEquals(origCone.numScoops(), 3, 0.01);
        origCone.addScoop(addFlavor);
        assertEquals(origCone.numScoops(), 4, 0.01);
        origCone.eatScoop();
        assertEquals(origCone.numScoops(), 3, 0.01);
    }
    
    /**
     * test contains method
     */
    public void testContains() {
        assertFalse(origCone.contains(addFlavor));
        origCone.addScoop(addFlavor);
        assertTrue(origCone.contains(addFlavor));
        assertFalse(origCone.contains(null));
        assertFalse(emptyCone.contains(addFlavor));
        origCone.addScoop("Chocolate");
        assertTrue(origCone.contains("Strawberry"));
        assertTrue(origCone.contains("Chocolate"));
    }
    
    /**
     * test emptyCone method
     */
    public void testEmptyCone() {
        assertTrue(emptyCone.emptyCone());
        assertFalse(origCone.emptyCone());
    }
    
    /**
     * test currentScoop method
     */
    public void testCurrentScoop() {
        origCone.addScoop(addFlavor);
        assertEquals(origCone.currentScoop(), addFlavor);
        assertNull(emptyCone.currentScoop());
    }
    
    /**
     * test toString method
     */
    public void testToString() {
        assertEquals(origCone.toString(), "[Chocolate, Strawberry, "
                + "Cookies and Cream]");
        assertEquals(emptyCone.toString(), "[]");
    }
    
    /**
     * test equals method
     */
    public void testEquals() {
        assertTrue(origCone.equals(origCone));
        assertTrue(origCone.equals(idenCone));
        assertFalse(origCone.equals(otherCone));
        assertFalse(origCone.equals(nullCone));
        assertFalse(origCone.equals(addFlavor));
    }
}

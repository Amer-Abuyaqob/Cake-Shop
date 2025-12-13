package decorators;

import cakes.Cake;

/**
 * Abstract base class for cake decorators following the Decorator pattern.
 * 
 * <p>This class wraps a {@link Cake} instance and delegates method calls to it,
 * allowing concrete decorators to enhance the cake's description and cost without
 * modifying the original cake object.
 * 
 * <p>Concrete decorators (e.g., ChocolateChips, Cream, Skittles) extend this
 * class and pass their decoration name and cost via the constructor. Both the
 * description grammar logic and cost calculation are centralized here.
 * 
 * @author Amer Abuyaqob
 * @version 1.0
 */
public abstract class CakeDecorator extends Cake {
    protected Cake decoratedCake;
    protected double decorationCost;
    protected String decorationName;

    /**
     * Constructs a new CakeDecorator wrapping the given cake.
     * 
     * @param decoratedCake The cake instance to be decorated
     * @param decorationCost The cost of this decoration to be added to the total
     * @param decorationName The name of this decoration (e.g., "Cream", "Chocolate Chips")
     */
    public CakeDecorator(Cake decoratedCake, double decorationCost, String decorationName) {
        super(decoratedCake.getOrderID(), decoratedCake.getBaseName(), 
              decoratedCake.getSize(), decoratedCake.getBasePrice());
        this.decoratedCake = decoratedCake;
        this.decorationCost = decorationCost;
        this.decorationName = decorationName;
    }

    /**
     * Returns the description of the decorated cake.
     * 
     * <p>This method is centralized in the base class and handles grammar properly:
     * <ul>
     *   <li>1st decoration: "Cake with [Decoration]" (only "with")</li>
     *   <li>2nd decoration: "Cake with X and [Decoration]" (one "with", one "and")</li>
     *   <li>3rd+ decorations: "Cake with X, Y, and [Decoration]" (Oxford comma style)</li>
     * </ul>
     * 
     * <p>Concrete decorators pass their decoration name via the constructor and do not
     * need to override this method.
     * 
     * @return A description of the cake with all decorations
     */
    @Override
    public String describe() {
        String baseDescription = this.decoratedCake.describe();
        
        // If no "with" exists, this is the first decoration
        if (!baseDescription.contains("with")) {
            return baseDescription + " with " + this.decorationName;
        }
        
        // If "with" exists but no ", " or " and ", this is the second decoration
        if (!baseDescription.contains(", ") && !baseDescription.contains(" and ")) {
            return baseDescription + " and " + this.decorationName;
        }
        
        // If commas or "and" exist, this is third or later decoration (convert to Oxford comma style)
        int withIndex = baseDescription.indexOf(" with ");
        String beforeWith = baseDescription.substring(0, withIndex);
        String decorations = baseDescription.substring(withIndex + 6); // Everything after " with "
        
        // If it contains ", and ", replace it to add the new decoration
        if (decorations.contains(", and ")) {
            // Replace ", and X" with ", X, and [decorationName]"
            int lastCommaAndIndex = decorations.lastIndexOf(", and ");
            String beforeLast = decorations.substring(0, lastCommaAndIndex);
            String afterLast = decorations.substring(lastCommaAndIndex + 6); // Skip ", and "
            return beforeWith + " with " + beforeLast + ", " + afterLast + ", and " + this.decorationName;
        }
        
        // If it only has " and " (2nd decoration becoming 3rd), convert to Oxford comma style
        if (decorations.contains(" and ")) {
            // Replace "X and Y" with "X, Y, and [decorationName]"
            int andIndex = decorations.lastIndexOf(" and ");
            String first = decorations.substring(0, andIndex);
            String second = decorations.substring(andIndex + 5); // Skip " and "
            return beforeWith + " with " + first + ", " + second + ", and " + this.decorationName;
        }
        
        // Fallback: just add ", and [decorationName]"
        return baseDescription + ", and " + this.decorationName;
    }

    /**
     * Returns the total cost of the decorated cake.
     * 
     * <p>This method is centralized in the base class and adds the decoration cost
     * to the wrapped cake's total cost. Concrete decorators pass their cost via the
     * constructor and do not need to override this method.
     * 
     * @return The total cost including all decorations
     */
    @Override
    public double getCost() {
        return this.decoratedCake.getCost() + this.decorationCost;
    }
}

package decorators;

import cakes.Cake;

/**
 * Concrete decorator that adds chocolate chips to a cake.
 * 
 * <p>This decorator wraps a {@link Cake} instance and enhances it by adding
 * chocolate chips to the description and adding the chocolate chips cost
 * to the total price.
 * 
 * <p>Example usage:
 * <pre>
 * Cake base = new ChocolateCake(1, "Large", 12.50);
 * Cake decorated = new ChocolateChipsDecorator(base);
 * // Result: "Order #1: Chocolate Cake (Large) with Chocolate Chips"
 * // Cost: 12.50 + 2.50 = 15.00
 * </pre>
 * 
 * @author Amer Abuyaqob
 * @version 1.0
 */
public class ChocolateChipsDecorator extends CakeDecorator {
    
    /** The cost of adding chocolate chips to a cake */
    private static final double CHOCOLATE_CHIPS_COST = 2.50;
    
    /** The name of this decoration */
    private static final String CHOCOLATE_CHIPS_NAME = "Chocolate Chips";

    /**
     * Constructs a new ChocolateChipsDecorator wrapping the given cake.
     * 
     * @param decoratedCake The cake instance to be decorated with chocolate chips
     */
    public ChocolateChipsDecorator(Cake decoratedCake) {
        super(decoratedCake, CHOCOLATE_CHIPS_COST, CHOCOLATE_CHIPS_NAME);
    }

}

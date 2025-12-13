package decorators;

import cakes.Cake;

/**
 * Concrete decorator that adds cream to a cake.
 * 
 * <p>This decorator wraps a {@link Cake} instance and enhances it by adding
 * cream to the description and adding the cream cost to the total price.
 * 
 * <p>Example usage:
 * <pre>
 * Cake base = new ChocolateCake(1, "Large", 12.50);
 * Cake decorated = new CreamDecorator(base);
 * // Result: "Order #1: Chocolate Cake (Large) with Cream"
 * // Cost: 12.50 + 2.00 = 14.50
 * </pre>
 *
 * @author Mustafa Abu Saffaqa
 * @version 1.0
 */
public class CreamDecorator extends CakeDecorator {
    
    /** The cost of adding cream to a cake */
    private static final double CREAM_COST = 2.0;
    
    /** The name of this decoration */
    private static final String CREAM_NAME = "Cream";

    /**
     * Constructs a new CreamDecorator wrapping the given cake.
     * 
     * @param decoratedCake The cake instance to be decorated with cream
     */
    public CreamDecorator(Cake decoratedCake) {
        super(decoratedCake, CREAM_COST, CREAM_NAME);
    }

}

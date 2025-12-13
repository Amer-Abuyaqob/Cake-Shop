package decorators;

import cakes.Cake;

/**
 * Concrete decorator that adds skittles to a cake.
 * 
 * <p>This decorator wraps a {@link Cake} instance and enhances it by adding
 * skittles to the description and adding the skittles cost to the total price.
 * 
 * <p>Example usage:
 * <pre>
 * Cake base = new AppleCake(2, "Medium", 10.00);
 * Cake decorated = new SkittlesDecorator(base);
 * // Result: "Order #2: Apple Cake (Medium) with Skittles"
 * // Cost: 10.00 + 1.50 = 11.50
 * </pre>
 * 
 * @author Mustafa Abu Saffaqa
 * @version 1.0
 */
public class SkittlesDecorator extends CakeDecorator {
    
    /** The cost of adding skittles to a cake */
    private static final double SKITTLES_COST = 1.5;
    
    /** The name of this decoration */
    private static final String SKITTLES_NAME = "Skittles";

    /**
     * Constructs a new SkittlesDecorator wrapping the given cake.
     * 
     * @param decoratedCake The cake instance to be decorated with skittles
     */
    public SkittlesDecorator(Cake decoratedCake) {
        super(decoratedCake, SKITTLES_COST, SKITTLES_NAME);
    }

}

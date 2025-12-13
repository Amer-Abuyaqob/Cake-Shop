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
 * class and override {@link #describe()} and {@link #getCost()} to add their
 * specific features and costs.
 * 
 * @author Amer Abuyaqob
 * @version 1.0
 */
public abstract class CakeDecorator extends Cake {
    protected Cake decoratedCake;

    /**
     * Constructs a new CakeDecorator wrapping the given cake.
     * 
     * @param decoratedCake The cake instance to be decorated
     */
    public CakeDecorator(Cake decoratedCake) {
        super(decoratedCake.getOrderID(), decoratedCake.getBaseName(), 
              decoratedCake.getSize(), decoratedCake.getBasePrice());
        this.decoratedCake = decoratedCake;
    }

    /**
     * Returns the description of the decorated cake.
     * Concrete decorators should override this to append their own description.
     * 
     * @return A description of the cake with all decorations
     */
    @Override
    public String describe() {
        return this.decoratedCake.describe();
    }

    /**
     * Returns the total cost of the decorated cake.
     * Concrete decorators should override this to add their own cost.
     * 
     * @return The total cost including all decorations
     */
    @Override
    public double getCost() {
        return this.decoratedCake.getCost();
    }
}

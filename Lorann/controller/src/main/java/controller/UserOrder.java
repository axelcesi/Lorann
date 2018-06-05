package controller;

/**
 * <h1>User Order Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class UserOrder implements IUserOrder {

    private final Order order;
    
    /**
     * Constructor for the UserOrder Class
     * @param order
     */
    public UserOrder(final Order order) {
        this.order = order;
    }

    /** Getter */
    @Override
    public Order getOrder() {
        return this.order;
    }
}
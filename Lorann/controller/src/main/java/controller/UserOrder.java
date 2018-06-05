package controller;

public class UserOrder implements IUserOrder {

    private final Order    order;

    public UserOrder(final Order order) {
        this.order = order;
    }

    @Override
    public Order getOrder() {
        return this.order;
    }
}
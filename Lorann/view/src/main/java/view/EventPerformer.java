package view;

import java.awt.event.KeyEvent;

import controller.IOrderPerformer;
import controller.IUserOrder;
import controller.Order;
import controller.UserOrder;

/**
 * <h1>The EventPerformer Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

class EventPerformer implements IEventPerformer {
    private final IOrderPerformer orderPerformer;

    /**
     * Constructor for the EventPerformer Class
     * @param orderPerformer
     */
    public EventPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

    /**
     * Analyses the keyCode
     */
    public void eventPerform(final KeyEvent keyCode) {
        final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
        if (userOrder != null) {
            this.orderPerformer.orderPerform(userOrder);
        }
    }

    /** Inputs keycode to the user */
    private IUserOrder keyCodeToUserOrder(final int keyCode) {
        IUserOrder userOrder;
        switch (keyCode) {
        case KeyEvent.VK_Z:
            userOrder = new UserOrder(Order.UP);
            break;
        case KeyEvent.VK_D:
            userOrder = new UserOrder(Order.RIGHT);
            break;
        case KeyEvent.VK_S:
            userOrder = new UserOrder(Order.DOWN);
            break;
        case KeyEvent.VK_Q:
            userOrder = new UserOrder(Order.LEFT);
            break;
        case KeyEvent.VK_A:
            userOrder = new UserOrder(Order.UPLEFT);
            break;
        case KeyEvent.VK_E:
            userOrder = new UserOrder(Order.UPRIGHT);
            break;
        case KeyEvent.VK_W:
            userOrder = new UserOrder(Order.DOWNLEFT);
            break;
        case KeyEvent.VK_C:
            userOrder = new UserOrder(Order.DOWNRIGHT);
            break;
            case KeyEvent.VK_CONTROL:
                userOrder = new UserOrder(Order.SHOOT);
                break;
            default:
                userOrder = null;
        }
        return userOrder;
    }
}
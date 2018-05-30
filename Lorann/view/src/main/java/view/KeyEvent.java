package view;

import java.awt.event.KeyEvent;

import controller.IOrderPerformer;
import controller.IUserOrder;
import controller.Order;
import controller.UserOrder;
/*import gameframe.IEventPerformer;*/

public class KeyEvent {
	private final IOrderPerformer orderPerformer;

	public EventPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}
	@Override
	public void KeyEvent(final KeyEvent keyCode) {
		final IUserOrder userOrder = this.keyCodeToUserOrder(keyCode.getKeyCode());
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}
		private IUserOrder keyCodeToUserOrder(final int keyCode) {
			IUserOrder userOrder;
			switch (keyCode) {
				case KeyEvent.VK_UP:
					userOrder = new UserOrder(0, Order.UP);
					break;
				case KeyEvent.VK_RIGHT:
					userOrder = new UserOrder(0, Order.RIGHT);
					break;
				case KeyEvent.VK_DOWN:
					userOrder = new UserOrder(0, Order.DOWN);
					break;
				case KeyEvent.VK_LEFT:
					userOrder = new UserOrder(0, Order.LEFT);
					break;
				case KeyEvent.VK_CONTROL:
					userOrder = new UserOrder(0, Order.SHOOT);
					break;
				default:
					userOrder = null;
			}
			return userOrder;
			}
		
	}
		

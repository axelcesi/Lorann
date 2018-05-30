package model.elements.mobile;

import model.elements.IElement;

public interface IMobile extends IElement{

	public Direction getDirection();
	
	public void setDirection(Direction direction);
	
	public Position getPosition();
	
	public Image getImage();
	
	public void move();
	
	public boolean isPlayer();

}

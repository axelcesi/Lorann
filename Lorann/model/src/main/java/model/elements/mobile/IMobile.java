package model.elements.mobile;

import java.awt.Image;

import model.elements.IElement;
import model.elements.Position;

public interface IMobile extends IElement{

	public Direction getDirection();
	
	public void setDirection(Direction direction);
	
	public Position getPosition();
	
	public Image getImage();
	
	public void move(Direction direction);
	
	public boolean isPlayer();

}

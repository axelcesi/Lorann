package model.elements.mobile;

import java.awt.Image;

import model.elements.IElement;
import model.elements.Position;

/**
 * <h1>The Interface for the Mobile Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public interface IMobile extends IElement{

	public Direction getDirection();
	
	public void setDirection(Direction direction);
	
	public Position getPosition();
	
	public void move(Direction direction);
	
	public String manageCollision(String type);

	public void bounce(Direction direction);

}

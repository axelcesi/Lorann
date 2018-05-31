package model.elements;

import java.awt.Image;

public interface IElement {
		
	public Sprite getSprite();	
	public void setSprite(Sprite sprite);
	public Image getImage();
	public Position getPosition();
	public void setPosition(Position position);
}

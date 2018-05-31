package model.elements;

import java.awt.Image;
import java.io.IOException;

public interface IElement {
		
	public Sprite getSprite();	
	public void setSprite(String sprite) throws IOException;
	public Image getImage();
	public Position getPosition();
	public void setPosition(Position position);
}

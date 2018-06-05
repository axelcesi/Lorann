package model.elements;

import java.awt.Image;
import java.io.IOException;
import model.elements.mobile.Direction;

public interface IElement {
		
	public Sprite getSprite();	
	public void setSprite(String sprite) throws IOException;
	public Image getImage();
	public Position getPosition();
	public void setPosition(Position position);
	public boolean isHero();
	public boolean isMobile();
	public void move(Direction direction);
	public String getType();
}

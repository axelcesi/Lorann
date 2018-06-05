package model.elements;

import java.awt.Image;
import java.io.IOException;

import model.elements.mobile.Direction;

public abstract class Element implements IElement 
{
	protected Position position;
	private Sprite sprite;

	
	protected Element(String sprite, int x, int y) throws IOException
	{
		this.sprite = new Sprite(sprite);
		this.position = new Position(x,y);
	}
	
	public Sprite getSprite()
	{
		return this.sprite;
	}
	
	public void setSprite(String sprite) throws IOException
	{
		this.sprite = new Sprite(sprite);
	}	
	
	public Image getImage()
	{
		return this.getSprite().getImage();
	}
	
	public Position getPosition()
	{
		return this.position;
	}
	
	public boolean isMobile()
	{
		return false;
	}
	public void setPosition(Position position)
	{
		this.position = position;
	}
	
	public boolean isHero()
	{
		return false;
	}
	
	public String getType()
	{
		return " ";
	}
	
	public void move(Direction direction)
	{
		
	}
}

package model.elements;

import java.awt.Image;

public abstract class Element implements IElement 
{
	private Position position;
	private Sprite sprite;

	
	protected Element(Sprite sprite, int x, int y)
	{
		this.sprite = sprite;
		this.position = new Position(x,y);
	}
	
	public Sprite getSprite()
	{
		return this.sprite;
	}
	
	public void setSprite(Sprite sprite)
	{
		this.sprite = sprite;
	}	
	
	public Image getImage()
	{
		return this.getSprite().getImage();
	}
	
	public Position getPosition()
	{
		return this.position;
	}
	
	public void setPosition(Position position)
	{
		this.position = position;
	}
}

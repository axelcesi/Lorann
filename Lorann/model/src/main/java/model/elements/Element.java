package model.elements;

import java.awt.Image;
import java.io.IOException;

import model.elements.mobile.Direction;

/**
 * <h1>Abstract Class for Element, implement IElement</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public abstract class Element implements IElement 
{
	protected Position position;
	private Sprite sprite;

	/**
	 * Constructor for the Element Class
	 * @param sprite
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	protected Element(String sprite, int x, int y) throws IOException
	{
		this.sprite = new Sprite(sprite);
		this.position = new Position(x,y);
	}
	
	/** Getter */
	public Sprite getSprite()
	{
		return this.sprite;
	}
	
	/** Setter */
	public void setSprite(String sprite) throws IOException
	{
		this.sprite = new Sprite(sprite);
	}	
	
	/** Getter */
	public Image getImage()
	{
		return this.getSprite().getImage();
	}
	
	/** Getter */
	public Position getPosition()
	{
		return this.position;
	}
	
	/** Boolean testing method */
	public boolean isMobile()
	{
		return false;
	}
	
	/** Setter */
	public void setPosition(Position position)
	{
		this.position = position;
	}
	
	/** Boolean testing method */
	public boolean isHero()
	{
		return false;
	}
	
	/** Getter */
	public String getType()
	{
		return "";
	}
	
	/** Deprecated or not used in this project
	 * @deprecated
	 */
	public void move(Direction direction)
	{
		
	}
}

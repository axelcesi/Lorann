package model.elements.mobile;

import model.elements.Position;
import model.elements.Sprite;

public abstract class Mobile implements IMobile{

	private Sprite sprite;
	private Position position;
	private Direction direction;
	
	Mobile(Sprite sprite, Position position, Direction direction)
	{
		
	}
	
	public Direction getDirection()
	{
		
	}
	
	public void setDirection(Direction direction)
	{
		
	}
	
	public Position getPosition()
	{
		
	}
	
	public void move(Direction direction)
	{
		
	}
	
	public boolean isPlayer()
	{
		
	}
	
	public boolean isSpell()
	{
		
	}
	
	public Image getImage()
	{
		
	}
	
	public void die()
	{
		
	}
	
	public void manageCollision()
	{
		
	}
	
}

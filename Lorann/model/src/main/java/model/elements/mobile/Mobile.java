package model.elements.mobile;

import java.awt.Image;
import java.io.IOException;

import model.elements.Element;
import model.elements.Position;
import model.elements.Sprite;

public abstract class Mobile extends Element implements IMobile{

	private Sprite sprite;
	private Position position;
	private Direction direction;
	
	Mobile(String sprite, int x, int y, Direction direction) throws IOException
	{
		super(sprite, x, y);
		this.direction = direction;
	}
	
	public Direction getDirection()
	{
		return this.direction;
	}
	
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	public Position getPosition()
	{
		return this.position;
	}
	
	public void move(Direction direction)
	{
		switch (direction) {
		case UP:
			this.position.setY(this.position.getY()-1);
			break;
		case RIGHT:
			this.position.setX(this.position.getX()+1);
			break;
		case DOWN:
			this.position.setY(this.position.getY()+1);
			break;
		case LEFT:
			this.position.setX(this.position.getX()-1);
			break;
		case UPRIGHT:
			this.position.setX(this.position.getX()+1);
			this.position.setY(this.position.getY()-1);
			break;
		case UPLEFT:
			this.position.setX(this.position.getX()-1);
			this.position.setY(this.position.getY()-1);
			break;
		case DOWNRIGHT:
			this.position.setX(this.position.getX()+1);
			this.position.setY(this.position.getY()+1);
			break;
		case DOWNLEFT:
			this.position.setX(this.position.getX()-1);
			this.position.setY(this.position.getY()+1);
			break;
		case NOP:
			break;
		default:
			break;
		}
	}
	
	public boolean isPlayer()
	{
		return false;
	}
	
	public boolean isSpell()
	{
		return false;
	}
	
	public void die()
	{
		//this.position = NULL;
		//this.sprite = NULL;
	}
	
	public void manageCollision(Direction direction)
	{
		
	}
	
}

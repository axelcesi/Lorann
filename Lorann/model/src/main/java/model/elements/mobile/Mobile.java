package model.elements.mobile;


import java.io.IOException;

import model.elements.Element;
import model.elements.Position;


public abstract class Mobile extends Element implements IMobile{

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
	
	public int getX()
	{
		return this.getPosition().getX();
	}
	
	public void move(Direction direction)
	{
		switch (direction) {
		case UP:
			this.position.setY(this.position.getY()-32);
			break;
		case RIGHT:
			this.position.setX(this.position.getX()+32);
			break;
		case DOWN:
			this.position.setY(this.position.getY()+32);
			break;
		case LEFT:
			this.position.setX(this.position.getX()-32);
			break;
		case UPRIGHT:
			this.position.setX(this.position.getX()+32);
			this.position.setY(this.position.getY()-32);
			break;
		case UPLEFT:
			this.position.setX(this.position.getX()-32);
			this.position.setY(this.position.getY()-32);
			break;
		case DOWNRIGHT:
			this.position.setX(this.position.getX()+32);
			this.position.setY(this.position.getY()+32);
			break;
		case DOWNLEFT:
			this.position.setX(this.position.getX()-32);
			this.position.setY(this.position.getY()+32);
			break;
		case NOP:
			break;
		default:
			break;
		}
	}
	
	public void bounce(Direction direction)
	{
		switch (direction) {
		case UP:
			this.setDirection(Direction.DOWN);
			break;
		case RIGHT:
			this.setDirection(Direction.LEFT);
			break;
		case DOWN:
			this.setDirection(Direction.UP);
			break;
		case LEFT:
			this.setDirection(Direction.RIGHT);
			break;
		case UPRIGHT:
			this.setDirection(Direction.DOWNLEFT);
			break;
		case UPLEFT:
			this.setDirection(Direction.DOWNRIGHT);
			break;
		case DOWNRIGHT:
			this.setDirection(Direction.UPLEFT);
			break;
		case DOWNLEFT:
			this.setDirection(Direction.UPRIGHT);
			break;
		default:
			break;
		}
	}
	
	public boolean isMobile()
	{
		return true;
	}
	
	public boolean isPlayer()
	{
		return false;
	}
	
	public boolean isSpell()
	{
		return false;
	}
	
	public boolean isMonster()
	{
		return false;
	}
	
	public void die()
	{
		//this.position = NULL;
		//this.sprite = NULL;
	}
	
	public String manageCollision(String type)
	{
		return "not implemented";
		
	}
	
}

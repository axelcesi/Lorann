package model.elements.mobile;


import java.io.IOException;

import model.elements.Element;
import model.elements.Position;

/**
 * <h1>The Mobile Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public abstract class Mobile extends Element implements IMobile{

	private Direction direction;
	
	/**
	 * Constructor for the Mobile Class
	 * @param sprite
	 * @param x
	 * @param y
	 * @param direction
	 * @throws IOException
	 */
	Mobile(String sprite, int x, int y, Direction direction) throws IOException
	{
		super(sprite, x, y);
		this.direction = direction;
	}
	
	/** Getter */
	public Direction getDirection()
	{
		return this.direction;
	}
	
	/** Setter */
	public void setDirection(Direction direction)
	{
		this.direction = direction;
	}
	
	/** Getter */
	public Position getPosition()
	{
		return this.position;
	}
	
	/**
	 * Depending on direction, makes move a mobile object
	 * @param direction (type Direction)
	 */
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
	
	/**
	 * Method used for the bouncing of mobile objects
	 * @param direction (type Direction)
	 */
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
	
	/** Boolean testing method */
	public boolean isMobile()
	{
		return true;
	}
}

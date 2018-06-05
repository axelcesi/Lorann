package model.elements;

/**
 * <h1>The Position Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Position {
	
	private int x;
	private int y;

	/** 
	 * Constructor used for the Position Class, needs an x&y
	 * @param x
	 * @param y
	 */
	Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor for the Position Class, needs a position object
	 * @param position
	 */
	Position(Position position)
	{
		this.x = position.x;
		this.y = position.y;
	}
	
	/** Getter */
	public int getX()
	{
		return this.x;
	}
	
	/** Setter */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/** Getter */
	public int getY()
	{
		return this.y;
	}
	
	/** Setter */
	public void setY(int y)
	{
		this.y = y;
	}
}

package model.elements;

public class Position {
	
	private int x;
	private int y;

	

	Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	Position(Position position)
	{
		this.x = position.x;
		this.y = position.y;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public void setX(int x)
	{
		this.x = x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
}

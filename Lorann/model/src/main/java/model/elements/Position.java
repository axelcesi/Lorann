package model.elements;

public class Position {
	
	private int x;
	private int y;
	private int maxX = 1;
	private int maxY = 1;
	

	Position(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	Position(Position position)
	{
		this.x = position.x;
		this.y = position.y;
		this.maxX = position.maxX;
		this.maxY = position.maxY;
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
	
	protected void setMaxX(int maxX)
	{
		this.maxX = maxX;
	}
	
	protected void setMaxY(int maxY)
	{
		this.maxY = maxY;
	}
}

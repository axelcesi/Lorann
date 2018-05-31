package model.elements;

public class Position {
	
	private int x;
	private int y;
	private int maxX;
	private int maxY;
	
	Position(int x, int y, int maxX, int maxY)
	{
		this.x = x;
		this.y = y;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	Position(int x, int y)
	{
		this.x = x;
		this.y = y;
		this.maxX = 200;
		this.maxY = 200;
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

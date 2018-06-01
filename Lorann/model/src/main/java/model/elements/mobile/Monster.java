package model.elements.mobile;

import model.elements.Position;
import model.elements.Sprite;

public class Monster extends Mobile{
	private int type;
	
	Monster(int x, int y, Direction direction, int type)
	{
		switch (type)
		{
		case 1 : super("monster1.png", x, y, direction);
			break;
		}
		
	}
	
	public void die()
	{
		
	}
	
	public void manageCollision()
	{
		
	}
	
	public void move()
	{
		
	}
}

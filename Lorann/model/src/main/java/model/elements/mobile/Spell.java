package model.elements.mobile;

import model.elements.Position;
import model.elements.Sprite;

public class Spell extends Mobile{

	public Sprite sprite = new Sprite("fireball.png");
	
	Spell(int x, int y, Direction direction)
	{
		super(sprite, x, y ,direction);
	}
	
	public void manageCollision()
	{
		
	}
	
	public void move()
	{
		
	}
}

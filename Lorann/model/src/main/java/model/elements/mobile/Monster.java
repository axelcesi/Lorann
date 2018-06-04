package model.elements.mobile;

import java.io.IOException;

import model.elements.Position;
import model.elements.Sprite;

public class Monster extends Mobile{
	private int type;
	
	Monster(int x, int y, int type) throws IOException
	{
		super("monster_1.png", x, y, Direction.NOP);
		this.setSprite("monster_"+type+".png");
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

package model.elements.mobile;

import java.io.IOException;

import model.elements.Position;
import model.elements.Sprite;

public class Spell extends Mobile{


	Spell(int x, int y, Direction direction) throws IOException
	{
		super("fireball.png", x, y ,direction);
	}
	
	public void manageCollision()
	{
		
	}
	
	public boolean isSpell()
	{
		return true;
	}
	
	public String getType()
	{
		return "Spell";
	}
}

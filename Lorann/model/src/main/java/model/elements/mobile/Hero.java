package model.elements.mobile;

import java.io.IOException;

import model.elements.Position;
import model.elements.Sprite;

public class Hero extends Mobile{
	private static String SPRITE = "lorann_l.png";
	
	public Hero(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Direction.NOP);		
	}
	
	public void die()
	{
		
	}
	
	
	public void launchSpell(Direction direction)
	{
		switch(direction)
		{
		case UP:
			Spell spell = new Spell(this.getPosition().getX(), this.getPosition().getY() + 1, Direction.DOWN);
			break;
		case RIGHT:
			Spell spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY(), Direction.LEFT);
			break;
		case DOWN:
			Spell spell = new Spell(this.getPosition().getX(), this.getPosition().getY() - 1, Direction.UP);
			break;
		case LEFT:
			Spell spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY(), Direction.RIGHT);
			break;
		case UPRIGHT:
			Spell spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY() + 1, Direction.DOWNLEFT);
			break;
		case UPLEFT:
			Spell spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() + 1, Direction.DOWNRIGHT);
			break;
		case DOWNRIGHT:
			Spell spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY() - 1, Direction.UPLEFT);
			break;
		case DOWNLEFT:
			Spell spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() - 1, Direction.UPRIGHT);
			break;
		case NOP :
			break;
		}
		//Spell spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), direction);
	}
	
	public void manageCollision()
	{
		
	}
}

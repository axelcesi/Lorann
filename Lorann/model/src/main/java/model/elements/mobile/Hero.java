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
		Spell spell;
		switch(direction)
		{
		case UP:
			spell = new Spell(this.getPosition().getX(), this.getPosition().getY() + 1, Direction.DOWN);
			break;
		case RIGHT:
			spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY(), Direction.LEFT);
			break;
		case DOWN:
			spell = new Spell(this.getPosition().getX(), this.getPosition().getY() - 1, Direction.UP);
			break;
		case LEFT:
			spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY(), Direction.RIGHT);
			break;
		case UPRIGHT:
			spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY() + 1, Direction.DOWNLEFT);
			break;
		case UPLEFT:
			spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() + 1, Direction.DOWNRIGHT);
			break;
		case DOWNRIGHT:
			spell = new Spell(this.getPosition().getX() - 1, this.getPosition().getY() - 1, Direction.UPLEFT);
			break;
		case DOWNLEFT:
			spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() - 1, Direction.UPRIGHT);
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

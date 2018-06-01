package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;


public class Hero extends Mobile{
	
	public Hero(int x, int y) throws IOException
	{
		super("lorann_l.png", x, y, Direction.NOP);		
	}
	
	public void die()
	{
		
	}
	
	
	public Element launchSpell(Direction direction) throws IOException
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
			spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() - 1, Direction.UPRIGHT);
			break;
		default:
			spell = new Spell(this.getPosition().getX() + 1, this.getPosition().getY() - 1, Direction.UPRIGHT);
			break;
			
		}
		return spell;
		//Spell spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), direction);
	}
	
	public void manageCollision()
	{
		
	}
	public boolean isPlayer()
	{
		return true;
	}
	
}

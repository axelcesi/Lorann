package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;


public class Hero extends Mobile implements Runnable{
	
	private boolean hasSpell;
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
	public boolean isHero()
	{
		return true;
	}
	
	public void run()
	{
		while (true)
		{
			switch (this.getDirection())
			{
			case UP :
				try {
					this.setSprite("lorann_up.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case NOP :
				switch (this.getSprite().getImageName())
				{
				case "lorann_l.png" :
					try {
						this.setSprite("lorann_ul.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_ul.png" :
					try {
						this.setSprite("lorann_u.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_u.png" :
					try {
						this.setSprite("lorann_ur.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_ur.png" :
					try {
						this.setSprite("lorann_r.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_r.png" :
					try {
						this.setSprite("lorann_br.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_br.png" :
					try {
						this.setSprite("lorann_b.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_b.png" :
					try {
						this.setSprite("lorann_bl.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
				case "lorann_bl.png" :
					try {
						this.setSprite("lorann_l.png");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;
					
				}
				break;
			default :
				break;
			}		
		}		
	}
	
}

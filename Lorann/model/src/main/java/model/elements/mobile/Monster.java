package model.elements.mobile;

import java.io.IOException;

/**
 * <h1>The Monster Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Monster extends Mobile{
	private int type;
	
	/** 
	 * The Constructor for the Monster Class, needs a type and x&y
	 * @param x
	 * @param y
	 * @param type
	 * @throws IOException
	 */
	Monster(int x, int y, int type) throws IOException
	{
		super("monster_1.png", x, y, Direction.NOP);
		switch (type)
		{
		case 1:			
			this.setSprite("monster_"+type+".png");
			this.setDirection(Direction.LEFT);
			break;
		case 2:
			this.setSprite("monster_"+type+".png");
			this.setDirection(Direction.RIGHT);
			break;
		case 3:
			this.setSprite("monster_"+type+".png");
			this.setDirection(Direction.UP);
			break;
		case 4:
			this.setSprite("monster_"+type+".png");
			this.setDirection(Direction.UPLEFT);
			break;
			
		}
	}
	
	/**
	 * Bouncing method
	 * @param direction (Type Direction)
	 */
	public void bounce(Direction direction)
	{
		switch (direction) {
		case UP:
			this.setDirection(Direction.DOWN);
			break;
		case RIGHT:
			this.setDirection(Direction.LEFT);
			break;
		case DOWN:
			this.setDirection(Direction.UP);
			break;
		case LEFT:
			this.setDirection(Direction.RIGHT);
			break;
		case UPRIGHT:
			this.setDirection(Direction.DOWNRIGHT);
			break;
		case UPLEFT:
			this.setDirection(Direction.DOWNLEFT);
			break;
		case DOWNRIGHT:
			this.setDirection(Direction.UPLEFT);
			break;
		case DOWNLEFT:
			this.setDirection(Direction.UPRIGHT);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Method to manage collision for the monsters
	 * @param type (String)
	 */
	public String manageCollision(String type)
	{
		switch (type)
		{
		case "bone":
			return "bounce";
		case "void":
			return "pass";
		case "purse":
			return "bounce";
		case "crystalBall":
			return "bounce";
		case "gateClosed":
			return "bounce";
		case "gateOpen":
			return "bounce";
		case "spell":
			return "die";
		case "monster":
			return "bounce";
		case "hero":
			return "kill hero";
		default:
			return "type error";
		}
		
	}
	
	/** Getter */
	public String getType()
	{
		return "monster";
	}
	
	/** Boolean testing method */
	public boolean isMonster()
	{
		return true;
	}
	
}

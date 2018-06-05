package model.elements.mobile;

import java.io.IOException;

public class Monster extends Mobile{
	private int type;
	
	Monster(int x, int y, int type) throws IOException
	{
		super("monster_1.png", x, y, Direction.LEFT);
		this.setSprite("monster_"+type+".png");
	}
	
	public void die()
	{
		
	}
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
			this.setDirection(Direction.DOWNLEFT);
			break;
		case UPLEFT:
			this.setDirection(Direction.DOWNRIGHT);
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
	
	public String getType()
	{
		return "monster";
	}
	public void move()
	{
		
	}
	
	public boolean isMonster()
	{
		return true;
	}
	
}

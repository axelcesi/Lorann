package model.elements.mobile;

import java.io.IOException;

/**
 * <h1>The Spell Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Spell extends Mobile implements Runnable{


	private static final long TIME_SLEEP = 100;

	/**
	 * Constructor for the Class Spell, needs x&y and a direction
	 * @param x
	 * @param y
	 * @param direction
	 * @throws IOException
	 */
	Spell(int x, int y, Direction direction) throws IOException
	{
		super("fireball_1.png", x, y ,direction);
	}
	
	/**
	 * Manages collision for the spell
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
		case "hero":
			return "spellpicked";
		case "monster":
			return "kill";
		default:
			return "type error";
		}		
	}
	
	/**
	 * Manages the bounce of the spell
	 * @param direction (type Direction)
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
	
	/**
	 * Animates the spell
	 */
	public void run()
	{
	 while (true)
        {
            try {
                Thread.sleep(TIME_SLEEP);
            } catch (InterruptedException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            switch (this.getSprite().getImageName())
            {
            case "fireball_1.png": 
                try {
                    this.setSprite("fireball_2.png");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case "fireball_2.png" :
                try {
                    this.setSprite("fireball_3.png");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case "fireball_3.png" :
                try {
                    this.setSprite("fireball_4.png");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case "fireball_4.png" :
                try {
                    this.setSprite("fireball_5.png");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            case "fireball_5.png" :
                try {
                    this.setSprite("fireball_1.png");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            }
        }
	}
	
	/** Boolean testing method */
	public boolean isSpell()
	{
		return true;
	}
	
	/** Getter */
	public String getType()
	{
		return "spell";
	}
}

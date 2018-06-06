package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;

/**
 * <h1>The Hero Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Hero extends Mobile implements Runnable{
	
	private static int TIME_SLEEP = 100;
	private boolean hasSpell = true;
	
	/**
	 * The constructor for the Hero Class, needs an x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	public Hero(int x, int y) throws IOException
	{
		super("lorann_l.png", x, y, Direction.NOP);	
	}
	
	/** Getter */
	public String getType()
	{
		return "hero";
	}
	
	/** Boolean testing Method */
	public boolean isHero()
	{
		return true;
	}

	/** Method used to reset spell when picked */
	public void pickSpell()
	{
		this.hasSpell = true;
	}
	
	/** Checks if the spell is available */
	public boolean hasSpell()
	{
		return hasSpell;
	}
	
	/** 
	 * Method used to manage collision between objects depending on types
	 * @param type
	 * @return stringMessage
	 */
	public String manageCollision(String type)
	{
		switch (type)
		{
		case "bone":
			return "block";
		case "void":
			return "pass";
		case "purse":
			return "pick";
		case "crystalBall":
			return "pick&open";
		case "gateClosed":
			return "trap";
		case "gateOpen":
			return "win";
		case "spell":
			return "pickspell";
		case "monster":
			return "game over";
		default:
			return "type error";
		}
		
	}
	
	/** 
	 * Method used to launch Lorann's spell
	 * @param direction
	 * @return
	 * @throws IOException
	 */
	public Element launchSpell(final Direction direction) throws IOException
    {
        Spell spell;
        this.hasSpell = false;
        this.getPosition();

        switch(this.getDirection())
        {
        case UP:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.DOWN);
            break;
        case RIGHT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.LEFT);
            break;
        case DOWN:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.UP);
            break;
        case LEFT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.RIGHT);
            break;
        case UPRIGHT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.DOWNLEFT);
            break;
        case UPLEFT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.DOWNRIGHT);
            break;
        case DOWNRIGHT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.UPLEFT);
            break;
        case DOWNLEFT:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.UPRIGHT);
            break;
        case NOP :
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.RIGHT);
            break;
        default:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY(), Direction.RIGHT);
            break;
        }
        Thread tSpell = new Thread(spell);
        tSpell.start();
        return spell;
    }
		
	/** Animates Loran */
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
		}
			/*switch (this.getDirection())
			{
			case UP :
				try {
					this.setSprite("lorann_u.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case UPRIGHT :
				try {
					this.setSprite("lorann_ur.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case RIGHT :
				try {
					this.setSprite("lorann_r.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case DOWNRIGHT :
				try {
					this.setSprite("lorann_dr.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case DOWN :
				try {
					this.setSprite("lorann_d.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case DOWNLEFT :
				try {
					this.setSprite("lorann_dl.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case LEFT :
				try {
					this.setSprite("lorann_.png");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case UPLEFT :
				try {
					this.setSprite("lorann_ul.png");
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
		}	*/	
	}
}

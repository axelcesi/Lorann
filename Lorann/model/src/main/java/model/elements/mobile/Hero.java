package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;


public class Hero extends Mobile implements Runnable{
	
	private static int TIME_SLEEP = 100;
	private boolean hasSpell = true;
	
	public Hero(int x, int y) throws IOException
	{
		super("lorann_l.png", x, y, Direction.NOP);	
	}
	
	public void die()
	{
		
	}
	
	public void pickSpell()
	{
		hasSpell = true;
	}
	
	public String getType()
	{
		return "hero";
	}
	
	public void tryMove()
	{
		
	}
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
			return "die";
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
	
	public Element launchSpell(final Direction direction) throws IOException
    {
        Spell spell;
        this.hasSpell = false;
        this.getPosition();

        switch(this.getDirection())
        {
        case UP:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY() + 32, Direction.DOWN);
            break;
        case RIGHT:
            spell = new Spell(this.getPosition().getX() - 32, this.getPosition().getY(), Direction.LEFT);
            break;
        case DOWN:
            spell = new Spell(this.getPosition().getX(), this.getPosition().getY() - 32, Direction.UP);
            break;
        case LEFT:
            spell = new Spell(this.getPosition().getX() + 32, this.getPosition().getY(), Direction.RIGHT);
            break;
        case UPRIGHT:
            spell = new Spell(this.getPosition().getX() - 32, this.getPosition().getY() + 32, Direction.DOWNLEFT);
            break;
        case UPLEFT:
            spell = new Spell(this.getPosition().getX() + 32, this.getPosition().getY() + 32, Direction.DOWNRIGHT);
            break;
        case DOWNRIGHT:
            spell = new Spell(this.getPosition().getX() - 32, this.getPosition().getY() - 32, Direction.UPLEFT);
            break;
        case DOWNLEFT:
            spell = new Spell(this.getPosition().getX() + 32, this.getPosition().getY() - 32, Direction.UPRIGHT);
            break;
        case NOP :
            spell = new Spell(this.getPosition().getX() + 32, this.getPosition().getY(), Direction.RIGHT);
            break;
        default:
            spell = new Spell(this.getPosition().getX() + 32, this.getPosition().getY(), Direction.RIGHT);
            break;

        }
        Thread tSpell = new Thread(spell);
        tSpell.start();
        return spell;
    }
	

	public boolean isHero()
	{
		return true;
	}
	
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

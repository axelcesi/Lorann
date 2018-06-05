package controller;
import java.io.IOException;


import model.IModel;
import model.Model;
import model.elements.IElement;
import model.elements.mobile.Direction;
import model.elements.mobile.Hero;
import model.elements.mobile.Mobile;
import view.View;

public class Controller implements IOrderPerformer {
	private static int TIME_SLEEP = 30;
    private View  view;
    private boolean	isGameOver	= false;
    private final IModel model;

    public Controller(final Model model) {
        this.model = model;
    }
    
    public void setView(final View view) {
		this.view = view;
	}
    
    public void orderPerform(final IUserOrder userOrder) {
        if (userOrder != null) {
            final Hero hero = (Hero) this.model.getHero();
            if (hero != null) {
            }
                Direction direction = null;
                switch (userOrder.getOrder()) {
                    case UP:
                        direction = Direction.UP;
                        break;
                    case RIGHT:
                        direction = Direction.RIGHT;
                        break;
                    case DOWN:
                        direction = Direction.DOWN;
                        break;
                    case LEFT:
                        direction = Direction.LEFT;
                        break;
                    case UPRIGHT:
                        direction = Direction.UPRIGHT;
                        break;
                    case UPLEFT:
                        direction = Direction.UPLEFT;
                        break;
                    case DOWNRIGHT:
                        direction = Direction.DOWNRIGHT;
                        break;
                    case DOWNLEFT:
                        direction = Direction.DOWNLEFT;
                        break;
                    case SHOOT:
                        try {
                            model.addElement(hero.launchSpell(hero.getDirection()));
                        } catch (final IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case NOP:
                        direction = Direction.NOP;
                        break;
                    default:
                        direction = Direction.NOP;
                        break;
                }
                //hero.setDirection(direction);
                tryMove(direction, hero);

            }
        }

    private void tryMove(Direction direction, Mobile mobile) 
    {
    	IElement element = this.model.getNextElement(mobile.getPosition(),direction);
    	String type;
    	if (element != null)
    		type = element.getType();
    	else type = "void";
    	
    	switch (mobile.manageCollision(type))
    	{
    	case "block":
    		break;
    	case "pass":
    		mobile.move(direction);
    		break;
    	case "pick":
    		mobile.move(direction);
    		model.removeElement(element);
    		break;
    	case "pick&open":
    		mobile.move(direction);
    		model.removeElement(element);
    		try {
				model.getGate().open();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		break;
    	case "die":
    		//mobile.die();
    		this.isGameOver=true;
    		break;
    	default:
    		break;
    	}		
	}

	/**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
   public void start()  {
        this.play();
    }
   
    public void play() {
		this.gameLoop();
		this.view.displayMessage("Game Over !");
		this.view.closeAll();
	}

	private void gameLoop() {
		
		while(isGameOver == false)
		{
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			//System.out.println("loop");
			
			/*//ArrayList<IElement> mobiles = new ArrayList<IElement>();
			for (IElement mobile : this.model.getElements())
			{
				if (mobile.isMobile() == true)
					mobile.move();
			}
			*/
			this.model.setMobilesHavesMoved();
		}
			/*
			for(int i = 0; i < 12; i++)
			{
				for (int j = 0; j < 20; j++)
				{
					if (mobiles[i][j].isMobile() == true)
					{
						mobiles[i][j].move();
					}
				}
			}*/
			
		
	
			
	}
/*
			//final Element[][] elements = new Elements[]();
			for (final Element mobile : this.model.getElement()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
				mobile.move();
				if (mobile.isSpell()) {
					this.manageCollision(mobile);
				}
			}
			this.model.setMobilesHavesMoved();*/

   /* private void lauchSpell(final int player) throws IOException {
		final IMobile lorran = this.model.getMobileByPlayer(player);
		if (lorran != null) {
			final Position position = new Position(lorran.getPosition().getX() + ((lorran.getWidth() - Spell.getWidthWithADirection(lorran.getDirection())) / 2),
					lorran.getPosition().getY() + ((lorran.getHeight() - Spell.getHeightWithADirection(lorran.getDirection())) / 2));
			this.model.addMobile(new Spell(lorran.getDirection(), position));
			switch (lorran.getDirection()) {
				case UP:
					position.setY(position.getY() - lorran.getHeight() - lorran.getSpeed());
					break;
				case RIGHT:
					position.setX(position.getX() + lorran.getWidth() + lorran.getSpeed());
					break;
				case DOWN:
					position.setY(position.getY() + lorran.getHeight() + lorran.getSpeed());
					break;
				case LEFT:
					position.setX(position.getX() - lorran.getWidth() - lorran.getSpeed());
					break;
				default:
					break;
			}
		}
	}*/
    
   /* private boolean isSpellOnMobile(final IMobile mobile, final IMobile spell) {
		if (((spell.getPosition().getX() / spell.getWidth()) >= (mobile.getPosition().getX() / spell.getWidth()))
				&& ((spell.getPosition().getX() / spell.getWidth()) <= ((mobile.getPosition().getX() + mobile.getWidth()) / spell.getWidth()))) {
			if (((spell.getPosition().getY() / spell.getHeight()) >= (mobile.getPosition().getY() / weapon.getHeight()))
					&& ((spell.getPosition().getY() / spell.getHeight()) <= ((mobile.getPosition().getY() + mobile.getHeight()) / spell.getHeight()))) {
				return true;
			}
		}
		return false;
	}
    
   /* private void manageCollision(final IMobile spell) {
		final ArrayList<IMobile> target = new ArrayList<IMobile>();
		boolean isTargetHit = false;

		for (final IMobile mobile : this.model.getMobiles()) {
			if (this.isSpellOnMobile(mobile, spell)) {
				target.add(mobile);
			}
		}
		for (final IMobile mobile : target) {
		)	isTargetHit = isTargetHit || mobile.hit();
		}
		if (isTargetHit) {
			this.model.removeMobile(spell);
			this.isGameOver = true;
		}
	}*/
    /**
     * Gets the view.
     *
     * @return the view
     */
    /*public IView getView() {
        return this.viewSysteme;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
   /* public IModel getModel() {
        return this.model;
    }
    public void setViewSystem(final IView viewSysteme) {
		this.viewSysteme = viewSysteme;
	}*/
}

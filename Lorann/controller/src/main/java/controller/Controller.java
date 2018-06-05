package controller;
import java.io.IOException;

import model.IModel;
import model.Model;
import model.elements.IElement;
import model.elements.mobile.Direction;
import model.elements.mobile.Hero;
import model.elements.mobile.IMobile;
import view.IView;
import view.View;

public class Controller implements IOrderPerformer {
	private static int TIME_SLEEP = 100;
    private IView  view;
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
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case RIGHT:
                        direction = Direction.RIGHT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case DOWN:
                        direction = Direction.DOWN;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case LEFT:
                        direction = Direction.LEFT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case UPRIGHT:
                        direction = Direction.UPRIGHT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case UPLEFT:
                        direction = Direction.UPLEFT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case DOWNRIGHT:
                        direction = Direction.DOWNRIGHT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case DOWNLEFT:
                        direction = Direction.DOWNLEFT;
                        hero.setDirection(direction);
                        tryMove(direction, hero);
                        break;
                    case SHOOT:
                        try {
                        	if (hero.hasSpell())
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


            }
        }

    private void tryMove(Direction direction, IMobile mobile) 
    {
    	IElement element = this.model.getNextElement(mobile.getPosition(),direction);
    	String type;
    	if (element != null)
    		type = element.getType();
    	else type = "void";
    	
    	Hero hero;
    	
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
    	case "bounce":
    		mobile.bounce(direction);
    		break;
    	case "game over":
    		model.removeElement(mobile);
    		this.isGameOver = true;
      		break;
     	case "kill hero":
    		model.removeElement(element);
    		this.isGameOver = true;
      		break;
    	case "pickspell":
    		hero = (Hero) this.model.getHero();
    		hero.pickSpell();
    		model.removeElement(element);
    		mobile.move(direction);
    		break;
    	case "spellpicked":
    		hero = (Hero) this.model.getHero();
    		hero.pickSpell();
    		model.removeElement(mobile);
    		break;
    	case "kill":
    		hero = (Hero) this.model.getHero();
    		hero.pickSpell();
    		mobile.move(direction);
    		model.removeElement(mobile);
    		model.removeElement(element);
      		break;
    	case "die":
    		hero = (Hero) this.model.getHero();
    		hero.pickSpell();
    		mobile.move(direction);
    		model.removeElement(mobile);
    		model.removeElement(element);
      		break;
    	case "win":
    		model.removeElement(mobile);
    		this.view.displayMessage("YOU WIN !");
    		this.view.closeAll();
    		
    		
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
			//this.model.setMobilesHavesMoved();
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			//System.out.println("loop");
			

			
			for (IMobile mobile : this.model.getMobiles())
			{
				if (mobile.getType() == "monster" || mobile.getType() == "spell")
				{
					this.tryMove(mobile.getDirection(), mobile);
				}
				//mobile.setDirection(Direction.LEFT);
				//this.tryMove(mobile.getDirection(), mobile);
			}
			
			this.model.setMobilesHavesMoved();
		}
	}
	public void setView(final IView view) {
		this.view = view;
	}
}

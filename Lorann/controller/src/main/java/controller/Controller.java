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

/**
 * <h1>The Controller Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Controller implements IOrderPerformer {
	private static int TIME_SLEEP = 100;
    private IView  view;
    private boolean	isGameOver	= false;
    private final IModel model;

    /**
     * Constructor for the Controller Class
     * @param model
     */
    public Controller(final Model model) {
        this.model = model;
    }
    
    /** Setter */
    public void setView(final View view) {
		this.view = view;
	}
   
    /** 
     * Used to determine with an input the adequate move
     * @param userOrder
     */
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

    /** 
     * Method used to determine what to do depending on the type of element encountered
     * @param direction
     * @param mobile
     */
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
    	case "trap":
    		model.removeElement(mobile);
    		this.isGameOver = true;
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

	/** Calls in the play method for the object */
   public void start()  {
        this.play();
    }
   
   /** The play method */
    public void play() {
		this.gameLoop();
		this.view.displayMessage("Game Over !");
		this.view.closeAll();
	}

    /** Method used to start the game */
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
	
	/** Setter */
	public void setView(final IView view) {
		this.view = view;
	}
}

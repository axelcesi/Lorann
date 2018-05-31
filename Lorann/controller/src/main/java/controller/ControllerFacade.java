package controller;
import java.io.IOException;
import java.util.ArrayList;

import model.Direction;
import model.IModel;
import model.IMobile;
import model.Spell;
import model.Position;
import view.IView;
/**
 * <h1>The Class ControllerFacade provides a facade of the Controller component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ControllerFacade implements IController {
	private static int TIME_SLEEP = 30;
    /** The view. */
    private final IView  view;
    private boolean	isGameOver	= false;
    /** The model. */
    private final IModel model;

    /**
     * Instantiates a new controller facade.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     */
    public ControllerFacade(final IView view, final IModel model) {
        super();
        this.view = view;
        this.model = model;
    }
    
    @Override
	public void orderPerform(final IUserOrder userOrder) {
		if (userOrder != null) {
			final IMobile lorran = this.model.getMobileByPlayer(userOrder.getPlayer());
			if (lorran != null) {
				Direction direction;
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
					case SHOOT:
						try {
							this.lauchSpell(userOrder.getPlayer());
						} catch (final IOException e) {
							e.printStackTrace();
						}
					case NOP:
					default:
						direction = this.model.getMobileByPlayer(userOrder.getPlayer()).getDirection();
						break;
				}
				lorran.setDirection(direction);
			}
		}
	}

    /**
     * Start.
     *
     * @throws SQLException
     *             the SQL exception
     */
  /*  public void start() throws SQLException {
        this.getView().displayMessage(this.getModel().getExampleById(1).toString());

        this.getView().displayMessage(this.getModel().getExampleByName("Example 2").toString());

        final List<Example> examples = this.getModel().getAllExamples();
        final StringBuilder message = new StringBuilder();
        for (final Example example : examples) {
            message.append(example);
            message.append('\n');
        }
        this.getView().displayMessage(message.toString());
    }*/
    public void play() {
		this.gameLoop();
		this.viewSystem.displayMessage("Game Over !");
		this.viewSystem.closeAll();
	}

	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			final ArrayList<IMobile> initialMobiles = new ArrayList<IMobile>();
			for (final IMobile mobile : this.model.getMobiles()) {
				initialMobiles.add(mobile);
			}
			for (final IMobile mobile : initialMobiles) {
				mobile.move();
				if (mobile.isSpell()) {
					this.manageCollision(mobile);
				}
			}
			this.model.setMobilesHavesMoved();
		}
	}

    private void lauchSpell(final int player) throws IOException {
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
	}
    
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
			isTargetHit = isTargetHit || mobile.hit();
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
    public IView getView() {
        return this.view;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public IModel getModel() {
        return this.model;
    }
}

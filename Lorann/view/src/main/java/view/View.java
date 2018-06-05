package view;

/**
 * <h1>The View Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import controller.IOrderPerformer;
import model.Model;

public class View implements Runnable, IView {
	private final GraphicsBuilder graphicsBuilder;
	private final EventPerformer eventPerformer;
	private final Observable observable;
	private GameFrame gameFrame;

	/**
	 * The Constructor for the View Class
	 * @param model
	 * @param observable
	 * @param orderPerformer
	 */
	public View(final Model model, final Observable observable, final IOrderPerformer orderPerformer) {
		this.observable = observable;
		this.eventPerformer = new EventPerformer(orderPerformer);
		this.graphicsBuilder = new GraphicsBuilder(model);
		//this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable);
		SwingUtilities.invokeLater(this);
	}

	/** Run the pannel */
	@Override
	public void run() {
			this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable, this.eventPerformer);
		}
			
	/** Displays a String message to the screen */
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	/** Closes all frames */
	public void closeAll() {
		this.gameFrame.dispose();
	}
}

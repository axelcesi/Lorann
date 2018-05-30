package view;

import java.util.Observable;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import model.IModel;
/*import gameframe.GameFrame;*/

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade implements IView {
	private final GraphicsBuilder	graphicsBuilder;
	private final KeyEvent	keyEvent;
	private final Observable			observable;
	/*private GameFrame							gameFrame;*/

    /**
     * Instantiates a new view facade.
     */
    public ViewFacade(final IOrderPerformer orderPerformer, final IModel model, final Observable observable) {
        /*super();*/
    	this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(dogfightModel);
		this.keyEvent = new keyEvent(orderPerformer);
		SwingUtilities.invokeLater(this);
    }
   /* @Override
	public void run() {
		this.gameFrame = new GameFrame("Lorran", this.keyEvent, this.graphicsBuilder, this.observable);
	}*/

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }
   /* @Override
	public void closeAll() {
		this.gameFrame.dispose();
	}*/
  
}

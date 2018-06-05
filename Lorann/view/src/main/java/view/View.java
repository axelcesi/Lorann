package view;


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

	public View(final Model model, final Observable observable, final IOrderPerformer orderPerformer) {
		this.observable = observable;
		this.eventPerformer = new EventPerformer(orderPerformer);
		this.graphicsBuilder = new GraphicsBuilder(model);
		//this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
			this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable, this.eventPerformer);
		}
			
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void closeAll() {
		this.gameFrame.dispose();
	}
}

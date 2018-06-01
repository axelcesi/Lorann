package view;


import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import model.Model;
import model.IModel;
import gameframe.GameFrame;
import gameframe.IEventPerformer;
import gameframe.IGraphicsBuilder;

public class ViewFacade implements IView, Runnable {
	private final GraphicsBuilder	graphicsBuilder;
	private final EventPerformer	eventPerformer;
	private final Observable			observable;
	private GameFrame							gameFrame;

	public ViewFacade(final IOrderPerformer orderPerformer, final IModel model, final Observable observable) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(model);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {
		this.gameFrame = new GameFrame("Lorran", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void closeAll() {
		this.gameFrame.dispose();
	}
}

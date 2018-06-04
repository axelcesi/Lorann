package view;


import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

//import controller.IOrderPerformer;
import model.Model;
import model.IModel;
//import gameframe.IEventPerformer;


public class View implements Runnable {
	private Model model;
	private final GraphicsBuilder	graphicsBuilder;
	//private final EventPerformer	eventPerformer;
	private final Observable			observable;
	private GameFrame							gameFrame;

	public View(final IModel model) {
		this.observable = new Observable();
		this.graphicsBuilder = new GraphicsBuilder(model);
		//this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable);
		SwingUtilities.invokeLater(this);
	}

	@Override
	public void run() {

			//for (int i = 0; i < 100; i++)
			this.gameFrame = new GameFrame(this.graphicsBuilder, this.observable);
			//this.gameFrame.update(graphicsBuilder);
		}
			
		//, this.observable);
	
	
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void closeAll() {
		this.gameFrame.dispose();
	}
}

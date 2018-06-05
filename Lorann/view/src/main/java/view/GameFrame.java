package view;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JFrame;

/**
 * <h1>The GameFram Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class GameFrame extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1459604730997883613L;
	private final IEventPerformer eventPerformer;
	//private GamePanel pan;
	
	/**
	 * Constructor for the GameFrame Class
	 * @param graphicsBuilder
	 * @param observable
	 * @param eventPerformer
	 */
	public GameFrame(final GraphicsBuilder graphicsBuilder, Observable observable, final IEventPerformer eventPerformer) 
	{     
		this.eventPerformer = eventPerformer;
	    this.setTitle("Lorann");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable(false);
	    this.setVisible(true);
	    this.addKeyListener(this);
	    
	    this.setSize(640, 430);
	    this.setLocationRelativeTo(null);               
	    
	    
	    this.setBackground(Color.BLACK);
	    GamePanel pan = new GamePanel(graphicsBuilder);
	    this.setContentPane(pan);
	    observable.addObserver(pan);
	    
	    this.setVisible(true);	
	} 
	
	/** AddS the pressed key to the object */
	public void keyPressed(final KeyEvent keyEvent) {
		this.eventPerformer.eventPerform(keyEvent);
	}

	/** Auto Generated stub */
	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}

	/** Auto Generated stub */
	@Override
	public void keyTyped(KeyEvent arg0) {

	}
}

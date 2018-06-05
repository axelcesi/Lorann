package view;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import javax.swing.JFrame;



public class GameFrame extends JFrame implements KeyListener{
	
	private static final long serialVersionUID = 1459604730997883613L;
	private final IEventPerformer eventPerformer;
	//private GamePanel pan;
	
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
	
	public void keyPressed(final KeyEvent keyEvent) {
		this.eventPerformer.eventPerform(keyEvent);
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

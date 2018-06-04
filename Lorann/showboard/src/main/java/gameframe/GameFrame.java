package view;
import java.awt.Color;
import java.util.Observable;

import javax.swing.JFrame;

import model.Model;

public class GameFrame extends JFrame {
	
	private static final long serialVersionUID = 1459604730997883613L;
	private GamePanel pan;
	
	public GameFrame(final GraphicsBuilder graphicsBuilder, Observable observable) 
	{     
	    this.setTitle("Lorann fils de pute");
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    
	    this.setSize(640, 500);
	    this.setLocationRelativeTo(null);               
	    
	    
	    this.setBackground(Color.BLACK);
	    pan = new GamePanel(graphicsBuilder);
	    this.setContentPane(pan);
	    
	    this.setVisible(true);
	    
	
	} 
	
	public void update(final GraphicsBuilder graphicsBuilder)
	{
		System.out.println("update");
		 pan = new GamePanel(graphicsBuilder);
		 this.setContentPane(pan);
	}
}

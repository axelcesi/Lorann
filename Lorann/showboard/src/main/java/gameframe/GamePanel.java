package view;

import java.awt.Graphics;
import java.util.Observable;

import javax.swing.JPanel;


 
public class GamePanel extends JPanel 
{ 
	private static final long serialVersionUID = 1L;
	private final GraphicsBuilder	graphicsBuilder;
	
	public GamePanel(GraphicsBuilder graphicsBuilder)
	{
		this.graphicsBuilder = graphicsBuilder;
	}
  
	public void updates()
	{
		
		this.repaint();
		System.out.println("repaint");
		
	}
	
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	public void paintComponent(Graphics g){
		System.out.println("ok");


		this.graphicsBuilder.applyModelToGraphic(g, null);
	}
}
    


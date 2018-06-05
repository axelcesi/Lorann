package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;


 
public class GamePanel extends JPanel implements Observer
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
		//this.setBackground(Color.BLACK);
		Rectangle r = this.getBounds ( ) ;
        g.setColor(Color.BLACK);
        g.fillRect ( r.x, r.y, r.width, r.height ) ;
		this.graphicsBuilder.applyModelToGraphic(g, this);
	}
}
    


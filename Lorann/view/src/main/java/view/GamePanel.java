package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

/**
 * <h1>The GamePanel Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */
 
public class GamePanel extends JPanel implements Observer
{ 
	private static final long serialVersionUID = 1L;
	private final GraphicsBuilder	graphicsBuilder;
	
	/**
	 * Constructor of the GamePanel Class
	 * @param graphicsBuilder
	 */
	public GamePanel(GraphicsBuilder graphicsBuilder)
	{
		this.graphicsBuilder = graphicsBuilder;
	}
  
	/** Repaints the panel */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
	
	/** Defined the background rectangle */
	public void paintComponent(Graphics g){
		Rectangle r = this.getBounds ( ) ;
        g.setColor(Color.BLACK);
        g.fillRect ( r.x, r.y, r.width, r.height ) ;
		this.graphicsBuilder.applyModelToGraphic(g, this);
	}
}
    


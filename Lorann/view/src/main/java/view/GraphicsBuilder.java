package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IModel;
import model.elements.IElement;

/**
 * <h1>The GraphicBuilder Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class GraphicsBuilder {
	private final IModel model;
	
	/**
	 * Constructor of the Graphic Builder Class
	 * @param model
	 */
	public GraphicsBuilder(final IModel model ) {
		this.model = model;
	}
	
	/**
	 * Draws elements to pannel
	 * @param g
	 * @param observer
	 */
	public void applyModelToGraphic(final Graphics g ,final ImageObserver observer) {
		for (IElement element : this.model.getElements())
		{
			
			if (element != null)	
			{
				g.drawImage(element.getImage(), element.getPosition().getX(), element.getPosition().getY(), observer);
			}
		}
	}
}

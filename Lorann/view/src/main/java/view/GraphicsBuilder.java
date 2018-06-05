package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import model.IModel;
import model.elements.IElement;



public class GraphicsBuilder {
	private final IModel model;
	
	public GraphicsBuilder(final IModel model ) {
		this.model = model;
	}
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

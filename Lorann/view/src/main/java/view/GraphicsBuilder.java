package view;

import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

import model.IModel;
import model.elements.Element;
import model.elements.IElement;



public class GraphicsBuilder {
	private final IModel model;
	private static int MAPWIDTH = 200;
	private static int MAPHEIGHT = 200;
	
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
		/*for (final IElement element : this.model.getElements()) {
			this.drawMobile(element, graphics, observer);
		}*///}
		//@Override
		/*public int getGlobalWidth() {
			return this.model.getArea().getWidth();
		}

		@Override
		public int getGlobalHeight() {
			return this.model.getArea().getHeight();
		}*/
/*
		private void drawMobile(final IMobile mobile, final Graphics graphics, final ImageObserver observer) {
			final BufferedImage imageMobile = new BufferedImage(WIDTH, HEIGHT, Transparency.TRANSLUCENT);
			final Graphics graphicsMobile = imageMobile.getGraphics();

			graphicsMobile.drawImage(mobile.getImage(), 0, 0, WIDTH, HEIGHT, observer);
			graphics.drawImage(imageMobile, mobile.getPosition().getX(), mobile.getPosition().getY(), observer);

		}*/


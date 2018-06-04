package view;

import java.awt.Graphics;
import java.util.Observable;


import model.IModel;



public class GraphicsBuilder {
	private final IModel model;
	private static int MAPWIDTH = 200;
	private static int MAPHEIGHT = 200;
	
	public GraphicsBuilder(final IModel model ) {
		this.model = model;
	}
	public void applyModelToGraphic(final Graphics g ,final Observable observable) {
		System.out.println("apply");

		for (int i = 0; i < 12; i++)
		{
			for (int j = 0; j < 20; j ++)
			{
				if (model.getImage(i, j) != null)
				{
					g.drawImage(model.getImage(i, j), j*32, i*32, null);
					//System.out.println("model");
				}
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


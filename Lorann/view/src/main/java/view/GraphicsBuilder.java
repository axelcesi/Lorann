package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class GraphicsBuilder {
	private final IModel model;
	private BufferedImage area;
	
	public GraphicsBuilder(final IModel model ) {
		this.model = model;
		this.buildArea();
	}
	@Override
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		graphics.drawImage(this.area, 0, 0, observer);

		for (final IMobile mobile : this.model.getMobiles()) {
			this.drawMobile(mobile, graphics, observer);
		}
		@Override
		public int getGlobalWidth() {
			return this.model.getArea().getWidth();
		}

		@Override
		public int getGlobalHeight() {
			return this.model.getArea().getHeight();
		}
		private void buildArea() {
			this.area = new BufferedImage(this.model.getArea().getWidth(), this.model.getArea().getHeight(), BufferedImage.TYPE_INT_RGB);
			final Graphics2D graphics = (Graphics2D) this.area.getGraphics();
			graphics.drawImage(this.model.getArea().getImage(), 0, 0, this.model.getArea().getWidth(), this.model.getArea().getHeight(), null);
		}
		private void drawMobile(final IMobile mobile, final Graphics graphics, final ImageObserver observer) {
			final BufferedImage imageMobile = new BufferedImage(mobile.getWidth(), mobile.getHeight(), Transparency.TRANSLUCENT);
			final Graphics graphicsMobile = imageMobile.getGraphics();

			graphicsMobile.drawImage(mobile.getImage(), 0, 0, mobile.getWidth(), mobile.getHeight(), observer);
			graphics.drawImage(imageMobile, mobile.getPosition().getX(), mobile.getPosition().getY(), observer);

			final boolean isHorizontalOut = (mobile.getPosition().getX() + mobile.getWidth()) > this.model.getArea().getWidth();
			final boolean isVerticalOut = (mobile.getPosition().getY() + mobile.getHeight()) > this.model.getArea().getHeight();

			if (isHorizontalOut) {
				final BufferedImage imageMobileH = imageMobile.getSubimage(this.model.getArea().getWidth() - mobile.getPosition().getX(), 0,
						(mobile.getWidth() - this.model.getArea().getWidth()) + mobile.getPosition().getX(), mobile.getHeight());
				graphics.drawImage(imageMobileH, 0, mobile.getPosition().getY(), observer);
			}

			if (isVerticalOut) {
				final BufferedImage imageMobileV = imageMobile.getSubimage(0, this.model.getArea().getHeight() - mobile.getPosition().getY(), mobile.getWidth(),
						(mobile.getHeight() - this.model.getArea().getHeight()) + mobile.getPosition().getY());
				graphics.drawImage(imageMobileV, mobile.getPosition().getX(), 0, observer);
			}

			if (isHorizontalOut && isVerticalOut) {
				final BufferedImage imageMobileHV = imageMobile.getSubimage(this.model.getArea().getWidth() - mobile.getPosition().getX(),
						this.model.getArea().getHeight() - mobile.getPosition().getY(),
						(mobile.getWidth() - this.model.getArea().getWidth()) + mobile.getPosition().getX(),
						(mobile.getHeight() - this.model.getArea().getHeight()) + mobile.getPosition().getY());
				graphics.drawImage(imageMobileHV, 0, 0, observer);
			}
		}
}

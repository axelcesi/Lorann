package model.elements;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The Sprite Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Sprite {

	private Image image;
	private String imageName;
	
	/**
	 * Constructor for the Sprite Class.
	 * @param imageName
	 * @throws IOException
	 */
	public Sprite(String imageName) throws IOException 
	{
		this.imageName = imageName;		
		this.image = ImageIO.read(new File("./sprite/" + this.imageName));
	}
	
	/** Getter */
	public Image getImage()
	{
		return this.image;
	}
	
	/** Load image in the object */
	public void loadImage() throws IOException
	{
		this.image = ImageIO.read(new File("images/" + this.imageName));
	}
	
	/** Setter */
	public void setImage(Image image)
	{
		this.image = image;
	}
	
	/** Getter */
	public String getImageName()
	{
		return this.imageName;
	}
	
	/** Setter */
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
}
	

package model.elements;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private Image image;
	private String imageName;
	private boolean ImageLoaded = false;
	
	public Sprite(String imageName) throws IOException 
	{
		this.imageName = imageName;
		
		this.image = ImageIO.read(new File("./sprite/" + this.imageName));
		
		this.ImageLoaded = true;
		//System.out.println(imageName);
	}
	
	public Image getImage()
	{
		return this.image;
	}
	
	public void loadImage() throws IOException
	{
		this.image = ImageIO.read(new File("images/" + this.imageName));
		this.ImageLoaded = true;
	}
	
	public void setImage(Image image)
	{
		this.image = image;
		this.ImageLoaded = true;
	}
	
	public String getImageName()
	{
		return this.imageName;
	}
	
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
	
	public boolean isImageLoaded()
	{
		if (this.ImageLoaded = true) {
			return true;
				}
		else {
			return false;
		}
	}
	
	public void setImageLoaded(boolean imageLoaded)
	{
		this.ImageLoaded = imageLoaded;
	}
}

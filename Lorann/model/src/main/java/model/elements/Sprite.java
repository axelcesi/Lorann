package model.elements;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {

	private Image image;
	private String imageName;
	
	public Sprite(String imageName) throws IOException 
	{
		this.imageName = imageName;		
		this.image = ImageIO.read(new File("./sprite/" + this.imageName));
	}
	
	public Image getImage()
	{
		return this.image;
	}
	
	public void loadImage() throws IOException
	{
		this.image = ImageIO.read(new File("images/" + this.imageName));
	}
	
	public void setImage(Image image)
	{
		this.image = image;
	}
	
	public String getImageName()
	{
		return this.imageName;
	}
	
	public void setImageName(String imageName)
	{
		this.imageName = imageName;
	}
}
	

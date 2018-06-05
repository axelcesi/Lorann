package model.elements.motionless;

import java.io.IOException;

import model.elements.Element;
import model.elements.motionless.Permeability;


public abstract class MotionlessElement extends Element
{
	
	private Permeability permeability;
	
	
	MotionlessElement(String sprite,int x, int y, Permeability permeability) throws IOException
	{
		super(sprite, x, y);
		this.permeability = permeability;
	}
	
	public Permeability getPermeability()
	{
		return this.permeability;
	}
	
	public void setPermeability(Permeability permeability)
	{
		this.permeability = permeability;
	}
	
	public void move()
	{
		
	}
}

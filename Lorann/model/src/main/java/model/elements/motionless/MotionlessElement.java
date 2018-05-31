package model.elements.motionless;

import model.elements.Element;
import model.elements.Permeability;


public abstract class MotionlessElement extends Element
{
	
	private Permeability permeability;
	
	
	MotionlessElement(Sprite sprite, Permeability permeability, Position position)
	{
		
	}
	
	public Permeability getPermeability()
	{
		return this.permeability;
	}
	
	public void setPermeability(Permeability permeability)
	{
		this.permeability = permeability;
	}
}

package model.elements.motionless;

import java.io.IOException;

import model.elements.Element;
import model.elements.motionless.Permeability;

/**
 * <h1>The Abstract Class for Motionless Elements</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public abstract class MotionlessElement extends Element
{
	/** Affects is something is allowed to go through an object */
	private Permeability permeability;
	
	/**
	 * Constructor for the Motionless Element Abstract Class, needs a permeability and a x&y
	 * @param sprite
	 * @param x
	 * @param y
	 * @param permeability
	 * @throws IOException
	 */
	MotionlessElement(String sprite,int x, int y, Permeability permeability) throws IOException
	{
		super(sprite, x, y);
		this.permeability = permeability;
	}
	
	/** Getter */
	public Permeability getPermeability()
	{
		return this.permeability;
	}
	
	/** Setter */
	public void setPermeability(Permeability permeability)
	{
		this.permeability = permeability;
	}
	
	/** Not used or deprecated 
	 * @deprecated
	 */
	public void move()
	{
		
	}
}

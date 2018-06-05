package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Purse Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Purse extends MotionlessElement
{
		
	/**
	 * Constructor for the Purse Class, needs a x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	Purse(int x, int y) throws IOException
	{
		super("purse.png", x, y, Permeability.BLOCKING);
	}
	
	/** Getter */
	public String getType()
	{
		return "purse";
	}
}

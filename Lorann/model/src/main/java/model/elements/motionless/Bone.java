package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Bone Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Bone extends MotionlessElement
{	
	/**
	 * Constructor for the Bone Class, needs x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	Bone(int x, int y) throws IOException
	{
		super("bone.png", x, y, Permeability.BLOCKING);
	}
	
	/** Getter */
	public String getType()
	{
		return "bone";
	}
}

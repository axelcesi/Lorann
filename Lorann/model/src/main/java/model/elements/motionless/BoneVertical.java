package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Vertical Bone Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class BoneVertical extends MotionlessElement
{
	/**
	 * Constructor for the Vertical Bone Class, need a x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	BoneVertical(int x, int y) throws IOException
	{
		super("vertical_bone.png", x, y, Permeability.BLOCKING);
	}
	
	/** Getter */
	public String getType()
	{
		return "bone";
	}
}

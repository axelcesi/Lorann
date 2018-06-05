package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Horizontal Bone Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class BoneHorizontal extends MotionlessElement
{

	/**
	 * Constructor for the Horizontal Bone Class, nees x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	BoneHorizontal(int x, int y) throws IOException
	{
		super("horizontal_bone.png", x, y, Permeability.BLOCKING);
	}
	
	/** Getter */
	public String getType()
	{
		return "bone";
	}
}

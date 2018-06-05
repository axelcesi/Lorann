package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Crystal Ball Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class CrystalBall extends MotionlessElement
{

	/**
	 * Constructor of the Crystal Ball Class, needs a x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	CrystalBall(int x, int y) throws IOException
	{
		super("crystal_ball.png", x, y, Permeability.PENETRABLE);
	}
	
	/** Getter */
	public String getType()
	{
		return "crystalBall";
	}
}

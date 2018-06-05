package model.elements.motionless;

import java.io.IOException;

public class CrystalBall extends MotionlessElement
{
	
	CrystalBall(int x, int y) throws IOException
	{
		super("crystal_ball.png", x, y, Permeability.PENETRABLE);
	}
	
	public String getType()
	{
		return "crystalBall";
	}
}

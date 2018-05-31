package model.elements.motionless;

import java.io.IOException;

public class CrystalBall extends MotionlessElement
{
	static private String SPRITE = new String("crystall_ball.png");
	
	CrystalBall(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Permeability.PENETRABLE);
	}
	
}

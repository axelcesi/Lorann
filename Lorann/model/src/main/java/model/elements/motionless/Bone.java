package model.elements.motionless;

import java.io.IOException;


public class Bone extends MotionlessElement
{	
	
	Bone(int x, int y) throws IOException
	{
		super("bone.png", x, y, Permeability.BLOCKING);
	}
	
	public String getType()
	{
		return "bone";
	}
}

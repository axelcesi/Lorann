package model.elements.motionless;

import java.io.IOException;

public class BoneHorizontal extends MotionlessElement
{

	BoneHorizontal(int x, int y) throws IOException
	{
		super("horizontal_bone.png", x, y, Permeability.BLOCKING);
	}
	
	public String getType()
	{
		return "bone";
	}
}

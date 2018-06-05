package model.elements.motionless;

import java.io.IOException;

public class BoneVertical extends MotionlessElement
{
	
	BoneVertical(int x, int y) throws IOException
	{
		super("vertical_bone.png", x, y, Permeability.BLOCKING);
	}
	
	public String getType()
	{
		return "BoneVertical";
	}
}

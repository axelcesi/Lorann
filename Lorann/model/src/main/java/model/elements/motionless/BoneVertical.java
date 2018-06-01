package model.elements.motionless;

import java.io.IOException;

public class BoneVertical extends MotionlessElement
{
	
	BoneVertical(int x, int y) throws IOException
	{
		super("bone_vertical.png", x, y, Permeability.BLOCKING);
	}
	
}

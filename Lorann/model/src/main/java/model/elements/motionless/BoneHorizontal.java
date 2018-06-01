package model.elements.motionless;

import java.io.IOException;

public class BoneHorizontal extends MotionlessElement
{

	BoneHorizontal(int x, int y) throws IOException
	{
		super("bone_horizontal.png", x, y, Permeability.BLOCKING);
	}
	
}

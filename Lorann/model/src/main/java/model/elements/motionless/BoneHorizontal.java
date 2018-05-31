package model.elements.motionless;

import java.io.IOException;

public class BoneHorizontal extends MotionlessElement
{
	static private String SPRITE = "bone_horizontal.png";
	
	BoneHorizontal(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Permeability.BLOCKING);
	}
	
}

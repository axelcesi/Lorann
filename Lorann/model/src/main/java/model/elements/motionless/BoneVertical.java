package model.elements.motionless;

import java.io.IOException;

public class BoneVertical extends MotionlessElement
{
	static private String SPRITE = "bone_vertical.png";
	
	BoneVertical(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Permeability.BLOCKING);
	}
	
}

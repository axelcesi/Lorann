package model.elements.motionless;

import java.io.IOException;

import model.elements.Sprite;

public class Bone extends MotionlessElement
{	
	
	Bone(int x, int y) throws IOException
	{
		super("bone.png", x, y, Permeability.BLOCKING);
	}	
}

package model.elements.motionless;

import java.io.IOException;

import model.elements.Sprite;

public class Bone extends MotionlessElement
{
	static private String SPRITE = "bone.png";
	
	Bone(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Permeability.BLOCKING);
	}	
}

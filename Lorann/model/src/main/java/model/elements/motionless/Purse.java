package model.elements.motionless;

import java.io.IOException;

public class Purse extends MotionlessElement
{
		
	Purse(int x, int y) throws IOException
	{
		super("closed_gate.png", x, y, Permeability.BLOCKING);
	}
	
}

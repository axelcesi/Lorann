package model.elements.motionless;

import java.io.IOException;

public class Purse extends MotionlessElement
{
		
	Purse(int x, int y) throws IOException
	{
		super("purse.png", x, y, Permeability.BLOCKING);
	}
	
	public String getType()
	{
		return "Purse";
	}
}

package model.elements.motionless;

import java.io.IOException;

public class Gate extends MotionlessElement
{
	private String SPRITE = "closed_gate.png";
	private boolean open = false;
	
	Gate(int x, int y) throws IOException
	{
		super(SPRITE, x, y, Permeability.BLOCKING);
	}
	
	public boolean isOpen()
	{
		
	}
	
	public void Open()
	{
		
	}
}

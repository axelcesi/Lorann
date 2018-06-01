package model.elements.motionless;

import java.io.IOException;

public class Gate extends MotionlessElement
{
	private boolean open = false;
	
	Gate(int x, int y) throws IOException
	{
		super("closed_gate.png", x, y, Permeability.BLOCKING);
	}
	
	public boolean isOpen()
	{
		return open;
	}
	
	public void Open() throws IOException
	{
		this.open = true;
		this.setSprite("open_gate.png");
	}
}

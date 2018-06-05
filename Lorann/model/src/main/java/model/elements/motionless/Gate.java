package model.elements.motionless;

import java.io.IOException;

public class Gate extends MotionlessElement
{
	private boolean open = false;
	
	Gate(int x, int y) throws IOException
	{
		super("gate_closed.png", x, y, Permeability.BLOCKING);
	}
	
	public boolean isOpen()
	{
		return open;
	}
	
	public void open() throws IOException
	{
		this.open = true;
		this.setSprite("gate_open.png");
	}
	
	public String getType()
	{
		if (this.isOpen() == true)
			return "gateOpen";
		if (this.isOpen() == false)
			return "gateClosed";
		return "";
	}
}

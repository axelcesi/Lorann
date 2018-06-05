package model.elements.motionless;

import java.io.IOException;

/**
 * <h1>The Gate Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Gate extends MotionlessElement
{
	private boolean open = false;
	
	/**
	 * Constructor for the Gate Class, need x&y
	 * @param x
	 * @param y
	 * @throws IOException
	 */
	Gate(int x, int y) throws IOException
	{
		super("gate_closed.png", x, y, Permeability.BLOCKING);
	}
	
	/** Getter, in a way */
	public boolean isOpen()
	{
		return open;
	}
	
	/**
	 * Opened the gate
	 * @throws IOException
	 */
	public void open() throws IOException
	{
		this.open = true;
		this.setSprite("gate_open.png");
	}
	
	/**
	 * Retruns the State of the Gate
	 */
	public String getType()
	{
		if (this.isOpen() == true)
			return "gateOpen";
		if (this.isOpen() == false)
			return "gateClosed";
		return "";
	}
}

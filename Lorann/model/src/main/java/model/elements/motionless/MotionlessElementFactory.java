package model.elements.motionless;

import java.io.IOException;

import model.elements.Element;

/**
 * <h1>Factory Class for the Motionless Elements</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public abstract class MotionlessElementFactory {

	/*private Bone bone;
	private BoneVertical boneVertical;
	private BoneHorizontal boneHorizontal;
	private Gate gate;
	private Purse purse;
	private CrystalBall crystalBall;*/
	
	/**
	 * Creates a bone depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createBone(int x, int y) throws IOException
	{
		return new Bone(x,y);
	}
	
	/**
	 * Creates a Vertical Bone depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createBoneVertical(int x, int y) throws IOException
	{
		return new BoneVertical(x,y);
	}
	
	/**.
	 * Creates an horizontal Bone depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createBoneHorizontal(int x, int y) throws IOException
	{
		return new BoneHorizontal(x,y);
	}
	
	/**
	 * Creates a gate depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createGate(int x, int y) throws IOException
	{
		return new Gate(x,y);
	}
	
	/**
	 * Creates a purse depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createPurse(int x, int y) throws IOException
	{
		return new Purse(x,y);
	}
	
	/**
	 * Creates a Crystal Ball depending on x and y parameters
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createCrystalBall(int x, int y) throws IOException
	{
		return new CrystalBall(x,y);
	}
	
	/**
	 * Creates an Element
	 * @param type
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
	public static Element createElement(String type, int x, int y) throws IOException
	{
		Element element = null;
		switch (type)
		{
		case "Bone" :
			element = createBone(x,y);
			break;
		case "BoneHorizontal" :
			element = createBoneHorizontal(x,y);
			break;
		case "BoneVertical" :
			element = createBoneVertical(x,y);
			break;
		case "Gate" :
			element = createGate(x,y);
			break;
		case "Purse" :
			element = createPurse(x,y);
			break;
		case "CrystalBall" :
			element = createCrystalBall(x,y);
			break;
		}
		return element;
	}
}

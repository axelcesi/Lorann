package model.elements.motionless;

import java.io.IOException;

import model.elements.Element;

public abstract class MotionlessElementFactory {

	/*private Bone bone;
	private BoneVertical boneVertical;
	private BoneHorizontal boneHorizontal;
	private Gate gate;
	private Purse purse;
	private CrystalBall crystalBall;*/
	
	public static Element createBone(int x, int y) throws IOException
	{
		return new Bone(x,y);
	}
	
	public static Element createBoneVertical(int x, int y) throws IOException
	{
		return new BoneVertical(x,y);
	}
	
	public static Element createBoneHorizontal(int x, int y) throws IOException
	{
		return new BoneHorizontal(x,y);
	}
	
	public static Element createGate(int x, int y) throws IOException
	{
		return new Gate(x,y);
	}
	
	public static Element createPurse(int x, int y) throws IOException
	{
		return new Purse(x,y);
	}
	
	public static Element createCrystalBall(int x, int y) throws IOException
	{
		return new CrystalBall(x,y);
	}
	
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

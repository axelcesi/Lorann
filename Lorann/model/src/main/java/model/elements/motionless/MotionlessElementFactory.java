package model.elements.motionless;

import java.io.IOException;

public abstract class MotionlessElementFactory {

	private Bone bone;
	private BoneVertical boneVertical;
	private BoneHorizontal boneHorizontal;
	private Gate gate;
	private Purse purse;
	private CrystalBall crystalBall;
	
	public MotionlessElement createBone(int x, int y) throws IOException
	{
		return new Bone(x,y);
	}
	
	public MotionlessElement createBoneVertical(int x, int y) throws IOException
	{
		return new BoneVertical(x,y);
	}
	
	public MotionlessElement createBoneHorizontal(int x, int y) throws IOException
	{
		return new BoneHorizontal(x,y);
	}
	
	public MotionlessElement createGate(int x, int y) throws IOException
	{
		return new Gate(x,y);
	}
	
	public MotionlessElement createPurse(int x, int y) throws IOException
	{
		return new Purse(x,y);
	}
	
	public MotionlessElement createCrystalBall(int x, int y) throws IOException
	{
		return new CrystalBall(x,y);
	}
	
	public MotionlessElement createElement(String type, int x, int y) throws IOException
	{
		MotionlessElement element = null;
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

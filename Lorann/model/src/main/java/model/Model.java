package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import model.elements.IElement;
import model.elements.Position;
import model.elements.mobile.Direction;
import model.elements.mobile.IMobile;
import model.elements.mobile.MobileFactory;
import model.elements.motionless.Gate;
import model.elements.motionless.MotionlessElementFactory;

/**
 * <h1>The Model Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public final class Model extends Observable implements IModel {

	private static final int LEVEL = 1;
	private final ArrayList<IElement> elements;       
    
	/**
	 * Constructor for the Model Class
	 * @throws IOException
	 * @throws SQLException
	 */
	public Model() throws IOException, SQLException 
    {
    	elements = new ArrayList<IElement>();
    	createMap();
    }

	/**
	 * Method used to get the level's String from the DataBase
	 * @param int level
	 * @return String 
	 */
    public String getLevelLayout(int level) throws SQLException
    {
    	//LorannBDDConnector connector = new LorannBDDConnector();
       	//return connector.getResult(level);
    	return("not ok");
    }
    
    /**
     * @throws IOException
     * @throws SQLException
     */
    public void createMap() throws IOException, SQLException
    {
    	//String Layout = this.getLevelLayout(LEVEL);
    	String Layout =
    			
    			".....O-------O......\n" + 
    			".....I...4...I......\n" + 
    			".....I.......I......\n" + 
    			".....I...@...I......\n" + 
    			"O----O-OPOPO-O----O.\n" + 
    			"I............2....I.\n" + 
    			"I...............1*I.\n" + 
    			"O----OPO-O-OPO----O.\n" + 
    			".....I.......I......\n" + 
    			".....I...3...I......\n" + 
    			".....I.......I......\n" +
    			".....O--O$O--O......\n";
    	
    	
    	for (int y = 0; y < 12; y++)
    	{
    		for (int x = 0 ; x < 20; x++)
    		{
    			switch (Layout.charAt(y*21 + x))
    			{
    			case 'O' :
    				this.elements.add(MotionlessElementFactory.createElement("Bone", x*32, y*32));
    				break;
    			case '*' :
    				this.elements.add(MotionlessElementFactory.createElement("CrystalBall", x*32, y*32));
    				break;
    			case '$' :
    				this.elements.add(MotionlessElementFactory.createElement("Gate", x*32, y*32));
    				break;
    			case '-' :
    				this.elements.add(MotionlessElementFactory.createElement("BoneHorizontal", x*32, y*32));
    				break;
    			case '@' :
    				this.elements.add(MobileFactory.createElement("Hero", x*32, y*32 ,0));
    				break;
    			case '1' :
    				this.elements.add(MobileFactory.createElement("Monster", x*32, y*32 ,1));
    				break;
    			case '2' :
    				this.elements.add(MobileFactory.createElement("Monster", x*32, y*32 ,2));
    				break;
    			case '3' :
    				this.elements.add(MobileFactory.createElement("Monster", x*32, y*32 ,3));
    				break;
    			case '4' :
    				this.elements.add(MobileFactory.createElement("Monster", x*32, y*32 ,4));
    				break;
    			case 'P' :
    				this.elements.add(MotionlessElementFactory.createElement("Purse", x*32, y*32));
    				break;
    			case 'I' :
    				this.elements.add(MotionlessElementFactory.createElement("BoneVertical", x*32, y*32));
    				break;
    			case '.' :
    				this.elements.add(null);
    				break;
    			}
    		}
    	}
    }
    
    /** Adds a mobile Element to the map */
    public void addElement(IElement mobile)
    {
    	this.elements.add(mobile);
    }
    
    /** Removes an Element from the map */
    public void removeElement(IElement element)
    {
    	int ind = elements.indexOf(element);
    	this.elements.remove(ind);
    }
    
    /** Getter */
    public ArrayList<IElement> getElements()
    {
    	return this.elements;
    }
    
    /** Getter */
    public IElement getUniqueElement(String type)
    {
    	for (IElement element : this.getElements())
    	{
   			if (element != null && element.getType() == type)
    		{
    			return element;
    		}
      	}
    	return null;
    }
    
    /** Getter */
    public IElement getNextElement(Position position, Direction direction)
    {
    	for (IElement element : this.getElements())
    	{
    		if (element != null)
    		{
    		switch (direction)
    		{
    		case UP :
	    		if (element.getPosition().getX() == position.getX() && element.getPosition().getY() == position.getY()-32)
	    		{
	    			return element;
	    		}
	    		break;
    		case DOWN:
	    		if (element.getPosition().getX() == position.getX() && element.getPosition().getY() == position.getY()+32)
	    		{
	    			return element;
	    		}
	    		break;
    		case LEFT :
	    		if (element.getPosition().getX() == position.getX()-32 && element.getPosition().getY() == position.getY())
	    		{
	    			return element;
	    		}
	    		break;
    		case RIGHT :
	    		if (element.getPosition().getX() == position.getX()+32 && element.getPosition().getY() == position.getY())
	    		{
	    			return element;
	    		}
	    		break;
    		case UPLEFT :
	    		if (element.getPosition().getX() == position.getX()-32 && element.getPosition().getY() == position.getY()-32)
	    		{
	    			return element;
	    		}
	    		break;
    		case UPRIGHT :
	    		if (element.getPosition().getX() == position.getX()+32 && element.getPosition().getY() == position.getY()-32)
	    		{
	    			return element;
	    		}
	    		break;
    		case DOWNLEFT :
	    		if (element.getPosition().getX() == position.getX()-32 && element.getPosition().getY() == position.getY()+32)
	    		{
	    			return element;
	    		}
	    		break;
    		case DOWNRIGHT :
	    		if (element.getPosition().getX() == position.getX()+32 && element.getPosition().getY() == position.getY()+32)
	    		{
	    			return element;
	    		}
	    		break;
			default:
				break;
    		}
    		}
    	}
    	return null;
    }

    /** Getter */
    public ArrayList<IMobile> getMobiles()
	{
    	final ArrayList<IMobile> mobiles = new ArrayList<>();
    	for (IElement element : this.getElements())
    	{
    		if (element != null && element.isMobile() == true)
    			mobiles.add((IMobile) element);
    	}
    	return mobiles;
	}    
     
    /** Getter */
    public IElement getHero()
    {
    	for (IElement element : this.getElements())
    	{
   			if (element != null && element.getType() == "hero")
    		{
    			return element;
    		}
      	}
    	return null;
    }
    
    /** Getter */
    public Gate getGate()
    {
    	for (IElement element : this.getElements())
    	{
   			if (element != null && element.getType() == "gateClosed")
    		{
    			return (Gate) element;
    		}
      	}
    	return null;
    }
    
    /**
     * Setter
     * @deprecated
     */
    public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}

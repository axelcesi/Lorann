package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import model.elements.IElement;
import model.elements.mobile.Mobile;
import model.elements.mobile.MobileFactory;
import model.elements.motionless.MotionlessElementFactory;

public final class Model extends Observable implements IModel {

	private final ArrayList<IElement> elements;       
    public Model() throws IOException, SQLException 
    {
    	elements = new ArrayList<IElement>();
    	createMap();
    }

  
    public String getLevelLayout(int level) throws SQLException
    {
    	//LorannBDDConnector connector = new LorannBDDConnector();
       //	return connector.getResult(level);
    	return("not ok");
    }

    public void createMap() throws IOException, SQLException
    {
    	String Layout =
    			
    			".....O-------O......\n" + 
    			".....I.......I......\n" + 
    			".....I.......I......\n" + 
    			".....I...@...I......\n" + 
    			"O----O-OPOPO-O----O.\n" + 
    			"I....1.......2....I.\n" + 
    			"I................*I.\n" + 
    			"O----OPO-O-OPO----O.\n" + 
    			".....I.......I......\n" + 
    			".....I...3...I......\n" + 
    			".....I.......I......\n" +
    			".....O--O$O--O......\n";
    	
    	
    	for (int y = 0; y < 12; y++)
    	{
    		for (int x = 0 ; x < 20; x++)
    		{
    			//System.out.print(i*20 + "|" + j +":"+ Layout.charAt(i*21 + j));
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
    				//System.out.println(".");
    				break;
    			}
    		}
    	}
    }
    
    
    public void addElement(IElement mobile)
    {
    	this.elements.add(mobile);
    }
    
    public void removeMobile(IElement mobile, int x, int y)
    {
    	
    }
    
    public ArrayList<IElement> getElements()
    {
    	return this.elements;
    }
    
    /*public IElement getElement(int x, int y)
    {
    	return this.elements[x][y];
    }*/
    
    public ArrayList<IElement> getMobiles()
	{
    	final ArrayList<IElement> mobiles = new ArrayList<IElement>();
    	for (IElement element : this.getElements())
    	{
    		if (element.isMobile() == true)
    			mobiles.add(element);
    	}
    	return mobiles;
	}
    
    public ArrayList<Image> getImages()
    {
    	ArrayList<Image> img = new ArrayList<>();
    	for (IElement element : this.getElements())
    	{
    		if (element != null)
    			img.add(element.getImage());
    		
    		else
    			img.addAll(null);
    	}
    	return img;
    }
    
   /* public Image getImage(int x, int y)
    {
    Image[][] img = this.getImages();
    	if (img[x][y] != null)
    	{
        	return this.elements[x][y].getImage();
    	}
    	else
    	{
    		return null;
    	}
    }*/
    
    public IElement getHero()
    {
    	for (IElement element : this.getElements())
    	{
   			if (element != null && element.getType() == "Hero")
    		{
    			return element;
    		}
      	}
    	return null;
    }
    
    public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}

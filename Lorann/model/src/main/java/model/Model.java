package model;

import java.awt.Image;
import java.io.IOException;

import java.sql.SQLException;

import model.elements.IElement;
import model.elements.mobile.MobileFactory;
import model.elements.motionless.MotionlessElementFactory;

public final class Model implements IModel {

    private final IElement elements[][];

    
    public Model() throws IOException, SQLException 
    {
    	elements = new IElement[12][20];
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
    	
    	
    	for (int i = 0; i < 12; i++)
    	{
    		for (int j = 0 ; j < 20; j++)
    		{
    			//System.out.print(i*20 + "|" + j +":"+ Layout.charAt(i*21 + j));
    			switch (Layout.charAt(i*21 + j))
    			{
    			case 'O' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Bone", i, j);
    				break;
    			case '*' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("CrystalBall", i, j);
    				break;
    			case '$' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Gate", i, j);
    				break;
    			case '-' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("BoneHorizontal", i, j);
    				break;
    			case '@' :
    				this.elements[i][j] = MobileFactory.createElement("Hero", i, j ,0);
    				break;
    			case '1' :
    				this.elements[i][j] = MobileFactory.createElement("Monster", i, j ,1);
    				break;
    			case '2' :
    				this.elements[i][j] = MobileFactory.createElement("Monster", i, j ,2);
    				break;
    			case '3' :
    				this.elements[i][j] = MobileFactory.createElement("Monster", i, j ,3);
    				break;
    			case '4' :
    				this.elements[i][j] = MobileFactory.createElement("Monster", i, j ,4);
    				break;
    			case 'P' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Purse", i, j);
    				break;
    			case 'I' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("BoneVertical", i, j);
    				break;
    			case '.' :
    				this.elements[i][j] = null;
    				//System.out.println(".");
    				break;
    			}
    		}
    	}
    }
    
    public void addMobile(IElement mobile, int x ,int y)
    {
    	//this.elements[i][j].add(mobile);
    }
    
    public void removeMobile(IElement mobile, int x, int y)
    {
    	
    }
    
    public IElement[][] getElements()
    {
    	return this.elements;
    }
    
    public IElement getElement(int x, int y)
    {
    	return this.elements[x][y];
    }
    
    public Image[][] getImages()
    {
    	Image[][] img = new Image[12][20];
    	for (int i = 0 ; i < 12; i++)
    	{
    		for (int j = 0; j < 20; j++)
    		{
    			if (this.elements[i][j] != null)
    			{
    				img[i][j] = this.elements[i][j].getImage();
    			}
    			else
    			{
    				img[i][j] = null;
    			}
    		}
    	}
    	return img;
    }
    
    public Image getImage(int x, int y)
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
    }
    
    public IElement getHero()
    {
    	for (int i = 0; i < 12; i ++)
    	{
    		for (int j = 0; j < 20; j++)
    		{
    			if (this.elements[i][j].isHero() == true)
    			{
    				return this.elements[i][j];
    			}
    		}
    	}
    	return null;
    }
}

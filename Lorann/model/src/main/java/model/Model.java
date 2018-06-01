package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ExampleDAO;
import model.elements.Element;
import model.elements.IElement;
import model.elements.mobile.Hero;
import model.elements.mobile.IMobile;
import model.elements.mobile.Mobile;
import model.elements.motionless.MotionlessElementFactory;

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class Model implements IModel {

    private final IElement elements[][];
    
    public Model(int level) 
    {
    	elements = new IElement[12][20];
    }
  /*  public Model() throws IOException 
    {
    	this.elements = new ArrayList<>();
    	Mobile Larann = new Hero(50,50);
    }*/
   
    public String getLevelLayout()
    {
    	return 
    }

    public void createMap() throws IOException
    {
    	String Layout = this.getLevelLayout();
    	
    	for (int i = 0; i < 12; i++)
    	{
    		for (int j = 0 ; j < 20; j++)
    		{
    			switch (Layout.charAt(j*12 + i))
    			{
    			case 'O' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Bone", i, j);
    			case '*' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("CrystalBall", i, j);
    			case '$' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Gate", i, j);
    			case '-' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("BoneHorizontal", i, j);
    			case '@' :
    				
    			case '1' :
    				
    			case '2' :
    			case '3' :
    			case '4' :
    			case 'P' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("Purse", i, j);
    			case 'I' :
    				this.elements[i][j] = MotionlessElementFactory.createElement("BoneVertical", i, j);
    			case '.' :
    				this.elements[i][j] = null;
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
    
    public IElement[][] getMobiles()
    {
    	return this.elements;
    }
}

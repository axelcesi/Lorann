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

/**
 * <h1>The Class ModelFacade provides a facade of the Model component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public final class Model implements IModel {

    private final ArrayList<ArrayList<IElement>> elements;
    
    public Model(int level) 
    {
    	this.elements = new ArrayList<>();
    }
  /*  public Model() throws IOException 
    {
    	this.elements = new ArrayList<>();
    	Mobile Larann = new Hero(50,50);
    }*/
   
    public String getLevelLayout()
    {
    	
    }

    public IElement[] createMap()
    {
    	String Layout = this.getLevelLayout();
    	
    	for (int i = 0; i < 12; i++)
    	{
    		for (int j = 0 ; j < 20; j++)
    		{
    			switch (Layout.charAt(j*12 + i))
    			{
    			case
    			}
    		}
    	}
    }
    
    public void addMobile(IMobile mobile)
    {
    	this.mobiles.add(mobile);
    }
    
    public void removeMobile(IMobile mobile)
    {
    	
    }
}

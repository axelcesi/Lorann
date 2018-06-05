package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.elements.Element;
import model.elements.IElement;
import model.elements.mobile.IMobile;

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void createMap() throws IOException, SQLException;
	public ArrayList<Image> getImages();
	public ArrayList<IElement> getElements();
	public void setMobilesHavesMoved();
	public IElement getHero();
	public void addElement(IElement element);
}

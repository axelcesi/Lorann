package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.elements.IElement;

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void createMap() throws IOException, SQLException;
	public ArrayList<IElement> getElements();
	public void setMobilesHavesMoved();
	public IElement getHero();
	public void addElement(IElement element);
}

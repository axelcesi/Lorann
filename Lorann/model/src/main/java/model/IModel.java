package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.elements.IElement;

/**
 * <h1>Interface for the Model Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void createMap() throws IOException, SQLException;
	public ArrayList<IElement> getElements();
	public void setMobilesHavesMoved();
	public IElement getHero();
	public void addElement(IElement element);
}

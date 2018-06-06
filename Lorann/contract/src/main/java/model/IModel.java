package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.elements.IElement;
import model.elements.*;
import model.elements.mobile.*;
import model.elements.motionless.*;

/**
 * <h1>The Interface IModel</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void removeMobile(IElement mobile);
	public void createMap() throws IOException, SQLException;
	public ArrayList<Image> getImages();
	public ArrayList<IElement> getElements();
	public void setMobilesHavesMoved();
	public ArrayList<IMobile> getMobiles();
	public IElement getHero();
	public void addElement(IElement element);
	public IElement getNextElement(Position position, Direction direction);
	public void removeElement(IElement element);
	public IElement getUniqueElement(String string);
	public Gate getGate();
}

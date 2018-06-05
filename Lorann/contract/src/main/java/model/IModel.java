package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import model.elements.Element;
import model.elements.IElement;
import model.elements.Position;
import model.elements.mobile.Direction;
import model.elements.mobile.IMobile;
import model.elements.motionless.Gate;

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void removeMobile(IElement mobile);
	public void createMap() throws IOException, SQLException;
	public ArrayList<Image> getImages();
	//public Image getImage(int x, int y);
	public ArrayList<IElement> getElements();
	public void setMobilesHavesMoved();
	public Object getMobiles();
	public IElement getHero();
	public void addElement(IElement element);
	public IElement getNextElement(Position position, Direction direction);
	public void removeElement(IElement element);
	public IElement getUniqueElement(String string);
	public Gate getGate();
}

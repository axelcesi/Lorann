package model;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;

import model.elements.IElement;
import model.elements.mobile.IMobile;

public interface IModel {
	public String getLevelLayout(int level)throws SQLException;
	public void addMobile(IElement mobile, int x, int y);
	public void removeMobile(IElement mobile, int x, int y);
	public void createMap() throws IOException, SQLException;
	public Image[][] getImages();
	public Image getImage(int x, int y);
}

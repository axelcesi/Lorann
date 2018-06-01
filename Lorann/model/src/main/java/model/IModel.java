package model;

import java.io.IOException;

import model.elements.IElement;
import model.elements.mobile.IMobile;

public interface IModel {
	public String getLevelLayout();
	public void addMobile(IElement mobile, int x, int y);
	public void removeMobile(IElement mobile, int x, int y);
	public void createMap() throws IOException;
}

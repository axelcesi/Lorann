package model;

import model.elements.IElement;
import model.elements.mobile.IMobile;

public interface IModel {
	public String getLevelLayout();
	public void addMobile(IMobile mobile);
	public void removeMobile(IMobile mobile);
	public IElement[] createMap();
}

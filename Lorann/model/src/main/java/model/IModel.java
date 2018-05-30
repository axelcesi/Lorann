package model;

public interface IModel {
	public String getLevelLayout();
	public void addMobile(Mobile mobile);
	public void removeMobile(Mobile mobile);
	public IElement[] createMap();
}

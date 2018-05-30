package model.elements;

public interface IElement {
		
	public Sprite getSprite();	
	public void setSprite(Sprite sprite);
	public Permeability getPermeability();
	public void setPermeability(Permeability permeability);
	public Image getImage();
	public Position getPosition();
	public void setPosition(Position position);
}

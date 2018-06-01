package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;
import model.elements.IElement;

public abstract class MobileFactory {

	public Element createHero(int x, int y) throws IOException
	{
		return new Hero(x,y);		
	}
	
	public Element createMonster(int x, int y, int type) throws IOException
	{
		return new Monster(x, y, type);
	}
	
	public Element createSpell(int x, int y, Direction direction) throws IOException
	{
		return new Spell(x, y, direction);
	}
	
	public static Element createElement(String type, int x, int y, int monsterType) throws IOException
	{
		Element element = null;
		switch (type)
		{
		case "Hero" : element = createHero(x,y);
		break;
		case "Monster" : element = createMonster(x, y, monsterType);
		break;
		}
		return element;
	}
}
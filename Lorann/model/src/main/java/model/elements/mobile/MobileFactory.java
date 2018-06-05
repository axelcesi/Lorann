package model.elements.mobile;

import java.io.IOException;

import model.elements.Element;

/**
 * <h1>The Factory for mobile Elements Class</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public abstract class MobileFactory {

	/**
	 * Creates an Hero, needs x&y
	 * @param x
	 * @param y
	 * @return
	 * @throws IOException
	 */
    public static Element createHero(int x, int y) throws IOException
    {
        Hero hero = new Hero(x,y);
        Thread tHero = new Thread(hero);
        tHero.start();
        return hero;
    }

    /**
     * Creates a monster, needs its type, x&y
     * @param x
     * @param y
     * @param type
     * @return
     * @throws IOException
     */
    public static Element createMonster(int x, int y, int type) throws IOException
    {
        return new Monster(x, y, type);
    }

    /**
     * Casts a spell, needs a direction and x&y
     * @param x
     * @param y
     * @param direction
     * @return
     * @throws IOException
     */
    public Element createSpell(int x, int y, Direction direction) throws IOException
    {
        Spell spell = new Spell(x, y, direction);
        Thread tSpell = new Thread(spell);
        tSpell.start();
        return spell;
    }

    /**
     * Creates an Element
     * @param type
     * @param x
     * @param y
     * @param monsterType
     * @return
     * @throws IOException
     */
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
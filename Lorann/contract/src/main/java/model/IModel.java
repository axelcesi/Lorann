package model;

import java.awt.Image;
import java.sql.SQLException;
import java.util.List;

import model.elements.mobile.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public interface IModel {

     
	IMobile getMobiles();

	Image getImage(int i, int j);
}

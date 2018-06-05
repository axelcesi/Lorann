package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import model.*;
import view.View;

/**
 * <h1>The Main class of the Project</h1>
 * @author AIGRET Nathanaël, DE CASTRO Axel, DOITTEE Anthime, JASSERAND Maxime
 * @version 1.0
 */

public class Main {

	/**
	 * The main method, launches the program.
	 * @param args
	 * @throws IOException
	 * @throws SQLException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(model, model, controller);
		controller.setView(view);
		controller.play();
	}
}

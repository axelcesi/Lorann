package main;

import java.io.IOException;
import java.sql.SQLException;

import controller.Controller;
import model.*;
import view.View;

public class Main {

	public static void main(String[] args) throws IOException, SQLException, InterruptedException {
		Model model = new Model();
		Controller controller = new Controller(model);
		View view = new View(model, model, controller);
		controller.setView(view);
		controller.play();
	}
}

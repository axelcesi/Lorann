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
		
		controller.play();
		//Thread tView = new Thread(view);		
		
		//tView.start();

		//GraphicsBuilder graphicBuilder = new GraphicsBuilder(model);
		//Image img = model.getImage(2, 3);
		
		
		
		//Model game = new Model();
		//System.exit(0);

	}

}

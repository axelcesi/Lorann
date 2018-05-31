import controller.ControllerFacade;
/*import model.Cloud;*/
import model.Dimension;
import model.Direction;
import model.Model;
import model.Hero;
import model.Position;
import view.ViewFacade;

public abstract class Main {

	public static void main(final String[] args) {
		final Model model = new Model();

		model.buildArea(new Dimension(1000, 700));
		model.addMobile(new Hero(0,/* Direction.RIGHT,*/ new Position(10, 60), "larran"));
	/*  model.addMobile(new Monster(1, /*Direction.RIGHT, new Position(10, 590), "Monster1"));
		model.addMobile(new Monster(1, /*Direction.RIGHT, new Position(10, 590), "Monster2"));
		model.addMobile(new Monster(1, /*Direction.RIGHT, new Position(10, 590), "Monster3"));
		model.addMobile(new Monster(1, /*Direction.RIGHT,*new Position(10, 590), "Monster4"));*/
		

		final ControllerFacade controller = new ControllerFacade(model);
		final ViewFacade view = new ViewFacade(controller, model, model);
		controller.setViewSystem(view);
		controller.play();
	}

}

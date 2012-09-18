package SwaggControl;

import java.awt.Point;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Random;

import SwaggControl.Container.Cons;


@SuppressWarnings("deprecation")
public class AntiBan extends Strategy implements Task {

	@Override
	public void run() {
		int whatdo = Random.nextInt(0, 20);
		switch (whatdo) {

		case 0:
			Camera.setAngle(Random.nextInt(1, 360));
			break;
		case 1:
			Camera.setAngle(Random.nextInt(1, 180));
			break;

		case 2:
			wiggleMouse();
			break;
		case 3:
			mouseMove();
			break;
		case 4:
			mouseMove();
			break;
		case 5:
			wiggleMouse();
			break;

		default:
			wiggleMouse();
		}
		
		Cons.lastantiban = System.currentTimeMillis();

	}
	
	public void wiggleMouse() {
		final Point p = Mouse.getLocation();
		Mouse.move(new Point(Random.nextInt(-50, 50) + p.x, Random.nextInt(-50,
				50) + p.y));
	}

	public void mouseMove() {
		final Point p = Mouse.getLocation();
		Mouse.move(new Point(Random.nextInt(-100, 600) + p.x, Random.nextInt(
				-100, 600) + p.y));
	}

	@Override
	public boolean validate() {
		return System.currentTimeMillis() - Cons.lastantiban > Random.nextInt(10000,30000);
	}
}
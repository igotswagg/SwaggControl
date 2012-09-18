package SwaggControl;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Time;

import SwaggControl.Container.Cons;

@SuppressWarnings("deprecation")
public class WalkOut extends Strategy implements Task {

	@Override
	public void run() {

		if (Cons.PortalNum == 1) {
			if (Calculations.distanceTo(Cons.TO_EAST_PORTAL[3]) > 10) {
				Walking.findPath(Cons.TO_EAST_PORTAL[3]).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_EAST_PORTAL[3]) > 5) {
				Walking.newTilePath(Cons.TO_EAST_PORTAL).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_EAST_PORTAL[3]) < 5) {
				Cons.WalkOut = false;
				Cons.Attacking = true;
			}
		}
		if (Cons.PortalNum == 2) {
			if (Calculations.distanceTo(Cons.TO_SOUTH_EAST_PORTAL[3]) > 10) {
				Walking.findPath(Cons.TO_SOUTH_EAST_PORTAL[3]).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_SOUTH_EAST_PORTAL[3]) > 5) {
				Walking.newTilePath(Cons.TO_SOUTH_EAST_PORTAL).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_SOUTH_EAST_PORTAL[3]) < 5) {
				Cons.WalkOut = false;
				Cons.Attacking = true;
			}
		}
		if (Cons.PortalNum == 3) {
			if (Calculations.distanceTo(Cons.TO_SOUTH_WEST_PORTAL[3]) > 10) {
				Walking.findPath(Cons.TO_SOUTH_WEST_PORTAL[3]).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_SOUTH_WEST_PORTAL[3]) > 5) {
				Walking.newTilePath(Cons.TO_SOUTH_WEST_PORTAL).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_SOUTH_WEST_PORTAL[3]) < 5) {
				Cons.WalkOut = false;
				Cons.Attacking = true;
			}
		}
		if (Cons.PortalNum == 4) {
			if (Calculations.distanceTo(Cons.TO_WEST_PORTAL[2]) > 10) {
				Walking.findPath(Cons.TO_WEST_PORTAL[2]).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_WEST_PORTAL[2]) > 5) {
				Walking.newTilePath(Cons.TO_WEST_PORTAL).traverse();
				OpenDoors();
			}
			if (Calculations.distanceTo(Cons.TO_WEST_PORTAL[2]) < 5) {
				Cons.WalkOut = false;
				Cons.Attacking = true;
			}
		}

	}

	private void OpenDoors() {
		if ((SceneEntities.getNearest(Cons.DoorsClosed1).isOnScreen() || SceneEntities
				.getNearest(Cons.DoorsClosed2).isOnScreen())
				&& Calculations.distanceTo(SceneEntities
						.getNearest(Cons.DoorsClosed1)) < 3){
			if (SceneEntities.getNearest(Cons.DoorsClosed1).isOnScreen()) {
				SceneEntities.getNearest(Cons.DoorsClosed1).interact("Open");
				Time.sleep(3000, 4000);
			}
			if (SceneEntities.getNearest(Cons.DoorsClosed2).isOnScreen()) {
				SceneEntities.getNearest(Cons.DoorsClosed2).interact("Open");
				Time.sleep(3000, 4000);
			}
		}
	}

	@Override
	public boolean validate() {
		return Cons.WalkOut && Game.getClientState() != 12 && !Cons.Attacking;

	}
}

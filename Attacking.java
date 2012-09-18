package SwaggControl;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.api.wrappers.interactive.NPC;

import SwaggControl.Container.Cons;

@SuppressWarnings("deprecation")
public class Attacking extends Strategy implements Task {

	@Override
	public void run() {
		if (Cons.PortalNum == 1) {
			if (NPCs.getNearest(Cons.OPEN_EAST_PORTAL) != null) {
				if (Players.getLocal().getInteracting() != (NPCs
						.getNearest(Cons.OPEN_EAST_PORTAL))) {
					if (NPCs.getNearest(Cons.OPEN_EAST_PORTAL).isOnScreen()) {
						NPCs.getNearest(Cons.OPEN_EAST_PORTAL).interact(
								"Attack");
						Time.sleep(2000, 6000);
						return;
					} else
						Walking.walk(NPCs.getNearest(Cons.OPEN_EAST_PORTAL));
				}
			}
			if (NPCs.getNearest(Cons.CLOSED_EAST_PORTAL) != null) {
				if (Calculations.distanceTo(Cons.TO_EAST_PORTAL[3]) > 10) {
					Walking.findPath(Cons.TO_EAST_PORTAL[3]).traverse();
					Time.sleep(800, 1000);
				} else {
					Attackmethod();
				}
			}

			if (NPCs.getNearest(Cons.CLOSED_EAST_PORTAL) == null
					&& NPCs.getNearest(Cons.OPEN_EAST_PORTAL) == null) {
				NextPortal();
				Cons.Attacking = false;
				Cons.WalkOut = true;
				return;
			}
		}
		if (Cons.PortalNum == 2) {
			if (NPCs.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL) != null) {
				if (Players.getLocal().getInteracting() != (NPCs
						.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL))) {
					if (NPCs.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL)
							.isOnScreen()) {
						NPCs.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL).interact(
								"Attack");
						Time.sleep(2000, 6000);
						return;
					} else
						Walking.walk(NPCs
								.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL));
				}
			}
			if (NPCs.getNearest(Cons.CLOSED_SOUTH_EAST_PORTAL) != null) {
				if (Calculations.distanceTo(Cons.TO_SOUTH_EAST_PORTAL[3]) > 10) {
					Walking.findPath(Cons.TO_SOUTH_EAST_PORTAL[3]).traverse();
					Time.sleep(800, 1000);
				} else {
					Attackmethod();
				}
			}

			if (NPCs.getNearest(Cons.CLOSED_SOUTH_EAST_PORTAL) == null
					&& NPCs.getNearest(Cons.OPEN_SOUTH_EAST_PORTAL) == null) {
				NextPortal();
				Cons.Attacking = false;
				Cons.WalkOut = true;
				return;
			}

		}
		if (Cons.PortalNum == 3) {
			if (NPCs.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL) != null) {
				if (Players.getLocal().getInteracting() != (NPCs
						.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL))) {
					if (NPCs.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL)
							.isOnScreen()) {
						NPCs.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL).interact(
								"Attack");
						Time.sleep(2000, 6000);
						return;
					} else
						Walking.walk(NPCs
								.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL));
				}
			}
			if (NPCs.getNearest(Cons.CLOSED_SOUTH_WEST_PORTAL) != null) {
				if (Calculations.distanceTo(Cons.TO_SOUTH_WEST_PORTAL[3]) > 10) {
					Walking.findPath(Cons.TO_SOUTH_WEST_PORTAL[3]).traverse();
					Time.sleep(800, 1000);
				} else {
					Attackmethod();
				}
			}
			if (NPCs.getNearest(Cons.CLOSED_SOUTH_WEST_PORTAL) == null
					&& NPCs.getNearest(Cons.OPEN_SOUTH_WEST_PORTAL) == null) {
				Cons.PortalNum = Random.nextInt(1, 2);
				Cons.Attacking = false;
				Cons.WalkOut = true;
				return;
			}
		}
		if (Cons.PortalNum == 4) {
			if (NPCs.getNearest(Cons.OPEN_WEST_PORTAL) != null) {
				if (Players.getLocal().getInteracting() != (NPCs
						.getNearest(Cons.OPEN_WEST_PORTAL))) {
					if (NPCs.getNearest(Cons.OPEN_WEST_PORTAL).isOnScreen()) {
						NPCs.getNearest(Cons.OPEN_WEST_PORTAL).interact(
								"Attack");
						Time.sleep(2000, 6000);
						return;
					} else
						Walking.walk(NPCs.getNearest(Cons.OPEN_WEST_PORTAL));

				}
			}
			if (NPCs.getNearest(Cons.CLOSED_WEST_PORTAL) != null) {
				if (Calculations.distanceTo(Cons.TO_WEST_PORTAL[2]) > 10) {
					Walking.findPath(Cons.TO_WEST_PORTAL[2]).traverse();
					Time.sleep(800, 1000);
				} else {
					Attackmethod();
				}

			}

			if (NPCs.getNearest(Cons.CLOSED_WEST_PORTAL) == null
					&& NPCs.getNearest(Cons.OPEN_WEST_PORTAL) == null) {
				Cons.PortalNum = Random.nextInt(1, 4);
				Cons.Attacking = false;
				Cons.WalkOut = true;
				return;
			}

		}
	}

	private void NextPortal() {
		if (Integer.parseInt(Widgets.get(408, 13).getText()) > 500) {
			Cons.PortalNum = 4;
		}
		if (Integer.parseInt(Widgets.get(408, 14).getText()) > 500) {
			Cons.PortalNum = 1;
		}
		if (Integer.parseInt(Widgets.get(408, 15).getText()) > 500) {
			Cons.PortalNum = 2;
		}
		if (Integer.parseInt(Widgets.get(408, 16).getText()) > 500) {
			Cons.PortalNum = 3;
		}
	}

	private void Attackmethod() {
		 NPC Monster = NPCs.getNearest(new Filter<NPC>() {

			@Override
			public boolean accept(NPC m) {
				if (m.getName().startsWith("Spi")
						|| m.getName().startsWith("Rava")
						|| m.getName().startsWith("Shi")
						|| m.getName().startsWith("Tor")
						|| m.getName().startsWith("Defi")
						|| m.getName().startsWith("Bra")) {
					return true;
					
				} else
					return false;
			}

		});
		if (Players.getLocal().getInteracting() != Monster) {
		
			
			if (Monster.isOnScreen()) {		
				Monster.interact("Attack");
				Time.sleep(1000, 2200);
			} else {
				Camera.turnTo(Monster);
				Time.sleep(100,350);
				
				Walking.walk(Monster);
				Time.sleep(500, 1100);
			}
		}
	}

	@Override
	public boolean validate() {
		return Cons.Attacking;

	}

}

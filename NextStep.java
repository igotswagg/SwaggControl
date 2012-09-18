package SwaggControl;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.Tile;

import SwaggControl.Container.Cons;

@SuppressWarnings("deprecation")
public class NextStep extends Strategy implements Task {

	@Override
	public void run() {

		Cons.MovedAlready = false;

		if (Cons.PortalNum == 0) {
			Cons.PortalNum = Random.nextInt(1, 5);
		}

		Cons.CenterTileNPC = NPCs.getNearest(Cons.SQUIRE_ID);

		Cons.CT = Cons.CenterTileNPC.getLocation();

		Cons.WestPortalTile = new Tile(Cons.CT.getLocation().getX() - 22,
				Cons.CT.getLocation().getY() - 15, 0);
		Cons.SouthWestPortalTile = new Tile(Cons.CT.getLocation().getX() - 6,
				Cons.CT.getLocation().getY() - 35, 0);
		Cons.SouthEastPortalTile = new Tile(Cons.CT.getLocation().getX() + 13,
				Cons.CT.getLocation().getY() - 34, 0);
		Cons.EastPortalTile = new Tile(Cons.CT.getLocation().getX() + 23,
				Cons.CT.getLocation().getY() - 20, 0);

		Cons.TO_EAST_PORTAL[0] = new Tile(Cons.CT.getLocation().getX() + 3,
				Cons.CT.getLocation().getY() - 6, 0);
		Cons.TO_EAST_PORTAL[1] = new Tile(Cons.CT.getLocation().getX() + 9,
				Cons.CT.getLocation().getY() - 13, 0);
		Cons.TO_EAST_PORTAL[2] = new Tile(Cons.CT.getLocation().getX() + 15,
				Cons.CT.getLocation().getY() - 14, 0);
		Cons.TO_EAST_PORTAL[3] = new Tile(Cons.CT.getLocation().getX() + 23,
				Cons.CT.getLocation().getY() - 18, 0);

		Cons.TO_SOUTH_EAST_PORTAL[0] = new Tile(
				Cons.CT.getLocation().getX() + 1,
				Cons.CT.getLocation().getY() - 8, 0);
		Cons.TO_SOUTH_EAST_PORTAL[1] = new Tile(
				Cons.CT.getLocation().getX() + 1,
				Cons.CT.getLocation().getY() - 21, 0);
		Cons.TO_SOUTH_EAST_PORTAL[2] = new Tile(
				Cons.CT.getLocation().getX() + 2,
				Cons.CT.getLocation().getY() - 30, 0);
		Cons.TO_SOUTH_EAST_PORTAL[3] = new Tile(
				Cons.CT.getLocation().getX() + 13,
				Cons.CT.getLocation().getY() - 34, 0);

		Cons.TO_SOUTH_WEST_PORTAL[0] = new Tile(
				Cons.CT.getLocation().getX() + 1,
				Cons.CT.getLocation().getY() - 8, 0);
		Cons.TO_SOUTH_WEST_PORTAL[1] = new Tile(
				Cons.CT.getLocation().getX() + 1,
				Cons.CT.getLocation().getY() - 21, 0);
		Cons.TO_SOUTH_WEST_PORTAL[2] = new Tile(
				Cons.CT.getLocation().getX() + 2,
				Cons.CT.getLocation().getY() - 30, 0);
		Cons.TO_SOUTH_WEST_PORTAL[3] = new Tile(
				Cons.CT.getLocation().getX() - 8,
				Cons.CT.getLocation().getY() - 34, 0);

		Cons.TO_WEST_PORTAL[0] = new Tile(Cons.CT.getLocation().getX() - 5,
				Cons.CT.getLocation().getY() - 6, 0);

		Cons.TO_WEST_PORTAL[1] = new Tile(Cons.CT.getLocation().getX() - 10,
				Cons.CT.getLocation().getY() - 13, 0);

		Cons.TO_WEST_PORTAL[2] = new Tile(Cons.CT.getLocation().getX() - 24,
				Cons.CT.getLocation().getY() - 14, 0);

		/*
		 * 12063,1263 12058,1257 12052,1250 12039,1249
		 */

		Cons.WalkOut = true;

	}

	@Override
	public boolean validate() {
		return NPCs.getNearest(Cons.SQUIRE_ID) != null
				&& NPCs.getNearest(Cons.SQUIRE_ID).getLocation() != Cons.CT;

	}
}

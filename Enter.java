package SwaggControl;

import org.powerbot.concurrent.Task;
import org.powerbot.concurrent.strategy.Strategy;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.Time;

import SwaggControl.Container.Cons;

@SuppressWarnings("deprecation")
public class Enter extends Strategy implements Task {

	@Override
	public void run() {

		Cons.CTFlip = false;
		Cons.PortalNum = 0;
		Cons.Attacking = false;

		if (!Cons.InSideBoat.contains(Players.getLocal().getLocation())) {

			if (SceneEntities.getNearest(Cons.GANGPLANK_ID) != null) {
				if (SceneEntities.getNearest(Cons.GANGPLANK_ID).isOnScreen()) {
					SceneEntities.getNearest(Cons.GANGPLANK_ID).interact(
							"Cross");
					Time.sleep(400, 800);
				}
			}
		}
		if (Cons.InSideBoat.contains(Players.getLocal().getLocation())) {
			if (Widgets.get(407).getChild(16).isOnScreen()) {
				if (Cons.StartPoints == 0) {
					Cons.StartPoints = Integer.parseInt(Widgets.get(407)
							.getChild(16).getText()
							.replace("Commendations: ", ""));
				}
				if (Cons.StartPoints > 0) {

					Cons.PointsGained = Integer.parseInt(Widgets.get(407)
							.getChild(16).getText()
							.replace("Commendations: ", ""))
							- Cons.StartPoints;
				}
			}

			if (Cons.BoatTileInside.distance(Players.getLocal().getLocation()) <= 1
					&& !Cons.MovedAlready) {
				Cons.InSideBoat.getTileArray()[Random.nextInt(1, 23)]
						.click(true);
				Cons.MovedAlready = true;
			}
		}

	}

	@Override
	public boolean validate() {
		return Cons.OutSideBoat.contains(Players.getLocal().getLocation())
				&& Game.getClientState() != 12;

	}
}

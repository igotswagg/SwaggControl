package SwaggControl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import java.awt.*;

import javax.imageio.ImageIO;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;

import org.powerbot.game.api.ActiveScript;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Environment;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.bot.event.MessageEvent;
import org.powerbot.game.bot.event.listener.MessageListener;
import org.powerbot.game.bot.event.listener.PaintListener;

import SwaggControl.Container.Cons;


///// Credits to HouseMD for the scriptbase.

@Manifest(authors = { "IGotSwagg" }, name = "SwaggControl Pro", description = "Playes The Pest Control Minigame: Veteran lander", version = 1.7)
public class SwaggControl extends ActiveScript implements PaintListener, 
		MessageListener {

	public long startTime;

	public long millis = 0;

	public long hours = 0;

	public long minutes = 0;

	public long seconds = 0;

	public long last = 0;

	@Override
	protected void setup() {
		startTime = System.currentTimeMillis();
		Cons.startHP = Skills.getExperience(Skills.CONSTITUTION);
		Cons.startATT = Skills.getExperience(Skills.ATTACK);
		Cons.startSTR = Skills.getExperience(Skills.STRENGTH);
		Cons.startDEF = Skills.getExperience(Skills.DEFENSE);
		Cons.startRAN = Skills.getExperience(Skills.RANGE);
		Cons.startMAG = Skills.getExperience(Skills.MAGIC);
		Cons.uname = Environment.getDisplayName();
		Cons.lastupdate = System.currentTimeMillis();
		provide(new Enter());
		provide(new NextStep());
		provide(new WalkOut());
		provide(new Attacking());
		provide(new AntiBan());
		
	}



	private final DecimalFormat df = new DecimalFormat("###,###,###,###");

	private final RenderingHints antialiasing = new RenderingHints(
			RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	private Image getImage(String url) {
		try {
			return ImageIO.read(new URL(url));
		} catch (IOException e) {
			return null;
		}
	}

	private final Color color1 = new Color(255, 255, 255);;

	private final Font font1 = new Font("Blue Highway", 0, 12);

	private final Image img1 = getImage("http://img171.imageshack.us/img171/8692/swaggcontrol.png");

	public void onRepaint(Graphics g1) {

		///////////mouse
		
		Graphics2D g = (Graphics2D) g1;
		
		Point p = Mouse.getLocation();	
		g.setColor(Color.BLUE);   ///mouselines x/y
		g.drawLine(0, Mouse.getY(), Mouse.getX(), Mouse.getY());
		g.drawLine(765, Mouse.getY(), Mouse.getX(), Mouse.getY());
		g.drawLine(Mouse.getX() , 50 , Mouse.getX() , Mouse.getY());
		g.drawLine(Mouse.getX(), 550, Mouse.getX(), Mouse.getY());
		
		g.setColor(Color.RED);   ///mouse
		g.drawLine(p.x - 6, p.y, p.x + 6, p.y);
		g.drawLine(p.x, p.y - 6, p.x, p.y + 6);
		
		///////////mouse
		
		g.setRenderingHints(antialiasing);

		millis = System.currentTimeMillis() - startTime;

		hours = millis / (1000 * 60 * 60);

		millis -= hours * (1000 * 60 * 60);

		minutes = millis / (1000 * 60);

		millis -= minutes * (1000 * 60);

		seconds = millis / 1000;

		Cons.currenttime = (int) (System.currentTimeMillis() - startTime);

		Cons.xpGained = (Skills.getExperience(Skills.CONSTITUTION)
				+ Skills.getExperience(Skills.ATTACK)
				+ Skills.getExperience(Skills.STRENGTH)
				+ Skills.getExperience(Skills.DEFENSE)
				+ Skills.getExperience(Skills.RANGE) + Skills
					.getExperience(Skills.MAGIC))
				- (Cons.startHP + Cons.startATT + Cons.startSTR + Cons.startDEF
						+ Cons.startRAN + Cons.startMAG);

		if (Cons.debugscreen) {

			if (Cons.InSideBoat.contains(Players.getLocal().getLocation())) {
				Cons.InsideBoat = true;
			}
			if (Cons.Island.contains(Players.getLocal().getLocation())) {
				Cons.OnIsland = true;
			}

			if (Cons.BoatTileInside.distance(Players.getLocal().getLocation()) <= 1) {
				Cons.InsideTile = true;
			}
			g.drawString("DEBUG: " + Cons.CT, 5, 85);
			g.drawString("InsideBoat: " + Cons.InsideBoat, 5, 95);

		}
		
		//////paint
		g.drawImage(img1, -7, 329, null);
		g.setFont(font1);
		g.setColor(color1);
		g.drawString("" + Cons.PointsGained, 177, 480);
		g.drawString("" + df.format(Cons.xpGained) + "xp", 177, 461);
		g.drawString(hours + "H " + minutes + "M " + seconds + "S ", 177, 436);
		g.drawString("" + Cons.GamesPlayed, 177, 500);
			}
		//////paint
	

	@Override
	public void messageReceived(MessageEvent e) {
		String x = e.getMessage().toLowerCase();
		if (x.contains("have been added to your money pouch.")) {
			Cons.GamesPlayed++;
			Cons.PointsGained++; //// veteran lander 4 points gained per win = 4x pointsgained++ (pro version)
			Cons.PointsGained++; //// novice lander 2 points gained per win = 2x pointsgained++ (lite version)
			Cons.PointsGained++;
			Cons.PointsGained++;
		}
	}
}

package SwaggControl.Container;

import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.interactive.NPC;

public class Cons {
	
	// NPCs
public static final int CLOSED_EAST_PORTAL = 6147;
public static final int OPEN_EAST_PORTAL = 6143;

public static final int CLOSED_SOUTH_EAST_PORTAL = 6148;
public static final int OPEN_SOUTH_EAST_PORTAL = 6144 ;

public static final int CLOSED_WEST_PORTAL = 6146;
public static final int OPEN_WEST_PORTAL = 6142;

public static final int CLOSED_SOUTH_WEST_PORTAL = 6149;
public static final int OPEN_SOUTH_WEST_PORTAL = 6145;
	// PATHS
	public static Tile TO_EAST_PORTAL[] = { new Tile(0, 0, 0),
			new Tile(0, 0, 0), new Tile(0, 0, 0), new Tile(0, 0, 0) };
	public static Tile TO_SOUTH_EAST_PORTAL[] = { new Tile(0, 0, 0),
			new Tile(0, 0, 0), new Tile(0, 0, 0), new Tile(0, 0, 0) };
	public static Tile TO_SOUTH_WEST_PORTAL[] = { new Tile(0, 0, 0),
			new Tile(0, 0, 0), new Tile(0, 0, 0), new Tile(0, 0, 0) };
	public static Tile TO_WEST_PORTAL[] = { new Tile(0, 0, 0),
			new Tile(0, 0, 0), new Tile(0, 0, 0), new Tile(0, 0, 0) };

	// OBJECTS

	public static final int DoorsClosed1 = 14233; // Opened door
	public static final int DoorsClosed2 = 14235; // Opened door

	public static final int EastPortal = 3936; // east Shield down
	public static final int SouthEastPortal = 14235; // southeast Shield down
	public static final int SouthWestPortal = 14235; // southwest Shield down
	public static final int WestPortal = 14235; // west Shield down

	// AREAS
	public static final Area OutSideBoat = new Area(new Tile[] {
			new Tile(2638, 2655, 0), new Tile(2643, 2655, 0),
			new Tile(2643, 2652, 0), new Tile(2638, 2652, 0) });

	public static final Tile BoatEnterTile = new Tile(2638, 2653, 0);
	public static final Tile BoatTileInside = new Tile(2634, 2653, 0);
	public static Tile WestPortalTile;
	public static Tile SouthWestPortalTile;
	public static Tile SouthEastPortalTile;
	public static Tile EastPortalTile;
	public static NPC CenterTileNPC;
	public static Tile CT;

	public static final Area InSideBoat = new Area(new Tile[] {
			new Tile(2632, 2654, 0), new Tile(2635, 2652, 0),
			new Tile(2635, 2649, 0), new Tile(2632, 2649, 0) });

	public static final Area Island = new Area(new Tile[] {
			new Tile(2624, 2624, 0), new Tile(2686, 2623, 0),
			new Tile(2686, 2559, 0), new Tile(2624, 2560, 0) });
	
	public static final Area Center = new Area(new Tile[] { 
			new Tile(2642, 2607, 0), new Tile(2669, 2607, 0), 
			new Tile(2669, 2585, 0), new Tile(2642, 2585, 0) });

	// OBJECTS

	public static final int GANGPLANK_ID = 25632;

	// FLIPFLOPS

	public static boolean InsideBoat = false;
	public static boolean OnIsland = false;
	public static boolean InsideTile = false;
	public static boolean NeedLocationSet = false;
	public static boolean AtSetLocation = false;
	public static boolean WalkOut = false;
	public static boolean MovedAlready = false;
	public static boolean CTFlip = false;
	public static boolean busychoosing = false;
	public static boolean Attacking = false;
	
	public static long lastupdate;
	
	public static boolean debugscreen = false;
	public static String status;

	// STRING
	public static String debug;

	// INTS
	public static int Map;
	public static final int NIGHT_ID = 3784;
	public static final int SQUIRE_ID = 3781;
	public static int PortalNum = 0;

	// MONSTERS

	public static final int[] MONSTER_ID = { 3732, 3733, 3734, 3735, 3736,
			3737, 3738, 3739, 3740, 3741, 3742, 3743, 3744, 3745, 3746, 3747,
			3748, 3749, 3750, 3751, 3752, 3753, 3754, 375, 3756, 3757, 3758,
			3759, 3760, 3761, 3762, 376, 3764, 3765, 3766, 3767, 3768, 3769,
			3770, 3771, 3772, 3773, 3774, 3775, 3776 };
	
	//PAINT
	
	public static int PointsGained = 0;
	public static int oldPointsGained = 0;
	public static int xpGained = 0;
	public static int oldxpGained =0;
	public static int GamesPlayed = 0;
	public static int oldGamesPlayed = 0;
	
	public static int startHP = 0;
	public static int startSTR = 0;
	public static int startATT = 0;
	public static int startDEF = 0;
	public static int startRAN = 0;
	public static int startMAG = 0;
	
	public static long lastantiban;
	public static int StartPoints = 0;
	public static int Pointsstring;
	
	public static long currenttime;
	public static long oldtime;
	
	public static String uname;

}

package sx.cirno.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import java.util.Map;
import java.util.TreeMap;

public class Client extends GameWindowMiddleman {
	private final static int[][] ANIMATION_ARRAY = { { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4 }, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3, 4 },
			{ 11, 3, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4 }, { 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 }, { 3, 4, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 },
			{ 4, 3, 2, 9, 7, 1, 6, 10, 8, 11, 0, 5 }, { 11, 4, 2, 9, 7, 1, 6, 10, 0, 5, 8, 3 }, { 11, 2, 9, 7, 1, 6, 10, 0, 5, 8, 4, 3 } };

	private final static int[] CLOTHES_COLORS = { 0xff0000, 0xff8000, 0xffe000, 0xa0e000, 57344, 32768, 41088, 45311, 33023, 12528, 0xe000e0, 0x303030,
			0x604000, 0x805000, 0xffffff };

	private final static int[] COMBAT_MODELS_LEFT = { 0, 1, 2, 1, 0, 0, 0, 0 };

	private final static int[] COMBAT_MODELS_RIGHT = { 0, 0, 0, 0, 0, 1, 2, 1 };

	private final static String[] EQUIPMENT_INFO = { "Armour", "WeaponAim", "WeaponPower", "Magic", "Prayer" };

	private final static int HAIR_COLORS[] = { 0xffc030, 0xffa040, 0x805030, 0x604020, 0x303030, 0xff6020, 0xff4000, 0xffffff, 65280, 65535 };

	private final static int PROJECTILE_STARTING_POSITION = 40;

	private final static String[] QUESTS = { "Black knight's fortress", "Cook's assistant", "Demon slayer", "Doric's quest", "The restless ghost",
			"Goblin diplomacy", "Ernest the chicken", "Imp catcher", "Pirate's treasure", "Prince Ali rescue", "Romeo & Juliet", "Sheep shearer",
			"Shield of Arrav", "The knight's sword", "Vampire slayer", "Witch's potion", "Dragon slayer", "Witch's house (members)", "Lost city (members)",
			"Hero's quest (members)", "Druidic ritual (members)", "Merlin's crystal (members)", "Scorpion catcher (members)", "Family crest (members)",
			"Tribal totem (members)", "Fishing contest (members)", "Monk's friend (members)", "Temple of Ikov (members)", "Clock tower (members)",
			"The Holy Grail (members)", "Fight Arena (members)", "Tree Gnome Village (members)", "The Hazeel Cult (members)", "Sheep Herder (members)",
			"Plague City (members)", "Sea Slug (members)", "Waterfall quest (members)", "Biohazard (members)", "Jungle potion (members)",
			"Grand tree (members)", "Shilo village (members)", "Underground pass (members)", "Observatory quest (members)", "Tourist trap (members)",
			"Watchtower (members)", "Dwarf Cannon (members)", "Murder Mystery (members)", "Digsite (members)", "Gertrude's Cat (members)",
			"Legend's Quest (members)" };
	
	
	
	
	
	

	private final static long serialVersionUID = -1397419235049871484L;

	private final static String[] SKILLS = { "Attack", "Defense", "Strength", "Hits", "Ranged", "Prayer", "Magic", "Cooking", "Woodcut", "Fletching",
			"Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblaw", "Agility", "Thieving" };

	private final static int[] SKIN_COLORS = { 0xecded0, 0xccb366, 0xb38c40, 0x997326, 0x906020 };

	private final static int[] WALK_ANIMATIONS = { 0, 1, 2, 1 };

	/*
	 * Converts an integer to a string describing how much the integer
	 * represents.
	 */
	private final static String formatMoney(int i) {
		String s = String.valueOf(i);
		for (int j = s.length() - 3; j > 0; j -= 3)
			s = s.substring(0, j) + "," + s.substring(j);

		if (s.length() > 8)
			s = "@gre@" + s.substring(0, s.length() - 8) + " million @whi@(" + s + ")";
		else if (s.length() > 4)
			s = "@cya@" + s.substring(0, s.length() - 4) + "K @whi@(" + s + ")";
		return s;
	}

	/*
	 * Entry point for the RuneScape Classic client
	 */
	public final static void main(final String[] args) {
		final Client client = new Client();
		client.member = true;
		client.ip = "127.0.0.1";
		client.port = 43594;
		client.initClient(client.clientWidth, client.clientHeight + 11, "Runescape Classic by Andrew Gower");
		client.loadingPercent = 10;
	}

	private boolean aBoolean666;
	private boolean aBoolean699;
	private boolean aBoolean727;
	private boolean aBoolean785;
	private boolean aBoolean840;
	private boolean aBoolean901;
	private boolean aBoolean926;
	private final boolean aBoolean929;
	private boolean aBoolean940;
	private boolean aBoolean944;
	private boolean aBoolean945;
	private boolean aBoolean950;
	private boolean aBoolean951;
	private final boolean[] selectedPrayers;
	private final boolean[] aBooleanArray808;
	private final boolean[] aBooleanArray980;
	private int abuseType;
	private int abuseWindow;
	private byte[] aByteArray977;
	private Graphics gameGraphics;
	private long aLong973;
	private long aLong992;
	private long aLong993;
	private Menu magicPrayerMenu;
	private Menu gameMenu;
	private Menu aMenu_834;
	private Menu friendsMenu;
	private Model[] aModelArray700;
	private int anInt668;
	private int anInt669;
	private int anInt679;
	private int anInt682;
	private int anInt688;
	private int anInt724;
	private int anInt732;
	private int magicPrayerMenuHandle;
	private int magicPrayerSelected;
	private int anInt736;
	private int anInt737;
	private int anInt739;
	private int anInt740;
	private int anInt741;
	private int anInt742;
	private int anInt757;
	private int anInt759;
	private int anInt760;
	private int anInt761;
	private int anInt762;
	private int anInt763;
	private int anInt770;
	private int friendsWindow;
	private int anInt775;
	private int anInt793;
	private int anInt799;
	private int anInt800;
	private int anInt801;
	private int anInt802;
	private int anInt812;
	private int chatMessageBoxHandle;
	private int anInt814;
	private int anInt815;
	private int anInt816;
	private int anInt831;
	private int anInt832;
	private int anInt835;
	private int anInt836;
	private int anInt841;
	private int anInt842;
	private int anInt843;
	private int anInt847;
	private int anInt848;
	private int anInt853;
	private int anInt872;
	private int anInt879;
	private int anInt880;
	private int anInt881;
	private final int anInt892;
	private int anInt893;
	private int anInt894;
	private int anInt909;
	private int anInt913;
	private int anInt920;
	private int anInt921;
	private int questPoints;
	private int anInt952;
	private int anInt956;
	private int anInt957;
	private int anInt958;
	private int anInt962;
	private int anInt963;
	private int anInt964;
	private int anInt965;
	private int anInt970;
	private int anInt971;
	private int friendsMenuHandle;
	private int anInt991;
	private int anInt995;
	private int anInt996;
	private final int[] anIntArray664;
	private final int[] anIntArray665;
	private final int[] anIntArray680;
	private final int[] anIntArray681;
	private final int[] anIntArray683;
	private final int[] anIntArray684;
	private final int[] equipmentBonuses;
	private final int[] ourCurrentSkillLevels;
	private final int[] anIntArray755;
	private final int[] anIntArray756;
	private final int[] anIntArray765;
	private final int[] anIntArray766;
	private final int[] anIntArray794;
	private final int[] anIntArray795;
	private final int[] anIntArray844;
	private final int[] anIntArray845;
	private final int[] anIntArray846;
	private final int[] anIntArray849;
	private final int[] anIntArray850;
	private final int[] anIntArray851;
	private final int[] anIntArray870;
	private final int[] anIntArray871;
	private final int[] anIntArray873;
	private final int[] anIntArray874;
	private final int[] anIntArray878;
	private final int[] anIntArray886;
	private final int[] anIntArray887;
	private final int[] anIntArray915;
	private final int[] anIntArray916;
	private final int[] anIntArray923;
	private final int[] anIntArray924;
	private final int[] anIntArray925;
	private final long[] ourSkillExperience;
	private final int[] experience;
	private final int[] anIntArray983;
	private final int[] anIntArray984;
	private int areaX;
	private int areaY;
	private String aString758;
	private final String[] aStringArray667;
	private final String[] aStringArray676;
	private final String[] aStringArray833;
	private final String[] aStringArray972;
	private boolean bigSystemMessage;
	private final int[] bubbleItemArray;
	private int bubbleItemCount;
	private final int[] bubbleItemX;
	private final int[] bubbleItemY;
	private final int[] bubbleItemZ;
	private Camera camera;
	private int cameraAutoAngle;
	private int cameraRotation;
	private int characterBodyGender;
	private final int characterBodyType;
	private int characterBottomColor;
	private int characterDesignAcceptButton;
	private int characterDesignBottomColorButtonLeft;
	private int characterDesignBottomColorButtonRight;
	private int characterDesignGenderButtonLeft;
	private int characterDesignGenderButtonRight;
	private int characterDesignHairColorButtonLeft;
	private int characterDesignHairColorButtonRight;
	private int characterDesignHeadButtonLeft;
	private int characterDesignHeadButtonRight;
	private Menu characterDesignMenu;
	private int characterDesignSkinColorButtonLeft;
	private int characterDesignSkinColorButtonRight;
	private int characterDesignTopColorButtonLeft;
	private int characterDesignTopColorButtonRight;
	private int characterHairColor;
	private int characterHeadGender;
	private int characterHeadType;
	private int characterSkinColor;
	private int characterTopColor;
	private final int clientHeight;
	private final int clientWidth;
	private int currentClawSpellModel;
	private int currentFlameSpellModel;
	private String currentPassword;
	private int currentTorchModel;
	private String currentUser;
	private int daysSinceLogin;
	private int deathScreenTimer;
	private int doorCount;
	private final int[] doorDir;
	private final int[] doorId;
	private final int[] doorX;
	private final int[] doorY;
	private boolean duelNoMagic;
	private boolean duelNoPrayer;
	private boolean duelNoRetreating;
	private boolean duelNoWeapons;
	private boolean duelOpponentAccepted;
	private String duelOpponentName;
	private int duelOurItemCount;
	private int duelTheirItemCount;
	private boolean duelWeAccepted;
	private int entitiesAdded;
	private Model[] gameDataModels;
	private GameImage gameImage;
	private Map<Integer, GroundItem> groundItems;
	private boolean hasSeenWelcomeBox;
	private int healthBarCount;
	private final int[] healthBarPercentages;
	private final int[] healthBarX;
	private final int[] healthBarY;
	private final int[] inventoryItemAmount;
	private final int[] inventoryItems;
	private int inventorySize;
	private LandscapeEngine landscapeEngine;
	private int lastChangedRecoveries;
	private int lastClawSpellModel;
	private int lastFlameSpellModel;
	private int lastHeight;
	private String lastIp;
	private int lastIpAddress;
	private boolean lastLoadedNull;
	private int lastTorchModel;
	private int lastWalkTimeout;
	private int loggedIn;
	private int loginButton;
	private int loginButton1;
	private int loginButtonCancel;
	private Menu loginMenu;
	private int loginPasswordText;
	private int loginScreen;
	private int loginStatusText;
	private int loginTimeout;
	private int loginTimer;
	private int loginUsernameText;
	private boolean member;
	private boolean memoryError;
	private final int[] menuActions;
	private final String[] mobMessages;
	private int mobMessagesCount;
	private final int[] mobMessagesHeight;
	private final int[] mobMessagesWidth;
	private final int[] mobMessagesX;
	private final int[] mobMessagesY;
	private int mouseButtonClick;
	private int mouseClickArrayOffset;
	private final int[] mouseClickXArray;
	private final int[] mouseClickYArray;
	private int mouseOverMenu;
	private Menu newUserMenu;
	private Map<Integer, NPC> npcs;
	private Map<Integer, GroundObject> objects;
	private int ourIndex;
	private Player ourPlayer;
	private final int[] ourMaximumSkillLevels;
	private Map<Integer, Player> players;
	private boolean recievedConstants;
	private int sectionX;
	private int sectionY;
	private int selectedSpell;
	private boolean showCharacterDesignMenu;
	private boolean showDuelScreen;
	private boolean showSystemMessage;
	private boolean showTradeConfirmScreen;
	private boolean showTradeScreen;
	private boolean showWelcomeBox;
	private SoundPlayer soundPlayer;
	private String systemMessage;
	private int systemUpdateTimer;
	private Map<Integer, TeleportBubble> teleportBubbles;
	private String tradeOpponentName;
	private int tradeOurItemCount;
	private int tradeTheirItemCount;
	private boolean tradeTheyAccepted;
	private boolean tradeWeAccepted;
	private int unreadMessages;
	private Menu welcomeMenu;
	private int wildernessType;
	private int wildHeight;
	private int wildHeightModifier;
	private int wildX;
	private int wildY;
	private final int[] wornItems;

	private Client() {
		anIntArray664 = new int[8];
		anIntArray665 = new int[8];
		aBoolean666 = true;
		aStringArray667 = new String[5];
		currentUser = "";
		currentPassword = "";
		aStringArray676 = new String[250];
		duelOpponentAccepted = false;
		duelWeAccepted = false;
		anIntArray680 = new int[14];
		anIntArray681 = new int[14];
		anIntArray683 = new int[14];
		anIntArray684 = new int[14];
		systemMessage = "";
		duelOpponentName = "";
		inventoryItems = new int[35];
		inventoryItemAmount = new int[35];
		wornItems = new int[35];
		mobMessages = new String[50];
		aBoolean699 = false;
		aModelArray700 = new Model[500];
		mobMessagesX = new int[50];
		mobMessagesY = new int[50];
		mobMessagesWidth = new int[50];
		mobMessagesHeight = new int[50];
		equipmentBonuses = new int[5];
		selectedPrayers = new boolean[50];
		tradeTheyAccepted = false;
		tradeWeAccepted = false;
		bubbleItemZ = new int[50];
		bubbleItemArray = new int[50];
		lastHeight = -1;
		memoryError = false;
		anInt724 = 48;
		aBoolean727 = false;
		cameraAutoAngle = 1;
		anInt737 = 2;
		showSystemMessage = false;
		hasSeenWelcomeBox = false;
		ourCurrentSkillLevels = new int[18];
		wildHeight = -1;
		lastFlameSpellModel = -1;
		lastTorchModel = -1;
		lastClawSpellModel = -1;
		anIntArray755 = new int[8000];
		anIntArray756 = new int[8000];
		anInt757 = -1;
		aString758 = "";
		anIntArray765 = new int[8];
		anIntArray766 = new int[8];
		menuActions = new int[250];
		showCharacterDesignMenu = false;
		gameDataModels = new Model[1000];
		aBoolean785 = false;
		duelNoRetreating = false;
		duelNoMagic = false;
		duelNoPrayer = false;
		duelNoWeapons = false;
		anIntArray794 = new int[8];
		anIntArray795 = new int[8];
		healthBarX = new int[50];
		healthBarY = new int[50];
		healthBarPercentages = new int[50];
		aBooleanArray808 = new boolean[50];
		cameraRotation = 128;
		showWelcomeBox = false;
		characterBodyGender = 1;
		characterBodyType = 2;
		characterHairColor = 2;
		characterTopColor = 8;
		characterBottomColor = 14;
		characterHeadGender = 1;
		anInt831 = -1;
		anInt832 = -2;
		aStringArray833 = new String[250];
		ourMaximumSkillLevels = new int[18];
		aBoolean840 = false;
		anIntArray844 = new int[250];
		anIntArray845 = new int[250];
		anIntArray846 = new int[250];
		anIntArray849 = new int[256];
		anIntArray850 = new int[256];
		anIntArray851 = new int[256];
		member = false;
		bubbleItemX = new int[50];
		bubbleItemY = new int[50];
		anIntArray870 = new int[256];
		anIntArray871 = new int[256];
		anIntArray873 = new int[8];
		anIntArray874 = new int[8];
		anIntArray878 = new int[5];
		anIntArray886 = new int[250];
		anIntArray887 = new int[250];
		ourPlayer = new Player();
		ourIndex = -1;
		anInt892 = 30;
		showTradeConfirmScreen = false;
		aBoolean901 = false;
		bigSystemMessage = false;
		anInt913 = 550;
		anIntArray915 = new int[256];
		anIntArray916 = new int[256];
		recievedConstants = false;
		selectedSpell = -1;
		anInt921 = 2;
		anIntArray923 = new int[14];
		anIntArray924 = new int[14];
		anIntArray925 = new int[250];
		aBoolean926 = false;
		ourSkillExperience = new long[18];
		aBoolean929 = false;
		showDuelScreen = false;
		lastLoadedNull = false;
		experience = new int[200];
		aBoolean940 = false;
		mouseClickXArray = new int[8192];
		mouseClickYArray = new int[8192];
		aBoolean944 = false;
		aBoolean945 = false;
		doorX = new int[500];
		doorY = new int[500];
		aBoolean950 = false;
		aBoolean951 = false;
		doorDir = new int[500];
		doorId = new int[500];
		anInt970 = -1;
		anInt971 = -2;
		aStringArray972 = new String[5];
		showTradeScreen = false;
		aBooleanArray980 = new boolean[500];
		anIntArray983 = new int[14];
		anIntArray984 = new int[14];
		clientWidth = 512;
		clientHeight = 334;
		tradeOpponentName = "";
		objects = new TreeMap<Integer, GroundObject>();
		groundItems = new TreeMap<Integer, GroundItem>();
		players = new TreeMap<Integer, Player>();
		npcs = new TreeMap<Integer, NPC>();
		teleportBubbles = new TreeMap<Integer, TeleportBubble>();
	}

	private final void autoRotateCamera() {
		if ((cameraAutoAngle & 1) == 1 && landscapePlayerVisible(cameraAutoAngle))
			return;
		if ((cameraAutoAngle & 1) == 0 && landscapePlayerVisible(cameraAutoAngle)) {
			if (landscapePlayerVisible(cameraAutoAngle + 1 & 7)) {
				cameraAutoAngle = cameraAutoAngle + 1 & 7;
				return;
			}
			if (landscapePlayerVisible(cameraAutoAngle + 7 & 7))
				cameraAutoAngle = cameraAutoAngle + 7 & 7;
			return;
		}
		int ai[] = { 1, -1, 2, -2, 3, -3, 4 };
		for (int i = 0; i < 7; i++) {
			if (!landscapePlayerVisible(cameraAutoAngle + ai[i] + 8 & 7))
				continue;
			cameraAutoAngle = cameraAutoAngle + ai[i] + 8 & 7;
			break;
		}

		if ((cameraAutoAngle & 1) == 0 && landscapePlayerVisible(cameraAutoAngle)) {
			if (landscapePlayerVisible(cameraAutoAngle + 1 & 7)) {
				cameraAutoAngle = cameraAutoAngle + 1 & 7;
				return;
			}
			if (landscapePlayerVisible(cameraAutoAngle + 7 & 7))
				cameraAutoAngle = cameraAutoAngle + 7 & 7;
		}
	}

	private final void collectGarbage() {
		try {
			if (gameImage != null) {
				gameImage.method223();
				gameImage.imagePixelArray = null;
				gameImage = null;
			}
			if (camera != null) {
				camera.cleanupModels();
				camera = null;
			}
			gameDataModels = null;
			aModelArray700 = null;
			objects.clear();
			players.clear();
			npcs.clear();
			ourPlayer = null;
			if (landscapeEngine != null) {
				landscapeEngine.aModelArray606 = null;
				landscapeEngine.aModelArrayArray590 = null;
				landscapeEngine.aModelArrayArray608 = null;
				landscapeEngine.aModel_597 = null;
				landscapeEngine = null;
			}
			System.gc();
		} catch (Exception _ex) {
			_ex.printStackTrace();
		}
	}

	public final Image createImage(int i, int j) {
		if (GameWindow.gameFrame != null)
			return GameWindow.gameFrame.createImage(i, j);

		return super.createImage(i, j);
	}

	private final void displayMessage(String s, int i) {
		if (i == 2 || i == 4 || i == 6) {
			while (s.length() > 5 && s.charAt(0) == '@' && s.charAt(4) == '@')
				s = s.substring(5);
			int j = s.indexOf(":");
			if (j != -1) {
				String s1 = s.substring(0, j);
				long l = DataOperations.usernameToHash(s1);
				for (int i1 = 0; i1 < super.ignoresCount; i1++) {
					if (super.ignoresHashList[i1] == l)
						return;
				}

			}
		}
		if (i == 2)
			s = "@yel@" + s;
		if (i == 3 || i == 4)
			s = "@whi@" + s;
		if (i == 6)
			s = "@cya@" + s;
		if (anInt816 != 0) {
			if (i == 4 || i == 3)
				anInt962 = 200;
			if (i == 2 && anInt816 != 1)
				anInt963 = 200;
			if (i == 5 && anInt816 != 2)
				anInt964 = 200;
			if (i == 6 && anInt816 != 3)
				anInt965 = 200;
			if (i == 3 && anInt816 != 0)
				anInt816 = 0;
			if (i == 6 && anInt816 != 3 && anInt816 != 0)
				anInt816 = 0;
		}
		for (int k = 4; k > 0; k--) {
			aStringArray972[k] = aStringArray972[k - 1];
			anIntArray878[k] = anIntArray878[k - 1];
		}

		aStringArray972[0] = s;
		anIntArray878[0] = 300;
		if (i == 2) {
			if (gameMenu.anIntArray187[anInt812] == gameMenu.anIntArray188[anInt812] - 4) {
				gameMenu.method167(anInt812, s, true);
			} else {
				gameMenu.method167(anInt812, s, false);
			}
		}
		if (i == 5) {
			if (gameMenu.anIntArray187[anInt814] == gameMenu.anIntArray188[anInt814] - 4) {
				gameMenu.method167(anInt814, s, true);
			} else {
				gameMenu.method167(anInt814, s, false);
			}
		}
		if (i == 6) {
			if (gameMenu.anIntArray187[anInt815] == gameMenu.anIntArray188[anInt815] - 4) {
				gameMenu.method167(anInt815, s, true);
				return;
			}
			gameMenu.method167(anInt815, s, false);
		}
	}

	public final void displayUnableToLogout() {
		loginTimeout = 0;
		displayMessage("@cya@Sorry, you can't logout at the moment", 3);
	}

	private final void drawCharacterDesignMenu() {
		gameImage.lowDetailToggle = false;
		gameImage.refreshPixels();
		characterDesignMenu.drawMenu();
		int i = 140;
		int j = 50;
		i += 116;
		j -= 25;
		gameImage.spriteClipRoutine3(i - 32 - 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyType], CLOTHES_COLORS[characterBottomColor]);
		gameImage.spriteClipRoutine4(i - 32 - 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyGender], CLOTHES_COLORS[characterTopColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.spriteClipRoutine4(i - 32 - 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterHeadType], HAIR_COLORS[characterHairColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.spriteClipRoutine3(i - 32, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyType] + 6, CLOTHES_COLORS[characterBottomColor]);
		gameImage.spriteClipRoutine4(i - 32, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyGender] + 6, CLOTHES_COLORS[characterTopColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.spriteClipRoutine4(i - 32, j, 64, 102, Data.ANIMATION_NUMBERS[characterHeadType] + 6, HAIR_COLORS[characterHairColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.spriteClipRoutine3((i - 32) + 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyType] + 12, CLOTHES_COLORS[characterBottomColor]);
		gameImage.spriteClipRoutine4((i - 32) + 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterBodyGender] + 12, CLOTHES_COLORS[characterTopColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.spriteClipRoutine4((i - 32) + 55, j, 64, 102, Data.ANIMATION_NUMBERS[characterHeadType] + 12, HAIR_COLORS[characterHairColor],
				SKIN_COLORS[characterSkinColor], 0, false);
		gameImage.drawSprite(0, clientHeight, Data.SPRITE_OFFSET1 + 22);
		gameImage.drawImage(gameGraphics, 0, 0);
	}

	private final void drawChatStrings() {
		gameImage.drawSprite(0, clientHeight - 4, Data.SPRITE_OFFSET1 + 23);
		int i = GameImage.method222(200, 200, 255);
		if (anInt816 == 0)
			i = GameImage.method222(255, 200, 50);
		if (anInt962 % 30 > 15)
			i = GameImage.method222(255, 50, 50);
		gameImage.drawCenteredString("All messages", 54, clientHeight + 6, 0, i);
		i = GameImage.method222(200, 200, 255);
		if (anInt816 == 1)
			i = GameImage.method222(255, 200, 50);
		if (anInt963 % 30 > 15)
			i = GameImage.method222(255, 50, 50);
		gameImage.drawCenteredString("Chat history", 155, clientHeight + 6, 0, i);
		i = GameImage.method222(200, 200, 255);
		if (anInt816 == 2)
			i = GameImage.method222(255, 200, 50);
		if (anInt964 % 30 > 15)
			i = GameImage.method222(255, 50, 50);
		gameImage.drawCenteredString("Quest history", 255, clientHeight + 6, 0, i);
		i = GameImage.method222(200, 200, 255);
		if (anInt816 == 3)
			i = GameImage.method222(255, 200, 50);
		if (anInt965 % 30 > 15)
			i = GameImage.method222(255, 50, 50);
		gameImage.drawCenteredString("Private history", 355, clientHeight + 6, 0, i);
		gameImage.drawCenteredString("Report abuse", 457, clientHeight + 6, 0, 0xffffff);
	}

	private final void drawGame() {
		if (deathScreenTimer != 0) {
			gameImage.fadeToBlack();
			gameImage.drawCenteredString("Oh dear! You are dead...", clientWidth / 2, clientHeight / 2, 7, 0xff0000);
			drawChatStrings();
			gameImage.drawImage(gameGraphics, 0, 0);
			return;
		}
		if (showCharacterDesignMenu) {
			drawCharacterDesignMenu();
			return;
		}
		if (!landscapeEngine.aBoolean613)
			return;
		for (int i = 0; i < 64; i++) {
			camera.removeModel(landscapeEngine.aModelArrayArray608[lastHeight][i]);
			if (lastHeight == 0) {
				camera.removeModel(landscapeEngine.aModelArrayArray590[1][i]);
				camera.removeModel(landscapeEngine.aModelArrayArray608[1][i]);
				camera.removeModel(landscapeEngine.aModelArrayArray590[2][i]);
				camera.removeModel(landscapeEngine.aModelArrayArray608[2][i]);
			}
			aBoolean926 = true;
			if (lastHeight == 0 && (landscapeEngine.walkableValue[ourPlayer.getX() / 128][ourPlayer.getY() / 128] & 0x80) == 0) {
				camera.addModel(landscapeEngine.aModelArrayArray608[lastHeight][i]);
				if (lastHeight == 0) {
					camera.addModel(landscapeEngine.aModelArrayArray590[1][i]);
					camera.addModel(landscapeEngine.aModelArrayArray608[1][i]);
					camera.addModel(landscapeEngine.aModelArrayArray590[2][i]);
					camera.addModel(landscapeEngine.aModelArrayArray608[2][i]);
				}
				aBoolean926 = false;
			}
		}

		if (currentFlameSpellModel != lastFlameSpellModel) {
			lastFlameSpellModel = currentFlameSpellModel;
			for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
				GroundObject object = e.getValue();
				if (object.getId() == 97)
					updateAnimatedObjects(object.getIndex(), "firea" + (currentFlameSpellModel + 1));
				if (object.getId() == 274)
					updateAnimatedObjects(object.getIndex(), "fireplacea" + (currentFlameSpellModel + 1));
				if (object.getId() == 1031)
					updateAnimatedObjects(object.getIndex(), "lightning" + (currentFlameSpellModel + 1));
				if (object.getId() == 1036)
					updateAnimatedObjects(object.getIndex(), "firespell" + (currentFlameSpellModel + 1));
				if (object.getId() == 1147)
					updateAnimatedObjects(object.getIndex(), "spellcharge" + (currentFlameSpellModel + 1));
			}

		}
		if (currentTorchModel != lastTorchModel) {
			lastTorchModel = currentTorchModel;
			for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
				GroundObject object = e.getValue();
				if (object.getId() == 51)
					updateAnimatedObjects(object.getIndex(), "torcha" + (currentTorchModel + 1));
				if (object.getId() == 143)
					updateAnimatedObjects(object.getIndex(), "skulltorcha" + (currentTorchModel + 1));
			}

		}
		if (currentClawSpellModel != lastClawSpellModel) {
			lastClawSpellModel = currentClawSpellModel;
			for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
				GroundObject object = e.getValue();
				if (object.getId() == 1142)
					updateAnimatedObjects(object.getIndex(), "clawspell" + (currentClawSpellModel + 1));
			}

		}
		camera.updateEntitiesAdded(entitiesAdded);
		entitiesAdded = 0;
		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player player = e.getValue();
			if (player.getBottomColor() != 255) {
				int k1 = player.getX();
				int i2 = player.getY();
				int k2 = -landscapeEngine.getAveragedElevation(k1, i2);
				int entityIndex = camera.addEntity(5000 + player.getIndex(), k1, k2, i2, 145, 220, player.getIndex() + 10000);
				entitiesAdded++;
				if (player == ourPlayer)
					camera.setOurPlayer(entityIndex);
				if (player.getCurrentSprite() == 8)
					camera.setOffset(entityIndex, -30);
				if (player.getCurrentSprite() == 9)
					camera.setOffset(entityIndex, 30);
			}
		}

		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player player = e.getValue();
			if (player.getProjectile() != null && player.getProjectile().getPosition() > 0) {
				Mob opponent = player.getProjectile().getTarget();
				if (opponent != null) {
					int l6 = -landscapeEngine.getAveragedElevation(player.getX(), player.getY()) - 110;
					int l8 = opponent.getX();
					int k9 = opponent.getY();
					int l9 = -landscapeEngine.getAveragedElevation(l8, k9) - Data.NPC_CAMERA2[opponent.getId()] / 2;
					int i10 = (player.getX() * player.getProjectile().getPosition() + l8
							* (PROJECTILE_STARTING_POSITION - player.getProjectile().getPosition()))
							/ PROJECTILE_STARTING_POSITION;
					int j10 = (l6 * player.getProjectile().getPosition() + l9 * (PROJECTILE_STARTING_POSITION - player.getProjectile().getPosition()))
							/ PROJECTILE_STARTING_POSITION;
					int k10 = (player.getY() * player.getProjectile().getPosition() + k9
							* (PROJECTILE_STARTING_POSITION - player.getProjectile().getPosition()))
							/ PROJECTILE_STARTING_POSITION;
					camera.addEntity(Data.SPRITE_OFFSET5 + player.getProjectile().getSprite(), i10, j10, k10, 32, 32, 0);
					entitiesAdded++;
				}
			}
		}

		for (Map.Entry<Integer, NPC> e : npcs.entrySet()) {
			NPC n = e.getValue();
			int i3 = n.getX();
			int j4 = n.getY();
			int i7 = -landscapeEngine.getAveragedElevation(i3, j4);
			int entityIndex = camera.addEntity(20000 + n.getIndex(), i3, i7, j4, Data.NPC_CAMERA1[n.getId()], Data.NPC_CAMERA2[n.getId()], n.getIndex() + 30000);
			entitiesAdded++;
			if (n.getCurrentSprite() == 8)
				camera.setOffset(entityIndex, -30);
			if (n.getCurrentSprite() == 9)
				camera.setOffset(entityIndex, 30);
		}

		for (Map.Entry<Integer, GroundItem> e : groundItems.entrySet()) {
			GroundItem item = e.getValue();
			int j3 = item.getX() * 128 + 64;
			int k4 = item.getY() * 128 + 64;
			camera.addEntity(40000 + item.getId(), j3, -landscapeEngine.getAveragedElevation(j3, k4) - item.getZ(), k4, 96, 64, item.getIndex() + 20000);
			entitiesAdded++;
		}

		for (Map.Entry<Integer, TeleportBubble> e : teleportBubbles.entrySet()) {
			TeleportBubble bubble = e.getValue();
			int l4 = bubble.getX() * 128 + 64;
			int j7 = bubble.getY() * 128 + 64;
			int j9 = bubble.getId();
			if (j9 == 0) {
				camera.addEntity(50000 + bubble.getIndex(), l4, -landscapeEngine.getAveragedElevation(l4, j7), j7, 128, 256, bubble.getIndex() + 50000);
				entitiesAdded++;
			}
			if (j9 == 1) {
				camera.addEntity(50000 + bubble.getIndex(), l4, -landscapeEngine.getAveragedElevation(l4, j7), j7, 128, 64, bubble.getIndex() + 50000);
				entitiesAdded++;
			}
		}

		gameImage.lowDetailToggle = false;
		gameImage.refreshPixels();
		gameImage.lowDetailToggle = super.keyLowDetailDown;
		if (lastHeight == 3) {
			int i5 = 40 + (int) (Math.random() * 3D);
			int k7 = 40 + (int) (Math.random() * 7D);
			camera.method309(i5, k7, -50, -10, -50);
		}
		bubbleItemCount = 0;
		mobMessagesCount = 0;
		healthBarCount = 0;
		if (aBoolean929) {
			if (aBoolean666 && !aBoolean926) {
				int j5 = cameraAutoAngle;
				autoRotateCamera();
				if (cameraAutoAngle != j5) {
					anInt879 = ourPlayer.getX();
					anInt880 = ourPlayer.getY();
				}
			}
			camera.zoom1 = 3000;
			camera.zoom2 = 3000;
			camera.zoom3 = 1;
			camera.zoom4 = 2800;
			cameraRotation = cameraAutoAngle * 32;
			int k5 = anInt879 + anInt736;
			int l7 = anInt880 + anInt920;
			camera.method297(k5, -landscapeEngine.getAveragedElevation(k5, l7), l7, 912, cameraRotation * 4, 0, 2000);
		} else {
			if (aBoolean666 && !aBoolean926)
				autoRotateCamera();
			if (!super.keyLowDetailDown) {
				camera.zoom1 = 2400;
				camera.zoom2 = 2400;
				camera.zoom3 = 1;
				camera.zoom4 = 2300;
			} else {
				camera.zoom1 = 2200;
				camera.zoom2 = 2200;
				camera.zoom3 = 1;
				camera.zoom4 = 2100;
			}
			int l5 = anInt879 + anInt736;
			int i8 = anInt880 + anInt920;
			camera.method297(l5, -landscapeEngine.getAveragedElevation(l5, i8), i8, 912, cameraRotation * 4, 0, anInt913 * 2);
		}
		camera.processCamera();
		method119();
		if (anInt841 > 0)
			gameImage.drawSprite(anInt842 - 8, anInt843 - 8, Data.SPRITE_OFFSET1 + 14 + (24 - anInt841) / 6);
		if (anInt841 < 0)
			gameImage.drawSprite(anInt842 - 8, anInt843 - 8, Data.SPRITE_OFFSET1 + 18 + (24 + anInt841) / 6);
		if (systemUpdateTimer != 0) {
			int i6 = systemUpdateTimer / 50;
			int j8 = i6 / 60;
			i6 %= 60;
			gameImage.drawCenteredString("System update in: " + j8 + ":" + (i6 < 10 ? ":0" + i6 : i6), 256, clientHeight - 7, 1, 0xffff00);
		}
		if (!recievedConstants) {
			int j6 = 2203 - (sectionY + wildY + areaY);
			if (sectionX + wildX + areaX >= 2640)
				j6 = -50;
			if (j6 > 0) {
				int k8 = 1 + j6 / 6;
				gameImage.drawSprite(453, clientHeight - 56, Data.SPRITE_OFFSET1 + 13);
				gameImage.drawCenteredString("Wilderness", 465, clientHeight - 20, 1, 0xffff00);
				gameImage.drawCenteredString("Level: " + k8, 465, clientHeight - 7, 1, 0xffff00);
				if (wildernessType == 0)
					wildernessType = 2;
			}
			if (wildernessType == 0 && j6 > -10 && j6 <= 0)
				wildernessType = 1;
		}
		if (anInt816 == 0) {
			for (int k6 = 0; k6 < 5; k6++) {
				if (anIntArray878[k6] > 0) {
					String s = aStringArray972[k6];
					gameImage.drawString(s, 7, clientHeight - 18 - k6 * 12, 1, 0xffff00);
				}
			}

		}
		gameMenu.method171(anInt812);
		gameMenu.method171(anInt814);
		gameMenu.method171(anInt815);
		if (anInt816 == 1) {
			gameMenu.method170(anInt812);
		} else if (anInt816 == 2) {
			gameMenu.method170(anInt814);
		} else if (anInt816 == 3)
			gameMenu.method170(anInt815);
		Menu.anInt225 = 2;
		gameMenu.drawMenu();
		Menu.anInt225 = 0;
		gameImage.method232(gameImage.defaultMenuWidth - 3 - 197, 3, Data.SPRITE_OFFSET1, 128);
		method111();
		gameImage.drawStringShadows = false;
		drawChatStrings();
		gameImage.drawImage(gameGraphics, 0, 0);
	}

	public final void drawGroundItem(int i, int j, int k, int l, int id) {
		gameImage.spriteClipRoutine4(i, j, k, l, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[id], Data.ITEM_COLOR_MASKS[id], 0, 0, false);
	}

	/*
	 * Draws the menus that are used to login Looks like this may only be called
	 * after dying. Will see later.
	 */
	private final void drawLoginMenus() {
		hasSeenWelcomeBox = false;
		gameImage.lowDetailToggle = false;
		gameImage.refreshPixels();
		if (loginScreen == 0)
			welcomeMenu.drawMenu();
		if (loginScreen == 2)
			loginMenu.drawMenu();
		gameImage.drawSprite(0, clientHeight, Data.SPRITE_OFFSET1 + 22);
		gameImage.drawImage(gameGraphics, 0, 0);
	}

	private final void drawMiniMap(boolean flag) {
		int i = gameImage.defaultMenuWidth - 199;
		char c = '\234';
		char c2 = '\230';
		gameImage.drawSprite(i - 49, 3, Data.SPRITE_OFFSET1 + 2);
		i += 40;
		gameImage.drawBox(i, 36, c, c2, 0);
		gameImage.method208(i, 36, i + c, 36 + c2);
		int k = 192 + anInt996;
		int i1 = cameraRotation + anInt995 & 0xff;
		int k1 = ((ourPlayer.getX() - 6040) * 3 * k) / 2048;
		int i3 = ((ourPlayer.getY() - 6040) * 3 * k) / 2048;
		int k4 = Camera.MINIMAP_VAR1[1024 - i1 * 4 & 0x3ff];
		int i5 = Camera.MINIMAP_VAR1[(1024 - i1 * 4 & 0x3ff) + 1024];
		int k5 = i3 * k4 + k1 * i5 >> 18;
		i3 = i3 * i5 - k1 * k4 >> 18;
		k1 = k5;
		gameImage.method242((i + c / 2) - k1, 36 + c2 / 2 + i3, Data.SPRITE_OFFSET1 - 1, i1 + 64 & 0xff, k);
		for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
			GroundObject object = e.getValue();
			int l1 = (((object.getX() * 128 + 64) - ourPlayer.getX()) * 3 * k) / 2048;
			int j3 = (((object.getY() * 128 + 64) - ourPlayer.getY()) * 3 * k) / 2048;
			int l5 = j3 * k4 + l1 * i5 >> 18;
			j3 = j3 * i5 - l1 * k4 >> 18;
			l1 = l5;
			method118(i + c / 2 + l1, (36 + c2 / 2) - j3, 65535);
		}

		for (Map.Entry<Integer, GroundItem> e : groundItems.entrySet()) {
			GroundItem item = e.getValue();
			int i2 = (((item.getX() * 128 + 64) - ourPlayer.getX()) * 3 * k) / 2048;
			int k3 = (((item.getY() * 128 + 64) - ourPlayer.getY()) * 3 * k) / 2048;
			int i6 = k3 * k4 + i2 * i5 >> 18;
			k3 = k3 * i5 - i2 * k4 >> 18;
			i2 = i6;
			method118(i + c / 2 + i2, (36 + c2 / 2) - k3, 0xff0000);
		}

		for (Map.Entry<Integer, NPC> e : npcs.entrySet()) {
			NPC npc = e.getValue();
			int j2 = ((npc.getX() - ourPlayer.getX()) * 3 * k) / 2048;
			int l3 = ((npc.getY() - ourPlayer.getY()) * 3 * k) / 2048;
			int j6 = l3 * k4 + j2 * i5 >> 18;
			l3 = l3 * i5 - j2 * k4 >> 18;
			j2 = j6;
			method118(i + c / 2 + j2, (36 + c2 / 2) - l3, 0xffff00);
		}

		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player p = e.getValue();
			int k2 = ((p.getX() - ourPlayer.getX()) * 3 * k) / 2048;
			int i4 = ((p.getY() - ourPlayer.getY()) * 3 * k) / 2048;
			int k6 = i4 * k4 + k2 * i5 >> 18;
			i4 = i4 * i5 - k2 * k4 >> 18;
			k2 = k6;
			int j8 = 0xffffff;
			for (int k8 = 0; k8 < super.friendsCount; k8++) {
				if (p.getUsernameHash() != super.friendsHashList[k8] || super.friendsOnline[k8] != 99)
					continue;
				j8 = 65280;
				break;
			}

			method118(i + c / 2 + k2, (36 + c2 / 2) - i4, j8);
		}

		gameImage.method212(i + c / 2, 36 + c2 / 2, 2, 0xffffff, 255);
		gameImage.method242(i + 19, 55, Data.SPRITE_OFFSET1 + 24, cameraRotation + 128 & 0xff, 128);
		gameImage.method208(0, 0, clientWidth, clientHeight + 12);
		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 199);
		int i8 = super.mouseY - 36;
		if (i >= 40 && i8 >= 0 && i < 196 && i8 < 152) {
			char c1 = '\234';
			char c3 = '\230';
			int l = 192 + anInt996;
			int j1 = cameraRotation + anInt995 & 0xff;
			int j = (gameImage).defaultMenuWidth - 199;
			j += 40;
			int l2 = ((super.mouseX - (j + c1 / 2)) * 16384) / (3 * l);
			int j4 = ((super.mouseY - (36 + c3 / 2)) * 16384) / (3 * l);
			int l4 = Camera.MINIMAP_VAR1[1024 - j1 * 4 & 0x3ff];
			int j5 = Camera.MINIMAP_VAR1[(1024 - j1 * 4 & 0x3ff) + 1024];
			int l6 = j4 * l4 + l2 * j5 >> 15;
			j4 = j4 * j5 - l2 * l4 >> 15;
			l2 = l6;
			l2 += ourPlayer.getX();
			j4 = ourPlayer.getY() - j4;
			if (mouseButtonClick == 1)
				method112(sectionX, sectionY, l2 / 128, j4 / 128, false);
			mouseButtonClick = 0;
		}
	}

	private final void drawReportAbuseWindow1() {
		abuseType = 0;
		int i = 135;
		for (int j = 0; j < 12; j++) {
			if (super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 12 && super.mouseY < i + 3) {
				abuseType = j + 1;
			}
			i += 14;
		}

		if (mouseButtonClick != 0 && abuseType != 0) {
			mouseButtonClick = 0;
			abuseWindow = 2;
			super.inputText = "";
			super.enteredText = "";
			return;
		}
		i += 15;
		if (mouseButtonClick != 0) {
			mouseButtonClick = 0;
			if (super.mouseX < 56 || super.mouseY < 35 || super.mouseX > 456 || super.mouseY > 325) {
				abuseWindow = 0;
				return;
			}
			if (super.mouseX > 66 && super.mouseX < 446 && super.mouseY >= i - 15 && super.mouseY < i + 5) {
				abuseWindow = 0;
				return;
			}
		}
		gameImage.drawBox(56, 35, 400, 290, 0);
		gameImage.drawBoxEdge(56, 35, 400, 290, 0xffffff);
		i = 50;
		gameImage.drawCenteredString("This form is for reporting players who are breaking our rules", 256, i, 1, 0xffffff);
		i += 15;
		gameImage.drawCenteredString("Using it sends a snapshot of the last 60 secs of activity to us", 256, i, 1, 0xffffff);
		i += 15;
		gameImage.drawCenteredString("If you misuse this form, you will be banned.", 256, i, 1, 0xff8000);
		i += 15;
		i += 10;
		gameImage.drawCenteredString("First indicate which of our 12 rules is being broken. For a detailed", 256, i, 1, 0xffff00);
		i += 15;
		gameImage.drawCenteredString("explanation of each rule please read the manual on our website.", 256, i, 1, 0xffff00);
		i += 15;
		int k;
		if (abuseType == 1) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("1: Offensive language", 256, i, 1, k);
		i += 14;
		if (abuseType == 2) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("2: Item scamming", 256, i, 1, k);
		i += 14;
		if (abuseType == 3) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("3: Password scamming", 256, i, 1, k);
		i += 14;
		if (abuseType == 4) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("4: Bug abuse", 256, i, 1, k);
		i += 14;
		if (abuseType == 5) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("5: Jagex Staff impersonation", 256, i, 1, k);
		i += 14;
		if (abuseType == 6) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("6: Account sharing/trading", 256, i, 1, k);
		i += 14;
		if (abuseType == 7) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("7: Macroing", 256, i, 1, k);
		i += 14;
		if (abuseType == 8) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("8: Mutiple logging in", 256, i, 1, k);
		i += 14;
		if (abuseType == 9) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("9: Encouraging others to break rules", 256, i, 1, k);
		i += 14;
		if (abuseType == 10) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("10: Misuse of customer support", 256, i, 1, k);
		i += 14;
		if (abuseType == 11) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("11: Advertising / website", 256, i, 1, k);
		i += 14;
		if (abuseType == 12) {
			gameImage.drawBoxEdge(66, i - 12, 380, 15, 0xffffff);
			k = 0xff8000;
		} else {
			k = 0xffffff;
		}
		gameImage.drawCenteredString("12: Real world item trading", 256, i, 1, k);
		i += 14;
		i += 15;
		k = 0xffffff;
		if (super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 15 && super.mouseY < i + 5)
			k = 0xffff00;
		gameImage.drawCenteredString("Click here to cancel", 256, i, 1, k);
	}

	private final void drawSystemMessage() {
		char c = '\u0190';
		char c1 = 'd';
		if (bigSystemMessage)
			c1 = '\u012C';
		gameImage.drawBox(256 - c / 2, 167 - c1 / 2, c, c1, 0);
		gameImage.drawBoxEdge(256 - c / 2, 167 - c1 / 2, c, c1, 0xffffff);
		gameImage.method255(systemMessage, 256, (167 - c1 / 2) + 20, 1, 0xffffff, c - 40);
		int i = 157 + c1 / 2;
		int j = 0xffffff;
		if (super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 106 && super.mouseX < 406)
			j = 0xff0000;
		gameImage.drawCenteredString("Click here to close window", 256, i, 1, j);
		if (mouseButtonClick == 1) {
			if (j == 0xff0000)
				showSystemMessage = false;
			if ((super.mouseX < 256 - c / 2 || super.mouseX > 256 + c / 2) && (super.mouseY < 167 - c1 / 2 || super.mouseY > 167 + c1 / 2)) {
				showSystemMessage = false;
			}
		}
		mouseButtonClick = 0;
	}

	public final void drawTeleportBubble(int i, int j, int k, int l, int i1) {
		int l1 = teleportBubbles.get(i1).getId();
		int i2 = teleportBubbles.get(i1).getTimer();
		if (l1 == 0) {
			int j2 = 255 + i2 * 5 * 256;
			gameImage.method212(i + k / 2, j + l / 2, 20 + i2 * 2, j2, 255 - i2 * 5);
		}
		if (l1 == 1) {
			int k2 = 0xff0000 + i2 * 5 * 256;
			gameImage.method212(i + k / 2, j + l / 2, 10 + i2, k2, 255 - i2 * 5);
		}
	}

	private final void drawWelcomeScreen() {
		int i = 65;
		if (lastChangedRecoveries != 201)
			i += 60;
		if (unreadMessages > 0)
			i += 60;
		if (lastIpAddress != 0)
			i += 45;
		int j = 167 - i / 2;
		gameImage.drawBox(56, 167 - i / 2, 400, i, 0);
		gameImage.drawBoxEdge(56, 167 - i / 2, 400, i, 0xffffff);
		j += 20;
		gameImage.drawCenteredString("Welcome to RuneScape " + currentUser, 256, j, 4, 0xffff00);
		j += 30;
		String s;
		if (daysSinceLogin == 0) {
			s = "earlier today";
		} else if (daysSinceLogin == 1) {
			s = "yesterday";
		} else {
			s = daysSinceLogin + " days ago";
		}
		if (lastIpAddress != 0) {
			gameImage.drawCenteredString("You last logged in " + s, 256, j, 1, 0xffffff);
			j += 15;
			if (lastIp == null)
				lastIp = DataOperations.convertIntToIp(lastIpAddress);
			gameImage.drawCenteredString("from: " + lastIp, 256, j, 1, 0xffffff);
			j += 15;
			j += 15;
		}
		if (unreadMessages > 0) {
			int k = 0xffffff;
			gameImage.drawCenteredString("RuneScape staff will NEVER email you. We use the", 256, j, 1, k);
			j += 15;
			gameImage.drawCenteredString("message-centre on this website instead.", 256, j, 1, k);
			j += 15;
			if (unreadMessages == 1) {
				gameImage.drawCenteredString("You have @yel@0@whi@ unread messages in your message-centre", 256, j, 1, 0xffffff);
			} else {
				gameImage.drawCenteredString("You have @gre@" + (unreadMessages - 1) + " unread messages @whi@in your message-centre", 256, j, 1, 0xffffff);
			}
			j += 15;
			j += 15;
		}
		if (lastChangedRecoveries != 201) {
			if (lastChangedRecoveries == 200) {
				gameImage.drawCenteredString("You have not yet set any password recovery questions.", 256, j, 1, 0xff8000);
				j += 15;
				gameImage.drawCenteredString("We strongly recommend you do so now to secure your account.", 256, j, 1, 0xff8000);
				j += 15;
				gameImage.drawCenteredString("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
				j += 15;
			} else {
				String s1;
				if (lastChangedRecoveries == 0) {
					s1 = "Earlier today";
				} else if (lastChangedRecoveries == 1) {
					s1 = "Yesterday";
				} else {
					s1 = lastChangedRecoveries + " days ago";
				}
				gameImage.drawCenteredString(s1 + " you changed your recovery questions", 256, j, 1, 0xff8000);
				j += 15;
				gameImage.drawCenteredString("If you do not remember making this change then cancel it immediately", 256, j, 1, 0xff8000);
				j += 15;
				gameImage.drawCenteredString("Do this from the 'account management' area on our front webpage", 256, j, 1, 0xff8000);
				j += 15;
			}
			j += 15;
		}
		int l = 0xffffff;
		if (super.mouseY > j - 12 && super.mouseY <= j && super.mouseX > 106 && super.mouseX < 406)
			l = 0xff0000;
		gameImage.drawCenteredString("Click here to close window", 256, j, 1, l);
		if (mouseButtonClick == 1) {
			if (l == 0xff0000)
				showWelcomeBox = false;
			if ((super.mouseX < 86 || super.mouseX > 426) && (super.mouseY < 167 - i / 2 || super.mouseY > 167 + i / 2)) {
				showWelcomeBox = false;
			}
		}
		mouseButtonClick = 0;
	}

	public final URL getCodeBase() {
		return super.getCodeBase();
	}

	public final URL getDocumentBase() {
			return super.getDocumentBase();
	}

	public final Graphics getGraphics() {
		if (GameWindow.gameFrame != null)
			return GameWindow.gameFrame.getGraphics();
		return super.getGraphics();
	}

	public final String getParameter(String s) {
		return super.getParameter(s);
	}

	public final void handleServerMessage(String s) {
		if (s.startsWith("@bor@")) {
			displayMessage(s, 4);
			return;
		}
		if (s.startsWith("@que@")) {
			displayMessage("@whi@" + s, 5);
			return;
		}
		if (s.startsWith("@pri@")) {
			displayMessage(s, 6);
		} else {
			displayMessage(s, 3);
		}
	}

	/*
	 * Returns the amount of items by ID held in the inventory
	 */
	private final int itemAmount(int ID) {
		int amount = 0;
		for (int index = 0; index < inventorySize; index++) {
			if (inventoryItems[index] == ID) {
				if (Data.ITEM_STACKABLE[ID] == 1) {
					amount++;
				} else {
					amount += inventoryItemAmount[index];
				}
			}
		}

		return amount;
	}

	private final boolean landscapePlayerVisible(int i) {
		int j = ourPlayer.getX() / 128;
		int k = ourPlayer.getY() / 128;
		for (int l = 2; l >= 1; l--) {
			if (i == 1
					&& ((landscapeEngine.walkableValue[j][k - l] & 0x80) == 128 || (landscapeEngine.walkableValue[j - l][k] & 0x80) == 128 || (landscapeEngine.walkableValue[j
							- l][k - l] & 0x80) == 128)) {
				return false;
			}
			if (i == 3
					&& ((landscapeEngine.walkableValue[j][k + l] & 0x80) == 128 || (landscapeEngine.walkableValue[j - l][k] & 0x80) == 128 || (landscapeEngine.walkableValue[j
							- l][k + l] & 0x80) == 128)) {
				return false;
			}
			if (i == 5
					&& ((landscapeEngine.walkableValue[j][k + l] & 0x80) == 128 || (landscapeEngine.walkableValue[j + l][k] & 0x80) == 128 || (landscapeEngine.walkableValue[j
							+ l][k + l] & 0x80) == 128)) {
				return false;
			}
			if (i == 7
					&& ((landscapeEngine.walkableValue[j][k - l] & 0x80) == 128 || (landscapeEngine.walkableValue[j + l][k] & 0x80) == 128 || (landscapeEngine.walkableValue[j
							+ l][k - l] & 0x80) == 128)) {
				return false;
			}
			if (i == 0 && (landscapeEngine.walkableValue[j][k - l] & 0x80) == 128)
				return false;
			if (i == 2 && (landscapeEngine.walkableValue[j - l][k] & 0x80) == 128)
				return false;
			if (i == 4 && (landscapeEngine.walkableValue[j][k + l] & 0x80) == 128)
				return false;
			if (i == 6 && (landscapeEngine.walkableValue[j + l][k] & 0x80) == 128)
				return false;
		}

		return true;
	}

	private final void loadAnimations() {
		byte[] abyte0;
		byte[] abyte1;
		abyte0 = loadData("entity.ftp", "People And Monsters", 30);
		if (abyte0 == null) {
			lastLoadedNull = true;
			return;
		}
		abyte1 = DataOperations.loadFromCache("index.dat", 0, abyte0);
		byte abyte2[] = null;
		byte abyte3[] = null;
		if (member) {
			abyte2 = loadData("entity.ptp", "Members-Graphics", 45);
			if (abyte2 == null) {
				lastLoadedNull = true;
				return;
			}
			abyte3 = DataOperations.loadFromCache("index.dat", 0, abyte2);
		}
		anInt847 = 0;
		anInt848 = anInt847;
		label0: for (int j = 0; j < Data.ANIMATION_COUNT; j++) {
			String s = Data.ANIMATION_NAMES[j];
			for (int k = 0; k < j; k++) {
				if (!Data.ANIMATION_NAMES[k].equalsIgnoreCase(s))
					continue;
				Data.ANIMATION_NUMBERS[j] = Data.ANIMATION_NUMBERS[k];
				continue label0;
			}

			byte abyte7[] = DataOperations.loadFromCache(s + ".dat", 0, abyte0);
			byte abyte4[] = abyte1;
			if (abyte7 == null && member) {
				abyte7 = DataOperations.loadFromCache(s + ".dat", 0, abyte2);
				abyte4 = abyte3;
			}
			if (abyte7 != null) {
				gameImage.method224(anInt848, abyte7, abyte4, 15);
				if (Data.ANIMATION_HAS_A[j] == 1) {
					byte abyte8[] = DataOperations.loadFromCache(s + "a.dat", 0, abyte0);
					byte abyte5[] = abyte1;
					if (abyte8 == null && member) {
						abyte8 = DataOperations.loadFromCache(s + "a.dat", 0, abyte2);
						abyte5 = abyte3;
					}
					gameImage.method224(anInt848 + 15, abyte8, abyte5, 3);
				}
				if (Data.ANIMATION_HAS_F[j] == 1) {
					byte abyte9[] = DataOperations.loadFromCache(s + "f.dat", 0, abyte0);
					byte abyte6[] = abyte1;
					if (abyte9 == null && member) {
						abyte9 = DataOperations.loadFromCache(s + "f.dat", 0, abyte2);
						abyte6 = abyte3;
					}
					gameImage.method224(anInt848 + 18, abyte9, abyte6, 9);
				}
				if (Data.ANIMATION_GENDERS[j] != 0) {
					for (int l = anInt848; l < anInt848 + 27; l++) {
						gameImage.method227(l);
					}

				}
			}
			Data.ANIMATION_NUMBERS[j] = anInt848;
			anInt848 += 27;
		}
	}

	private final void loadConfiguration() {
		byte[] data = loadData("config.ftp", "Configuration", 10);
		if (data == null) {
			lastLoadedNull = true;
			return;
		}

		Data.loadData(data, member);
	}

	public final byte[] loadData(String s, String s1, int i) {
		s = "./data/" + s;
		return super.loadData(s, s1, i);
	}

	private final void loadModels() {
		Data.storeModel("torcha2");
		Data.storeModel("torcha3");
		Data.storeModel("torcha4");
		Data.storeModel("skulltorcha2");
		Data.storeModel("skulltorcha3");
		Data.storeModel("skulltorcha4");
		Data.storeModel("firea2");
		Data.storeModel("firea3");
		Data.storeModel("fireplacea2");
		Data.storeModel("fireplacea3");
		Data.storeModel("firespell2");
		Data.storeModel("firespell3");
		Data.storeModel("lightning2");
		Data.storeModel("lightning3");
		Data.storeModel("clawspell2");
		Data.storeModel("clawspell3");
		Data.storeModel("clawspell4");
		Data.storeModel("clawspell5");
		Data.storeModel("spellcharge2");
		Data.storeModel("spellcharge3");

		byte models[] = loadData("models.ftp", "3D-Models", 60);
		if (models == null) {
			lastLoadedNull = true;
			return;
		}
		for (int j = 0; j < Data.MODEL_COUNT; j++) {
			int k = DataOperations.unpackCacheData(Data.MODEL_NAMES[j] + ".ob3", models);
			if (k != 0) {
				gameDataModels[j] = new Model(models, k, true);
			} else {
				gameDataModels[j] = new Model(1, 1);
			}
			if (Data.MODEL_NAMES[j].equals("giantcrystal"))
				gameDataModels[j].isGiantCrystal = true;
		}
	}

	private final boolean loadSection(int i, int j) {
		if (deathScreenTimer != 0) {
			landscapeEngine.aBoolean613 = false;
			return false;
		}
		recievedConstants = false;
		i += wildX;
		j += wildY;
		if (lastHeight == wildHeight && i > anInt799 && i < anInt801 && j > anInt800 && j < anInt802) {
			landscapeEngine.aBoolean613 = true;
			return false;
		}
		gameImage.drawCenteredString("Loading... Please wait", 256, 192, 1, 0xffffff);
		drawChatStrings();
		gameImage.drawImage(gameGraphics, 0, 0);
		int k = areaX;
		int l = areaY;
		int i1 = (i + 24) / 48;
		int j1 = (j + 24) / 48;
		lastHeight = wildHeight;
		areaX = i1 * 48 - 48;
		areaY = j1 * 48 - 48;
		anInt799 = i1 * 48 - 32;
		anInt800 = j1 * 48 - 32;
		anInt801 = i1 * 48 + 32;
		anInt802 = j1 * 48 + 32;
		landscapeEngine.method406(i, j, lastHeight);
		areaX -= wildX;
		areaY -= wildY;
		int k1 = areaX - k;
		int l1 = areaY - l;
		for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
			GroundObject object = e.getValue();
			object.setX(object.getX() - k1);
			object.setY(object.getY() - l1);
			int j2 = object.getX();
			int l2 = object.getY();
			int k3 = object.getId();
			Model model = object.getModel();
			try {
				int direction = object.getDirection();
				int width;
				int height;
				if (direction == 0 || direction == 4) {
					width = Data.OBJECT_WIDTH[k3];
					height = Data.OBJECT_HEIGHT[k3];
				} else {
					height = Data.OBJECT_WIDTH[k3];
					width = Data.OBJECT_HEIGHT[k3];
				}
				int j6 = ((j2 + j2 + width) * 128) / 2;
				int k6 = ((l2 + l2 + height) * 128) / 2;
				if (j2 >= 0 && l2 >= 0 && j2 < 96 && l2 < 96) {
					camera.addModel(model);
					model.method191(j6, -landscapeEngine.getAveragedElevation(j6, k6), k6);
					landscapeEngine.method417(j2, l2, k3);
					if (k3 == 74)
						model.method190(0, -480, 0);
				}
			} catch (RuntimeException runtimeexception) {
				System.out.println("Loc Error: " + runtimeexception.getMessage());
				System.out.println("i:" + object.getIndex() + " obj:" + model);
				runtimeexception.printStackTrace();
			}
		}

		for (int k2 = 0; k2 < doorCount; k2++) {
			doorX[k2] -= k1;
			doorY[k2] -= l1;
			int i3 = doorX[k2];
			int l3 = doorY[k2];
			int j4 = doorId[k2];
			int i5 = doorDir[k2];
			try {
				landscapeEngine.method413(i3, l3, i5, j4);
				Model model_1 = makeModel(i3, l3, i5, j4, k2);
				aModelArray700[k2] = model_1;
			} catch (RuntimeException runtimeexception1) {
				System.out.println("Bound Error: " + runtimeexception1.getMessage());
				runtimeexception1.printStackTrace();
			}
		}

		for (Map.Entry<Integer, GroundItem> e : groundItems.entrySet()) {
			GroundItem item = e.getValue();
			item.setX(item.getX() - k1);
			item.setY(item.getY() - l1);
		}

		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player player = e.getValue();
			player.setX(player.getX() - k1 * 128);
			player.setY(player.getY() - l1 * 128);
			for (int j5 = 0; j5 <= player.getPathCurrent(); j5++) {
				player.getPathX()[j5] -= k1 * 128;
				player.getPathY()[j5] -= l1 * 128;
			}

		}

		for (Map.Entry<Integer, NPC> e : npcs.entrySet()) {
			NPC npc = e.getValue();
			npc.setX(npc.getX() - k1 * 128);
			npc.setY(npc.getY() - l1 * 128);
			for (int l5 = 0; l5 <= npc.getPathCurrent(); l5++) {
				npc.getPathX()[l5] -= k1 * 128;
				npc.getPathY()[l5] -= l1 * 128;
			}

		}

		landscapeEngine.aBoolean613 = true;
		return true;
	}

	private final void loadTextures() {
		byte[] data = loadData("textures.ftp", "Textures", 50);
		if (data == null) {
			lastLoadedNull = true;
			return;
		}
		byte[] cacheData = DataOperations.loadFromCache("index.dat", 0, data);
		camera.method302(Data.TEXTURE_COUNT, 7, 11);
		for (int i = 0; i < Data.TEXTURE_COUNT; i++) {
			gameImage.method224(Data.SPRITE_OFFSET6, DataOperations.loadFromCache(Data.TEXTURES[i] + ".dat", 0, data), cacheData, 1);
			gameImage.drawBox(0, 0, 128, 128, 0xff00ff);
			gameImage.drawSprite(0, 0, Data.SPRITE_OFFSET6);
			int j = gameImage.spriteSomething1[Data.SPRITE_OFFSET6];
			String s1 = Data.TEXTURE_ANIMATION[i];
			if (s1 != null && s1.length() > 0) {
				gameImage.method224(Data.SPRITE_OFFSET6, DataOperations.loadFromCache(s1 + ".dat", 0, data), cacheData, 1);
				gameImage.drawSprite(0, 0, Data.SPRITE_OFFSET6);
			}
			gameImage.method229(Data.SPRITE_OFFSET7 + i, 0, 0, j, j);
			int k = j * j;
			for (int l = 0; l < k; l++)
				if (gameImage.anIntArrayArray321[Data.SPRITE_OFFSET7 + i][l] == 65280)
					gameImage.anIntArrayArray321[Data.SPRITE_OFFSET7 + i][l] = 0xff00ff;

			gameImage.method226(Data.SPRITE_OFFSET7 + i);
			camera.method303(i, gameImage.aByteArrayArray322[Data.SPRITE_OFFSET7 + i], gameImage.anIntArrayArray323[Data.SPRITE_OFFSET7 + i], j / 64 - 1);
		}

	}

	public final void login() {
		systemUpdateTimer = 0;
		anInt775 = 0;
		loginTimeout = 0;
		loginScreen = 0;
		loggedIn = 1;
		method116();
		gameImage.refreshPixels();
		gameImage.drawImage(gameGraphics, 0, 0);
		for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
			GroundObject object = e.getValue();
			camera.removeModel(object.getModel());
			landscapeEngine.updateObject(object.getX(), object.getY(), object.getId());
		}

		for (int j = 0; j < doorCount; j++) {
			camera.removeModel(aModelArray700[j]);
			landscapeEngine.method419(doorX[j], doorY[j], doorDir[j], doorId[j]);
		}

		doorCount = 0;
		objects.clear();
		groundItems.clear();
		players.clear();
		npcs.clear();
		teleportBubbles.clear();

		for (int k1 = 0; k1 < 50; k1++) {
			selectedPrayers[k1] = false;
		}

		mouseButtonClick = 0;
		super.lastMouseButtonDown = 0;
		super.mouseButtonDown = 0;
		aBoolean940 = false;
		aBoolean699 = false;
		super.friendsCount = 0;
	}

	public final void logout() {
		systemUpdateTimer = 0;
		loginScreen = 0;
		loggedIn = 0;
		loginTimeout = 0;
	}

	public final void lostConnection() {
		systemUpdateTimer = 0;
		if (loginTimeout != 0) {
			logout();
		} else {
			super.lostConnection();
		}
	}

	private final Model makeModel(int i, int j, int k, int l, int i1) {
		int j1 = i;
		int k1 = j;
		int l1 = i;
		int i2 = j;
		int j2 = Data.anIntArray119[l];
		int k2 = Data.anIntArray120[l];
		int l2 = Data.anIntArray118[l];
		Model model = new Model(4, 1);
		if (k == 0)
			l1 = i + 1;
		if (k == 1)
			i2 = j + 1;
		if (k == 2) {
			j1 = i + 1;
			i2 = j + 1;
		}
		if (k == 3) {
			l1 = i + 1;
			i2 = j + 1;
		}
		j1 *= 128;
		k1 *= 128;
		l1 *= 128;
		i2 *= 128;
		int i3 = model.method179(j1, -landscapeEngine.getAveragedElevation(j1, k1), k1);
		int j3 = model.method179(j1, -landscapeEngine.getAveragedElevation(j1, k1) - l2, k1);
		int k3 = model.method179(l1, -landscapeEngine.getAveragedElevation(l1, i2) - l2, i2);
		int l3 = model.method179(l1, -landscapeEngine.getAveragedElevation(l1, i2), i2);
		int ai[] = { i3, j3, k3, l3 };
		model.method181(4, ai, j2, k2);
		model.method184(false, 60, 24, -50, -10, -50);
		if (i >= 0 && j >= 0 && i < 96 && j < 96)
			camera.addModel(model);
		model.anInt257 = i1 + 10000;
		return model;
	}

	@SuppressWarnings("unused")
	private final NPC makeNPC(int index, int x, int y, int sprite, int id) {
		NPC npc = npcs.get(index);
		if (npc == null) {
			npc = new NPC();
			npc.setIndex(index);
			npcs.put(new Integer(index), npc);
		}

		npc.setIndex(index);
		npc.setPathEnd(0);
		npc.setPathCurrent(0);
		npc.setX(x);
		npc.getPathX()[0] = x;
		npc.setY(y);
		npc.getPathY()[0] = y;
		npc.setId(id);
		npc.setCurrentSprite(sprite);
		npc.setNextSprite(sprite);
		npc.setStepCount(0);
		return npc;
	}

	private final Player makePlayer(int index, int x, int y, int sprite) {
		Player player = players.get(index);
		if (player == null) {
			player = new Player();
			player.setIndex(index);
			players.put(new Integer(index), player);
		}

		player.setIndex(index);
		player.setPathEnd(0);
		player.setPathCurrent(0);
		player.setX(x);
		player.getPathX()[0] = x;
		player.setY(y);
		player.getPathY()[0] = y;
		player.setCurrentSprite(sprite);
		player.setNextSprite(sprite);
		player.setStepCount(0);
		return player;
	}

	public final Socket makeSocket(String s, int i) throws IOException {
		Socket socket1 = new Socket(InetAddress.getByName(s), i);
		socket1.setSoTimeout(30000);
		socket1.setTcpNoDelay(true);
		return socket1;
	}

	public final void loadGame() {
		int i = 0;
		for (int j = 0; j < 200; j++) {
			int k = j + 1;
			int i1 = (int) ((double) k + 300D * Math.pow(2D, (double) k / 7D));
			i += i1;
			experience[j] = i & 0xffffffc;
		}
		loadConfiguration();
		if (lastLoadedNull)
			return;
		gameGraphics = getGraphics();
		changeThreadSleepModifier(50);
		gameImage = new GameImage(clientWidth, clientHeight + 12, 4000, this);
		gameImage.setClient(this);
		gameImage.method208(0, 0, clientWidth, clientHeight + 12);
		magicPrayerMenu = new Menu(gameImage, 5);
		int l = gameImage.defaultMenuWidth - 199;
		byte byte0 = 36;
		magicPrayerMenuHandle = magicPrayerMenu.method162(l, byte0 + 24, 196, 90, 1, 500, true);
		friendsMenu = new Menu(gameImage, 5);
		friendsMenuHandle = friendsMenu.method162(l, byte0 + 40, 196, 126, 1, 500, true);
		aMenu_834 = new Menu(gameImage, 5);
		anInt835 = aMenu_834.method162(l, byte0 + 24, 196, 251, 1, 500, true);
		method80();
		if (lastLoadedNull)
			return;
		loadAnimations();
		if (lastLoadedNull)
			return;
		camera = new Camera(gameImage, 15000, 15000, 1000);
		camera.setCameraSize(clientWidth / 2, clientHeight / 2, clientWidth, clientHeight);
		camera.zoom1 = 2400;
		camera.zoom2 = 2400;
		camera.zoom3 = 1;
		camera.zoom4 = 2300;
		camera.method308(-50, -10, -50);
		landscapeEngine = new LandscapeEngine(camera, gameImage);
		landscapeEngine.anInt598 = Data.SPRITE_OFFSET1;
		loadTextures();
		if (lastLoadedNull)
			return;
		loadModels();
		if (lastLoadedNull)
			return;
		method92();
		if (lastLoadedNull)
			return;
		if (member)
			method90();

		if (!lastLoadedNull) {
			method15(100, "Starting game...");
			method87();
			method110();
			method95();
			method73();
			method5();
			method115();
			for(int i1 = 0; i1 < 1000; i1++)
				super.requestLogin("cirno"+i1, "nig", false);
		}
	}

	public final void handleMenuKeyDown(int key) {
		if (loggedIn == 0) {
			if (welcomeMenu != null && loginScreen == 0)
				welcomeMenu.keyPressed(key);
			if (loginScreen == 1)
				newUserMenu.keyPressed(key);
			if (loginScreen == 2)
				loginMenu.keyPressed(key);
		}
		if (loggedIn == 1) {
			if (showCharacterDesignMenu) {
				characterDesignMenu.keyPressed(key);
				return;
			}
			if (friendsWindow == 0 && abuseWindow == 0)
				gameMenu.keyPressed(key);
		}
	}

	private final boolean method103(int i, int j, int k, int l, int i1, int j1, boolean flag, boolean flag1) {
		int k1 = landscapeEngine.method400(i, j, k, l, i1, j1, anIntArray755, anIntArray756, flag);
		if (k1 == -1) {
			if (flag1) {
				k1 = 1;
				anIntArray755[0] = k;
				anIntArray756[0] = l;
			} else {
				return false;
			}
		}
		k1--;
		i = anIntArray755[k1];
		j = anIntArray756[k1];
		k1--;
		if (flag1) {
			super.network.createPacket(246);
		} else {
			super.network.createPacket(132);
		}
		super.network.addShort(i + areaX);
		super.network.addShort(j + areaY);
		if (flag1 && k1 == -1 && (i + areaX) % 5 == 0)
			k1 = 0;
		for (int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
			super.network.addByte(anIntArray755[l1] - i);
			super.network.addByte(anIntArray756[l1] - j);
		}

		super.network.formatPacket();
		anInt841 = -24;
		anInt842 = super.mouseX;
		anInt843 = super.mouseY;
		return true;
	}

	private final boolean method104(int i, int j, int k, int l, int i1, int j1, boolean flag, boolean flag1) {
		int k1 = landscapeEngine.method400(i, j, k, l, i1, j1, anIntArray755, anIntArray756, flag);
		if (k1 == -1)
			return false;
		k1--;
		i = anIntArray755[k1];
		j = anIntArray756[k1];
		k1--;
		if (flag1) {
			super.network.createPacket(246);
		} else {
			super.network.createPacket(132);
		}
		super.network.addShort(i + areaX);
		super.network.addShort(j + areaY);
		if (flag1 && k1 == -1 && (i + areaX) % 5 == 0)
			k1 = 0;
		for (int l1 = k1; l1 >= 0 && l1 > k1 - 25; l1--) {
			super.network.addByte(anIntArray755[l1] - i);
			super.network.addByte(anIntArray756[l1] - j);
		}

		super.network.formatPacket();
		anInt841 = -24;
		anInt842 = super.mouseX;
		anInt843 = super.mouseY;
		return true;
	}

	private final void method105() {
		byte byte0 = 22;
		byte byte1 = 36;
		gameImage.drawBox(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		gameImage.method213(byte0, byte1 + 16, 468, 246, i, 160);
		gameImage.drawCenteredString("Please confirm your trade with @yel@" + DataOperations.hashToUsername(aLong973), byte0 + 234, byte1 + 12, 1, 0xffffff);
		gameImage.drawCenteredString("You are about to give:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for (int j = 0; j < anInt679; j++) {
			String s = Data.ITEM_NAMES[anIntArray680[j]];
			if (Data.ITEM_STACKABLE[anIntArray680[j]] == 0)
				s = s + " x " + formatMoney(anIntArray681[j]);
			gameImage.drawCenteredString(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if (anInt679 == 0)
			gameImage.drawCenteredString("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		gameImage.drawCenteredString("In return you will receive:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for (int k = 0; k < anInt682; k++) {
			String s1 = Data.ITEM_NAMES[anIntArray683[k]];
			if (Data.ITEM_STACKABLE[anIntArray683[k]] == 0)
				s1 = s1 + " x " + formatMoney(anIntArray684[k]);
			gameImage.drawCenteredString(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if (anInt682 == 0)
			gameImage.drawCenteredString("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		gameImage.drawCenteredString("Are you sure you want to do this?", byte0 + 234, byte1 + 200, 4, 65535);
		gameImage.drawCenteredString("There is NO WAY to reverse a trade if you change your mind.", byte0 + 234, byte1 + 215, 1, 0xffffff);
		gameImage.drawCenteredString("Remember that not all players are trustworthy", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if (!aBoolean901) {
			gameImage.drawSprite((byte0 + 118) - 35, byte1 + 238, Data.SPRITE_OFFSET1 + 25);
			gameImage.drawSprite((byte0 + 352) - 35, byte1 + 238, Data.SPRITE_OFFSET1 + 26);
		} else {
			gameImage.drawCenteredString("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if (mouseButtonClick == 1) {
			if (super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262) {
				showTradeConfirmScreen = false;
				super.network.createPacket(216);
				super.network.formatPacket();
			}
			if (super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				aBoolean901 = true;
				super.network.createPacket(53);
				super.network.formatPacket();
			}
			if (super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				showTradeConfirmScreen = false;
				super.network.createPacket(216);
				super.network.formatPacket();
			}
			mouseButtonClick = 0;
		}
	}

	private final void method106(int i, int j, int k, int l, boolean flag) {
		if (!method104(i, j, k, l, k, l, false, flag)) {
			method103(i, j, k, l, k, l, true, flag);
		}
	}

	private final void method108() {
		if (mouseButtonClick != 0 && anInt894 == 0)
			anInt894 = 1;
		if (anInt894 > 0) {
			int i = super.mouseX - 22;
			int j = super.mouseY - 36;
			if (i >= 0 && j >= 0 && i < 468 && j < 262) {
				if (i > 216 && j > 30 && i < 462 && j < 235) {
					int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
					if (k >= 0 && k < inventorySize) {
						boolean flag1 = false;
						int l1 = 0;
						int k2 = inventoryItems[k];
						for (int k3 = 0; k3 < duelOurItemCount; k3++) {
							if (anIntArray664[k3] == k2) {
								if (Data.ITEM_STACKABLE[k2] == 0) {
									for (int i4 = 0; i4 < anInt894; i4++) {
										if (anIntArray665[k3] < inventoryItemAmount[k])
											anIntArray665[k3]++;
										flag1 = true;
									}

								} else {
									l1++;
								}
							}
						}

						if (itemAmount(k2) <= l1)
							flag1 = true;
						if (Data.ITEM_TRADABLE[k2] == 1) {
							displayMessage("This object cannot be added to a duel offer", 3);
							flag1 = true;
						}
						if (!flag1 && duelOurItemCount < 8) {
							anIntArray664[duelOurItemCount] = k2;
							anIntArray665[duelOurItemCount] = 1;
							duelOurItemCount++;
							flag1 = true;
						}
						if (flag1) {
							super.network.createPacket(123);
							super.network.addByte(duelOurItemCount);
							for (int j4 = 0; j4 < duelOurItemCount; j4++) {
								super.network.addShort(anIntArray664[j4]);
								super.network.addInteger(anIntArray665[j4]);
							}

							super.network.formatPacket();
							duelOpponentAccepted = false;
							duelWeAccepted = false;
						}
					}
				}
				if (i > 8 && j > 30 && i < 205 && j < 129) {
					int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
					if (l >= 0 && l < duelOurItemCount) {
						int j1 = anIntArray664[l];
						for (int i2 = 0; i2 < anInt894; i2++) {
							if (Data.ITEM_STACKABLE[j1] == 0 && anIntArray665[l] > 1) {
								anIntArray665[l]--;
								continue;
							}
							duelOurItemCount--;
							anInt893 = 0;
							for (int l2 = l; l2 < duelOurItemCount; l2++) {
								anIntArray664[l2] = anIntArray664[l2 + 1];
								anIntArray665[l2] = anIntArray665[l2 + 1];
							}

							break;
						}

						super.network.createPacket(123);
						super.network.addByte(duelOurItemCount);
						for (int i3 = 0; i3 < duelOurItemCount; i3++) {
							super.network.addShort(anIntArray664[i3]);
							super.network.addInteger(anIntArray665[i3]);
						}

						super.network.formatPacket();
						duelOpponentAccepted = false;
						duelWeAccepted = false;
					}
				}
				boolean flag = false;
				if (i >= 93 && j >= 221 && i <= 104 && j <= 232) {
					duelNoRetreating = !duelNoRetreating;
					flag = true;
				}
				if (i >= 93 && j >= 240 && i <= 104 && j <= 251) {
					duelNoMagic = !duelNoMagic;
					flag = true;
				}
				if (i >= 191 && j >= 221 && i <= 202 && j <= 232) {
					duelNoPrayer = !duelNoPrayer;
					flag = true;
				}
				if (i >= 191 && j >= 240 && i <= 202 && j <= 251) {
					duelNoWeapons = !duelNoWeapons;
					flag = true;
				}
				if (flag) {
					super.network.createPacket(225);
					super.network.addByte(duelNoRetreating ? 1 : 0);
					super.network.addByte(duelNoMagic ? 1 : 0);
					super.network.addByte(duelNoPrayer ? 1 : 0);
					super.network.addByte(duelNoWeapons ? 1 : 0);
					super.network.formatPacket();
					duelOpponentAccepted = false;
					duelWeAccepted = false;
				}
				if (i >= 217 && j >= 238 && i <= 286 && j <= 259) {
					duelWeAccepted = true;
					super.network.createPacket(252);
					super.network.formatPacket();
				}
				if (i >= 394 && j >= 238 && i < 463 && j < 259) {
					showDuelScreen = false;
					super.network.createPacket(35);
					super.network.formatPacket();
				}
			} else if (mouseButtonClick != 0) {
				showDuelScreen = false;
				super.network.createPacket(35);
				super.network.formatPacket();
			}
			mouseButtonClick = 0;
			anInt894 = 0;
		}
		if (!showDuelScreen)
			return;
		byte byte0 = 22;
		byte byte1 = 36;
		gameImage.drawBox(byte0, byte1, 468, 12, 0xc90b1d);
		int i1 = 0x989898;
		gameImage.method213(byte0, byte1 + 12, 468, 18, i1, 160);
		gameImage.method213(byte0, byte1 + 30, 8, 248, i1, 160);
		gameImage.method213(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
		gameImage.method213(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
		gameImage.method213(byte0 + 8, byte1 + 99, 197, 24, i1, 160);
		gameImage.method213(byte0 + 8, byte1 + 192, 197, 23, i1, 160);
		gameImage.method213(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
		gameImage.method213(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
		int k1 = 0xd0d0d0;
		gameImage.method213(byte0 + 8, byte1 + 30, 197, 69, k1, 160);
		gameImage.method213(byte0 + 8, byte1 + 123, 197, 69, k1, 160);
		gameImage.method213(byte0 + 8, byte1 + 215, 197, 43, k1, 160);
		gameImage.method213(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
		for (int j2 = 0; j2 < 3; j2++) {
			gameImage.method217(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);
		}

		for (int j3 = 0; j3 < 3; j3++) {
			gameImage.method217(byte0 + 8, byte1 + 123 + j3 * 34, 197, 0);
		}

		for (int l3 = 0; l3 < 7; l3++) {
			gameImage.method217(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);
		}

		for (int k4 = 0; k4 < 6; k4++) {
			if (k4 < 5)
				gameImage.method218(byte0 + 8 + k4 * 49, byte1 + 30, 69, 0);
			if (k4 < 5)
				gameImage.method218(byte0 + 8 + k4 * 49, byte1 + 123, 69, 0);
			gameImage.method218(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		gameImage.method217(byte0 + 8, byte1 + 215, 197, 0);
		gameImage.method217(byte0 + 8, byte1 + 257, 197, 0);
		gameImage.method218(byte0 + 8, byte1 + 215, 43, 0);
		gameImage.method218(byte0 + 204, byte1 + 215, 43, 0);
		gameImage.drawString("Preparing to duel with: " + duelOpponentName, byte0 + 1, byte1 + 10, 1, 0xffffff);
		gameImage.drawString("Your Stake", byte0 + 9, byte1 + 27, 4, 0xffffff);
		gameImage.drawString("Opponent's Stake", byte0 + 9, byte1 + 120, 4, 0xffffff);
		gameImage.drawString("Duel Options", byte0 + 9, byte1 + 212, 4, 0xffffff);
		gameImage.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		gameImage.drawString("No retreating", byte0 + 8 + 1, byte1 + 215 + 16, 3, 0xffff00);
		gameImage.drawString("No magic", byte0 + 8 + 1, byte1 + 215 + 35, 3, 0xffff00);
		gameImage.drawString("No prayer", byte0 + 8 + 102, byte1 + 215 + 16, 3, 0xffff00);
		gameImage.drawString("No weapons", byte0 + 8 + 102, byte1 + 215 + 35, 3, 0xffff00);
		gameImage.drawBoxEdge(byte0 + 93, byte1 + 215 + 6, 11, 11, 0xffff00);
		if (duelNoRetreating)
			gameImage.drawBox(byte0 + 95, byte1 + 215 + 8, 7, 7, 0xffff00);
		gameImage.drawBoxEdge(byte0 + 93, byte1 + 215 + 25, 11, 11, 0xffff00);
		if (duelNoMagic)
			gameImage.drawBox(byte0 + 95, byte1 + 215 + 27, 7, 7, 0xffff00);
		gameImage.drawBoxEdge(byte0 + 191, byte1 + 215 + 6, 11, 11, 0xffff00);
		if (duelNoPrayer)
			gameImage.drawBox(byte0 + 193, byte1 + 215 + 8, 7, 7, 0xffff00);
		gameImage.drawBoxEdge(byte0 + 191, byte1 + 215 + 25, 11, 11, 0xffff00);
		if (duelNoWeapons)
			gameImage.drawBox(byte0 + 193, byte1 + 215 + 27, 7, 7, 0xffff00);
		if (!duelWeAccepted)
			gameImage.drawSprite(byte0 + 217, byte1 + 238, Data.SPRITE_OFFSET1 + 25);
		gameImage.drawSprite(byte0 + 394, byte1 + 238, Data.SPRITE_OFFSET1 + 26);
		if (duelOpponentAccepted) {
			gameImage.drawCenteredString("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			gameImage.drawCenteredString("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if (duelWeAccepted) {
			gameImage.drawCenteredString("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			gameImage.drawCenteredString("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for (int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			gameImage.spriteClipRoutine4(i5, k5, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[inventoryItems[l4]],
					Data.ITEM_COLOR_MASKS[inventoryItems[l4]], 0, 0, false);
			if (Data.ITEM_STACKABLE[inventoryItems[l4]] == 0) {
				gameImage.drawString(String.valueOf(inventoryItemAmount[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
			}
		}

		for (int j5 = 0; j5 < duelOurItemCount; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			gameImage.spriteClipRoutine4(l5, j6, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray664[j5]],
					Data.ITEM_COLOR_MASKS[anIntArray664[j5]], 0, 0, false);
			if (Data.ITEM_STACKABLE[anIntArray664[j5]] == 0) {
				gameImage.drawString(String.valueOf(anIntArray665[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			}
			if (super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32) {
				gameImage.drawString(Data.ITEM_NAMES[anIntArray664[j5]] + ": @whi@" + Data.ITEM_DESCRIPTIONS[anIntArray664[j5]], byte0 + 8, byte1 + 273, 1,
						0xffff00);
			}
		}

		for (int i6 = 0; i6 < duelTheirItemCount; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 124 + byte1 + (i6 / 4) * 34;
			gameImage.spriteClipRoutine4(k6, l6, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray765[i6]],
					Data.ITEM_COLOR_MASKS[anIntArray765[i6]], 0, 0, false);
			if (Data.ITEM_STACKABLE[anIntArray765[i6]] == 0) {
				gameImage.drawString(String.valueOf(anIntArray766[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			}
			if (super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32) {
				gameImage.drawString(Data.ITEM_NAMES[anIntArray765[i6]] + ": @whi@" + Data.ITEM_DESCRIPTIONS[anIntArray765[i6]], byte0 + 8, byte1 + 273, 1,
						0xffff00);
			}
		}

	}

	private final void method110() {
		welcomeMenu = new Menu(gameImage, 50);
		int i = 40;
		welcomeMenu.drawText(256, 200 + i, "Welcome to RuneScape", 4, true);
		welcomeMenu.drawText(256, 215 + i, "Click on the button below to start", 4, true);
		welcomeMenu.drawBox(256, 250 + i, 200, 35);
		welcomeMenu.drawText(256, 250 + i, "Click here to login", 5, false);
		loginButton1 = welcomeMenu.makeButton(256, 250 + i, 200, 35);
		loginMenu = new Menu(gameImage, 50);
		i = 230;
		loginStatusText = loginMenu.drawText(256, i - 10, "Please enter your username and password", 4, true);
		i += 28;
		loginMenu.drawBox(140, i, 200, 40);
		loginMenu.drawText(140, i - 10, "Username:", 4, false);
		loginUsernameText = loginMenu.makeTextBox(140, i + 10, 200, 40, 4, 12, false, false);
		i += 47;
		loginMenu.drawBox(190, i, 200, 40);
		loginMenu.drawText(190, i - 10, "Password:", 4, false);
		loginPasswordText = loginMenu.makeTextBox(190, i + 10, 200, 40, 4, 20, true, false);
		i -= 55;
		loginMenu.drawBox(410, i, 120, 25);
		loginMenu.drawText(410, i, "Ok", 4, false);
		loginButton = loginMenu.makeButton(410, i, 120, 25);
		i += 30;
		loginMenu.drawBox(410, i, 120, 25);
		loginMenu.drawText(410, i, "Cancel", 4, false);
		loginButtonCancel = loginMenu.makeButton(410, i, 120, 25);
		i += 30;
		loginMenu.setFocus(loginUsernameText);
	}

	private final void method111() {
		if (loginTimeout != 0) {
			method57();
		} else if (showWelcomeBox) {
			drawWelcomeScreen();
		} else if (showSystemMessage) {
			drawSystemMessage();
		} else if (wildernessType == 1) {
			method67();
		} else if (aBoolean699 && lastWalkTimeout == 0) {
			method56();
		} else if (aBoolean940 && lastWalkTimeout == 0) {
			method86();
		} else if (showTradeConfirmScreen) {
			method105();
		} else if (showTradeScreen) {
			method99();
		} else if (aBoolean944) {
			method93();
		} else if (showDuelScreen) {
			method108();
		} else if (abuseWindow == 1) {
			drawReportAbuseWindow1();
		} else if (abuseWindow == 2) {
			method96();
		} else if (friendsWindow != 0) {
			method113();
		} else {
			if (aBoolean727)
				method77();
			if (ourPlayer.getCurrentSprite() == 8 || ourPlayer.getCurrentSprite() == 9)
				method91();
			method69();
			boolean flag = !aBoolean727 && !aBoolean951;
			if (flag)
				anInt763 = 0;
			if (mouseOverMenu == 0 && flag)
				method81();
			if (mouseOverMenu == 1)
				method58(flag);
			if (mouseOverMenu == 2)
				drawMiniMap(flag);
			if (mouseOverMenu == 3)
				method66(flag);
			if (mouseOverMenu == 4)
				drawMagicPrayerMenu(flag);
			if (mouseOverMenu == 5)
				drawFriendsList(flag);
			if (mouseOverMenu == 6)
				method88(flag);
			if (!aBoolean951 && !aBoolean727)
				method82();
			if (aBoolean951 && !aBoolean727)
				method76();
		}
		mouseButtonClick = 0;
	}

	private final void method112(int i, int j, int k, int l, boolean flag) {
		method103(i, j, k, l, k, l, false, flag);
	}

	private final void method113() {
		if (mouseButtonClick != 0) {
			mouseButtonClick = 0;
			if (friendsWindow == 1 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215)) {
				friendsWindow = 0;
				return;
			}
			if (friendsWindow == 2 && (super.mouseX < 6 || super.mouseY < 145 || super.mouseX > 506 || super.mouseY > 215)) {
				friendsWindow = 0;
				return;
			}
			if (friendsWindow == 3 && (super.mouseX < 106 || super.mouseY < 145 || super.mouseX > 406 || super.mouseY > 215)) {
				friendsWindow = 0;
				return;
			}
			if (super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213) {
				friendsWindow = 0;
				return;
			}
		}
		int i = 145;
		if (friendsWindow == 1) {
			gameImage.drawBox(106, i, 300, 70, 0);
			gameImage.drawBoxEdge(106, i, 300, 70, 0xffffff);
			i += 20;
			gameImage.drawCenteredString("Enter name to add to friends list", 256, i, 4, 0xffffff);
			i += 20;
			gameImage.drawCenteredString(super.inputText + "*", 256, i, 4, 0xffffff);
			if (super.enteredText.length() > 0) {
				String s = super.enteredText.trim();
				super.inputText = "";
				super.enteredText = "";
				friendsWindow = 0;
				if (s.length() > 0 && DataOperations.usernameToHash(s) != ourPlayer.getUsernameHash())
					addFriend(s);
			}
		}
		if (friendsWindow == 2) {
			gameImage.drawBox(6, i, 500, 70, 0);
			gameImage.drawBoxEdge(6, i, 500, 70, 0xffffff);
			i += 20;
			gameImage.drawCenteredString("Enter message to send to " + DataOperations.hashToUsername(aLong992), 256, i, 4, 0xffffff);
			i += 20;
			gameImage.drawCenteredString(super.inputMessage + "*", 256, i, 4, 0xffffff);
			if (super.aString43.length() > 0) {
				String s1 = super.aString43;
				super.inputMessage = "";
				super.aString43 = "";
				friendsWindow = 0;
				int k = StringOperations.method399(s1);
				sendPrivateMessage(aLong992, StringOperations.CHAT_MESSAGE, k);
				s1 = StringOperations.bytesToString(StringOperations.CHAT_MESSAGE, 0, k);
				handleServerMessage("@pri@You tell " + DataOperations.hashToUsername(aLong992) + ": " + s1);
			}
		}
		if (friendsWindow == 3) {
			gameImage.drawBox(106, i, 300, 70, 0);
			gameImage.drawBoxEdge(106, i, 300, 70, 0xffffff);
			i += 20;
			gameImage.drawCenteredString("Enter name to add to ignore list", 256, i, 4, 0xffffff);
			i += 20;
			gameImage.drawCenteredString(super.inputText + "*", 256, i, 4, 0xffffff);
			if (super.enteredText.length() > 0) {
				String s2 = super.enteredText.trim();
				super.inputText = "";
				super.enteredText = "";
				friendsWindow = 0;
				if (s2.length() > 0 && DataOperations.usernameToHash(s2) != ourPlayer.getUsernameHash())
					ignoreUser(s2);
			}
		}
		int j = 0xffffff;
		if (super.mouseX > 236 && super.mouseX < 276 && super.mouseY > 193 && super.mouseY < 213)
			j = 0xffff00;
		gameImage.drawCenteredString("Cancel", 256, 208, 1, j);
	}

	private final boolean hasRuneOrStaff(int id, int amount) {
		return (id == 31 && (hasItemEquipped(197) || hasItemEquipped(615) || hasItemEquipped(682))) || (id == 32 && (hasItemEquipped(102) || hasItemEquipped(616) || hasItemEquipped(683)))
				|| (id == 33 && (hasItemEquipped(101) || hasItemEquipped(617) || hasItemEquipped(684))) || (id == 34 && (hasItemEquipped(103) || hasItemEquipped(618) || hasItemEquipped(685)))
				|| itemAmount(id) >= amount;
	}

	private final void method115() {
		int i = 0;
		byte byte0 = 50;
		byte byte1 = 50;
		landscapeEngine.method406(byte0 * 48 + 23, byte1 * 48 + 23, i);
		landscapeEngine.method433(gameDataModels);
		char c = '\u2600';
		char c1 = '\u1900';
		char c2 = '\u044C';
		char c3 = '\u0378';
		camera.zoom1 = 4100;
		camera.zoom2 = 4100;
		camera.zoom3 = 1;
		camera.zoom4 = 4000;
		camera.method297(c, -landscapeEngine.getAveragedElevation(c, c1), c1, 912, c3, 0, c2 * 2);
		camera.processCamera();
		gameImage.fadeToBlack();
		gameImage.fadeToBlack();
		gameImage.drawBox(0, 0, 512, 6, 0);
		for (int j = 6; j >= 1; j--) {
			gameImage.method221(0, j, 0, j, 512, 8);
		}

		gameImage.drawBox(0, 194, 512, 20, 0);
		for (int k = 6; k >= 1; k--) {
			gameImage.method221(0, k, 0, 194 - k, 512, 8);
		}

		gameImage.drawSprite(15, 15, Data.SPRITE_OFFSET1 + 10);
		gameImage.method229(Data.SPRITE_OFFSET4, 0, 0, 512, 200);
		gameImage.method226(Data.SPRITE_OFFSET4);
		c = '\u2400';
		c1 = '\u2400';
		c2 = '\u044C';
		c3 = '\u0378';
		camera.zoom1 = 4100;
		camera.zoom2 = 4100;
		camera.zoom3 = 1;
		camera.zoom4 = 4000;
		camera.method297(c, -landscapeEngine.getAveragedElevation(c, c1), c1, 912, c3, 0, c2 * 2);
		camera.processCamera();
		gameImage.fadeToBlack();
		gameImage.fadeToBlack();
		gameImage.drawBox(0, 0, 512, 6, 0);
		for (int l = 6; l >= 1; l--) {
			gameImage.method221(0, l, 0, l, 512, 8);
		}

		gameImage.drawBox(0, 194, 512, 20, 0);
		for (int i1 = 6; i1 >= 1; i1--) {
			gameImage.method221(0, i1, 0, 194 - i1, 512, 8);
		}

		gameImage.drawSprite(15, 15, Data.SPRITE_OFFSET1 + 10);
		gameImage.method229(Data.SPRITE_OFFSET4 + 1, 0, 0, 512, 200);
		gameImage.method226(Data.SPRITE_OFFSET4 + 1);
		for (int j1 = 0; j1 < 64; j1++) {
			camera.removeModel(landscapeEngine.aModelArrayArray608[0][j1]);
			camera.removeModel(landscapeEngine.aModelArrayArray590[1][j1]);
			camera.removeModel(landscapeEngine.aModelArrayArray608[1][j1]);
			camera.removeModel(landscapeEngine.aModelArrayArray590[2][j1]);
			camera.removeModel(landscapeEngine.aModelArrayArray608[2][j1]);
		}

		c = '\u2B80';
		c1 = '\u2880';
		c2 = '\u01F4';
		c3 = '\u0178';
		camera.zoom1 = 4100;
		camera.zoom2 = 4100;
		camera.zoom3 = 1;
		camera.zoom4 = 4000;
		camera.method297(c, -landscapeEngine.getAveragedElevation(c, c1), c1, 912, c3, 0, c2 * 2);
		camera.processCamera();
		gameImage.fadeToBlack();
		gameImage.fadeToBlack();
		gameImage.drawBox(0, 0, 512, 6, 0);
		for (int k1 = 6; k1 >= 1; k1--) {
			gameImage.method221(0, k1, 0, k1, 512, 8);
		}

		gameImage.drawBox(0, 194, 512, 20, 0);
		for (int l1 = 6; l1 >= 1; l1--) {
			gameImage.method221(0, l1, 0, 194, 512, 8);
		}

		gameImage.drawSprite(15, 15, Data.SPRITE_OFFSET1 + 10);
		gameImage.method229(Data.SPRITE_OFFSET1 + 10, 0, 0, 512, 200);
		gameImage.method226(Data.SPRITE_OFFSET1 + 10);
	}

	private final void method116() {
		super.inputMessage = "";
		super.aString43 = "";
	}

	private final boolean hasItemEquipped(int i) {
		for (int j = 0; j < inventorySize; j++)
			if (inventoryItems[j] == i && wornItems[j] == 1)
				return true;

		return false;
	}

	private final void method118(int i, int j, int k) {
		gameImage.method219(i, j, k);
		gameImage.method219(i - 1, j, k);
		gameImage.method219(i + 1, j, k);
		gameImage.method219(i, j - 1, k);
		gameImage.method219(i, j + 1, k);
	}

	private final void method119() {
		for (int i = 0; i < mobMessagesCount; i++) {
			int j = gameImage.stringHeight(1);
			int l = mobMessagesX[i];
			int k1 = mobMessagesY[i];
			int j2 = mobMessagesWidth[i];
			int i3 = mobMessagesHeight[i];
			boolean flag = true;
			while (flag) {
				flag = false;
				for (int i4 = 0; i4 < i; i4++) {
					if (k1 + i3 > mobMessagesY[i4] - j && k1 - j < mobMessagesY[i4] + mobMessagesHeight[i4] && l - j2 < mobMessagesX[i4] + mobMessagesWidth[i4]
							&& l + j2 > mobMessagesX[i4] - mobMessagesWidth[i4] && mobMessagesY[i4] - j - i3 < k1) {
						k1 = mobMessagesY[i4] - j - i3;
						flag = true;
					}
				}

			}
			mobMessagesY[i] = k1;
			gameImage.method255(mobMessages[i], l, k1, 1, 0xffff00, 300);
		}

		for (int k = 0; k < bubbleItemCount; k++) {
			int i1 = bubbleItemX[k];
			int l1 = bubbleItemY[k];
			int k2 = bubbleItemZ[k];
			int j3 = bubbleItemArray[k];
			int l3 = (39 * k2) / 100;
			int j4 = (27 * k2) / 100;
			int k4 = l1 - j4;
			gameImage.spriteClipRoutine2(i1 - l3 / 2, k4, l3, j4, Data.SPRITE_OFFSET1 + 9, 85);
			int l4 = (36 * k2) / 100;
			int i5 = (24 * k2) / 100;
			gameImage.spriteClipRoutine4(i1 - l4 / 2, (k4 + j4 / 2) - i5 / 2, l4, i5, Data.ITEM_SPRITES[j3] + Data.SPRITE_OFFSET3,
					Data.ITEM_COLOR_MASKS[j3], 0, 0, false);
		}

		for (int j1 = 0; j1 < healthBarCount; j1++) {
			int i2 = healthBarX[j1];
			int l2 = healthBarY[j1];
			int k3 = healthBarPercentages[j1];
			gameImage.method213(i2 - 15, l2 - 3, k3, 5, 65280, 192);
			gameImage.method213((i2 - 15) + k3, l2 - 3, 30 - k3, 5, 0xff0000, 192);
		}

	}

	public final void method2() {
		if (memoryError)
			return;
		if (lastLoadedNull)
			return;
		try {
			loginTimer++;
			if (loggedIn == 0) {
				super.lastActionTimeout = 0;
				updateLoginMenu();
			}
			if (loggedIn == 1) {
				super.lastActionTimeout++;
				processGame();
			}
			super.lastMouseButtonDown = 0;
			super.keyDown2 = 0;
			anInt952++;
			if (anInt952 > 500) {
				anInt952 = 0;
				int i = (int) (Math.random() * 4D);
				if ((i & 1) == 1)
					anInt736 += anInt737;
				if ((i & 2) == 2)
					anInt920 += anInt921;
			}
			if (anInt736 < -50)
				anInt737 = 2;
			if (anInt736 > 50)
				anInt737 = -2;
			if (anInt920 < -50)
				anInt921 = 2;
			if (anInt920 > 50)
				anInt921 = -2;
			if (anInt962 > 0)
				anInt962--;
			if (anInt963 > 0)
				anInt963--;
			if (anInt964 > 0)
				anInt964--;
			if (anInt965 > 0)
				anInt965--;
		} catch (OutOfMemoryError _ex) {
			collectGarbage();
			memoryError = true;
		}
	}

	public final void method4() {
		if (lastLoadedNull) {
			Graphics g = getGraphics();
			g.setColor(Color.black);
			g.fillRect(0, 0, 512, 356);
			g.setFont(new Font("Arial", 1, 16));
			g.setColor(Color.yellow);
			int i = 35;
			g.drawString("Sorry, an error has occured whilst loading RuneScape", 30, i);
			i += 50;
			g.setColor(Color.white);
			g.drawString("To fix this try the following (in order):", 30, i);
			i += 50;
			g.setColor(Color.white);
			g.setFont(new Font("Arial", 1, 12));
			g.drawString("1: Try closing ALL open web-browser windows, and reloading", 30, i);
			i += 30;
			g.drawString("2: Try clearing your web-browsers cache from tools->internet options", 30, i);
			i += 30;
			g.drawString("3: Try using a different game-world", 30, i);
			i += 30;
			g.drawString("4: Try rebooting your computer", 30, i);
			i += 30;
			g.drawString("5: Try selecting a different version of Java from the play-game menu", 30, i);
			changeThreadSleepModifier(1);
			return;
		}
		if (memoryError) {
			Graphics g2 = getGraphics();
			g2.setColor(Color.black);
			g2.fillRect(0, 0, 512, 356);
			g2.setFont(new Font("Arial", 1, 20));
			g2.setColor(Color.white);
			g2.drawString("Error - out of memory!", 50, 50);
			g2.drawString("Close ALL unnecessary programs", 50, 100);
			g2.drawString("and windows before loading the game", 50, 150);
			g2.drawString("RuneScape needs about 64 MB of spare RAM", 50, 200);
			changeThreadSleepModifier(1);
			return;
		}
		try {
			if (loggedIn == 0) {
				gameImage.drawStringShadows = false;
				drawLoginMenus();
			}
			if (loggedIn == 1) {
				gameImage.drawStringShadows = true;
				drawGame();
			}
		} catch (OutOfMemoryError _ex) {
			collectGarbage();
			memoryError = true;
		}
	}

	private final void method55(int i, int j, int k, int l) {
		int i1;
		int j1;
		if (k == 0 || k == 4) {
			i1 = Data.OBJECT_WIDTH[l];
			j1 = Data.OBJECT_HEIGHT[l];
		} else {
			j1 = Data.OBJECT_WIDTH[l];
			i1 = Data.OBJECT_HEIGHT[l];
		}
		if (Data.OBJECT_TYPES[l] == 2 || Data.OBJECT_TYPES[l] == 3) {
			if (k == 0) {
				i--;
				i1++;
			}
			if (k == 2)
				j1++;
			if (k == 4)
				i1++;
			if (k == 6) {
				j--;
				j1++;
			}
			method103(sectionX, sectionY, i, j, (i + i1) - 1, (j + j1) - 1, false, true);
		} else {
			method103(sectionX, sectionY, i, j, (i + i1) - 1, (j + j1) - 1, true, true);
		}
	}

	private final void method56() {
		char c = '\u0198';
		char c1 = '\u014E';
		if (anInt688 > 0 && anInt853 <= 48)
			anInt688 = 0;
		if (anInt688 > 1 && anInt853 <= 96)
			anInt688 = 1;
		if (anInt688 > 2 && anInt853 <= 144)
			anInt688 = 2;
		if (anInt831 >= anInt853 || anInt831 < 0)
			anInt831 = -1;
		if (anInt831 != -1 && anIntArray915[anInt831] != anInt832) {
			anInt831 = -1;
			anInt832 = -2;
		}
		if (mouseButtonClick != 0) {
			mouseButtonClick = 0;
			int i = super.mouseX - (256 - c / 2);
			int k = super.mouseY - (170 - c1 / 2);
			if (i >= 0 && k >= 12 && i < 408 && k < 280) {
				int i1 = anInt688 * 48;
				for (int l1 = 0; l1 < 6; l1++) {
					for (int j2 = 0; j2 < 8; j2++) {
						int l6 = 7 + j2 * 49;
						int j7 = 28 + l1 * 34;
						if (i > l6 && i < l6 + 49 && k > j7 && k < j7 + 34 && i1 < anInt853 && anIntArray915[i1] != -1) {
							anInt832 = anIntArray915[i1];
							anInt831 = i1;
						}
						i1++;
					}

				}

				i = 256 - c / 2;
				k = 170 - c1 / 2;
				int k2;
				if (anInt831 < 0) {
					k2 = -1;
				} else {
					k2 = anIntArray915[anInt831];
				}
				if (k2 != -1) {
					int j1 = anIntArray916[anInt831];
					if (Data.ITEM_STACKABLE[k2] == 1 && j1 > 1)
						j1 = 1;
					if (j1 >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 238 && super.mouseX < i + 250 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(1);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (j1 >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 238 && super.mouseX < i + 280 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(5);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (j1 >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 238 && super.mouseX < i + 305 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(25);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (j1 >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 238 && super.mouseX < i + 335 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(100);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (j1 >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 238 && super.mouseX < i + 368 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(500);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (j1 >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 238 && super.mouseX < i + 400 && super.mouseY <= k + 249) {
						super.network.createPacket(183);
						super.network.addShort(k2);
						super.network.addShort(2500);
						super.network.addInteger(0x12345678);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 1 && super.mouseX >= i + 220 && super.mouseY >= k + 263 && super.mouseX < i + 250 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(1);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 5 && super.mouseX >= i + 250 && super.mouseY >= k + 263 && super.mouseX < i + 280 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(5);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 25 && super.mouseX >= i + 280 && super.mouseY >= k + 263 && super.mouseX < i + 305 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(25);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 100 && super.mouseX >= i + 305 && super.mouseY >= k + 263 && super.mouseX < i + 335 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(100);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 500 && super.mouseX >= i + 335 && super.mouseY >= k + 263 && super.mouseX < i + 368 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(500);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
					if (itemAmount(k2) >= 2500 && super.mouseX >= i + 370 && super.mouseY >= k + 263 && super.mouseX < i + 400 && super.mouseY <= k + 274) {
						super.network.createPacket(198);
						super.network.addShort(k2);
						super.network.addShort(2500);
						super.network.addInteger(0x87654321);
						super.network.formatPacket();
					}
				}
			} else if (anInt853 > 48 && i >= 50 && i <= 115 && k <= 12) {
				anInt688 = 0;
			} else if (anInt853 > 48 && i >= 115 && i <= 180 && k <= 12) {
				anInt688 = 1;
			} else if (anInt853 > 96 && i >= 180 && i <= 245 && k <= 12) {
				anInt688 = 2;
			} else if (anInt853 > 144 && i >= 245 && i <= 310 && k <= 12) {
				anInt688 = 3;
			} else {
				super.network.createPacket(48);
				super.network.formatPacket();
				aBoolean699 = false;
				return;
			}
		}
		int j = 256 - c / 2;
		int l = 170 - c1 / 2;
		gameImage.drawBox(j, l, 408, 12, 192);
		int k1 = 0x989898;
		gameImage.method213(j, l + 12, 408, 17, k1, 160);
		gameImage.method213(j, l + 29, 8, 204, k1, 160);
		gameImage.method213(j + 399, l + 29, 9, 204, k1, 160);
		gameImage.method213(j, l + 233, 408, 47, k1, 160);
		gameImage.drawString("Bank", j + 1, l + 10, 1, 0xffffff);
		int i2 = 50;
		if (anInt853 > 48) {
			int l2 = 0xffffff;
			if (anInt688 == 0) {
				l2 = 0xff0000;
			} else if (super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12) {
				l2 = 0xffff00;
			}
			gameImage.drawString("<page 1>", j + i2, l + 10, 1, l2);
			i2 += 65;
			l2 = 0xffffff;
			if (anInt688 == 1) {
				l2 = 0xff0000;
			} else if (super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12) {
				l2 = 0xffff00;
			}
			gameImage.drawString("<page 2>", j + i2, l + 10, 1, l2);
			i2 += 65;
		}
		if (anInt853 > 96) {
			int i3 = 0xffffff;
			if (anInt688 == 2) {
				i3 = 0xff0000;
			} else if (super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12) {
				i3 = 0xffff00;
			}
			gameImage.drawString("<page 3>", j + i2, l + 10, 1, i3);
			i2 += 65;
		}
		if (anInt853 > 144) {
			int j3 = 0xffffff;
			if (anInt688 == 3) {
				j3 = 0xff0000;
			} else if (super.mouseX > j + i2 && super.mouseY >= l && super.mouseX < j + i2 + 65 && super.mouseY < l + 12) {
				j3 = 0xffff00;
			}
			gameImage.drawString("<page 4>", j + i2, l + 10, 1, j3);
			i2 += 65;
		}
		int k3 = 0xffffff;
		if (super.mouseX > j + 320 && super.mouseY >= l && super.mouseX < j + 408 && super.mouseY < l + 12) {
			k3 = 0xff0000;
		}
		gameImage.method253("Close window", j + 406, l + 10, 1, k3);
		gameImage.drawString("Number in bank in green", j + 7, l + 24, 1, 65280);
		gameImage.drawString("Number held in blue", j + 289, l + 24, 1, 65535);
		int i7 = 0xd0d0d0;
		int k7 = anInt688 * 48;
		for (int i8 = 0; i8 < 6; i8++) {
			for (int j8 = 0; j8 < 8; j8++) {
				int l8 = j + 7 + j8 * 49;
				int i9 = l + 28 + i8 * 34;
				if (anInt831 == k7) {
					gameImage.method213(l8, i9, 49, 34, 0xff0000, 160);
				} else {
					gameImage.method213(l8, i9, 49, 34, i7, 160);
				}
				gameImage.drawBoxEdge(l8, i9, 50, 35, 0);
				if (k7 < anInt853 && anIntArray915[k7] != -1) {
					gameImage.spriteClipRoutine4(l8, i9, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray915[k7]],
							Data.ITEM_COLOR_MASKS[anIntArray915[k7]], 0, 0, false);
					gameImage.drawString(String.valueOf(anIntArray916[k7]), l8 + 1, i9 + 10, 1, 65280);
					gameImage.method253(String.valueOf(itemAmount(anIntArray915[k7])), l8 + 47, i9 + 29, 1, 65535);
				}
				k7++;
			}

		}

		gameImage.method217(j + 5, l + 256, 398, 0);
		if (anInt831 == -1) {
			gameImage.drawCenteredString("Select an object to withdraw or deposit", j + 204, l + 248, 3, 0xffff00);
			return;
		}
		int k8;
		if (anInt831 < 0) {
			k8 = -1;
		} else {
			k8 = anIntArray915[anInt831];
		}
		if (k8 != -1) {
			int l7 = anIntArray916[anInt831];
			if (Data.ITEM_STACKABLE[k8] == 1 && l7 > 1)
				l7 = 1;
			if (l7 > 0) {
				gameImage.drawString("Withdraw " + Data.ITEM_NAMES[k8], j + 2, l + 248, 1, 0xffffff);
				int l3 = 0xffffff;
				if (super.mouseX >= j + 220 && super.mouseY >= l + 238 && super.mouseX < j + 250 && super.mouseY <= l + 249) {
					l3 = 0xff0000;
				}
				gameImage.drawString("One", j + 222, l + 248, 1, l3);
				if (l7 >= 5) {
					int i4 = 0xffffff;
					if (super.mouseX >= j + 250 && super.mouseY >= l + 238 && super.mouseX < j + 280 && super.mouseY <= l + 249) {
						i4 = 0xff0000;
					}
					gameImage.drawString("Five", j + 252, l + 248, 1, i4);
				}
				if (l7 >= 25) {
					int j4 = 0xffffff;
					if (super.mouseX >= j + 280 && super.mouseY >= l + 238 && super.mouseX < j + 305 && super.mouseY <= l + 249) {
						j4 = 0xff0000;
					}
					gameImage.drawString("25", j + 282, l + 248, 1, j4);
				}
				if (l7 >= 100) {
					int k4 = 0xffffff;
					if (super.mouseX >= j + 305 && super.mouseY >= l + 238 && super.mouseX < j + 335 && super.mouseY <= l + 249) {
						k4 = 0xff0000;
					}
					gameImage.drawString("100", j + 307, l + 248, 1, k4);
				}
				if (l7 >= 500) {
					int l4 = 0xffffff;
					if (super.mouseX >= j + 335 && super.mouseY >= l + 238 && super.mouseX < j + 368 && super.mouseY <= l + 249) {
						l4 = 0xff0000;
					}
					gameImage.drawString("500", j + 337, l + 248, 1, l4);
				}
				if (l7 >= 2500) {
					int i5 = 0xffffff;
					if (super.mouseX >= j + 370 && super.mouseY >= l + 238 && super.mouseX < j + 400 && super.mouseY <= l + 249) {
						i5 = 0xff0000;
					}
					gameImage.drawString("2500", j + 370, l + 248, 1, i5);
				}
			}
			if (itemAmount(k8) > 0) {
				gameImage.drawString("Deposit " + Data.ITEM_NAMES[k8], j + 2, l + 273, 1, 0xffffff);
				int j5 = 0xffffff;
				if (super.mouseX >= j + 220 && super.mouseY >= l + 263 && super.mouseX < j + 250 && super.mouseY <= l + 274) {
					j5 = 0xff0000;
				}
				gameImage.drawString("One", j + 222, l + 273, 1, j5);
				if (itemAmount(k8) >= 5) {
					int k5 = 0xffffff;
					if (super.mouseX >= j + 250 && super.mouseY >= l + 263 && super.mouseX < j + 280 && super.mouseY <= l + 274) {
						k5 = 0xff0000;
					}
					gameImage.drawString("Five", j + 252, l + 273, 1, k5);
				}
				if (itemAmount(k8) >= 25) {
					int l5 = 0xffffff;
					if (super.mouseX >= j + 280 && super.mouseY >= l + 263 && super.mouseX < j + 305 && super.mouseY <= l + 274) {
						l5 = 0xff0000;
					}
					gameImage.drawString("25", j + 282, l + 273, 1, l5);
				}
				if (itemAmount(k8) >= 100) {
					int i6 = 0xffffff;
					if (super.mouseX >= j + 305 && super.mouseY >= l + 263 && super.mouseX < j + 335 && super.mouseY <= l + 274) {
						i6 = 0xff0000;
					}
					gameImage.drawString("100", j + 307, l + 273, 1, i6);
				}
				if (itemAmount(k8) >= 500) {
					int j6 = 0xffffff;
					if (super.mouseX >= j + 335 && super.mouseY >= l + 263 && super.mouseX < j + 368 && super.mouseY <= l + 274) {
						j6 = 0xff0000;
					}
					gameImage.drawString("500", j + 337, l + 273, 1, j6);
				}
				if (itemAmount(k8) >= 2500) {
					int k6 = 0xffffff;
					if (super.mouseX >= j + 370 && super.mouseY >= l + 263 && super.mouseX < j + 400 && super.mouseY <= l + 274) {
						k6 = 0xff0000;
					}
					gameImage.drawString("2500", j + 370, l + 273, 1, k6);
				}
			}
		}
	}

	private final void method57() {
		gameImage.drawBox(126, 137, 260, 60, 0);
		gameImage.drawBoxEdge(126, 137, 260, 60, 0xffffff);
		gameImage.drawCenteredString("Logging out...", 256, 173, 5, 0xffffff);
	}

	private final void method58(boolean flag) {
		int i = gameImage.defaultMenuWidth - 248;
		gameImage.drawSprite(i, 3, Data.SPRITE_OFFSET1 + 1);
		for (int j = 0; j < anInt892; j++) {
			int k = i + (j % 5) * 49;
			int i1 = 36 + (j / 5) * 34;
			if (j < inventorySize && wornItems[j] == 1) {
				gameImage.method213(k, i1, 49, 34, 0xff0000, 128);
			} else {
				gameImage.method213(k, i1, 49, 34, GameImage.method222(181, 181, 181), 128);
			}
			if (j < inventorySize) {
				gameImage.spriteClipRoutine4(k, i1, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[inventoryItems[j]],
						Data.ITEM_COLOR_MASKS[inventoryItems[j]], 0, 0, false);
				if (Data.ITEM_STACKABLE[inventoryItems[j]] == 0) {
					gameImage.drawString(String.valueOf(inventoryItemAmount[j]), k + 1, i1 + 10, 1, 0xffff00);
				}
			}
		}

		for (int l = 1; l <= 4; l++) {
			gameImage.method218(i + l * 49, 36, (anInt892 / 5) * 34, 0);
		}

		for (int j1 = 1; j1 <= anInt892 / 5 - 1; j1++) {
			gameImage.method217(i, 36 + j1 * 34, 245, 0);
		}

		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 248);
		int k1 = super.mouseY - 36;
		if (i >= 0 && k1 >= 0 && i < 248 && k1 < (anInt892 / 5) * 34) {
			int l1 = i / 49 + (k1 / 34) * 5;
			if (l1 < inventorySize) {
				int i2 = inventoryItems[l1];
				if (selectedSpell >= 0) {
					if (Data.anIntArray63[selectedSpell] == 3) {
						aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
						aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
						menuActions[anInt763] = 600;
						anIntArray844[anInt763] = l1;
						anIntArray845[anInt763] = selectedSpell;
						anInt763++;
					}
				} else {
					if (anInt757 >= 0) {
						aStringArray676[anInt763] = "Use " + aString758 + " with";
						aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
						menuActions[anInt763] = 610;
						anIntArray844[anInt763] = l1;
						anIntArray845[anInt763] = anInt757;
						anInt763++;
						return;
					}
					if (wornItems[l1] == 1) {
						aStringArray676[anInt763] = "Remove";
						aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
						menuActions[anInt763] = 620;
						anIntArray844[anInt763] = l1;
						anInt763++;
					} else if (Data.ITEM_WEARABLE[i2] != 0) {
						if ((Data.ITEM_WEARABLE[i2] & 0x18) != 0) {
							aStringArray676[anInt763] = "Wield";
						} else {
							aStringArray676[anInt763] = "Wear";
						}
						aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
						menuActions[anInt763] = 630;
						anIntArray844[anInt763] = l1;
						anInt763++;
					}
					if (!Data.ITEM_ACTIONS[i2].equals("")) {
						aStringArray676[anInt763] = Data.ITEM_ACTIONS[i2];
						aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
						menuActions[anInt763] = 640;
						anIntArray844[anInt763] = l1;
						anInt763++;
					}
					aStringArray676[anInt763] = "Use";
					aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
					menuActions[anInt763] = 650;
					anIntArray844[anInt763] = l1;
					anInt763++;
					aStringArray676[anInt763] = "Drop";
					aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
					menuActions[anInt763] = 660;
					anIntArray844[anInt763] = l1;
					anInt763++;
					aStringArray676[anInt763] = "Examine";
					aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[i2];
					menuActions[anInt763] = 3600;
					anIntArray844[anInt763] = i2;
					anInt763++;
				}
			}
		}
	}

	private final void method66(boolean flag) {
		int i = gameImage.defaultMenuWidth - 199;
		int j = 36;
		gameImage.drawSprite(i - 49, 3, Data.SPRITE_OFFSET1 + 3);
		char c = '\304';
		char c1 = '\u0113';
		int l;
		int k = l = GameImage.method222(160, 160, 160);
		if (anInt836 == 0) {
			k = GameImage.method222(220, 220, 220);
		} else {
			l = GameImage.method222(220, 220, 220);
		}
		gameImage.method213(i, j, c / 2, 24, k, 128);
		gameImage.method213(i + c / 2, j, c / 2, 24, l, 128);
		gameImage.method213(i, j + 24, c, c1 - 24, GameImage.method222(220, 220, 220), 128);
		gameImage.method217(i, j + 24, c, 0);
		gameImage.method218(i + c / 2, j, 24, 0);
		gameImage.drawCenteredString("Stats", i + c / 4, j + 16, 4, 0);
		gameImage.drawCenteredString("Quests", i + c / 4 + c / 2, j + 16, 4, 0);
		if (anInt836 == 0) {
			int i1 = 72;
			int k1 = -1;
			gameImage.drawString("Skills", i + 5, i1, 3, 0xffff00);
			i1 += 13;
			for (int l1 = 0; l1 < 9; l1++) {
				int i2 = 0xffffff;
				if (super.mouseX > i + 3 && super.mouseY >= i1 - 11 && super.mouseY < i1 + 2 && super.mouseX < i + 90) {
					i2 = 0xff0000;
					k1 = l1;
				}
				gameImage.drawString(SKILLS[l1] + ":@yel@" + ourCurrentSkillLevels[l1] + "/" + ourMaximumSkillLevels[l1], i + 5, i1, 1, i2);
				i2 = 0xffffff;
				if (super.mouseX >= i + 90 && super.mouseY >= i1 - 13 - 11 && super.mouseY < (i1 - 13) + 2 && super.mouseX < i + 196) {
					i2 = 0xff0000;
					k1 = l1 + 9;
				}
				gameImage.drawString(SKILLS[l1 + 9] + ":@yel@" + ourCurrentSkillLevels[l1 + 9] + "/" + ourMaximumSkillLevels[l1 + 9], (i + c / 2) - 5,
						i1 - 13, 1, i2);
				i1 += 13;
			}

			gameImage.drawString("Quest Points:@yel@" + questPoints, (i + c / 2) - 5, i1 - 13, 1, 0xffffff);
			i1 += 12;
			// gameGraphics.drawString("Fatigue: @yel@" + (anInt978 * 100) / 750
			// + "%", i + 5, i1 - 13, 1, 0xffffff);
			i1 += 8;
			gameImage.drawString("Equipment Status", i + 5, i1, 3, 0xffff00);
			i1 += 12;
			for (int j2 = 0; j2 < 3; j2++) {
				gameImage.drawString(EQUIPMENT_INFO[j2] + ":@yel@" + equipmentBonuses[j2], i + 5, i1, 1, 0xffffff);
				if (j2 < 2) {
					gameImage.drawString(EQUIPMENT_INFO[j2 + 3] + ":@yel@" + equipmentBonuses[j2 + 3], i + c / 2 + 25, i1, 1, 0xffffff);
				}
				i1 += 13;
			}

			i1 += 6;
			gameImage.method217(i, i1 - 15, c, 0);
			if (k1 != -1) {
				gameImage.drawString(SKILLS[k1] + " skill", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int k2 = experience[0];
				for (int i3 = 0; i3 < 98; i3++) {
					if (ourSkillExperience[k1] >= experience[i3])
						k2 = experience[i3 + 1];
				}

				gameImage.drawString("Total xp: " + ourSkillExperience[k1], i + 5, i1, 1, 0xffffff);
				i1 += 12;
				gameImage.drawString("Next level at: " + k2 / 4, i + 5, i1, 1, 0xffffff);
			} else {
				gameImage.drawString("Overall levels", i + 5, i1, 1, 0xffff00);
				i1 += 12;
				int l2 = 0;
				for (int j3 = 0; j3 < 18; j3++) {
					l2 += ourMaximumSkillLevels[j3];
				}

				gameImage.drawString("Skill total: " + l2, i + 5, i1, 1, 0xffffff);
				i1 += 12;
				gameImage.drawString("Combat level: " + ourPlayer.getLevel(), i + 5, i1, 1, 0xffffff);
				i1 += 12;
			}
		}
		if (anInt836 == 1) {
			aMenu_834.method164(anInt835);
			aMenu_834.method166(anInt835, 0, "@whi@Quest-list (green=completed)");
			for (int j1 = 0; j1 < 50; j1++) {
				aMenu_834.method166(anInt835, j1 + 1, (aBooleanArray808[j1] ? "@gre@" : "@red@") + QUESTS[j1]);
			}

			aMenu_834.drawMenu();
		}
		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 199);
		j = super.mouseY - 36;
		if (i >= 0 && j >= 0 && i < c && j < c1) {
			if (anInt836 == 1) {
				aMenu_834.updateActions(i + (gameImage.defaultMenuWidth - 199), j + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			}
			if (j <= 24 && mouseButtonClick == 1) {
				if (i < 98) {
					anInt836 = 0;
					return;
				}
				if (i > 98)
					anInt836 = 1;
			}
		}
	}

	private final void method67() {
		int i = 97;
		gameImage.drawBox(86, 77, 340, 180, 0);
		gameImage.drawBoxEdge(86, 77, 340, 180, 0xffffff);
		gameImage.drawCenteredString("Warning! Proceed with caution", 256, i, 4, 0xff0000);
		i += 26;
		gameImage.drawCenteredString("If you go much further north you will enter the", 256, i, 1, 0xffffff);
		i += 13;
		gameImage.drawCenteredString("wilderness. This a very dangerous area where", 256, i, 1, 0xffffff);
		i += 13;
		gameImage.drawCenteredString("other players can attack you!", 256, i, 1, 0xffffff);
		i += 22;
		gameImage.drawCenteredString("The further north you go the more dangerous it", 256, i, 1, 0xffffff);
		i += 13;
		gameImage.drawCenteredString("becomes, but the more treasure you will find.", 256, i, 1, 0xffffff);
		i += 22;
		gameImage.drawCenteredString("In the wilderness an indicator at the bottom-right", 256, i, 1, 0xffffff);
		i += 13;
		gameImage.drawCenteredString("of the screen will show the current level of danger", 256, i, 1, 0xffffff);
		i += 22;
		int j = 0xffffff;
		if (super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331)
			j = 0xff0000;
		gameImage.drawCenteredString("Click here to close window", 256, i, 1, j);
		if (mouseButtonClick != 0) {
			if (super.mouseY > i - 12 && super.mouseY <= i && super.mouseX > 181 && super.mouseX < 331) {
				wildernessType = 2;
			}
			if (super.mouseX < 86 || super.mouseX > 426 || super.mouseY < 77 || super.mouseY > 257)
				wildernessType = 2;
			mouseButtonClick = 0;
		}
	}

	private final void method69() {
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 && super.mouseY >= 3 && super.mouseX < gameImage.defaultMenuWidth - 3
				&& super.mouseY < 35) {
			mouseOverMenu = 1;
		}
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 33 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 33 && super.mouseY < 35) {
			mouseOverMenu = 2;
			anInt995 = (int) (Math.random() * 13D) - 6;
			anInt996 = (int) (Math.random() * 23D) - 11;
		}
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 66 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 66 && super.mouseY < 35) {
			mouseOverMenu = 3;
		}
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 99 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 99 && super.mouseY < 35) {
			mouseOverMenu = 4;
		}
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 132 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 132 && super.mouseY < 35) {
			mouseOverMenu = 5;
		}
		if (mouseOverMenu == 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 165 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 165 && super.mouseY < 35) {
			mouseOverMenu = 6;
		}
		if (mouseOverMenu != 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 && super.mouseY >= 3 && super.mouseX < gameImage.defaultMenuWidth - 3
				&& super.mouseY < 26) {
			mouseOverMenu = 1;
		}
		if (mouseOverMenu != 0 && mouseOverMenu != 2 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 33 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 33 && super.mouseY < 26) {
			mouseOverMenu = 2;
			anInt995 = (int) (Math.random() * 13D) - 6;
			anInt996 = (int) (Math.random() * 23D) - 11;
		}
		if (mouseOverMenu != 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 66 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 66 && super.mouseY < 26) {
			mouseOverMenu = 3;
		}
		if (mouseOverMenu != 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 99 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 99 && super.mouseY < 26) {
			mouseOverMenu = 4;
		}
		if (mouseOverMenu != 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 132 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 132 && super.mouseY < 26) {
			mouseOverMenu = 5;
		}
		if (mouseOverMenu != 0 && super.mouseX >= gameImage.defaultMenuWidth - 35 - 165 && super.mouseY >= 3
				&& super.mouseX < gameImage.defaultMenuWidth - 3 - 165 && super.mouseY < 26) {
			mouseOverMenu = 6;
		}
		if (mouseOverMenu == 1 && (super.mouseX < gameImage.defaultMenuWidth - 248 || super.mouseY > 36 + (anInt892 / 5) * 34)) {
			mouseOverMenu = 0;
		}
		if (mouseOverMenu == 3 && (super.mouseX < gameImage.defaultMenuWidth - 199 || super.mouseY > 316)) {
			mouseOverMenu = 0;
		}
		if ((mouseOverMenu == 2 || mouseOverMenu == 4 || mouseOverMenu == 5) && (super.mouseX < gameImage.defaultMenuWidth - 199 || super.mouseY > 240)) {
			mouseOverMenu = 0;
		}
		if (mouseOverMenu == 6 && (super.mouseX < gameImage.defaultMenuWidth - 199 || super.mouseY > 311)) {
			mouseOverMenu = 0;
		}
	}

	private final void method70(int i) {
		int j = anIntArray886[i];
		int k = anIntArray887[i];
		int l = anIntArray844[i];
		int i1 = anIntArray845[i];
		int j1 = anIntArray846[i];
		int action = menuActions[i];
		if (action == 200) {
			method106(sectionX, sectionY, j, k, true);
			super.network.createPacket(104);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 210) {
			method106(sectionX, sectionY, j, k, true);
			super.network.createPacket(34);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 220) {
			method106(sectionX, sectionY, j, k, true);
			super.network.createPacket(245);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
		}
		if (action == 3200)
			displayMessage(Data.ITEM_DESCRIPTIONS[l], 3);
		if (action == 300) {
			method78(j, k, l);
			super.network.createPacket(67);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addByte(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 310) {
			method78(j, k, l);
			super.network.createPacket(36);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addByte(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 320) {
			method78(j, k, l);
			super.network.createPacket(126);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addByte(l);
			super.network.formatPacket();
		}
		if (action == 2300) {
			method78(j, k, l);
			super.network.createPacket(235);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addByte(l);
			super.network.formatPacket();
		}
		if (action == 3300)
			displayMessage(Data.aStringArray100[l], 3);
		if (action == 400) {
			method55(j, k, l, i1);
			super.network.createPacket(17);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(j1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 410) {
			method55(j, k, l, i1);
			super.network.createPacket(94);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(j1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 420) {
			method55(j, k, l, i1);
			super.network.createPacket(51);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.formatPacket();
		}
		if (action == 2400) {
			method55(j, k, l, i1);
			super.network.createPacket(40);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.formatPacket();
		}
		if (action == 3400)
			displayMessage(Data.OBJECT_DESCRIPTIONS[l], 3);
		if (action == 600) {
			super.network.createPacket(49);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 610) {
			super.network.createPacket(27);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 620) {
			super.network.createPacket(92);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 630) {
			super.network.createPacket(181);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 640) {
			super.network.createPacket(89);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 650) {
			anInt757 = l;
			mouseOverMenu = 0;
			aString758 = Data.ITEM_NAMES[inventoryItems[anInt757]];
		}
		if (action == 660) {
			super.network.createPacket(147);
			super.network.addShort(l);
			super.network.formatPacket();
			anInt757 = -1;
			mouseOverMenu = 0;
			displayMessage("Dropping " + Data.ITEM_NAMES[inventoryItems[l]], 4);
		}
		if (action == 3600)
			displayMessage(Data.ITEM_DESCRIPTIONS[l], 3);
		if (action == 700) {
			int l1 = (j - 64) / 128;
			int l3 = (k - 64) / 128;
			method112(sectionX, sectionY, l1, l3, true);
			super.network.createPacket(71);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 710) {
			int i2 = (j - 64) / 128;
			int i4 = (k - 64) / 128;
			method112(sectionX, sectionY, i2, i4, true);
			super.network.createPacket(142);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 720) {
			int j2 = (j - 64) / 128;
			int j4 = (k - 64) / 128;
			method112(sectionX, sectionY, j2, j4, true);
			super.network.createPacket(177);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 725) {
			int k2 = (j - 64) / 128;
			int k4 = (k - 64) / 128;
			method112(sectionX, sectionY, k2, k4, true);
			super.network.createPacket(74);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 715 || action == 2715) {
			int l2 = (j - 64) / 128;
			int l4 = (k - 64) / 128;
			method112(sectionX, sectionY, l2, l4, true);
			super.network.createPacket(73);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 3700)
			displayMessage(Data.NPC_DESCRIPTIONS[l], 3);
		if (action == 800) {
			int i3 = (j - 64) / 128;
			int i5 = (k - 64) / 128;
			method112(sectionX, sectionY, i3, i5, true);
			super.network.createPacket(55);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 810) {
			int j3 = (j - 64) / 128;
			int j5 = (k - 64) / 128;
			method112(sectionX, sectionY, j3, j5, true);
			super.network.createPacket(16);
			super.network.addShort(l);
			super.network.addShort(i1);
			super.network.formatPacket();
			anInt757 = -1;
		}
		if (action == 805 || action == 2805) {
			int k3 = (j - 64) / 128;
			int k5 = (k - 64) / 128;
			method112(sectionX, sectionY, k3, k5, true);
			super.network.createPacket(57);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 2806) {
			super.network.createPacket(222);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 2810) {
			super.network.createPacket(166);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 2820) {
			super.network.createPacket(68);
			super.network.addShort(l);
			super.network.formatPacket();
		}
		if (action == 900) {
			method112(sectionX, sectionY, j, k, true);
			super.network.createPacket(232);
			super.network.addShort(j + areaX);
			super.network.addShort(k + areaY);
			super.network.addShort(l);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 920) {
			method112(sectionX, sectionY, j, k, false);
			if (anInt841 == -24)
				anInt841 = 24;
		}
		if (action == 1000) {
			super.network.createPacket(206);
			super.network.addShort(l);
			super.network.formatPacket();
			selectedSpell = -1;
		}
		if (action == 4000) {
			anInt757 = -1;
			selectedSpell = -1;
		}
	}

	private final void method73() {
		loggedIn = 0;
		loginScreen = 0;
		currentUser = "";
		currentPassword = "";
	}

	private final void method76() {
		if (mouseButtonClick != 0) {
			for (int i = 0; i < anInt763; i++) {
				int k = anInt759 + 2;
				int i1 = anInt760 + 27 + i * 15;
				if (super.mouseX <= k - 2 || super.mouseY <= i1 - 12 || super.mouseY >= i1 + 4 || super.mouseX >= (k - 3) + anInt761) {
					continue;
				}
				method70(anIntArray925[i]);
				break;
			}

			mouseButtonClick = 0;
			aBoolean951 = false;
			return;
		}
		if (super.mouseX < anInt759 - 10 || super.mouseY < anInt760 - 10 || super.mouseX > anInt759 + anInt761 + 10 || super.mouseY > anInt760 + anInt762 + 10) {
			aBoolean951 = false;
			return;
		}
		gameImage.method213(anInt759, anInt760, anInt761, anInt762, 0xd0d0d0, 160);
		gameImage.drawString("Choose option", anInt759 + 2, anInt760 + 12, 1, 65535);
		for (int j = 0; j < anInt763; j++) {
			int l = anInt759 + 2;
			int j1 = anInt760 + 27 + j * 15;
			int k1 = 0xffffff;
			if (super.mouseX > l - 2 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && super.mouseX < (l - 3) + anInt761) {
				k1 = 0xffff00;
			}
			gameImage.drawString(aStringArray676[anIntArray925[j]] + " " + aStringArray833[anIntArray925[j]], l, j1, 1, k1);
		}

	}

	private final void method77() {
		if (mouseButtonClick != 0) {
			for (int i = 0; i < anInt881; i++) {
				if (super.mouseX >= gameImage.stringWidth(aStringArray667[i], 1) || super.mouseY <= i * 12 || super.mouseY >= 12 + i * 12) {
					continue;
				}
				super.network.createPacket(154);
				super.network.addByte(i);
				super.network.formatPacket();
				break;
			}

			mouseButtonClick = 0;
			aBoolean727 = false;
			return;
		}
		for (int j = 0; j < anInt881; j++) {
			int k = 65535;
			if (super.mouseX < gameImage.stringWidth(aStringArray667[j], 1) && super.mouseY > j * 12 && super.mouseY < 12 + j * 12) {
				k = 0xff0000;
			}
			gameImage.drawString(aStringArray667[j], 6, 12 + j * 12, 1, k);
		}

	}

	private final void method78(int i, int j, int k) {
		if (k == 0) {
			method103(sectionX, sectionY, i, j - 1, i, j, false, true);
			return;
		}
		if (k == 1) {
			method103(sectionX, sectionY, i - 1, j, i, j, false, true);
		} else {
			method103(sectionX, sectionY, i, j, i, j, true, true);
		}
	}

	private final void method80() {
		byte abyte0[] = loadData("media.ftp", "2D-Graphics", 20);
		if (abyte0 == null) {
			lastLoadedNull = true;
			return;
		}
		byte abyte1[] = DataOperations.loadFromCache("index.dat", 0, abyte0);
		gameImage.method224(Data.SPRITE_OFFSET1, DataOperations.loadFromCache("inv1.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 1, DataOperations.loadFromCache("inv2.dat", 0, abyte0), abyte1, 6);
		gameImage.method224(Data.SPRITE_OFFSET1 + 9, DataOperations.loadFromCache("bubble.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 10, DataOperations.loadFromCache("runescape.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 11, DataOperations.loadFromCache("splat.dat", 0, abyte0), abyte1, 3);
		gameImage.method224(Data.SPRITE_OFFSET1 + 14, DataOperations.loadFromCache("icon.dat", 0, abyte0), abyte1, 8);
		gameImage.method224(Data.SPRITE_OFFSET1 + 22, DataOperations.loadFromCache("hbar.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 23, DataOperations.loadFromCache("hbar2.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 24, DataOperations.loadFromCache("compass.dat", 0, abyte0), abyte1, 1);
		gameImage.method224(Data.SPRITE_OFFSET1 + 25, DataOperations.loadFromCache("buttons.dat", 0, abyte0), abyte1, 2);
		gameImage.method224(Data.SPRITE_OFFSET2, DataOperations.loadFromCache("scrollbar.dat", 0, abyte0), abyte1, 2);
		gameImage.method224(Data.SPRITE_OFFSET2 + 2, DataOperations.loadFromCache("corners.dat", 0, abyte0), abyte1, 4);
		gameImage.method224(Data.SPRITE_OFFSET2 + 6, DataOperations.loadFromCache("arrows.dat", 0, abyte0), abyte1, 2);
		gameImage.method224(Data.SPRITE_OFFSET5, DataOperations.loadFromCache("projectile.dat", 0, abyte0), abyte1, Data.anInt84);
		int i = Data.MAX_SPRITES;
		for (int j = 1; i > 0; j++) {
			int k = i;
			i -= 30;
			if (k > 30)
				k = 30;
			gameImage.method224(Data.SPRITE_OFFSET3 + (j - 1) * 30, DataOperations.loadFromCache("objects" + j + ".dat", 0, abyte0), abyte1, k);
		}

		gameImage.method227(Data.SPRITE_OFFSET1);
		gameImage.method227(Data.SPRITE_OFFSET1 + 9);
		for (int l = 11; l <= 26; l++) {
			gameImage.method227(Data.SPRITE_OFFSET1 + l);
		}

		for (int i1 = 0; i1 < Data.anInt84; i1++) {
			gameImage.method227(Data.SPRITE_OFFSET5 + i1);
		}

		for (int j1 = 0; j1 < Data.MAX_SPRITES; j1++) {
			gameImage.method227(Data.SPRITE_OFFSET3 + j1);
		}

	}

	private final void method81() {
		int i = 2203 - (sectionY + wildY + areaY);
		if (sectionX + wildX + areaX >= 2640)
			i = -50;
		int j = -1;
		for (Map.Entry<Integer, GroundObject> e : objects.entrySet())
			e.getValue().setRightClickShown(false);

		for (int l = 0; l < doorCount; l++) {
			aBooleanArray980[l] = false;
		}

		int i1 = camera.getCurrentVisibleModelCount();
		Model aclass5[] = camera.getVisibleModels();
		int ai[] = camera.getVisibleModelHandles();
		for (int j1 = 0; j1 < i1; j1++) {
			if (anInt763 > 200)
				break;
			int k1 = ai[j1];
			Model model = aclass5[j1];
			if (model.anIntArray258[k1] <= 65535 || model.anIntArray258[k1] >= 0x30d40 && model.anIntArray258[k1] <= 0x493e0) {
				if (model == camera.currentModel) {
					int i2 = model.anIntArray258[k1] % 10000;
					int l2 = model.anIntArray258[k1] / 10000;
					if (l2 == 1) {
						Player opponent = players.get(i2);
						String s = "";
						int k3 = 0;
						if (ourPlayer.getLevel() > 0 && opponent.getLevel() > 0) {
							k3 = ourPlayer.getLevel() - opponent.getLevel();
						}
						if (k3 < 0)
							s = "@or1@";
						if (k3 < -3)
							s = "@or2@";
						if (k3 < -6)
							s = "@or3@";
						if (k3 < -9)
							s = "@red@";
						if (k3 > 0)
							s = "@gr1@";
						if (k3 > 3)
							s = "@gr2@";
						if (k3 > 6)
							s = "@gr3@";
						if (k3 > 9)
							s = "@gre@";
						s = " " + s + "(level-" + opponent.getLevel() + ")";
						if (selectedSpell >= 0) {
							if (Data.anIntArray63[selectedSpell] == 1 || Data.anIntArray63[selectedSpell] == 2) {
								aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
								aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
								menuActions[anInt763] = 800;
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								anIntArray844[anInt763] = opponent.getIndex();
								anIntArray845[anInt763] = selectedSpell;
								anInt763++;
							}
						} else if (anInt757 >= 0) {
							aStringArray676[anInt763] = "Use " + aString758 + " with";
							aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
							menuActions[anInt763] = 810;
							anIntArray886[anInt763] = opponent.getX();
							anIntArray887[anInt763] = opponent.getY();
							anIntArray844[anInt763] = opponent.getIndex();
							anIntArray845[anInt763] = anInt757;
							anInt763++;
						} else {
							if (i > 0 && (opponent.getY() - 64) / 128 + wildY + areaY < 2203) {
								aStringArray676[anInt763] = "Attack";
								aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
								if (k3 >= 0 && k3 < 5) {
									menuActions[anInt763] = 805;
								} else {
									menuActions[anInt763] = 2805;
								}
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								anIntArray844[anInt763] = opponent.getIndex();
								anInt763++;
							} else if (member) {
								aStringArray676[anInt763] = "Duel with";
								aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								menuActions[anInt763] = 2806;
								anIntArray844[anInt763] = opponent.getIndex();
								anInt763++;
							}
							aStringArray676[anInt763] = "Trade with";
							aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
							menuActions[anInt763] = 2810;
							anIntArray844[anInt763] = opponent.getIndex();
							anInt763++;
							aStringArray676[anInt763] = "Follow";
							aStringArray833[anInt763] = "@whi@" + opponent.getName() + s;
							menuActions[anInt763] = 2820;
							anIntArray844[anInt763] = opponent.getIndex();
							anInt763++;
						}
					} else if (l2 == 2) {
						if (selectedSpell >= 0) {
							if (Data.anIntArray63[selectedSpell] == 3) {
								aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
								aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[groundItems.get(i2).getId()];
								menuActions[anInt763] = 200;
								anIntArray886[anInt763] = groundItems.get(i2).getX();
								anIntArray887[anInt763] = groundItems.get(i2).getY();
								anIntArray844[anInt763] = groundItems.get(i2).getId();
								anIntArray845[anInt763] = selectedSpell;
								anInt763++;
							}
						} else if (anInt757 >= 0) {
							aStringArray676[anInt763] = "Use " + aString758 + " with";
							aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[groundItems.get(i2).getId()];
							menuActions[anInt763] = 210;
							anIntArray886[anInt763] = groundItems.get(i2).getX();
							anIntArray887[anInt763] = groundItems.get(i2).getY();
							anIntArray844[anInt763] = groundItems.get(i2).getId();
							anIntArray845[anInt763] = anInt757;
							anInt763++;
						} else {
							aStringArray676[anInt763] = "Take";
							aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[groundItems.get(i2).getId()];
							menuActions[anInt763] = 220;
							anIntArray886[anInt763] = groundItems.get(i2).getX();
							anIntArray887[anInt763] = groundItems.get(i2).getY();
							anIntArray844[anInt763] = groundItems.get(i2).getId();
							anInt763++;
							aStringArray676[anInt763] = "Examine";
							aStringArray833[anInt763] = "@lre@" + Data.ITEM_NAMES[groundItems.get(i2).getId()];
							menuActions[anInt763] = 3200;
							anIntArray844[anInt763] = groundItems.get(i2).getId();
							anInt763++;
						}
					} else if (l2 == 3) {
						String s1 = "";
						int l3 = -1;
						NPC opponent = npcs.get(i2);
						int i4 = opponent.getId();
						if (Data.NPC_ATTACKABLE[i4] > 0) {
							int j4 = (Data.NPC_ATTACK[i4] + Data.NPC_DEFENSE[i4] + Data.NPC_STRENGTH[i4] + Data.NPC_HITPOINTS[i4]) / 4;
							l3 = ((ourMaximumSkillLevels[0] + ourMaximumSkillLevels[1] + ourMaximumSkillLevels[2] + ourMaximumSkillLevels[3] + 27) / 4) - j4;
							s1 = "@yel@";
							if (l3 < 0)
								s1 = "@or1@";
							if (l3 < -3)
								s1 = "@or2@";
							if (l3 < -6)
								s1 = "@or3@";
							if (l3 < -9)
								s1 = "@red@";
							if (l3 > 0)
								s1 = "@gr1@";
							if (l3 > 3)
								s1 = "@gr2@";
							if (l3 > 6)
								s1 = "@gr3@";
							if (l3 > 9)
								s1 = "@gre@";
							s1 = " " + s1 + "(level-" + j4 + ")";
						}
						if (selectedSpell >= 0) {
							if (Data.anIntArray63[selectedSpell] == 2) {
								aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
								aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()];
								menuActions[anInt763] = 700;
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								anIntArray844[anInt763] = opponent.getIndex();
								anIntArray845[anInt763] = selectedSpell;
								anInt763++;
							}
						} else if (anInt757 >= 0) {
							aStringArray676[anInt763] = "Use " + aString758 + " with";
							aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()];
							menuActions[anInt763] = 710;
							anIntArray886[anInt763] = opponent.getX();
							anIntArray887[anInt763] = opponent.getY();
							anIntArray844[anInt763] = opponent.getIndex();
							anIntArray845[anInt763] = anInt757;
							anInt763++;
						} else {
							if (Data.NPC_ATTACKABLE[i4] > 0) {
								aStringArray676[anInt763] = "Attack";
								aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()] + s1;
								if (l3 >= 0) {
									menuActions[anInt763] = 715;
								} else {
									menuActions[anInt763] = 2715;
								}
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								anIntArray844[anInt763] = opponent.getIndex();
								anInt763++;
							}
							aStringArray676[anInt763] = "Talk-to";
							aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()];
							menuActions[anInt763] = 720;
							anIntArray886[anInt763] = opponent.getX();
							anIntArray887[anInt763] = opponent.getY();
							anIntArray844[anInt763] = opponent.getIndex();
							anInt763++;
							if (!Data.NPC_COMMANDS[i4].equals("")) {
								aStringArray676[anInt763] = Data.NPC_COMMANDS[i4];
								aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()];
								menuActions[anInt763] = 725;
								anIntArray886[anInt763] = opponent.getX();
								anIntArray887[anInt763] = opponent.getY();
								anIntArray844[anInt763] = opponent.getIndex();
								anInt763++;
							}
							aStringArray676[anInt763] = "Examine";
							aStringArray833[anInt763] = "@yel@" + Data.NPC_NAMES[opponent.getId()];
							menuActions[anInt763] = 3700;
							anIntArray844[anInt763] = opponent.getId();
							anInt763++;
						}
					}
				} else if (model != null && model.anInt257 >= 10000) {
					int j2 = model.anInt257 - 10000;
					int i3 = doorId[j2];
					if (!aBooleanArray980[j2]) {
						if (selectedSpell >= 0) {
							if (Data.anIntArray63[selectedSpell] == 4) {
								aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
								aStringArray833[anInt763] = "@cya@" + Data.aStringArray99[i3];
								menuActions[anInt763] = 300;
								anIntArray886[anInt763] = doorX[j2];
								anIntArray887[anInt763] = doorY[j2];
								anIntArray844[anInt763] = doorDir[j2];
								anIntArray845[anInt763] = selectedSpell;
								anInt763++;
							}
						} else if (anInt757 >= 0) {
							aStringArray676[anInt763] = "Use " + aString758 + " with";
							aStringArray833[anInt763] = "@cya@" + Data.aStringArray99[i3];
							menuActions[anInt763] = 310;
							anIntArray886[anInt763] = doorX[j2];
							anIntArray887[anInt763] = doorY[j2];
							anIntArray844[anInt763] = doorDir[j2];
							anIntArray845[anInt763] = anInt757;
							anInt763++;
						} else {
							if (!Data.aStringArray101[i3].equalsIgnoreCase("WalkTo")) {
								aStringArray676[anInt763] = Data.aStringArray101[i3];
								aStringArray833[anInt763] = "@cya@" + Data.aStringArray99[i3];
								menuActions[anInt763] = 320;
								anIntArray886[anInt763] = doorX[j2];
								anIntArray887[anInt763] = doorY[j2];
								anIntArray844[anInt763] = doorDir[j2];
								anInt763++;
							}
							if (!Data.aStringArray102[i3].equalsIgnoreCase("Examine")) {
								aStringArray676[anInt763] = Data.aStringArray102[i3];
								aStringArray833[anInt763] = "@cya@" + Data.aStringArray99[i3];
								menuActions[anInt763] = 2300;
								anIntArray886[anInt763] = doorX[j2];
								anIntArray887[anInt763] = doorY[j2];
								anIntArray844[anInt763] = doorDir[j2];
								anInt763++;
							}
							aStringArray676[anInt763] = "Examine";
							aStringArray833[anInt763] = "@cya@" + Data.aStringArray99[i3];
							menuActions[anInt763] = 3300;
							anIntArray844[anInt763] = i3;
							anInt763++;
						}
						aBooleanArray980[j2] = true;
					}
				} else if (model != null && model.anInt257 >= 0) {
					GroundObject object = objects.get(model.anInt257);
					if (object != null && !object.hasRightClickShown()) {
						if (selectedSpell >= 0) {
							if (Data.anIntArray63[selectedSpell] == 5) {
								aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on";
								aStringArray833[anInt763] = "@cya@" + Data.OBJECT_NAMES[object.getId()];
								menuActions[anInt763] = 400;
								anIntArray886[anInt763] = object.getX();
								anIntArray887[anInt763] = object.getY();
								anIntArray844[anInt763] = object.getDirection();
								anIntArray845[anInt763] = object.getId();
								anIntArray846[anInt763] = selectedSpell;
								anInt763++;
							}
						} else if (anInt757 >= 0) {
							aStringArray676[anInt763] = "Use " + aString758 + " with";
							aStringArray833[anInt763] = "@cya@" + Data.OBJECT_NAMES[object.getId()];
							menuActions[anInt763] = 410;
							anIntArray886[anInt763] = object.getX();
							anIntArray887[anInt763] = object.getY();
							anIntArray844[anInt763] = object.getDirection();
							anIntArray845[anInt763] = object.getId();
							anIntArray846[anInt763] = anInt757;
							anInt763++;
						} else {
							if (!Data.OBJECT_COMMANDS_1[object.getId()].equalsIgnoreCase("WalkTo")) {
								aStringArray676[anInt763] = Data.OBJECT_COMMANDS_1[object.getId()];
								aStringArray833[anInt763] = "@cya@" + Data.OBJECT_NAMES[object.getId()];
								menuActions[anInt763] = 420;
								anIntArray886[anInt763] = object.getX();
								anIntArray887[anInt763] = object.getY();
								anIntArray844[anInt763] = object.getDirection();
								anIntArray845[anInt763] = object.getId();
								anInt763++;
							}
							if (!Data.OBJECT_COMMANDS_2[object.getId()].equalsIgnoreCase("Examine")) {
								aStringArray676[anInt763] = Data.OBJECT_COMMANDS_2[object.getId()];
								aStringArray833[anInt763] = "@cya@" + Data.OBJECT_NAMES[object.getId()];
								menuActions[anInt763] = 2400;
								anIntArray886[anInt763] = object.getX();
								anIntArray887[anInt763] = object.getY();
								anIntArray844[anInt763] = object.getDirection();
								anIntArray845[anInt763] = object.getId();
								anInt763++;
							}
							aStringArray676[anInt763] = "Examine";
							aStringArray833[anInt763] = "@cya@" + Data.OBJECT_NAMES[object.getId()];
							menuActions[anInt763] = 3400;
							anIntArray844[anInt763] = object.getId();
							anInt763++;
						}
						object.setRightClickShown(true);
					}
				} else {
					if (k1 >= 0)
						k1 = model.anIntArray258[k1] - 0x30d40;
					if (k1 >= 0)
						j = k1;
				}
			}
		}

		if (selectedSpell >= 0 && Data.anIntArray63[selectedSpell] <= 1) {
			aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on self";
			aStringArray833[anInt763] = "";
			menuActions[anInt763] = 1000;
			anIntArray844[anInt763] = selectedSpell;
			anInt763++;
		}
		if (j != -1) {
			if (selectedSpell >= 0) {
				if (Data.anIntArray63[selectedSpell] == 6) {
					aStringArray676[anInt763] = "Cast " + Data.SPELL_NAMES[selectedSpell] + " on ground";
					aStringArray833[anInt763] = "";
					menuActions[anInt763] = 900;
					anIntArray886[anInt763] = landscapeEngine.anIntArray586[j];
					anIntArray887[anInt763] = landscapeEngine.anIntArray605[j];
					anIntArray844[anInt763] = selectedSpell;
					anInt763++;
				}
			} else if (anInt757 < 0) {
				aStringArray676[anInt763] = "Walk here";
				aStringArray833[anInt763] = "";
				menuActions[anInt763] = 920;
				anIntArray886[anInt763] = landscapeEngine.anIntArray586[j];
				anIntArray887[anInt763] = landscapeEngine.anIntArray605[j];
				anInt763++;
			}
		}
	}

	private final void method82() {
		if (selectedSpell >= 0 || anInt757 >= 0) {
			aStringArray676[anInt763] = "Cancel";
			aStringArray833[anInt763] = "";
			menuActions[anInt763] = 4000;
			anInt763++;
		}
		for (int i = 0; i < anInt763; i++) {
			anIntArray925[i] = i;
		}

		for (boolean flag = false; !flag;) {
			flag = true;
			for (int j = 0; j < anInt763 - 1; j++) {
				int l = anIntArray925[j];
				int j1 = anIntArray925[j + 1];
				if (menuActions[l] > menuActions[j1]) {
					anIntArray925[j] = j1;
					anIntArray925[j + 1] = l;
					flag = false;
				}
			}

		}

		if (anInt763 > 20)
			anInt763 = 20;
		if (anInt763 > 0) {
			int k = -1;
			for (int i1 = 0; i1 < anInt763; i1++) {
				if (aStringArray833[anIntArray925[i1]] == null || aStringArray833[anIntArray925[i1]].length() <= 0) {
					continue;
				}
				k = i1;
				break;
			}

			String s = null;
			if ((anInt757 >= 0 || selectedSpell >= 0) && anInt763 == 1) {
				s = "Choose a target";
			} else if ((anInt757 >= 0 || selectedSpell >= 0) && anInt763 > 1) {
				s = "@whi@" + aStringArray676[anIntArray925[0]] + " " + aStringArray833[anIntArray925[0]];
			} else if (k != -1)
				s = aStringArray833[anIntArray925[k]] + ": @whi@" + aStringArray676[anIntArray925[0]];
			if (anInt763 == 2 && s != null)
				s = s + "@whi@ / 1 more option";
			if (anInt763 > 2 && s != null)
				s = s + "@whi@ / " + (anInt763 - 1) + " more options";
			if (s != null)
				gameImage.drawString(s, 6, 14, 1, 0xffff00);
			if (!aBoolean785 && mouseButtonClick == 1 || aBoolean785 && mouseButtonClick == 1 && anInt763 == 1) {
				method70(anIntArray925[0]);
				mouseButtonClick = 0;
				return;
			}
			if (!aBoolean785 && mouseButtonClick == 2 || aBoolean785 && mouseButtonClick == 1) {
				anInt762 = (anInt763 + 1) * 15;
				anInt761 = gameImage.stringWidth("Choose option", 1) + 5;
				for (int k1 = 0; k1 < anInt763; k1++) {
					int l1 = gameImage.stringWidth(aStringArray676[k1] + " " + aStringArray833[k1], 1) + 5;
					if (l1 > anInt761)
						anInt761 = l1;
				}

				anInt759 = super.mouseX - anInt761 / 2;
				anInt760 = super.mouseY - 7;
				aBoolean951 = true;
				if (anInt759 < 0)
					anInt759 = 0;
				if (anInt760 < 0)
					anInt760 = 0;
				if (anInt759 + anInt761 > 510)
					anInt759 = 510 - anInt761;
				if (anInt760 + anInt762 > 315)
					anInt760 = 315 - anInt762;
				mouseButtonClick = 0;
			}
		}
	}

	private final void drawFriendsList(boolean flag) {
		int i = gameImage.defaultMenuWidth - 199;
		int j = 36;
		gameImage.drawSprite(i - 49, 3, Data.SPRITE_OFFSET1 + 5);
		char c = '\304';
		char c1 = '\266';
		int l;
		int k = l = GameImage.method222(160, 160, 160);
		if (anInt991 == 0) {
			k = GameImage.method222(220, 220, 220);
		} else {
			l = GameImage.method222(220, 220, 220);
		}
		gameImage.method213(i, j, c / 2, 24, k, 128);
		gameImage.method213(i + c / 2, j, c / 2, 24, l, 128);
		gameImage.method213(i, j + 24, c, c1 - 24, GameImage.method222(220, 220, 220), 128);
		gameImage.method217(i, j + 24, c, 0);
		gameImage.method218(i + c / 2, j, 24, 0);
		gameImage.method217(i, (j + c1) - 16, c, 0);
		gameImage.drawCenteredString("Friends", i + c / 4, j + 16, 4, 0);
		gameImage.drawCenteredString("Ignore", i + c / 4 + c / 2, j + 16, 4, 0);
		friendsMenu.method164(friendsMenuHandle);
		if (anInt991 == 0) {
			for (int i1 = 0; i1 < super.friendsCount; i1++) {
				String s;
				if (super.friendsOnline[i1] == 99) {
					s = "@gre@";
				} else if (super.friendsOnline[i1] > 0) {
					s = "@yel@";
				} else {
					s = "@red@";
				}
				friendsMenu.method166(friendsMenuHandle, i1, s + DataOperations.hashToUsername(super.friendsHashList[i1]) + "~439~@whi@Remove         WWWWWWWWWW");
			}

		}
		if (anInt991 == 1) {
			for (int j1 = 0; j1 < super.ignoresCount; j1++) {
				friendsMenu.method166(friendsMenuHandle, j1, "@yel@" + DataOperations.hashToUsername(super.ignoresHashList[j1]) + "~439~@whi@Remove         WWWWWWWWWW");
			}

		}
		friendsMenu.drawMenu();
		if (anInt991 == 0) {
			int k1 = friendsMenu.getHighlightedEntry(friendsMenuHandle);
			if (k1 >= 0 && super.mouseX < 489) {
				if (super.mouseX > 429) {
					gameImage.drawCenteredString("Click to remove " + DataOperations.hashToUsername(super.friendsHashList[k1]), i + c / 2, j + 35, 1,
							0xffffff);
				} else if (super.friendsOnline[k1] == 99) {
					gameImage.drawCenteredString("Click to message " + DataOperations.hashToUsername(super.friendsHashList[k1]), i + c / 2, j + 35, 1,
							0xffffff);
				} else if (super.friendsOnline[k1] > 0) {
					gameImage.drawCenteredString(DataOperations.hashToUsername(super.friendsHashList[k1]) + " is on world " + super.friendsOnline[k1], i + c
							/ 2, j + 35, 1, 0xffffff);
				} else {
					gameImage.drawCenteredString(DataOperations.hashToUsername(super.friendsHashList[k1]) + " is offline", i + c / 2, j + 35, 1, 0xffffff);
				}
			} else {
				gameImage.drawCenteredString("Click a name to send a message", i + c / 2, j + 35, 1, 0xffffff);
			}
			int k2;
			if (super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1) {
				k2 = 0xffff00;
			} else {
				k2 = 0xffffff;
			}
			gameImage.drawCenteredString("Click here to add a friend", i + c / 2, (j + c1) - 3, 1, k2);
		}
		if (anInt991 == 1) {
			int l1 = friendsMenu.getHighlightedEntry(friendsMenuHandle);
			if (l1 >= 0 && super.mouseX < 489 && super.mouseX > 429) {
				if (super.mouseX > 429) {
					gameImage.drawCenteredString("Click to remove " + DataOperations.hashToUsername(super.ignoresHashList[l1]), i + c / 2, j + 35, 1,
							0xffffff);
				}
			} else {
				gameImage.drawCenteredString("Blocking messages from:", i + c / 2, j + 35, 1, 0xffffff);
			}
			int l2;
			if (super.mouseX > i && super.mouseX < i + c && super.mouseY > (j + c1) - 16 && super.mouseY < j + c1) {
				l2 = 0xffff00;
			} else {
				l2 = 0xffffff;
			}
			gameImage.drawCenteredString("Click here to add a name", i + c / 2, (j + c1) - 3, 1, l2);
		}
		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 199);
		j = super.mouseY - 36;
		if (i >= 0 && j >= 0 && i < 196 && j < 182) {
			friendsMenu.updateActions(i + (gameImage.defaultMenuWidth - 199), j + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			if (j <= 24 && mouseButtonClick == 1) {
				if (i < 98 && anInt991 == 1) {
					anInt991 = 0;
					friendsMenu.method165(friendsMenuHandle);
				} else if (i > 98 && anInt991 == 0) {
					anInt991 = 1;
					friendsMenu.method165(friendsMenuHandle);
				}
			}
			if (mouseButtonClick == 1 && anInt991 == 0) {
				int i2 = friendsMenu.getHighlightedEntry(friendsMenuHandle);
				if (i2 >= 0 && super.mouseX < 489) {
					if (super.mouseX > 429) {
						removeFriend(super.friendsHashList[i2]);
					} else if (super.friendsOnline[i2] != 0) {
						friendsWindow = 2;
						aLong992 = super.friendsHashList[i2];
						super.inputMessage = "";
						super.aString43 = "";
					}
				}
			}
			if (mouseButtonClick == 1 && anInt991 == 1) {
				int j2 = friendsMenu.getHighlightedEntry(friendsMenuHandle);
				if (j2 >= 0 && super.mouseX < 489 && super.mouseX > 429)
					removeIgnoredUser(super.ignoresHashList[j2]);
			}
			if (j > 166 && mouseButtonClick == 1 && anInt991 == 0) {
				friendsWindow = 1;
				super.inputText = "";
				super.enteredText = "";
			}
			if (j > 166 && mouseButtonClick == 1 && anInt991 == 1) {
				friendsWindow = 3;
				super.inputText = "";
				super.enteredText = "";
			}
			mouseButtonClick = 0;
		}
	}

	private final void drawMagicPrayerMenu(boolean flag) {
		int i = gameImage.defaultMenuWidth - 199;
		int j = 36;
		gameImage.drawSprite(i - 49, 3, Data.SPRITE_OFFSET1 + 4);
		char c = '\304';
		char c1 = '\266';
		int l;
		int k = l = GameImage.method222(160, 160, 160);
		if (magicPrayerSelected == 0) {
			k = GameImage.method222(220, 220, 220);
		} else {
			l = GameImage.method222(220, 220, 220);
		}
		gameImage.method213(i, j, c / 2, 24, k, 128);
		gameImage.method213(i + c / 2, j, c / 2, 24, l, 128);
		gameImage.method213(i, j + 24, c, 90, GameImage.method222(220, 220, 220), 128);
		gameImage.method213(i, j + 24 + 90, c, c1 - 90 - 24, GameImage.method222(160, 160, 160), 128);
		gameImage.method217(i, j + 24, c, 0);
		gameImage.method218(i + c / 2, j, 24, 0);
		gameImage.method217(i, j + 113, c, 0);
		gameImage.drawCenteredString("Magic", i + c / 4, j + 16, 4, 0);
		gameImage.drawCenteredString("Prayers", i + c / 4 + c / 2, j + 16, 4, 0);
		if (magicPrayerSelected == 0) {
			magicPrayerMenu.method164(magicPrayerMenuHandle);
			int i1 = 0;
			for (int i2 = 0; i2 < Data.anInt85; i2++) {
				String s = "@yel@";
				for (int l3 = 0; l3 < Data.SPELL_RUNECOUNT[i2]; l3++) {
					int k4 = Data.SPELL_RUNEIDS[i2][l3];
					if (hasRuneOrStaff(k4, Data.SPELL_RUNEAMOUNTS[i2][l3]))
						continue;
					s = "@whi@";
					break;
				}

				int l4 = ourCurrentSkillLevels[6];
				if (Data.SPELL_LEVELS[i2] > l4)
					s = "@bla@";
				magicPrayerMenu.method166(magicPrayerMenuHandle, i1++, s + "Level " + Data.SPELL_LEVELS[i2] + ": " + Data.SPELL_NAMES[i2]);
			}

			magicPrayerMenu.drawMenu();
			int i3 = magicPrayerMenu.getHighlightedEntry(magicPrayerMenuHandle);
			if (i3 != -1) {
				gameImage.drawString("Level " + Data.SPELL_LEVELS[i3] + ": " + Data.SPELL_NAMES[i3], i + 2, j + 124, 1, 0xffff00);
				gameImage.drawString(Data.SPELL_DESCRIPTIONS[i3], i + 2, j + 136, 0, 0xffffff);
				for (int i4 = 0; i4 < Data.SPELL_RUNECOUNT[i3]; i4++) {
					int i5 = Data.SPELL_RUNEIDS[i3][i4];
					gameImage.drawSprite(i + 2 + i4 * 44, j + 150, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[i5]);
					int j5 = itemAmount(i5);
					int k5 = Data.SPELL_RUNEAMOUNTS[i3][i4];
					String s2 = "@red@";
					if (hasRuneOrStaff(i5, k5))
						s2 = "@gre@";
					gameImage.drawString(s2 + j5 + "/" + k5, i + 2 + i4 * 44, j + 150, 1, 0xffffff);
				}

			} else {
				gameImage.drawString("Point at a spell for a description", i + 2, j + 124, 1, 0);
			}
		}
		if (magicPrayerSelected == 1) {
			magicPrayerMenu.method164(magicPrayerMenuHandle);
			int j1 = 0;
			for (int j2 = 0; j2 < Data.PRAYER_COUNT; j2++) {
				String s1 = "@whi@";
				if (Data.PRAYER_LEVELS[j2] > ourMaximumSkillLevels[5])
					s1 = "@bla@";
				if (selectedPrayers[j2])
					s1 = "@gre@";
				magicPrayerMenu.method166(magicPrayerMenuHandle, j1++, s1 + "Level " + Data.PRAYER_LEVELS[j2] + ": " + Data.PRAYER_NAMES[j2]);
			}

			magicPrayerMenu.drawMenu();
			int j3 = magicPrayerMenu.getHighlightedEntry(magicPrayerMenuHandle);
			if (j3 != -1) {
				gameImage.drawCenteredString("Level " + Data.PRAYER_LEVELS[j3] + ": " + Data.PRAYER_NAMES[j3], i + c / 2, j + 130, 1, 0xffff00);
				gameImage.drawCenteredString(Data.PRAYER_DESCRIPTIONS[j3], i + c / 2, j + 145, 0, 0xffffff);
				gameImage.drawCenteredString("Drain rate: " + Data.anIntArray138[j3], i + c / 2, j + 160, 1, 0);
			} else {
				gameImage.drawString("Point at a prayer for a description", i + 2, j + 124, 1, 0);
			}
		}
		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 199);
		j = super.mouseY - 36;
		if (i >= 0 && j >= 0 && i < 196 && j < 182) {
			magicPrayerMenu.updateActions(i + (gameImage.defaultMenuWidth - 199), j + 36, super.lastMouseButtonDown, super.mouseButtonDown);
			if (j <= 24 && mouseButtonClick == 1) {
				if (i < 98 && magicPrayerSelected == 1) {
					magicPrayerSelected = 0;
					magicPrayerMenu.method165(magicPrayerMenuHandle);
				} else if (i > 98 && magicPrayerSelected == 0) {
					magicPrayerSelected = 1;
					magicPrayerMenu.method165(magicPrayerMenuHandle);
				}
			}
			if (mouseButtonClick == 1 && magicPrayerSelected == 0) {
				int k1 = magicPrayerMenu.getHighlightedEntry(magicPrayerMenuHandle);
				if (k1 != -1) {
					int k2 = ourCurrentSkillLevels[6];
					if (Data.SPELL_LEVELS[k1] > k2) {
						displayMessage("Your magic ability is not high enough for this spell", 3);
					} else {
						int k3;
						for (k3 = 0; k3 < Data.SPELL_RUNECOUNT[k1]; k3++) {
							int j4 = Data.SPELL_RUNEIDS[k1][k3];
							if (hasRuneOrStaff(j4, Data.SPELL_RUNEAMOUNTS[k1][k3]))
								continue;
							displayMessage("You don't have all the reagents you need for this spell", 3);
							k3 = -1;
							break;
						}

						if (k3 == Data.SPELL_RUNECOUNT[k1]) {
							selectedSpell = k1;
							anInt757 = -1;
						}
					}
				}
			}
			if (mouseButtonClick == 1 && magicPrayerSelected == 1) {
				int l1 = magicPrayerMenu.getHighlightedEntry(magicPrayerMenuHandle);
				if (l1 != -1) {
					int l2 = ourMaximumSkillLevels[5];
					if (Data.PRAYER_LEVELS[l1] > l2) {
						displayMessage("Your prayer ability is not high enough for this prayer", 3);
					} else if (ourCurrentSkillLevels[5] == 0) {
						displayMessage("You have run out of prayer points. Return to a church to recharge", 3);
					} else if (selectedPrayers[l1]) {
						super.network.createPacket(248);
						super.network.addByte(l1);
						super.network.formatPacket();
						selectedPrayers[l1] = false;
						playSound("prayeroff");
					} else {
						super.network.createPacket(56);
						super.network.addByte(l1);
						super.network.formatPacket();
						selectedPrayers[l1] = true;
						playSound("prayeron");
					}
				}
			}
			mouseButtonClick = 0;
		}
	}

	private final void method86() {
		if (mouseButtonClick != 0) {
			mouseButtonClick = 0;
			int i = super.mouseX - 52;
			int j = super.mouseY - 44;
			if (i >= 0 && j >= 12 && i < 408 && j < 246) {
				int k = 0;
				for (int i1 = 0; i1 < 5; i1++) {
					for (int i2 = 0; i2 < 8; i2++) {
						int l2 = 7 + i2 * 49;
						int l3 = 28 + i1 * 34;
						if (i > l2 && i < l2 + 49 && j > l3 && j < l3 + 34 && anIntArray849[k] != -1) {
							anInt970 = k;
							anInt971 = anIntArray849[k];
						}
						k++;
					}

				}

				if (anInt970 >= 0) {
					int j2 = anIntArray849[anInt970];
					if (j2 != -1) {
						if (anIntArray850[anInt970] > 0 && i > 298 && j >= 204 && i < 408 && j <= 215) {
							int i3 = anInt957 + anIntArray851[anInt970];
							if (i3 < 10)
								i3 = 10;
							int i4 = (i3 * Data.ITEM_PRICES[j2]) / 100;
							super.network.createPacket(128);
							super.network.addShort(anIntArray849[anInt970]);
							super.network.addInteger(i4);
							super.network.formatPacket();
						}
						if (itemAmount(j2) > 0 && i > 2 && j >= 229 && i < 112 && j <= 240) {
							int j3 = anInt956 + anIntArray851[anInt970];
							if (j3 < 10)
								j3 = 10;
							int j4 = (j3 * Data.ITEM_PRICES[j2]) / 100;
							super.network.createPacket(255);
							super.network.addShort(anIntArray849[anInt970]);
							super.network.addInteger(j4);
							super.network.formatPacket();
						}
					}
				}
			} else {
				super.network.createPacket(253);
				super.network.formatPacket();
				aBoolean940 = false;
				return;
			}
		}
		byte byte0 = 52;
		byte byte1 = 44;
		gameImage.drawBox(byte0, byte1, 408, 12, 192);
		int l = 0x989898;
		gameImage.method213(byte0, byte1 + 12, 408, 17, l, 160);
		gameImage.method213(byte0, byte1 + 29, 8, 170, l, 160);
		gameImage.method213(byte0 + 399, byte1 + 29, 9, 170, l, 160);
		gameImage.method213(byte0, byte1 + 199, 408, 47, l, 160);
		gameImage.drawString("Buying and selling items", byte0 + 1, byte1 + 10, 1, 0xffffff);
		int j1 = 0xffffff;
		if (super.mouseX > byte0 + 320 && super.mouseY >= byte1 && super.mouseX < byte0 + 408 && super.mouseY < byte1 + 12) {
			j1 = 0xff0000;
		}
		gameImage.method253("Close window", byte0 + 406, byte1 + 10, 1, j1);
		gameImage.drawString("Shops stock in green", byte0 + 2, byte1 + 24, 1, 65280);
		gameImage.drawString("Number you own in blue", byte0 + 135, byte1 + 24, 1, 65535);
		gameImage.drawString("Your money: " + itemAmount(10) + "gp", byte0 + 280, byte1 + 24, 1, 0xffff00);
		int k2 = 0xd0d0d0;
		int k3 = 0;
		for (int k4 = 0; k4 < 5; k4++) {
			for (int l4 = 0; l4 < 8; l4++) {
				int j5 = byte0 + 7 + l4 * 49;
				int i6 = byte1 + 28 + k4 * 34;
				if (anInt970 == k3) {
					gameImage.method213(j5, i6, 49, 34, 0xff0000, 160);
				} else {
					gameImage.method213(j5, i6, 49, 34, k2, 160);
				}
				gameImage.drawBoxEdge(j5, i6, 50, 35, 0);
				if (anIntArray849[k3] != -1) {
					gameImage.spriteClipRoutine4(j5, i6, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray849[k3]],
							Data.ITEM_COLOR_MASKS[anIntArray849[k3]], 0, 0, false);
					gameImage.drawString(String.valueOf(anIntArray850[k3]), j5 + 1, i6 + 10, 1, 65280);
					gameImage.method253(String.valueOf(itemAmount(anIntArray849[k3])), j5 + 47, i6 + 10, 1, 65535);
				}
				k3++;
			}

		}

		gameImage.method217(byte0 + 5, byte1 + 222, 398, 0);
		if (anInt970 == -1) {
			gameImage.drawCenteredString("Select an object to buy or sell", byte0 + 204, byte1 + 214, 3, 0xffff00);
			return;
		}
		int i5 = anIntArray849[anInt970];
		if (i5 != -1) {
			if (anIntArray850[anInt970] > 0) {
				int k5 = anInt957 + anIntArray851[anInt970];
				if (k5 < 10)
					k5 = 10;
				int j6 = (k5 * Data.ITEM_PRICES[i5]) / 100;
				gameImage.drawString("Buy a new " + Data.ITEM_NAMES[i5] + " for " + j6 + "gp", byte0 + 2, byte1 + 214, 1, 0xffff00);
				int k1 = 0xffffff;
				if (super.mouseX > byte0 + 298 && super.mouseY >= byte1 + 204 && super.mouseX < byte0 + 408 && super.mouseY <= byte1 + 215) {
					k1 = 0xff0000;
				}
				gameImage.method253("Click here to buy", byte0 + 405, byte1 + 214, 3, k1);
			} else {
				gameImage.drawCenteredString("This item is not currently available to buy", byte0 + 204, byte1 + 214, 3, 0xffff00);
			}
			if (itemAmount(i5) > 0) {
				int l5 = anInt956 + anIntArray851[anInt970];
				if (l5 < 10)
					l5 = 10;
				int k6 = (l5 * Data.ITEM_PRICES[i5]) / 100;
				gameImage.method253("Sell your " + Data.ITEM_NAMES[i5] + " for " + k6 + "gp", byte0 + 405, byte1 + 239, 1, 0xffff00);
				int l1 = 0xffffff;
				if (super.mouseX > byte0 + 2 && super.mouseY >= byte1 + 229 && super.mouseX < byte0 + 112 && super.mouseY <= byte1 + 240) {
					l1 = 0xff0000;
				}
				gameImage.drawString("Click here to sell", byte0 + 2, byte1 + 239, 3, l1);
				return;
			}
			gameImage.drawCenteredString("You do not have any of this item to sell", byte0 + 204, byte1 + 239, 3, 0xffff00);
		}
	}

	private final void method87() {
		gameMenu = new Menu(gameImage, 10);
		anInt812 = gameMenu.method159(5, 269, 502, 56, 1, 20, true);
		chatMessageBoxHandle = gameMenu.method160(7, 324, 498, 14, 1, 80, false, true);
		anInt814 = gameMenu.method159(5, 269, 502, 56, 1, 20, true);
		anInt815 = gameMenu.method159(5, 269, 502, 56, 1, 20, true);
		gameMenu.setFocus(chatMessageBoxHandle);
	}

	private final void method88(boolean flag) {
		int i = gameImage.defaultMenuWidth - 199;
		int j = 36;
		gameImage.drawSprite(i - 49, 3, Data.SPRITE_OFFSET1 + 6);
		char c = '\304';
		gameImage.method213(i, 36, c, 65, GameImage.method222(181, 181, 181), 160);
		gameImage.method213(i, 101, c, 65, GameImage.method222(201, 201, 201), 160);
		gameImage.method213(i, 166, c, 95, GameImage.method222(181, 181, 181), 160);
		gameImage.method213(i, 261, c, 40, GameImage.method222(201, 201, 201), 160);
		int k = i + 3;
		int i1 = j + 15;
		gameImage.drawString("Game options - click to toggle", k, i1, 1, 0);
		i1 += 15;
		if (aBoolean666) {
			gameImage.drawString("Camera angle mode - @gre@Auto", k, i1, 1, 0xffffff);
		} else {
			gameImage.drawString("Camera angle mode - @red@Manual", k, i1, 1, 0xffffff);
		}
		i1 += 15;
		if (aBoolean785) {
			gameImage.drawString("Mouse buttons - @red@One", k, i1, 1, 0xffffff);
		} else {
			gameImage.drawString("Mouse buttons - @gre@Two", k, i1, 1, 0xffffff);
		}
		i1 += 15;
		if (member) {
			if (aBoolean950) {
				gameImage.drawString("Sound effects - @red@off", k, i1, 1, 0xffffff);
			} else {
				gameImage.drawString("Sound effects - @gre@on", k, i1, 1, 0xffffff);
			}
		}
		i1 += 15;
		gameImage.drawString("To change your contact details,", k, i1, 0, 0xffffff);
		i1 += 15;
		gameImage.drawString("password, recovery questions, etc..", k, i1, 0, 0xffffff);
		i1 += 15;
		gameImage.drawString("please select 'account management'", k, i1, 0, 0xffffff);
		i1 += 15;
		if (anInt909 == 0) {
			gameImage.drawString("from the runescape.com front page", k, i1, 0, 0xffffff);
		} else if (anInt909 == 1) {
			gameImage.drawString("from the link below the gamewindow", k, i1, 0, 0xffffff);
		} else {
			gameImage.drawString("from the runescape front webpage", k, i1, 0, 0xffffff);
		}
		i1 += 15;
		i1 += 5;
		gameImage.drawString("Privacy settings. Will be applied to", i + 3, i1, 1, 0);
		i1 += 15;
		gameImage.drawString("all people not on your friends list", i + 3, i1, 1, 0);
		i1 += 15;
		if (super.blockChatMessages == 0) {
			gameImage.drawString("Block chat messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		} else {
			gameImage.drawString("Block chat messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		}
		i1 += 15;
		if (super.blockPrivateMessages == 0) {
			gameImage.drawString("Block private messages: @red@<off>", i + 3, i1, 1, 0xffffff);
		} else {
			gameImage.drawString("Block private messages: @gre@<on>", i + 3, i1, 1, 0xffffff);
		}
		i1 += 15;
		if (super.blockTradeRequests == 0) {
			gameImage.drawString("Block trade requests: @red@<off>", i + 3, i1, 1, 0xffffff);
		} else {
			gameImage.drawString("Block trade requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
		}
		i1 += 15;
		if (member) {
			if (super.blockDuelRequests == 0) {
				gameImage.drawString("Block duel requests: @red@<off>", i + 3, i1, 1, 0xffffff);
			} else {
				gameImage.drawString("Block duel requests: @gre@<on>", i + 3, i1, 1, 0xffffff);
			}
		}
		i1 += 15;
		i1 += 5;
		gameImage.drawString("Always logout when you finish", k, i1, 1, 0);
		i1 += 15;
		int k1 = 0xffffff;
		if (super.mouseX > k && super.mouseX < k + c && super.mouseY > i1 - 12 && super.mouseY < i1 + 4) {
			k1 = 0xffff00;
		}
		gameImage.drawString("Click here to logout", i + 3, i1, 1, k1);
		if (!flag)
			return;
		i = super.mouseX - (gameImage.defaultMenuWidth - 199);
		j = super.mouseY - 36;
		if (i >= 0 && j >= 0 && i < 196 && j < 265) {
			int l1 = gameImage.defaultMenuWidth - 199;
			byte byte0 = 36;
			char c1 = '\304';
			int l = l1 + 3;
			int j1 = byte0 + 30;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				aBoolean666 = !aBoolean666;
				super.network.createPacket(157);
				super.network.addByte(0);
				super.network.addByte(aBoolean666 ? 1 : 0);
				super.network.formatPacket();
			}
			j1 += 15;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				aBoolean785 = !aBoolean785;
				super.network.createPacket(157);
				super.network.addByte(2);
				super.network.addByte(aBoolean785 ? 1 : 0);
				super.network.formatPacket();
			}
			j1 += 15;
			if (member && super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				aBoolean950 = !aBoolean950;
				super.network.createPacket(157);
				super.network.addByte(3);
				super.network.addByte(aBoolean950 ? 1 : 0);
				super.network.formatPacket();
			}
			j1 += 15;
			j1 += 15;
			j1 += 15;
			j1 += 15;
			j1 += 15;
			boolean flag1 = false;
			j1 += 35;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.blockChatMessages = 1 - super.blockChatMessages;
				flag1 = true;
			}
			j1 += 15;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.blockPrivateMessages = 1 - super.blockPrivateMessages;
				flag1 = true;
			}
			j1 += 15;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.blockTradeRequests = 1 - super.blockTradeRequests;
				flag1 = true;
			}
			j1 += 15;
			if (member && super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				super.blockDuelRequests = 1 - super.blockDuelRequests;
				flag1 = true;
			}
			j1 += 15;
			if (flag1)
				sendBlockedRequests(super.blockChatMessages, super.blockPrivateMessages, super.blockTradeRequests, super.blockDuelRequests);
			j1 += 20;
			if (super.mouseX > l && super.mouseX < l + c1 && super.mouseY > j1 - 12 && super.mouseY < j1 + 4 && mouseButtonClick == 1) {
				requestLogout();
			}
			mouseButtonClick = 0;
		}
	}

	private final void method90() {
		try {
			aByteArray977 = loadData("sounds.ptp", "Sound-Effects", 90);
			soundPlayer = new SoundPlayer();
		} catch (Throwable throwable) {
			System.out.println("Unable to init sounds:" + throwable);
		}
	}

	private final void method91() {
		byte byte0 = 7;
		byte byte1 = 15;
		char c = '\257';
		if (mouseButtonClick != 0) {
			for (int i = 0; i < 5; i++) {
				if (i <= 0 || super.mouseX <= byte0 || super.mouseX >= byte0 + c || super.mouseY <= byte1 + i * 20 || super.mouseY >= byte1 + i * 20 + 20) {
					continue;
				}
				anInt775 = i - 1;
				mouseButtonClick = 0;
				super.network.createPacket(41);
				super.network.addByte(anInt775);
				super.network.formatPacket();
				break;
			}

		}
		for (int j = 0; j < 5; j++) {
			if (j == anInt775 + 1) {
				gameImage.method213(byte0, byte1 + j * 20, c, 20, GameImage.method222(255, 0, 0), 128);
			} else {
				gameImage.method213(byte0, byte1 + j * 20, c, 20, GameImage.method222(190, 190, 190), 128);
			}
			gameImage.method217(byte0, byte1 + j * 20, c, 0);
			gameImage.method217(byte0, byte1 + j * 20 + 20, c, 0);
		}

		gameImage.drawCenteredString("Select combat style", byte0 + c / 2, byte1 + 16, 3, 0xffffff);
		gameImage.drawCenteredString("Controlled (+1 of each)", byte0 + c / 2, byte1 + 36, 3, 0);
		gameImage.drawCenteredString("Aggressive (+3 strength)", byte0 + c / 2, byte1 + 56, 3, 0);
		gameImage.drawCenteredString("Accurate   (+3 attack)", byte0 + c / 2, byte1 + 76, 3, 0);
		gameImage.drawCenteredString("Defensive  (+3 defense)", byte0 + c / 2, byte1 + 96, 3, 0);
	}

	private final void method92() {
		landscapeEngine.aByteArray593 = loadData("maps.ftp", "Map", 70);
		if (member)
			landscapeEngine.aByteArray610 = loadData("maps.ptp", "Members-Map", 75);
		landscapeEngine.aByteArray592 = loadData("land.ftp", "Landscape", 80);
		if (member)
			landscapeEngine.aByteArray609 = loadData("land.ptp", "Members-Landscape", 85);
	}

	private final void method93() {
		byte byte0 = 22;
		byte byte1 = 36;
		gameImage.drawBox(byte0, byte1, 468, 16, 192);
		int i = 0x989898;
		gameImage.method213(byte0, byte1 + 16, 468, 246, i, 160);
		gameImage.drawCenteredString("Please confirm your duel with @yel@" + DataOperations.hashToUsername(aLong993), byte0 + 234, byte1 + 12, 1, 0xffffff);
		gameImage.drawCenteredString("Your stake:", byte0 + 117, byte1 + 30, 1, 0xffff00);
		for (int j = 0; j < anInt872; j++) {
			String s = Data.ITEM_NAMES[anIntArray873[j]];
			if (Data.ITEM_STACKABLE[anIntArray873[j]] == 0)
				s = s + " x " + formatMoney(anIntArray874[j]);
			gameImage.drawCenteredString(s, byte0 + 117, byte1 + 42 + j * 12, 1, 0xffffff);
		}

		if (anInt872 == 0)
			gameImage.drawCenteredString("Nothing!", byte0 + 117, byte1 + 42, 1, 0xffffff);
		gameImage.drawCenteredString("Your opponent's stake:", byte0 + 351, byte1 + 30, 1, 0xffff00);
		for (int k = 0; k < anInt793; k++) {
			String s1 = Data.ITEM_NAMES[anIntArray794[k]];
			if (Data.ITEM_STACKABLE[anIntArray794[k]] == 0)
				s1 = s1 + " x " + formatMoney(anIntArray795[k]);
			gameImage.drawCenteredString(s1, byte0 + 351, byte1 + 42 + k * 12, 1, 0xffffff);
		}

		if (anInt793 == 0)
			gameImage.drawCenteredString("Nothing!", byte0 + 351, byte1 + 42, 1, 0xffffff);
		if (anInt739 == 0) {
			gameImage.drawCenteredString("You can retreat from this duel", byte0 + 234, byte1 + 180, 1, 65280);
		} else {
			gameImage.drawCenteredString("No retreat is possible!", byte0 + 234, byte1 + 180, 1, 0xff0000);
		}
		if (anInt740 == 0) {
			gameImage.drawCenteredString("Magic may be used", byte0 + 234, byte1 + 192, 1, 65280);
		} else {
			gameImage.drawCenteredString("Magic cannot be used", byte0 + 234, byte1 + 192, 1, 0xff0000);
		}
		if (anInt741 == 0) {
			gameImage.drawCenteredString("Prayer may be used", byte0 + 234, byte1 + 204, 1, 65280);
		} else {
			gameImage.drawCenteredString("Prayer cannot be used", byte0 + 234, byte1 + 204, 1, 0xff0000);
		}
		if (anInt742 == 0) {
			gameImage.drawCenteredString("Weapons may be used", byte0 + 234, byte1 + 216, 1, 65280);
		} else {
			gameImage.drawCenteredString("Weapons cannot be used", byte0 + 234, byte1 + 216, 1, 0xff0000);
		}
		gameImage.drawCenteredString("If you are sure click 'Accept' to begin the duel", byte0 + 234, byte1 + 230, 1, 0xffffff);
		if (!aBoolean945) {
			gameImage.drawSprite((byte0 + 118) - 35, byte1 + 238, Data.SPRITE_OFFSET1 + 25);
			gameImage.drawSprite((byte0 + 352) - 35, byte1 + 238, Data.SPRITE_OFFSET1 + 26);
		} else {
			gameImage.drawCenteredString("Waiting for other player...", byte0 + 234, byte1 + 250, 1, 0xffff00);
		}
		if (mouseButtonClick == 1) {
			if (super.mouseX < byte0 || super.mouseY < byte1 || super.mouseX > byte0 + 468 || super.mouseY > byte1 + 262) {
				aBoolean944 = false;
				super.network.createPacket(216);
				super.network.formatPacket();
			}
			if (super.mouseX >= (byte0 + 118) - 35 && super.mouseX <= byte0 + 118 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				aBoolean945 = true;
				super.network.createPacket(87);
				super.network.formatPacket();
			}
			if (super.mouseX >= (byte0 + 352) - 35 && super.mouseX <= byte0 + 353 + 70 && super.mouseY >= byte1 + 238 && super.mouseY <= byte1 + 238 + 21) {
				aBoolean944 = false;
				super.network.createPacket(35);
				super.network.formatPacket();
			}
			mouseButtonClick = 0;
		}
	}

	private final void method94() {
		anInt853 = anInt770;
		for (int i = 0; i < anInt770; i++) {
			anIntArray915[i] = anIntArray870[i];
			anIntArray916[i] = anIntArray871[i];
		}

		for (int j = 0; j < inventorySize; j++) {
			if (anInt853 >= anInt724)
				break;
			int k = inventoryItems[j];
			boolean flag = false;
			for (int l = 0; l < anInt853; l++) {
				if (anIntArray915[l] != k)
					continue;
				flag = true;
				break;
			}

			if (!flag) {
				anIntArray915[anInt853] = k;
				anIntArray916[anInt853] = 0;
				anInt853++;
			}
		}

	}

	private final void method95() {
		characterDesignMenu = new Menu(gameImage, 100);
		characterDesignMenu.drawText(256, 10, "Please design Your Character", 4, true);
		int i = 140;
		int j = 34;
		i += 116;
		j -= 10;
		characterDesignMenu.drawText(i - 55, j + 110, "Front", 3, true);
		characterDesignMenu.drawText(i, j + 110, "Side", 3, true);
		characterDesignMenu.drawText(i + 55, j + 110, "Back", 3, true);
		byte byte0 = 54;
		j += 145;
		characterDesignMenu.method157(i - byte0, j, 53, 41);
		characterDesignMenu.drawText(i - byte0, j - 8, "Head", 1, true);
		characterDesignMenu.drawText(i - byte0, j + 8, "Type", 1, true);
		characterDesignMenu.method158(i - byte0 - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignHeadButtonLeft = characterDesignMenu.makeButton(i - byte0 - 40, j, 20, 20);
		characterDesignMenu.method158((i - byte0) + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignHeadButtonRight = characterDesignMenu.makeButton((i - byte0) + 40, j, 20, 20);
		characterDesignMenu.method157(i + byte0, j, 53, 41);
		characterDesignMenu.drawText(i + byte0, j - 8, "Hair", 1, true);
		characterDesignMenu.drawText(i + byte0, j + 8, "Color", 1, true);
		characterDesignMenu.method158((i + byte0) - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignHairColorButtonLeft = characterDesignMenu.makeButton((i + byte0) - 40, j, 20, 20);
		characterDesignMenu.method158(i + byte0 + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignHairColorButtonRight = characterDesignMenu.makeButton(i + byte0 + 40, j, 20, 20);
		j += 50;
		characterDesignMenu.method157(i - byte0, j, 53, 41);
		characterDesignMenu.drawText(i - byte0, j, "Gender", 1, true);
		characterDesignMenu.method158(i - byte0 - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignGenderButtonLeft = characterDesignMenu.makeButton(i - byte0 - 40, j, 20, 20);
		characterDesignMenu.method158((i - byte0) + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignGenderButtonRight = characterDesignMenu.makeButton((i - byte0) + 40, j, 20, 20);
		characterDesignMenu.method157(i + byte0, j, 53, 41);
		characterDesignMenu.drawText(i + byte0, j - 8, "Top", 1, true);
		characterDesignMenu.drawText(i + byte0, j + 8, "Color", 1, true);
		characterDesignMenu.method158((i + byte0) - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignTopColorButtonLeft = characterDesignMenu.makeButton((i + byte0) - 40, j, 20, 20);
		characterDesignMenu.method158(i + byte0 + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignTopColorButtonRight = characterDesignMenu.makeButton(i + byte0 + 40, j, 20, 20);
		j += 50;
		characterDesignMenu.method157(i - byte0, j, 53, 41);
		characterDesignMenu.drawText(i - byte0, j - 8, "Skin", 1, true);
		characterDesignMenu.drawText(i - byte0, j + 8, "Color", 1, true);
		characterDesignMenu.method158(i - byte0 - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignSkinColorButtonLeft = characterDesignMenu.makeButton(i - byte0 - 40, j, 20, 20);
		characterDesignMenu.method158((i - byte0) + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignSkinColorButtonRight = characterDesignMenu.makeButton((i - byte0) + 40, j, 20, 20);
		characterDesignMenu.method157(i + byte0, j, 53, 41);
		characterDesignMenu.drawText(i + byte0, j - 8, "Bottom", 1, true);
		characterDesignMenu.drawText(i + byte0, j + 8, "Color", 1, true);
		characterDesignMenu.method158((i + byte0) - 40, j, Data.SPRITE_OFFSET2 + 7);
		characterDesignBottomColorButtonLeft = characterDesignMenu.makeButton((i + byte0) - 40, j, 20, 20);
		characterDesignMenu.method158(i + byte0 + 40, j, Data.SPRITE_OFFSET2 + 6);
		characterDesignBottomColorButtonRight = characterDesignMenu.makeButton(i + byte0 + 40, j, 20, 20);
		j += 82;
		j -= 35;
		characterDesignMenu.drawBox(i, j, 200, 30);
		characterDesignMenu.drawText(i, j, "Accept", 4, false);
		characterDesignAcceptButton = characterDesignMenu.makeButton(i, j, 200, 30);
	}

	private final void method96() {
		if (super.enteredText.length() > 0) {
			String s = super.enteredText.trim();
			super.inputText = "";
			super.enteredText = "";
			if (s.length() > 0) {
				long l = DataOperations.usernameToHash(s);
				super.network.createPacket(7);
				super.network.addTwoIntegers(l);
				super.network.addByte(abuseType);
				super.network.addByte(aBoolean840 ? 1 : 0);
				super.network.formatPacket();
			}
			abuseWindow = 0;
			return;
		}
		gameImage.drawBox(56, 130, 400, 100, 0);
		gameImage.drawBoxEdge(56, 130, 400, 100, 0xffffff);
		int i = 160;
		gameImage.drawCenteredString("Now type the name of the offending player, and press enter", 256, i, 1, 0xffff00);
		i += 18;
		gameImage.drawCenteredString("Name: " + super.inputText + "*", 256, i, 4, 0xffffff);
		if (super.priviliges > 0) {
			i = 207;
			if (aBoolean840) {
				gameImage.drawCenteredString("Moderator option: Mute player for 48 hours: <ON>", 256, i, 1, 0xff8000);
			} else {
				gameImage.drawCenteredString("Moderator option: Mute player for 48 hours: <OFF>", 256, i, 1, 0xffffff);
			}
			if (super.mouseX > 106 && super.mouseX < 406 && super.mouseY > i - 13 && super.mouseY < i + 2 && mouseButtonClick == 1) {
				mouseButtonClick = 0;
				aBoolean840 = !aBoolean840;
			}
		}
		i = 222;
		int j = 0xffffff;
		if (super.mouseX > 196 && super.mouseX < 316 && super.mouseY > i - 13 && super.mouseY < i + 2) {
			j = 0xffff00;
			if (mouseButtonClick == 1) {
				mouseButtonClick = 0;
				abuseWindow = 0;
			}
		}
		gameImage.drawCenteredString("Click here to cancel", 256, i, 1, j);
		if (mouseButtonClick == 1 && (super.mouseX < 56 || super.mouseX > 456 || super.mouseY < 130 || super.mouseY > 230)) {
			mouseButtonClick = 0;
			abuseWindow = 0;
		}
	}

	private final void method99() {
		if (mouseButtonClick != 0 && anInt894 == 0)
			anInt894 = 1;
		if (anInt894 > 0) {
			int i = super.mouseX - 22;
			int j = super.mouseY - 36;
			if (i >= 0 && j >= 0 && i < 468 && j < 262) {
				if (i > 216 && j > 30 && i < 462 && j < 235) {
					int k = (i - 217) / 49 + ((j - 31) / 34) * 5;
					if (k >= 0 && k < inventorySize) {
						boolean flag = false;
						int l1 = 0;
						int k2 = inventoryItems[k];
						for (int k3 = 0; k3 < tradeOurItemCount; k3++) {
							if (anIntArray983[k3] == k2) {
								if (Data.ITEM_STACKABLE[k2] == 0) {
									for (int i4 = 0; i4 < anInt894; i4++) {
										if (anIntArray984[k3] < inventoryItemAmount[k])
											anIntArray984[k3]++;
										flag = true;
									}

								} else {
									l1++;
								}
							}
						}

						if (itemAmount(k2) <= l1)
							flag = true;
						if (Data.ITEM_TRADABLE[k2] == 1) {
							displayMessage("This object cannot be traded with other players", 3);
							flag = true;
						}
						if (!flag && tradeOurItemCount < 12) {
							anIntArray983[tradeOurItemCount] = k2;
							anIntArray984[tradeOurItemCount] = 1;
							tradeOurItemCount++;
							flag = true;
						}
						if (flag) {
							super.network.createPacket(70);
							super.network.addByte(tradeOurItemCount);
							for (int j4 = 0; j4 < tradeOurItemCount; j4++) {
								super.network.addShort(anIntArray983[j4]);
								super.network.addInteger(anIntArray984[j4]);
							}

							super.network.formatPacket();
							tradeTheyAccepted = false;
							tradeWeAccepted = false;
						}
					}
				}
				if (i > 8 && j > 30 && i < 205 && j < 133) {
					int l = (i - 9) / 49 + ((j - 31) / 34) * 4;
					if (l >= 0 && l < tradeOurItemCount) {
						int j1 = anIntArray983[l];
						for (int i2 = 0; i2 < anInt894; i2++) {
							if (Data.ITEM_STACKABLE[j1] == 0 && anIntArray984[l] > 1) {
								anIntArray984[l]--;
								continue;
							}
							tradeOurItemCount--;
							anInt893 = 0;
							for (int l2 = l; l2 < tradeOurItemCount; l2++) {
								anIntArray983[l2] = anIntArray983[l2 + 1];
								anIntArray984[l2] = anIntArray984[l2 + 1];
							}

							break;
						}

						super.network.createPacket(70);
						super.network.addByte(tradeOurItemCount);
						for (int i3 = 0; i3 < tradeOurItemCount; i3++) {
							super.network.addShort(anIntArray983[i3]);
							super.network.addInteger(anIntArray984[i3]);
						}

						super.network.formatPacket();
						tradeTheyAccepted = false;
						tradeWeAccepted = false;
					}
				}
				if (i >= 217 && j >= 238 && i <= 286 && j <= 259) {
					tradeWeAccepted = true;
					super.network.createPacket(211);
					super.network.formatPacket();
				}
				if (i >= 394 && j >= 238 && i < 463 && j < 259) {
					showTradeScreen = false;
					super.network.createPacket(216);
					super.network.formatPacket();
				}
			} else if (mouseButtonClick != 0) {
				showTradeScreen = false;
				super.network.createPacket(216);
				super.network.formatPacket();
			}
			mouseButtonClick = 0;
			anInt894 = 0;
		}
		if (!showTradeScreen)
			return;
		byte byte0 = 22;
		byte byte1 = 36;
		gameImage.drawBox(byte0, byte1, 468, 12, 192);
		int i1 = 0x989898;
		gameImage.method213(byte0, byte1 + 12, 468, 18, i1, 160);
		gameImage.method213(byte0, byte1 + 30, 8, 248, i1, 160);
		gameImage.method213(byte0 + 205, byte1 + 30, 11, 248, i1, 160);
		gameImage.method213(byte0 + 462, byte1 + 30, 6, 248, i1, 160);
		gameImage.method213(byte0 + 8, byte1 + 133, 197, 22, i1, 160);
		gameImage.method213(byte0 + 8, byte1 + 258, 197, 20, i1, 160);
		gameImage.method213(byte0 + 216, byte1 + 235, 246, 43, i1, 160);
		int k1 = 0xd0d0d0;
		gameImage.method213(byte0 + 8, byte1 + 30, 197, 103, k1, 160);
		gameImage.method213(byte0 + 8, byte1 + 155, 197, 103, k1, 160);
		gameImage.method213(byte0 + 216, byte1 + 30, 246, 205, k1, 160);
		for (int j2 = 0; j2 < 4; j2++) {
			gameImage.method217(byte0 + 8, byte1 + 30 + j2 * 34, 197, 0);
		}

		for (int j3 = 0; j3 < 4; j3++) {
			gameImage.method217(byte0 + 8, byte1 + 155 + j3 * 34, 197, 0);
		}

		for (int l3 = 0; l3 < 7; l3++) {
			gameImage.method217(byte0 + 216, byte1 + 30 + l3 * 34, 246, 0);
		}

		for (int k4 = 0; k4 < 6; k4++) {
			if (k4 < 5)
				gameImage.method218(byte0 + 8 + k4 * 49, byte1 + 30, 103, 0);
			if (k4 < 5)
				gameImage.method218(byte0 + 8 + k4 * 49, byte1 + 155, 103, 0);
			gameImage.method218(byte0 + 216 + k4 * 49, byte1 + 30, 205, 0);
		}

		gameImage.drawString("Trading with: " + tradeOpponentName, byte0 + 1, byte1 + 10, 1, 0xffffff);
		gameImage.drawString("Your Offer", byte0 + 9, byte1 + 27, 4, 0xffffff);
		gameImage.drawString("Opponent's Offer", byte0 + 9, byte1 + 152, 4, 0xffffff);
		gameImage.drawString("Your Inventory", byte0 + 216, byte1 + 27, 4, 0xffffff);
		if (!tradeWeAccepted)
			gameImage.drawSprite(byte0 + 217, byte1 + 238, Data.SPRITE_OFFSET1 + 25);
		gameImage.drawSprite(byte0 + 394, byte1 + 238, Data.SPRITE_OFFSET1 + 26);
		if (tradeTheyAccepted) {
			gameImage.drawCenteredString("Other player", byte0 + 341, byte1 + 246, 1, 0xffffff);
			gameImage.drawCenteredString("has accepted", byte0 + 341, byte1 + 256, 1, 0xffffff);
		}
		if (tradeWeAccepted) {
			gameImage.drawCenteredString("Waiting for", byte0 + 217 + 35, byte1 + 246, 1, 0xffffff);
			gameImage.drawCenteredString("other player", byte0 + 217 + 35, byte1 + 256, 1, 0xffffff);
		}
		for (int l4 = 0; l4 < inventorySize; l4++) {
			int i5 = 217 + byte0 + (l4 % 5) * 49;
			int k5 = 31 + byte1 + (l4 / 5) * 34;
			gameImage.spriteClipRoutine4(i5, k5, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[inventoryItems[l4]],
					Data.ITEM_COLOR_MASKS[inventoryItems[l4]], 0, 0, false);
			if (Data.ITEM_STACKABLE[inventoryItems[l4]] == 0) {
				gameImage.drawString(String.valueOf(inventoryItemAmount[l4]), i5 + 1, k5 + 10, 1, 0xffff00);
			}
		}

		for (int j5 = 0; j5 < tradeOurItemCount; j5++) {
			int l5 = 9 + byte0 + (j5 % 4) * 49;
			int j6 = 31 + byte1 + (j5 / 4) * 34;
			gameImage.spriteClipRoutine4(l5, j6, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray983[j5]],
					Data.ITEM_COLOR_MASKS[anIntArray983[j5]], 0, 0, false);
			if (Data.ITEM_STACKABLE[anIntArray983[j5]] == 0) {
				gameImage.drawString(String.valueOf(anIntArray984[j5]), l5 + 1, j6 + 10, 1, 0xffff00);
			}
			if (super.mouseX > l5 && super.mouseX < l5 + 48 && super.mouseY > j6 && super.mouseY < j6 + 32) {
				gameImage.drawString(Data.ITEM_NAMES[anIntArray983[j5]] + ": @whi@" + Data.ITEM_DESCRIPTIONS[anIntArray983[j5]], byte0 + 8, byte1 + 273, 1,
						0xffff00);
			}
		}

		for (int i6 = 0; i6 < tradeTheirItemCount; i6++) {
			int k6 = 9 + byte0 + (i6 % 4) * 49;
			int l6 = 156 + byte1 + (i6 / 4) * 34;
			gameImage.spriteClipRoutine4(k6, l6, 48, 32, Data.SPRITE_OFFSET3 + Data.ITEM_SPRITES[anIntArray923[i6]],
					Data.ITEM_COLOR_MASKS[anIntArray923[i6]], 0, 0, false);
			if (Data.ITEM_STACKABLE[anIntArray923[i6]] == 0) {
				gameImage.drawString(String.valueOf(anIntArray924[i6]), k6 + 1, l6 + 10, 1, 0xffff00);
			}
			if (super.mouseX > k6 && super.mouseX < k6 + 48 && super.mouseY > l6 && super.mouseY < l6 + 32) {
				gameImage.drawString(Data.ITEM_NAMES[anIntArray923[i6]] + ": @whi@" + Data.ITEM_DESCRIPTIONS[anIntArray923[i6]], byte0 + 8, byte1 + 273, 1,
						0xffff00);
			}
		}

	}

	public final void mouseClick(int i, int j, int k) {
		mouseClickXArray[mouseClickArrayOffset] = j;
		mouseClickYArray[mouseClickArrayOffset] = k;
		mouseClickArrayOffset = mouseClickArrayOffset + 1 & 0x1fff;
		for (int l = 10; l < 4000; l++) {
			int i1 = mouseClickArrayOffset - l & 0x1fff;
			if (mouseClickXArray[i1] == j && mouseClickYArray[i1] == k) {
				boolean flag = false;
				for (int j1 = 1; j1 < l; j1++) {
					int k1 = mouseClickArrayOffset - j1 & 0x1fff;
					int l1 = i1 - j1 & 0x1fff;
					if (mouseClickXArray[l1] != j || mouseClickYArray[l1] != k)
						flag = true;
					if (mouseClickXArray[k1] != mouseClickXArray[l1] || mouseClickYArray[k1] != mouseClickYArray[l1])
						break;
					if (j1 == l - 1 && flag && lastWalkTimeout == 0 && loginTimeout == 0) {
						requestLogout();
						return;
					}
				}

			}
		}

	}

	private final void playSound(String s) {
		if (soundPlayer == null)
			return;
		if (!aBoolean950) {
			soundPlayer.loadSoundData(aByteArray977, DataOperations.unpackCacheData(s + ".pcm", aByteArray977), DataOperations.method364(s + ".pcm",
					aByteArray977));
		}
	}

	/*
	 * Draws the screen to change your characters looks
	 */
	private final void processCharacterDesignMenu() {
		characterDesignMenu.updateActions(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
		if (characterDesignMenu.hasActivated(characterDesignHeadButtonLeft)) {
			do {
				characterHeadType = ((characterHeadType - 1) + Data.ANIMATION_COUNT) % Data.ANIMATION_COUNT;
			} while ((Data.ANIMATION_GENDERS[characterHeadType] & 3) != 1 || (Data.ANIMATION_GENDERS[characterHeadType] & 4 * characterHeadGender) == 0);
		}
		if (characterDesignMenu.hasActivated(characterDesignHeadButtonRight)) {
			do {
				characterHeadType = (characterHeadType + 1) % Data.ANIMATION_COUNT;
			} while ((Data.ANIMATION_GENDERS[characterHeadType] & 3) != 1 || (Data.ANIMATION_GENDERS[characterHeadType] & 4 * characterHeadGender) == 0);
		}
		if (characterDesignMenu.hasActivated(characterDesignHairColorButtonLeft))
			characterHairColor = ((characterHairColor - 1) + HAIR_COLORS.length) % HAIR_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignHairColorButtonRight))
			characterHairColor = (characterHairColor + 1) % HAIR_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignGenderButtonLeft) || characterDesignMenu.hasActivated(characterDesignGenderButtonRight)) {
			characterHeadGender = 3 - characterHeadGender;
			while ((Data.ANIMATION_GENDERS[characterHeadType] & 3) != 1 || (Data.ANIMATION_GENDERS[characterHeadType] & 4 * characterHeadGender) == 0) {
				characterHeadType = (characterHeadType + 1) % Data.ANIMATION_COUNT;
			}
			while ((Data.ANIMATION_GENDERS[characterBodyGender] & 3) != 2 || (Data.ANIMATION_GENDERS[characterBodyGender] & 4 * characterHeadGender) == 0) {
				characterBodyGender = (characterBodyGender + 1) % Data.ANIMATION_COUNT;
			}
		}
		if (characterDesignMenu.hasActivated(characterDesignTopColorButtonLeft))
			characterTopColor = ((characterTopColor - 1) + CLOTHES_COLORS.length) % CLOTHES_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignTopColorButtonRight))
			characterTopColor = (characterTopColor + 1) % CLOTHES_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignSkinColorButtonLeft))
			characterSkinColor = ((characterSkinColor - 1) + SKIN_COLORS.length) % SKIN_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignSkinColorButtonRight))
			characterSkinColor = (characterSkinColor + 1) % SKIN_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignBottomColorButtonLeft))
			characterBottomColor = ((characterBottomColor - 1) + CLOTHES_COLORS.length) % CLOTHES_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignBottomColorButtonRight))
			characterBottomColor = (characterBottomColor + 1) % CLOTHES_COLORS.length;
		if (characterDesignMenu.hasActivated(characterDesignAcceptButton)) {
			super.network.createPacket(218);
			super.network.addByte(characterHeadGender);
			super.network.addByte(characterHeadType);
			super.network.addByte(characterBodyGender);
			super.network.addByte(characterBodyType);
			super.network.addByte(characterHairColor);
			super.network.addByte(characterTopColor);
			super.network.addByte(characterBottomColor);
			super.network.addByte(characterSkinColor);
			super.network.formatPacket();
			gameImage.refreshPixels();
			showCharacterDesignMenu = false;
		}
	}

	private final void processGame() {
		if (systemUpdateTimer > 1)
			systemUpdateTimer--;
		processNetworking();
		if (loginTimeout > 0)
			loginTimeout--;
		if (super.lastActionTimeout > 4500 && lastWalkTimeout == 0 && loginTimeout == 0) {
			super.lastActionTimeout -= 500;
			requestLogout();
			return;
		}
		if (ourPlayer.getCurrentSprite() == 8 || ourPlayer.getCurrentSprite() == 9)
			lastWalkTimeout = 500;
		if (lastWalkTimeout > 0)
			lastWalkTimeout--;
		if (showCharacterDesignMenu) {
			processCharacterDesignMenu();
			return;
		}
		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player player = e.getValue();
			int k = (player.getPathCurrent() + 1) % 10;
			if (player.getPathEnd() != k) {
				int i1 = -1;
				int l2 = player.getPathEnd();
				int j4;
				if (l2 < k) {
					j4 = k - l2;
				} else {
					j4 = (10 + k) - l2;
				}
				int j5 = 4;
				if (j4 > 2)
					j5 = (j4 - 1) * 4;
				if (player.getPathX()[l2] - player.getX() > 128 * 3 || player.getPathY()[l2] - player.getY() > 128 * 3
						|| player.getPathX()[l2] - player.getX() < -128 * 3 || player.getPathY()[l2] - player.getY() < -128 * 3 || j4 > 8) {
					player.setX(player.getPathX()[l2]);
					player.setY(player.getPathY()[l2]);
				} else {
					if (player.getX() < player.getPathX()[l2]) {
						player.setX(player.getX() + j5);
						player.incStepCount();
						i1 = 2;
					} else if (player.getX() > player.getPathX()[l2]) {
						player.setX(player.getX() - j5);
						player.incStepCount();
						i1 = 6;
					}
					if (player.getX() - player.getPathX()[l2] < j5 && player.getX() - player.getPathX()[l2] > -j5) {
						player.setX(player.getPathX()[l2]);
					}
					if (player.getY() < player.getPathY()[l2]) {
						player.setY(player.getY() + j5);
						player.incStepCount();
						if (i1 == -1) {
							i1 = 4;
						} else if (i1 == 2) {
							i1 = 3;
						} else {
							i1 = 5;
						}
					} else if (player.getY() > player.getPathY()[l2]) {
						player.setY(player.getY() - j5);
						player.incStepCount();
						if (i1 == -1) {
							i1 = 0;
						} else if (i1 == 2) {
							i1 = 1;
						} else {
							i1 = 7;
						}
					}
					if (player.getY() - player.getPathY()[l2] < j5 && player.getY() - player.getPathY()[l2] > -j5) {
						player.setY(player.getPathY()[l2]);
					}
				}
				if (i1 != -1)
					player.setCurrentSprite(i1);
				if (player.getX() == player.getPathX()[l2] && player.getY() == player.getPathY()[l2]) {
					player.setPathEnd((l2 + 1) % 10);
				}
			} else {
				player.setCurrentSprite(player.getNextSprite());
			}
			if (player.getMessageTimer() > 0)
				player.decMessageTimer();
			if (player.getBubbleTimer() > 0)
				player.decBubbleTimer();
			if (player.getHealthBarTimer() > 0)
				player.decHealthBarTimer();
			if (deathScreenTimer > 0) {
				deathScreenTimer--;
				if (deathScreenTimer == 0)
					displayMessage("You have been granted another life. Be more careful this time!", 3);
				if (deathScreenTimer == 0)
					displayMessage("You retain your skills. Your objects land where you died", 3);
			}
		}

		for (Map.Entry<Integer, NPC> e : npcs.entrySet()) {
			NPC npc = e.getValue();
			int j1 = (npc.getPathCurrent() + 1) % 10;
			if (npc.getPathEnd() != j1) {
				int i3 = -1;
				int k4 = npc.getPathEnd();
				int k5;
				if (k4 < j1) {
					k5 = j1 - k4;
				} else {
					k5 = (10 + j1) - k4;
				}
				int l5 = 4;
				if (k5 > 2)
					l5 = (k5 - 1) * 4;
				if (npc.getPathX()[k4] - npc.getX() > 128 * 3 || npc.getPathY()[k4] - npc.getY() > 128 * 3 || npc.getPathX()[k4] - npc.getX() < -128 * 3
						|| npc.getPathY()[k4] - npc.getY() < -128 * 3 || k5 > 8) {
					npc.setX(npc.getPathX()[k4]);
					npc.setY(npc.getPathY()[k4]);
				} else {
					if (npc.getX() < npc.getPathX()[k4]) {
						npc.setX(npc.getX() + l5);
						npc.incStepCount();
						i3 = 2;
					} else if (npc.getX() > npc.getPathX()[k4]) {
						npc.setX(npc.getX() - l5);
						npc.incStepCount();
						i3 = 6;
					}
					if (npc.getX() - npc.getPathX()[k4] < l5 && npc.getX() - npc.getPathX()[k4] > -l5) {
						npc.setX(npc.getPathX()[k4]);
					}
					if (npc.getY() < npc.getPathY()[k4]) {
						npc.setY(npc.getY() + 15);
						npc.incStepCount();
						if (i3 == -1) {
							i3 = 4;
						} else if (i3 == 2) {
							i3 = 3;
						} else {
							i3 = 5;
						}
					} else if (npc.getY() > npc.getPathY()[k4]) {
						npc.setY(npc.getY() - 15);
						npc.incStepCount();
						if (i3 == -1) {
							i3 = 0;
						} else if (i3 == 2) {
							i3 = 1;
						} else {
							i3 = 7;
						}
					}
					if (npc.getY() - npc.getPathY()[k4] < l5 && npc.getY() - npc.getPathY()[k4] > -l5) {
						npc.setY(npc.getPathY()[k4]);
					}
				}
				if (i3 != -1)
					npc.setCurrentSprite(i3);
				if (npc.getX() == npc.getPathX()[k4] && npc.getY() == npc.getPathY()[k4]) {
					npc.setPathEnd((k4 + 1) % 10);
				}
			} else {
				npc.setCurrentSprite(npc.getNextSprite());
				if (npc.getId() == 43)
					npc.incStepCount();
			}
			if (npc.getMessageTimer() > 0)
				npc.decMessageTimer();
			if (npc.getBubbleTimer() > 0)
				npc.decBubbleTimer();
			if (npc.getHealthBarTimer() > 0)
				npc.decHealthBarTimer();
		}

		if (mouseOverMenu != 2) {
			if (GameImage.anInt346 > 0)
				anInt668++;
			if (GameImage.anInt347 > 0)
				anInt668 = 0;
			GameImage.anInt346 = 0;
			GameImage.anInt347 = 0;
		}
		for (Map.Entry<Integer, Player> e : players.entrySet()) {
			Player player = e.getValue();
			if (player.getProjectile() != null && player.getProjectile().getPosition() > 0)
				player.getProjectile().setPosition(player.getProjectile().getPosition() - 1);
		}

		if (aBoolean929) {
			if (anInt879 - ourPlayer.getX() < -500 || anInt879 - ourPlayer.getX() > 500 || anInt880 - ourPlayer.getY() < -500
					|| anInt880 - ourPlayer.getY() > 500) {
				anInt879 = ourPlayer.getX();
				anInt880 = ourPlayer.getY();
			}
		} else {
			if (anInt879 - ourPlayer.getX() < -500 || anInt879 - ourPlayer.getX() > 500 || anInt880 - ourPlayer.getY() < -500
					|| anInt880 - ourPlayer.getY() > 500) {
				anInt879 = ourPlayer.getX();
				anInt880 = ourPlayer.getY();
			}
			if (anInt879 != ourPlayer.getX()) {
				anInt879 += (ourPlayer.getX() - anInt879) / (16 + (anInt913 - 500) / 15);
			}
			if (anInt880 != ourPlayer.getY()) {
				anInt880 += (ourPlayer.getY() - anInt880) / (16 + (anInt913 - 500) / 15);
			}
			if (aBoolean666) {
				int k1 = cameraAutoAngle * 32;
				int j3 = k1 - cameraRotation;
				byte byte0 = 1;
				if (j3 != 0) {
					anInt732++;
					if (j3 > 128) {
						byte0 = -1;
						j3 = 256 - j3;
					} else if (j3 > 0) {
						byte0 = 1;
					} else if (j3 < -128) {
						byte0 = 1;
						j3 = 256 + j3;
					} else if (j3 < 0) {
						byte0 = -1;
						j3 = -j3;
					}
					cameraRotation += ((anInt732 * j3 + 255) / 256) * byte0;
					cameraRotation &= 0xff;
				} else {
					anInt732 = 0;
				}
			}
		}
		if (anInt668 > 20)
			anInt668 = 0;
		if (super.mouseY > clientHeight - 4) {
			if (super.mouseX > 15 && super.mouseX < 96 && super.lastMouseButtonDown == 1)
				anInt816 = 0;
			if (super.mouseX > 110 && super.mouseX < 194 && super.lastMouseButtonDown == 1) {
				anInt816 = 1;
				gameMenu.anIntArray187[anInt812] = 0xf423f;
			}
			if (super.mouseX > 215 && super.mouseX < 295 && super.lastMouseButtonDown == 1) {
				anInt816 = 2;
				gameMenu.anIntArray187[anInt814] = 0xf423f;
			}
			if (super.mouseX > 315 && super.mouseX < 395 && super.lastMouseButtonDown == 1) {
				anInt816 = 3;
				gameMenu.anIntArray187[anInt815] = 0xf423f;
			}
			if (super.mouseX > 417 && super.mouseX < 497 && super.lastMouseButtonDown == 1) {
				abuseWindow = 1;
				abuseType = 0;
				super.inputText = "";
				super.enteredText = "";
			}
			super.lastMouseButtonDown = 0;
			super.mouseButtonDown = 0;
		}
		gameMenu.updateActions(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
		if (anInt816 > 0 && super.mouseX >= 494 && super.mouseY >= clientHeight - 66)
			super.lastMouseButtonDown = 0;
		if (gameMenu.hasActivated(chatMessageBoxHandle)) {
			String s = gameMenu.getText(chatMessageBoxHandle);
			gameMenu.updateText(chatMessageBoxHandle, "");
			if (s.startsWith("::")) {
				if (s.equalsIgnoreCase("::closecon")) {
					super.network.close();
				} else if (s.equalsIgnoreCase("::logout")) {
					sendLogoutPacket();
				} else if (s.equalsIgnoreCase("::lostcon")) {
					lostConnection();
				} else {
					sendCommand(s.substring(2));
				}
			} else {
				int k3 = StringOperations.method399(s);
				sendChatMessage(StringOperations.CHAT_MESSAGE, k3);
				s = StringOperations.bytesToString(StringOperations.CHAT_MESSAGE, 0, k3);
				ourPlayer.setMessageTimer(150);
				ourPlayer.setMessage(s);
				displayMessage(ourPlayer.getName() + ": " + s, 2);
			}
		}
		if (anInt816 == 0) {
			for (int l1 = 0; l1 < 5; l1++) {
				if (anIntArray878[l1] > 0)
					anIntArray878[l1]--;
			}

		}
		if (deathScreenTimer != 0)
			super.lastMouseButtonDown = 0;
		if (showTradeScreen || showDuelScreen) {
			if (super.mouseButtonDown != 0) {
				anInt893++;
			} else {
				anInt893 = 0;
			}
			if (anInt893 > 600) {
				anInt894 += 5000;
			} else if (anInt893 > 450) {
				anInt894 += 500;
			} else if (anInt893 > 300) {
				anInt894 += 50;
			} else if (anInt893 > 150) {
				anInt894 += 5;
			} else if (anInt893 > 50) {
				anInt894++;
			} else if (anInt893 > 20 && (anInt893 & 5) == 0)
				anInt894++;
		} else {
			anInt893 = 0;
			anInt894 = 0;
		}
		if (super.lastMouseButtonDown == 1) {
			mouseButtonClick = 1;
		} else if (super.lastMouseButtonDown == 2)
			mouseButtonClick = 2;
		camera.updateMouseCoords(super.mouseX, super.mouseY);
		super.lastMouseButtonDown = 0;
		if (aBoolean666) {
			if (anInt732 == 0 || aBoolean929) {
				if (super.keyLeftDown) {
					cameraAutoAngle = cameraAutoAngle + 1 & 7;
					super.keyLeftDown = false;
					if (!aBoolean926) {
						if ((cameraAutoAngle & 1) == 0)
							cameraAutoAngle = cameraAutoAngle + 1 & 7;
						for (int i2 = 0; i2 < 8; i2++) {
							if (landscapePlayerVisible(cameraAutoAngle))
								break;
							cameraAutoAngle = cameraAutoAngle + 1 & 7;
						}

					}
				}
				if (super.keyRightDown) {
					cameraAutoAngle = cameraAutoAngle + 7 & 7;
					super.keyRightDown = false;
					if (!aBoolean926) {
						if ((cameraAutoAngle & 1) == 0)
							cameraAutoAngle = cameraAutoAngle + 7 & 7;
						for (int j2 = 0; j2 < 8; j2++) {
							if (landscapePlayerVisible(cameraAutoAngle))
								break;
							cameraAutoAngle = cameraAutoAngle + 7 & 7;
						}

					}
				}
			}
		} else if (super.keyLeftDown) {
			cameraRotation = cameraRotation + 2 & 0xff;
		} else if (super.keyRightDown)
			cameraRotation = cameraRotation - 2 & 0xff;
		if (aBoolean926 && anInt913 > 550) {
			anInt913 -= 4;
		} else if (!aBoolean926 && anInt913 < 750)
			anInt913 += 4;
		if (anInt841 > 0) {
			anInt841--;
		} else if (anInt841 < 0)
			anInt841++;
		camera.method306(17);
		anInt958++;
		if (anInt958 > 5) {
			anInt958 = 0;
			currentFlameSpellModel = (currentFlameSpellModel + 1) % 3;
			currentTorchModel = (currentTorchModel + 1) % 4;
			currentClawSpellModel = (currentClawSpellModel + 1) % 5;
		}
		for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
			GroundObject object = e.getValue();
			int l3 = object.getX();
			int l4 = object.getY();
			if (l3 >= 0 && l4 >= 0 && l3 < 96 && l4 < 96 && object.getId() == 74)
				object.getModel().method188(1, 0, 0);
		}

		for (Map.Entry<Integer, TeleportBubble> e : teleportBubbles.entrySet()) {
			TeleportBubble bubble = e.getValue();
			bubble.setTimer(bubble.getTimer() + 1);
			if (bubble.getTimer() > 50)
				teleportBubbles.remove(bubble);
		}

	}

	/*
	 * Processes NPC walking, sprites, animations, messages, etc.
	 */
	public final void processNpcEvents(int i, final int y, final int k, final int l, final int i1, final int j1, final int k1) {
		final NPC npc = npcs.get(i1);
		int l1 = npc.getCurrentSprite() + (cameraRotation + 16) / 32 & 7;
		boolean flag = false;
		int i2 = l1;
		switch (i2) {
		case 5:
			i2 = 3;
			flag = true;
			break;
		case 6:
			i2 = 2;
			flag = true;
			break;
		case 7:
			i2 = 1;
			flag = true;
			break;
		default:
			break;
		}
		int j2 = i2 * 3 + WALK_ANIMATIONS[(npc.getStepCount() / Data.NPC_WALKING_SPRITES[npc.getId()]) % 4];
		if (npc.getCurrentSprite() == 8) { // Fighting left
			i2 = 5;
			l1 = 2;
			flag = false;
			i -= (Data.NPC_FIGHTING_SPRITES[npc.getId()] * k1) / 100;
			j2 = i2 * 3 + COMBAT_MODELS_LEFT[(loginTimer / (Data.NPC_COMBAT_MODELS[npc.getId()] - 1)) % 8];
		} else if (npc.getCurrentSprite() == 9) { // Fighting right
			i2 = 5;
			l1 = 2;
			flag = true;
			i += (Data.NPC_FIGHTING_SPRITES[npc.getId()] * k1) / 100;
			j2 = i2 * 3 + COMBAT_MODELS_RIGHT[(loginTimer / Data.NPC_COMBAT_MODELS[npc.getId()]) % 8];
		}
		for (int k2 = 0; k2 < 12; k2++) {
			final int k3 = Data.NPC_SPRITES[npc.getId()][ANIMATION_ARRAY[l1][k2]];
			if (k3 >= 0) {
				int i4 = 0;
				int j4 = 0;
				int k4 = j2;
				if (flag && i2 >= 1 && i2 <= 3 && Data.ANIMATION_HAS_F[k3] == 1)
					k4 += 15;
				if (i2 != 5 || Data.ANIMATION_HAS_A[k3] == 1) {
					final int l4 = k4 + Data.ANIMATION_NUMBERS[k3];
					i4 = (i4 * k) / gameImage.spriteSomething1[l4]; // TODO:
					// figure
					// out
					// these
					// variables
					j4 = (j4 * l) / gameImage.spriteSomething2[l4];
					final int i5 = (k * gameImage.spriteSomething1[l4]) / gameImage.spriteSomething1[Data.ANIMATION_NUMBERS[k3]];
					i4 -= (i5 - k) / 2;
					int colorVar = Data.ANIMATION_COLORS[k3];
					int skinColor = 0;
					switch (colorVar) {
					case 1:
						colorVar = Data.NPC_HAIR_COLORS[npc.getId()];
						skinColor = Data.NPC_SKIN_COLORS[npc.getId()];
						break;
					case 2:
						colorVar = Data.NPC_TOP_COLORS[npc.getId()];
						skinColor = Data.NPC_SKIN_COLORS[npc.getId()];
						break;
					case 3:
						colorVar = Data.NPC_PANT_COLORS[npc.getId()];
						skinColor = Data.NPC_SKIN_COLORS[npc.getId()];
						break;
					default:
						break;
					}
					gameImage.spriteClipRoutine4(i + i4, y + j4, i5, l, l4, colorVar, skinColor, j1, flag);
				}
			}
		}

		if (npc.getMessageTimer() > 0) { // Draw the message the NPC has last
			// said
			// above the NPCs head
			mobMessagesWidth[mobMessagesCount] = gameImage.stringWidth(npc.getMessage(), 1) / 2;
			if (mobMessagesWidth[mobMessagesCount] > 150)
				mobMessagesWidth[mobMessagesCount] = 150;
			mobMessagesHeight[mobMessagesCount] = (gameImage.stringWidth(npc.getMessage(), 1) / 300) * gameImage.stringHeight(1);
			mobMessagesX[mobMessagesCount] = i + k / 2;
			mobMessagesY[mobMessagesCount] = y;
			mobMessages[mobMessagesCount++] = npc.getMessage();
		}
		if (npc.getCurrentSprite() == 8 || npc.getCurrentSprite() == 9 || npc.getHealthBarTimer() != 0) { // NPC
			// is
			// fighting
			if (npc.getHealthBarTimer() > 0) {
				int x = i;
				if (npc.getCurrentSprite() == 8)
					x -= (20 * k1) / 100;
				else if (npc.getCurrentSprite() == 9)
					x += (20 * k1) / 100;
				healthBarX[healthBarCount] = x + k / 2; // TODO: Figure this
				// out
				healthBarY[healthBarCount] = y;
				healthBarPercentages[healthBarCount++] = (npc.getCurrentHitpoints() * 30) / npc.getMaxHitpoints();
			}
			if (npc.getHealthBarTimer() > 150) {
				int j3 = i;
				if (npc.getCurrentSprite() == 8) {
					j3 -= (10 * k1) / 100;
				} else if (npc.getCurrentSprite() == 9)
					j3 += (10 * k1) / 100;
				gameImage.drawSprite((j3 + k / 2) - 12, (y + l / 2) - 12, Data.SPRITE_OFFSET1 + 12);
				gameImage.drawCenteredString(String.valueOf(npc.getDamage()), (j3 + k / 2) - 1, y + l / 2 + 5, 3, 0xffffff);
			}
		}
	}

	/*
	 * Processes Players walking, sprites, animations, actions, etc. Anything a
	 * player does goes through here.
	 */
	public final void processPlayerEvents(int i, int j, int k, int l, int i1, int j1, int k1) {
		Player player = players.get(i1);
		if (player.getBottomColor() == 255)
			return;
		int l1 = player.getCurrentSprite() + (cameraRotation + 16) / 32 & 7;
		boolean flag = false;
		int i2 = l1;
		if (i2 == 5) {
			i2 = 3;
			flag = true;
		} else if (i2 == 6) {
			i2 = 2;
			flag = true;
		} else if (i2 == 7) {
			i2 = 1;
			flag = true;
		}
		int j2 = i2 * 3 + WALK_ANIMATIONS[(player.getStepCount() / 6) % 4];
		if (player.getCurrentSprite() == 8) {
			i2 = 5;
			l1 = 2;
			flag = false;
			i -= (5 * k1) / 100;
			j2 = i2 * 3 + COMBAT_MODELS_LEFT[(loginTimer / 5) % 8];
		} else if (player.getCurrentSprite() == 9) {
			i2 = 5;
			l1 = 2;
			flag = true;
			i += (5 * k1) / 100;
			j2 = i2 * 3 + COMBAT_MODELS_RIGHT[(loginTimer / 6) % 8];
		}
		for (int k2 = 0; k2 < 12; k2++) {
			int l2 = ANIMATION_ARRAY[l1][k2];
			int l3 = player.getWornItems()[l2] - 1;
			if (l3 >= 0) {
				int k4 = 0;
				int i5 = 0;
				int j5 = j2;
				if (flag && i2 >= 1 && i2 <= 3) {
					if (Data.ANIMATION_HAS_F[l3] == 1) {
						j5 += 15;
					} else if (l2 == 4 && i2 == 1) {
						k4 = -22;
						i5 = -3;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					} else if (l2 == 4 && i2 == 2) {
						k4 = 0;
						i5 = -8;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					} else if (l2 == 4 && i2 == 3) {
						k4 = 26;
						i5 = -5;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					} else if (l2 == 3 && i2 == 1) {
						k4 = 22;
						i5 = 3;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					} else if (l2 == 3 && i2 == 2) {
						k4 = 0;
						i5 = 8;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					} else if (l2 == 3 && i2 == 3) {
						k4 = -26;
						i5 = 5;
						j5 = i2 * 3 + WALK_ANIMATIONS[(2 + player.getStepCount() / 6) % 4];
					}
				}
				if (i2 != 5 || Data.ANIMATION_HAS_A[l3] == 1) {
					int k5 = j5 + Data.ANIMATION_NUMBERS[l3];
					k4 = (k4 * k) / gameImage.spriteSomething1[k5];
					i5 = (i5 * l) / gameImage.spriteSomething2[k5];
					int l5 = (k * gameImage.spriteSomething1[k5]) / gameImage.spriteSomething1[Data.ANIMATION_NUMBERS[l3]];
					k4 -= (l5 - k) / 2;
					int i6 = Data.ANIMATION_COLORS[l3];
					int j6 = SKIN_COLORS[player.getSkinColor()];
					if (i6 == 1) {
						i6 = HAIR_COLORS[player.getHairColor()];
					} else if (i6 == 2) {
						i6 = CLOTHES_COLORS[player.getTopColor()];
					} else if (i6 == 3)
						i6 = CLOTHES_COLORS[player.getBottomColor()];
					gameImage.spriteClipRoutine4(i + k4, j + i5, l5, l, k5, i6, j6, j1, flag);
				}
			}
		}

		if (player.getMessageTimer() > 0) {
			mobMessagesWidth[mobMessagesCount] = gameImage.stringWidth(player.getMessage(), 1) / 2;
			if (mobMessagesWidth[mobMessagesCount] > 150)
				mobMessagesWidth[mobMessagesCount] = 150;
			mobMessagesHeight[mobMessagesCount] = (gameImage.stringWidth(player.getMessage(), 1) / 300) * gameImage.stringHeight(1);
			mobMessagesX[mobMessagesCount] = i + k / 2;
			mobMessagesY[mobMessagesCount] = j;
			mobMessages[mobMessagesCount++] = player.getMessage();
		}
		if (player.getBubbleTimer() > 0) {
			bubbleItemX[bubbleItemCount] = i + k / 2;
			bubbleItemY[bubbleItemCount] = j;
			bubbleItemZ[bubbleItemCount] = k1;
			bubbleItemArray[bubbleItemCount++] = player.getBubbleItem();
		}
		if (player.getCurrentSprite() == 8 || player.getCurrentSprite() == 9 || player.getHealthBarTimer() != 0) {
			if (player.getHealthBarTimer() > 0) {
				int i3 = i;
				if (player.getCurrentSprite() == 8) {
					i3 -= (20 * k1) / 100;
				} else if (player.getCurrentSprite() == 9)
					i3 += (20 * k1) / 100;
				healthBarX[healthBarCount] = i3 + k / 2;
				healthBarY[healthBarCount] = j;
				healthBarPercentages[healthBarCount++] = (player.getCurrentHitpoints() * 30) / player.getMaxHitpoints();
			}
			if (player.getHealthBarTimer() > 150) {
				int j3 = i;
				if (player.getCurrentSprite() == 8) {
					j3 -= (10 * k1) / 100;
				} else if (player.getCurrentSprite() == 9)
					j3 += (10 * k1) / 100;
				gameImage.drawSprite((j3 + k / 2) - 12, (j + l / 2) - 12, Data.SPRITE_OFFSET1 + 11);
				gameImage.drawCenteredString(String.valueOf(player.getDamage()), (j3 + k / 2) - 1, j + l / 2 + 5, 3, 0xffffff);
			}
		}
		if (player.getSkulled() == 1 && player.getBubbleTimer() == 0) {
			int k3 = j1 + i + k / 2;
			if (player.getCurrentSprite() == 8) {
				k3 -= (20 * k1) / 100;
			} else if (player.getCurrentSprite() == 9)
				k3 += (20 * k1) / 100;
			int j4 = (16 * k1) / 100;
			int l4 = (16 * k1) / 100;
			gameImage.spriteClipRoutine1(k3 - j4 / 2, j - l4 / 2 - (10 * k1) / 100, j4, l4, Data.SPRITE_OFFSET1 + 13);
		}
	}

	public final void readIncomingPacket(int packetId, int length, byte[] data) {
		try {
			if (packetId == 145) {

				int offset = 8;
				sectionX = DataOperations.readBits(data, offset, 11);
				offset += 11;
				sectionY = DataOperations.readBits(data, offset, 13);
				offset += 13;
				int direction = DataOperations.readBits(data, offset, 4);
				offset += 4;
				boolean flag1 = loadSection(sectionX, sectionY);
				sectionX -= areaX;
				sectionY -= areaY;
				int l22 = sectionX * 128 + 64;
				int l25 = sectionY * 128 + 64;
				if (flag1) {
					ourPlayer.setPathCurrent(0);
					ourPlayer.setPathEnd(0);
					ourPlayer.setX(ourPlayer.getPathX()[0] = l22);
					ourPlayer.setY(ourPlayer.getPathY()[0] = l25);
				}
				ourPlayer = makePlayer(ourIndex, l22, l25, direction);

				while (offset + 24 < length * 8) {
					int index = DataOperations.readBits(data, offset, 11);
					offset += 11;
					int xOffset = DataOperations.readBits(data, offset, 5);
					offset += 5;
					if (xOffset > 15)
						xOffset -= 32;
					int yOffset = DataOperations.readBits(data, offset, 5);
					offset += 5;
					if (yOffset > 15)
						yOffset -= 32;
					int sprite = DataOperations.readBits(data, offset, 4);
					offset += 4;
					makePlayer(index, (sectionX + xOffset) * 128 + 64, (sectionY + yOffset) * 128 + 64, sprite);
				}
				return;
			}

			if (packetId == 109) {
				for (int offset = 1; offset < length;) {
					int id = DataOperations.getShort(data, offset);
					offset += 2;
					int x = sectionX + data[offset++];
					int y = sectionY + data[offset++];
					if ((id & 0x8000) == 0) {
						GroundItem item = new GroundItem(id, x, y);
						item.setIndex(groundItems.size() + 1);
						item.setZ(0);
						for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
							GroundObject object = e.getValue();
							if (object.getX() == x && object.getY() == y)
								item.setZ(Data.OBJECT_ELEVATION[object.getId()]);
							break;
						}

						groundItems.put(item.getIndex(), item);
					} else {
						id &= 0x7fff;
						groundItems.remove(x + y);
					}
				}

				return;
			}
			if (packetId == 27) {
				for (int offset = 1; offset < length;) {
					int id = DataOperations.getUnsigned4Bytes(data, offset);
					offset += 4;
					int x = sectionX + data[offset++];
					int y = sectionY + data[offset++];
					for (Map.Entry<Integer, GroundObject> e : objects.entrySet()) {
						GroundObject object = e.getValue();
						if (object.getX() == x && object.getY() == y) {
							camera.removeModel(object.getModel());
							landscapeEngine.updateObject(object.getX(), object.getY(), object.getId());
							objects.remove(object);
						}
					}

					if (id != 60000) {
						int direction = landscapeEngine.registerObject(x, y);
						int width;
						int height;
						if (direction == 0 || direction == 4) {
							width = Data.OBJECT_WIDTH[id];
							height = Data.OBJECT_HEIGHT[id];
						} else {
							height = Data.OBJECT_WIDTH[id];
							width = Data.OBJECT_HEIGHT[id];
						}
						int j40 = ((x + x + width) * 128) / 2;
						int i42 = ((y + y + height) * 128) / 2;
						int k43 = Data.OBJECT_MODELS[id];
						GroundObject object = new GroundObject(id, x, y);
						object.setIndex(objects.size() + 1);
						Model model_1 = gameDataModels[k43].method203();
						camera.addModel(model_1);
						model_1.anInt257 = object.getIndex();
						model_1.method188(0, direction * 32, 0);
						model_1.method190(j40, -landscapeEngine.getAveragedElevation(j40, i42), i42);
						model_1.method184(true, 48, 48, -50, -10, -50);
						landscapeEngine.method417(x, y, id);
						if (id == 74)
							model_1.method190(0, -480, 0);
						object.setDirection(direction);
						object.setModel(model_1);
						objects.put(object.getIndex(), object);
					}
				}

				return;
			}
			if (packetId == 114) {
				int offset = 1;
				inventorySize = data[offset++] & 0xff;
				for (int index = 0; index < inventorySize; index++) {
					int id = DataOperations.getShort(data, offset);
					offset += 2;
					inventoryItems[index] = id & 0x7fff;
					wornItems[index] = id / 32768;
					if (Data.ITEM_STACKABLE[id & 0x7fff] == 0) {
						inventoryItemAmount[index] = DataOperations.readByteOrInteger(data, offset);
						if (inventoryItemAmount[index] >= 128) {
							offset += 4;
						} else {
							offset++;
						}
					} else {
						inventoryItemAmount[index] = 1;
					}
				}

				return;
			}
			if (packetId == 53) {
				int updateSize = DataOperations.getShort(data, 1);
				int offset = 3;
				for (int k15 = 0; k15 < updateSize; k15++) {
					int index = DataOperations.getShort(data, offset);
					offset += 2;
					Player player = players.get(index);
					byte action = data[offset++];
					if (action == 0) {
						int i30 = DataOperations.getShort(data, offset);
						offset += 2;
						if (player != null) {
							player.setBubbleTimer(150);
							player.setBubbleItem(i30);
						}
					} else if (action == 1) {
						byte byte7 = data[offset];
						offset++;
						if (player != null) {
							String s2 = StringOperations.bytesToString(data, offset, byte7);
							boolean flag3 = false;
							for (int k40 = 0; k40 < super.ignoresCount; k40++) {
								if (super.ignoresHashList[k40] == player.getUsernameHash())
									flag3 = true;
							}

							if (!flag3) {
								player.setMessageTimer(150);
								player.setMessage(s2);
								displayMessage(player.getName() + ": " + player.getMessage(), 2);
							}
						}
						offset += byte7;
					} else if (action == 2) {
						int j30 = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						int j34 = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						int k37 = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						if (player != null) {
							player.setDamage(j30);
							player.setCurrentHitpoints(j34);
							player.setMaxHitpoints(k37);
							player.setHealthBarTimer(200);
							if (player == ourPlayer) {
								ourCurrentSkillLevels[3] = j34;
								ourMaximumSkillLevels[3] = k37;
								showWelcomeBox = false;
								showSystemMessage = false;
							}
						}
					} else if (action == 3 || action == 4) {
						int projectileSprite = DataOperations.getShort(data, offset);
						offset += 2;
						int projectileTargetIndex = DataOperations.getShort(data, offset);
						offset += 2;
						if (player != null)
							player.setProjectile(new Projectile(action == 3 ? npcs.get(projectileTargetIndex) : players.get(projectileTargetIndex),
									projectileSprite, PROJECTILE_STARTING_POSITION));
					} else if (action == 5) {
						if (player != null) {
							player.setUsernameHash(DataOperations.getUnsigned8Bytes(data, offset));
							offset += 8;
							player.setName(DataOperations.hashToUsername(player.getUsernameHash()));
							for (int i35 = 0; i35 < 12; i35++)
								player.getWornItems()[i35] = DataOperations.getUnsignedByte(data[offset++]);

							player.setHairColor(data[offset++] & 0xff);
							player.setTopColor(data[offset++] & 0xff);
							player.setBottomColor(data[offset++] & 0xff);
							player.setSkinColor(data[offset++] & 0xff);
							player.setLevel(data[offset++] & 0xff);
							player.setSkulled(data[offset++] & 0xff);
						} else {
							offset += 14;
							offset += DataOperations.getUnsignedByte(data[offset]) + 1;
						}
					} else if (action == 6) {
						byte byte8 = data[offset];
						offset++;
						if (player != null) {
							String s3 = StringOperations.bytesToString(data, offset, byte8);
							player.setMessageTimer(150);
							player.setMessage(s3);
							if (player == ourPlayer)
								displayMessage(player.getName() + ": " + player.getMessage(), 5);
						}
						offset += byte8;
					}
				}

				return;
			}
			if (packetId == 95) {
				for (int l1 = 1; l1 < length;) {
					if (DataOperations.getUnsignedByte(data[l1]) == 255) {
						int j9 = 0;
						int l15 = sectionX + data[l1 + 1] >> 3;
						int j20 = sectionY + data[l1 + 2] >> 3;
						l1 += 3;
						for (int k24 = 0; k24 < doorCount; k24++) {
							int j27 = (doorX[k24] >> 3) - l15;
							int k31 = (doorY[k24] >> 3) - j20;
							if (j27 != 0 || k31 != 0) {
								if (k24 != j9) {
									aModelArray700[j9] = aModelArray700[k24];
									aModelArray700[j9].anInt257 = j9 + 10000;
									doorX[j9] = doorX[k24];
									doorY[j9] = doorY[k24];
									doorDir[j9] = doorDir[k24];
									doorId[j9] = doorId[k24];
								}
								j9++;
							} else {
								camera.removeModel(aModelArray700[k24]);
								landscapeEngine.method419(doorX[k24], doorY[k24], doorDir[k24], doorId[k24]);
							}
						}

						doorCount = j9;
					} else {
						int k9 = DataOperations.getShort(data, l1);
						l1 += 2;
						int i16 = sectionX + data[l1++];
						int k20 = sectionY + data[l1++];
						byte byte5 = data[l1++];
						int k27 = 0;
						for (int l31 = 0; l31 < doorCount; l31++) {
							if (doorX[l31] != i16 || doorY[l31] != k20 || doorDir[l31] != byte5) {
								if (l31 != k27) {
									aModelArray700[k27] = aModelArray700[l31];
									aModelArray700[k27].anInt257 = k27 + 10000;
									doorX[k27] = doorX[l31];
									doorY[k27] = doorY[l31];
									doorDir[k27] = doorDir[l31];
									doorId[k27] = doorId[l31];
								}
								k27++;
							} else {
								camera.removeModel(aModelArray700[l31]);
								landscapeEngine.method419(doorX[l31], doorY[l31], doorDir[l31], doorId[l31]);
							}
						}

						doorCount = k27;
						if (k9 != 65535) {
							landscapeEngine.method413(i16, k20, byte5, k9);
							Model model = makeModel(i16, k20, byte5, k9, doorCount);
							aModelArray700[doorCount] = model;
							doorX[doorCount] = i16;
							doorY[doorCount] = k20;
							doorId[doorCount] = k9;
							doorDir[doorCount++] = byte5;
						}
					}
				}

				return;
			}
			if (packetId == 77) {
				// TODO: NPCs
				return;
			}
			if (packetId == 190) {
				int updateLength = DataOperations.getShort(data, 1);
				int offset = 3;
				for (int k16 = 0; k16 < updateLength; k16++) {
					NPC npc = npcs.get(DataOperations.getShort(data, offset));
					offset += 2;
					int updateType = DataOperations.getUnsignedByte(data[offset]);
					offset++;
					if (updateType == 1) {
						int targetIndex = DataOperations.getShort(data, offset);
						offset += 2;
						byte messageLength = data[offset++];
						if (npc != null) {
							String message = StringOperations.bytesToString(data, offset, messageLength);
							npc.setMessageTimer(150);
							npc.setMessage(message);
							if (targetIndex == ourPlayer.getIndex()) {
								displayMessage("@yel@" + Data.NPC_NAMES[npc.getId()] + ": " + npc.getMessage(), 5);
							}
						}
						offset += messageLength;
					} else if (updateType == 2) {
						int damage = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						int currentHitpoints = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						int maxHitpoints = DataOperations.getUnsignedByte(data[offset]);
						offset++;
						if (npc != null) {
							npc.setDamage(damage);
							npc.setCurrentHitpoints(currentHitpoints);
							npc.setMaxHitpoints(maxHitpoints);
							npc.setHealthBarTimer(200);
						}
					}
				}

				return;
			}
			if (packetId == 223) {
				aBoolean727 = true;
				int k2 = DataOperations.getUnsignedByte(data[1]);
				anInt881 = k2;
				int j10 = 2;
				for (int l16 = 0; l16 < k2; l16++) {
					int j21 = DataOperations.getUnsignedByte(data[j10]);
					j10++;
					aStringArray667[l16] = new String(data, j10, j21);
					j10 += j21;
				}

				return;
			}
			if (packetId == 127) {
				aBoolean727 = false;
				return;
			}
			if (packetId == 131) {
				recievedConstants = true;
				ourIndex = DataOperations.getShort(data, 1);
				wildX = DataOperations.getShort(data, 3);
				wildY = DataOperations.getShort(data, 5);
				wildHeight = DataOperations.getShort(data, 7);
				wildHeightModifier = DataOperations.getShort(data, 9);
				wildY -= wildHeight * wildHeightModifier;

				return;
			}
			if (packetId == 180) {
				int offset = 1;
				for (int k10 = 0; k10 < 18; k10++)
					ourCurrentSkillLevels[k10] = DataOperations.getUnsignedByte(data[offset++]);

				for (int i17 = 0; i17 < 18; i17++)
					ourMaximumSkillLevels[i17] = DataOperations.getUnsignedByte(data[offset++]);

				for (int k21 = 0; k21 < 18; k21++) {
					ourSkillExperience[k21] = DataOperations.getUnsigned4Bytes(data, offset);
					offset += 4;
				}

				questPoints = DataOperations.getUnsignedByte(data[offset]);
				return;
			}
			if (packetId == 177) {
				for (int i3 = 0; i3 < 5; i3++)
					equipmentBonuses[i3] = DataOperations.getUnsignedByte(data[1 + i3]);

				return;
			}
			if (packetId == 165) {
				deathScreenTimer = 250;
				return;
			}
			/*
			 * if (packetId == 115) { int j3 = (length - 1) / 4; for (int l10 =
			 * 0; l10 < j3; l10++) { int j17 = sectionX +
			 * DataOperations.method356(data, 1 + l10 * 4) >> 3; int l21 =
			 * sectionY + DataOperations.method356(data, 3 + l10 * 4) >> 3; int
			 * i25 = 0; for (int k28 = 0; k28 < groundItemCount; k28++) { int
			 * i33 = (groundItemX[k28] >> 3) - j17; int j36 = (groundItemY[k28]
			 * >> 3) - l21; if (i33 != 0 || j36 != 0) { if (k28 != i25) {
			 * groundItemX[i25] = groundItemX[k28]; groundItemY[i25] =
			 * groundItemY[k28]; groundItemId[i25] = groundItemId[k28];
			 * groundItemZ[i25] = groundItemZ[k28]; } i25++; } }
			 * 
			 * groundItemCount = i25; i25 = 0; for (int j33 = 0; j33 <
			 * objectCount; j33++) { int k36 = (objectX[j33] >> 3) - j17; int
			 * l38 = (objectY[j33] >> 3) - l21; if (k36 != 0 || l38 != 0) { if
			 * (j33 != i25) { aModelArray805[i25] = aModelArray805[j33];
			 * aModelArray805[i25].anInt257 = i25; objectX[i25] = objectX[j33];
			 * objectY[i25] = objectY[j33]; objectId[i25] = objectId[j33];
			 * anIntArray885[i25] = anIntArray885[j33]; } i25++; } else {
			 * camera.method269(aModelArray805[j33]);
			 * landscapeEngine.method403(objectX[j33], objectY[j33],
			 * objectId[j33]); } }
			 * 
			 * objectCount = i25; i25 = 0; for (int l36 = 0; l36 < anInt959;
			 * l36++) { int i39 = (anIntArray947[l36] >> 3) - j17; int j41 =
			 * (anIntArray948[l36] >> 3) - l21; if (i39 != 0 || j41 != 0) { if
			 * (l36 != i25) { aModelArray700[i25] = aModelArray700[l36];
			 * aModelArray700[i25].anInt257 = i25 + 10000; anIntArray947[i25] =
			 * anIntArray947[l36]; anIntArray948[i25] = anIntArray948[l36];
			 * anIntArray960[i25] = anIntArray960[l36]; anIntArray961[i25] =
			 * anIntArray961[l36]; } i25++; } else {
			 * camera.method269(aModelArray700[l36]);
			 * landscapeEngine.method419(anIntArray947[l36], anIntArray948[l36],
			 * anIntArray960[l36], anIntArray961[l36]); } }
			 * 
			 * anInt959 = i25; }
			 * 
			 * return; }
			 */
			if (packetId == 207) {
				showCharacterDesignMenu = true;
				return;
			}
			if (packetId == 4) {
				Player player = players.get(DataOperations.getShort(data, 1));
				if (player != null)
					tradeOpponentName = player.getName();
				tradeTheyAccepted = false;
				tradeWeAccepted = false;
				tradeOurItemCount = 0;
				tradeTheirItemCount = 0;
				showTradeScreen = true;
				return;
			}
			if (packetId == 187) {
				showTradeScreen = false;
				showTradeConfirmScreen = false;
				return;
			}
			if (packetId == 250) {
				tradeTheirItemCount = data[1] & 0xff;
				int l3 = 2;
				for (int i11 = 0; i11 < tradeTheirItemCount; i11++) {
					anIntArray923[i11] = DataOperations.getShort(data, l3);
					l3 += 2;
					anIntArray924[i11] = DataOperations.getUnsigned4Bytes(data, l3);
					l3 += 4;
				}

				tradeTheyAccepted = false;
				tradeWeAccepted = false;
				return;
			}
			if (packetId == 92) {
				byte byte0 = data[1];
				if (byte0 == 1) {
					tradeTheyAccepted = true;
					return;
				} else {
					tradeTheyAccepted = false;
					return;
				}
			}
			if (packetId == 253) {
				aBoolean940 = true;
				int i4 = 1;
				int j11 = data[i4++] & 0xff;
				byte byte4 = data[i4++];
				anInt956 = data[i4++] & 0xff;
				anInt957 = data[i4++] & 0xff;
				for (int i22 = 0; i22 < 40; i22++) {
					anIntArray849[i22] = -1;
				}

				for (int j25 = 0; j25 < j11; j25++) {
					anIntArray849[j25] = DataOperations.getShort(data, i4);
					i4 += 2;
					anIntArray850[j25] = DataOperations.getShort(data, i4);
					i4 += 2;
					anIntArray851[j25] = data[i4++];
				}

				if (byte4 == 1) {
					int l28 = 39;
					for (int k33 = 0; k33 < inventorySize; k33++) {
						if (l28 < j11)
							break;
						boolean flag2 = false;
						for (int j39 = 0; j39 < 40; j39++) {
							if (anIntArray849[j39] != inventoryItems[k33])
								continue;
							flag2 = true;
							break;
						}

						if (inventoryItems[k33] == 10)
							flag2 = true;
						if (!flag2) {
							anIntArray849[l28] = inventoryItems[k33] & 0x7fff;
							anIntArray850[l28] = 0;
							anIntArray851[l28] = 0;
							l28--;
						}
					}

				}
				if (anInt970 >= 0 && anInt970 < 40 && anIntArray849[anInt970] != anInt971) {
					anInt970 = -1;
					anInt971 = -2;
				}
				return;
			}
			if (packetId == 220) {
				aBoolean940 = false;
				return;
			}
			if (packetId == 18) {
				byte byte1 = data[1];
				if (byte1 == 1) {
					tradeWeAccepted = true;
					return;
				} else {
					tradeWeAccepted = false;
					return;
				}
			}
			if (packetId == 152) {
				aBoolean666 = DataOperations.getUnsignedByte(data[1]) == 1;
				aBoolean785 = DataOperations.getUnsignedByte(data[2]) == 1;
				aBoolean950 = DataOperations.getUnsignedByte(data[3]) == 1;
				return;
			}
			if (packetId == 209) {
				for (int j4 = 0; j4 < length - 1; j4++) {
					boolean flag = data[j4 + 1] == 1;
					if (!selectedPrayers[j4] && flag)
						playSound("prayeron");
					if (selectedPrayers[j4] && !flag)
						playSound("prayeroff");
					selectedPrayers[j4] = flag;
				}

				return;
			}
			if (packetId == 224) {
				for (int k4 = 0; k4 < 50; k4++) {
					aBooleanArray808[k4] = data[k4 + 1] == 1;
				}

				return;
			}
			if (packetId == 93) {
				aBoolean699 = true;
				int l4 = 1;
				anInt770 = data[l4++] & 0xff;
				anInt724 = data[l4++] & 0xff;
				for (int k11 = 0; k11 < anInt770; k11++) {
					anIntArray870[k11] = DataOperations.getShort(data, l4);
					l4 += 2;
					anIntArray871[k11] = DataOperations.readByteOrInteger(data, l4);
					if (anIntArray871[k11] >= 128) {
						l4 += 4;
					} else {
						l4++;
					}
				}

				method94();
				return;
			}
			if (packetId == 171) {
				aBoolean699 = false;
				return;
			}
			if (packetId == 211) {
				int i5 = data[1] & 0xff;
				ourSkillExperience[i5] = DataOperations.getUnsigned4Bytes(data, 2);
				return;
			}
			if (packetId == 229) {
				Player player = players.get(DataOperations.getShort(data, 1));
				if (player != null)
					duelOpponentName = player.getName();
				duelOurItemCount = 0;
				duelTheirItemCount = 0;
				duelOpponentAccepted = false;
				duelWeAccepted = false;
				duelNoRetreating = false;
				duelNoMagic = false;
				duelNoPrayer = false;
				duelNoWeapons = false;
				showDuelScreen = true;
				return;
			}
			if (packetId == 160) {
				showDuelScreen = false;
				aBoolean944 = false;
				return;
			}
			if (packetId == 251) {
				showTradeConfirmScreen = true;
				aBoolean901 = false;
				showTradeScreen = false;
				int k5 = 1;
				aLong973 = DataOperations.getUnsigned8Bytes(data, k5);
				k5 += 8;
				anInt682 = data[k5++] & 0xff;
				for (int l11 = 0; l11 < anInt682; l11++) {
					anIntArray683[l11] = DataOperations.getShort(data, k5);
					k5 += 2;
					anIntArray684[l11] = DataOperations.getUnsigned4Bytes(data, k5);
					k5 += 4;
				}

				anInt679 = data[k5++] & 0xff;
				for (int k17 = 0; k17 < anInt679; k17++) {
					anIntArray680[k17] = DataOperations.getShort(data, k5);
					k5 += 2;
					anIntArray681[k17] = DataOperations.getUnsigned4Bytes(data, k5);
					k5 += 4;
				}

				return;
			}
			if (packetId == 63) {
				duelTheirItemCount = data[1] & 0xff;
				int l5 = 2;
				for (int i12 = 0; i12 < duelTheirItemCount; i12++) {
					anIntArray765[i12] = DataOperations.getShort(data, l5);
					l5 += 2;
					anIntArray766[i12] = DataOperations.getUnsigned4Bytes(data, l5);
					l5 += 4;
				}

				duelOpponentAccepted = false;
				duelWeAccepted = false;
				return;
			}
			if (packetId == 198) {
				duelNoRetreating = (data[1] == 1);
				duelNoMagic = (data[2] == 1);
				duelNoPrayer = (data[3] == 1);
				duelNoWeapons = (data[4] == 1);
				duelOpponentAccepted = false;
				duelWeAccepted = false;
				return;
			}
			if (packetId == 139) {
				int i6 = 1;
				int j12 = data[i6++] & 0xff;
				int l17 = DataOperations.getShort(data, i6);
				i6 += 2;
				int j22 = DataOperations.readByteOrInteger(data, i6);
				if (j22 == 0) {
					anInt770--;
					for (int k25 = j12; k25 < anInt770; k25++) {
						anIntArray870[k25] = anIntArray870[k25 + 1];
						anIntArray871[k25] = anIntArray871[k25 + 1];
					}
				} else {
					anIntArray870[j12] = l17;
					anIntArray871[j12] = j22;
					if (j12 >= anInt770)
						anInt770 = j12 + 1;
				}
				method94();
				return;
			}
			if (packetId == 228) {
				int j6 = 1;
				int k12 = 1;
				int i18 = data[j6++] & 0xff;
				int k22 = DataOperations.getShort(data, j6);
				j6 += 2;
				if (Data.ITEM_STACKABLE[k22 & 0x7fff] == 0)
					k12 = DataOperations.readByteOrInteger(data, j6);
				inventoryItems[i18] = k22 & 0x7fff;
				wornItems[i18] = k22 / 32768;
				inventoryItemAmount[i18] = k12;
				if (i18 >= inventorySize)
					inventorySize = i18 + 1;
				return;
			}
			if (packetId == 191) {
				int k6 = data[1] & 0xff;
				inventorySize--;
				for (int l12 = k6; l12 < inventorySize; l12++) {
					inventoryItems[l12] = inventoryItems[l12 + 1];
					inventoryItemAmount[l12] = inventoryItemAmount[l12 + 1];
					wornItems[l12] = wornItems[l12 + 1];
				}

				return;
			}
			if (packetId == 208) {
				int l6 = 1;
				int i13 = data[l6++] & 0xff;
				ourCurrentSkillLevels[i13] = DataOperations.getUnsignedByte(data[l6++]);
				ourMaximumSkillLevels[i13] = DataOperations.getUnsignedByte(data[l6++]);
				ourSkillExperience[i13] = DataOperations.getUnsigned4Bytes(data, l6);
				l6 += 4;
				return;
			}
			if (packetId == 65) {
				byte byte2 = data[1];
				if (byte2 == 1) {
					duelOpponentAccepted = true;
					return;
				} else {
					duelOpponentAccepted = false;
					return;
				}
			}
			if (packetId == 197) {
				byte byte3 = data[1];
				if (byte3 == 1) {
					duelWeAccepted = true;
					return;
				} else {
					duelWeAccepted = false;
					return;
				}
			}
			if (packetId == 147) {
				aBoolean944 = true;
				aBoolean945 = false;
				showDuelScreen = false;
				int i7 = 1;
				aLong993 = DataOperations.getUnsigned8Bytes(data, i7);
				i7 += 8;
				anInt793 = data[i7++] & 0xff;
				for (int j13 = 0; j13 < anInt793; j13++) {
					anIntArray794[j13] = DataOperations.getShort(data, i7);
					i7 += 2;
					anIntArray795[j13] = DataOperations.getUnsigned4Bytes(data, i7);
					i7 += 4;
				}

				anInt872 = data[i7++] & 0xff;
				for (int j18 = 0; j18 < anInt872; j18++) {
					anIntArray873[j18] = DataOperations.getShort(data, i7);
					i7 += 2;
					anIntArray874[j18] = DataOperations.getUnsigned4Bytes(data, i7);
					i7 += 4;
				}

				anInt739 = data[i7++] & 0xff;
				anInt740 = data[i7++] & 0xff;
				anInt741 = data[i7++] & 0xff;
				anInt742 = data[i7] & 0xff;
				return;
			}
			if (packetId == 11) {
				playSound(new String(data, 1, length - 1));
				return;
			}
			if (packetId == 23) {
				int id = data[1] & 0xFF;
				int x = data[2] + sectionX;
				int y = data[3] + sectionY;
				TeleportBubble bubble = new TeleportBubble(id, x, y);
				bubble.setIndex(x + y);
				return;
			}
			if (packetId == 248) {
				if (!hasSeenWelcomeBox) {
					lastIpAddress = DataOperations.getUnsigned4Bytes(data, 1);
					daysSinceLogin = DataOperations.getShort(data, 5);
					lastChangedRecoveries = data[7] & 0xff;
					unreadMessages = DataOperations.getShort(data, 8);
					showWelcomeBox = true;
					hasSeenWelcomeBox = true;
					lastIp = null;
				}
				return;
			}
			if (packetId == 148) {
				systemMessage = new String(data, 1, length - 1);
				showSystemMessage = true;
				bigSystemMessage = false;
				return;
			}
			if (packetId == 64) {
				systemMessage = new String(data, 1, length - 1);
				showSystemMessage = true;
				bigSystemMessage = true;
				return;
			}
			if (packetId == 172) {
				systemUpdateTimer = DataOperations.getShort(data, 1) * 32;
				return;
			}
		} catch (RuntimeException runtimeexception) {
			if (anInt669 < 3) {
				runtimeexception.printStackTrace();
				super.network.createPacket(156);
				super.network.addString(runtimeexception.toString());
				super.network.formatPacket();
				super.network.createPacket(156);
				super.network.addString("p-type:" + packetId + " p-size:" + length);
				super.network.formatPacket();
				super.network.createPacket(156);
				super.network.addString("rx:" + sectionX + " ry:" + sectionY);
				super.network.formatPacket();
				String s1 = "";
				for (int l18 = 0; l18 < 80 && l18 < length; l18++) {
					s1 = s1 + data[l18] + " ";
				}

				super.network.createPacket(156);
				super.network.addString(s1);
				super.network.formatPacket();
				anInt669++;
			}
		}
	}

	private final void requestLogout() {
		if (loggedIn == 0)
			return;
		if (lastWalkTimeout > 450) {
			displayMessage("@cya@You can't logout during combat!", 3);
			return;
		}
		if (lastWalkTimeout > 0) {
			displayMessage("@cya@You can't logout for 10 seconds after combat", 3);
		} else {
			super.network.createPacket(129);
			super.network.formatPacket();
			loginTimeout = 1000;
		}
	}

	public final void shutdown() {
		sendLogoutPacket();
		collectGarbage();
	}

	private final void updateAnimatedObjects(int i, String s) {
		int j = objects.get(i).getX();
		int k = objects.get(i).getY();
		int l = j - ourPlayer.getX() / 128;
		int i1 = k - ourPlayer.getY() / 128;
		byte byte0 = 7;
		if (j >= 0 && k >= 0 && j < 96 && k < 96 && l > -byte0 && l < byte0 && i1 > -byte0 && i1 < byte0) {
			camera.removeModel(objects.get(i).getModel());
			int j1 = Data.storeModel(s);
			Model model = gameDataModels[j1].method203();
			camera.addModel(model);
			model.method184(true, 48, 48, -50, -10, -50);
			model.method205(objects.get(i).getModel());
			model.anInt257 = i;
			objects.get(i).setModel(model);
		}
	}

	/*
	 * Change which login menu is shown according to what's been clicked.
	 */
	private final void updateLoginMenu() {
		if (super.socketTimeout > 0)
			super.socketTimeout--;
		if (loginScreen == 0) {
			welcomeMenu.updateActions(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
			if (welcomeMenu.hasActivated(loginButton1)) {
				loginScreen = 2;
				loginMenu.updateText(loginStatusText, "Please enter your username and password");
				loginMenu.updateText(loginUsernameText, currentUser);
				loginMenu.updateText(loginPasswordText, currentPassword);
				loginMenu.setFocus(loginUsernameText);
			}
		} else if (loginScreen == 2) {
			loginMenu.updateActions(super.mouseX, super.mouseY, super.lastMouseButtonDown, super.mouseButtonDown);
			if (loginMenu.hasActivated(loginButtonCancel))
				loginScreen = 0;
			if (loginMenu.hasActivated(loginUsernameText))
				loginMenu.setFocus(loginPasswordText);
			if (loginMenu.hasActivated(loginPasswordText) || loginMenu.hasActivated(loginButton)) {
				currentUser = loginMenu.getText(loginUsernameText);
				currentPassword = loginMenu.getText(loginPasswordText);
				requestLogin(currentUser, currentPassword, false);
			}
		}
	}

	public void updateLoginScreen(String s) {
		if (loginScreen == 2)
			loginMenu.updateText(loginStatusText, s);
		drawLoginMenus();
		method9();
	}
}

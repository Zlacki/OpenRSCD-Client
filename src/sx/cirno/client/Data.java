package sx.cirno.client;

public final class Data {

	public static int[] ANIMATION_COLORS;

	public static int ANIMATION_COUNT; // or animation

	public static int[] ANIMATION_GENDERS;

	public static int[] ANIMATION_HAS_A;

	public static int[] ANIMATION_HAS_F; // TODO: Figure this shit out -

	public static String[] ANIMATION_NAMES;

	// something to do with animations
	public static int[] ANIMATION_NUMBERS;
	private static int anInt131;
	private static int anInt139;
	private static int anInt58;
	public static int anInt84;
	public static int anInt85;
	public static int PRAYER_COUNT;
	public static int[] anIntArray115;
	public static int[] anIntArray116;
	public static int[] anIntArray117;
	public static int[] anIntArray118;
	public static int[] anIntArray119;
	public static int[] anIntArray120;
	public static int[] anIntArray121;
	public static int[] anIntArray122;
	public static int[] PRAYER_LEVELS;
	public static int[] anIntArray138;
	public static int[] SPELL_LEVELS;
	public static int[] SPELL_RUNECOUNT;
	public static int[] anIntArray63;
	public static int[] anIntArray87;
	public static int[] anIntArray88;
	public static int[][] SPELL_RUNEIDS;
	public static int[][] SPELL_RUNEAMOUNTS;
	public static String[] aStringArray100;
	public static String[] aStringArray101;
	public static String[] aStringArray102;
	public static String[] SPELL_DESCRIPTIONS;
	public static String[] PRAYER_NAMES;
	public static String[] PRAYER_DESCRIPTIONS;
	public static String[] aStringArray99;
	private static byte[] CACHE_INTEGER_DATA;
	private static int CACHE_INTEGER_OFFSET;
	private static byte[] CACHE_STRING_DATA;
	private static int CACHE_STRING_OFFSET;
	public static String[] ITEM_ACTIONS;
	public static int[] ITEM_COLOR_MASKS;
	public static String[] ITEM_DESCRIPTIONS;
	public static String[] ITEM_NAMES;
	public static int[] ITEM_PRICES;
	public static int[] ITEM_SPRITES;
	public static int[] ITEM_STACKABLE;
	public static int[] ITEM_TRADABLE;
	public static int[] ITEM_WEARABLE;
	public static int MAX_SPRITES;
	public static int MODEL_COUNT;
	public final static String[] MODEL_NAMES = new String[5000];
	public static int[] NPC_ATTACK;
	public static int[] NPC_ATTACKABLE;
	public static int[] NPC_CAMERA1;
	public static int[] NPC_CAMERA2;
	public static int[] NPC_COMBAT_MODELS;
	public static String[] NPC_COMMANDS;
	public static int[] NPC_DEFENSE;
	public static String[] NPC_DESCRIPTIONS;
	public static int[] NPC_FIGHTING_SPRITES;
	public static int[] NPC_HAIR_COLORS;
	public static int[] NPC_HITPOINTS;
	public static int NPC_LENGTH;
	public static String[] NPC_NAMES;
	public static int[] NPC_PANT_COLORS;
	public static int[] NPC_SKIN_COLORS;
	public static int[][] NPC_SPRITES;
	public static int[] NPC_STRENGTH;
	public static int[] NPC_TOP_COLORS;
	public static int[] NPC_WALKING_SPRITES;
	public static String[] OBJECT_COMMANDS_1;
	public static String[] OBJECT_COMMANDS_2;
	private static int OBJECT_COUNT;
	public static String[] OBJECT_DESCRIPTIONS;
	public static int[] OBJECT_ELEVATION;
	public static int[] OBJECT_HEIGHT;
	public static int[] OBJECT_MODELS;
	public static String[] OBJECT_NAMES;
	public static int[] OBJECT_TYPES;
	public static int[] OBJECT_WIDTH;
	public static String[] SPELL_NAMES;
	public static int SPRITE_OFFSET1, SPRITE_OFFSET2, SPRITE_OFFSET3, SPRITE_OFFSET4, SPRITE_OFFSET5, SPRITE_OFFSET6, SPRITE_OFFSET7;
	public static String[] TEXTURE_ANIMATION;
	public static int TEXTURE_COUNT;
	public static String[] TEXTURES;

	private final static int getCacheByte() {
		return CACHE_INTEGER_DATA[CACHE_INTEGER_OFFSET++] & 0xff;
	}

	private final static int getCacheInteger() {
		int i = DataOperations.getUnsigned4Bytes(CACHE_INTEGER_DATA, CACHE_INTEGER_OFFSET);
		CACHE_INTEGER_OFFSET += 4;
		if (i > 0x5f5e0ff)
			i = 0x5f5e0ff - i;
		return i;
	}

	private final static int getCacheShort() {
		int i = DataOperations.getShort(CACHE_INTEGER_DATA, CACHE_INTEGER_OFFSET);
		CACHE_INTEGER_OFFSET += 2;
		return i;
	}

	private final static String getCacheString() {
		StringBuilder sb = new StringBuilder();

		while (CACHE_STRING_DATA[CACHE_STRING_OFFSET] != 0)
			sb.append((char) CACHE_STRING_DATA[CACHE_STRING_OFFSET++]);
		CACHE_STRING_OFFSET++;

		return sb.toString();
	}

	public final static void loadData(byte[] data, boolean member) {
		SPRITE_OFFSET1 = 2000;
		SPRITE_OFFSET2 = SPRITE_OFFSET1 + 100;
		SPRITE_OFFSET3 = SPRITE_OFFSET2 + 50;
		SPRITE_OFFSET4 = SPRITE_OFFSET3 + 1000;
		SPRITE_OFFSET5 = SPRITE_OFFSET4 + 10;
		SPRITE_OFFSET6 = SPRITE_OFFSET5 + 50;
		SPRITE_OFFSET7 = SPRITE_OFFSET6 + 10;
		CACHE_STRING_DATA = DataOperations.loadFromCache("string.dat", 0, data);
		CACHE_STRING_OFFSET = 0;
		CACHE_INTEGER_DATA = DataOperations.loadFromCache("integer.dat", 0, data);
		CACHE_INTEGER_OFFSET = 0;
		int itemsLength = getCacheShort();
		int[] itemIsMembers = new int[itemsLength];
		ITEM_NAMES = new String[itemsLength];
		ITEM_DESCRIPTIONS = new String[itemsLength];
		ITEM_ACTIONS = new String[itemsLength];
		ITEM_SPRITES = new int[itemsLength];
		ITEM_PRICES = new int[itemsLength];
		ITEM_STACKABLE = new int[itemsLength];
		ITEM_WEARABLE = new int[itemsLength];
		ITEM_COLOR_MASKS = new int[itemsLength];
		ITEM_TRADABLE = new int[itemsLength];

		int i;

		for (i = 0; i < itemsLength; i++)
			ITEM_NAMES[i] = getCacheString();

		for (i = 0; i < itemsLength; i++)
			ITEM_DESCRIPTIONS[i] = getCacheString();

		for (i = 0; i < itemsLength; i++)
			ITEM_ACTIONS[i] = getCacheString();

		for (i = 0; i < itemsLength; i++) {
			ITEM_SPRITES[i] = getCacheShort();
			if (ITEM_SPRITES[i] + 1 > MAX_SPRITES)
				MAX_SPRITES = ITEM_SPRITES[i] + 1;
		}

		for (i = 0; i < itemsLength; i++)
			ITEM_PRICES[i] = getCacheInteger();

		for (i = 0; i < itemsLength; i++)
			ITEM_STACKABLE[i] = getCacheByte();

		for (i = 0; i < itemsLength; i++)
			getCacheByte();

		for (i = 0; i < itemsLength; i++)
			ITEM_WEARABLE[i] = getCacheShort();

		for (i = 0; i < itemsLength; i++)
			ITEM_COLOR_MASKS[i] = getCacheInteger();

		for (i = 0; i < itemsLength; i++)
			ITEM_TRADABLE[i] = getCacheByte();

		for (i = 0; i < itemsLength; i++)
			itemIsMembers[i] = getCacheByte();

		for (i = 0; i < itemsLength; i++)
			if (!member && itemIsMembers[i] == 1) {
				ITEM_NAMES[i] = "Members object";
				ITEM_DESCRIPTIONS[i] = "You need to be a member to use this object";
				ITEM_PRICES[i] = 0;
				ITEM_ACTIONS[i] = "";
				ITEM_WEARABLE[i] = 0;
				ITEM_TRADABLE[i] = 1;
			}

		NPC_LENGTH = getCacheShort();
		NPC_NAMES = new String[NPC_LENGTH];
		NPC_DESCRIPTIONS = new String[NPC_LENGTH];
		NPC_COMMANDS = new String[NPC_LENGTH];
		NPC_ATTACK = new int[NPC_LENGTH];
		NPC_STRENGTH = new int[NPC_LENGTH];
		NPC_HITPOINTS = new int[NPC_LENGTH];
		NPC_DEFENSE = new int[NPC_LENGTH];
		NPC_ATTACKABLE = new int[NPC_LENGTH];
		NPC_SPRITES = new int[NPC_LENGTH][12];
		NPC_HAIR_COLORS = new int[NPC_LENGTH];
		NPC_TOP_COLORS = new int[NPC_LENGTH];
		NPC_PANT_COLORS = new int[NPC_LENGTH];
		NPC_SKIN_COLORS = new int[NPC_LENGTH];
		NPC_CAMERA1 = new int[NPC_LENGTH];
		NPC_CAMERA2 = new int[NPC_LENGTH];
		NPC_WALKING_SPRITES = new int[NPC_LENGTH];
		NPC_COMBAT_MODELS = new int[NPC_LENGTH];
		NPC_FIGHTING_SPRITES = new int[NPC_LENGTH];

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_NAMES[i] = getCacheString();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_DESCRIPTIONS[i] = getCacheString();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_ATTACK[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_STRENGTH[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_HITPOINTS[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_DEFENSE[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_ATTACKABLE[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			for (int i1 = 0; i1 < 12; i1++) {
				NPC_SPRITES[i][i1] = getCacheByte();
				if (NPC_SPRITES[i][i1] == 255)
					NPC_SPRITES[i][i1] = -1;
			}

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_HAIR_COLORS[i] = getCacheInteger();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_TOP_COLORS[i] = getCacheInteger();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_PANT_COLORS[i] = getCacheInteger();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_SKIN_COLORS[i] = getCacheInteger();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_CAMERA1[i] = getCacheShort();
		// TODO: Find out more about these two.
		for (i = 0; i < NPC_LENGTH; i++)
			NPC_CAMERA2[i] = getCacheShort();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_WALKING_SPRITES[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_COMBAT_MODELS[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_FIGHTING_SPRITES[i] = getCacheByte();

		for (i = 0; i < NPC_LENGTH; i++)
			NPC_COMMANDS[i] = getCacheString();

		TEXTURE_COUNT = getCacheShort();
		TEXTURES = new String[TEXTURE_COUNT];
		TEXTURE_ANIMATION = new String[TEXTURE_COUNT];

		for (i = 0; i < TEXTURE_COUNT; i++)
			TEXTURES[i] = getCacheString();

		for (i = 0; i < TEXTURE_COUNT; i++)
			TEXTURE_ANIMATION[i] = getCacheString();

		ANIMATION_COUNT = getCacheShort();
		ANIMATION_NAMES = new String[ANIMATION_COUNT];
		ANIMATION_COLORS = new int[ANIMATION_COUNT];
		ANIMATION_GENDERS = new int[ANIMATION_COUNT];
		ANIMATION_HAS_A = new int[ANIMATION_COUNT];
		ANIMATION_HAS_F = new int[ANIMATION_COUNT];
		ANIMATION_NUMBERS = new int[ANIMATION_COUNT];
		for (int j8 = 0; j8 < ANIMATION_COUNT; j8++)
			ANIMATION_NAMES[j8] = getCacheString();

		for (int k8 = 0; k8 < ANIMATION_COUNT; k8++)
			ANIMATION_COLORS[k8] = getCacheInteger();

		for (int l8 = 0; l8 < ANIMATION_COUNT; l8++)
			ANIMATION_GENDERS[l8] = getCacheByte();

		for (int i9 = 0; i9 < ANIMATION_COUNT; i9++)
			ANIMATION_HAS_A[i9] = getCacheByte();

		for (int j9 = 0; j9 < ANIMATION_COUNT; j9++)
			ANIMATION_HAS_F[j9] = getCacheByte();

		for (int k9 = 0; k9 < ANIMATION_COUNT; k9++)
			ANIMATION_NUMBERS[k9] = getCacheByte();

		OBJECT_COUNT = getCacheShort();
		OBJECT_NAMES = new String[OBJECT_COUNT];
		OBJECT_DESCRIPTIONS = new String[OBJECT_COUNT];
		OBJECT_COMMANDS_1 = new String[OBJECT_COUNT];
		OBJECT_COMMANDS_2 = new String[OBJECT_COUNT];
		OBJECT_MODELS = new int[OBJECT_COUNT];
		OBJECT_WIDTH = new int[OBJECT_COUNT];
		OBJECT_HEIGHT = new int[OBJECT_COUNT];
		OBJECT_TYPES = new int[OBJECT_COUNT];
		OBJECT_ELEVATION = new int[OBJECT_COUNT];
		for (int l9 = 0; l9 < OBJECT_COUNT; l9++)
			OBJECT_NAMES[l9] = getCacheString();

		for (int i10 = 0; i10 < OBJECT_COUNT; i10++)
			OBJECT_DESCRIPTIONS[i10] = getCacheString();

		for (int j10 = 0; j10 < OBJECT_COUNT; j10++)
			OBJECT_COMMANDS_1[j10] = getCacheString();

		for (int k10 = 0; k10 < OBJECT_COUNT; k10++)
			OBJECT_COMMANDS_2[k10] = getCacheString();

		for (int l10 = 0; l10 < OBJECT_COUNT; l10++)
			OBJECT_MODELS[l10] = storeModel(getCacheString());

		for (int i11 = 0; i11 < OBJECT_COUNT; i11++)
			OBJECT_WIDTH[i11] = getCacheByte();

		for (int j11 = 0; j11 < OBJECT_COUNT; j11++)
			OBJECT_HEIGHT[j11] = getCacheByte();

		for (int k11 = 0; k11 < OBJECT_COUNT; k11++)
			OBJECT_TYPES[k11] = getCacheByte();

		for (int l11 = 0; l11 < OBJECT_COUNT; l11++)
			OBJECT_ELEVATION[l11] = getCacheByte();
		/*
		 * try { FileWriter writer = new FileWriter(new File("objects.json"));
		 * writer.write("{\n\t\"Objects\":\n\t[\n"); writer.flush(); for(int l11
		 * = 0; l11 < OBJECT_COUNT; l11++) { writer.write("\t\t{\n");
		 * writer.write("\t\t\t\"name\":\"" + OBJECT_NAMES[l11] + "\",\n");
		 * writer.write("\t\t\t\"description\":\"" + OBJECT_DESCRIPTIONS[l11] +
		 * "\",\n"); writer.write("\t\t\t\"command1\":\"" +
		 * OBJECT_COMMANDS_1[l11] + "\",\n");
		 * writer.write("\t\t\t\"command2\":\"" + OBJECT_COMMANDS_2[l11] +
		 * "\",\n"); writer.write("\t\t\t\"id\":" + l11 + ",\n");
		 * writer.write("\t\t\t\"type\":" + OBJECT_TYPES[l11] + ",\n");
		 * writer.write("\t\t\t\"width\":" + OBJECT_WIDTH[l11] + ",\n");
		 * writer.write("\t\t\t\"height\":" + OBJECT_HEIGHT[l11] + ",\n");
		 * writer.write("\t\t\t\"elevation\":" + OBJECT_ELEVATION[l11] + "\n");
		 * writer.write("\t\t},\n"); writer.flush(); } writer.write("\t]\n}");
		 * writer.flush(); writer.close(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
		anInt131 = getCacheShort();
		aStringArray99 = new String[anInt131];
		aStringArray100 = new String[anInt131];
		aStringArray101 = new String[anInt131];
		aStringArray102 = new String[anInt131];
		anIntArray118 = new int[anInt131];
		anIntArray119 = new int[anInt131];
		anIntArray120 = new int[anInt131];
		anIntArray121 = new int[anInt131];
		anIntArray122 = new int[anInt131];
		for (int i12 = 0; i12 < anInt131; i12++) {
			aStringArray99[i12] = getCacheString();
		}

		for (int j12 = 0; j12 < anInt131; j12++) {
			aStringArray100[j12] = getCacheString();
		}

		for (int k12 = 0; k12 < anInt131; k12++) {
			aStringArray101[k12] = getCacheString();
		}

		for (int l12 = 0; l12 < anInt131; l12++) {
			aStringArray102[l12] = getCacheString();
		}

		for (int i13 = 0; i13 < anInt131; i13++) {
			anIntArray118[i13] = getCacheShort();
		}

		for (int j13 = 0; j13 < anInt131; j13++) {
			anIntArray119[j13] = getCacheInteger();
		}

		for (int k13 = 0; k13 < anInt131; k13++) {
			anIntArray120[k13] = getCacheInteger();
		}

		for (int l13 = 0; l13 < anInt131; l13++) {
			anIntArray121[l13] = getCacheByte();
		}

		for (int i14 = 0; i14 < anInt131; i14++) {
			anIntArray122[i14] = getCacheByte();
		}

		anInt139 = getCacheShort();
		anIntArray87 = new int[anInt139];
		anIntArray88 = new int[anInt139];
		for (int j14 = 0; j14 < anInt139; j14++) {
			anIntArray87[j14] = getCacheByte();
		}

		for (int k14 = 0; k14 < anInt139; k14++) {
			anIntArray88[k14] = getCacheByte();
		}

		anInt58 = getCacheShort();
		anIntArray115 = new int[anInt58];
		anIntArray116 = new int[anInt58];
		anIntArray117 = new int[anInt58];
		for (int l14 = 0; l14 < anInt58; l14++) {
			anIntArray115[l14] = getCacheInteger();
		}

		for (int i15 = 0; i15 < anInt58; i15++) {
			anIntArray116[i15] = getCacheByte();
		}

		for (int j15 = 0; j15 < anInt58; j15++) {
			anIntArray117[j15] = getCacheByte();
		}

		anInt84 = getCacheShort();
		anInt85 = getCacheShort();
		SPELL_NAMES = new String[anInt85];
		SPELL_DESCRIPTIONS = new String[anInt85];
		SPELL_LEVELS = new int[anInt85];
		SPELL_RUNECOUNT = new int[anInt85];
		anIntArray63 = new int[anInt85];
		SPELL_RUNEIDS = new int[anInt85][];
		SPELL_RUNEAMOUNTS = new int[anInt85][];
		for (int k15 = 0; k15 < anInt85; k15++) {
			SPELL_NAMES[k15] = getCacheString();
		}

		for (int l15 = 0; l15 < anInt85; l15++) {
			SPELL_DESCRIPTIONS[l15] = getCacheString();
		}

		for (int i16 = 0; i16 < anInt85; i16++) {
			SPELL_LEVELS[i16] = getCacheByte();
		}

		for (int j16 = 0; j16 < anInt85; j16++) {
			SPELL_RUNECOUNT[j16] = getCacheByte();
		}

		for (int k16 = 0; k16 < anInt85; k16++) {
			anIntArray63[k16] = getCacheByte();
		}

		for (int l16 = 0; l16 < anInt85; l16++) {
			int i17 = getCacheByte();
			SPELL_RUNEIDS[l16] = new int[i17];
			for (int k17 = 0; k17 < i17; k17++) {
				SPELL_RUNEIDS[l16][k17] = getCacheShort();
			}

		}

		for (int j17 = 0; j17 < anInt85; j17++) {
			int l17 = getCacheByte();
			SPELL_RUNEAMOUNTS[j17] = new int[l17];
			for (int j18 = 0; j18 < l17; j18++) {
				SPELL_RUNEAMOUNTS[j17][j18] = getCacheByte();
			}

		}

		PRAYER_COUNT = getCacheShort();
		PRAYER_NAMES = new String[PRAYER_COUNT];
		PRAYER_DESCRIPTIONS = new String[PRAYER_COUNT];
		PRAYER_LEVELS = new int[PRAYER_COUNT];
		anIntArray138 = new int[PRAYER_COUNT];
		for (int i18 = 0; i18 < PRAYER_COUNT; i18++) {
			PRAYER_NAMES[i18] = getCacheString();
		}

		for (int k18 = 0; k18 < PRAYER_COUNT; k18++) {
			PRAYER_DESCRIPTIONS[k18] = getCacheString();
		}

		for (int l18 = 0; l18 < PRAYER_COUNT; l18++) {
			PRAYER_LEVELS[l18] = getCacheByte();
		}

		for (int i19 = 0; i19 < PRAYER_COUNT; i19++) {
			anIntArray138[i19] = getCacheByte();
		}

		CACHE_STRING_DATA = null;
		CACHE_INTEGER_DATA = null;
	}

	public final static int storeModel(String s) {
		if (s.equalsIgnoreCase("na"))
			return 0;
		for (int i = 0; i < MODEL_COUNT; i++)
			if (MODEL_NAMES[i].equalsIgnoreCase(s))
				return i;

		MODEL_NAMES[MODEL_COUNT++] = s;
		return MODEL_COUNT - 1;
	}
}

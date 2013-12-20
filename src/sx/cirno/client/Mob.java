package sx.cirno.client;

public class Mob extends Entity {
	private int bottomColor;
	private int bubbleItem;
	private int bubbleTimer;
	private int currentHitpoints;
	private int currentSprite;
	private int damage;
	private int hairColor;
	private int healthBarTimer;
	private int knownIndex;
	private int level;
	private int maxHitpoints;
	private String message;
	private int messageTimer;
	private String name;
	private int nextSprite;
	private int pathCurrent;
	private int pathEnd;
	private int[] pathX;
	private int[] pathY;
	private int skinColor;
	private int stepCount;
	private int topColor;
	private String clan;

	public Mob() {
		pathX = new int[10];
		pathY = new int[10];
		level = -1;
	}

	public final void decBubbleTimer() {
		this.bubbleTimer--;
	}

	public final void decHealthBarTimer() {
		this.healthBarTimer--;
	}

	public final void decMessageTimer() {
		this.messageTimer--;
	}

	public final int getBottomColor() {
		return this.bottomColor;
	}

	public final int getBubbleItem() {
		return this.bubbleItem;
	}

	public final int getBubbleTimer() {
		return this.bubbleTimer;
	}

	public final int getCurrentHitpoints() {
		return this.currentHitpoints;
	}

	public final int getCurrentSprite() {
		return this.currentSprite;
	}

	public int getDamage() {
		return damage;
	}

	public final int getHairColor() {
		return this.hairColor;
	}

	public final int getHealthBarTimer() {
		return this.healthBarTimer;
	}

	public final int getKnownIndex() {
		return this.knownIndex;
	}

	public final int getLevel() {
		return this.level;
	}

	public final int getMaxHitpoints() {
		return this.maxHitpoints;
	}

	public final String getMessage() {
		return this.message;
	}

	public final int getMessageTimer() {
		return this.messageTimer;
	}

	public final String getName() {
		return this.name;
	}

	public final int getNextSprite() {
		return this.nextSprite;
	}

	public final int getPathCurrent() {
		return this.pathCurrent;
	}

	public final int getPathEnd() {
		return this.pathEnd;
	}

	public final int[] getPathX() {
		return this.pathX;
	}

	public final int[] getPathY() {
		return this.pathY;
	}

	public final int getSkinColor() {
		return this.skinColor;
	}

	public final int getStepCount() {
		return this.stepCount;
	}

	public final int getTopColor() {
		return this.topColor;
	}

	public final void incStepCount() {
		this.stepCount++;
	}

	public final void setBottomColor(int bottomColor) {
		this.bottomColor = bottomColor;
	}

	public final void setBubbleItem(int bubbleItem) {
		this.bubbleItem = bubbleItem;
	}

	public final void setBubbleTimer(int bubbleTimer) {
		this.bubbleTimer = bubbleTimer;
	}

	public final void setCurrentHitpoints(int currentHitpoints) {
		this.currentHitpoints = currentHitpoints;
	}

	public final void setCurrentSprite(int currentSprite) {
		this.currentSprite = currentSprite;
	}

	public final void setDamage(int damage) {
		this.damage = damage;
	}

	public final void setHairColor(int hairColor) {
		this.hairColor = hairColor;
	}

	public final void setHealthBarTimer(int healthBarTimer) {
		this.healthBarTimer = healthBarTimer;
	}

	public final void setKnownIndex(int knownIndex) {
		this.knownIndex = knownIndex;
	}

	public final void setLevel(int level) {
		this.level = level;
	}

	public final void setMaxHitpoints(int maxHitpoints) {
		this.maxHitpoints = maxHitpoints;
	}

	public final void setMessage(String message) {
		this.message = message;
	}

	public final void setMessageTimer(int messageTimer) {
		this.messageTimer = messageTimer;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final void setNextSprite(int nextSprite) {
		this.nextSprite = nextSprite;
	}

	public final void setPathCurrent(int pathCurrent) {
		this.pathCurrent = pathCurrent;
	}

	public final void setPathEnd(int pathEnd) {
		this.pathEnd = pathEnd;
	}

	public final void setPathX(int[] pathX) {
		this.pathX = pathX;
	}

	public final void setPathY(int[] pathY) {
		this.pathY = pathY;
	}

	public final void setSkinColor(int skinColor) {
		this.skinColor = skinColor;
	}

	public final void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}

	public final void setTopColor(int topColor) {
		this.topColor = topColor;
	}

	public String getClan() {
		return clan;
	}

	public void setClan(String clan) {
		this.clan = clan;
	}
}

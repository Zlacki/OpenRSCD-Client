package sx.cirno.client;

public class Player extends Mob {
	private Projectile projectile;
	private int skulled;
	private long usernameHash;
	private int[] wornItems;

	public Player() {
		super();
		wornItems = new int[12];
	}

	public Projectile getProjectile() {
		return projectile;
	}

	public final int getSkulled() {
		return this.skulled;
	}

	public final long getUsernameHash() {
		return this.usernameHash;
	}

	public final int[] getWornItems() {
		return this.wornItems;
	}

	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}

	public final void setSkulled(int skulled) {
		this.skulled = skulled;
	}

	public final void setUsernameHash(long usernameHash) {
		this.usernameHash = usernameHash;
	}

	public final void setWornItems(int[] wornItems) {
		this.wornItems = wornItems;
	}
}

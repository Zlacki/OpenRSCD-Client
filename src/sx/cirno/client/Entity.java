package sx.cirno.client;

public class Entity {
	private int id;
	private int index;
	private int x;
	private int y;
	private int z;

	public final int getId() {
		return this.id;
	}

	public final int getIndex() {
		return this.index;
	}

	public final int getX() {
		return this.x;
	}

	public final int getY() {
		return this.y;
	}

	public int getZ() {
		return z;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final void setIndex(int index) {
		this.index = index;
	}

	public final void setX(int x) {
		this.x = x;
	}

	public final void setY(int y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
}

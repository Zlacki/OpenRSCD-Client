package sx.cirno.client;

public class Projectile extends Entity {
	private int position;
	private int sprite;
	private Mob target;

	public Projectile(Mob target, int sprite, int position) {
		super();
		this.setTarget(target);
		this.setSprite(sprite);
		this.setPosition(position);
	}

	public int getPosition() {
		return position;
	}

	public int getSprite() {
		return sprite;
	}

	public Mob getTarget() {
		return target;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public void setSprite(int sprite) {
		this.sprite = sprite;
	}

	public void setTarget(Mob target) {
		this.target = target;
	}
}

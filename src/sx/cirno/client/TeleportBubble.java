package sx.cirno.client;

public class TeleportBubble extends Entity {
	private int timer;

	public TeleportBubble(int id, int x, int y) {
		super();
		super.setId(id);
		super.setX(x);
		super.setY(y);
		setTimer(0);
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}
}

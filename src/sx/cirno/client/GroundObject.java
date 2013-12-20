package sx.cirno.client;

public class GroundObject extends Entity implements Comparable<Object> {
	private int direction;
	private Model model;
	private boolean rightClickShown;

	public GroundObject(int id, int x, int y) {
		super();
		super.setId(id);
		super.setX(x);
		super.setY(y);
		setRightClickShown(false);
	}

	public int getDirection() {
		return direction;
	}

	public Model getModel() {
		return model;
	}

	public boolean hasRightClickShown() {
		return rightClickShown;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setRightClickShown(boolean rightClickShown) {
		this.rightClickShown = rightClickShown;
	}

	public boolean equals(Object o) {
		return (o instanceof GroundObject && ((GroundObject) o).getX() == this.getX()) && (((GroundObject) o).getY() == this.getY());
	}

	public int compareTo(Object o) {
		if(o instanceof GroundObject && ((((GroundObject) o).getX() == this.getX()) && (((GroundObject) o).getY() == this.getY())))
			return 0;
		if(o instanceof GroundObject && ((((GroundObject) o).getX() >= this.getX()) || (((GroundObject) o).getY() >= this.getY())))
			return 1;
		return -1;
	}
}

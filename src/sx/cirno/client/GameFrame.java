package sx.cirno.client;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GameFrame extends Frame implements WindowListener {
	private static final long serialVersionUID = -1411530486840051359L;
	public Graphics gameGraphics;
	public GameWindow gameWindow;
	int height;
	int width;

	public GameFrame(GameWindow gameWindow, int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.gameWindow = gameWindow;
		setTitle(title);
		setResizable(false);
		setVisible(true);
		toFront();
		setSize(width, height + 28);
		super.addKeyListener(this.gameWindow);
		super.addMouseListener(this.gameWindow);
		super.addMouseMotionListener(this.gameWindow);
		gameGraphics = getGraphics();
	}

	@Override
	public Graphics getGraphics() {
		Graphics g = super.getGraphics();
		g.translate(0, 24);
		return g;
	}

	@Override
	public void paint(Graphics g) {
		gameWindow.paint(g);
	}

	public void windowClosing(WindowEvent e) {
		gameWindow.destroy();
	}

	public void windowActivated(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowOpened(WindowEvent e) {}
}

package sx.cirno.client;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.IndexColorModel;
import java.awt.image.MemoryImageSource;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;

public class GameWindow extends Applet implements Runnable, KeyListener, MouseListener, MouseMotionListener {
	public static String acceptedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"\243$%^&*()-_=+[{]};:'@#~,<.>/?\\| ";
	public static GameFrame gameFrame = null;
	private static final long serialVersionUID = 1289363040829180898L;
	public boolean keyLeftBraceDown;
	public boolean keyRightBraceDown;
	public boolean keyLeftDown;
	public boolean keyRightDown;
	public boolean keyUpDown;
	public boolean keyDownDown;
	public boolean keySpaceDown;
	public boolean keyNMDown;
	public boolean keyLowDetailDown;
	public boolean aBoolean8;
	public Font aFont18;
	public Font aFont19;
	public Font aFont20;
	public Graphics aGraphics22;
	public long aLongArray6[];
	public Image anImage21;
	public int anInt10;
	public int lastActionTimeout;
	public int anInt16;
	public int keyDown;
	public int keyDown2;
	public int anInt4;
	public int anInt9;
	public String aString14;
	public String aString17;
	public String inputMessage;
	public String aString43;
	public Thread aThread3;
	public String enteredText;
	public int height;
	public String inputText;
	public int lastMouseButtonDown;

	public int loadingPercent;
	public int loadingScreen;
	public int mouseButtonDown;
	public int mouseX;
	public int mouseY;
	public int width;

	public GameWindow() {
		width = 512;
		height = 384;
		anInt4 = 20;
		aLongArray6 = new long[10];
		loadingScreen = 1;
		aString17 = "Loading";
		aFont18 = new Font("Arial", 0, 10);
		aFont19 = new Font("Arial", 1, 13);
		aFont20 = new Font("Arial", 0, 12);
		keyLeftBraceDown = false;
		keyRightBraceDown = false;
		keyLeftDown = false;
		keyRightDown = false;
		keyUpDown = false;
		keyDownDown = false;
		keySpaceDown = false;
		keyNMDown = false;
		loadingPercent = 1;
		keyLowDetailDown = false;
		inputText = "";
		enteredText = "";
		inputMessage = "";
		aString43 = "";
	}

	public void changeThreadSleepModifier(int i) {
		anInt4 = 1000 / i;
	}

	@Override
	public Image createImage(int i, int j) {
		if (gameFrame != null) {
			return gameFrame.createImage(i, j);
		} else {
			return super.createImage(i, j);
		}
	}

	@Override
	public void destroy() {
		anInt9 = -1;
		try {
			Thread.sleep(5000L);
		} catch (Exception _ex) {}
		if (anInt9 == -1) {
			System.out.println("5 seconds expired, forcing kill");
			method12();
			if (aThread3 != null)
				aThread3 = null;
		}
	}

	public void drawString(Graphics g, String s, Font font, int i, int j) {
		Object obj;
		if (gameFrame == null) {
			obj = this;
		} else {
			obj = gameFrame;
		}
		FontMetrics fontmetrics = ((Component) (obj)).getFontMetrics(font);
		fontmetrics.stringWidth(s);
		g.setFont(font);
		g.drawString(s, i - fontmetrics.stringWidth(s) / 2, j + fontmetrics.getHeight() / 4);
	}

	@Override
	public URL getCodeBase() {
		return super.getCodeBase();
	}

	@Override
	public URL getDocumentBase() {
		return super.getDocumentBase();
	}

	@Override
	public Graphics getGraphics() {
		if (gameFrame != null) {
			return gameFrame.getGraphics();
		} else {
			return super.getGraphics();
		}
	}

	@Override
	public String getParameter(String s) {
		return super.getParameter(s);
	}

	public void initClient(int width, int height, String title) {
		System.out.println("Starting application");
		this.width = width;
		this.height = height;
		gameFrame = new GameFrame(this, width, height, title);
		loadingScreen = 1;
		aThread3 = new Thread(this);
		aThread3.start();
		aThread3.setPriority(1);
	}

	public byte[] loadData(String s, String s1, int i) {
		int j = 0;
		int k = 0;
		byte abyte0[] = null;
		try {
			method15(i, "Loading " + s1 + " - 0%");
			java.io.InputStream inputstream = DataOperations.method350(s);
			DataInputStream datainputstream = new DataInputStream(inputstream);
			byte abyte2[] = new byte[6];
			datainputstream.readFully(abyte2, 0, 6);
			j = ((abyte2[0] & 0xff) << 16) + ((abyte2[1] & 0xff) << 8) + (abyte2[2] & 0xff);
			k = ((abyte2[3] & 0xff) << 16) + ((abyte2[4] & 0xff) << 8) + (abyte2[5] & 0xff);
			method15(i, "Loading " + s1 + " - 5%");
			int l = 0;
			abyte0 = new byte[k];
			while (l < k) {
				int i1 = k - l;
				if (i1 > 1000)
					i1 = 1000;
				datainputstream.readFully(abyte0, l, i1);
				l += i1;
				method15(i, "Loading " + s1 + " - " + (5 + (l * 95) / k) + "%");
			}
			datainputstream.close();
		} catch (IOException _ex) {}
		method15(i, "Unpacking " + s1);
		if (k != j) {
			byte abyte1[] = new byte[j];
			DataFileDecrypter.unpackData(abyte1, j, abyte0, k, 0);
			return abyte1;
		} else {
			return abyte0;
		}
	}

	public Socket makeSocket(String s, int i) throws IOException {
		Socket socket = new Socket(InetAddress.getByName(s), i);
		socket.setSoTimeout(30000);
		socket.setTcpNoDelay(true);
		return socket;
	}

	public void loadGame() {}

	public void handleMenuKeyDown(int i) {}

	public void method12() {
		anInt9 = -2;
		System.out.println("Closing program");
		shutdown();
		try {
			Thread.sleep(1000L);
		} catch (Exception _ex) {}
		if (gameFrame != null)
			gameFrame.dispose();
		System.exit(0);
	}

	public void method13() {
		aGraphics22.setColor(Color.black);
		aGraphics22.fillRect(0, 0, width, height);
		byte abyte0[] = loadData("rscdef.ftp", "RSCDEF-Library", 0);
		if (abyte0 == null) {
			return;
		} else {
			byte abyte1[] = DataOperations.loadFromCache("logo.tga", 0, abyte0);
			anImage21 = method17(abyte1);
			GameImage.method251("h11p", 0, this);
			GameImage.method251("h12b", 1, this);
			GameImage.method251("h12p", 2, this);
			GameImage.method251("h13b", 3, this);
			GameImage.method251("h14b", 4, this);
			GameImage.method251("h16b", 5, this);
			GameImage.method251("h20b", 6, this);
			GameImage.method251("h24b", 7, this);
			return;
		}
	}

	public void drawLoadingScreen(int percent, String message) {
		try {
			int j = (width - 281) / 2;
			int k = (height - 148) / 2;
			aGraphics22.setColor(Color.black);
			aGraphics22.fillRect(0, 0, width, height);
			aGraphics22.drawImage(anImage21, j, k, this);
			j += 2;
			k += 90;
			anInt16 = percent;
			aString17 = message;
			aGraphics22.setColor(new Color(132, 132, 132));
			aGraphics22.drawRect(j - 2, k - 2, 280, 23);
			aGraphics22.fillRect(j, k, (277 * percent) / 100, 20);
			aGraphics22.setColor(new Color(198, 198, 198));
			drawString(aGraphics22, message, aFont18, j + 138, k + 10);
			aGraphics22.setColor(new Color(100, 200, 200));
			drawString(aGraphics22, "The strongest in Gensokyo!", aFont18, j + 138, k + 30);
			if (aString14 != null) {
				aGraphics22.setColor(Color.white);
				drawString(aGraphics22, aString14, aFont19, j + 138, k - 120);
				return;
			}
		} catch (Exception _ex) {}
	}

	public void method15(int i, String s) {
		try {
			int j = (width - 281) / 2;
			int k = (height - 148) / 2;
			j += 2;
			k += 90;
			anInt16 = i;
			aString17 = s;
			int l = (277 * i) / 100;
			aGraphics22.setColor(new Color(132, 132, 132));
			aGraphics22.fillRect(j, k, l, 20);
			aGraphics22.setColor(Color.black);
			aGraphics22.fillRect(j + l, k, 277 - l, 20);
			aGraphics22.setColor(new Color(198, 198, 198));
			drawString(aGraphics22, s, aFont18, j + 138, k + 10);
			return;
		} catch (Exception _ex) {
			return;
		}
	}

	public Image method17(byte abyte0[]) {
		int i = abyte0[13] * 256 + abyte0[12];
		int j = abyte0[15] * 256 + abyte0[14];
		byte abyte1[] = new byte[256];
		byte abyte2[] = new byte[256];
		byte abyte3[] = new byte[256];
		for (int k = 0; k < 256; k++) {
			abyte1[k] = abyte0[20 + k * 3];
			abyte2[k] = abyte0[19 + k * 3];
			abyte3[k] = abyte0[18 + k * 3];
		}

		IndexColorModel indexcolormodel = new IndexColorModel(8, 256, abyte1, abyte2, abyte3);
		byte abyte4[] = new byte[i * j];
		int l = 0;
		for (int i1 = j - 1; i1 >= 0; i1--) {
			for (int j1 = 0; j1 < i; j1++) {
				abyte4[l++] = abyte0[786 + j1 + i1 * i];
			}

		}

		MemoryImageSource memoryimagesource = new MemoryImageSource(i, j, indexcolormodel, abyte4, 0, i);
		Image image = createImage(memoryimagesource);
		return image;
	}

	public synchronized void method2() {}

	public synchronized void method4() {}

	public void method5() {}

	public void method9() {
		for (int i = 0; i < 10; i++) {
			aLongArray6[i] = 0L;
		}

	}

	@Override
	public void paint(Graphics g) {
		if (loadingScreen == 2 && anImage21 != null) {
			drawLoadingScreen(anInt16, aString17);
			return;
		}
		if (loadingScreen == 0)
			method5();
	}

	public void run() {
		if (loadingScreen == 1) {
			loadingScreen = 2;
			aGraphics22 = getGraphics();
			method13();
			drawLoadingScreen(0, "Loading...");
			loadGame();
			loadingScreen = 0;
		}
		int i = 0;
		int j = 256;
		int k = 1;
		int i1 = 0;
		for (int j1 = 0; j1 < 10; j1++) {
			aLongArray6[j1] = System.currentTimeMillis();
		}

		while (anInt9 >= 0) {
			if (anInt9 > 0) {
				anInt9--;
				if (anInt9 == 0) {
					method12();
					aThread3 = null;
					return;
				}
			}
			int k1 = j;
			int i2 = k;
			j = 300;
			k = 1;
			long now = System.currentTimeMillis();
			if (aLongArray6[i] == 0L) {
				j = k1;
				k = i2;
			} else if (now > aLongArray6[i])
				j = (int) ((2560 * anInt4) / (now - aLongArray6[i]));
			if (j < 25)
				j = 25;
			if (j > 256) {
				j = 256;
				k = (int) (anInt4 - (now - aLongArray6[i]) / 10L);
				if (k < loadingPercent)
					k = loadingPercent;
			}
			try {
				Thread.sleep(k);
			} catch (InterruptedException _ex) {}
			aLongArray6[i] = now;
			i = (i + 1) % 10;
			if (k > 1) {
				for (int j2 = 0; j2 < 10; j2++) {
					if (aLongArray6[j2] != 0L)
						aLongArray6[j2] += k;
				}

			}
			int k2 = 0;
			while (i1 < 256) {
				method2();
				i1 += j;
				if (++k2 > 1000) {
					i1 = 0;
					anInt10 += 6;
					if (anInt10 > 25) {
						anInt10 = 0;
						keyLowDetailDown = true;
					}
					break;
				}
			}
			anInt10--;
			i1 &= 0xff;
			method4();
		}
		if (anInt9 == -1)
			method12();
		aThread3 = null;
	}

	public void shutdown() {}

	@Override
	public void start() {
		if (anInt9 >= 0)
			anInt9 = 0;
	}

	public void startThread(Runnable runnable) {
		Thread thread = new Thread(runnable);
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public void stop() {
		if (anInt9 >= 0)
			anInt9 = 4000 / anInt4;
	}

	@Override
	public void update(Graphics g) {
		paint(g);
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyChar();
		int code = e.getKeyCode();
		handleMenuKeyDown(c);
		keyDown = c;
		keyDown2 = c;
		lastActionTimeout = 0;
		if (code == 37)
			keyLeftDown = true;
		if (code == 39)
			keyRightDown = true;
		if (code == 38)
			keyUpDown = true;
		if (code == 40)
			keyDownDown = true;
		if ((char) c == ' ')
			keySpaceDown = true;
		if ((char) c == 'n' || (char) c == 'm')
			keyNMDown = true;
		if ((char) c == 'N' || (char) c == 'M')
			keyNMDown = true;
		if ((char) c == '{')
			keyLeftBraceDown = true;
		if ((char) c == '}')
			keyRightBraceDown = true;
		if (code == 112)
			keyLowDetailDown = !keyLowDetailDown;
		boolean validKey = false;
		for (int j = 0; j < acceptedCharacters.length(); j++) {
			if (c != acceptedCharacters.charAt(j))
				continue;
			validKey = true;
			break;
		}

		if (validKey && inputText.length() < 20)
			inputText += e.getKeyChar();
		if (validKey && inputMessage.length() < 80)
			inputMessage += e.getKeyChar();
		if (code == 8 && inputText.length() > 0)
			inputText = inputText.substring(0, inputText.length() - 1);
		if (code == 8 && inputMessage.length() > 0)
			inputMessage = inputMessage.substring(0, inputMessage.length() - 1);
		if (code == 10 || code == 13) {
			enteredText = inputText;
			aString43 = inputMessage;
		}

		return;
	}

	public void keyReleased(KeyEvent e) {
		int c = e.getKeyChar();
		int code = e.getKeyCode();
		keyDown = 0;
		if (code == 37)
			keyLeftDown = false;
		if (code == 39)
			keyRightDown = false;
		if (code == 38)
			keyUpDown = false;
		if (code == 40)
			keyDownDown = false;
		if ((char) c == ' ')
			keySpaceDown = false;
		if ((char) c == 'n' || (char) c == 'm')
			keyNMDown = false;
		if ((char) c == 'N' || (char) c == 'M')
			keyNMDown = false;
		if ((char) c == '{')
			keyLeftBraceDown = false;
		if ((char) c == '}')
			keyRightBraceDown = false;

		return;
	}

	public void keyTyped(KeyEvent e) {}

	public void mouseClicked(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY() - 24;
		mouseButtonDown = (e.isMetaDown() ? 2 : 1);
		lastMouseButtonDown = mouseButtonDown;
		lastActionTimeout = 0;
		mouseClick(mouseButtonDown, e.getX(), e.getY() - 24);
		return;
	}

	public void mouseReleased(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY() - 24;
		mouseButtonDown = 0;
		return;
	}

	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY() - 24;
		mouseButtonDown = (e.isMetaDown() ? 2 : 1);
		return;
	}

	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY() - 24;
		mouseButtonDown = 0;
		lastActionTimeout = 0;
		return;
	}

	public void mouseClick(int i, int j, int k) {}
}

package sx.cirno.client;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;

public class GameWindowMiddleman extends GameWindow {
	private final static long serialVersionUID = 2868067699241414940L;
	private final static int VERSION = 202;
	public int blockChatMessages;
	public int blockDuelRequests;
	public int blockPrivateMessages;
	public int blockTradeRequests;
	public int friendsCount;
	public long friendsHashList[];
	public int friendsOnline[];
	public int ignoresCount;
	public long ignoresHashList[];
	public String ip;
	public long lastPing;
	public Networking network;
	public byte[] packetData;
	public String password;
	public int port;
	public int priviliges;
	public int reconnectTries;
	public int socketTimeout;
	public String username;

	public GameWindowMiddleman() {
		ip = "127.0.0.1";
		port = 43594;
		username = "";
		password = "";
		packetData = new byte[5000];
		friendsHashList = new long[200];
		friendsOnline = new int[200];
		ignoresHashList = new long[100];
	}

	/*
	 * Add a user to your friends list by username.
	 */
	public void addFriend(String user) {
		network.createPacket(168);
		network.addTwoIntegers(DataOperations.usernameToHash(user));
		network.formatPacket();
		long l = DataOperations.usernameToHash(user);
		for (int i = 0; i < friendsCount; i++) {
			if (friendsHashList[i] == l)
				return;
		}

		if (friendsCount < 100) {
			friendsHashList[friendsCount] = l;
			friendsOnline[friendsCount] = 0;
			friendsCount++;
		}
	}

	/*
	 * Displays a message in the game window telling the user that they can't
	 * log out at this time.
	 */
	public void displayUnableToLogout() {}

	public void handleServerMessage(String s) {}

	/*
	 * Ignore a user by username.
	 */
	public void ignoreUser(String user) {
		long l = DataOperations.usernameToHash(user);
		network.createPacket(25);
		network.addTwoIntegers(l);
		network.formatPacket();
		for (int i = 0; i < ignoresCount; i++) {
			if (ignoresHashList[i] == l)
				return;
		}

		if (ignoresCount < 100) {
			ignoresHashList[ignoresCount++] = l;
		}
	}

	/*
	 * Resets variables so that the client can prepare for a new user and think
	 * that it's logged in
	 */
	public void login() {}

	/*
	 * Resets variables so that the client thinks it is logged out
	 */
	public void logout() {}

	/*
	 * Called when the client realizes it's lost connection
	 */
	public void lostConnection() {
		System.out.println("Lost connection");
		reconnectTries = 10;
		network.close();
		requestLogin(username, password, true);
	}

	/*
	 * Will loop organizing the friends list until you logout, it looks like.
	 */
	public void organizeFriendsListByStatus() {
		boolean flag = true;
		while (flag) {
			flag = false;
			for (int index = 0; index < friendsCount - 1; index++) {
				if (friendsOnline[index] < friendsOnline[index + 1]) {
					int j = friendsOnline[index];
					friendsOnline[index] = friendsOnline[index + 1];
					friendsOnline[index + 1] = j;
					long l = friendsHashList[index];
					friendsHashList[index] = friendsHashList[index + 1];
					friendsHashList[index + 1] = l;
					flag = true;
				}
			}
		}
	}

	/*
	 * Pings every 5 seconds to assure the client is still connected, handles
	 * incoming packets, and disconnects if the server doesn't respond for too
	 * long.
	 */
	public void processNetworking() {
		long now = System.currentTimeMillis();
		if (network.containsData())
			lastPing = now;
		if (now - lastPing > 5000L) {
			lastPing = now;
			network.createPacket(153);
			network.formatPacket();
		}
		try {
			network.writePacket(20);
		} catch (IOException _ex) {
			System.out.println(_ex);
			lostConnection();
			return;
		}
		int packetSize = network.readPacket(packetData);
		if (packetSize > 0)
			readIncomingPackets(packetData[0] & 0xff, packetSize);
	}

	/*
	 * Read the packet
	 */
	public void readIncomingPacket(int id, int length, byte[] data) {}

	/*
	 * Read the packet
	 */
	public void readIncomingPackets(int id, int length) {
		if (id == 5)
			lastPing = System.currentTimeMillis();
		if (id == 48) {
			String s = new String(packetData, 1, length - 1);
			handleServerMessage(s);
		}
		if (id == 222)
			sendLogoutPacket();
		if (id == 136) {
			displayUnableToLogout();
			return;
		}
		if (id == 249) {
			friendsCount = DataOperations.getUnsignedByte(packetData[1]);
			for (int index = 0; index < friendsCount; index++) {
				friendsHashList[index] = DataOperations.getUnsigned8Bytes(packetData, 2 + index * 9);
				friendsOnline[index] = DataOperations.getUnsignedByte(packetData[10 + index * 9]);
			}

			organizeFriendsListByStatus();
			return;
		}
		if (id == 25) {
			long hash = DataOperations.getUnsigned8Bytes(packetData, 1);
			int status = packetData[9] & 0xff;
			for (int index = 0; index < friendsCount; index++) {
				if (friendsHashList[index] == hash) {
					if (friendsOnline[index] == 0 && status != 0)
						handleServerMessage("@pri@" + DataOperations.hashToUsername(hash) + " has logged in");
					if (friendsOnline[index] != 0 && status == 0)
						handleServerMessage("@pri@" + DataOperations.hashToUsername(hash) + " has logged out");
					friendsOnline[index] = status;
					length = 0;
					organizeFriendsListByStatus();
					return;
				}
			}

			friendsHashList[friendsCount] = hash;
			friendsOnline[friendsCount] = status;
			friendsCount++;
			organizeFriendsListByStatus();
			return;
		}
		if (id == 2) {
			ignoresCount = DataOperations.getUnsignedByte(packetData[1]);
			for (int index = 0; index < ignoresCount; index++) {
				ignoresHashList[index] = DataOperations.getUnsigned8Bytes(packetData, 2 + index * 8);
			}

			return;
		}
		if (id == 158) {
			blockChatMessages = packetData[1];
			blockPrivateMessages = packetData[2];
			blockTradeRequests = packetData[3];
			blockDuelRequests = packetData[4];
			return;
		}
		if (id == 170) {
			long hash = DataOperations.getUnsigned8Bytes(packetData, 1);
			String message = StringOperations.bytesToString(packetData, 13, length - 13);
			handleServerMessage("@pri@" + DataOperations.hashToUsername(hash) + ": tells you " + message);
		} else {
			readIncomingPacket(id, length, packetData);
		}
	}

	/*
	 * Remove a user from your friends list by username hash.
	 */
	public void removeFriend(long hash) {
		network.createPacket(52);
		network.addTwoIntegers(hash);
		network.formatPacket();
		for (int i = 0; i < friendsCount; i++) {
			if (friendsHashList[i] != hash)
				continue;
			friendsCount--;
			for (int j = i; j < friendsCount; j++) {
				friendsHashList[j] = friendsHashList[j + 1];
				friendsOnline[j] = friendsOnline[j + 1];
			}

			break;
		}

		handleServerMessage("@pri@" + DataOperations.hashToUsername(hash) + " has been removed from your friends list");
	}

	/*
	 * Remove an ignored user by username hash.
	 */
	public void removeIgnoredUser(long hash) {
		network.createPacket(108);
		network.addTwoIntegers(hash);
		network.formatPacket();
		for (int i = 0; i < ignoresCount; i++) {
			if (ignoresHashList[i] == hash) {
				ignoresCount--;
				/*
				 * for (int j = i; j < ignoresCount; j++) { ignoresHashList[j] =
				 * ignoresHashList[j + 1]; }
				 */
				System.arraycopy(ignoresHashList, 0, ignoresHashList, 1, ignoresCount); // TODO:
				// Needs
				// checking.

				return;
			}
		}

	}

	/*
	 * Handles logging in and initializing the network stream and cipher
	 */
	public void requestLogin(String username, String password, boolean reconnecting) {
		if (socketTimeout > 0) {
			updateLoginScreen("Please wait... Connecting to server");
			try {
				Thread.sleep(2000L);
			} catch (InterruptedException IE) {
				IE.printStackTrace();
			}
			updateLoginScreen("Sorry! The server is currently full. Please try again later");
			return;
		}
		try {
			this.username = username;
			username = DataOperations.sanitizeLoginCredentials(username, 20);
			this.password = password;
			password = DataOperations.sanitizeLoginCredentials(password, 20);
			if (username.trim().length() == 0) {
				updateLoginScreen("You must enter both a username and a password - Please try again");
				return;
			}
			if (reconnecting) {
				showBlackBox("Connection lost! Please wait...", "Attempting to re-establish");
			} else {
				updateLoginScreen("Please wait... Connecting to server");
			}
			network = new Networking(makeSocket(ip, port), this);
			network.setMaxReadPacketCount(1000);
			// long l = DataOperations.usernameToHash(username);
			network.createPacket(32);
			// streamClass.addByte((int) (l >> 16 & 31L));
			network.finalisePacket();
			long sessionID = network.readLong();
			// aLong635 = sessionID; // ????
			if (sessionID == 0L) { // this suggests we should modularize the
				// server
				updateLoginScreen("Login server offline. Please try again in a few mins");
				return;
			}
			System.out.println("Verb: Session ID: " + sessionID);
			/*
			 * int[] cipherKeys = new int[4]; cipherKeys[0] = (int)
			 * (Math.random() * 99999999D); cipherKeys[1] = (int) (Math.random()
			 * * 99999999D); cipherKeys[2] = (int) (sessionID >> 32);
			 * cipherKeys[3] = (int) sessionID; Cipher cipher = new Cipher(new
			 * byte[500]); cipher.offset = 0; cipher.addInt(cipherKeys[0]);
			 * cipher.addInt(cipherKeys[1]); cipher.addInt(cipherKeys[2]);
			 * cipher.addInt(cipherKeys[3]); cipher.addString(username);
			 * cipher.addString(password); cipher.encrypt(rsaKey, rsaMod);
			 */
			network.createPacket(0);
			if (reconnecting)
				network.addByte(1); // TODO: Handle reconnects differently??
			else
				network.addByte(0);
			network.addShort(VERSION);
			// streamClass.addBytes(cipher.data, 0, cipher.offset);
			network.addString(username);
			network.addString(password);
			network.finalisePacket();
			// streamClass.setIsaacRotatorKeys(cipherKeys);
			int response = network.readInputStream();
			System.out.println("Login response: " + response);

			if (response == 25) { // Moderator response
				priviliges = 1;
				reconnectTries = 0;
				login();
				return;
			}
			if (response == 0) {
				priviliges = 0;
				reconnectTries = 0;
				login();
				return;
			}
			if (response == 1) {
				reconnectTries = 0;
				return;
			}
			if (reconnecting) {
				username = "";
				password = "";
				logout();
				return;
			}
			network.close();
			if (response == -1) {
				updateLoginScreen("Error unable to login. Server timed out");
				return;
			}
			if (response == 3) {
				updateLoginScreen("Invalid username or password. Try again, or create a new account");
				return;
			}
			if (response == 4) {
				updateLoginScreen("That username is already logged in. Wait 60 seconds then retry");
				return;
			}
			if (response == 5) {
				updateLoginScreen("The client has been updated. Please reload this page");
				return;
			}
			if (response == 6) {
				updateLoginScreen("You may only use 1 character at once. Your ip-address is already in use");
				return;
			}
			if (response == 7) {
				updateLoginScreen("Login attempts exceeded! Please try again in 5 minutes");
				return;
			}
			if (response == 8) {
				updateLoginScreen("Error unable to login. Server rejected session");
				return;
			}
			if (response == 9) {
				updateLoginScreen("Error unable to login. Loginserver rejected session");
				return;
			}
			if (response == 10) {
				updateLoginScreen("That username is already in use. Wait 60 seconds then retry");
				return;
			}
			if (response == 11) {
				updateLoginScreen("Account temporarily disabled. Check your message inbox for details");
				return;
			}
			if (response == 12) {
				updateLoginScreen("Account permanently disabled. Check your message inbox for details");
				return;
			}
			if (response == 14) {
				updateLoginScreen("Sorry! This world is currently full. Please try a different world");
				socketTimeout = 1500;
				return;
			}
			if (response == 15) {
				updateLoginScreen("You need a members account to login to this world");
				return;
			}
			if (response == 16) {
				updateLoginScreen("Error - no reply from loginserver. Please try again");
				return;
			}
			if (response == 17) {
				updateLoginScreen("Error - failed to decode profile. Contact customer support");
				return;
			}
			if (response == 20) {
				updateLoginScreen("Error - loginserver mismatch Please try a different world");
				return;
			} else {
				updateLoginScreen("Error unable to login. Unrecognised response code");
				return;
			}
		} catch (Exception exception) {
			System.out.println(String.valueOf(exception));
		}
		if (reconnectTries > 0) {
			try {
				Thread.sleep(5000L);
			} catch (InterruptedException IE) {
				IE.printStackTrace();
			}
			reconnectTries--;
			requestLogin(this.username, this.password, reconnecting);
		}
		if (reconnecting) {
			this.username = "";
			this.password = "";
			logout();
		} else {
			updateLoginScreen("Sorry! Unable to connect. Check internet settings or try another world");
		}
	}

	/*
	 * Inform the server of our trade/duel/chat/private blocks.
	 */
	public void sendBlockedRequests(int chatMessages, int privateMessages, int tradeRequests, int duelRequests) {
		network.createPacket(176);
		network.addByte(chatMessages);
		network.addByte(privateMessages);
		network.addByte(tradeRequests);
		network.addByte(duelRequests);
		network.formatPacket();
	}

	/*
	 * Send a chat message to your area(48x48 tiles comprise an area).
	 */
	public void sendChatMessage(byte[] message, int length) {
		network.createPacket(145);
		network.addBytes(message, 0, length);
		network.formatPacket();
	}

	/*
	 * Send a command string.
	 */
	public void sendCommand(String command) {
		network.createPacket(90);
		network.addString(command);
		network.formatPacket();
	}

	/*
	 * Sends the logout packet, resets variables
	 */
	public void sendLogoutPacket() {
		if (network != null) {
			try {
				network.createPacket(39);
				network.finalisePacket();
				network.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		username = "";
		password = "";
		logout();
	}

	/*
	 * Send a private chat message to a user by username hash.
	 */
	public void sendPrivateMessage(long hash, byte[] message, int length) {
		network.createPacket(254);
		network.addTwoIntegers(hash);
		network.addBytes(message, 0, length);
		network.formatPacket();
	}

	/*
	 * Draws a black box with text in it.
	 */
	public void showBlackBox(String s, String s1) {
		Graphics g = getGraphics();
		Font font = new Font("Arial", 1, 15);
		char c = '\u0200';
		char c1 = '\u0158';
		g.setColor(Color.black);
		g.fillRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
		g.setColor(Color.white);
		g.drawRect(c / 2 - 140, c1 / 2 - 25, 280, 50);
		drawString(g, s, font, c / 2, c1 / 2 - 10);
		drawString(g, s1, font, c / 2, c1 / 2 + 10);
	}

	/*
	 * Updates the login menu text.
	 */
	public void updateLoginScreen(String s) {}
}

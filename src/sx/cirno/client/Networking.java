package sx.cirno.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Networking implements Runnable {

	private byte[] buffer;

	private boolean closed;

	private final Socket connection;

	private boolean error;

	private String errorMessage;

	private ISAACRotator incomingRotator;

	private final InputStream inputStream;

	private int lastReadCount;

	private final int maxLength;

	private int maxReadPacketCount;

	private int offset;

	private ISAACRotator outgoingRotator;

	private final OutputStream outputStream;

	private int readCount;

	private int readLength;

	private int readPacketCount;

	private int start;

	private boolean stopped;

	private int unknownVar1;

	private byte[] writeBuffer;

	public Networking(final Socket socket, final GameWindow gameWindow) throws IOException {
		this.offset = 3;
		this.error = false;
		this.errorMessage = "";
		this.maxLength = 5000;
		this.closed = false;
		this.stopped = true;
		this.connection = socket;
		this.inputStream = socket.getInputStream();
		this.outputStream = socket.getOutputStream();
		this.stopped = false;
		gameWindow.startThread(this);
	}

	public final void addByte(final int i) {
		this.buffer[this.offset++] = (byte) i;
	}

	public final void addBytes(final byte[] data, final int i, final int j) {
		for (int k = 0; k < j; k++)
			this.buffer[this.offset++] = data[i + k];
	}

	public final void addInteger(final int i) {
		addByte(i >> 24);
		addByte(i >> 16);
		addByte(i >> 8);
		addByte(i);
	}

	public final void addShort(final int i) {
		addByte(i >> 8);
		addByte(i);
	}

	public final void addString(final String s) {
		final byte[] data = s.getBytes();
		addByte(s.length());
		for (int i = 0; i < s.length(); i++)
			this.buffer[i + this.offset] = data[i];
		this.offset += s.length();
	}

	public final void addTwoIntegers(final long l) {
		addInteger((int) (l >> 32));
		addInteger((int) (l & -1L));
	}

	public final int available() throws IOException {
		if (this.closed) {
			return 0;
		} else {
			return this.inputStream.available();
		}
	}

	public final void close() {
		this.closed = true;
		try {
			if (this.inputStream != null)
				this.inputStream.close();
			if (this.outputStream != null)
				this.outputStream.close();
			if (this.connection != null)
				this.connection.close();
		} catch (IOException _ex) {
			System.out.println("Error closing stream");
		}
		this.stopped = true;
		synchronized (this) {
			notify();
		}
		this.writeBuffer = null;
	}

	public final boolean containsData() {
		return this.start > 0;
	}

	public final void createPacket(final int i) {
		if (this.start > (this.maxLength * 4) / 5) {
			try {
				writePacket(0);
			} catch (IOException ioexception) {
				this.error = true;
				this.errorMessage = ioexception.getMessage();
			}
		}
		if (this.buffer == null)
			this.buffer = new byte[this.maxLength];
		this.buffer[this.start + 2] = (byte) i;
		this.buffer[this.start + 3] = 0;
		this.offset = this.start + 3;
	}

	public final int decodePacket(final int i) {
		return i - this.incomingRotator.getNextValue() & 0xff;
	}

	public final void finalisePacket() throws IOException {
		formatPacket();
		writePacket(0);
	}

	public final void formatPacket() {
		if (this.outgoingRotator != null)
			this.buffer[this.offset + 2] = (byte) ((this.buffer[this.offset + 2] & 0xff) + this.outgoingRotator.getNextValue());
		final int j = this.offset - this.start - 2;
		this.buffer[this.start] = (byte) (j >> 8);
		this.buffer[this.start + 1] = (byte) j;
		this.start = this.offset;
	}

	public final void read(final int i, final byte[] data) throws IOException {
		read(i, 0, data);
	}

	public final void read(final int i, final int j, final byte abyte0[]) throws IOException {
		if (this.closed)
			return;
		int k = 0;
		int l;
		for (; k < i; k += l) {
			if ((l = this.inputStream.read(abyte0, k + j, i - k)) <= 0)
				throw new IOException("EOF");
		}

	}

	public final int readByte() throws IOException {
		return readInputStream();
	}

	public final int readInputStream() throws IOException {
		if (this.closed) {
			return 0;
		} else {
			return this.inputStream.read();
		}
	}

	public final long readLong() throws IOException {
		final long l = readShort();
		final long l1 = readShort();
		final long l2 = readShort();
		final long l3 = readShort();
		return (l << 48) + (l1 << 32) + (l2 << 16) + l3;
	}

	public final int readPacket(final byte[] data) {
		try {
			this.readPacketCount++;
			if (this.maxReadPacketCount > 0 && this.readPacketCount > this.maxReadPacketCount) {
				this.error = true;
				this.errorMessage = "time-out";
				this.maxReadPacketCount += this.maxReadPacketCount;
				return 0;
			}
			if (this.readLength == 0 && available() >= 2)
				this.readLength = ((((readByte() & 0xFF) << 8) | (readByte() & 0xFF)));
			if (this.readLength > 0 && available() >= this.readLength) {
				read(this.readLength, data);
				final int i = this.readLength;
				this.readLength = 0;
				this.readPacketCount = 0;
				return i;
			}
		} catch (IOException ioexception) {
			this.error = true;
			this.errorMessage = ioexception.getMessage();
		}
		return 0;
	}

	public final int readShort() throws IOException {
		final int i = readByte();
		final int j = readByte();
		return i * 256 + j;
	}

	public final void run() {
		while (!this.stopped) {
			final int i;
			final int j;
			synchronized (this) {
				if (this.lastReadCount == this.readCount) {
					try {
						wait();
					} catch (InterruptedException _ex) {}
				}
				if (this.stopped)
					return;
				j = this.readCount;
				if (this.lastReadCount >= this.readCount) {
					i = this.lastReadCount - this.readCount;
				} else {
					i = 5000 - this.readCount;
				}
			}
			if (i > 0) {
				try {
					this.outputStream.write(this.writeBuffer, j, i);
				} catch (IOException ioexception) {
					this.error = true;
					this.errorMessage = "Twriter:" + ioexception;
				}
				this.readCount = (this.readCount + i) % 5000;
				try {
					if (this.lastReadCount == this.readCount)
						this.outputStream.flush();
				} catch (IOException ioexception1) {
					this.error = true;
					this.errorMessage = "Twriter:" + ioexception1;
				}
			}
		}
	}

	public final void setIsaacRotatorKeys(final int[] keys) {
		this.incomingRotator = new ISAACRotator(keys);
		this.outgoingRotator = new ISAACRotator(keys);
	}

	public final void setMaxReadPacketCount(final int maxReadPacketCount) {
		this.maxReadPacketCount = maxReadPacketCount;
	}

	public final void write(final byte[] data, final int i, final int j) throws IOException {
		if (this.closed)
			return;
		if (this.writeBuffer == null)
			this.writeBuffer = new byte[5000];
		synchronized (this) {
			for (int k = 0; k < j; k++) {
				this.writeBuffer[this.lastReadCount] = data[k + i];
				this.lastReadCount = (this.lastReadCount + 1) % 5000;
				if (this.lastReadCount == (this.readCount + 4900) % 5000)
					throw new IOException("buffer overflow");
			}

			notify();
		}
	}

	public final void writePacket(final int i) throws IOException {
		if (this.error) {
			this.start = 0;
			this.offset = 3;
			this.error = false;
			throw new IOException(this.errorMessage);
		}
		this.unknownVar1++;
		if (this.unknownVar1 < i)
			return;
		if (this.start > 0) {
			this.unknownVar1 = 0;
			write(this.buffer, 0, this.start);
		}
		this.start = 0;
		this.offset = 3;
	}
}

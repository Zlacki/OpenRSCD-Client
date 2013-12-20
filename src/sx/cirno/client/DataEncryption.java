package sx.cirno.client;

import java.math.BigInteger;
import java.util.zip.CRC32;

public class DataEncryption {

	public static CRC32 aCRC32_522 = new CRC32();

	public byte data[];

	public int offset;

	public DataEncryption() {}

	public DataEncryption(byte[] data) {
		this.data = data;
		offset = 0;
	}

	public void addByte(int i) {
		data[offset++] = (byte) i;
	}

	public void addInt(int i) {
		data[offset++] = (byte) (i >> 24);
		data[offset++] = (byte) (i >> 16);
		data[offset++] = (byte) (i >> 8);
		data[offset++] = (byte) i;
	}

	public void addString(String s) {
		byte[] data = s.getBytes();
		for (int i = 0; i < s.length(); i++)
			data[i + (offset++)] = data[i];
		data[offset++] = 10;
	}

	public void encrypt(BigInteger pubKey, BigInteger modulo) {
		int i = offset;
		offset = 0;
		byte abyte0[] = new byte[i];
		method325(abyte0, 0, i);
		BigInteger biginteger2 = new BigInteger(abyte0);
		BigInteger biginteger3 = biginteger2.modPow(pubKey, modulo);
		byte abyte1[] = biginteger3.toByteArray();
		offset = 0;
		addByte(abyte1.length);
		method321(abyte1, 0, abyte1.length);
	}

	public void method321(byte abyte0[], int i, int j) {
		for (int k = i; k < i + j; k++) {
			data[offset++] = abyte0[k];
		}

	}

	public void method325(byte abyte0[], int i, int j) {
		for (int k = i; k < i + j; k++) {
			abyte0[k] = data[offset++];
		}

	}

	public int readByte() {
		return data[offset++] & 0xff;
	}

	public int readInteger() {
		return (readByte() << 24) + (readByte() << 16) + (readByte() << 8) + (readByte() & 0xff);
	}

	public int readShort() {
		return (readByte() << 8) + (readByte() & 0xff);
	}
}

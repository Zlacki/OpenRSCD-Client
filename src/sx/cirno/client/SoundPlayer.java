package sx.cirno.client;

import java.io.InputStream;

public class SoundPlayer extends InputStream {

	public int length;

	public int offset;

	public byte[] sound;

	public SoundPlayer() {}

	public void loadSoundData(byte[] sound, int offset, int length) {
		this.sound = sound;
		this.offset = offset;
		this.length = offset + length;
	}

	@Override
	public int read() {
		byte abyte0[] = new byte[1];
		read(abyte0, 0, 1);
		return abyte0[0];
	}

	@Override
	public int read(byte[] data, int i, int j) {
		for (int k = 0; k < j; k++) {
			if (offset < length) {
				data[i + k] = sound[offset++];
			} else {
				data[i + k] = -1;
			}
		}

		return j;
	}
}

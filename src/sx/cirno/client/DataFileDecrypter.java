package sx.cirno.client;

public class DataFileDecrypter {

	public static int unpackData(byte abyte0[], int i, byte abyte1[], int j, int k) {
		DataFileVariables variables = new DataFileVariables();
		variables.aByteArray475 = abyte1;
		variables.anInt476 = k;
		variables.aByteArray480 = abyte0;
		variables.anInt481 = 0;
		variables.anInt477 = j;
		variables.anInt482 = i;
		variables.anInt489 = 0;
		variables.anInt488 = 0;
		variables.anInt478 = 0;
		variables.anInt479 = 0;
		variables.anInt483 = 0;
		variables.anInt484 = 0;
		variables.anInt491 = 0;
		method131(variables);
		i -= variables.anInt482;
		return i;
	}

	public static void method130(DataFileVariables class11) {
		byte byte4 = class11.aByte485;
		int i = class11.anInt486;
		int j = class11.anInt496;
		int k = class11.anInt494;
		int ai[] = DataFileVariables.anIntArray499;
		int l = class11.anInt493;
		byte abyte0[] = class11.aByteArray480;
		int i1 = class11.anInt481;
		int j1 = class11.anInt482;
		int k1 = j1;
		int l1 = class11.anInt513 + 1;
		label0: do {
			if (i > 0) {
				do {
					if (j1 == 0)
						break label0;
					if (i == 1)
						break;
					abyte0[i1] = byte4;
					i--;
					i1++;
					j1--;
				} while (true);
				if (j1 == 0) {
					i = 1;
					break;
				}
				abyte0[i1] = byte4;
				i1++;
				j1--;
			}
			boolean flag = true;
			while (flag) {
				flag = false;
				if (j == l1) {
					i = 0;
					break label0;
				}
				byte4 = (byte) k;
				l = ai[l];
				byte byte0 = (byte) (l & 0xff);
				l >>= 8;
				j++;
				if (byte0 != k) {
					k = byte0;
					if (j1 == 0) {
						i = 1;
					} else {
						abyte0[i1] = byte4;
						i1++;
						j1--;
						flag = true;
						continue;
					}
					break label0;
				}
				if (j != l1)
					continue;
				if (j1 == 0) {
					i = 1;
					break label0;
				}
				abyte0[i1] = byte4;
				i1++;
				j1--;
				flag = true;
			}
			i = 2;
			l = ai[l];
			byte byte1 = (byte) (l & 0xff);
			l >>= 8;
			if (++j != l1) {
				if (byte1 != k) {
					k = byte1;
				} else {
					i = 3;
					l = ai[l];
					byte byte2 = (byte) (l & 0xff);
					l >>= 8;
					if (++j != l1) {
						if (byte2 != k) {
							k = byte2;
						} else {
							l = ai[l];
							byte byte3 = (byte) (l & 0xff);
							l >>= 8;
							j++;
							i = (byte3 & 0xff) + 4;
							l = ai[l];
							k = (byte) (l & 0xff);
							l >>= 8;
							j++;
						}
					}
				}
			}
		} while (true);
		int i2 = class11.anInt483;
		class11.anInt483 += k1 - j1;
		if (class11.anInt483 < i2)
			class11.anInt484++;
		class11.aByte485 = byte4;
		class11.anInt486 = i;
		class11.anInt496 = j;
		class11.anInt494 = k;
		DataFileVariables.anIntArray499 = ai;
		class11.anInt493 = l;
		class11.aByteArray480 = abyte0;
		class11.anInt481 = i1;
		class11.anInt482 = j1;
	}

	public static void method131(DataFileVariables class11) {
		int k8 = 0;
		int ai[] = null;
		int ai1[] = null;
		int ai2[] = null;
		class11.anInt490 = 1;
		if (DataFileVariables.anIntArray499 == null)
			DataFileVariables.anIntArray499 = new int[class11.anInt490 * 0x186a0];
		boolean flag19 = true;
		while (flag19) {
			byte byte0 = method132(class11);
			if (byte0 == 23)
				return;
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method132(class11);
			class11.anInt491++;
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method132(class11);
			byte0 = method133(class11);
			if (byte0 != 0) {
				class11.aBoolean487 = true;
			} else {
				class11.aBoolean487 = false;
			}
			if (class11.aBoolean487)
				System.out.println("PANIC! RANDOMISED BLOCK!");
			class11.anInt492 = 0;
			byte0 = method132(class11);
			class11.anInt492 = class11.anInt492 << 8 | byte0 & 0xff;
			byte0 = method132(class11);
			class11.anInt492 = class11.anInt492 << 8 | byte0 & 0xff;
			byte0 = method132(class11);
			class11.anInt492 = class11.anInt492 << 8 | byte0 & 0xff;
			for (int j = 0; j < 16; j++) {
				byte byte1 = method133(class11);
				if (byte1 == 1) {
					class11.aBooleanArray502[j] = true;
				} else {
					class11.aBooleanArray502[j] = false;
				}
			}

			for (int k = 0; k < 256; k++) {
				class11.aBooleanArray501[k] = false;
			}

			for (int l = 0; l < 16; l++) {
				if (class11.aBooleanArray502[l]) {
					for (int i3 = 0; i3 < 16; i3++) {
						byte byte2 = method133(class11);
						if (byte2 == 1)
							class11.aBooleanArray501[l * 16 + i3] = true;
					}

				}
			}

			method135(class11);
			int i4 = class11.anInt500 + 2;
			int j4 = method134(3, class11);
			int k4 = method134(15, class11);
			for (int i1 = 0; i1 < k4; i1++) {
				int j3 = 0;
				do {
					byte byte3 = method133(class11);
					if (byte3 == 0)
						break;
					j3++;
				} while (true);
				class11.aByteArray507[i1] = (byte) j3;
			}

			byte abyte0[] = new byte[6];
			for (byte byte16 = 0; byte16 < j4; byte16++) {
				abyte0[byte16] = byte16;
			}

			for (int j1 = 0; j1 < k4; j1++) {
				byte byte17 = class11.aByteArray507[j1];
				byte byte15 = abyte0[byte17];
				for (; byte17 > 0; byte17--) {
					abyte0[byte17] = abyte0[byte17 - 1];
				}

				abyte0[0] = byte15;
				class11.aByteArray506[j1] = byte15;
			}

			for (int k3 = 0; k3 < j4; k3++) {
				int l6 = method134(5, class11);
				for (int k1 = 0; k1 < i4; k1++) {
					do {
						byte byte4 = method133(class11);
						if (byte4 == 0)
							break;
						byte4 = method133(class11);
						if (byte4 == 0) {
							l6++;
						} else {
							l6--;
						}
					} while (true);
					class11.aByteArrayArray508[k3][k1] = (byte) l6;
				}

			}

			for (int l3 = 0; l3 < j4; l3++) {
				byte byte8 = 32;
				int i = 0;
				for (int l1 = 0; l1 < i4; l1++) {
					if (class11.aByteArrayArray508[l3][l1] > i)
						i = class11.aByteArrayArray508[l3][l1];
					if (class11.aByteArrayArray508[l3][l1] < byte8)
						byte8 = class11.aByteArrayArray508[l3][l1];
				}

				method136(class11.anIntArrayArray509[l3], class11.anIntArrayArray510[l3], class11.anIntArrayArray511[l3], class11.aByteArrayArray508[l3],
						byte8, i, i4);
				class11.anIntArray512[l3] = byte8;
			}

			int l4 = class11.anInt500 + 1;
			int i5 = -1;
			int j5 = 0;
			for (int i2 = 0; i2 <= 255; i2++) {
				class11.anIntArray495[i2] = 0;
			}

			int j9 = 4095;
			for (int l8 = 15; l8 >= 0; l8--) {
				for (int i9 = 15; i9 >= 0; i9--) {
					class11.aByteArray504[j9] = (byte) (l8 * 16 + i9);
					j9--;
				}

				class11.anIntArray505[l8] = j9 + 1;
			}

			int i6 = 0;
			if (j5 == 0) {
				i5++;
				j5 = 50;
				byte byte12 = class11.aByteArray506[i5];
				k8 = class11.anIntArray512[byte12];
				ai = class11.anIntArrayArray509[byte12];
				ai2 = class11.anIntArrayArray511[byte12];
				ai1 = class11.anIntArrayArray510[byte12];
			}
			j5--;
			int i7 = k8;
			int l7;
			byte byte9;
			for (l7 = method134(i7, class11); l7 > ai[i7]; l7 = l7 << 1 | byte9) {
				i7++;
				byte9 = method133(class11);
			}

			for (int k5 = ai2[l7 - ai1[i7]]; k5 != l4;) {
				if (k5 == 0 || k5 == 1) {
					int j6 = -1;
					int k6 = 1;
					do {
						if (k5 == 0) {
							j6 += k6;
						} else if (k5 == 1)
							j6 += 2 * k6;
						k6 *= 2;
						if (j5 == 0) {
							i5++;
							j5 = 50;
							byte byte13 = class11.aByteArray506[i5];
							k8 = class11.anIntArray512[byte13];
							ai = class11.anIntArrayArray509[byte13];
							ai2 = class11.anIntArrayArray511[byte13];
							ai1 = class11.anIntArrayArray510[byte13];
						}
						j5--;
						int j7 = k8;
						int i8;
						byte byte10;
						for (i8 = method134(j7, class11); i8 > ai[j7]; i8 = i8 << 1 | byte10) {
							j7++;
							byte10 = method133(class11);
						}

						k5 = ai2[i8 - ai1[j7]];
					} while (k5 == 0 || k5 == 1);
					j6++;
					byte byte5 = class11.aByteArray503[class11.aByteArray504[class11.anIntArray505[0]] & 0xff];
					class11.anIntArray495[byte5 & 0xff] += j6;
					for (; j6 > 0; j6--) {
						DataFileVariables.anIntArray499[i6] = byte5 & 0xff;
						i6++;
					}

				} else {
					int j11 = k5 - 1;
					byte byte6;
					if (j11 < 16) {
						int j10 = class11.anIntArray505[0];
						byte6 = class11.aByteArray504[j10 + j11];
						for (; j11 > 3; j11 -= 4) {
							int k11 = j10 + j11;
							class11.aByteArray504[k11] = class11.aByteArray504[k11 - 1];
							class11.aByteArray504[k11 - 1] = class11.aByteArray504[k11 - 2];
							class11.aByteArray504[k11 - 2] = class11.aByteArray504[k11 - 3];
							class11.aByteArray504[k11 - 3] = class11.aByteArray504[k11 - 4];
						}

						for (; j11 > 0; j11--) {
							class11.aByteArray504[j10 + j11] = class11.aByteArray504[(j10 + j11) - 1];
						}

						class11.aByteArray504[j10] = byte6;
					} else {
						int l10 = j11 / 16;
						int i11 = j11 % 16;
						int k10 = class11.anIntArray505[l10] + i11;
						byte6 = class11.aByteArray504[k10];
						for (; k10 > class11.anIntArray505[l10]; k10--) {
							class11.aByteArray504[k10] = class11.aByteArray504[k10 - 1];
						}

						class11.anIntArray505[l10]++;
						for (; l10 > 0; l10--) {
							class11.anIntArray505[l10]--;
							class11.aByteArray504[class11.anIntArray505[l10]] = class11.aByteArray504[(class11.anIntArray505[l10 - 1] + 16) - 1];
						}

						class11.anIntArray505[0]--;
						class11.aByteArray504[class11.anIntArray505[0]] = byte6;
						if (class11.anIntArray505[0] == 0) {
							int i10 = 4095;
							for (int k9 = 15; k9 >= 0; k9--) {
								for (int l9 = 15; l9 >= 0; l9--) {
									class11.aByteArray504[i10] = class11.aByteArray504[class11.anIntArray505[k9] + l9];
									i10--;
								}

								class11.anIntArray505[k9] = i10 + 1;
							}

						}
					}
					class11.anIntArray495[class11.aByteArray503[byte6 & 0xff] & 0xff]++;
					DataFileVariables.anIntArray499[i6] = class11.aByteArray503[byte6 & 0xff] & 0xff;
					i6++;
					if (j5 == 0) {
						i5++;
						j5 = 50;
						byte byte14 = class11.aByteArray506[i5];
						k8 = class11.anIntArray512[byte14];
						ai = class11.anIntArrayArray509[byte14];
						ai2 = class11.anIntArrayArray511[byte14];
						ai1 = class11.anIntArrayArray510[byte14];
					}
					j5--;
					int k7 = k8;
					int j8;
					byte byte11;
					for (j8 = method134(k7, class11); j8 > ai[k7]; j8 = j8 << 1 | byte11) {
						k7++;
						byte11 = method133(class11);
					}

					k5 = ai2[j8 - ai1[k7]];
				}
			}

			class11.anInt486 = 0;
			class11.aByte485 = 0;
			class11.anIntArray497[0] = 0;
			for (int j2 = 1; j2 <= 256; j2++) {
				class11.anIntArray497[j2] = class11.anIntArray495[j2 - 1];
			}

			for (int k2 = 1; k2 <= 256; k2++) {
				class11.anIntArray497[k2] += class11.anIntArray497[k2 - 1];
			}

			for (int l2 = 0; l2 < i6; l2++) {
				byte byte7 = (byte) (DataFileVariables.anIntArray499[l2] & 0xff);
				DataFileVariables.anIntArray499[class11.anIntArray497[byte7 & 0xff]] |= l2 << 8;
				class11.anIntArray497[byte7 & 0xff]++;
			}

			class11.anInt493 = DataFileVariables.anIntArray499[class11.anInt492] >> 8;
			class11.anInt496 = 0;
			class11.anInt493 = DataFileVariables.anIntArray499[class11.anInt493];
			class11.anInt494 = (byte) (class11.anInt493 & 0xff);
			class11.anInt493 >>= 8;
			class11.anInt496++;
			class11.anInt513 = i6;
			method130(class11);
			if (class11.anInt496 == class11.anInt513 + 1 && class11.anInt486 == 0) {
				flag19 = true;
			} else {
				flag19 = false;
			}
		}
	}

	public static byte method132(DataFileVariables class11) {
		return (byte) method134(8, class11);
	}

	public static byte method133(DataFileVariables class11) {
		return (byte) method134(1, class11);
	}

	public static int method134(int i, DataFileVariables class11) {
		int j;
		do {
			if (class11.anInt489 >= i) {
				int k = class11.anInt488 >> class11.anInt489 - i & (1 << i) - 1;
				class11.anInt489 -= i;
				j = k;
				break;
			}
			class11.anInt488 = class11.anInt488 << 8 | class11.aByteArray475[class11.anInt476] & 0xff;
			class11.anInt489 += 8;
			class11.anInt476++;
			class11.anInt477--;
			class11.anInt478++;
			if (class11.anInt478 == 0)
				class11.anInt479++;
		} while (true);
		return j;
	}

	public static void method135(DataFileVariables class11) {
		class11.anInt500 = 0;
		for (int i = 0; i < 256; i++) {
			if (class11.aBooleanArray501[i]) {
				class11.aByteArray503[class11.anInt500] = (byte) i;
				class11.anInt500++;
			}
		}

	}

	public static void method136(int ai[], int ai1[], int ai2[], byte abyte0[], int i, int j, int k) {
		int l = 0;
		for (int i1 = i; i1 <= j; i1++) {
			for (int l2 = 0; l2 < k; l2++) {
				if (abyte0[l2] == i1) {
					ai2[l] = l2;
					l++;
				}
			}

		}

		for (int j1 = 0; j1 < 23; j1++) {
			ai1[j1] = 0;
		}

		for (int k1 = 0; k1 < k; k1++) {
			ai1[abyte0[k1] + 1]++;
		}

		for (int l1 = 1; l1 < 23; l1++) {
			ai1[l1] += ai1[l1 - 1];
		}

		for (int i2 = 0; i2 < 23; i2++) {
			ai[i2] = 0;
		}

		int i3 = 0;
		for (int j2 = i; j2 <= j; j2++) {
			i3 += ai1[j2 + 1] - ai1[j2];
			ai[j2] = i3 - 1;
			i3 <<= 1;
		}

		for (int k2 = i + 1; k2 <= j; k2++) {
			ai1[k2] = (ai[k2 - 1] + 1 << 1) - ai1[k2];
		}

	}
}

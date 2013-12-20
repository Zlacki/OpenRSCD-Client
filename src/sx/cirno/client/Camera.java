package sx.cirno.client;

/*
 * TODO: Hold ‘Model’s and ‘CameraModel’s in a map
 */
public class Camera {
	private static long aLong441;
	public static int anInt458;
	public static int anInt459;
	public static int anInt460;
	public static int anInt461;
	public static int anInt462;
	public static int anInt463;
	public final static int[] MINIMAP_VAR1 = new int[2048];
	public final static int[] MINIMAP_VAR2 = new int[512];

	public static void method288(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		if (i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		int i4 = 0;
		if (i1 != 0) {
			i = k / i1 << 7;
			j = l / i1 << 7;
		}
		if (i < 0) {
			i = 0;
		} else if (i > 16256)
			i = 16256;
		k += j1;
		l += k1;
		i1 += l1;
		if (i1 != 0) {
			i3 = k / i1 << 7;
			j3 = l / i1 << 7;
		}
		if (i3 < 0) {
			i3 = 0;
		} else if (i3 > 16256)
			i3 = 16256;
		int k3 = i3 - i >> 4;
		int l3 = j3 - j >> 4;
		for (int j4 = i2 >> 4; j4 > 0; j4--) {
			i += k2 & 0x600000;
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i = i3;
			j = j3;
			k += j1;
			l += k1;
			i1 += l1;
			if (i1 != 0) {
				i3 = k / i1 << 7;
				j3 = l / i1 << 7;
			}
			if (i3 < 0) {
				i3 = 0;
			} else if (i3 > 16256)
				i3 = 16256;
			k3 = i3 - i >> 4;
			l3 = j3 - j >> 4;
		}

		for (int k4 = 0; k4 < (i2 & 0xf); k4++) {
			if ((k4 & 3) == 0) {
				i = (i & 0x3fff) + (k2 & 0x600000);
				i4 = k2 >> 23;
				k2 += l2;
			}
			ai[j2++] = ai1[(j & 0x3f80) + (i >> 7)] >>> i4;
			i += k3;
			j += l3;
		}

	}

	public static void method289(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		if (i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		int i4 = 0;
		if (i1 != 0) {
			i = k / i1 << 7;
			j = l / i1 << 7;
		}
		if (i < 0) {
			i = 0;
		} else if (i > 16256)
			i = 16256;
		k += j1;
		l += k1;
		i1 += l1;
		if (i1 != 0) {
			i3 = k / i1 << 7;
			j3 = l / i1 << 7;
		}
		if (i3 < 0) {
			i3 = 0;
		} else if (i3 > 16256)
			i3 = 16256;
		int k3 = i3 - i >> 4;
		int l3 = j3 - j >> 4;
		for (int j4 = i2 >> 4; j4 > 0; j4--) {
			i += k2 & 0x600000;
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			i = (i & 0x3fff) + (k2 & 0x600000);
			i4 = k2 >> 23;
			k2 += l2;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i = i3;
			j = j3;
			k += j1;
			l += k1;
			i1 += l1;
			if (i1 != 0) {
				i3 = k / i1 << 7;
				j3 = l / i1 << 7;
			}
			if (i3 < 0) {
				i3 = 0;
			} else if (i3 > 16256)
				i3 = 16256;
			k3 = i3 - i >> 4;
			l3 = j3 - j >> 4;
		}

		for (int k4 = 0; k4 < (i2 & 0xf); k4++) {
			if ((k4 & 3) == 0) {
				i = (i & 0x3fff) + (k2 & 0x600000);
				i4 = k2 >> 23;
				k2 += l2;
			}
			ai[j2++] = (ai1[(j & 0x3f80) + (i >> 7)] >>> i4) + (ai[j2] >> 1 & 0x7f7f7f);
			i += k3;
			j += l3;
		}

	}

	public static void method290(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2, int i3) {
		if (j2 <= 0)
			return;
		int j3 = 0;
		int k3 = 0;
		i3 <<= 2;
		if (j1 != 0) {
			j3 = l / j1 << 7;
			k3 = i1 / j1 << 7;
		}
		if (j3 < 0) {
			j3 = 0;
		} else if (j3 > 16256)
			j3 = 16256;
		for (int j4 = j2; j4 > 0; j4 -= 16) {
			l += k1;
			i1 += l1;
			j1 += i2;
			j = j3;
			k = k3;
			if (j1 != 0) {
				j3 = l / j1 << 7;
				k3 = i1 / j1 << 7;
			}
			if (j3 < 0) {
				j3 = 0;
			} else if (j3 > 16256)
				j3 = 16256;
			int l3 = j3 - j >> 4;
			int i4 = k3 - k >> 4;
			int k4 = l2 >> 23;
			j += l2 & 0x600000;
			l2 += i3;
			if (j4 < 16) {
				for (int l4 = 0; l4 < j4; l4++) {
					if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
						ai[k2] = i;
					k2++;
					j += l3;
					k += i4;
					if ((l4 & 3) == 3) {
						j = (j & 0x3fff) + (l2 & 0x600000);
						k4 = l2 >> 23;
						l2 += i3;
					}
				}

			} else {
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0x3fff) + (l2 & 0x600000);
				k4 = l2 >> 23;
				l2 += i3;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0x3f80) + (j >> 7)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
			}
		}

	}

	public static void method291(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		if (i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		l2 <<= 2;
		if (i1 != 0) {
			i3 = k / i1 << 6;
			j3 = l / i1 << 6;
		}
		if (i3 < 0) {
			i3 = 0;
		} else if (i3 > 4032)
			i3 = 4032;
		for (int i4 = i2; i4 > 0; i4 -= 16) {
			k += j1;
			l += k1;
			i1 += l1;
			i = i3;
			j = j3;
			if (i1 != 0) {
				i3 = k / i1 << 6;
				j3 = l / i1 << 6;
			}
			if (i3 < 0) {
				i3 = 0;
			} else if (i3 > 4032)
				i3 = 4032;
			int k3 = i3 - i >> 4;
			int l3 = j3 - j >> 4;
			int j4 = k2 >> 20;
			i += k2 & 0xc0000;
			k2 += l2;
			if (i4 < 16) {
				for (int k4 = 0; k4 < i4; k4++) {
					ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
					i += k3;
					j += l3;
					if ((k4 & 3) == 3) {
						i = (i & 0xfff) + (k2 & 0xc0000);
						j4 = k2 >> 20;
						k2 += l2;
					}
				}

			} else {
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
				i += k3;
				j += l3;
				ai[j2++] = ai1[(j & 0xfc0) + (i >> 6)] >>> j4;
			}
		}

	}

	public static void method292(int ai[], int ai1[], int i, int j, int k, int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2) {
		if (i2 <= 0)
			return;
		int i3 = 0;
		int j3 = 0;
		l2 <<= 2;
		if (i1 != 0) {
			i3 = k / i1 << 6;
			j3 = l / i1 << 6;
		}
		if (i3 < 0) {
			i3 = 0;
		} else if (i3 > 4032)
			i3 = 4032;
		for (int i4 = i2; i4 > 0; i4 -= 16) {
			k += j1;
			l += k1;
			i1 += l1;
			i = i3;
			j = j3;
			if (i1 != 0) {
				i3 = k / i1 << 6;
				j3 = l / i1 << 6;
			}
			if (i3 < 0) {
				i3 = 0;
			} else if (i3 > 4032)
				i3 = 4032;
			int k3 = i3 - i >> 4;
			int l3 = j3 - j >> 4;
			int j4 = k2 >> 20;
			i += k2 & 0xc0000;
			k2 += l2;
			if (i4 < 16) {
				for (int k4 = 0; k4 < i4; k4++) {
					ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
					i += k3;
					j += l3;
					if ((k4 & 3) == 3) {
						i = (i & 0xfff) + (k2 & 0xc0000);
						j4 = k2 >> 20;
						k2 += l2;
					}
				}

			} else {
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				i = (i & 0xfff) + (k2 & 0xc0000);
				j4 = k2 >> 20;
				k2 += l2;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
				i += k3;
				j += l3;
				ai[j2++] = (ai1[(j & 0xfc0) + (i >> 6)] >>> j4) + (ai[j2] >> 1 & 0x7f7f7f);
			}
		}

	}

	public static void method293(int ai[], int i, int j, int k, int ai1[], int l, int i1, int j1, int k1, int l1, int i2, int j2, int k2, int l2, int i3) {
		if (j2 <= 0)
			return;
		int j3 = 0;
		int k3 = 0;
		i3 <<= 2;
		if (j1 != 0) {
			j3 = l / j1 << 6;
			k3 = i1 / j1 << 6;
		}
		if (j3 < 0) {
			j3 = 0;
		} else if (j3 > 4032)
			j3 = 4032;
		for (int j4 = j2; j4 > 0; j4 -= 16) {
			l += k1;
			i1 += l1;
			j1 += i2;
			j = j3;
			k = k3;
			if (j1 != 0) {
				j3 = l / j1 << 6;
				k3 = i1 / j1 << 6;
			}
			if (j3 < 0) {
				j3 = 0;
			} else if (j3 > 4032)
				j3 = 4032;
			int l3 = j3 - j >> 4;
			int i4 = k3 - k >> 4;
			int k4 = l2 >> 20;
			j += l2 & 0xc0000;
			l2 += i3;
			if (j4 < 16) {
				for (int l4 = 0; l4 < j4; l4++) {
					if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
						ai[k2] = i;
					k2++;
					j += l3;
					k += i4;
					if ((l4 & 3) == 3) {
						j = (j & 0xfff) + (l2 & 0xc0000);
						k4 = l2 >> 20;
						l2 += i3;
					}
				}

			} else {
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				j = (j & 0xfff) + (l2 & 0xc0000);
				k4 = l2 >> 20;
				l2 += i3;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
				j += l3;
				k += i4;
				if ((i = ai1[(k & 0xfc0) + (j >> 6)] >>> k4) != 0)
					ai[k2] = i;
				k2++;
			}
		}

	}

	public static void method294(int ai[], int i, int j, int k, int ai1[], int l, int i1) {
		if (i >= 0)
			return;
		i1 <<= 1;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 8;
		for (int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 8);
		for (int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k;
			if ((l1 & 1) == 1) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
			}
		}

	}

	public static void method295(int ai[], int i, int j, int k, int ai1[], int l, int i1) {
		if (i >= 0)
			return;
		i1 <<= 2;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 16;
		for (int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 16);
		for (int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k + (ai[j] >> 1 & 0x7f7f7f);
			if ((l1 & 3) == 3) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
				l += i1;
			}
		}

	}

	public static void method296(int ai[], int i, int j, int k, int ai1[], int l, int i1) {
		if (i >= 0)
			return;
		i1 <<= 2;
		k = ai1[l >> 8 & 0xff];
		l += i1;
		int j1 = i / 16;
		for (int k1 = j1; k1 < 0; k1++) {
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			ai[j++] = k;
			k = ai1[l >> 8 & 0xff];
			l += i1;
		}

		j1 = -(i % 16);
		for (int l1 = 0; l1 < j1; l1++) {
			ai[j++] = k;
			if ((l1 & 3) == 3) {
				k = ai1[l >> 8 & 0xff];
				l += i1;
			}
		}

	}

	public static int method310(int i, int j, int k) {
		return -1 - (i / 8) * 1024 - (j / 8) * 32 - k / 8;
	}

	public boolean gameHasTicked;
	public boolean isLowDetail;
	public boolean aBooleanArray440[];
	public byte aByteArrayArray435[][];
	public CameraModel cameraModels[];
	public CameraVariables aClass9Array448[];
	public double aDouble397;
	public GameImage gameImage;
	public long aLongArray438[];
	public Model currentModel;
	public Model visibleModels[];
	public Model models[];
	public int anInt384;
	public int lastCameraModelCount;
	public int anInt389;
	public int zoom1;
	public int zoom2;
	public int zoom3;
	public int zoom4;
	public int anInt398;
	public int mouseX;
	public int mouseY;
	public int currentVisibleModelCount;
	public int maxVisibleModelCount;
	public int width;
	public int halfWidth;
	public int halfHeight;
	public int halfWidth2;
	public int halfHeight2;
	public int cameraSize;
	public int anInt412;
	public int anInt413;
	public int anInt414;
	public int anInt415;
	public int anInt416;
	public int anInt417;
	public int anInt418;
	public int modelCount;
	public int maxModelCount;
	public int cameraModelCount;
	public int entityCount;
	public int anInt434;
	public int anInt449;
	public int anInt450;
	public int anInt464;
	public int anInt465;
	public int anIntArray385[];
	public int anIntArray387[];
	public int visibleModelHandles[];
	public int anIntArray422[];
	public int anIntArray426[];
	public int anIntArray427[];
	public int anIntArray428[];
	public int anIntArray429[];
	public int anIntArray430[];
	public int anIntArray431[];
	public int entityOffset[];
	public int anIntArray437[];
	public int anIntArray447[];
	public int anIntArray451[];
	public int anIntArray452[];
	public int anIntArray453[];
	public int anIntArray454[];
	public int anIntArray455[];
	public int anIntArray456[];
	public int anIntArrayArray386[][];
	public int anIntArrayArray436[][];
	public int anIntArrayArray439[][];
	public int anIntArrayArray442[][];
	public int anIntArrayArray443[][];

	public Camera(GameImage gameImage, int i, int j, int k) {
		anInt384 = 50;
		anIntArray385 = new int[anInt384];
		anIntArrayArray386 = new int[anInt384][256];
		anInt389 = 5;
		zoom1 = 1000;
		zoom2 = 1000;
		zoom3 = 20;
		zoom4 = 10;
		aDouble397 = 1.1000000000000001D;
		anInt398 = 1;
		gameHasTicked = false;
		maxVisibleModelCount = 100;
		visibleModels = new Model[maxVisibleModelCount];
		visibleModelHandles = new int[maxVisibleModelCount];
		width = 512;
		halfWidth = 256;
		halfHeight = 192;
		halfWidth2 = 256;
		halfHeight2 = 256;
		cameraSize = 8;
		anInt412 = 4;
		anIntArray451 = new int[40];
		anIntArray452 = new int[40];
		anIntArray453 = new int[40];
		anIntArray454 = new int[40];
		anIntArray455 = new int[40];
		anIntArray456 = new int[40];
		isLowDetail = false;
		this.gameImage = gameImage;
		halfWidth = gameImage.defaultMenuWidth / 2;
		halfHeight = gameImage.defaultMenuHeight / 2;
		anIntArray447 = gameImage.imagePixelArray;
		modelCount = 0;
		maxModelCount = i;
		models = new Model[maxModelCount];
		anIntArray422 = new int[maxModelCount];
		cameraModelCount = 0;
		cameraModels = new CameraModel[j];
		for (int l = 0; l < j; l++) {
			cameraModels[l] = new CameraModel();
		}

		entityCount = 0;
		currentModel = new Model(k * 2, k);
		anIntArray426 = new int[k];
		anIntArray430 = new int[k];
		anIntArray431 = new int[k];
		anIntArray427 = new int[k];
		anIntArray428 = new int[k];
		anIntArray429 = new int[k];
		entityOffset = new int[k];
		anInt413 = 0;
		anInt414 = 0;
		anInt415 = 0;
		anInt416 = 0;
		anInt417 = 0;
		anInt418 = 0;
		for (int i1 = 0; i1 < 256; i1++) {
			MINIMAP_VAR2[i1] = (int) (Math.sin(i1 * 0.02454369D) * 32768D);
			MINIMAP_VAR2[i1 + 256] = (int) (Math.cos(i1 * 0.02454369D) * 32768D);
		}

		for (int j1 = 0; j1 < 1024; j1++) {
			MINIMAP_VAR1[j1] = (int) (Math.sin(j1 * 0.00613592315D) * 32768D);
			MINIMAP_VAR1[j1 + 1024] = (int) (Math.cos(j1 * 0.00613592315D) * 32768D);
		}

	}

	public int addEntity(int i, int j, int k, int l, int i1, int j1, int k1) {
		anIntArray426[entityCount] = i;
		anIntArray427[entityCount] = j;
		anIntArray428[entityCount] = k;
		anIntArray429[entityCount] = l;
		anIntArray430[entityCount] = i1;
		anIntArray431[entityCount] = j1;
		entityOffset[entityCount] = 0;
		int l1 = currentModel.method180(j, k, l);
		int i2 = currentModel.method180(j, k - j1, l);
		int ai[] = { l1, i2 };
		currentModel.method181(2, ai, 0, 0);
		currentModel.anIntArray258[entityCount] = k1;
		currentModel.aByteArray259[entityCount++] = 0;
		return entityCount - 1;
	}

	public void addModel(Model model) {
		if (model == null)
			System.out.println("Warning tried to add null object!");
		if (modelCount < maxModelCount) {
			anIntArray422[modelCount] = 0;
			models[modelCount++] = model;
		}
	}

	public void cleanupModels() {
		entityCount = 0;
		currentModel.method176();
		for (int i = 0; i < modelCount; i++)
			models[i] = null;

		modelCount = 0;
	}

	public void updateEntitiesAdded(int lastEntityCount) {
		entityCount -= lastEntityCount;
		currentModel.method177(lastEntityCount, lastEntityCount * 2);
		if (entityCount < 0)
			entityCount = 0;
	}

	public void setOurPlayer(int i) {
		currentModel.aByteArray259[i] = 1;
	}

	public void setOffset(int entityIndex, int offset) {
		entityOffset[entityIndex] = offset;
	}

	public void updateMouseCoords(int x, int y) {
		mouseX = x - halfWidth2;
		mouseY = y;
		currentVisibleModelCount = 0;
		gameHasTicked = true;
	}

	public int getCurrentVisibleModelCount() {
		return currentVisibleModelCount;
	}

	public int[] getVisibleModelHandles() {
		return visibleModelHandles;
	}

	public Model[] getVisibleModels() {
		return visibleModels;
	}

	public void setCameraSize(int halfWindowWidth, int halfWindowHeight, int windowWidth, int windowHeight) {
		halfWidth = halfWidth2 = halfWindowWidth;
		halfHeight = halfHeight2 = halfWindowHeight;
		width = windowWidth;
		cameraSize = 9;
		aClass9Array448 = new CameraVariables[windowHeight];
		for (int k1 = 0; k1 < windowHeight; k1++)
			aClass9Array448[k1] = new CameraVariables();
	}

	public void method281(CameraModel aclass7[], int i, int j) {
		if (i < j) {
			int k = i - 1;
			int l = j + 1;
			int i1 = (i + j) / 2;
			CameraModel class7 = aclass7[i1];
			aclass7[i1] = aclass7[i];
			aclass7[i] = class7;
			int j1 = class7.anInt361;
			while (k < l) {
				do
					l--;
				while (aclass7[l].anInt361 < j1);
				do
					k++;
				while (aclass7[k].anInt361 > j1);
				if (k < l) {
					CameraModel class7_1 = aclass7[k];
					aclass7[k] = aclass7[l];
					aclass7[l] = class7_1;
				}
			}
			method281(aclass7, i, l);
			method281(aclass7, l + 1, j);
		}
	}

	public void method282(int i, CameraModel aclass7[], int j) {
		for (int k = 0; k <= j; k++) {
			aclass7[k].aBoolean367 = false;
			aclass7[k].anInt368 = k;
			aclass7[k].anInt369 = -1;
		}

		int l = 0;
		do {
			while (aclass7[l].aBoolean367)
				l++;
			if (l == j)
				return;
			CameraModel class7 = aclass7[l];
			class7.aBoolean367 = true;
			int i1 = l;
			int j1 = l + i;
			if (j1 >= j)
				j1 = j - 1;
			for (int k1 = j1; k1 >= i1 + 1; k1--) {
				CameraModel class7_1 = aclass7[k1];
				if (class7.anInt353 < class7_1.anInt355 && class7_1.anInt353 < class7.anInt355 && class7.anInt354 < class7_1.anInt356
						&& class7_1.anInt354 < class7.anInt356 && class7.anInt368 != class7_1.anInt369 && !method300(class7, class7_1)
						&& method301(class7_1, class7)) {
					method283(aclass7, i1, k1);
					if (aclass7[k1] != class7_1)
						k1++;
					i1 = anInt464;
					class7_1.anInt369 = class7.anInt368;
				}
			}

		} while (true);
	}

	public boolean method283(CameraModel aclass7[], int i, int j) {
		do {
			CameraModel class7 = aclass7[i];
			for (int k = i + 1; k <= j; k++) {
				CameraModel class7_1 = aclass7[k];
				if (!method300(class7_1, class7))
					break;
				aclass7[i] = class7_1;
				aclass7[k] = class7;
				i = k;
				if (i == j) {
					anInt464 = i;
					anInt465 = i - 1;
					return true;
				}
			}

			CameraModel class7_2 = aclass7[j];
			for (int l = j - 1; l >= i; l--) {
				CameraModel class7_3 = aclass7[l];
				if (!method300(class7_2, class7_3))
					break;
				aclass7[j] = class7_3;
				aclass7[l] = class7_2;
				j = l;
				if (i == j) {
					anInt464 = j + 1;
					anInt465 = j;
					return true;
				}
			}

			if (i + 1 >= j) {
				anInt464 = i;
				anInt465 = j;
				return false;
			}
			if (!method283(aclass7, i + 1, j)) {
				anInt464 = i;
				return false;
			}
			j = anInt465;
		} while (true);
	}

	public void method284(int i, int j, int k) {
		int l = -anInt416 + 1024 & 0x3ff;
		int i1 = -anInt417 + 1024 & 0x3ff;
		int j1 = -anInt418 + 1024 & 0x3ff;
		if (j1 != 0) {
			int k1 = MINIMAP_VAR1[j1];
			int j2 = MINIMAP_VAR1[j1 + 1024];
			int i3 = j * k1 + i * j2 >> 15;
			j = j * j2 - i * k1 >> 15;
			i = i3;
		}
		if (l != 0) {
			int l1 = MINIMAP_VAR1[l];
			int k2 = MINIMAP_VAR1[l + 1024];
			int j3 = j * k2 - k * l1 >> 15;
			k = j * l1 + k * k2 >> 15;
			j = j3;
		}
		if (i1 != 0) {
			int i2 = MINIMAP_VAR1[i1];
			int l2 = MINIMAP_VAR1[i1 + 1024];
			int k3 = k * i2 + i * l2 >> 15;
			k = k * l2 - i * i2 >> 15;
			i = k3;
		}
		if (i < anInt458)
			anInt458 = i;
		if (i > anInt459)
			anInt459 = i;
		if (j < anInt460)
			anInt460 = j;
		if (j > anInt461)
			anInt461 = j;
		if (k < anInt462)
			anInt462 = k;
		if (k > anInt463)
			anInt463 = k;
	}

	public void processCamera() {
		isLowDetail = gameImage.lowDetailToggle;
		int i3 = halfWidth * zoom1 >> cameraSize;
		int j3 = halfHeight * zoom1 >> cameraSize;
		anInt458 = 0;
		anInt459 = 0;
		anInt460 = 0;
		anInt461 = 0;
		anInt462 = 0;
		anInt463 = 0;
		method284(-i3, -j3, zoom1);
		method284(-i3, j3, zoom1);
		method284(i3, -j3, zoom1);
		method284(i3, j3, zoom1);
		method284(-halfWidth, -halfHeight, 0);
		method284(-halfWidth, halfHeight, 0);
		method284(halfWidth, -halfHeight, 0);
		method284(halfWidth, halfHeight, 0);
		anInt458 += anInt413;
		anInt459 += anInt413;
		anInt460 += anInt414;
		anInt461 += anInt414;
		anInt462 += anInt415;
		anInt463 += anInt415;
		models[modelCount] = currentModel;
		currentModel.anInt246 = 2;
		for (int i = 0; i < modelCount; i++) {
			models[i].method201(anInt413, anInt414, anInt415, anInt416, anInt417, anInt418, cameraSize, anInt389);
		}

		models[modelCount].method201(anInt413, anInt414, anInt415, anInt416, anInt417, anInt418, cameraSize, anInt389);
		cameraModelCount = 0;
		for (int k3 = 0; k3 < modelCount; k3++) {
			Model model = models[k3];
			if (model.aBoolean247) {
				for (int j = 0; j < model.anInt234; j++) {
					int l3 = model.anIntArray235[j];
					int ai1[] = model.anIntArrayArray236[j];
					boolean flag = false;
					for (int k4 = 0; k4 < l3; k4++) {
						int i1 = model.anIntArray229[ai1[k4]];
						if (i1 <= anInt389 || i1 >= zoom1)
							continue;
						flag = true;
						break;
					}

					if (flag) {
						int l1 = 0;
						for (int k5 = 0; k5 < l3; k5++) {
							int j1 = model.anIntArray230[ai1[k5]];
							if (j1 > -halfWidth)
								l1 |= 1;
							if (j1 < halfWidth)
								l1 |= 2;
							if (l1 == 3)
								break;
						}

						if (l1 == 3) {
							int i2 = 0;
							for (int l6 = 0; l6 < l3; l6++) {
								int k1 = model.anIntArray231[ai1[l6]];
								if (k1 > -halfHeight)
									i2 |= 1;
								if (k1 < halfHeight)
									i2 |= 2;
								if (i2 == 3)
									break;
							}

							if (i2 == 3) {
								CameraModel class7_1 = cameraModels[cameraModelCount];
								class7_1.aModel_359 = model;
								class7_1.anInt360 = j;
								method298(cameraModelCount);
								int l8;
								if (class7_1.anInt365 < 0) {
									l8 = model.anIntArray237[j];
								} else {
									l8 = model.anIntArray238[j];
								}
								if (l8 != 0xbc614e) {
									int j2 = 0;
									for (int l9 = 0; l9 < l3; l9++) {
										j2 += model.anIntArray229[ai1[l9]];
									}

									class7_1.anInt361 = j2 / l3 + model.anInt245;
									class7_1.anInt366 = l8;
									cameraModelCount++;
								}
							}
						}
					}
				}

			}
		}

		Model model_1 = currentModel;
		if (model_1.aBoolean247) {
			for (int k = 0; k < model_1.anInt234; k++) {
				int ai[] = model_1.anIntArrayArray236[k];
				int j4 = ai[0];
				int l4 = model_1.anIntArray230[j4];
				int l5 = model_1.anIntArray231[j4];
				int i7 = model_1.anIntArray229[j4];
				if (i7 > anInt389 && i7 < zoom2) {
					int i8 = (anIntArray430[k] << cameraSize) / i7;
					int i9 = (anIntArray431[k] << cameraSize) / i7;
					if (l4 - i8 / 2 <= halfWidth && l4 + i8 / 2 >= -halfWidth && l5 - i9 <= halfHeight && l5 >= -halfHeight) {
						CameraModel class7_2 = cameraModels[cameraModelCount];
						class7_2.aModel_359 = model_1;
						class7_2.anInt360 = k;
						method299(cameraModelCount);
						class7_2.anInt361 = (i7 + model_1.anIntArray229[ai[1]]) / 2;
						cameraModelCount++;
					}
				}
			}

		}
		if (cameraModelCount == 0)
			return;
		method281(cameraModels, 0, cameraModelCount - 1);
		method282(100, cameraModels, cameraModelCount);
		for (int i4 = 0; i4 < cameraModelCount; i4++) {
			CameraModel class7 = cameraModels[i4];
			Model model_2 = class7.aModel_359;
			int l = class7.anInt360;
			if (model_2 == currentModel) {
				int ai2[] = model_2.anIntArrayArray236[l];
				int i6 = ai2[0];
				int j7 = model_2.anIntArray230[i6];
				int j8 = model_2.anIntArray231[i6];
				int j9 = model_2.anIntArray229[i6];
				int i10 = (anIntArray430[l] << cameraSize) / j9;
				int k10 = (anIntArray431[l] << cameraSize) / j9;
				int j11 = model_2.anIntArray230[ai2[1]] - j7;
				int l11 = j7 - i10 / 2;
				int j12 = (halfHeight2 + j8) - k10;
				gameImage.drawGameEntity(l11 + halfWidth2, j12, i10, k10, anIntArray426[l], j11, (256 << cameraSize) / j9);
				if (gameHasTicked && currentVisibleModelCount < maxVisibleModelCount) {
					l11 += (entityOffset[l] << cameraSize) / j9;
					if (mouseY >= j12 && mouseY <= j12 + k10 && mouseX >= l11 && mouseX <= l11 + i10 && !model_2.aBoolean263
							&& model_2.aByteArray259[l] == 0) {
						visibleModels[currentVisibleModelCount] = model_2;
						visibleModelHandles[currentVisibleModelCount] = l;
						currentVisibleModelCount++;
					}
				}
			} else {
				int k8 = 0;
				int j10 = 0;
				int l10 = model_2.anIntArray235[l];
				int ai3[] = model_2.anIntArrayArray236[l];
				if (model_2.anIntArray241[l] != 0xbc614e) {
					if (class7.anInt365 < 0) {
						j10 = model_2.anInt308 - model_2.anIntArray241[l];
					} else {
						j10 = model_2.anInt308 + model_2.anIntArray241[l];
					}
				}
				for (int k11 = 0; k11 < l10; k11++) {
					int k2 = ai3[k11];
					anIntArray454[k11] = model_2.anIntArray227[k2];
					anIntArray455[k11] = model_2.anIntArray228[k2];
					anIntArray456[k11] = model_2.anIntArray229[k2];
					if (model_2.anIntArray241[l] == 0xbc614e) {
						if (class7.anInt365 < 0) {
							j10 = (model_2.anInt308 - model_2.anIntArray232[k2]) + model_2.aByteArray233[k2];
						} else {
							j10 = model_2.anInt308 + model_2.anIntArray232[k2] + model_2.aByteArray233[k2];
						}
					}
					if (model_2.anIntArray229[k2] >= anInt389) {
						anIntArray451[k8] = model_2.anIntArray230[k2];
						anIntArray452[k8] = model_2.anIntArray231[k2];
						anIntArray453[k8] = j10;
						if (model_2.anIntArray229[k2] > zoom4) {
							anIntArray453[k8] += (model_2.anIntArray229[k2] - zoom4) / zoom3;
						}
						k8++;
					} else {
						int k9;
						if (k11 == 0) {
							k9 = ai3[l10 - 1];
						} else {
							k9 = ai3[k11 - 1];
						}
						if (model_2.anIntArray229[k9] >= anInt389) {
							int k7 = model_2.anIntArray229[k2] - model_2.anIntArray229[k9];
							int i5 = model_2.anIntArray227[k2]
									- ((model_2.anIntArray227[k2] - model_2.anIntArray227[k9]) * (model_2.anIntArray229[k2] - anInt389)) / k7;
							int j6 = model_2.anIntArray228[k2]
									- ((model_2.anIntArray228[k2] - model_2.anIntArray228[k9]) * (model_2.anIntArray229[k2] - anInt389)) / k7;
							anIntArray451[k8] = (i5 << cameraSize) / anInt389;
							anIntArray452[k8] = (j6 << cameraSize) / anInt389;
							anIntArray453[k8] = j10;
							k8++;
						}
						if (k11 == l10 - 1) {
							k9 = ai3[0];
						} else {
							k9 = ai3[k11 + 1];
						}
						if (model_2.anIntArray229[k9] >= anInt389) {
							int l7 = model_2.anIntArray229[k2] - model_2.anIntArray229[k9];
							int j5 = model_2.anIntArray227[k2]
									- ((model_2.anIntArray227[k2] - model_2.anIntArray227[k9]) * (model_2.anIntArray229[k2] - anInt389)) / l7;
							int k6 = model_2.anIntArray228[k2]
									- ((model_2.anIntArray228[k2] - model_2.anIntArray228[k9]) * (model_2.anIntArray229[k2] - anInt389)) / l7;
							anIntArray451[k8] = (j5 << cameraSize) / anInt389;
							anIntArray452[k8] = (k6 << cameraSize) / anInt389;
							anIntArray453[k8] = j10;
							k8++;
						}
					}
				}

				for (int i12 = 0; i12 < l10; i12++) {
					if (anIntArray453[i12] < 0) {
						anIntArray453[i12] = 0;
					} else if (anIntArray453[i12] > 255)
						anIntArray453[i12] = 255;
					if (class7.anInt366 >= 0) {
						if (anIntArray437[class7.anInt366] == 1) {
							anIntArray453[i12] <<= 9;
						} else {
							anIntArray453[i12] <<= 6;
						}
					}
				}

				method286(0, 0, 0, 0, k8, anIntArray451, anIntArray452, anIntArray453, model_2, l);
				if (anInt450 > anInt449) {
					method287(0, 0, l10, anIntArray454, anIntArray455, anIntArray456, class7.anInt366, model_2);
				}
			}
		}

		gameHasTicked = false;
	}

	public void method286(int i, int j, int k, int l, int i1, int ai[], int ai1[], int ai2[], Model model, int j1) {
		if (i1 == 3) {
			int k1 = ai1[0] + halfHeight2;
			int k2 = ai1[1] + halfHeight2;
			int k3 = ai1[2] + halfHeight2;
			int k4 = ai[0];
			int l5 = ai[1];
			int j7 = ai[2];
			int l8 = ai2[0];
			int j10 = ai2[1];
			int j11 = ai2[2];
			int j12 = (halfHeight2 + halfHeight) - 1;
			int l12 = 0;
			int j13 = 0;
			int l13 = 0;
			int j14 = 0;
			int l14 = 0xbc614e;
			int j15 = 0xff439eb2;
			if (k3 != k1) {
				j13 = (j7 - k4 << 8) / (k3 - k1);
				j14 = (j11 - l8 << 8) / (k3 - k1);
				if (k1 < k3) {
					l12 = k4 << 8;
					l13 = l8 << 8;
					l14 = k1;
					j15 = k3;
				} else {
					l12 = j7 << 8;
					l13 = j11 << 8;
					l14 = k3;
					j15 = k1;
				}
				if (l14 < 0) {
					l12 -= j13 * l14;
					l13 -= j14 * l14;
					l14 = 0;
				}
				if (j15 > j12)
					j15 = j12;
			}
			int l15 = 0;
			int j16 = 0;
			int l16 = 0;
			int j17 = 0;
			int l17 = 0xbc614e;
			int j18 = 0xff439eb2;
			if (k2 != k1) {
				j16 = (l5 - k4 << 8) / (k2 - k1);
				j17 = (j10 - l8 << 8) / (k2 - k1);
				if (k1 < k2) {
					l15 = k4 << 8;
					l16 = l8 << 8;
					l17 = k1;
					j18 = k2;
				} else {
					l15 = l5 << 8;
					l16 = j10 << 8;
					l17 = k2;
					j18 = k1;
				}
				if (l17 < 0) {
					l15 -= j16 * l17;
					l16 -= j17 * l17;
					l17 = 0;
				}
				if (j18 > j12)
					j18 = j12;
			}
			int l18 = 0;
			int j19 = 0;
			int l19 = 0;
			int j20 = 0;
			int l20 = 0xbc614e;
			int j21 = 0xff439eb2;
			if (k3 != k2) {
				j19 = (j7 - l5 << 8) / (k3 - k2);
				j20 = (j11 - j10 << 8) / (k3 - k2);
				if (k2 < k3) {
					l18 = l5 << 8;
					l19 = j10 << 8;
					l20 = k2;
					j21 = k3;
				} else {
					l18 = j7 << 8;
					l19 = j11 << 8;
					l20 = k3;
					j21 = k2;
				}
				if (l20 < 0) {
					l18 -= j19 * l20;
					l19 -= j20 * l20;
					l20 = 0;
				}
				if (j21 > j12)
					j21 = j12;
			}
			anInt449 = l14;
			if (l17 < anInt449)
				anInt449 = l17;
			if (l20 < anInt449)
				anInt449 = l20;
			anInt450 = j15;
			if (j18 > anInt450)
				anInt450 = j18;
			if (j21 > anInt450)
				anInt450 = j21;
			int l21 = 0;
			for (k = anInt449; k < anInt450; k++) {
				if (k >= l14 && k < j15) {
					i = j = l12;
					l = l21 = l13;
					l12 += j13;
					l13 += j14;
				} else {
					i = 0xa0000;
					j = 0xfff60000;
				}
				if (k >= l17 && k < j18) {
					if (l15 < i) {
						i = l15;
						l = l16;
					}
					if (l15 > j) {
						j = l15;
						l21 = l16;
					}
					l15 += j16;
					l16 += j17;
				}
				if (k >= l20 && k < j21) {
					if (l18 < i) {
						i = l18;
						l = l19;
					}
					if (l18 > j) {
						j = l18;
						l21 = l19;
					}
					l18 += j19;
					l19 += j20;
				}
				CameraVariables class9_6 = aClass9Array448[k];
				class9_6.leftX = i;
				class9_6.leftY = j;
				class9_6.anInt382 = l;
				class9_6.anInt383 = l21;
			}

			if (anInt449 < halfHeight2 - halfHeight)
				anInt449 = halfHeight2 - halfHeight;
		} else if (i1 == 4) {
			int l1 = ai1[0] + halfHeight2;
			int l2 = ai1[1] + halfHeight2;
			int l3 = ai1[2] + halfHeight2;
			int l4 = ai1[3] + halfHeight2;
			int i6 = ai[0];
			int k7 = ai[1];
			int i9 = ai[2];
			int k10 = ai[3];
			int k11 = ai2[0];
			int k12 = ai2[1];
			int i13 = ai2[2];
			int k13 = ai2[3];
			int i14 = (halfHeight2 + halfHeight) - 1;
			int k14 = 0;
			int i15 = 0;
			int k15 = 0;
			int i16 = 0;
			int k16 = 0xbc614e;
			int i17 = 0xff439eb2;
			if (l4 != l1) {
				i15 = (k10 - i6 << 8) / (l4 - l1);
				i16 = (k13 - k11 << 8) / (l4 - l1);
				if (l1 < l4) {
					k14 = i6 << 8;
					k15 = k11 << 8;
					k16 = l1;
					i17 = l4;
				} else {
					k14 = k10 << 8;
					k15 = k13 << 8;
					k16 = l4;
					i17 = l1;
				}
				if (k16 < 0) {
					k14 -= i15 * k16;
					k15 -= i16 * k16;
					k16 = 0;
				}
				if (i17 > i14)
					i17 = i14;
			}
			int k17 = 0;
			int i18 = 0;
			int k18 = 0;
			int i19 = 0;
			int k19 = 0xbc614e;
			int i20 = 0xff439eb2;
			if (l2 != l1) {
				i18 = (k7 - i6 << 8) / (l2 - l1);
				i19 = (k12 - k11 << 8) / (l2 - l1);
				if (l1 < l2) {
					k17 = i6 << 8;
					k18 = k11 << 8;
					k19 = l1;
					i20 = l2;
				} else {
					k17 = k7 << 8;
					k18 = k12 << 8;
					k19 = l2;
					i20 = l1;
				}
				if (k19 < 0) {
					k17 -= i18 * k19;
					k18 -= i19 * k19;
					k19 = 0;
				}
				if (i20 > i14)
					i20 = i14;
			}
			int k20 = 0;
			int i21 = 0;
			int k21 = 0;
			int i22 = 0;
			int j22 = 0xbc614e;
			int k22 = 0xff439eb2;
			if (l3 != l2) {
				i21 = (i9 - k7 << 8) / (l3 - l2);
				i22 = (i13 - k12 << 8) / (l3 - l2);
				if (l2 < l3) {
					k20 = k7 << 8;
					k21 = k12 << 8;
					j22 = l2;
					k22 = l3;
				} else {
					k20 = i9 << 8;
					k21 = i13 << 8;
					j22 = l3;
					k22 = l2;
				}
				if (j22 < 0) {
					k20 -= i21 * j22;
					k21 -= i22 * j22;
					j22 = 0;
				}
				if (k22 > i14)
					k22 = i14;
			}
			int l22 = 0;
			int i23 = 0;
			int j23 = 0;
			int k23 = 0;
			int l23 = 0xbc614e;
			int i24 = 0xff439eb2;
			if (l4 != l3) {
				i23 = (k10 - i9 << 8) / (l4 - l3);
				k23 = (k13 - i13 << 8) / (l4 - l3);
				if (l3 < l4) {
					l22 = i9 << 8;
					j23 = i13 << 8;
					l23 = l3;
					i24 = l4;
				} else {
					l22 = k10 << 8;
					j23 = k13 << 8;
					l23 = l4;
					i24 = l3;
				}
				if (l23 < 0) {
					l22 -= i23 * l23;
					j23 -= k23 * l23;
					l23 = 0;
				}
				if (i24 > i14)
					i24 = i14;
			}
			anInt449 = k16;
			if (k19 < anInt449)
				anInt449 = k19;
			if (j22 < anInt449)
				anInt449 = j22;
			if (l23 < anInt449)
				anInt449 = l23;
			anInt450 = i17;
			if (i20 > anInt450)
				anInt450 = i20;
			if (k22 > anInt450)
				anInt450 = k22;
			if (i24 > anInt450)
				anInt450 = i24;
			int j24 = 0;
			for (k = anInt449; k < anInt450; k++) {
				if (k >= k16 && k < i17) {
					i = j = k14;
					l = j24 = k15;
					k14 += i15;
					k15 += i16;
				} else {
					i = 0xa0000;
					j = 0xfff60000;
				}
				if (k >= k19 && k < i20) {
					if (k17 < i) {
						i = k17;
						l = k18;
					}
					if (k17 > j) {
						j = k17;
						j24 = k18;
					}
					k17 += i18;
					k18 += i19;
				}
				if (k >= j22 && k < k22) {
					if (k20 < i) {
						i = k20;
						l = k21;
					}
					if (k20 > j) {
						j = k20;
						j24 = k21;
					}
					k20 += i21;
					k21 += i22;
				}
				if (k >= l23 && k < i24) {
					if (l22 < i) {
						i = l22;
						l = j23;
					}
					if (l22 > j) {
						j = l22;
						j24 = j23;
					}
					l22 += i23;
					j23 += k23;
				}
				CameraVariables class9_7 = aClass9Array448[k];
				class9_7.leftX = i;
				class9_7.leftY = j;
				class9_7.anInt382 = l;
				class9_7.anInt383 = j24;
			}

			if (anInt449 < halfHeight2 - halfHeight)
				anInt449 = halfHeight2 - halfHeight;
		} else {
			anInt450 = anInt449 = ai1[0] += halfHeight2;
			for (k = 1; k < i1; k++) {
				int i2;
				if ((i2 = ai1[k] += halfHeight2) < anInt449) {
					anInt449 = i2;
				} else if (i2 > anInt450)
					anInt450 = i2;
			}

			if (anInt449 < halfHeight2 - halfHeight)
				anInt449 = halfHeight2 - halfHeight;
			if (anInt450 >= halfHeight2 + halfHeight)
				anInt450 = (halfHeight2 + halfHeight) - 1;
			if (anInt449 >= anInt450)
				return;
			for (k = anInt449; k < anInt450; k++) {
				CameraVariables class9 = aClass9Array448[k];
				class9.leftX = 0xa0000;
				class9.leftY = 0xfff60000;
			}

			int j2 = i1 - 1;
			int i3 = ai1[0];
			int i4 = ai1[j2];
			if (i3 < i4) {
				int i5 = ai[0] << 8;
				int j6 = (ai[j2] - ai[0] << 8) / (i4 - i3);
				int l7 = ai2[0] << 8;
				int j9 = (ai2[j2] - ai2[0] << 8) / (i4 - i3);
				if (i3 < 0) {
					i5 -= j6 * i3;
					l7 -= j9 * i3;
					i3 = 0;
				}
				if (i4 > anInt450)
					i4 = anInt450;
				for (k = i3; k <= i4; k++) {
					CameraVariables class9_2 = aClass9Array448[k];
					class9_2.leftX = class9_2.leftY = i5;
					class9_2.anInt382 = class9_2.anInt383 = l7;
					i5 += j6;
					l7 += j9;
				}

			} else if (i3 > i4) {
				int j5 = ai[j2] << 8;
				int k6 = (ai[0] - ai[j2] << 8) / (i3 - i4);
				int i8 = ai2[j2] << 8;
				int k9 = (ai2[0] - ai2[j2] << 8) / (i3 - i4);
				if (i4 < 0) {
					j5 -= k6 * i4;
					i8 -= k9 * i4;
					i4 = 0;
				}
				if (i3 > anInt450)
					i3 = anInt450;
				for (k = i4; k <= i3; k++) {
					CameraVariables class9_3 = aClass9Array448[k];
					class9_3.leftX = class9_3.leftY = j5;
					class9_3.anInt382 = class9_3.anInt383 = i8;
					j5 += k6;
					i8 += k9;
				}

			}
			for (k = 0; k < j2; k++) {
				int k5 = k + 1;
				int j3 = ai1[k];
				int j4 = ai1[k5];
				if (j3 < j4) {
					int l6 = ai[k] << 8;
					int j8 = (ai[k5] - ai[k] << 8) / (j4 - j3);
					int l9 = ai2[k] << 8;
					int l10 = (ai2[k5] - ai2[k] << 8) / (j4 - j3);
					if (j3 < 0) {
						l6 -= j8 * j3;
						l9 -= l10 * j3;
						j3 = 0;
					}
					if (j4 > anInt450)
						j4 = anInt450;
					for (int l11 = j3; l11 <= j4; l11++) {
						CameraVariables class9_4 = aClass9Array448[l11];
						if (l6 < class9_4.leftX) {
							class9_4.leftX = l6;
							class9_4.anInt382 = l9;
						}
						if (l6 > class9_4.leftY) {
							class9_4.leftY = l6;
							class9_4.anInt383 = l9;
						}
						l6 += j8;
						l9 += l10;
					}

				} else if (j3 > j4) {
					int i7 = ai[k5] << 8;
					int k8 = (ai[k] - ai[k5] << 8) / (j3 - j4);
					int i10 = ai2[k5] << 8;
					int i11 = (ai2[k] - ai2[k5] << 8) / (j3 - j4);
					if (j4 < 0) {
						i7 -= k8 * j4;
						i10 -= i11 * j4;
						j4 = 0;
					}
					if (j3 > anInt450)
						j3 = anInt450;
					for (int i12 = j4; i12 <= j3; i12++) {
						CameraVariables class9_5 = aClass9Array448[i12];
						if (i7 < class9_5.leftX) {
							class9_5.leftX = i7;
							class9_5.anInt382 = i10;
						}
						if (i7 > class9_5.leftY) {
							class9_5.leftY = i7;
							class9_5.anInt383 = i10;
						}
						i7 += k8;
						i10 += i11;
					}

				}
			}

			if (anInt449 < halfHeight2 - halfHeight)
				anInt449 = halfHeight2 - halfHeight;
		}
		if (gameHasTicked && currentVisibleModelCount < maxVisibleModelCount && mouseY >= anInt449 && mouseY < anInt450) {
			CameraVariables class9_1 = aClass9Array448[mouseY];
			if (mouseX >= class9_1.leftX >> 8 && mouseX <= class9_1.leftY >> 8 && class9_1.leftX <= class9_1.leftY && !model.aBoolean263
					&& model.aByteArray259[j1] == 0) {
				visibleModels[currentVisibleModelCount] = model;
				visibleModelHandles[currentVisibleModelCount] = j1;
				currentVisibleModelCount++;
			}
		}
	}

	public void method287(int i, int j, int k, int ai[], int ai1[], int ai2[], int l, Model model) {
		if (l == -2)
			return;
		if (l >= 0) {
			if (l >= anInt434)
				l = 0;
			method304(l);
			int i1 = ai[0];
			int k1 = ai1[0];
			int j2 = ai2[0];
			int i3 = i1 - ai[1];
			int k3 = k1 - ai1[1];
			int i4 = j2 - ai2[1];
			k--;
			int i6 = ai[k] - i1;
			int j7 = ai1[k] - k1;
			int k8 = ai2[k] - j2;
			if (anIntArray437[l] == 1) {
				int l9 = i6 * k1 - j7 * i1 << 12;
				int k10 = j7 * j2 - k8 * k1 << (5 - cameraSize) + 7 + 4;
				int i11 = k8 * i1 - i6 * j2 << (5 - cameraSize) + 7;
				int k11 = i3 * k1 - k3 * i1 << 12;
				int i12 = k3 * j2 - i4 * k1 << (5 - cameraSize) + 7 + 4;
				int k12 = i4 * i1 - i3 * j2 << (5 - cameraSize) + 7;
				int i13 = k3 * i6 - i3 * j7 << 5;
				int k13 = i4 * j7 - k3 * k8 << (5 - cameraSize) + 4;
				int i14 = i3 * k8 - i4 * i6 >> cameraSize - 5;
				int k14 = k10 >> 4;
				int i15 = i12 >> 4;
				int k15 = k13 >> 4;
				int i16 = anInt449 - halfHeight2;
				int k16 = width;
				int i17 = halfWidth2 + anInt449 * k16;
				byte byte1 = 1;
				l9 += i11 * i16;
				k11 += k12 * i16;
				i13 += i14 * i16;
				if (isLowDetail) {
					if ((anInt449 & 1) == 1) {
						anInt449++;
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					}
					i11 <<= 1;
					k12 <<= 1;
					i14 <<= 1;
					k16 <<= 1;
					byte1 = 2;
				}
				if (model.aBoolean255) {
					for (i = anInt449; i < anInt450; i += byte1) {
						CameraVariables class9_3 = aClass9Array448[i];
						j = class9_3.leftX >> 8;
						int k17 = class9_3.leftY >> 8;
						int k20 = k17 - j;
						if (k20 <= 0) {
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						} else {
							int i22 = class9_3.anInt382;
							int k23 = (class9_3.anInt383 - i22) / k20;
							if (j < -halfWidth) {
								i22 += (-halfWidth - j) * k23;
								j = -halfWidth;
								k20 = k17 - j;
							}
							if (k17 > halfWidth) {
								int l17 = halfWidth;
								k20 = l17 - j;
							}
							method289(anIntArray447, anIntArrayArray439[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, k20, i17 + j, i22,
									k23 << 2);
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						}
					}

					return;
				}
				if (!aBooleanArray440[l]) {
					for (i = anInt449; i < anInt450; i += byte1) {
						CameraVariables class9_4 = aClass9Array448[i];
						j = class9_4.leftX >> 8;
						int i18 = class9_4.leftY >> 8;
						int l20 = i18 - j;
						if (l20 <= 0) {
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						} else {
							int j22 = class9_4.anInt382;
							int l23 = (class9_4.anInt383 - j22) / l20;
							if (j < -halfWidth) {
								j22 += (-halfWidth - j) * l23;
								j = -halfWidth;
								l20 = i18 - j;
							}
							if (i18 > halfWidth) {
								int j18 = halfWidth;
								l20 = j18 - j;
							}
							method288(anIntArray447, anIntArrayArray439[l], 0, 0, l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, l20, i17 + j, j22,
									l23 << 2);
							l9 += i11;
							k11 += k12;
							i13 += i14;
							i17 += k16;
						}
					}

					return;
				}
				for (i = anInt449; i < anInt450; i += byte1) {
					CameraVariables class9_5 = aClass9Array448[i];
					j = class9_5.leftX >> 8;
					int k18 = class9_5.leftY >> 8;
					int i21 = k18 - j;
					if (i21 <= 0) {
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					} else {
						int k22 = class9_5.anInt382;
						int i24 = (class9_5.anInt383 - k22) / i21;
						if (j < -halfWidth) {
							k22 += (-halfWidth - j) * i24;
							j = -halfWidth;
							i21 = k18 - j;
						}
						if (k18 > halfWidth) {
							int l18 = halfWidth;
							i21 = l18 - j;
						}
						method290(anIntArray447, 0, 0, 0, anIntArrayArray439[l], l9 + k14 * j, k11 + i15 * j, i13 + k15 * j, k10, i12, k13, i21, i17 + j, k22,
								i24);
						l9 += i11;
						k11 += k12;
						i13 += i14;
						i17 += k16;
					}
				}

				return;
			}
			int i10 = i6 * k1 - j7 * i1 << 11;
			int l10 = j7 * j2 - k8 * k1 << (5 - cameraSize) + 6 + 4;
			int j11 = k8 * i1 - i6 * j2 << (5 - cameraSize) + 6;
			int l11 = i3 * k1 - k3 * i1 << 11;
			int j12 = k3 * j2 - i4 * k1 << (5 - cameraSize) + 6 + 4;
			int l12 = i4 * i1 - i3 * j2 << (5 - cameraSize) + 6;
			int j13 = k3 * i6 - i3 * j7 << 5;
			int l13 = i4 * j7 - k3 * k8 << (5 - cameraSize) + 4;
			int j14 = i3 * k8 - i4 * i6 >> cameraSize - 5;
			int l14 = l10 >> 4;
			int j15 = j12 >> 4;
			int l15 = l13 >> 4;
			int j16 = anInt449 - halfHeight2;
			int l16 = width;
			int j17 = halfWidth2 + anInt449 * l16;
			byte byte2 = 1;
			i10 += j11 * j16;
			l11 += l12 * j16;
			j13 += j14 * j16;
			if (isLowDetail) {
				if ((anInt449 & 1) == 1) {
					anInt449++;
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				}
				j11 <<= 1;
				l12 <<= 1;
				j14 <<= 1;
				l16 <<= 1;
				byte2 = 2;
			}
			if (model.aBoolean255) {
				for (i = anInt449; i < anInt450; i += byte2) {
					CameraVariables class9_6 = aClass9Array448[i];
					j = class9_6.leftX >> 8;
					int i19 = class9_6.leftY >> 8;
					int j21 = i19 - j;
					if (j21 <= 0) {
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					} else {
						int l22 = class9_6.anInt382;
						int j24 = (class9_6.anInt383 - l22) / j21;
						if (j < -halfWidth) {
							l22 += (-halfWidth - j) * j24;
							j = -halfWidth;
							j21 = i19 - j;
						}
						if (i19 > halfWidth) {
							int j19 = halfWidth;
							j21 = j19 - j;
						}
						method292(anIntArray447, anIntArrayArray439[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, j21, j17 + j, l22,
								j24);
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					}
				}

				return;
			}
			if (!aBooleanArray440[l]) {
				for (i = anInt449; i < anInt450; i += byte2) {
					CameraVariables class9_7 = aClass9Array448[i];
					j = class9_7.leftX >> 8;
					int k19 = class9_7.leftY >> 8;
					int k21 = k19 - j;
					if (k21 <= 0) {
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					} else {
						int i23 = class9_7.anInt382;
						int k24 = (class9_7.anInt383 - i23) / k21;
						if (j < -halfWidth) {
							i23 += (-halfWidth - j) * k24;
							j = -halfWidth;
							k21 = k19 - j;
						}
						if (k19 > halfWidth) {
							int l19 = halfWidth;
							k21 = l19 - j;
						}
						method291(anIntArray447, anIntArrayArray439[l], 0, 0, i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, k21, j17 + j, i23,
								k24);
						i10 += j11;
						l11 += l12;
						j13 += j14;
						j17 += l16;
					}
				}

				return;
			}
			for (i = anInt449; i < anInt450; i += byte2) {
				CameraVariables class9_8 = aClass9Array448[i];
				j = class9_8.leftX >> 8;
				int i20 = class9_8.leftY >> 8;
				int l21 = i20 - j;
				if (l21 <= 0) {
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				} else {
					int j23 = class9_8.anInt382;
					int l24 = (class9_8.anInt383 - j23) / l21;
					if (j < -halfWidth) {
						j23 += (-halfWidth - j) * l24;
						j = -halfWidth;
						l21 = i20 - j;
					}
					if (i20 > halfWidth) {
						int j20 = halfWidth;
						l21 = j20 - j;
					}
					method293(anIntArray447, 0, 0, 0, anIntArrayArray439[l], i10 + l14 * j, l11 + j15 * j, j13 + l15 * j, l10, j12, l13, l21, j17 + j, j23, l24);
					i10 += j11;
					l11 += l12;
					j13 += j14;
					j17 += l16;
				}
			}

			return;
		}
		for (int j1 = 0; j1 < anInt384; j1++) {
			if (anIntArray385[j1] == l) {
				anIntArray387 = anIntArrayArray386[j1];
				break;
			}
			if (j1 == anInt384 - 1) {
				int l1 = (int) (Math.random() * anInt384);
				anIntArray385[l1] = l;
				l = -1 - l;
				int k2 = (l >> 10 & 0x1f) * 8;
				int j3 = (l >> 5 & 0x1f) * 8;
				int l3 = (l & 0x1f) * 8;
				for (int j4 = 0; j4 < 256; j4++) {
					int j6 = j4 * j4;
					int k7 = (k2 * j6) / 0x10000;
					int l8 = (j3 * j6) / 0x10000;
					int j10 = (l3 * j6) / 0x10000;
					anIntArrayArray386[l1][255 - j4] = (k7 << 16) + (l8 << 8) + j10;
				}

				anIntArray387 = anIntArrayArray386[l1];
			}
		}

		int i2 = width;
		int l2 = halfWidth2 + anInt449 * i2;
		byte byte0 = 1;
		if (isLowDetail) {
			if ((anInt449 & 1) == 1) {
				anInt449++;
				l2 += i2;
			}
			i2 <<= 1;
			byte0 = 2;
		}
		if (model.isGiantCrystal) {
			for (i = anInt449; i < anInt450; i += byte0) {
				CameraVariables class9 = aClass9Array448[i];
				j = class9.leftX >> 8;
				int k4 = class9.leftY >> 8;
				int k6 = k4 - j;
				if (k6 <= 0) {
					l2 += i2;
				} else {
					int l7 = class9.anInt382;
					int i9 = (class9.anInt383 - l7) / k6;
					if (j < -halfWidth) {
						l7 += (-halfWidth - j) * i9;
						j = -halfWidth;
						k6 = k4 - j;
					}
					if (k4 > halfWidth) {
						int l4 = halfWidth;
						k6 = l4 - j;
					}
					method295(anIntArray447, -k6, l2 + j, 0, anIntArray387, l7, i9);
					l2 += i2;
				}
			}

			return;
		}
		for (i = anInt449; i < anInt450; i += byte0) {
			CameraVariables class9_2 = aClass9Array448[i];
			j = class9_2.leftX >> 8;
			int k5 = class9_2.leftY >> 8;
			int i7 = k5 - j;
			if (i7 <= 0) {
				l2 += i2;
			} else {
				int j8 = class9_2.anInt382;
				int k9 = (class9_2.anInt383 - j8) / i7;
				if (j < -halfWidth) {
					j8 += (-halfWidth - j) * k9;
					j = -halfWidth;
					i7 = k5 - j;
				}
				if (k5 > halfWidth) {
					int l5 = halfWidth;
					i7 = l5 - j;
				}
				method296(anIntArray447, -i7, l2 + j, 0, anIntArray387, j8, k9);
				l2 += i2;
			}
		}

	}

	public void method297(int i, int j, int k, int l, int i1, int j1, int k1) {
		l &= 0x3ff;
		i1 &= 0x3ff;
		j1 &= 0x3ff;
		anInt416 = 1024 - l & 0x3ff;
		anInt417 = 1024 - i1 & 0x3ff;
		anInt418 = 1024 - j1 & 0x3ff;
		int l1 = 0;
		int i2 = 0;
		int j2 = k1;
		if (l != 0) {
			int k2 = MINIMAP_VAR1[l];
			int j3 = MINIMAP_VAR1[l + 1024];
			int i4 = i2 * j3 - j2 * k2 >> 15;
			j2 = i2 * k2 + j2 * j3 >> 15;
			i2 = i4;
		}
		if (i1 != 0) {
			int l2 = MINIMAP_VAR1[i1];
			int k3 = MINIMAP_VAR1[i1 + 1024];
			int j4 = j2 * l2 + l1 * k3 >> 15;
			j2 = j2 * k3 - l1 * l2 >> 15;
			l1 = j4;
		}
		if (j1 != 0) {
			int i3 = MINIMAP_VAR1[j1];
			int l3 = MINIMAP_VAR1[j1 + 1024];
			int k4 = i2 * i3 + l1 * l3 >> 15;
			i2 = i2 * l3 - l1 * i3 >> 15;
			l1 = k4;
		}
		anInt413 = i - l1;
		anInt414 = j - i2;
		anInt415 = k - j2;
	}

	public void method298(int i) {
		CameraModel class7 = cameraModels[i];
		Model model = class7.aModel_359;
		int j = class7.anInt360;
		int ai[] = model.anIntArrayArray236[j];
		int k = model.anIntArray235[j];
		int l = model.anIntArray240[j];
		int j1 = model.anIntArray227[ai[0]];
		int k1 = model.anIntArray228[ai[0]];
		int l1 = model.anIntArray229[ai[0]];
		int i2 = model.anIntArray227[ai[1]] - j1;
		int j2 = model.anIntArray228[ai[1]] - k1;
		int k2 = model.anIntArray229[ai[1]] - l1;
		int l2 = model.anIntArray227[ai[2]] - j1;
		int i3 = model.anIntArray228[ai[2]] - k1;
		int j3 = model.anIntArray229[ai[2]] - l1;
		int k3 = j2 * j3 - i3 * k2;
		int l3 = k2 * l2 - j3 * i2;
		int i4 = i2 * i3 - l2 * j2;
		if (l == -1) {
			l = 0;
			for (; k3 > 25000 || l3 > 25000 || i4 > 25000 || k3 < -25000 || l3 < -25000 || i4 < -25000; i4 >>= 1) {
				l++;
				k3 >>= 1;
				l3 >>= 1;
			}

			model.anIntArray240[j] = l;
			model.anIntArray239[j] = (int) (anInt412 * Math.sqrt(k3 * k3 + l3 * l3 + i4 * i4));
		} else {
			k3 >>= l;
			l3 >>= l;
			i4 >>= l;
		}
		class7.anInt365 = j1 * k3 + k1 * l3 + l1 * i4;
		class7.anInt362 = k3;
		class7.anInt363 = l3;
		class7.anInt364 = i4;
		int j4 = model.anIntArray229[ai[0]];
		int k4 = j4;
		int l4 = model.anIntArray230[ai[0]];
		int i5 = l4;
		int j5 = model.anIntArray231[ai[0]];
		int k5 = j5;
		for (int l5 = 1; l5 < k; l5++) {
			int i1 = model.anIntArray229[ai[l5]];
			if (i1 > k4) {
				k4 = i1;
			} else if (i1 < j4)
				j4 = i1;
			i1 = model.anIntArray230[ai[l5]];
			if (i1 > i5) {
				i5 = i1;
			} else if (i1 < l4)
				l4 = i1;
			i1 = model.anIntArray231[ai[l5]];
			if (i1 > k5) {
				k5 = i1;
			} else if (i1 < j5)
				j5 = i1;
		}

		class7.anInt357 = j4;
		class7.anInt358 = k4;
		class7.anInt353 = l4;
		class7.anInt355 = i5;
		class7.anInt354 = j5;
		class7.anInt356 = k5;
	}

	public void method299(int i) {
		CameraModel class7 = cameraModels[i];
		Model model = class7.aModel_359;
		int j = class7.anInt360;
		int ai[] = model.anIntArrayArray236[j];
		int l = 0;
		int i1 = 0;
		int j1 = 1;
		int k1 = model.anIntArray227[ai[0]];
		int l1 = model.anIntArray228[ai[0]];
		int i2 = model.anIntArray229[ai[0]];
		model.anIntArray239[j] = 1;
		model.anIntArray240[j] = 0;
		class7.anInt365 = k1 * l + l1 * i1 + i2 * j1;
		class7.anInt362 = l;
		class7.anInt363 = i1;
		class7.anInt364 = j1;
		int j2 = model.anIntArray229[ai[0]];
		int k2 = j2;
		int l2 = model.anIntArray230[ai[0]];
		int i3 = l2;
		if (model.anIntArray230[ai[1]] < l2) {
			l2 = model.anIntArray230[ai[1]];
		} else {
			i3 = model.anIntArray230[ai[1]];
		}
		int j3 = model.anIntArray231[ai[1]];
		int k3 = model.anIntArray231[ai[0]];
		int k = model.anIntArray229[ai[1]];
		if (k > k2) {
			k2 = k;
		} else if (k < j2)
			j2 = k;
		k = model.anIntArray230[ai[1]];
		if (k > i3) {
			i3 = k;
		} else if (k < l2)
			l2 = k;
		k = model.anIntArray231[ai[1]];
		if (k > k3) {
			k3 = k;
		} else if (k < j3)
			j3 = k;
		class7.anInt357 = j2;
		class7.anInt358 = k2;
		class7.anInt353 = l2 - 20;
		class7.anInt355 = i3 + 20;
		class7.anInt354 = j3;
		class7.anInt356 = k3;
	}

	public boolean method300(CameraModel class7, CameraModel class7_1) {
		if (class7.anInt353 >= class7_1.anInt355)
			return true;
		if (class7_1.anInt353 >= class7.anInt355)
			return true;
		if (class7.anInt354 >= class7_1.anInt356)
			return true;
		if (class7_1.anInt354 >= class7.anInt356)
			return true;
		if (class7.anInt357 >= class7_1.anInt358)
			return true;
		if (class7_1.anInt357 > class7.anInt358)
			return false;
		Model model = class7.aModel_359;
		Model model_1 = class7_1.aModel_359;
		int i = class7.anInt360;
		int j = class7_1.anInt360;
		int ai[] = model.anIntArrayArray236[i];
		int ai1[] = model_1.anIntArrayArray236[j];
		int k = model.anIntArray235[i];
		int l = model_1.anIntArray235[j];
		int k2 = model_1.anIntArray227[ai1[0]];
		int l2 = model_1.anIntArray228[ai1[0]];
		int i3 = model_1.anIntArray229[ai1[0]];
		int j3 = class7_1.anInt362;
		int k3 = class7_1.anInt363;
		int l3 = class7_1.anInt364;
		int i4 = model_1.anIntArray239[j];
		int j4 = class7_1.anInt365;
		boolean flag = false;
		for (int k4 = 0; k4 < k; k4++) {
			int i1 = ai[k4];
			int i2 = (k2 - model.anIntArray227[i1]) * j3 + (l2 - model.anIntArray228[i1]) * k3 + (i3 - model.anIntArray229[i1]) * l3;
			if ((i2 >= -i4 || j4 >= 0) && (i2 <= i4 || j4 <= 0))
				continue;
			flag = true;
			break;
		}

		if (!flag)
			return true;
		k2 = model.anIntArray227[ai[0]];
		l2 = model.anIntArray228[ai[0]];
		i3 = model.anIntArray229[ai[0]];
		j3 = class7.anInt362;
		k3 = class7.anInt363;
		l3 = class7.anInt364;
		i4 = model.anIntArray239[i];
		j4 = class7.anInt365;
		flag = false;
		for (int l4 = 0; l4 < l; l4++) {
			int j1 = ai1[l4];
			int j2 = (k2 - model_1.anIntArray227[j1]) * j3 + (l2 - model_1.anIntArray228[j1]) * k3 + (i3 - model_1.anIntArray229[j1]) * l3;
			if ((j2 >= -i4 || j4 <= 0) && (j2 <= i4 || j4 >= 0))
				continue;
			flag = true;
			break;
		}

		if (!flag)
			return true;
		int ai2[];
		int ai3[];
		if (k == 2) {
			ai2 = new int[4];
			ai3 = new int[4];
			int i5 = ai[0];
			int k1 = ai[1];
			ai2[0] = model.anIntArray230[i5] - 20;
			ai2[1] = model.anIntArray230[k1] - 20;
			ai2[2] = model.anIntArray230[k1] + 20;
			ai2[3] = model.anIntArray230[i5] + 20;
			ai3[0] = ai3[3] = model.anIntArray231[i5];
			ai3[1] = ai3[2] = model.anIntArray231[k1];
		} else {
			ai2 = new int[k];
			ai3 = new int[k];
			for (int j5 = 0; j5 < k; j5++) {
				int i6 = ai[j5];
				ai2[j5] = model.anIntArray230[i6];
				ai3[j5] = model.anIntArray231[i6];
			}

		}
		int ai4[];
		int ai5[];
		if (l == 2) {
			ai4 = new int[4];
			ai5 = new int[4];
			int k5 = ai1[0];
			int l1 = ai1[1];
			ai4[0] = model_1.anIntArray230[k5] - 20;
			ai4[1] = model_1.anIntArray230[l1] - 20;
			ai4[2] = model_1.anIntArray230[l1] + 20;
			ai4[3] = model_1.anIntArray230[k5] + 20;
			ai5[0] = ai5[3] = model_1.anIntArray231[k5];
			ai5[1] = ai5[2] = model_1.anIntArray231[l1];
		} else {
			ai4 = new int[l];
			ai5 = new int[l];
			for (int l5 = 0; l5 < l; l5++) {
				int j6 = ai1[l5];
				ai4[l5] = model_1.anIntArray230[j6];
				ai5[l5] = model_1.anIntArray231[j6];
			}

		}
		return !method314(ai2, ai3, ai4, ai5);
	}

	public boolean method301(CameraModel class7, CameraModel class7_1) {
		Model model = class7.aModel_359;
		Model model_1 = class7_1.aModel_359;
		int i = class7.anInt360;
		int j = class7_1.anInt360;
		int ai[] = model.anIntArrayArray236[i];
		int ai1[] = model_1.anIntArrayArray236[j];
		int k = model.anIntArray235[i];
		int l = model_1.anIntArray235[j];
		int i2 = model_1.anIntArray227[ai1[0]];
		int j2 = model_1.anIntArray228[ai1[0]];
		int k2 = model_1.anIntArray229[ai1[0]];
		int l2 = class7_1.anInt362;
		int i3 = class7_1.anInt363;
		int j3 = class7_1.anInt364;
		int k3 = model_1.anIntArray239[j];
		int l3 = class7_1.anInt365;
		boolean flag = false;
		for (int i4 = 0; i4 < k; i4++) {
			int i1 = ai[i4];
			int k1 = (i2 - model.anIntArray227[i1]) * l2 + (j2 - model.anIntArray228[i1]) * i3 + (k2 - model.anIntArray229[i1]) * j3;
			if ((k1 >= -k3 || l3 >= 0) && (k1 <= k3 || l3 <= 0))
				continue;
			flag = true;
			break;
		}

		if (!flag)
			return true;
		i2 = model.anIntArray227[ai[0]];
		j2 = model.anIntArray228[ai[0]];
		k2 = model.anIntArray229[ai[0]];
		l2 = class7.anInt362;
		i3 = class7.anInt363;
		j3 = class7.anInt364;
		k3 = model.anIntArray239[i];
		l3 = class7.anInt365;
		flag = false;
		for (int j4 = 0; j4 < l; j4++) {
			int j1 = ai1[j4];
			int l1 = (i2 - model_1.anIntArray227[j1]) * l2 + (j2 - model_1.anIntArray228[j1]) * i3 + (k2 - model_1.anIntArray229[j1]) * j3;
			if ((l1 >= -k3 || l3 <= 0) && (l1 <= k3 || l3 >= 0))
				continue;
			flag = true;
			break;
		}

		return !flag;
	}

	public void method302(int i, int j, int k) {
		anInt434 = i;
		aByteArrayArray435 = new byte[i][];
		anIntArrayArray436 = new int[i][];
		anIntArray437 = new int[i];
		aLongArray438 = new long[i];
		aBooleanArray440 = new boolean[i];
		anIntArrayArray439 = new int[i][];
		aLong441 = 0L;
		anIntArrayArray442 = new int[j][];
		anIntArrayArray443 = new int[k][];
	}

	public void method303(int i, byte abyte0[], int ai[], int j) {
		aByteArrayArray435[i] = abyte0;
		anIntArrayArray436[i] = ai;
		anIntArray437[i] = j;
		aLongArray438[i] = 0L;
		aBooleanArray440[i] = false;
		anIntArrayArray439[i] = null;
		method304(i);
	}

	public void method304(int i) {
		if (i < 0)
			return;
		aLongArray438[i] = aLong441++;
		if (anIntArrayArray439[i] != null)
			return;
		if (anIntArray437[i] == 0) {
			for (int j = 0; j < anIntArrayArray442.length; j++) {
				if (anIntArrayArray442[j] == null) {
					anIntArrayArray442[j] = new int[16384];
					anIntArrayArray439[i] = anIntArrayArray442[j];
					method305(i);
					return;
				}
			}

			long l = 1L << 30;
			int i1 = 0;
			for (int k1 = 0; k1 < anInt434; k1++) {
				if (k1 != i && anIntArray437[k1] == 0 && anIntArrayArray439[k1] != null && aLongArray438[k1] < l) {
					l = aLongArray438[k1];
					i1 = k1;
				}
			}

			anIntArrayArray439[i] = anIntArrayArray439[i1];
			anIntArrayArray439[i1] = null;
			method305(i);
			return;
		}
		for (int k = 0; k < anIntArrayArray443.length; k++) {
			if (anIntArrayArray443[k] == null) {
				anIntArrayArray443[k] = new int[0x10000];
				anIntArrayArray439[i] = anIntArrayArray443[k];
				method305(i);
				return;
			}
		}

		long l1 = 1L << 30;
		int j1 = 0;
		for (int i2 = 0; i2 < anInt434; i2++) {
			if (i2 != i && anIntArray437[i2] == 1 && anIntArrayArray439[i2] != null && aLongArray438[i2] < l1) {
				l1 = aLongArray438[i2];
				j1 = i2;
			}
		}

		anIntArrayArray439[i] = anIntArrayArray439[j1];
		anIntArrayArray439[j1] = null;
		method305(i);
	}

	public void method305(int i) {
		char c;
		if (anIntArray437[i] == 0) {
			c = '@';
		} else {
			c = '\200';
		}
		int ai[] = anIntArrayArray439[i];
		int j = 0;
		for (int k = 0; k < c; k++) {
			for (int l = 0; l < c; l++) {
				int j1 = anIntArrayArray436[i][aByteArrayArray435[i][l + k * c] & 0xff];
				j1 &= 0xf8f8ff;
				if (j1 == 0) {
					j1 = 1;
				} else if (j1 == 0xf800ff) {
					j1 = 0;
					aBooleanArray440[i] = true;
				}
				ai[j++] = j1;
			}

		}

		for (int i1 = 0; i1 < j; i1++) {
			int k1 = ai[i1];
			ai[j + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
			ai[j * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
			ai[j * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
		}

	}

	public void method306(int i) {
		if (anIntArrayArray439[i] == null)
			return;
		int ai[] = anIntArrayArray439[i];
		for (int j = 0; j < 64; j++) {
			int k = j + 4032;
			int l = ai[k];
			for (int j1 = 0; j1 < 63; j1++) {
				ai[k] = ai[k - 64];
				k -= 64;
			}

			anIntArrayArray439[i][k] = l;
		}

		char c = '\u1000';
		for (int i1 = 0; i1 < c; i1++) {
			int k1 = ai[i1];
			ai[c + i1] = k1 - (k1 >>> 3) & 0xf8f8ff;
			ai[c * 2 + i1] = k1 - (k1 >>> 2) & 0xf8f8ff;
			ai[c * 3 + i1] = k1 - (k1 >>> 2) - (k1 >>> 3) & 0xf8f8ff;
		}

	}

	public int method307(int i) {
		if (i == 0xbc614e)
			return 0;
		method304(i);
		if (i >= 0)
			return anIntArrayArray439[i][0];
		if (i < 0) {
			i = -(i + 1);
			int j = i >> 10 & 0x1f;
			int k = i >> 5 & 0x1f;
			int l = i & 0x1f;
			return (j << 19) + (k << 11) + (l << 3);
		} else {
			return 0;
		}
	}

	public void method308(int i, int j, int k) {
		if (i == 0 && j == 0 && k == 0)
			i = 32;
		for (int l = 0; l < modelCount; l++) {
			models[l].method186(i, j, k);
		}

	}

	public void method309(int i, int j, int k, int l, int i1) {
		if (k == 0 && l == 0 && i1 == 0)
			k = 32;
		for (int j1 = 0; j1 < modelCount; j1++) {
			models[j1].method185(i, j, k, l, i1);
		}

	}

	public int method311(int i, int j, int k, int l, int i1) {
		if (l == j) {
			return i;
		} else {
			return i + ((k - i) * (i1 - j)) / (l - j);
		}
	}

	public boolean method312(int i, int j, int k, int l, boolean flag) {
		if (flag && i <= k || i < k)
			return i > l || j > k || j > l || !flag;
		return i < l || j < k || j < l || flag;
	}

	public boolean method313(int i, int j, int k, boolean flag) {
		if (flag && i <= k || i < k)
			return j > k || !flag;
		return j > k || flag;
	}

	public boolean method314(int ai[], int ai1[], int ai2[], int ai3[]) {
		int i = ai.length;
		int j = ai2.length;
		byte byte0 = 0;
		int i20;
		int k20 = i20 = ai1[0];
		int k = 0;
		int j20;
		int l20 = j20 = ai3[0];
		int i1 = 0;
		for (int i21 = 1; i21 < i; i21++) {
			if (ai1[i21] < i20) {
				i20 = ai1[i21];
				k = i21;
			} else if (ai1[i21] > k20)
				k20 = ai1[i21];
		}

		for (int j21 = 1; j21 < j; j21++) {
			if (ai3[j21] < j20) {
				j20 = ai3[j21];
				i1 = j21;
			} else if (ai3[j21] > l20)
				l20 = ai3[j21];
		}

		if (j20 >= k20)
			return false;
		if (i20 >= l20)
			return false;
		int l;
		int j1;
		boolean flag;
		if (ai1[k] < ai3[i1]) {
			l = k;
			while (ai1[l] < ai3[i1])
				l = (l + 1) % i;
			while (ai1[k] < ai3[i1])
				k = ((k - 1) + i) % i;
			int k1 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
			int k6 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
			int l10 = ai2[i1];
			flag = (k1 < l10) | (k6 < l10);
			if (method313(k1, k6, l10, flag))
				return true;
			j1 = (i1 + 1) % j;
			i1 = ((i1 - 1) + j) % j;
			if (k == l)
				byte0 = 1;
		} else {
			j1 = i1;
			while (ai3[j1] < ai1[k])
				j1 = (j1 + 1) % j;
			while (ai3[i1] < ai1[k])
				i1 = ((i1 - 1) + j) % j;
			int l1 = ai[k];
			int i11 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
			int l15 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
			flag = (l1 < i11) | (l1 < l15);
			if (method313(i11, l15, l1, !flag))
				return true;
			l = (k + 1) % i;
			k = ((k - 1) + i) % i;
			if (i1 == j1)
				byte0 = 2;
		}
		while (byte0 == 0) {
			if (ai1[k] < ai1[l]) {
				if (ai1[k] < ai3[i1]) {
					if (ai1[k] < ai3[j1]) {
						int i2 = ai[k];
						int l6 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
						int j11 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
						int i16 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
						if (method312(i2, l6, j11, i16, flag))
							return true;
						k = ((k - 1) + i) % i;
						if (k == l)
							byte0 = 1;
					} else {
						int j2 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
						int i7 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
						int k11 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
						int j16 = ai2[j1];
						if (method312(j2, i7, k11, j16, flag))
							return true;
						j1 = (j1 + 1) % j;
						if (i1 == j1)
							byte0 = 2;
					}
				} else if (ai3[i1] < ai3[j1]) {
					int k2 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
					int j7 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
					int l11 = ai2[i1];
					int k16 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
					if (method312(k2, j7, l11, k16, flag))
						return true;
					i1 = ((i1 - 1) + j) % j;
					if (i1 == j1)
						byte0 = 2;
				} else {
					int l2 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
					int k7 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
					int i12 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
					int l16 = ai2[j1];
					if (method312(l2, k7, i12, l16, flag))
						return true;
					j1 = (j1 + 1) % j;
					if (i1 == j1)
						byte0 = 2;
				}
			} else if (ai1[l] < ai3[i1]) {
				if (ai1[l] < ai3[j1]) {
					int i3 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
					int l7 = ai[l];
					int j12 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
					int i17 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
					if (method312(i3, l7, j12, i17, flag))
						return true;
					l = (l + 1) % i;
					if (k == l)
						byte0 = 1;
				} else {
					int j3 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
					int i8 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
					int k12 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
					int j17 = ai2[j1];
					if (method312(j3, i8, k12, j17, flag))
						return true;
					j1 = (j1 + 1) % j;
					if (i1 == j1)
						byte0 = 2;
				}
			} else if (ai3[i1] < ai3[j1]) {
				int k3 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
				int j8 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
				int l12 = ai2[i1];
				int k17 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
				if (method312(k3, j8, l12, k17, flag))
					return true;
				i1 = ((i1 - 1) + j) % j;
				if (i1 == j1)
					byte0 = 2;
			} else {
				int l3 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int k8 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int i13 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int l17 = ai2[j1];
				if (method312(l3, k8, i13, l17, flag))
					return true;
				j1 = (j1 + 1) % j;
				if (i1 == j1)
					byte0 = 2;
			}
		}
		while (byte0 == 1) {
			if (ai1[k] < ai3[i1]) {
				if (ai1[k] < ai3[j1]) {
					int i4 = ai[k];
					int j13 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
					int i18 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
					return method313(j13, i18, i4, !flag);
				}
				int j4 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int l8 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int k13 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int j18 = ai2[j1];
				if (method312(j4, l8, k13, j18, flag))
					return true;
				j1 = (j1 + 1) % j;
				if (i1 == j1)
					byte0 = 0;
			} else if (ai3[i1] < ai3[j1]) {
				int k4 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
				int i9 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
				int l13 = ai2[i1];
				int k18 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai3[i1]);
				if (method312(k4, i9, l13, k18, flag))
					return true;
				i1 = ((i1 - 1) + j) % j;
				if (i1 == j1)
					byte0 = 0;
			} else {
				int l4 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[j1]);
				int j9 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[j1]);
				int i14 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai3[j1]);
				int l18 = ai2[j1];
				if (method312(l4, j9, i14, l18, flag))
					return true;
				j1 = (j1 + 1) % j;
				if (i1 == j1)
					byte0 = 0;
			}
		}
		while (byte0 == 2) {
			if (ai3[i1] < ai1[k]) {
				if (ai3[i1] < ai1[l]) {
					int i5 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
					int k9 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
					int j14 = ai2[i1];
					return method313(i5, k9, j14, flag);
				}
				int j5 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
				int l9 = ai[l];
				int k14 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
				int i19 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
				if (method312(j5, l9, k14, i19, flag))
					return true;
				l = (l + 1) % i;
				if (k == l)
					byte0 = 0;
			} else if (ai1[k] < ai1[l]) {
				int k5 = ai[k];
				int i10 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai1[k]);
				int l14 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
				int j19 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
				if (method312(k5, i10, l14, j19, flag))
					return true;
				k = ((k - 1) + i) % i;
				if (k == l)
					byte0 = 0;
			} else {
				int l5 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai1[l]);
				int j10 = ai[l];
				int i15 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[l]);
				int k19 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[l]);
				if (method312(l5, j10, i15, k19, flag))
					return true;
				l = (l + 1) % i;
				if (k == l)
					byte0 = 0;
			}
		}
		if (ai1[k] < ai3[i1]) {
			int i6 = ai[k];
			int j15 = method311(ai2[(i1 + 1) % j], ai3[(i1 + 1) % j], ai2[i1], ai3[i1], ai1[k]);
			int l19 = method311(ai2[((j1 - 1) + j) % j], ai3[((j1 - 1) + j) % j], ai2[j1], ai3[j1], ai1[k]);
			return method313(j15, l19, i6, !flag);
		}
		int j6 = method311(ai[(k + 1) % i], ai1[(k + 1) % i], ai[k], ai1[k], ai3[i1]);
		int k10 = method311(ai[((l - 1) + i) % i], ai1[((l - 1) + i) % i], ai[l], ai1[l], ai3[i1]);
		int k15 = ai2[i1];
		return method313(j6, k10, k15, flag);
	}

	public void removeModel(Model model) {
		for (int i = 0; i < modelCount; i++) {
			if (models[i] == model) {
				modelCount--;
				for (int j = i; j < modelCount; j++) {
					models[j] = models[j + 1];
					anIntArray422[j] = anIntArray422[j + 1];
				}

			}
		}

	}

}

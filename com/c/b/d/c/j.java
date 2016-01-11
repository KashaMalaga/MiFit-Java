package com.c.b.d.c;

import com.c.b.f;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.util.Arrays;

public final class j {
    static final char a = '\u00e6';
    static final char b = '\u00e7';
    static final char c = '\u00eb';
    static final char d = '\u00ee';
    static final char e = '\u00ef';
    static final char f = '\u00f0';
    static final char g = '\u00fe';
    static final char h = '\u00fe';
    static final int i = 0;
    static final int j = 1;
    static final int k = 2;
    static final int l = 3;
    static final int m = 4;
    static final int n = 5;
    private static final char o = '\u0081';
    private static final char p = '\u00ec';
    private static final char q = '\u00ed';
    private static final String r = "[)>\u001e05\u001d";
    private static final String s = "[)>\u001e06\u001d";
    private static final String t = "\u001e\u0004";

    private j() {
    }

    private static char a(char c, int i) {
        int i2 = (((i * 149) % 253) + j) + c;
        return i2 <= HeartRateInfo.NO_HR_VALUE ? (char) i2 : (char) (i2 - 254);
    }

    public static int a(CharSequence charSequence, int i) {
        int i2 = i;
        int length = charSequence.length();
        if (i < length) {
            char charAt = charSequence.charAt(i);
            while (a(charAt) && i < length) {
                i2 += j;
                i += j;
                if (i < length) {
                    charAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    static int a(CharSequence charSequence, int i, int i2) {
        if (i >= charSequence.length()) {
            return i2;
        }
        float[] fArr;
        int i3;
        if (i2 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i4 = i;
        while (i + i4 != charSequence.length()) {
            char charAt = charSequence.charAt(i + i4);
            i4 += j;
            if (a(charAt)) {
                fArr[i] = (float) (((double) fArr[i]) + 0.5d);
            } else if (b(charAt)) {
                fArr[i] = (float) ((int) Math.ceil((double) fArr[i]));
                fArr[i] = fArr[i] + 2.0f;
            } else {
                fArr[i] = (float) ((int) Math.ceil((double) fArr[i]));
                fArr[i] = fArr[i] + 1.0f;
            }
            if (d(charAt)) {
                fArr[j] = fArr[j] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[j] = fArr[j] + 2.6666667f;
            } else {
                fArr[j] = fArr[j] + 1.3333334f;
            }
            if (e(charAt)) {
                fArr[k] = fArr[k] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[k] = fArr[k] + 2.6666667f;
            } else {
                fArr[k] = fArr[k] + 1.3333334f;
            }
            if (f(charAt)) {
                fArr[l] = fArr[l] + 0.6666667f;
            } else if (b(charAt)) {
                fArr[l] = fArr[l] + 4.3333335f;
            } else {
                fArr[l] = fArr[l] + 3.3333333f;
            }
            if (h(charAt)) {
                fArr[m] = fArr[m] + 0.75f;
            } else if (b(charAt)) {
                fArr[m] = fArr[m] + 4.25f;
            } else {
                fArr[m] = fArr[m] + 3.25f;
            }
            if (i(charAt)) {
                fArr[n] = fArr[n] + 4.0f;
            } else {
                fArr[n] = fArr[n] + 1.0f;
            }
            if (i4 >= m) {
                int[] iArr = new int[6];
                byte[] bArr = new byte[6];
                a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int a = a(bArr);
                if (iArr[i] < iArr[n] && iArr[i] < iArr[j] && iArr[i] < iArr[k] && iArr[i] < iArr[l] && iArr[i] < iArr[m]) {
                    return i;
                }
                if (iArr[n] < iArr[i] || ((bArr[j] + bArr[k]) + bArr[l]) + bArr[m] == 0) {
                    return n;
                }
                if (a == j && bArr[m] > (byte) 0) {
                    return m;
                }
                if (a == j && bArr[k] > (byte) 0) {
                    return k;
                }
                if (a == j && bArr[l] > (byte) 0) {
                    return l;
                }
                if (iArr[j] + j < iArr[i] && iArr[j] + j < iArr[n] && iArr[j] + j < iArr[m] && iArr[j] + j < iArr[k]) {
                    if (iArr[j] < iArr[l]) {
                        return j;
                    }
                    if (iArr[j] == iArr[l]) {
                        for (i3 = (i + i4) + j; i3 < charSequence.length(); i3 += j) {
                            char charAt2 = charSequence.charAt(i3);
                            if (g(charAt2)) {
                                return l;
                            }
                            if (!f(charAt2)) {
                                break;
                            }
                        }
                        return j;
                    }
                }
            }
        }
        byte[] bArr2 = new byte[6];
        int[] iArr2 = new int[6];
        i3 = a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
        i4 = a(bArr2);
        return iArr2[i] != i3 ? (i4 != j || bArr2[n] <= (byte) 0) ? (i4 != j || bArr2[m] <= (byte) 0) ? (i4 != j || bArr2[k] <= (byte) 0) ? (i4 != j || bArr2[l] <= (byte) 0) ? j : l : k : m : n : i;
    }

    private static int a(byte[] bArr) {
        int i = i;
        int i2 = i;
        while (i < 6) {
            i2 += bArr[i];
            i += j;
        }
        return i2;
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = i; i3 < 6; i3 += j) {
            iArr[i3] = (int) Math.ceil((double) fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + j);
            }
        }
        return i2;
    }

    public static String a(String str) {
        return a(str, l.FORCE_NONE, null, null);
    }

    public static String a(String str, l lVar, f fVar, f fVar2) {
        int i = i;
        g[] gVarArr = new g[]{new a(), new c(), new m(), new n(), new f(), new b()};
        h hVar = new h(str);
        hVar.a(lVar);
        hVar.a(fVar, fVar2);
        if (str.startsWith(r) && str.endsWith(t)) {
            hVar.a((char) p);
            hVar.a((int) k);
            hVar.a += r.length();
        } else if (str.startsWith(s) && str.endsWith(t)) {
            hVar.a((char) q);
            hVar.a((int) k);
            hVar.a += s.length();
        }
        while (hVar.h()) {
            gVarArr[i].a(hVar);
            if (hVar.f() >= 0) {
                i = hVar.f();
                hVar.g();
            }
        }
        int e = hVar.e();
        hVar.k();
        int i2 = hVar.j().i();
        if (!(e >= i2 || i == 0 || i == n)) {
            hVar.a((char) h);
        }
        StringBuilder d = hVar.d();
        if (d.length() < i2) {
            d.append(o);
        }
        while (d.length() < i2) {
            d.append(a((char) o, d.length() + j));
        }
        return hVar.d().toString();
    }

    static boolean a(char c) {
        return c >= '0' && c <= '9';
    }

    static boolean b(char c) {
        return c >= '\u0080' && c <= '\u00ff';
    }

    static void c(char c) {
        String toHexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(i, 4 - toHexString.length()) + toHexString) + ')');
    }

    private static boolean d(char c) {
        return c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'));
    }

    private static boolean e(char c) {
        return c == ' ' || ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'));
    }

    private static boolean f(char c) {
        return g(c) || c == ' ' || ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z'));
    }

    private static boolean g(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    private static boolean h(char c) {
        return c >= ' ' && c <= '^';
    }

    private static boolean i(char c) {
        return false;
    }
}

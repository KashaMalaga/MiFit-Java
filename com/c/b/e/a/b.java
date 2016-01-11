package com.c.b.e.a;

import b.a.C0374dh;
import com.c.b.c.e;
import com.xiaomi.hm.health.bt.profile.a.j;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import kankan.wheel.widget.a;

final class b {
    private static final char a = '\ufff0';
    private static final char b = '\ufff1';
    private static final char c = '\ufff2';
    private static final char d = '\ufff3';
    private static final char e = '\ufff4';
    private static final char f = '\ufff5';
    private static final char g = '\ufff6';
    private static final char h = '\ufff7';
    private static final char i = '\ufff8';
    private static final char j = '\ufff9';
    private static final char k = '\ufffa';
    private static final char l = '\ufffb';
    private static final char m = '\ufffc';
    private static final char n = '\u001c';
    private static final char o = '\u001d';
    private static final char p = '\u001e';
    private static final NumberFormat q = new DecimalFormat("000000000");
    private static final NumberFormat r = new DecimalFormat("000");
    private static final String[] s = new String[]{"\nABCDEFGHIJKLMNOPQRSTUVWXYZ\ufffa\u001c\u001d\u001e\ufffb \ufffc\"#$%&'()*+,-./0123456789:\ufff1\ufff2\ufff3\ufff4\ufff8", "`abcdefghijklmnopqrstuvwxyz\ufffa\u001c\u001d\u001e\ufffb{\ufffc}~\u007f;<=>?[\\]^_ ,./:@!|\ufffc\ufff5\ufff6\ufffc\ufff0\ufff2\ufff3\ufff4\ufff7", "\u00c0\u00c1\u00c2\u00c3\u00c4\u00c5\u00c6\u00c7\u00c8\u00c9\u00ca\u00cb\u00cc\u00cd\u00ce\u00cf\u00d0\u00d1\u00d2\u00d3\u00d4\u00d5\u00d6\u00d7\u00d8\u00d9\u00da\ufffa\u001c\u001d\u001e\u00db\u00dc\u00dd\u00de\u00df\u00aa\u00ac\u00b1\u00b2\u00b3\u00b5\u00b9\u00ba\u00bc\u00bd\u00be\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087\u0088\u0089\ufff7 \ufff9\ufff3\ufff4\ufff8", "\u00e0\u00e1\u00e2\u00e3\u00e4\u00e5\u00e6\u00e7\u00e8\u00e9\u00ea\u00eb\u00ec\u00ed\u00ee\u00ef\u00f0\u00f1\u00f2\u00f3\u00f4\u00f5\u00f6\u00f7\u00f8\u00f9\u00fa\ufffa\u001c\u001d\u001e\ufffb\u00fb\u00fc\u00fd\u00fe\u00ff\u00a1\u00a8\u00ab\u00af\u00b0\u00b4\u00b7\u00b8\u00bb\u00bf\u008a\u008b\u008c\u008d\u008e\u008f\u0090\u0091\u0092\u0093\u0094\ufff7 \ufff2\ufff9\ufff4\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\ufffa\ufffc\ufffc\u001b\ufffb\u001c\u001d\u001e\u001f\u009f\u00a0\u00a2\u00a3\u00a4\u00a5\u00a6\u00a7\u00a9\u00ad\u00ae\u00b6\u0095\u0096\u0097\u0098\u0099\u009a\u009b\u009c\u009d\u009e\ufff7 \ufff2\ufff3\ufff9\ufff8", "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()*+,-./0123456789:;<=>?"};

    private b() {
    }

    private static int a(int i, byte[] bArr) {
        int i2 = i - 1;
        return ((1 << (5 - (i2 % 6))) & bArr[i2 / 6]) == 0 ? 0 : 1;
    }

    private static int a(byte[] bArr) {
        return a(bArr, new byte[]{(byte) 53, (byte) 54, (byte) 43, (byte) 44, (byte) 45, (byte) 46, (byte) 47, (byte) 48, (byte) 37, (byte) 38});
    }

    private static int a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (bArr2.length == 0) {
            throw new IllegalArgumentException();
        }
        int i2 = 0;
        while (i < bArr2.length) {
            i2 += a(bArr2[i], bArr) << ((bArr2.length - i) - 1);
            i++;
        }
        return i2;
    }

    static e a(byte[] bArr, int i) {
        StringBuilder stringBuilder = new StringBuilder(144);
        switch (i) {
            case a.k /*2*/:
            case a.l /*3*/:
                String format;
                if (i == 2) {
                    format = new DecimalFormat("0000000000".substring(0, c(bArr))).format((long) d(bArr));
                } else {
                    format = e(bArr);
                }
                String format2 = r.format((long) a(bArr));
                String format3 = r.format((long) b(bArr));
                stringBuilder.append(a(bArr, 10, 84));
                if (!stringBuilder.toString().startsWith("[)>\u001e01\u001d")) {
                    stringBuilder.insert(0, format + o + format2 + o + format3 + o);
                    break;
                }
                stringBuilder.insert(9, format + o + format2 + o + format3 + o);
                break;
            case a.aQ /*4*/:
                stringBuilder.append(a(bArr, 1, 93));
                break;
            case a.X /*5*/:
                stringBuilder.append(a(bArr, 1, 77));
                break;
        }
        return new e(bArr, stringBuilder.toString(), null, String.valueOf(i));
    }

    private static String a(byte[] bArr, int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i3 = i;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        while (i3 < i + i2) {
            int i7;
            char charAt = s[i5].charAt(bArr[i3]);
            switch (charAt) {
                case '\ufff0':
                case '\ufff1':
                case '\ufff2':
                case '\ufff3':
                case '\ufff4':
                    i6 = 1;
                    i7 = i5;
                    i5 = i3;
                    i3 = charAt - 65520;
                    i4 = i7;
                    break;
                case '\ufff5':
                    i6 = 2;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '\ufff6':
                    i6 = 3;
                    i4 = i5;
                    i5 = i3;
                    i3 = 0;
                    break;
                case '\ufff7':
                    i5 = i3;
                    i6 = -1;
                    i3 = 0;
                    break;
                case '\ufff8':
                    i5 = i3;
                    i6 = -1;
                    i3 = 1;
                    break;
                case '\ufff9':
                    i6 = -1;
                    i7 = i5;
                    i5 = i3;
                    i3 = i7;
                    break;
                case '\ufffb':
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    i3++;
                    stringBuilder.append(q.format((long) (((((bArr[i3] << 24) + (bArr[i3] << 18)) + (bArr[i3] << 12)) + (bArr[i3] << 6)) + bArr[i3])));
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
                default:
                    stringBuilder.append(charAt);
                    i7 = i3;
                    i3 = i5;
                    i5 = i7;
                    break;
            }
            int i8 = i6 - 1;
            if (i6 == 0) {
                i3 = i4;
            }
            i6 = i8;
            i7 = i3;
            i3 = i5 + 1;
            i5 = i7;
        }
        while (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == m) {
            stringBuilder.setLength(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    private static int b(byte[] bArr) {
        return a(bArr, new byte[]{(byte) 55, (byte) 56, (byte) 57, (byte) 58, (byte) 59, (byte) 60, (byte) 49, (byte) 50, (byte) 51, (byte) 52});
    }

    private static int c(byte[] bArr) {
        return a(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32});
    }

    private static int d(byte[] bArr) {
        return a(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, j.ap, j.aq, (byte) 22, (byte) 23, (byte) 24, C0374dh.k, C0374dh.l, C0374dh.m, C0374dh.n, (byte) 17, (byte) 18, (byte) 7, (byte) 8, (byte) 9, (byte) 10, C0374dh.i, C0374dh.j, (byte) 1, (byte) 2});
    }

    private static String e(byte[] bArr) {
        return String.valueOf(new char[]{s[0].charAt(a(bArr, new byte[]{(byte) 39, (byte) 40, (byte) 41, (byte) 42, (byte) 31, (byte) 32})), s[0].charAt(a(bArr, new byte[]{(byte) 33, (byte) 34, (byte) 35, (byte) 36, (byte) 25, (byte) 26})), s[0].charAt(a(bArr, new byte[]{(byte) 27, (byte) 28, (byte) 29, (byte) 30, (byte) 19, j.ap})), s[0].charAt(a(bArr, new byte[]{j.aq, (byte) 22, (byte) 23, (byte) 24, C0374dh.k, C0374dh.l})), s[0].charAt(a(bArr, new byte[]{C0374dh.m, C0374dh.n, (byte) 17, (byte) 18, (byte) 7, (byte) 8})), s[0].charAt(a(bArr, new byte[]{(byte) 9, (byte) 10, C0374dh.i, C0374dh.j, (byte) 1, (byte) 2}))});
    }
}

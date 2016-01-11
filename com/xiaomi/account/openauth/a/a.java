package com.xiaomi.account.openauth.a;

import android.support.v4.media.h;
import android.support.v4.view.a.C0113o;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;

public class a {
    private static final String a = System.getProperty("line.separator");
    private static char[] b = new char[64];
    private static byte[] c = new byte[C0113o.h];

    static {
        int i;
        int i2 = 0;
        char c = 'A';
        int i3 = 0;
        while (c <= 'Z') {
            i = i3 + 1;
            b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = 'a';
        while (c <= 'z') {
            i = i3 + 1;
            b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        c = '0';
        while (c <= '9') {
            i = i3 + 1;
            b[i3] = c;
            c = (char) (c + 1);
            i3 = i;
        }
        i = i3 + 1;
        b[i3] = '+';
        i3 = i + 1;
        b[i] = '/';
        for (int i4 = 0; i4 < c.length; i4++) {
            c[i4] = (byte) -1;
        }
        while (i2 < 64) {
            c[b[i2]] = (byte) i2;
            i2++;
        }
    }

    private a() {
    }

    public static String a(String str) {
        return new String(b(str.getBytes()));
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length, 76, a);
    }

    public static String a(byte[] bArr, int i, int i2, int i3, String str) {
        int i4 = (i3 * 3) / 4;
        if (i4 <= 0) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder(((((i2 + i4) - 1) / i4) * str.length()) + (((i2 + 2) / 3) * 4));
        int i5 = 0;
        while (i5 < i2) {
            int min = Math.min(i2 - i5, i4);
            stringBuilder.append(a(bArr, i + i5, min));
            stringBuilder.append(str);
            i5 += min;
        }
        return stringBuilder.toString();
    }

    public static byte[] a(char[] cArr) {
        return a(cArr, 0, cArr.length);
    }

    public static byte[] a(char[] cArr, int i, int i2) {
        if (i2 % 4 != 0) {
            throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        }
        while (i2 > 0 && cArr[(i + i2) - 1] == '=') {
            i2--;
        }
        int i3 = (i2 * 3) / 4;
        byte[] bArr = new byte[i3];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            char c = cArr[i];
            int i9 = i8 + 1;
            char c2 = cArr[i8];
            if (i9 < i4) {
                i8 = i9 + 1;
                i6 = cArr[i9];
                i9 = i8;
            } else {
                i6 = 65;
            }
            if (i9 < i4) {
                i8 = i9 + 1;
                i9 = cArr[i9];
                i7 = i8;
            } else {
                i7 = i9;
                i9 = 65;
            }
            if (c > '\u007f' || c2 > '\u007f' || i6 > h.j || i9 > h.j) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            byte b = c[c];
            byte b2 = c[c2];
            byte b3 = c[i6];
            byte b4 = c[i9];
            if (b < (byte) 0 || b2 < (byte) 0 || b3 < (byte) 0 || b4 < (byte) 0) {
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            }
            i8 = (b << 2) | (b2 >>> 4);
            int i10 = ((b2 & 15) << 4) | (b3 >>> 2);
            i6 = ((b3 & 3) << 6) | b4;
            i9 = i5 + 1;
            bArr[i5] = (byte) i8;
            if (i9 < i3) {
                i8 = i9 + 1;
                bArr[i9] = (byte) i10;
            } else {
                i8 = i9;
            }
            if (i8 < i3) {
                i9 = i8 + 1;
                bArr[i8] = (byte) i6;
            } else {
                i9 = i8;
            }
            i5 = i9;
            i = i7;
        }
        return bArr;
    }

    public static char[] a(byte[] bArr, int i) {
        return a(bArr, 0, i);
    }

    public static char[] a(byte[] bArr, int i, int i2) {
        int i3 = ((i2 * 4) + 2) / 3;
        char[] cArr = new char[(((i2 + 2) / 3) * 4)];
        int i4 = i + i2;
        int i5 = 0;
        while (i < i4) {
            int i6;
            int i7;
            int i8 = i + 1;
            int i9 = bArr[i] & HeartRateInfo.HR_EMPTY_VALUE;
            if (i8 < i4) {
                i6 = bArr[i8] & HeartRateInfo.HR_EMPTY_VALUE;
                i8++;
            } else {
                i6 = 0;
            }
            if (i8 < i4) {
                i7 = i8 + 1;
                i8 = bArr[i8] & HeartRateInfo.HR_EMPTY_VALUE;
            } else {
                i7 = i8;
                i8 = 0;
            }
            int i10 = i9 >>> 2;
            i9 = ((i9 & 3) << 4) | (i6 >>> 4);
            i6 = ((i6 & 15) << 2) | (i8 >>> 6);
            int i11 = i8 & 63;
            i8 = i5 + 1;
            cArr[i5] = b[i10];
            i5 = i8 + 1;
            cArr[i8] = b[i9];
            cArr[i5] = i5 < i3 ? b[i6] : '=';
            i6 = i5 + 1;
            cArr[i6] = i6 < i3 ? b[i11] : '=';
            i5 = i6 + 1;
            i = i7;
        }
        return cArr;
    }

    public static String b(String str) {
        return new String(d(str));
    }

    public static char[] b(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static byte[] c(String str) {
        char[] cArr = new char[str.length()];
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (!(charAt == ' ' || charAt == '\r' || charAt == '\n' || charAt == '\t')) {
                int i3 = i + 1;
                cArr[i] = charAt;
                i = i3;
            }
        }
        return a(cArr, 0, i);
    }

    public static byte[] d(String str) {
        return a(str.toCharArray());
    }
}

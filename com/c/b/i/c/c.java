package com.c.b.i.c;

import com.c.b.c.a;
import com.c.b.c.d;
import com.c.b.g;
import com.c.b.i.a.o;
import com.c.b.i.a.q;
import com.c.b.i.a.s;
import com.c.b.i.a.u;
import com.c.b.x;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import kankan.wheel.widget.l;

public final class c {
    static final String a = "ISO-8859-1";
    private static final int[] b = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private c() {
    }

    static int a(int i) {
        return i < b.length ? b[i] : -1;
    }

    private static int a(a aVar, o oVar, s sVar, b bVar) {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            f.a(aVar, oVar, sVar, i3, bVar);
            int a = a(bVar);
            if (a < i) {
                i2 = i3;
            } else {
                a = i;
            }
            i3++;
            i = a;
        }
        return i2;
    }

    private static int a(b bVar) {
        return ((e.a(bVar) + e.b(bVar)) + e.c(bVar)) + e.d(bVar);
    }

    static a a(a aVar, int i, int i2, int i3) {
        if (aVar.b() != i2) {
            throw new x("Number of bits and data bytes does not match");
        }
        Collection<a> arrayList = new ArrayList(i3);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i4 < i3) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            a(i, i2, i3, i4, iArr, iArr2);
            int i8 = iArr[0];
            byte[] bArr = new byte[i8];
            aVar.a(i7 * 8, bArr, 0, i8);
            byte[] a = a(bArr, iArr2[0]);
            arrayList.add(new a(bArr, a));
            int max = Math.max(i6, i8);
            i4++;
            i5 = Math.max(i5, a.length);
            i6 = max;
            i7 = iArr[0] + i7;
        }
        if (i2 != i7) {
            throw new x("Data bytes does not match offset");
        }
        a aVar2 = new a();
        for (max = 0; max < i6; max++) {
            for (a a2 : arrayList) {
                byte[] a3 = a2.a();
                if (max < a3.length) {
                    aVar2.c(a3[max], 8);
                }
            }
        }
        for (max = 0; max < i5; max++) {
            for (a a22 : arrayList) {
                a3 = a22.b();
                if (max < a3.length) {
                    aVar2.c(a3[max], 8);
                }
            }
        }
        if (i == aVar2.b()) {
            return aVar2;
        }
        throw new x("Interleaving error: " + i + " and " + aVar2.b() + " differ.");
    }

    public static q a(String str) {
        return a(str, null);
    }

    private static q a(String str, String str2) {
        int i = 0;
        if ("Shift_JIS".equals(str2)) {
            return b(str) ? q.KANJI : q.BYTE;
        } else {
            int i2 = 0;
            int i3 = 0;
            while (i < str.length()) {
                int charAt = str.charAt(i);
                if (charAt >= '0' && charAt <= '9') {
                    i3 = 1;
                } else if (a(charAt) == -1) {
                    return q.BYTE;
                } else {
                    i2 = 1;
                }
                i++;
            }
            return i2 != 0 ? q.ALPHANUMERIC : i3 != 0 ? q.NUMERIC : q.BYTE;
        }
    }

    private static s a(int i, o oVar) {
        for (int i2 = 1; i2 <= 40; i2++) {
            s b = s.b(i2);
            if (b.c() - b.a(oVar).c() >= (i + 7) / 8) {
                return b;
            }
        }
        throw new x("Data too big");
    }

    public static g a(String str, o oVar) {
        return a(str, oVar, null);
    }

    public static g a(String str, o oVar, Map<g, ?> map) {
        String str2 = map == null ? null : (String) map.get(g.CHARACTER_SET);
        if (str2 == null) {
            str2 = a;
        }
        q a = a(str, str2);
        a aVar = new a();
        if (a == q.BYTE && !a.equals(str2)) {
            d a2 = d.a(str2);
            if (a2 != null) {
                a(a2, aVar);
            }
        }
        a(a, aVar);
        a aVar2 = new a();
        a(str, a, aVar2, str2);
        s a3 = a((a.a(a((aVar.a() + a.a(s.b(1))) + aVar2.a(), oVar)) + aVar.a()) + aVar2.a(), oVar);
        a aVar3 = new a();
        aVar3.a(aVar);
        a(a == q.BYTE ? aVar2.b() : str.length(), a3, a, aVar3);
        aVar3.a(aVar2);
        u a4 = a3.a(oVar);
        int c = a3.c() - a4.c();
        a(c, aVar3);
        a a5 = a(aVar3, a3.c(), c, a4.b());
        g gVar = new g();
        gVar.a(oVar);
        gVar.a(a);
        gVar.a(a3);
        int d = a3.d();
        b bVar = new b(d, d);
        d = a(a5, oVar, a3, bVar);
        gVar.a(d);
        f.a(a5, oVar, a3, d, bVar);
        gVar.a(bVar);
        return gVar;
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) {
        if (i4 >= i3) {
            throw new x("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        i7 -= i9;
        i8 -= i10;
        if (i7 != i8) {
            throw new x("EC bytes mismatch");
        } else if (i3 != i6 + i5) {
            throw new x("RS blocks mismatch");
        } else {
            if (i != (i5 * (i10 + i8)) + ((i9 + i7) * i6)) {
                throw new x("Total bytes mismatch");
            } else if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i7;
            } else {
                iArr[0] = i10;
                iArr2[0] = i8;
            }
        }
    }

    static void a(int i, a aVar) {
        int i2 = i * 8;
        if (aVar.a() > i2) {
            throw new x("data bits cannot fit in the QR Code" + aVar.a() + " > " + i2);
        }
        int i3;
        for (i3 = 0; i3 < 4 && aVar.a() < i2; i3++) {
            aVar.a(false);
        }
        i3 = aVar.a() & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                aVar.a(false);
                i3++;
            }
        }
        int b = i - aVar.b();
        for (i3 = 0; i3 < b; i3++) {
            aVar.c((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.a() != i2) {
            throw new x("Bits size does not equal capacity");
        }
    }

    static void a(int i, s sVar, q qVar, a aVar) {
        int a = qVar.a(sVar);
        if (i >= (1 << a)) {
            throw new x(i + " is bigger than " + ((1 << a) - 1));
        }
        aVar.c(i, a);
    }

    private static void a(d dVar, a aVar) {
        aVar.c(q.ECI.a(), 4);
        aVar.c(dVar.a(), 8);
    }

    static void a(q qVar, a aVar) {
        aVar.c(qVar.a(), 4);
    }

    static void a(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int charAt = charSequence.charAt(i) - 48;
            if (i + 2 < length) {
                aVar.c(((charAt * 100) + ((charSequence.charAt(i + 1) - 48) * 10)) + (charSequence.charAt(i + 2) - 48), 10);
                i += 3;
            } else if (i + 1 < length) {
                aVar.c((charAt * 10) + (charSequence.charAt(i + 1) - 48), 7);
                i += 2;
            } else {
                aVar.c(charAt, 4);
                i++;
            }
        }
    }

    static void a(String str, a aVar) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i = 0; i < length; i += 2) {
                int i2 = ((bytes[i] & HeartRateInfo.HR_EMPTY_VALUE) << 8) | (bytes[i + 1] & HeartRateInfo.HR_EMPTY_VALUE);
                i2 = (i2 < 33088 || i2 > 40956) ? (i2 < 57408 || i2 > 60351) ? -1 : i2 - 49472 : i2 - 33088;
                if (i2 == -1) {
                    throw new x("Invalid byte sequence");
                }
                aVar.c((i2 & HeartRateInfo.HR_EMPTY_VALUE) + ((i2 >> 8) * 192), 13);
            }
        } catch (Throwable e) {
            throw new x(e);
        }
    }

    static void a(String str, a aVar, String str2) {
        try {
            for (byte c : str.getBytes(str2)) {
                aVar.c(c, 8);
            }
        } catch (Throwable e) {
            throw new x(e);
        }
    }

    static void a(String str, q qVar, a aVar, String str2) {
        switch (d.a[qVar.ordinal()]) {
            case l.a /*1*/:
                a((CharSequence) str, aVar);
                return;
            case kankan.wheel.widget.a.k /*2*/:
                b(str, aVar);
                return;
            case kankan.wheel.widget.a.l /*3*/:
                a(str, aVar, str2);
                return;
            case kankan.wheel.widget.a.aQ /*4*/:
                a(str, aVar);
                return;
            default:
                throw new x("Invalid mode: " + qVar);
        }
    }

    static byte[] a(byte[] bArr, int i) {
        int i2 = 0;
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & HeartRateInfo.HR_EMPTY_VALUE;
        }
        new com.c.b.c.b.d(com.c.b.c.b.a.e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        return bArr2;
    }

    static void b(CharSequence charSequence, a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int a = a(charSequence.charAt(i));
            if (a == -1) {
                throw new x();
            } else if (i + 1 < length) {
                int a2 = a(charSequence.charAt(i + 1));
                if (a2 == -1) {
                    throw new x();
                }
                aVar.c((a * 45) + a2, 11);
                i += 2;
            } else {
                aVar.c(a, 6);
                i++;
            }
        }
    }

    private static boolean b(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & HeartRateInfo.HR_EMPTY_VALUE;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException e) {
            return false;
        }
    }
}

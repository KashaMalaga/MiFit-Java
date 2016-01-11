package com.c.b.i.a;

import android.support.v4.view.a.C0113o;
import com.c.b.c.c;
import com.c.b.c.d;
import com.c.b.c.e;
import com.c.b.c.l;
import com.c.b.h;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

final class m {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', '$', '%', '*', '+', '-', '.', '/', ':'};
    private static final int b = 1;

    private m() {
    }

    private static char a(int i) {
        if (i < a.length) {
            return a[i];
        }
        throw h.a();
    }

    private static int a(c cVar) {
        int a = cVar.a(8);
        if ((a & C0113o.h) == 0) {
            return a & android.support.v4.media.h.j;
        }
        if ((a & 192) == C0113o.h) {
            return ((a & 63) << 8) | cVar.a(8);
        } else if ((a & 224) == 192) {
            return ((a & 31) << 16) | cVar.a(16);
        } else {
            throw h.a();
        }
    }

    static e a(byte[] bArr, s sVar, o oVar, Map<com.c.b.e, ?> map) {
        int i;
        int i2;
        c cVar = new c(bArr);
        StringBuilder stringBuilder = new StringBuilder(50);
        List arrayList = new ArrayList(b);
        d dVar = null;
        int i3 = -1;
        int i4 = -1;
        boolean z = false;
        while (true) {
            boolean z2;
            q a = cVar.c() < 4 ? q.TERMINATOR : q.a(cVar.a(4));
            if (a == q.TERMINATOR) {
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (a == q.FNC1_FIRST_POSITION || a == q.FNC1_SECOND_POSITION) {
                z2 = b;
                i = i4;
                i2 = i3;
            } else if (a == q.STRUCTURED_APPEND) {
                if (cVar.c() < 16) {
                    throw h.a();
                }
                try {
                    z2 = z;
                    i = cVar.a(8);
                    i2 = cVar.a(8);
                } catch (IllegalArgumentException e) {
                    throw h.a();
                }
            } else if (a == q.ECI) {
                dVar = d.a(a(cVar));
                if (dVar == null) {
                    throw h.a();
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else if (a == q.HANZI) {
                r2 = cVar.a(4);
                i = cVar.a(a.a(sVar));
                if (r2 == b) {
                    a(cVar, stringBuilder, i);
                }
                z2 = z;
                i = i4;
                i2 = i3;
            } else {
                r2 = cVar.a(a.a(sVar));
                if (a == q.NUMERIC) {
                    c(cVar, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (a == q.ALPHANUMERIC) {
                    a(cVar, stringBuilder, r2, z);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (a == q.BYTE) {
                    a(cVar, stringBuilder, r2, dVar, arrayList, map);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else if (a == q.KANJI) {
                    b(cVar, stringBuilder, r2);
                    z2 = z;
                    i = i4;
                    i2 = i3;
                } else {
                    throw h.a();
                }
            }
            if (a == q.TERMINATOR) {
                break;
            }
            i3 = i2;
            i4 = i;
            z = z2;
        }
        return new e(bArr, stringBuilder.toString(), arrayList.isEmpty() ? null : arrayList, oVar == null ? null : oVar.toString(), i, i2);
    }

    private static void a(c cVar, StringBuilder stringBuilder, int i) {
        if (i * 13 > cVar.c()) {
            throw h.a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = cVar.a(13);
            a = (a % 96) | ((a / 96) << 8);
            a = a < 959 ? a + 41377 : a + 42657;
            bArr[i2] = (byte) ((a >> 8) & HeartRateInfo.HR_EMPTY_VALUE);
            bArr[i2 + b] = (byte) (a & HeartRateInfo.HR_EMPTY_VALUE);
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, l.b));
        } catch (UnsupportedEncodingException e) {
            throw h.a();
        }
    }

    private static void a(c cVar, StringBuilder stringBuilder, int i, d dVar, Collection<byte[]> collection, Map<com.c.b.e, ?> map) {
        if (i * 8 > cVar.c()) {
            throw h.a();
        }
        Object obj = new byte[i];
        for (int i2 = 0; i2 < i; i2 += b) {
            obj[i2] = (byte) cVar.a(8);
        }
        try {
            stringBuilder.append(new String(obj, dVar == null ? l.a(obj, map) : dVar.name()));
            collection.add(obj);
        } catch (UnsupportedEncodingException e) {
            throw h.a();
        }
    }

    private static void a(c cVar, StringBuilder stringBuilder, int i, boolean z) {
        int length = stringBuilder.length();
        while (i > b) {
            if (cVar.c() < 11) {
                throw h.a();
            }
            int a = cVar.a(11);
            stringBuilder.append(a(a / 45));
            stringBuilder.append(a(a % 45));
            i -= 2;
        }
        if (i == b) {
            if (cVar.c() < 6) {
                throw h.a();
            }
            stringBuilder.append(a(cVar.a(6)));
        }
        if (z) {
            while (length < stringBuilder.length()) {
                if (stringBuilder.charAt(length) == '%') {
                    if (length >= stringBuilder.length() - 1 || stringBuilder.charAt(length + b) != '%') {
                        stringBuilder.setCharAt(length, '\u001d');
                    } else {
                        stringBuilder.deleteCharAt(length + b);
                    }
                }
                length += b;
            }
        }
    }

    private static void b(c cVar, StringBuilder stringBuilder, int i) {
        if (i * 13 > cVar.c()) {
            throw h.a();
        }
        byte[] bArr = new byte[(i * 2)];
        int i2 = 0;
        while (i > 0) {
            int a = cVar.a(13);
            a = (a % 192) | ((a / 192) << 8);
            a = a < 7936 ? a + 33088 : a + 49472;
            bArr[i2] = (byte) (a >> 8);
            bArr[i2 + b] = (byte) a;
            i--;
            i2 += 2;
        }
        try {
            stringBuilder.append(new String(bArr, l.a));
        } catch (UnsupportedEncodingException e) {
            throw h.a();
        }
    }

    private static void c(c cVar, StringBuilder stringBuilder, int i) {
        while (i >= 3) {
            if (cVar.c() < 10) {
                throw h.a();
            }
            int a = cVar.a(10);
            if (a >= com.xiaomi.account.openauth.h.E) {
                throw h.a();
            }
            stringBuilder.append(a(a / 100));
            stringBuilder.append(a((a / 10) % 10));
            stringBuilder.append(a(a % 10));
            i -= 3;
        }
        if (i == 2) {
            if (cVar.c() < 7) {
                throw h.a();
            }
            a = cVar.a(7);
            if (a >= 100) {
                throw h.a();
            }
            stringBuilder.append(a(a / 10));
            stringBuilder.append(a(a % 10));
        } else if (i != b) {
        } else {
            if (cVar.c() < 4) {
                throw h.a();
            }
            a = cVar.a(4);
            if (a >= 10) {
                throw h.a();
            }
            stringBuilder.append(a(a));
        }
    }
}

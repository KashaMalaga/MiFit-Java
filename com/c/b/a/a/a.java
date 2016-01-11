package com.c.b.a.a;

import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.services.C0454m;
import cn.com.smartdevices.bracelet.lab.sportmode.GroupItemBaseInfo;
import cn.com.smartdevices.bracelet.lab.sportmode.SportBaseInfo;
import com.a.a.a.C0907p;
import com.a.a.a.C0908q;
import com.a.a.a.C0910s;
import com.a.a.a.C0911t;
import com.a.a.a.C0912u;
import com.c.b.c.b;
import com.c.b.c.e;
import com.c.b.h;
import com.sina.weibo.sdk.component.WidgetRequestParam;
import com.tencent.connect.common.Constants;
import com.xiaomi.mipush.sdk.f;
import java.util.Arrays;
import kankan.wheel.widget.l;

public final class a {
    private static final String[] a = new String[]{"CTRL_PS", " ", C0911t.a, "B", "C", "D", C0908q.a, "F", "G", "H", "I", "J", C0910s.a, "L", C0912u.b, C0910s.c, "O", "P", "Q", "R", C0907p.b, C0912u.a, "U", C0911t.b, C0908q.b, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] b = new String[]{"CTRL_PS", " ", c.b, c.d, GroupItemBaseInfo.KEY_COUNT, "d", GroupItemBaseInfo.KEY_END_TIME, "f", "g", C0454m.a, "i", "j", "k", "l", "m", "n", "o", c.a, WidgetRequestParam.REQ_PARAM_COMMENT_TOPIC, "r", GroupItemBaseInfo.KEY_START_TIME, C0454m.c, "u", SportBaseInfo.VERSION, "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};
    private static final String[] c = new String[]{"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};
    private static final String[] d = new String[]{com.xiaomi.e.a.f, "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", f.i, "-", ".", "/", kankan.wheel.widget.a.ci, ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};
    private static final String[] e = new String[]{"CTRL_PS", " ", Constants.VIA_RESULT_SUCCESS, Constants.VIA_TO_TYPE_QQ_GROUP, Constants.VIA_SSO_LOGIN, Constants.VIA_TO_TYPE_QQ_DISCUSS_GROUP, Constants.VIA_TO_TYPE_QZONE, Constants.VIA_SHARE_TYPE_TEXT, Constants.VIA_SHARE_TYPE_INFO, "7", "8", "9", f.i, ".", "CTRL_UL", "CTRL_US"};
    private com.c.b.a.a f;

    private static int a(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }

    private static int a(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    private static c a(char c) {
        switch (c) {
            case 'B':
                return c.BINARY;
            case 'D':
                return c.DIGIT;
            case 'L':
                return c.LOWER;
            case 'M':
                return c.MIXED;
            case cn.com.smartdevices.bracelet.gps.c.a.h /*80*/:
                return c.PUNCT;
            default:
                return c.UPPER;
        }
    }

    private static String a(c cVar, int i) {
        switch (b.a[cVar.ordinal()]) {
            case l.a /*1*/:
                return a[i];
            case kankan.wheel.widget.a.k /*2*/:
                return b[i];
            case kankan.wheel.widget.a.l /*3*/:
                return c[i];
            case kankan.wheel.widget.a.aQ /*4*/:
                return d[i];
            case kankan.wheel.widget.a.X /*5*/:
                return e[i];
            default:
                throw new IllegalStateException("Bad table");
        }
    }

    public static String a(boolean[] zArr) {
        return b(zArr);
    }

    private static String b(boolean[] zArr) {
        int length = zArr.length;
        c cVar = c.UPPER;
        c cVar2 = c.UPPER;
        StringBuilder stringBuilder = new StringBuilder(20);
        int i = 0;
        c cVar3 = cVar2;
        cVar2 = cVar;
        while (i < length) {
            int i2;
            if (cVar3 != c.BINARY) {
                i2 = cVar3 == c.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int a = a(zArr, i, i2);
                i += i2;
                String a2 = a(cVar3, a);
                if (a2.startsWith("CTRL_")) {
                    cVar = a(a2.charAt(5));
                    if (a2.charAt(6) == 'L') {
                        cVar2 = cVar;
                    }
                } else {
                    stringBuilder.append(a2);
                    cVar = cVar2;
                }
                cVar3 = cVar;
            } else if (length - i < 5) {
                break;
            } else {
                i2 = a(zArr, i, 5);
                i += 5;
                if (i2 == 0) {
                    if (length - i < 11) {
                        break;
                    }
                    i2 = a(zArr, i, 11) + 31;
                    i += 11;
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (length - i < 8) {
                        i2 = length;
                        break;
                    }
                    stringBuilder.append((char) a(zArr, i, 8));
                    i3++;
                    i += 8;
                }
                i2 = i;
                i = i2;
                cVar3 = cVar2;
            }
        }
        return stringBuilder.toString();
    }

    private boolean[] c(boolean[] zArr) {
        com.c.b.c.b.a aVar;
        int i = 8;
        if (this.f.a() <= 2) {
            i = 6;
            aVar = com.c.b.c.b.a.c;
        } else if (this.f.a() <= 8) {
            aVar = com.c.b.c.b.a.g;
        } else if (this.f.a() <= 22) {
            i = 10;
            aVar = com.c.b.c.b.a.b;
        } else {
            i = 12;
            aVar = com.c.b.c.b.a.a;
        }
        int b = this.f.b();
        int length = zArr.length / i;
        if (length < b) {
            throw h.a();
        }
        int i2 = length - b;
        int[] iArr = new int[length];
        int length2 = zArr.length % i;
        int i3 = 0;
        while (i3 < length) {
            iArr[i3] = a(zArr, length2, i);
            i3++;
            length2 += i;
        }
        try {
            new com.c.b.c.b.c(aVar).a(iArr, i2);
            int i4 = (1 << i) - 1;
            int i5 = 0;
            for (i3 = 0; i3 < b; i3++) {
                length2 = iArr[i3];
                if (length2 == 0 || length2 == i4) {
                    throw h.a();
                }
                if (length2 == 1 || length2 == i4 - 1) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[((b * i) - i5)];
            i2 = 0;
            i3 = 0;
            while (i2 < b) {
                int i6 = iArr[i2];
                if (i6 == 1 || i6 == i4 - 1) {
                    Arrays.fill(zArr2, i3, (i3 + i) - 1, i6 > 1);
                    i5 = (i - 1) + i3;
                } else {
                    length2 = i - 1;
                    while (length2 >= 0) {
                        length = i3 + 1;
                        zArr2[i3] = ((1 << length2) & i6) != 0;
                        length2--;
                        i3 = length;
                    }
                    i5 = i3;
                }
                i2++;
                i3 = i5;
            }
            return zArr2;
        } catch (Throwable e) {
            throw h.a(e);
        }
    }

    public e a(com.c.b.a.a aVar) {
        this.f = aVar;
        return new e(null, b(c(a(aVar.d()))), null, null);
    }

    boolean[] a(b bVar) {
        int i;
        int i2;
        int i3;
        int i4;
        boolean c = this.f.c();
        int a = this.f.a();
        int i5 = c ? (a * 4) + 11 : (a * 4) + 14;
        int[] iArr = new int[i5];
        boolean[] zArr = new boolean[a(a, c)];
        if (c) {
            for (i = 0; i < iArr.length; i++) {
                iArr[i] = i;
            }
        } else {
            i2 = i5 / 2;
            i3 = ((i5 + 1) + ((((i5 / 2) - 1) / 15) * 2)) / 2;
            for (i = 0; i < i2; i++) {
                i4 = (i / 15) + i;
                iArr[(i2 - i) - 1] = (i3 - i4) - 1;
                iArr[i2 + i] = (i4 + i3) + 1;
            }
        }
        i4 = 0;
        for (int i6 = 0; i6 < a; i6++) {
            i = c ? ((a - i6) * 4) + 9 : ((a - i6) * 4) + 12;
            int i7 = i6 * 2;
            int i8 = (i5 - 1) - i7;
            for (i3 = 0; i3 < i; i3++) {
                int i9 = i3 * 2;
                for (i2 = 0; i2 < 2; i2++) {
                    zArr[(i4 + i9) + i2] = bVar.a(iArr[i7 + i2], iArr[i7 + i3]);
                    zArr[(((i * 2) + i4) + i9) + i2] = bVar.a(iArr[i7 + i3], iArr[i8 - i2]);
                    zArr[(((i * 4) + i4) + i9) + i2] = bVar.a(iArr[i8 - i2], iArr[i8 - i3]);
                    zArr[(((i * 6) + i4) + i9) + i2] = bVar.a(iArr[i8 - i3], iArr[i7 + i2]);
                }
            }
            i4 = (i * 8) + i4;
        }
        return zArr;
    }
}

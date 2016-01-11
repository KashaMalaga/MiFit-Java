package com.c.b.i.a;

import a.a.a.B;
import android.support.v4.view.a.C0113o;
import cn.com.smartdevices.bracelet.honor.a.d;
import cn.com.smartdevices.bracelet.model.ShareData;
import com.c.b.c.b;
import com.c.b.h;
import kankan.wheel.widget.a;

public final class s {
    private static final int[] a = new int[]{31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final s[] b = f();
    private final int c;
    private final int[] d;
    private final u[] e;
    private final int f;

    private s(int i, int[] iArr, u... uVarArr) {
        int i2 = 0;
        this.c = i;
        this.d = iArr;
        this.e = uVarArr;
        int a = uVarArr[0].a();
        t[] d = uVarArr[0].d();
        int length = d.length;
        int i3 = 0;
        while (i2 < length) {
            t tVar = d[i2];
            i3 += (tVar.b() + a) * tVar.a();
            i2++;
        }
        this.f = i3;
    }

    public static s a(int i) {
        if (i % 4 != 1) {
            throw h.a();
        }
        try {
            return b((i - 17) / 4);
        } catch (IllegalArgumentException e) {
            throw h.a();
        }
    }

    public static s b(int i) {
        if (i >= 1 && i <= 40) {
            return b[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static s c(int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (i2 < a.length) {
            int i5 = a[i2];
            if (i5 == i) {
                return b(i2 + 7);
            }
            i5 = p.a(i, i5);
            if (i5 < i3) {
                i4 = i2 + 7;
                i3 = i5;
            }
            i2++;
        }
        return i3 <= 3 ? b(i4) : null;
    }

    private static s[] f() {
        r0 = new s[40];
        int[] iArr = new int[0];
        u[] uVarArr = new u[4];
        uVarArr[0] = new u(7, new t(1, 19));
        uVarArr[1] = new u(10, new t(1, 16));
        uVarArr[2] = new u(13, new t(1, 13));
        uVarArr[3] = new u(17, new t(1, 9));
        r0[0] = new s(1, iArr, uVarArr);
        iArr = new int[]{6, 18};
        uVarArr = new u[4];
        uVarArr[0] = new u(10, new t(1, 34));
        uVarArr[1] = new u(16, new t(1, 28));
        uVarArr[2] = new u(22, new t(1, 22));
        uVarArr[3] = new u(28, new t(1, 16));
        r0[1] = new s(2, iArr, uVarArr);
        iArr = new int[]{6, 22};
        uVarArr = new u[4];
        uVarArr[0] = new u(15, new t(1, 55));
        uVarArr[1] = new u(26, new t(1, 44));
        uVarArr[2] = new u(18, new t(2, 17));
        uVarArr[3] = new u(22, new t(2, 13));
        r0[2] = new s(3, iArr, uVarArr);
        iArr = new int[]{6, 26};
        uVarArr = new u[4];
        uVarArr[0] = new u(20, new t(1, 80));
        uVarArr[1] = new u(18, new t(2, 32));
        uVarArr[2] = new u(26, new t(2, 24));
        uVarArr[3] = new u(16, new t(4, 9));
        r0[3] = new s(4, iArr, uVarArr);
        iArr = new int[]{6, 30};
        uVarArr = new u[4];
        uVarArr[0] = new u(26, new t(1, 108));
        uVarArr[1] = new u(24, new t(2, 43));
        uVarArr[2] = new u(18, new t(2, 15), new t(2, 16));
        uVarArr[3] = new u(22, new t(2, 11), new t(2, 12));
        r0[4] = new s(5, iArr, uVarArr);
        iArr = new int[]{6, 34};
        uVarArr = new u[4];
        uVarArr[0] = new u(18, new t(2, 68));
        uVarArr[1] = new u(16, new t(4, 27));
        uVarArr[2] = new u(24, new t(4, 19));
        uVarArr[3] = new u(28, new t(4, 15));
        r0[5] = new s(6, iArr, uVarArr);
        iArr = new int[]{6, 22, 38};
        uVarArr = new u[4];
        uVarArr[0] = new u(20, new t(2, 78));
        uVarArr[1] = new u(18, new t(4, 31));
        uVarArr[2] = new u(18, new t(2, 14), new t(4, 15));
        uVarArr[3] = new u(26, new t(4, 13), new t(1, 14));
        r0[6] = new s(7, iArr, uVarArr);
        iArr = new int[]{6, 24, 42};
        uVarArr = new u[4];
        uVarArr[0] = new u(24, new t(2, 97));
        uVarArr[1] = new u(22, new t(2, 38), new t(2, 39));
        uVarArr[2] = new u(22, new t(4, 18), new t(2, 19));
        uVarArr[3] = new u(26, new t(4, 14), new t(2, 15));
        r0[7] = new s(8, iArr, uVarArr);
        iArr = new int[]{6, 26, 46};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(2, 116));
        uVarArr[1] = new u(22, new t(3, 36), new t(2, 37));
        uVarArr[2] = new u(20, new t(4, 16), new t(4, 17));
        uVarArr[3] = new u(24, new t(4, 12), new t(4, 13));
        r0[8] = new s(9, iArr, uVarArr);
        iArr = new int[]{6, 28, 50};
        uVarArr = new u[4];
        uVarArr[0] = new u(18, new t(2, 68), new t(2, 69));
        uVarArr[1] = new u(26, new t(4, 43), new t(1, 44));
        uVarArr[2] = new u(24, new t(6, 19), new t(2, 20));
        uVarArr[3] = new u(28, new t(6, 15), new t(2, 16));
        r0[9] = new s(10, iArr, uVarArr);
        iArr = new int[]{6, 30, 54};
        uVarArr = new u[4];
        uVarArr[0] = new u(20, new t(4, 81));
        uVarArr[1] = new u(30, new t(1, 50), new t(4, 51));
        uVarArr[2] = new u(28, new t(4, 22), new t(4, 23));
        uVarArr[3] = new u(24, new t(3, 12), new t(8, 13));
        r0[10] = new s(11, iArr, uVarArr);
        iArr = new int[]{6, 32, 58};
        uVarArr = new u[4];
        uVarArr[0] = new u(24, new t(2, 92), new t(2, 93));
        uVarArr[1] = new u(22, new t(6, 36), new t(2, 37));
        uVarArr[2] = new u(26, new t(4, 20), new t(6, 21));
        uVarArr[3] = new u(28, new t(7, 14), new t(4, 15));
        r0[11] = new s(12, iArr, uVarArr);
        iArr = new int[]{6, 34, 62};
        uVarArr = new u[4];
        uVarArr[0] = new u(26, new t(4, B.p));
        uVarArr[1] = new u(22, new t(8, 37), new t(1, 38));
        uVarArr[2] = new u(24, new t(8, 20), new t(4, 21));
        uVarArr[3] = new u(22, new t(12, 11), new t(4, 12));
        r0[12] = new s(13, iArr, uVarArr);
        iArr = new int[]{6, 26, 46, 66};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(3, 115), new t(1, 116));
        uVarArr[1] = new u(24, new t(4, 40), new t(5, 41));
        uVarArr[2] = new u(20, new t(11, 16), new t(5, 17));
        uVarArr[3] = new u(24, new t(11, 12), new t(5, 13));
        r0[13] = new s(14, iArr, uVarArr);
        iArr = new int[]{6, 26, 48, 70};
        uVarArr = new u[4];
        uVarArr[0] = new u(22, new t(5, 87), new t(1, 88));
        uVarArr[1] = new u(24, new t(5, 41), new t(5, 42));
        uVarArr[2] = new u(30, new t(5, 24), new t(7, 25));
        uVarArr[3] = new u(24, new t(11, 12), new t(7, 13));
        r0[14] = new s(15, iArr, uVarArr);
        iArr = new int[]{6, 26, 50, 74};
        uVarArr = new u[4];
        uVarArr[0] = new u(24, new t(5, 98), new t(1, 99));
        uVarArr[1] = new u(28, new t(7, 45), new t(3, 46));
        uVarArr[2] = new u(24, new t(15, 19), new t(2, 20));
        uVarArr[3] = new u(30, new t(3, 15), new t(13, 16));
        r0[15] = new s(16, iArr, uVarArr);
        iArr = new int[]{6, 30, 54, 78};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(1, B.p), new t(5, 108));
        uVarArr[1] = new u(28, new t(10, 46), new t(1, 47));
        uVarArr[2] = new u(28, new t(1, 22), new t(15, 23));
        uVarArr[3] = new u(28, new t(2, 14), new t(17, 15));
        r0[16] = new s(17, iArr, uVarArr);
        iArr = new int[]{6, 30, 56, 82};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(5, 120), new t(1, 121));
        uVarArr[1] = new u(26, new t(9, 43), new t(4, 44));
        uVarArr[2] = new u(28, new t(17, 22), new t(1, 23));
        uVarArr[3] = new u(28, new t(2, 14), new t(19, 15));
        r0[17] = new s(18, iArr, uVarArr);
        iArr = new int[]{6, 30, 58, 86};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(3, 113), new t(4, 114));
        uVarArr[1] = new u(26, new t(3, 44), new t(11, 45));
        uVarArr[2] = new u(26, new t(17, 21), new t(4, 22));
        uVarArr[3] = new u(26, new t(9, 13), new t(16, 14));
        r0[18] = new s(19, iArr, uVarArr);
        iArr = new int[]{6, 34, 62, 90};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(3, B.p), new t(5, 108));
        uVarArr[1] = new u(26, new t(3, 41), new t(13, 42));
        uVarArr[2] = new u(30, new t(15, 24), new t(5, 25));
        uVarArr[3] = new u(28, new t(15, 15), new t(10, 16));
        r0[19] = new s(20, iArr, uVarArr);
        iArr = new int[]{6, 28, 50, 72, 94};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(4, 116), new t(4, 117));
        uVarArr[1] = new u(26, new t(17, 42));
        uVarArr[2] = new u(28, new t(17, 22), new t(6, 23));
        uVarArr[3] = new u(30, new t(19, 16), new t(6, 17));
        r0[20] = new s(21, iArr, uVarArr);
        iArr = new int[]{6, 26, 50, 74, 98};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(2, 111), new t(7, 112));
        uVarArr[1] = new u(28, new t(17, 46));
        uVarArr[2] = new u(30, new t(7, 24), new t(16, 25));
        uVarArr[3] = new u(24, new t(34, 13));
        r0[21] = new s(22, iArr, uVarArr);
        iArr = new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(4, 121), new t(5, 122));
        uVarArr[1] = new u(28, new t(4, 47), new t(14, 48));
        uVarArr[2] = new u(30, new t(11, 24), new t(14, 25));
        uVarArr[3] = new u(30, new t(16, 15), new t(14, 16));
        r0[22] = new s(23, iArr, uVarArr);
        iArr = new int[]{6, 28, 54, 80, B.o};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(6, 117), new t(4, 118));
        uVarArr[1] = new u(28, new t(6, 45), new t(14, 46));
        uVarArr[2] = new u(30, new t(11, 24), new t(16, 25));
        uVarArr[3] = new u(30, new t(30, 16), new t(2, 17));
        r0[23] = new s(24, iArr, uVarArr);
        iArr = new int[]{6, 32, 58, 84, 110};
        uVarArr = new u[4];
        uVarArr[0] = new u(26, new t(8, B.o), new t(4, B.p));
        uVarArr[1] = new u(28, new t(8, 47), new t(13, 48));
        uVarArr[2] = new u(30, new t(7, 24), new t(22, 25));
        uVarArr[3] = new u(30, new t(22, 15), new t(13, 16));
        r0[24] = new s(25, iArr, uVarArr);
        iArr = new int[]{6, 30, 58, 86, 114};
        uVarArr = new u[4];
        uVarArr[0] = new u(28, new t(10, 114), new t(2, 115));
        uVarArr[1] = new u(28, new t(19, 46), new t(4, 47));
        uVarArr[2] = new u(28, new t(28, 22), new t(6, 23));
        uVarArr[3] = new u(30, new t(33, 16), new t(4, 17));
        r0[25] = new s(26, iArr, uVarArr);
        iArr = new int[]{6, 34, 62, 90, 118};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(8, 122), new t(4, 123));
        uVarArr[1] = new u(28, new t(22, 45), new t(3, 46));
        uVarArr[2] = new u(30, new t(8, 23), new t(26, 24));
        uVarArr[3] = new u(30, new t(12, 15), new t(28, 16));
        r0[26] = new s(27, iArr, uVarArr);
        iArr = new int[]{6, 26, 50, 74, 98, 122};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(3, 117), new t(10, 118));
        uVarArr[1] = new u(28, new t(3, 45), new t(23, 46));
        uVarArr[2] = new u(30, new t(4, 24), new t(31, 25));
        uVarArr[3] = new u(30, new t(11, 15), new t(31, 16));
        r0[27] = new s(28, iArr, uVarArr);
        iArr = new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, android.support.v4.media.h.i};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(7, 116), new t(7, 117));
        uVarArr[1] = new u(28, new t(21, 45), new t(7, 46));
        uVarArr[2] = new u(30, new t(1, 23), new t(37, 24));
        uVarArr[3] = new u(30, new t(19, 15), new t(26, 16));
        r0[28] = new s(29, iArr, uVarArr);
        iArr = new int[]{6, 26, 52, 78, d.e, android.support.v4.media.h.k};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(5, 115), new t(10, 116));
        uVarArr[1] = new u(28, new t(19, 47), new t(10, 48));
        uVarArr[2] = new u(30, new t(15, 24), new t(25, 25));
        uVarArr[3] = new u(30, new t(23, 15), new t(25, 16));
        r0[29] = new s(30, iArr, uVarArr);
        iArr = new int[]{6, 30, 56, 82, 108, 134};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(13, 115), new t(3, 116));
        uVarArr[1] = new u(28, new t(2, 46), new t(29, 47));
        uVarArr[2] = new u(30, new t(42, 24), new t(1, 25));
        uVarArr[3] = new u(30, new t(23, 15), new t(28, 16));
        r0[30] = new s(31, iArr, uVarArr);
        iArr = new int[]{6, 34, 60, 86, 112, 138};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(17, 115));
        uVarArr[1] = new u(28, new t(10, 46), new t(23, 47));
        uVarArr[2] = new u(30, new t(10, 24), new t(35, 25));
        uVarArr[3] = new u(30, new t(19, 15), new t(35, 16));
        r0[31] = new s(32, iArr, uVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(17, 115), new t(1, 116));
        uVarArr[1] = new u(28, new t(14, 46), new t(21, 47));
        uVarArr[2] = new u(30, new t(29, 24), new t(19, 25));
        uVarArr[3] = new u(30, new t(11, 15), new t(46, 16));
        r0[32] = new s(33, iArr, uVarArr);
        iArr = new int[]{6, 34, 62, 90, 118, 146};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(13, 115), new t(6, 116));
        uVarArr[1] = new u(28, new t(14, 46), new t(23, 47));
        uVarArr[2] = new u(30, new t(44, 24), new t(7, 25));
        uVarArr[3] = new u(30, new t(59, 16), new t(1, 17));
        r0[33] = new s(34, iArr, uVarArr);
        iArr = new int[]{6, 30, 54, 78, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, android.support.v4.media.h.i, a.ap};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(12, 121), new t(7, 122));
        uVarArr[1] = new u(28, new t(12, 47), new t(26, 48));
        uVarArr[2] = new u(30, new t(39, 24), new t(14, 25));
        uVarArr[3] = new u(30, new t(22, 15), new t(41, 16));
        r0[34] = new s(35, iArr, uVarArr);
        iArr = new int[]{6, 24, 50, 76, ShareData.SHARE_TYPE_LAB_SITUP_NEW_RECORD, C0113o.h, 154};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(6, 121), new t(14, 122));
        uVarArr[1] = new u(28, new t(6, 47), new t(34, 48));
        uVarArr[2] = new u(30, new t(46, 24), new t(10, 25));
        uVarArr[3] = new u(30, new t(2, 15), new t(64, 16));
        r0[35] = new s(36, iArr, uVarArr);
        iArr = new int[]{6, 28, 54, 80, B.o, 132, 158};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(17, 122), new t(4, 123));
        uVarArr[1] = new u(28, new t(29, 46), new t(14, 47));
        uVarArr[2] = new u(30, new t(49, 24), new t(10, 25));
        uVarArr[3] = new u(30, new t(24, 15), new t(46, 16));
        r0[36] = new s(37, iArr, uVarArr);
        iArr = new int[]{6, 32, 58, 84, 110, 136, 162};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(4, 122), new t(18, 123));
        uVarArr[1] = new u(28, new t(13, 46), new t(32, 47));
        uVarArr[2] = new u(30, new t(48, 24), new t(14, 25));
        uVarArr[3] = new u(30, new t(42, 15), new t(32, 16));
        r0[37] = new s(38, iArr, uVarArr);
        iArr = new int[]{6, 26, 54, 82, 110, 138, 166};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(20, 117), new t(4, 118));
        uVarArr[1] = new u(28, new t(40, 47), new t(7, 48));
        uVarArr[2] = new u(30, new t(43, 24), new t(22, 25));
        uVarArr[3] = new u(30, new t(10, 15), new t(67, 16));
        r0[38] = new s(39, iArr, uVarArr);
        iArr = new int[]{6, 30, 58, 86, 114, 142, a.aC};
        uVarArr = new u[4];
        uVarArr[0] = new u(30, new t(19, 118), new t(6, 119));
        uVarArr[1] = new u(28, new t(18, 47), new t(31, 48));
        uVarArr[2] = new u(30, new t(34, 24), new t(34, 25));
        uVarArr[3] = new u(30, new t(20, 15), new t(61, 16));
        r0[39] = new s(40, iArr, uVarArr);
        return r0;
    }

    public int a() {
        return this.c;
    }

    public u a(o oVar) {
        return this.e[oVar.ordinal()];
    }

    public int[] b() {
        return this.d;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return (this.c * 4) + 17;
    }

    b e() {
        int d = d();
        b bVar = new b(d);
        bVar.a(0, 0, 9, 9);
        bVar.a(d - 8, 0, 8, 9);
        bVar.a(0, d - 8, 9, 8);
        int length = this.d.length;
        int i = 0;
        while (i < length) {
            int i2 = this.d[i] - 2;
            int i3 = 0;
            while (i3 < length) {
                if (!((i == 0 && (i3 == 0 || i3 == length - 1)) || (i == length - 1 && i3 == 0))) {
                    bVar.a(this.d[i3] - 2, i2, 5, 5);
                }
                i3++;
            }
            i++;
        }
        bVar.a(6, 9, 1, d - 17);
        bVar.a(9, 6, d - 17, 1);
        if (this.c > 6) {
            bVar.a(d - 11, 0, 3, 6);
            bVar.a(0, d - 11, 6, 3);
        }
        return bVar;
    }

    public String toString() {
        return String.valueOf(this.c);
    }
}

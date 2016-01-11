package com.c.b.a.c;

import android.support.v4.media.h;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import com.c.b.c.a;
import com.xiaomi.hm.health.dataprocess.HeartRateInfo;
import com.xiaomi.hm.health.t;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    static final String[] a = new String[]{"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};
    static final int b = 0;
    static final int c = 1;
    static final int d = 2;
    static final int e = 3;
    static final int f = 4;
    static final int[][] g = new int[][]{new int[]{b, 327708, 327710, 327709, 656318}, new int[]{590318, b, 327710, 327709, 656318}, new int[]{262158, 590300, b, 590301, 932798}, new int[]{327709, 327708, 656318, b, 327710}, new int[]{327711, 656380, 656382, 656381, b}};
    static final int[][] h = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{6, 6}));
    private static final int[][] i = ((int[][]) Array.newInstance(Integer.TYPE, new int[]{5, PersonInfo.INCOMING_CALL_DISABLE_BIT}));
    private final byte[] j;

    static {
        int i;
        i[b][32] = c;
        for (i = 65; i <= 90; i += c) {
            i[b][i] = (i - 65) + d;
        }
        i[c][32] = c;
        for (i = 97; i <= 122; i += c) {
            i[c][i] = (i - 97) + d;
        }
        i[d][32] = c;
        for (i = 48; i <= 57; i += c) {
            i[d][i] = (i - 48) + d;
        }
        i[d][44] = 12;
        i[d][46] = 13;
        int[] iArr = new int[]{b, 32, c, d, e, f, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, h.i, h.j};
        for (i = b; i < iArr.length; i += c) {
            i[e][iArr[i]] = i;
        }
        iArr = new int[]{b, 13, b, b, b, b, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (i = b; i < iArr.length; i += c) {
            if (iArr[i] > 0) {
                i[f][iArr[i]] = i;
            }
        }
        int[][] iArr2 = h;
        int length = iArr2.length;
        for (i = b; i < length; i += c) {
            Arrays.fill(iArr2[i], -1);
        }
        h[b][f] = b;
        h[c][f] = b;
        h[c][b] = 28;
        h[e][f] = b;
        h[d][f] = b;
        h[d][b] = 15;
    }

    public d(byte[] bArr) {
        this.j = bArr;
    }

    private static Collection<g> a(Iterable<g> iterable) {
        Collection linkedList = new LinkedList();
        for (g gVar : iterable) {
            Object obj;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                g gVar2 = (g) it.next();
                if (gVar2.a(gVar)) {
                    obj = null;
                    break;
                } else if (gVar.a(gVar2)) {
                    it.remove();
                }
            }
            obj = c;
            if (obj != null) {
                linkedList.add(gVar);
            }
        }
        return linkedList;
    }

    private Collection<g> a(Iterable<g> iterable, int i) {
        Collection linkedList = new LinkedList();
        for (g a : iterable) {
            a(a, i, linkedList);
        }
        return a(linkedList);
    }

    private static Collection<g> a(Iterable<g> iterable, int i, int i2) {
        Iterable linkedList = new LinkedList();
        for (g a : iterable) {
            a(a, i, i2, linkedList);
        }
        return a(linkedList);
    }

    private static void a(g gVar, int i, int i2, Collection<g> collection) {
        g b = gVar.b(i);
        collection.add(b.a(f, i2));
        if (gVar.a() != f) {
            collection.add(b.b(f, i2));
        }
        if (i2 == e || i2 == f) {
            collection.add(b.a(d, 16 - i2).a(d, c));
        }
        if (gVar.c() > 0) {
            collection.add(gVar.a(i).a(i + c));
        }
    }

    private void a(g gVar, int i, Collection<g> collection) {
        char c = (char) (this.j[i] & HeartRateInfo.HR_EMPTY_VALUE);
        Object obj = i[gVar.a()][c] > 0 ? c : b;
        g gVar2 = null;
        int i2 = b;
        while (i2 <= f) {
            int i3 = i[i2][c];
            if (i3 > 0) {
                if (gVar2 == null) {
                    gVar2 = gVar.b(i);
                }
                if (obj == null || i2 == gVar.a() || i2 == d) {
                    collection.add(gVar2.a(i2, i3));
                }
                if (obj == null && h[gVar.a()][i2] >= 0) {
                    collection.add(gVar2.b(i2, i3));
                }
            }
            i2 += c;
        }
        if (gVar.c() > 0 || i[gVar.a()][c] == 0) {
            collection.add(gVar.a(i));
        }
    }

    public a a() {
        Iterable singletonList = Collections.singletonList(g.a);
        int i = b;
        while (i < this.j.length) {
            int i2;
            byte b = i + c < this.j.length ? this.j[i + c] : (byte) 0;
            switch (this.j[i]) {
                case t.WeightView_wv_bmi_size /*13*/:
                    if (b != (byte) 10) {
                        i2 = b;
                        break;
                    }
                    i2 = d;
                    break;
                case (byte) 44:
                    if (b != (byte) 32) {
                        i2 = b;
                        break;
                    }
                    i2 = f;
                    break;
                case kankan.wheel.widget.a.aZ /*46*/:
                    if (b != (byte) 32) {
                        i2 = b;
                        break;
                    }
                    i2 = e;
                    break;
                case (byte) 58:
                    if (b != (byte) 32) {
                        i2 = b;
                        break;
                    }
                    i2 = 5;
                    break;
                default:
                    i2 = b;
                    break;
            }
            if (i2 > 0) {
                singletonList = a(singletonList, i, i2);
                i += c;
            } else {
                singletonList = a(singletonList, i);
            }
            i += c;
        }
        return ((g) Collections.min(singletonList, new e(this))).a(this.j);
    }
}

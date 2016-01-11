package com.f.a.c;

import android.opengl.GLES10;
import com.f.a.b.a.f;
import com.f.a.b.a.i;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public final class b {
    private static final int a = 2048;
    private static f b;

    static {
        int[] iArr = new int[1];
        GLES10.glGetIntegerv(3379, iArr, 0);
        int max = Math.max(iArr[0], a);
        b = new f(max, max);
    }

    private b() {
    }

    public static int a(f fVar) {
        int a = fVar.a();
        int b = fVar.b();
        return Math.max((int) Math.ceil((double) (((float) a) / ((float) b.a()))), (int) Math.ceil((double) (((float) b) / ((float) b.b()))));
    }

    public static int a(f fVar, f fVar2, i iVar, boolean z) {
        int a = fVar.a();
        int b = fVar.b();
        int a2 = fVar2.a();
        int b2 = fVar2.b();
        int i = a / a2;
        int i2 = b / b2;
        switch (c.a[iVar.ordinal()]) {
            case l.a /*1*/:
                if (!z) {
                    b = Math.max(i, i2);
                    break;
                }
                i = a;
                a = b;
                b = 1;
                while (true) {
                    if (i / 2 < a2 && a / 2 < b2) {
                        break;
                    }
                    i /= 2;
                    a /= 2;
                    b *= 2;
                }
                break;
            case a.k /*2*/:
                if (!z) {
                    b = Math.min(i, i2);
                    break;
                }
                i = a;
                a = b;
                b = 1;
                while (i / 2 >= a2 && a / 2 >= b2) {
                    i /= 2;
                    a /= 2;
                    b *= 2;
                }
                break;
            default:
                b = 1;
                break;
        }
        return b < 1 ? 1 : b;
    }

    public static f a(com.f.a.b.e.a aVar, f fVar) {
        int a = aVar.a();
        if (a <= 0) {
            a = fVar.a();
        }
        int b = aVar.b();
        if (b <= 0) {
            b = fVar.b();
        }
        return new f(a, b);
    }

    public static float b(f fVar, f fVar2, i iVar, boolean z) {
        int i;
        int a = fVar.a();
        int b = fVar.b();
        int a2 = fVar2.a();
        int b2 = fVar2.b();
        float f = ((float) a) / ((float) a2);
        float f2 = ((float) b) / ((float) b2);
        if ((iVar != i.FIT_INSIDE || f < f2) && (iVar != i.CROP || f >= f2)) {
            i = (int) (((float) a) / f2);
            a2 = b2;
        } else {
            i = a2;
            a2 = (int) (((float) b) / f);
        }
        return ((z || i >= a || a2 >= b) && (!z || i == a || a2 == b)) ? 1.0f : ((float) i) / ((float) a);
    }
}

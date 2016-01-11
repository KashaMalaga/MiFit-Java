package com.huami.android.zxing;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v4.view.C0151az;
import com.c.a.C0993k;
import com.c.a.r;
import com.c.b.a;
import com.c.b.c.b;
import com.c.b.g;
import com.c.b.l;
import com.d.a.a.h;
import java.util.EnumMap;
import java.util.Map;

public class z {
    private static C0993k a;

    private z() {
    }

    public static Bitmap a(Object obj, int i) {
        if (obj == null) {
            return null;
        }
        Map enumMap;
        Object b = a().b(obj);
        String a = a(b);
        if (a != null) {
            enumMap = new EnumMap(g.class);
            enumMap.put(g.CHARACTER_SET, a);
        } else {
            enumMap = null;
        }
        try {
            b a2 = new l().a(b, a.QR_CODE, i, i, enumMap);
            int f = a2.f();
            int g = a2.g();
            int[] iArr = new int[(f * g)];
            for (int i2 = 0; i2 < g; i2++) {
                int i3 = i2 * f;
                for (int i4 = 0; i4 < f; i4++) {
                    iArr[i3 + i4] = a2.a(i4, i2) ? C0151az.s : 0;
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(f, g, Config.ARGB_8888);
            createBitmap.setPixels(iArr, 0, f, 0, 0, f, g);
            return createBitmap;
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static C0993k a() {
        if (a == null) {
            synchronized (z.class) {
                if (a == null) {
                    a = new r().i();
                }
            }
        }
        return a;
    }

    public static String a(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > '\u00ff') {
                return h.DEFAULT_CHARSET;
            }
        }
        return null;
    }
}

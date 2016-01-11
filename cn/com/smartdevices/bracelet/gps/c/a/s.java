package cn.com.smartdevices.bracelet.gps.c.a;

import android.content.Context;
import android.util.SparseArray;
import cn.com.smartdevices.bracelet.gps.model.l;
import cn.com.smartdevices.bracelet.gps.services.aa;
import java.util.List;

public class s {
    private static s a = null;
    private final SparseArray<l> b = new SparseArray(1);

    private s() {
    }

    public static synchronized s a() {
        s sVar;
        synchronized (s.class) {
            if (a == null) {
                a = new s();
            }
            sVar = a;
        }
        return sVar;
    }

    public l a(Context context, int i) {
        if (this.b.get(i) != null) {
            return (l) this.b.get(i);
        }
        l c = p.c(context, i);
        if (c == null) {
            return null;
        }
        this.b.put(i, c);
        return c;
    }

    public boolean a(Context context, l lVar) {
        if (lVar == null) {
            return false;
        }
        this.b.put(lVar.c(), lVar);
        return p.a(context, lVar);
    }

    public boolean a(Context context, aa aaVar) {
        if (context == null || aaVar == null) {
            throw new IllegalArgumentException();
        }
        l a = a(context, aaVar.i());
        if (a == null) {
            a = new l(aaVar.i());
            this.b.put(aaVar.i(), a);
        }
        if (aaVar.o() <= a.b()) {
            return true;
        }
        a.a(aaVar.o());
        a.c = (int) (((float) a.c) + aaVar.e());
        a.a += aaVar.l();
        a.b++;
        return p.a(context, a);
    }

    public boolean a(Context context, List<? extends aa> list, int i) {
        if (context == null || list == null) {
            throw new IllegalArgumentException();
        }
        l lVar = new l(i);
        for (aa aaVar : list) {
            lVar.c = (int) (((float) lVar.c) + aaVar.e());
            lVar.a += aaVar.l();
            lVar.b++;
            if (aaVar.o() > lVar.b()) {
                lVar.a(aaVar.o());
            }
        }
        this.b.put(i, lVar);
        return p.a(context, lVar);
    }

    public void b() {
        this.b.clear();
    }

    public boolean b(Context context, aa aaVar) {
        if (context == null || aaVar == null) {
            throw new IllegalArgumentException();
        }
        l a = a(context, aaVar.i());
        if (a == null) {
            a = new l(aaVar.i());
            this.b.put(aaVar.i(), a);
        }
        a.c = (int) (((float) a.c) - aaVar.e());
        a.a -= aaVar.l();
        a.b--;
        return p.a(context, a);
    }
}

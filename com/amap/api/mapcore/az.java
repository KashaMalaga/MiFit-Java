package com.amap.api.mapcore;

import android.content.Context;
import android.view.View;
import com.amap.api.mapcore.util.u;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

public class az extends View {
    CopyOnWriteArrayList<af> a = new CopyOnWriteArrayList();
    a b = new a();
    CopyOnWriteArrayList<Integer> c = new CopyOnWriteArrayList();
    private t d;

    class a implements Serializable, Comparator<Object> {
        a() {
        }

        public int compare(Object obj, Object obj2) {
            af afVar = (af) obj;
            af afVar2 = (af) obj2;
            if (!(afVar == null || afVar2 == null)) {
                try {
                    if (afVar.d() > afVar2.d()) {
                        return 1;
                    }
                    if (afVar.d() < afVar2.d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    com.amap.api.mapcore.util.az.a(th, "TileOverlayView", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    public az(Context context) {
        super(context);
    }

    public az(Context context, t tVar) {
        super(context);
        this.d = tVar;
    }

    t a() {
        return this.d;
    }

    public void a(af afVar) {
        b(afVar);
        this.a.add(afVar);
        c();
    }

    public void a(GL10 gl10) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            u.a(gl10, ((Integer) it.next()).intValue());
        }
        this.c.clear();
        it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar.e()) {
                afVar.a(gl10);
            }
        }
    }

    public void a(boolean z) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar != null && afVar.e()) {
                afVar.b(z);
            }
        }
    }

    public void b() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar != null) {
                afVar.a();
            }
        }
        this.a.clear();
    }

    public void b(boolean z) {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar != null) {
                afVar.c(z);
            }
        }
    }

    public boolean b(af afVar) {
        return this.a.remove(afVar);
    }

    void c() {
        Object[] toArray = this.a.toArray();
        Arrays.sort(toArray, this.b);
        this.a.clear();
        for (Object obj : toArray) {
            this.a.add((af) obj);
        }
    }

    public void d() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar != null) {
                afVar.g();
            }
        }
    }

    public void e() {
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            af afVar = (af) it.next();
            if (afVar != null) {
                afVar.h();
            }
        }
    }
}

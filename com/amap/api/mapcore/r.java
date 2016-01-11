package com.amap.api.mapcore;

import android.util.Log;
import com.amap.api.mapcore.util.az;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class r {
    private static int b = 0;
    a a = new a();
    private CopyOnWriteArrayList<aa> c = new CopyOnWriteArrayList();

    class a implements Serializable, Comparator<Object> {
        a() {
        }

        public int compare(Object obj, Object obj2) {
            aa aaVar = (aa) obj;
            aa aaVar2 = (aa) obj2;
            if (!(aaVar == null || aaVar2 == null)) {
                try {
                    if (aaVar.d() > aaVar2.d()) {
                        return 1;
                    }
                    if (aaVar.d() < aaVar2.d()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.a(th, "GLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    r() {
    }

    static String a(String str) {
        b++;
        return str + b;
    }

    private aa c(String str) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            if (aaVar != null && aaVar.c().equals(str)) {
                return aaVar;
            }
        }
        return null;
    }

    public void a() {
        try {
            this.c.clear();
            b = 0;
        } catch (Throwable th) {
            az.a(th, "GLOverlayLayer", "clear");
            th.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer clear erro" + th.getMessage());
        }
    }

    public void a(aa aaVar) {
        b(aaVar.c());
        this.c.add(aaVar);
        c();
    }

    public void a(GL10 gl10, boolean z, int i) {
        int size = this.c.size();
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            try {
                if (aaVar.e()) {
                    if (size > 20) {
                        if (aaVar.a()) {
                            if (z) {
                                if (aaVar.d() <= ((float) i)) {
                                    aaVar.a(gl10);
                                }
                            } else if (aaVar.d() > ((float) i)) {
                                aaVar.a(gl10);
                            }
                        }
                    } else if (z) {
                        if (aaVar.d() <= ((float) i)) {
                            aaVar.a(gl10);
                        }
                    } else if (aaVar.d() > ((float) i)) {
                        aaVar.a(gl10);
                    }
                }
            } catch (Throwable e) {
                az.a(e, "GLOverlayLayer", "draw");
                e.printStackTrace();
            }
        }
    }

    public void b() {
        try {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                ((aa) it.next()).j();
            }
            a();
        } catch (Throwable th) {
            az.a(th, "GLOverlayLayer", "destory");
            th.printStackTrace();
            Log.d("amapApi", "GLOverlayLayer destory erro" + th.getMessage());
        }
    }

    public boolean b(String str) {
        aa c = c(str);
        return c != null ? this.c.remove(c) : false;
    }

    protected void c() {
        try {
            Object[] toArray = this.c.toArray();
            Arrays.sort(toArray, this.a);
            this.c.clear();
            for (Object obj : toArray) {
                this.c.add((aa) obj);
            }
        } catch (Throwable th) {
            az.a(th, "GLOverlayLayer", "changeOverlayIndex");
            th.printStackTrace();
        }
    }

    public void d() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            if (aaVar != null) {
                try {
                    aaVar.g();
                } catch (Throwable e) {
                    az.a(e, "GLOverlayLayer", "calMapFPoint");
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean e() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aa aaVar = (aa) it.next();
            if (aaVar != null && !aaVar.k()) {
                return false;
            }
        }
        return true;
    }
}

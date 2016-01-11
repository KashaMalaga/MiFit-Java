package com.amap.api.mapcore;

import com.amap.api.mapcore.util.az;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.opengles.GL10;

class o {
    a a = new a();
    private CopyOnWriteArrayList<q> b = new CopyOnWriteArrayList();

    class a implements Serializable, Comparator<Object> {
        a() {
        }

        public int compare(Object obj, Object obj2) {
            q qVar = (q) obj;
            q qVar2 = (q) obj2;
            if (!(qVar == null || qVar2 == null)) {
                try {
                    if (qVar.getZIndex() > qVar2.getZIndex()) {
                        return 1;
                    }
                    if (qVar.getZIndex() < qVar2.getZIndex()) {
                        return -1;
                    }
                } catch (Throwable th) {
                    az.a(th, "CustomGLOverlayLayer", "compare");
                    th.printStackTrace();
                }
            }
            return 0;
        }
    }

    o() {
    }

    public void a(GL10 gl10) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((q) it.next()).onDrawFrame(gl10);
        }
    }

    public boolean a(q qVar) {
        return this.b.contains(qVar) ? this.b.remove(qVar) : false;
    }
}

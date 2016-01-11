package cn.com.smartdevices.bracelet.chart.b;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class a extends d {
    private Executor d = Executors.newSingleThreadExecutor();
    private ArrayList<c> e = new ArrayList();

    public void a(int i) {
        c cVar = new c();
        cVar.executeOnExecutor(this.d, new Integer[]{Integer.valueOf(i)});
        this.e.add(cVar);
    }

    public boolean a() {
        if (!this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).isCancelled()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        if (!this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                if (!cVar.isCancelled()) {
                    cVar.cancel(false);
                }
            }
        }
        this.e.clear();
    }
}

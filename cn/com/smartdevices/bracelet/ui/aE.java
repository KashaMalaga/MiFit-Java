package cn.com.smartdevices.bracelet.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v13.app.h;
import cn.com.smartdevices.bracelet.chart.util.ChartData;
import cn.com.smartdevices.bracelet.model.PersonInfo;
import cn.com.smartdevices.bracelet.ui.widget.c;
import cn.com.smartdevices.bracelet.view.DynamicView;
import java.util.ArrayList;
import java.util.Iterator;

class aE extends h {
    final /* synthetic */ C0694ax c;
    private ArrayList<aF> d;

    public aE(C0694ax c0694ax, FragmentManager fragmentManager) {
        this.c = c0694ax;
        super(fragmentManager);
        d();
    }

    private void g(int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(ChartData.KEY_MODE, i);
        this.d.add((aF) Fragment.instantiate(this.c.getActivity(), aF.class.getName(), bundle));
    }

    public int a(Object obj) {
        return -2;
    }

    public Fragment a(int i) {
        return (Fragment) this.d.get(i);
    }

    public void a(float f) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((aF) it.next()).a(f);
        }
    }

    public void a(c cVar) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((aF) it.next()).a(cVar);
        }
    }

    public void a(boolean z) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((aF) it.next()).a(z);
        }
    }

    public int b() {
        return this.d.size();
    }

    public void b(boolean z) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            aF aFVar = (aF) it.next();
            aFVar.a(Boolean.valueOf(z));
            if (aFVar.c == PersonInfo.INCOMING_CALL_DISABLE_BIT) {
                aFVar.a(Boolean.valueOf(false));
            }
        }
    }

    public void d() {
        this.d = new ArrayList(3);
        if (this.c.D) {
            g(16);
        }
        if (this.c.E) {
            g(1);
        }
        if (this.c.F) {
            g(PersonInfo.INCOMING_CALL_DISABLE_BIT);
        }
    }

    public aF e(int i) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            aF aFVar = (aF) it.next();
            if (aFVar.c == i) {
                return aFVar;
            }
        }
        return null;
    }

    public DynamicView f(int i) {
        aF e = e(i);
        return e != null ? e.a : null;
    }
}

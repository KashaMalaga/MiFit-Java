package com.amap.api.mapcore.util;

import android.content.Context;
import java.util.List;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public class al {
    private aj a;

    public al(Context context) {
        this.a = new aj(context);
    }

    private am a(int i) {
        switch (i) {
            case a.i /*0*/:
                return new ah();
            case l.a /*1*/:
                return new ak();
            case a.k /*2*/:
                return new ag();
            default:
                return null;
        }
    }

    private void a(an anVar, am amVar) {
        amVar.a(anVar);
        this.a.a(amVar);
    }

    private void b(an anVar, am amVar) {
        String a = am.a(anVar.b());
        List c = this.a.c(a, amVar);
        if (c == null || c.size() == 0) {
            amVar.a(anVar);
            this.a.a(amVar);
            return;
        }
        an anVar2 = (an) c.get(0);
        if (anVar.a() == 0) {
            anVar2.b(anVar2.d() + 1);
        } else {
            anVar2.b(0);
        }
        amVar.a(anVar2);
        this.a.b(a, amVar);
    }

    private void c(String str, int i) {
        this.a.a(am.a(str), a(i));
    }

    public List<an> a(int i, int i2) {
        List<an> list = null;
        try {
            aq a = a(i2);
            list = this.a.c(am.a(i), a);
        } catch (Throwable th) {
            az.a(th, "LogDB", "ByState");
            th.printStackTrace();
        }
        return list;
    }

    public void a(an anVar, int i) {
        try {
            aq a = a(i);
            a.a(anVar);
            this.a.b(am.a(anVar.b()), a);
        } catch (Throwable th) {
            az.a(th, "LogDB", "updateLogInfo");
            th.printStackTrace();
        }
    }

    public void a(String str, int i) {
        try {
            c(str, i);
        } catch (Throwable th) {
            az.a(th, "LogDB", "delLog");
            th.printStackTrace();
        }
    }

    public void b(an anVar, int i) {
        try {
            am a = a(i);
            switch (i) {
                case a.i /*0*/:
                    a(anVar, a);
                    return;
                case l.a /*1*/:
                    b(anVar, a);
                    return;
                case a.k /*2*/:
                    b(anVar, a);
                    return;
                default:
                    return;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        th.printStackTrace();
    }

    public void b(String str, int i) {
        try {
            c(str, i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

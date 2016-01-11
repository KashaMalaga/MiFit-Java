package cn.com.smartdevices.bracelet.weight.a;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.i.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.g;
import cn.com.smartdevices.bracelet.model.LoginData;

public class a extends d<Integer> {
    private static final String a = "Syncer.Weight.Delete";
    private Context b;
    private LoginData c;

    public a(Context context, LoginData loginData, Integer num) {
        super(num);
        this.b = context;
        this.c = loginData;
    }

    public String tag() {
        return "Syncer.Weight.Delete_@" + Integer.toHexString(hashCode());
    }

    public void work() {
        C0596r.e(tag(), "Sync Start!!");
        if (this.c.isValid()) {
            try {
                String a = e.a(g.aa);
                h dVar = new cn.com.smartdevices.bracelet.i.a.a.d(this.b);
                cn.com.smartdevices.bracelet.i.a.e dVar2 = new d();
                cn.com.smartdevices.bracelet.i.b.a a2 = new cn.com.smartdevices.bracelet.i.b.a(this.mWorkParams).a((d) this, new c());
                a2.a((d) this, new e()).a((d) this, new b(this)).a((d) this, new cn.com.smartdevices.bracelet.i.a.a.a(a)).a((d) this, dVar);
                if (dVar.isSuccessed()) {
                    a2.a((d) this, dVar2);
                    success(dVar2.isSuccessed());
                }
            } catch (Throwable e) {
                C0596r.a(tag(), "Sync Exception!!", e);
            }
            C0596r.e(tag(), "Sync Finish!!");
            return;
        }
        C0596r.e(tag(), "Sync Stop!!");
    }
}

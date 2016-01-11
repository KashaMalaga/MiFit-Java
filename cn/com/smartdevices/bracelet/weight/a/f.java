package cn.com.smartdevices.bracelet.weight.a;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.i.b.a;
import cn.com.smartdevices.bracelet.i.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.j.g;
import cn.com.smartdevices.bracelet.model.LoginData;

public class f extends d<i> {
    private static final String a = "Syncer.Weight.Download";
    private Context b;
    private LoginData c;

    public f(Context context, LoginData loginData) {
        this(context, loginData, new i());
    }

    public f(Context context, LoginData loginData, i iVar) {
        super(iVar);
        this.b = context;
        this.c = loginData;
    }

    public String tag() {
        return "Syncer.Weight.Download_@" + Integer.toHexString(hashCode());
    }

    public void work() {
        C0596r.e(tag(), "Sync Start!!");
        if (this.c.isValid()) {
            try {
                String a = e.a(g.Z);
                h dVar = new cn.com.smartdevices.bracelet.i.a.a.d(this.b);
                cn.com.smartdevices.bracelet.i.a.e kVar = new k();
                a a2 = new a(this.mWorkParams).a((d) this, new g(this)).a((d) this, new cn.com.smartdevices.bracelet.i.a.a.a(a)).a((d) this, dVar);
                if (dVar.isSuccessed()) {
                    a2.a((d) this, new j()).a((d) this, kVar).a(new h(this));
                }
            } catch (Throwable e) {
                C0596r.a(tag(), "Sync Exception!!", e);
            }
            logState(tag());
            C0596r.e(tag(), "Sync Finish!!");
            return;
        }
        C0596r.e(tag(), "Sync Stop!!");
    }
}

package cn.com.smartdevices.bracelet.weight.a;

import android.content.Context;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.i.a.g;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.i.b.a;
import cn.com.smartdevices.bracelet.i.d;
import cn.com.smartdevices.bracelet.j.e;
import cn.com.smartdevices.bracelet.model.LoginData;

public class l extends d<Integer> {
    private static final String a = "Syncer.Weight.Upload";
    private Context b;
    private LoginData c;

    public l(Context context, LoginData loginData, Integer num) {
        super(num);
        this.b = context;
        this.c = loginData;
    }

    public String tag() {
        return "Syncer.Weight.Upload_@" + Integer.toHexString(hashCode());
    }

    public void work() {
        C0596r.e(tag(), "Sync Start!!");
        if (this.c.isValid()) {
            try {
                a aVar = new a(this.mWorkParams);
                cn.com.smartdevices.bracelet.i.a.a nVar = new n();
                i qVar = new q();
                g aVar2 = new cn.com.smartdevices.bracelet.i.a.a.a(e.a(cn.com.smartdevices.bracelet.j.g.Y));
                h dVar = new cn.com.smartdevices.bracelet.i.a.a.d(this.b);
                cn.com.smartdevices.bracelet.i.a.e oVar = new o();
                aVar = aVar.a((d) this, nVar);
                aVar.a((d) this, qVar).a((d) this, new m(this)).a((d) this, aVar2).a((d) this, dVar);
                if (dVar.isSuccessed()) {
                    aVar.a((d) this, oVar);
                    success(oVar.isSuccessed());
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

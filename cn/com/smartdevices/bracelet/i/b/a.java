package cn.com.smartdevices.bracelet.i.b;

import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.i.a.b;
import cn.com.smartdevices.bracelet.i.a.c;
import cn.com.smartdevices.bracelet.i.a.f;
import cn.com.smartdevices.bracelet.i.a.g;
import cn.com.smartdevices.bracelet.i.a.h;
import cn.com.smartdevices.bracelet.i.a.i;
import cn.com.smartdevices.bracelet.i.d;

public class a<Data> {
    protected b a;
    protected Data b;

    public a(b bVar) {
        this.a = bVar;
    }

    public a(Data data) {
        this.b = data;
    }

    public a a(c cVar) {
        cVar.before();
        return this;
    }

    public a a(f fVar) {
        fVar.then(this.a.state());
        return this;
    }

    public a a(d dVar, cn.com.smartdevices.bracelet.i.a.a aVar) {
        C0596r.e(dVar.tag(), "Sync Access... : " + this.b);
        a aVar2 = new a((b) aVar);
        try {
            aVar2.a(aVar.access(this.b));
            C0596r.e(dVar.tag(), "Sync Accessed Data : " + aVar2.b);
            if (aVar.isEmpty(aVar2.b)) {
                aVar.exception(new cn.com.smartdevices.bracelet.i.a(17));
            } else if (aVar.isIdle()) {
                aVar.success();
            }
        } catch (Throwable e) {
            aVar.exception(new cn.com.smartdevices.bracelet.i.a(1, e));
        }
        aVar.logState(dVar.tag());
        return aVar2;
    }

    public a a(d dVar, cn.com.smartdevices.bracelet.i.a.d dVar2) {
        if (this.a != null) {
            if (this.a.isException()) {
                throw this.a.getException();
            } else if (this.a.isPassedon()) {
                return this;
            }
        }
        C0596r.e(dVar.tag(), "Sync Parse...");
        a aVar = new a((b) dVar2);
        try {
            aVar.a(dVar2.a(this.b));
            if (dVar2.isIdle()) {
                dVar2.success();
            }
        } catch (Throwable e) {
            dVar2.exception(new cn.com.smartdevices.bracelet.i.a(6, e));
        }
        dVar2.logState(dVar.tag());
        return aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public cn.com.smartdevices.bracelet.i.b.a a(cn.com.smartdevices.bracelet.i.d r4, cn.com.smartdevices.bracelet.i.a.e r5) {
        /*
        r3 = this;
        r0 = r3.a;
        if (r0 == 0) goto L_0x001c;
    L_0x0004:
        r0 = r3.a;
        r0 = r0.isException();
        if (r0 == 0) goto L_0x0013;
    L_0x000c:
        r0 = r3.a;
        r0 = r0.getException();
        throw r0;
    L_0x0013:
        r0 = r3.a;
        r0 = r0.isPassedon();
        if (r0 == 0) goto L_0x001c;
    L_0x001b:
        return r3;
    L_0x001c:
        r0 = r4.tag();
        r1 = "Sync Process...";
        cn.com.smartdevices.bracelet.C0596r.e(r0, r1);
        r0 = r3.b;	 Catch:{ Exception -> 0x003d }
        r5.a(r0);	 Catch:{ Exception -> 0x003d }
        r0 = r5.isIdle();	 Catch:{ Exception -> 0x003d }
        if (r0 == 0) goto L_0x0033;
    L_0x0030:
        r5.success();	 Catch:{ Exception -> 0x003d }
    L_0x0033:
        r0 = r4.tag();
        r5.logState(r0);
        r3.a = r5;
        goto L_0x001b;
    L_0x003d:
        r0 = move-exception;
        r1 = new cn.com.smartdevices.bracelet.i.a;
        r2 = 5;
        r1.<init>(r2, r0);
        r5.exception(r1);
        goto L_0x0033;
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.com.smartdevices.bracelet.i.b.a.a(cn.com.smartdevices.bracelet.i.d, cn.com.smartdevices.bracelet.i.a.e):cn.com.smartdevices.bracelet.i.b.a");
    }

    public a a(d dVar, g gVar) {
        if (this.a == null || !this.a.isException()) {
            C0596r.e(dVar.tag(), "Sync Send...");
            a aVar = new a((b) gVar);
            try {
                aVar.a(gVar.a(this.b));
                C0596r.e(dVar.tag(), "Sync Send Received : " + aVar.b);
                if (gVar.isIdle()) {
                    gVar.success();
                }
            } catch (Throwable e) {
                gVar.exception(new cn.com.smartdevices.bracelet.i.a(4, e));
            }
            gVar.logState(dVar.tag());
            return aVar;
        }
        throw this.a.getException();
    }

    public a a(d dVar, h hVar) {
        if (this.a == null || !this.a.isException()) {
            C0596r.e(dVar.tag(), "Sync Check...");
            try {
                hVar.check(this.b);
                if (hVar.isIdle()) {
                    hVar.success();
                }
            } catch (Throwable e) {
                hVar.exception(new cn.com.smartdevices.bracelet.i.a(3, e));
            }
            hVar.logState(dVar.tag());
            this.a = hVar;
            return this;
        }
        throw this.a.getException();
    }

    public a a(d dVar, i iVar) {
        if (this.a == null || !this.a.isException()) {
            C0596r.e(dVar.tag(), "Sync Wrap...");
            a aVar = new a((b) iVar);
            try {
                aVar.a(iVar.wrap(this.b));
                C0596r.e(dVar.tag(), "Sync Wrapped Data : " + aVar.b);
                if (iVar.isIdle()) {
                    iVar.success();
                }
            } catch (Throwable e) {
                iVar.exception(new cn.com.smartdevices.bracelet.i.a(2, e));
            }
            iVar.logState(dVar.tag());
            return aVar;
        }
        throw this.a.getException();
    }

    public a a(Object obj, c cVar) {
        cVar.mArg = obj;
        return a(cVar);
    }

    public a a(Object obj, f fVar) {
        fVar.mArg = obj;
        return a(fVar);
    }

    public Data a() {
        return this.b;
    }

    public void a(Data data) {
        this.b = data;
    }
}

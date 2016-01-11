package cn.com.smartdevices.bracelet.gps.services;

import android.content.Context;
import android.text.TextUtils;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.sync.z;
import com.xiaomi.e.a;
import java.util.ArrayList;
import java.util.List;

final class C0447f extends C0446e {
    final /* synthetic */ C0445d d;
    private Context e = null;
    private long f = 0;
    private int g = 0;
    private int h = 0;
    private int i = 0;
    private List<c> j = null;
    private String k = a.f;

    public C0447f(C0445d c0445d, Context context, C0450i c0450i) {
        this.d = c0445d;
        super(c0445d);
        this.e = context;
        this.g = c0450i.d;
        this.f = c0450i.c;
        this.h = c0450i.a;
        this.i = c0450i.b;
    }

    protected Void a(Void... voidArr) {
        if (this.j != null && this.j.size() > 0) {
            try {
                List a = this.d.a(this.j, this.i, this.h);
                List arrayList = new ArrayList(1);
                C0453l c0453l = new C0453l(this.g, this.f);
                c0453l.a(a);
                arrayList.add(c0453l);
                c0453l.a(this.h, this.i);
                this.k = this.d.a(this.e, c0453l);
                if (TextUtils.isEmpty(this.k)) {
                    C0596r.e("Track", "CoordinateCreatorTask  mResultUri = null");
                } else {
                    c0453l.c(this.k);
                    p.b(this.e, arrayList);
                    z.a(this.e, this.f);
                }
            } catch (Exception e) {
                C0596r.d("Track", "Failed to create countour = " + this.f + ",message = " + e.getMessage());
            }
        }
        return null;
    }

    protected void a(Void voidR) {
        if (this.j != null) {
            this.j.clear();
        }
        this.d.a(this.f, this.k);
        super.a(voidR);
    }

    public void a(List<c> list) {
        this.j = list;
    }

    protected void b(Void voidR) {
        if (this.j != null) {
            this.j.clear();
        }
        this.d.a(this.f, this.k);
        super.b(voidR);
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onCancelled(Object obj) {
        a((Void) obj);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        b((Void) obj);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        if (this.f <= 0) {
            cancel(true);
        }
    }
}

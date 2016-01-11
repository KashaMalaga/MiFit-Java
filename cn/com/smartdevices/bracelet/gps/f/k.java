package cn.com.smartdevices.bracelet.gps.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import cn.com.smartdevices.bracelet.gps.services.C0445d;
import cn.com.smartdevices.bracelet.gps.services.C0450i;
import cn.com.smartdevices.bracelet.gps.services.N;
import cn.com.smartdevices.bracelet.gps.sync.C0485s;
import com.xiaomi.e.a;
import java.util.List;

@SuppressLint({"NewApi"})
final class k extends AsyncTask<Long, Void, List<c>> {
    final /* synthetic */ j a;
    private Context b = null;
    private boolean c = false;
    private int d = -1;
    private long e = 0;
    private String f = a.f;
    private C0445d g = null;

    public k(j jVar, Context context, int i, long j, String str) {
        this.a = jVar;
        this.b = context;
        this.d = i;
        this.e = j;
        this.f = str;
        this.g = new C0445d();
    }

    protected List<c> a(Long... lArr) {
        List<c> e = p.e(this.b, this.e);
        if (e == null) {
            return null;
        }
        if (e != null && e.size() > 0) {
            return e;
        }
        if (C0485s.a(this.b, this.e)) {
            if (j.a(this.f)) {
                this.f = this.g.b(this.b, this.d, this.e);
                C0596r.e("Track", "LoadTrackTask exeuteContourTrackSync mContourUri = " + this.f);
            }
            return p.e(this.b, this.e);
        }
        C0596r.e("Track", "LoadTrackTask syncSportDataFromServer failed tackId = " + this.e);
        return null;
    }

    public void a() {
        this.c = true;
        super.cancel(true);
    }

    public void a(N n) {
        this.g.a(n);
    }

    public void a(List<c> list) {
        if (this.a.h != null) {
            this.a.h.a(this.e, -1);
        }
    }

    public void b() {
        this.g.a();
    }

    protected void b(List<c> list) {
        if (this.a.h != null) {
            this.a.h.a(this.e, (List) list);
        }
    }

    void c(List<c> list) {
        this.a.a.a();
        if (list != null && list.size() > 0) {
            this.a.a.a((List) list);
            this.a.a.a((List) list, g.a(false));
            this.a.a.b((List) list);
            if (j.a(this.f)) {
                C0450i c0450i = new C0450i();
                c0450i.d = this.d;
                c0450i.c = this.e;
                c0450i.a = this.a.f;
                c0450i.b = this.a.g;
                this.g.a(this.b, (List) list, c0450i);
            }
            if (this.a.h != null) {
                this.a.h.a(this.e, 0);
            }
        } else if (this.a.h != null) {
            this.a.h.a(this.e, -1);
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Long[]) objArr);
    }

    public /* synthetic */ void onCancelled(Object obj) {
        a((List) obj);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        b((List) obj);
    }
}

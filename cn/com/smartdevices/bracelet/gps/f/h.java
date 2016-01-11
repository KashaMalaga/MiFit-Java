package cn.com.smartdevices.bracelet.gps.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.c;
import cn.com.smartdevices.bracelet.gps.model.g;
import java.util.List;

@SuppressLint({"NewApi"})
final class h extends AsyncTask<Long, Void, List<c>> {
    final /* synthetic */ g a;
    private boolean b = false;
    private int c = -1;
    private long d = 0;

    public h(g gVar, int i, long j) {
        this.a = gVar;
        this.c = i;
        this.d = j;
    }

    protected List<c> a(Long... lArr) {
        return p.e((Context) this.a.l.get(), this.d);
    }

    public void a() {
        this.b = true;
        super.cancel(true);
    }

    public void a(List<c> list) {
        if (this.a.m != null) {
            this.a.m.a(this.d, -1);
        }
    }

    protected void b(List<c> list) {
        if (list != null && list.size() > 0) {
            this.a.j.a((List) list, g.a(true, true, false));
            this.a.j.e();
            if (this.a.m != null) {
                this.a.m.a(this.d, 0);
            }
        } else if (this.a.m != null) {
            this.a.m.a(this.d, -1);
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

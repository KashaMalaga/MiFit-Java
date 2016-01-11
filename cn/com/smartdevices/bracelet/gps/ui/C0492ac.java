package cn.com.smartdevices.bracelet.gps.ui;

import android.os.AsyncTask;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.c.a.s;
import cn.com.smartdevices.bracelet.gps.model.l;
import cn.com.smartdevices.bracelet.gps.services.aa;
import java.util.List;

class C0492ac extends AsyncTask<Void, Void, l> {
    final /* synthetic */ HistoryActivity a;

    private C0492ac(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    protected l a(Void... voidArr) {
        l a = s.a().a(this.a, 4);
        if (a != null) {
            return a;
        }
        List<aa> d = p.d(this.a, 4);
        l lVar = new l();
        if (!(d == null || d.size() == 0)) {
            for (aa aaVar : d) {
                lVar.c = (int) (((float) lVar.c) + aaVar.e());
                lVar.a = aaVar.l() + lVar.a;
            }
            lVar.b = d.size();
        }
        return lVar;
    }

    protected void a(l lVar) {
        this.a.y = lVar;
        this.a.k();
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        a((l) obj);
    }
}

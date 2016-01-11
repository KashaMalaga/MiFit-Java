package cn.com.smartdevices.bracelet;

import android.content.Context;
import java.util.ArrayList;

class K extends H {
    final Context b;
    final /* synthetic */ F c;

    public K(F f, Context context) {
        this.c = f;
        super(f);
        this.b = context;
    }

    public void a() {
        C0596r.d("SyncMiLiDataCB", "SyncHandler doWork...");
        if (Utils.l(this.b)) {
            if (System.currentTimeMillis() - Keeper.readSyncToServerTime() < F.a) {
                C0596r.d("SyncMiLiDataCB", "sync to server less than 5 minutes!!!");
                C0401a.a(this.b, C0401a.eu);
            }
            C0591m a = C0591m.a();
            C0595q t = a.t();
            ArrayList a2 = a.a(t);
            if (a2 != null && a2.size() > 0) {
                ArrayList a3 = a(a2);
                C0596r.d("SyncMiLiDataCB", "Sync Total pages: " + a3.size() + ", page size = " + 3);
                for (int i = 0; i < a3.size(); i++) {
                    a(this.b, (ArrayList) a3.get(i), t);
                }
                return;
            }
            return;
        }
        C0596r.d("SyncMiLiDataCB", "No connected network!!!");
        C0401a.a(this.b, C0401a.et);
    }
}

package cn.com.smartdevices.bracelet.gps.ui;

import android.app.DialogFragment;
import cn.com.smartdevices.bracelet.C0401a;
import cn.com.smartdevices.bracelet.C0596r;
import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.model.l;
import cn.com.smartdevices.bracelet.gps.model.m;
import cn.com.smartdevices.bracelet.gps.services.aa;
import cn.com.smartdevices.bracelet.gps.sync.z;
import com.huami.android.view.e;
import java.util.ArrayList;

final class C0490aa implements e {
    final /* synthetic */ HistoryActivity a;
    private int b = -1;
    private int c = -1;
    private m d = null;
    private aa e = null;

    public C0490aa(HistoryActivity historyActivity, int i, int i2) {
        this.a = historyActivity;
        this.b = i;
        this.c = i2;
        this.d = historyActivity.g.a(this.b);
        this.e = historyActivity.g.b(this.b, this.c);
    }

    public void a(DialogFragment dialogFragment) {
    }

    public void b(DialogFragment dialogFragment) {
        if (this.e != null) {
            p.h(this.a.l, this.e.o(), 4);
            C0401a.a(this.a.getApplicationContext(), C0401a.bO);
        }
    }

    public void c(DialogFragment dialogFragment) {
        if (this.d != null && this.e != null) {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(Long.valueOf(this.e.o()));
            if (this.a.a(this.e.o())) {
                l f = this.a.y;
                f.a -= this.e.l();
                f = this.a.y;
                f.c = (int) (((float) f.c) - this.e.e());
                f = this.a.y;
                f.b--;
                this.a.k();
                this.a.g.a(this.b, this.c);
                if (this.a.g.getGroupCount() <= 0) {
                    this.a.b(false);
                } else {
                    this.a.g.notifyDataSetChanged();
                }
                z.a(this.a.l, 4, arrayList);
            } else {
                C0596r.e("UI", "deleteTargetTrackId failed to delete from db");
            }
            C0401a.a(this.a.getApplicationContext(), C0401a.bN);
        }
    }
}

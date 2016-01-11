package cn.com.smartdevices.bracelet.gps.ui;

import cn.com.smartdevices.bracelet.gps.c.a.p;
import cn.com.smartdevices.bracelet.gps.services.aa;
import com.huami.android.view.b;
import com.xiaomi.hm.health.b.a.n;

final class Z implements ao {
    final /* synthetic */ HistoryActivity a;

    private Z(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public void a(int i) {
        this.a.i();
        this.a.a(10);
    }

    public void a(long j, int i, boolean z) {
        this.a.a(i);
        if (z) {
            aa b = p.b(this.a.l, j, 4);
            if (b != null) {
                this.a.g.a(b);
                this.a.g.notifyDataSetChanged();
            }
        }
    }

    public void a(long j, long j2, long j3, boolean z, int i) {
        this.a.c(false);
        this.a.j.onRefreshComplete();
        if (z && j3 > -2) {
            this.a.k = j3;
        }
        if (z && j > -1 && j2 > -1) {
            this.a.a(j, j2);
        } else if (!z || i == 2) {
            b.a(this.a.l, n.running_failed_to_get_history_neterror, 0).show();
        }
    }

    public void a(long j, long j2, boolean z, int i) {
        if (z && j > -1 && j2 > -1) {
            this.a.a(j, j2);
        }
    }

    public void a(boolean z) {
        if (z) {
            new C0492ac(this.a).execute(new Void[0]);
        }
    }

    public void a(boolean z, int i) {
        this.a.a(100);
        this.a.f.sendEmptyMessageDelayed(3, 200);
    }
}

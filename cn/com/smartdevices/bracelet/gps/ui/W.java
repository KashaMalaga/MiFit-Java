package cn.com.smartdevices.bracelet.gps.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import cn.com.smartdevices.bracelet.gps.a.b;
import cn.com.smartdevices.bracelet.gps.sync.C0483q;

class W implements OnChildClickListener {
    final /* synthetic */ HistoryActivity a;

    W(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        b.c(this.a);
        Object valueOf = String.valueOf(this.a.g.b(i, i2).o());
        if (TextUtils.isEmpty(valueOf)) {
            return false;
        }
        try {
            long longValue = Long.valueOf(valueOf).longValue();
            Intent intent = new Intent(this.a.getApplicationContext(), GPSResultActivity.class);
            intent.putExtra(C0483q.a, longValue);
            try {
                this.a.startActivity(intent);
            } catch (Exception e) {
                com.huami.android.view.b.a(this.a.getApplicationContext(), "Error activity", 0).show();
            }
            return true;
        } catch (Exception e2) {
            return false;
        }
    }
}

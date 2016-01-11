package cn.com.smartdevices.bracelet.gps.ui;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

class U implements OnGroupClickListener {
    final /* synthetic */ HistoryActivity a;

    U(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        this.a.g.b(i);
        return true;
    }
}

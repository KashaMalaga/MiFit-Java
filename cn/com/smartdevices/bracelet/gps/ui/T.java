package cn.com.smartdevices.bracelet.gps.ui;

import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;

class T implements OnRefreshListener<ExpandableListView> {
    final /* synthetic */ HistoryActivity a;

    T(HistoryActivity historyActivity) {
        this.a = historyActivity;
    }

    public void onRefresh(PullToRefreshBase<ExpandableListView> pullToRefreshBase) {
        if (this.a.g()) {
            this.a.j.onRefreshComplete();
        } else {
            this.a.a(true);
        }
    }
}

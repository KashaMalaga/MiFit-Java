package cn.com.smartdevices.bracelet.gps.ui;

import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ExpandableListView;

class X implements OnScrollListener {
    final /* synthetic */ ExpandableListView a;
    final /* synthetic */ HistoryActivity b;

    X(HistoryActivity historyActivity, ExpandableListView expandableListView) {
        this.b = historyActivity;
        this.a = expandableListView;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        int packedPositionGroup = ExpandableListView.getPackedPositionGroup(this.a.getExpandableListPosition(i));
        if (i >= 1) {
            this.b.a.setVisibility(0);
            this.b.c = this.b.a.getHeight();
            if (packedPositionGroup != this.b.E) {
                this.b.b.setText(this.b.a(this.b.g.a(packedPositionGroup)));
                this.b.E = packedPositionGroup;
            }
            packedPositionGroup = this.b.c;
            int pointToPosition = this.a.pointToPosition(0, this.b.c);
            pointToPosition = ExpandableListView.getPackedPositionGroup(this.a.getExpandableListPosition(pointToPosition)) != this.b.E ? ((ViewGroup) this.a.getChildAt(pointToPosition - this.a.getFirstVisiblePosition())).getTop() : packedPositionGroup;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.b.a.getLayoutParams();
            marginLayoutParams.topMargin = -(this.b.c - pointToPosition);
            this.b.a.setLayoutParams(marginLayoutParams);
            return;
        }
        this.b.a.setVisibility(8);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}

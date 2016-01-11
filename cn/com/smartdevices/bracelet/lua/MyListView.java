package cn.com.smartdevices.bracelet.lua;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import cn.com.smartdevices.bracelet.C0596r;

public class MyListView extends ListView implements OnScrollListener {
    private static final int MAX_Y_OVERSCROLL_DISTANCE = 200;
    private static final String TAG = "MyListView";
    private Boolean disableDrag = Boolean.valueOf(false);
    private Context mContext;
    private int mMaxYOverscrollDistance;
    private SlidingUpPanelLayout parentPanelLayout = null;

    public MyListView(Context context) {
        super(context);
        this.mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initBounceListView();
    }

    public MyListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initBounceListView();
    }

    private void initBounceListView() {
        this.mMaxYOverscrollDistance = (int) (this.mContext.getResources().getDisplayMetrics().density * 200.0f);
        super.setOnScrollListener(this);
    }

    public Boolean getDisableDrag() {
        return this.disableDrag;
    }

    public SlidingUpPanelLayout getParentPanelLayout() {
        return this.parentPanelLayout;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        C0596r.e(TAG, "overscroll: deltaY = " + i2 + " scrollY = " + i4);
        if (!this.disableDrag.booleanValue() && i2 < 0) {
            this.parentPanelLayout.setSlidingEnabled(true);
        }
        return super.overScrollBy(i, i2, i3, i4, i5, i6, i7, this.mMaxYOverscrollDistance, z);
    }

    public void setDisableDrag(Boolean bool) {
        this.disableDrag = bool;
    }

    public void setParentPanelLayout(SlidingUpPanelLayout slidingUpPanelLayout) {
        this.parentPanelLayout = slidingUpPanelLayout;
    }
}

package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

public class PullToRefreshExpandableListView extends PullToRefreshAdapterViewBase<ExpandableListView> {

    class InternalExpandableListView extends ExpandableListView implements EmptyViewMethodAccessor {
        public InternalExpandableListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setEmptyView(View view) {
            PullToRefreshExpandableListView.this.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    @TargetApi(9)
    final class InternalExpandableListViewSDK9 extends InternalExpandableListView {
        public InternalExpandableListViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.overScrollBy(PullToRefreshExpandableListView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshExpandableListView(Context context) {
        super(context);
    }

    public PullToRefreshExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshExpandableListView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshExpandableListView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    protected ExpandableListView createRefreshableView(Context context, AttributeSet attributeSet) {
        ExpandableListView internalExpandableListViewSDK9 = VERSION.SDK_INT >= 9 ? new InternalExpandableListViewSDK9(context, attributeSet) : new InternalExpandableListView(context, attributeSet);
        internalExpandableListViewSDK9.setId(16908298);
        return internalExpandableListViewSDK9;
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }
}

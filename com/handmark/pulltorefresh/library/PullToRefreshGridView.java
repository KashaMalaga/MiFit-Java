package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;

public class PullToRefreshGridView extends PullToRefreshAdapterViewBase<GridView> {

    class InternalGridView extends GridView implements EmptyViewMethodAccessor {
        public InternalGridView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public void setEmptyView(View view) {
            PullToRefreshGridView.this.setEmptyView(view);
        }

        public void setEmptyViewInternal(View view) {
            super.setEmptyView(view);
        }
    }

    @TargetApi(9)
    final class InternalGridViewSDK9 extends InternalGridView {
        public InternalGridViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.overScrollBy(PullToRefreshGridView.this, i, i3, i2, i4, z);
            return overScrollBy;
        }
    }

    public PullToRefreshGridView(Context context) {
        super(context);
    }

    public PullToRefreshGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshGridView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshGridView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    protected final GridView createRefreshableView(Context context, AttributeSet attributeSet) {
        GridView internalGridViewSDK9 = VERSION.SDK_INT >= 9 ? new InternalGridViewSDK9(context, attributeSet) : new InternalGridView(context, attributeSet);
        internalGridViewSDK9.setId(R.id.gridview);
        return internalGridViewSDK9;
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.VERTICAL;
    }
}

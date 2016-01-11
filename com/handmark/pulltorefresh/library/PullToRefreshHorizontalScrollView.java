package com.handmark.pulltorefresh.library;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Orientation;

public class PullToRefreshHorizontalScrollView extends PullToRefreshBase<HorizontalScrollView> {

    @TargetApi(9)
    final class InternalHorizontalScrollViewSDK9 extends HorizontalScrollView {
        public InternalHorizontalScrollViewSDK9(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        private int getScrollRange() {
            return getChildCount() > 0 ? Math.max(0, getChildAt(0).getWidth() - ((getWidth() - getPaddingLeft()) - getPaddingRight())) : 0;
        }

        protected boolean overScrollBy(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
            boolean overScrollBy = super.overScrollBy(i, i2, i3, i4, i5, i6, i7, i8, z);
            OverscrollHelper.overScrollBy(PullToRefreshHorizontalScrollView.this, i, i3, i2, i4, getScrollRange(), z);
            return overScrollBy;
        }
    }

    public PullToRefreshHorizontalScrollView(Context context) {
        super(context);
    }

    public PullToRefreshHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PullToRefreshHorizontalScrollView(Context context, Mode mode) {
        super(context, mode);
    }

    public PullToRefreshHorizontalScrollView(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
    }

    protected HorizontalScrollView createRefreshableView(Context context, AttributeSet attributeSet) {
        HorizontalScrollView internalHorizontalScrollViewSDK9 = VERSION.SDK_INT >= 9 ? new InternalHorizontalScrollViewSDK9(context, attributeSet) : new HorizontalScrollView(context, attributeSet);
        internalHorizontalScrollViewSDK9.setId(R.id.scrollview);
        return internalHorizontalScrollViewSDK9;
    }

    public final Orientation getPullToRefreshScrollDirection() {
        return Orientation.HORIZONTAL;
    }

    protected boolean isReadyForPullEnd() {
        View childAt = ((HorizontalScrollView) this.mRefreshableView).getChildAt(0);
        return childAt != null ? ((HorizontalScrollView) this.mRefreshableView).getScrollX() >= childAt.getWidth() - getWidth() : false;
    }

    protected boolean isReadyForPullStart() {
        return ((HorizontalScrollView) this.mRefreshableView).getScrollX() == 0;
    }
}

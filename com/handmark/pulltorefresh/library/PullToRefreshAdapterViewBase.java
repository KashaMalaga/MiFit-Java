package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.handmark.pulltorefresh.library.PullToRefreshBase.AnimationStyle;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnLastItemVisibleListener;
import com.handmark.pulltorefresh.library.internal.EmptyViewMethodAccessor;
import com.handmark.pulltorefresh.library.internal.IndicatorLayout;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public abstract class PullToRefreshAdapterViewBase<T extends AbsListView> extends PullToRefreshBase<T> implements OnScrollListener {
    private View mEmptyView;
    private IndicatorLayout mIndicatorIvBottom;
    private IndicatorLayout mIndicatorIvTop;
    private boolean mLastItemVisible;
    private OnLastItemVisibleListener mOnLastItemVisibleListener;
    private OnScrollListener mOnScrollListener;
    private boolean mScrollEmptyView = true;
    private boolean mShowIndicator;

    /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[Mode.values().length];

        static {
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public PullToRefreshAdapterViewBase(Context context) {
        super(context);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode) {
        super(context, mode);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    public PullToRefreshAdapterViewBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context, mode, animationStyle);
        ((AbsListView) this.mRefreshableView).setOnScrollListener(this);
    }

    private void addIndicatorViews() {
        Mode mode = getMode();
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (mode.showHeaderLoadingLayout() && this.mIndicatorIvTop == null) {
            this.mIndicatorIvTop = new IndicatorLayout(getContext(), Mode.PULL_FROM_START);
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams.gravity = 53;
            refreshableViewWrapper.addView(this.mIndicatorIvTop, layoutParams);
        } else if (!(mode.showHeaderLoadingLayout() || this.mIndicatorIvTop == null)) {
            refreshableViewWrapper.removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (mode.showFooterLoadingLayout() && this.mIndicatorIvBottom == null) {
            this.mIndicatorIvBottom = new IndicatorLayout(getContext(), Mode.PULL_FROM_END);
            LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
            layoutParams2.rightMargin = getResources().getDimensionPixelSize(R.dimen.indicator_right_padding);
            layoutParams2.gravity = 85;
            refreshableViewWrapper.addView(this.mIndicatorIvBottom, layoutParams2);
        } else if (!mode.showFooterLoadingLayout() && this.mIndicatorIvBottom != null) {
            refreshableViewWrapper.removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private static FrameLayout.LayoutParams convertEmptyViewLayoutParams(LayoutParams layoutParams) {
        FrameLayout.LayoutParams layoutParams2 = null;
        if (layoutParams != null) {
            layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                layoutParams2.gravity = ((LinearLayout.LayoutParams) layoutParams).gravity;
            } else {
                layoutParams2.gravity = 17;
            }
        }
        return layoutParams2;
    }

    private boolean getShowIndicatorInternal() {
        return this.mShowIndicator && isPullToRefreshEnabled();
    }

    private boolean isFirstItemVisible() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            Log.d("PullToRefresh", "isFirstItemVisible. Empty View.");
            return true;
        }
        if (((AbsListView) this.mRefreshableView).getFirstVisiblePosition() <= 1) {
            View childAt = ((AbsListView) this.mRefreshableView).getChildAt(0);
            if (childAt != null) {
                return childAt.getTop() >= ((AbsListView) this.mRefreshableView).getTop();
            }
        }
        return false;
    }

    private boolean isLastItemVisible() {
        Adapter adapter = ((AbsListView) this.mRefreshableView).getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            Log.d("PullToRefresh", "isLastItemVisible. Empty View.");
            return true;
        }
        int count = ((AbsListView) this.mRefreshableView).getCount() - 1;
        int lastVisiblePosition = ((AbsListView) this.mRefreshableView).getLastVisiblePosition();
        Log.d("PullToRefresh", "isLastItemVisible. Last Item Position: " + count + " Last Visible Pos: " + lastVisiblePosition);
        if (lastVisiblePosition >= count - 1) {
            View childAt = ((AbsListView) this.mRefreshableView).getChildAt(lastVisiblePosition - ((AbsListView) this.mRefreshableView).getFirstVisiblePosition());
            if (childAt != null) {
                return childAt.getBottom() <= ((AbsListView) this.mRefreshableView).getBottom();
            }
        }
        return false;
    }

    private void removeIndicatorViews() {
        if (this.mIndicatorIvTop != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvTop);
            this.mIndicatorIvTop = null;
        }
        if (this.mIndicatorIvBottom != null) {
            getRefreshableViewWrapper().removeView(this.mIndicatorIvBottom);
            this.mIndicatorIvBottom = null;
        }
    }

    private void updateIndicatorViewsVisibility() {
        if (this.mIndicatorIvTop != null) {
            if (isRefreshing() || !isReadyForPullStart()) {
                if (this.mIndicatorIvTop.isVisible()) {
                    this.mIndicatorIvTop.hide();
                }
            } else if (!this.mIndicatorIvTop.isVisible()) {
                this.mIndicatorIvTop.show();
            }
        }
        if (this.mIndicatorIvBottom == null) {
            return;
        }
        if (isRefreshing() || !isReadyForPullEnd()) {
            if (this.mIndicatorIvBottom.isVisible()) {
                this.mIndicatorIvBottom.hide();
            }
        } else if (!this.mIndicatorIvBottom.isVisible()) {
            this.mIndicatorIvBottom.show();
        }
    }

    public boolean getShowIndicator() {
        return this.mShowIndicator;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
        this.mShowIndicator = typedArray.getBoolean(R.styleable.PullToRefresh_ptrShowIndicator, !isPullToRefreshOverScrollEnabled());
    }

    protected boolean isReadyForPullEnd() {
        return isLastItemVisible();
    }

    protected boolean isReadyForPullStart() {
        return isFirstItemVisible();
    }

    protected void onPullToRefresh() {
        super.onPullToRefresh();
        if (getShowIndicatorInternal()) {
            switch (AnonymousClass1.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[getCurrentMode().ordinal()]) {
                case l.a /*1*/:
                    this.mIndicatorIvBottom.pullToRefresh();
                    return;
                case a.k /*2*/:
                    this.mIndicatorIvTop.pullToRefresh();
                    return;
                default:
                    return;
            }
        }
    }

    protected void onRefreshing(boolean z) {
        super.onRefreshing(z);
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    protected void onReleaseToRefresh() {
        super.onReleaseToRefresh();
        if (getShowIndicatorInternal()) {
            switch (AnonymousClass1.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[getCurrentMode().ordinal()]) {
                case l.a /*1*/:
                    this.mIndicatorIvBottom.releaseToRefresh();
                    return;
                case a.k /*2*/:
                    this.mIndicatorIvTop.releaseToRefresh();
                    return;
                default:
                    return;
            }
        }
    }

    protected void onReset() {
        super.onReset();
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Log.d("PullToRefresh", "First Visible: " + i + ". Visible Count: " + i2 + ". Total Items:" + i3);
        if (this.mOnLastItemVisibleListener != null) {
            boolean z = i3 > 0 && i + i2 >= i3 - 1;
            this.mLastItemVisible = z;
        }
        if (getShowIndicatorInternal()) {
            updateIndicatorViewsVisibility();
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.mEmptyView != null && !this.mScrollEmptyView) {
            this.mEmptyView.scrollTo(-i, -i2);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && this.mOnLastItemVisibleListener != null && this.mLastItemVisible) {
            this.mOnLastItemVisibleListener.onLastItemVisible();
        }
        if (this.mOnScrollListener != null) {
            this.mOnScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    public void setAdapter(ListAdapter listAdapter) {
        ((AdapterView) this.mRefreshableView).setAdapter(listAdapter);
    }

    public final void setEmptyView(View view) {
        FrameLayout refreshableViewWrapper = getRefreshableViewWrapper();
        if (view != null) {
            view.setClickable(true);
            ViewParent parent = view.getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            LayoutParams convertEmptyViewLayoutParams = convertEmptyViewLayoutParams(view.getLayoutParams());
            if (convertEmptyViewLayoutParams != null) {
                refreshableViewWrapper.addView(view, convertEmptyViewLayoutParams);
            } else {
                refreshableViewWrapper.addView(view);
            }
        }
        if (this.mRefreshableView instanceof EmptyViewMethodAccessor) {
            ((EmptyViewMethodAccessor) this.mRefreshableView).setEmptyViewInternal(view);
        } else {
            ((AbsListView) this.mRefreshableView).setEmptyView(view);
        }
        this.mEmptyView = view;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        ((AbsListView) this.mRefreshableView).setOnItemClickListener(onItemClickListener);
    }

    public final void setOnLastItemVisibleListener(OnLastItemVisibleListener onLastItemVisibleListener) {
        this.mOnLastItemVisibleListener = onLastItemVisibleListener;
    }

    public final void setOnScrollListener(OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    public final void setScrollEmptyView(boolean z) {
        this.mScrollEmptyView = z;
    }

    public void setShowIndicator(boolean z) {
        this.mShowIndicator = z;
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }

    protected void updateUIForMode() {
        super.updateUIForMode();
        if (getShowIndicatorInternal()) {
            addIndicatorViews();
        } else {
            removeIndicatorViews();
        }
    }
}

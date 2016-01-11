package com.handmark.pulltorefresh.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.handmark.pulltorefresh.library.internal.FlipLoadingLayout;
import com.handmark.pulltorefresh.library.internal.LoadingLayout;
import com.handmark.pulltorefresh.library.internal.RotateLoadingLayout;
import com.handmark.pulltorefresh.library.internal.Utils;
import com.handmark.pulltorefresh.library.internal.ViewCompat;
import kankan.wheel.widget.a;
import kankan.wheel.widget.l;

public abstract class PullToRefreshBase<T extends View> extends LinearLayout implements IPullToRefresh<T> {
    static final boolean DEBUG = true;
    static final int DEMO_SCROLL_INTERVAL = 225;
    static final float FRICTION = 2.0f;
    static final String LOG_TAG = "PullToRefresh";
    public static final int SMOOTH_SCROLL_DURATION_MS = 200;
    public static final int SMOOTH_SCROLL_LONG_DURATION_MS = 325;
    static final String STATE_CURRENT_MODE = "ptr_current_mode";
    static final String STATE_MODE = "ptr_mode";
    static final String STATE_SCROLLING_REFRESHING_ENABLED = "ptr_disable_scrolling";
    static final String STATE_SHOW_REFRESHING_VIEW = "ptr_show_refreshing_view";
    static final String STATE_STATE = "ptr_state";
    static final String STATE_SUPER = "ptr_super";
    static final boolean USE_HW_LAYERS = false;
    private Mode mCurrentMode;
    private SmoothScrollRunnable mCurrentSmoothScrollRunnable;
    private boolean mFilterTouchEvents = DEBUG;
    private LoadingLayout mFooterLayout;
    private LoadingLayout mHeaderLayout;
    private float mInitialMotionX;
    private float mInitialMotionY;
    private boolean mIsBeingDragged = false;
    private float mLastMotionX;
    private float mLastMotionY;
    private boolean mLayoutVisibilityChangesEnabled = DEBUG;
    private AnimationStyle mLoadingAnimationStyle = AnimationStyle.getDefault();
    private Mode mMode = Mode.getDefault();
    private OnPullEventListener<T> mOnPullEventListener;
    private OnRefreshListener<T> mOnRefreshListener;
    private OnRefreshListener2<T> mOnRefreshListener2;
    private boolean mOverScrollEnabled = DEBUG;
    T mRefreshableView;
    private FrameLayout mRefreshableViewWrapper;
    private Interpolator mScrollAnimationInterpolator;
    private boolean mScrollingWhileRefreshingEnabled = false;
    private boolean mShowViewWhileRefreshing = DEBUG;
    private State mState = State.RESET;
    private int mTouchSlop;

    public interface OnRefreshListener<V extends View> {
        void onRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    public interface OnRefreshListener2<V extends View> {
        void onPullDownToRefresh(PullToRefreshBase<V> pullToRefreshBase);

        void onPullUpToRefresh(PullToRefreshBase<V> pullToRefreshBase);
    }

    interface OnSmoothScrollFinishedListener {
        void onSmoothScrollFinished();
    }

    /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle = new int[AnimationStyle.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode = new int[Mode.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation = new int[Orientation.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[AnimationStyle.ROTATE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[AnimationStyle.FLIP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_END.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.PULL_FROM_START.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.MANUAL_REFRESH_ONLY.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[Mode.BOTH.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.PULL_TO_REFRESH.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.RELEASE_TO_REFRESH.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.REFRESHING.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.MANUAL_REFRESHING.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[State.OVERSCROLLING.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.HORIZONTAL.ordinal()] = 1;
            } catch (NoSuchFieldError e13) {
            }
            try {
                $SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[Orientation.VERTICAL.ordinal()] = 2;
            } catch (NoSuchFieldError e14) {
            }
        }
    }

    public enum AnimationStyle {
        ROTATE,
        FLIP;

        static AnimationStyle getDefault() {
            return ROTATE;
        }

        static AnimationStyle mapIntToValue(int i) {
            switch (i) {
                case l.a /*1*/:
                    return FLIP;
                default:
                    return ROTATE;
            }
        }

        LoadingLayout createLoadingLayout(Context context, Mode mode, Orientation orientation, TypedArray typedArray) {
            switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$AnimationStyle[ordinal()]) {
                case a.k /*2*/:
                    return new FlipLoadingLayout(context, mode, orientation, typedArray);
                default:
                    return new RotateLoadingLayout(context, mode, orientation, typedArray);
            }
        }
    }

    public enum Mode {
        DISABLED(0),
        PULL_FROM_START(1),
        PULL_FROM_END(2),
        BOTH(3),
        MANUAL_REFRESH_ONLY(4);
        
        public static Mode PULL_DOWN_TO_REFRESH;
        public static Mode PULL_UP_TO_REFRESH;
        private int mIntValue;

        static {
            PULL_DOWN_TO_REFRESH = PULL_FROM_START;
            PULL_UP_TO_REFRESH = PULL_FROM_END;
        }

        private Mode(int i) {
            this.mIntValue = i;
        }

        static Mode getDefault() {
            return PULL_FROM_START;
        }

        static Mode mapIntToValue(int i) {
            for (Mode mode : values()) {
                if (i == mode.getIntValue()) {
                    return mode;
                }
            }
            return getDefault();
        }

        int getIntValue() {
            return this.mIntValue;
        }

        boolean permitsPullToRefresh() {
            return (this == DISABLED || this == MANUAL_REFRESH_ONLY) ? false : PullToRefreshBase.DEBUG;
        }

        public boolean showFooterLoadingLayout() {
            return (this == PULL_FROM_END || this == BOTH || this == MANUAL_REFRESH_ONLY) ? PullToRefreshBase.DEBUG : false;
        }

        public boolean showHeaderLoadingLayout() {
            return (this == PULL_FROM_START || this == BOTH) ? PullToRefreshBase.DEBUG : false;
        }
    }

    public interface OnLastItemVisibleListener {
        void onLastItemVisible();
    }

    public interface OnPullEventListener<V extends View> {
        void onPullEvent(PullToRefreshBase<V> pullToRefreshBase, State state, Mode mode);
    }

    public enum Orientation {
        VERTICAL,
        HORIZONTAL
    }

    final class SmoothScrollRunnable implements Runnable {
        private boolean mContinueRunning = PullToRefreshBase.DEBUG;
        private int mCurrentY = -1;
        private final long mDuration;
        private final Interpolator mInterpolator;
        private OnSmoothScrollFinishedListener mListener;
        private final int mScrollFromY;
        private final int mScrollToY;
        private long mStartTime = -1;

        public SmoothScrollRunnable(int i, int i2, long j, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
            this.mScrollFromY = i;
            this.mScrollToY = i2;
            this.mInterpolator = PullToRefreshBase.this.mScrollAnimationInterpolator;
            this.mDuration = j;
            this.mListener = onSmoothScrollFinishedListener;
        }

        public void run() {
            if (this.mStartTime == -1) {
                this.mStartTime = System.currentTimeMillis();
            } else {
                float f = (float) (this.mScrollFromY - this.mScrollToY);
                this.mCurrentY = this.mScrollFromY - Math.round(this.mInterpolator.getInterpolation(((float) Math.max(Math.min(((System.currentTimeMillis() - this.mStartTime) * 1000) / this.mDuration, 1000), 0)) / 1000.0f) * f);
                PullToRefreshBase.this.setHeaderScroll(this.mCurrentY);
            }
            if (this.mContinueRunning && this.mScrollToY != this.mCurrentY) {
                ViewCompat.postOnAnimation(PullToRefreshBase.this, this);
            } else if (this.mListener != null) {
                this.mListener.onSmoothScrollFinished();
            }
        }

        public void stop() {
            this.mContinueRunning = false;
            PullToRefreshBase.this.removeCallbacks(this);
        }
    }

    public enum State {
        RESET(0),
        PULL_TO_REFRESH(1),
        RELEASE_TO_REFRESH(2),
        REFRESHING(8),
        MANUAL_REFRESHING(9),
        OVERSCROLLING(16);
        
        private int mIntValue;

        private State(int i) {
            this.mIntValue = i;
        }

        static State mapIntToValue(int i) {
            for (State state : values()) {
                if (i == state.getIntValue()) {
                    return state;
                }
            }
            return RESET;
        }

        int getIntValue() {
            return this.mIntValue;
        }
    }

    public PullToRefreshBase(Context context) {
        super(context);
        init(context, null);
    }

    public PullToRefreshBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public PullToRefreshBase(Context context, Mode mode) {
        super(context);
        this.mMode = mode;
        init(context, null);
    }

    public PullToRefreshBase(Context context, Mode mode, AnimationStyle animationStyle) {
        super(context);
        this.mMode = mode;
        this.mLoadingAnimationStyle = animationStyle;
        init(context, null);
    }

    private void addRefreshableView(Context context, T t) {
        this.mRefreshableViewWrapper = new FrameLayout(context);
        this.mRefreshableViewWrapper.addView(t, -1, -1);
        addViewInternal(this.mRefreshableViewWrapper, new LayoutParams(-1, -1));
    }

    private void callRefreshListener() {
        if (this.mOnRefreshListener != null) {
            this.mOnRefreshListener.onRefresh(this);
        } else if (this.mOnRefreshListener2 == null) {
        } else {
            if (this.mCurrentMode == Mode.PULL_FROM_START) {
                this.mOnRefreshListener2.onPullDownToRefresh(this);
            } else if (this.mCurrentMode == Mode.PULL_FROM_END) {
                this.mOnRefreshListener2.onPullUpToRefresh(this);
            }
        }
    }

    private LayoutParams getLoadingLayoutLayoutParams() {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                return new LayoutParams(-2, -1);
            default:
                return new LayoutParams(-1, -2);
        }
    }

    private int getMaximumPullScroll() {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                return Math.round(((float) getWidth()) / FRICTION);
            default:
                return Math.round(((float) getHeight()) / FRICTION);
        }
    }

    private void init(Context context, AttributeSet attributeSet) {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                setOrientation(0);
                break;
            default:
                setOrientation(1);
                break;
        }
        setGravity(17);
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullToRefresh);
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrMode)) {
            this.mMode = Mode.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrMode, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAnimationStyle)) {
            this.mLoadingAnimationStyle = AnimationStyle.mapIntToValue(obtainStyledAttributes.getInteger(R.styleable.PullToRefresh_ptrAnimationStyle, 0));
        }
        this.mRefreshableView = createRefreshableView(context, attributeSet);
        addRefreshableView(context, this.mRefreshableView);
        this.mHeaderLayout = createLoadingLayout(context, Mode.PULL_FROM_START, obtainStyledAttributes);
        this.mFooterLayout = createLoadingLayout(context, Mode.PULL_FROM_END, obtainStyledAttributes);
        Drawable drawable;
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrRefreshableViewBackground)) {
            drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrRefreshableViewBackground);
            if (drawable != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        } else if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrAdapterViewBackground)) {
            Utils.warnDeprecation("ptrAdapterViewBackground", "ptrRefreshableViewBackground");
            drawable = obtainStyledAttributes.getDrawable(R.styleable.PullToRefresh_ptrAdapterViewBackground);
            if (drawable != null) {
                this.mRefreshableView.setBackgroundDrawable(drawable);
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrOverScroll)) {
            this.mOverScrollEnabled = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrOverScroll, DEBUG);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled)) {
            this.mScrollingWhileRefreshingEnabled = obtainStyledAttributes.getBoolean(R.styleable.PullToRefresh_ptrScrollingWhileRefreshingEnabled, false);
        }
        handleStyledAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        updateUIForMode();
    }

    private boolean isReadyForPull() {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mMode.ordinal()]) {
            case l.a /*1*/:
                return isReadyForPullEnd();
            case a.k /*2*/:
                return isReadyForPullStart();
            case a.aQ /*4*/:
                return (isReadyForPullEnd() || isReadyForPullStart()) ? DEBUG : false;
            default:
                return false;
        }
    }

    private void pullEvent() {
        float f;
        float f2;
        int round;
        int footerSize;
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                f = this.mInitialMotionX;
                f2 = this.mLastMotionX;
                break;
            default:
                f = this.mInitialMotionY;
                f2 = this.mLastMotionY;
                break;
        }
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mCurrentMode.ordinal()]) {
            case l.a /*1*/:
                round = Math.round(Math.max(f - f2, 0.0f) / FRICTION);
                footerSize = getFooterSize();
                break;
            default:
                round = Math.round(Math.min(f - f2, 0.0f) / FRICTION);
                footerSize = getHeaderSize();
                break;
        }
        setHeaderScroll(round);
        if (round != 0 && !isRefreshing()) {
            float abs = ((float) Math.abs(round)) / ((float) footerSize);
            switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mCurrentMode.ordinal()]) {
                case l.a /*1*/:
                    this.mFooterLayout.onPull(abs);
                    break;
                default:
                    this.mHeaderLayout.onPull(abs);
                    break;
            }
            if (this.mState != State.PULL_TO_REFRESH && footerSize >= Math.abs(round)) {
                setState(State.PULL_TO_REFRESH, new boolean[0]);
            } else if (this.mState == State.PULL_TO_REFRESH && footerSize < Math.abs(round)) {
                setState(State.RELEASE_TO_REFRESH, new boolean[0]);
            }
        }
    }

    private final void smoothScrollTo(int i, long j) {
        smoothScrollTo(i, j, 0, null);
    }

    private final void smoothScrollTo(int i, long j, long j2, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        int scrollX;
        if (this.mCurrentSmoothScrollRunnable != null) {
            this.mCurrentSmoothScrollRunnable.stop();
        }
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                scrollX = getScrollX();
                break;
            default:
                scrollX = getScrollY();
                break;
        }
        if (scrollX != i) {
            if (this.mScrollAnimationInterpolator == null) {
                this.mScrollAnimationInterpolator = new DecelerateInterpolator();
            }
            this.mCurrentSmoothScrollRunnable = new SmoothScrollRunnable(scrollX, i, j, onSmoothScrollFinishedListener);
            if (j2 > 0) {
                postDelayed(this.mCurrentSmoothScrollRunnable, j2);
            } else {
                post(this.mCurrentSmoothScrollRunnable);
            }
        }
    }

    private final void smoothScrollToAndBack(int i) {
        smoothScrollTo(i, 200, 0, new OnSmoothScrollFinishedListener() {
            public void onSmoothScrollFinished() {
                PullToRefreshBase.this.smoothScrollTo(0, 200, 225, null);
            }
        });
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Log.d(LOG_TAG, "addView: " + view.getClass().getSimpleName());
        View refreshableView = getRefreshableView();
        if (refreshableView instanceof ViewGroup) {
            ((ViewGroup) refreshableView).addView(view, i, layoutParams);
            return;
        }
        throw new UnsupportedOperationException("Refreshable View is not a ViewGroup so can't addView");
    }

    protected final void addViewInternal(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
    }

    protected final void addViewInternal(View view, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, -1, layoutParams);
    }

    protected LoadingLayout createLoadingLayout(Context context, Mode mode, TypedArray typedArray) {
        LoadingLayout createLoadingLayout = this.mLoadingAnimationStyle.createLoadingLayout(context, mode, getPullToRefreshScrollDirection(), typedArray);
        createLoadingLayout.setVisibility(4);
        return createLoadingLayout;
    }

    protected LoadingLayoutProxy createLoadingLayoutProxy(boolean z, boolean z2) {
        LoadingLayoutProxy loadingLayoutProxy = new LoadingLayoutProxy();
        if (z && this.mMode.showHeaderLoadingLayout()) {
            loadingLayoutProxy.addLayout(this.mHeaderLayout);
        }
        if (z2 && this.mMode.showFooterLoadingLayout()) {
            loadingLayoutProxy.addLayout(this.mFooterLayout);
        }
        return loadingLayoutProxy;
    }

    protected abstract T createRefreshableView(Context context, AttributeSet attributeSet);

    public final boolean demo() {
        if (this.mMode.showHeaderLoadingLayout() && isReadyForPullStart()) {
            smoothScrollToAndBack((-getHeaderSize()) * 2);
            return DEBUG;
        } else if (!this.mMode.showFooterLoadingLayout() || !isReadyForPullEnd()) {
            return false;
        } else {
            smoothScrollToAndBack(getFooterSize() * 2);
            return DEBUG;
        }
    }

    protected final void disableLoadingLayoutVisibilityChanges() {
        this.mLayoutVisibilityChangesEnabled = false;
    }

    public final Mode getCurrentMode() {
        return this.mCurrentMode;
    }

    public final boolean getFilterTouchEvents() {
        return this.mFilterTouchEvents;
    }

    protected final LoadingLayout getFooterLayout() {
        return this.mFooterLayout;
    }

    protected final int getFooterSize() {
        return this.mFooterLayout.getContentSize();
    }

    protected final LoadingLayout getHeaderLayout() {
        return this.mHeaderLayout;
    }

    protected final int getHeaderSize() {
        return this.mHeaderLayout.getContentSize();
    }

    public final ILoadingLayout getLoadingLayoutProxy() {
        return getLoadingLayoutProxy(DEBUG, DEBUG);
    }

    public final ILoadingLayout getLoadingLayoutProxy(boolean z, boolean z2) {
        return createLoadingLayoutProxy(z, z2);
    }

    public final Mode getMode() {
        return this.mMode;
    }

    public abstract Orientation getPullToRefreshScrollDirection();

    protected int getPullToRefreshScrollDuration() {
        return SMOOTH_SCROLL_DURATION_MS;
    }

    protected int getPullToRefreshScrollDurationLonger() {
        return SMOOTH_SCROLL_LONG_DURATION_MS;
    }

    public final T getRefreshableView() {
        return this.mRefreshableView;
    }

    protected FrameLayout getRefreshableViewWrapper() {
        return this.mRefreshableViewWrapper;
    }

    public final boolean getShowViewWhileRefreshing() {
        return this.mShowViewWhileRefreshing;
    }

    public final State getState() {
        return this.mState;
    }

    protected void handleStyledAttributes(TypedArray typedArray) {
    }

    public final boolean isDisableScrollingWhileRefreshing() {
        return !isScrollingWhileRefreshingEnabled() ? DEBUG : false;
    }

    public final boolean isPullToRefreshEnabled() {
        return this.mMode.permitsPullToRefresh();
    }

    public final boolean isPullToRefreshOverScrollEnabled() {
        return (VERSION.SDK_INT >= 9 && this.mOverScrollEnabled && OverscrollHelper.isAndroidOverScrollEnabled(this.mRefreshableView)) ? DEBUG : false;
    }

    protected abstract boolean isReadyForPullEnd();

    protected abstract boolean isReadyForPullStart();

    public final boolean isRefreshing() {
        return (this.mState == State.REFRESHING || this.mState == State.MANUAL_REFRESHING) ? DEBUG : false;
    }

    public final boolean isScrollingWhileRefreshingEnabled() {
        return this.mScrollingWhileRefreshingEnabled;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.mIsBeingDragged = false;
            return false;
        } else if (action != 0 && this.mIsBeingDragged) {
            return DEBUG;
        } else {
            float y;
            switch (action) {
                case a.i /*0*/:
                    if (isReadyForPull()) {
                        y = motionEvent.getY();
                        this.mInitialMotionY = y;
                        this.mLastMotionY = y;
                        y = motionEvent.getX();
                        this.mInitialMotionX = y;
                        this.mLastMotionX = y;
                        this.mIsBeingDragged = false;
                        break;
                    }
                    break;
                case a.k /*2*/:
                    if (this.mScrollingWhileRefreshingEnabled || !isRefreshing()) {
                        if (isReadyForPull()) {
                            float y2 = motionEvent.getY();
                            float x = motionEvent.getX();
                            float f;
                            switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
                                case l.a /*1*/:
                                    y = x - this.mLastMotionX;
                                    f = y2 - this.mLastMotionY;
                                    break;
                                default:
                                    y = y2 - this.mLastMotionY;
                                    f = x - this.mLastMotionX;
                                    break;
                            }
                            float abs = Math.abs(y);
                            if (abs > ((float) this.mTouchSlop) && (!this.mFilterTouchEvents || abs > Math.abs(r0))) {
                                if (!this.mMode.showHeaderLoadingLayout() || y < 1.0f || !isReadyForPullStart()) {
                                    if (this.mMode.showFooterLoadingLayout() && y <= GroundOverlayOptions.NO_DIMENSION && isReadyForPullEnd()) {
                                        this.mLastMotionY = y2;
                                        this.mLastMotionX = x;
                                        this.mIsBeingDragged = DEBUG;
                                        if (this.mMode == Mode.BOTH) {
                                            this.mCurrentMode = Mode.PULL_FROM_END;
                                            break;
                                        }
                                    }
                                }
                                this.mLastMotionY = y2;
                                this.mLastMotionX = x;
                                this.mIsBeingDragged = DEBUG;
                                if (this.mMode == Mode.BOTH) {
                                    this.mCurrentMode = Mode.PULL_FROM_START;
                                    break;
                                }
                            }
                        }
                    }
                    return DEBUG;
                    break;
            }
            return this.mIsBeingDragged;
        }
    }

    protected void onPtrRestoreInstanceState(Bundle bundle) {
    }

    protected void onPtrSaveInstanceState(Bundle bundle) {
    }

    protected void onPullToRefresh() {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mCurrentMode.ordinal()]) {
            case l.a /*1*/:
                this.mFooterLayout.pullToRefresh();
                return;
            case a.k /*2*/:
                this.mHeaderLayout.pullToRefresh();
                return;
            default:
                return;
        }
    }

    public final void onRefreshComplete() {
        if (isRefreshing()) {
            setState(State.RESET, new boolean[0]);
        }
    }

    protected void onRefreshing(boolean z) {
        if (this.mMode.showHeaderLoadingLayout()) {
            this.mHeaderLayout.refreshing();
        }
        if (this.mMode.showFooterLoadingLayout()) {
            this.mFooterLayout.refreshing();
        }
        if (!z) {
            callRefreshListener();
        } else if (this.mShowViewWhileRefreshing) {
            OnSmoothScrollFinishedListener anonymousClass1 = new OnSmoothScrollFinishedListener() {
                public void onSmoothScrollFinished() {
                    PullToRefreshBase.this.callRefreshListener();
                }
            };
            switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mCurrentMode.ordinal()]) {
                case l.a /*1*/:
                case a.l /*3*/:
                    smoothScrollTo(getFooterSize(), anonymousClass1);
                    return;
                default:
                    smoothScrollTo(-getHeaderSize(), anonymousClass1);
                    return;
            }
        } else {
            smoothScrollTo(0);
        }
    }

    protected void onReleaseToRefresh() {
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Mode[this.mCurrentMode.ordinal()]) {
            case l.a /*1*/:
                this.mFooterLayout.releaseToRefresh();
                return;
            case a.k /*2*/:
                this.mHeaderLayout.releaseToRefresh();
                return;
            default:
                return;
        }
    }

    protected void onReset() {
        this.mIsBeingDragged = false;
        this.mLayoutVisibilityChangesEnabled = DEBUG;
        this.mHeaderLayout.reset();
        this.mFooterLayout.reset();
        smoothScrollTo(0);
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setMode(Mode.mapIntToValue(bundle.getInt(STATE_MODE, 0)));
            this.mCurrentMode = Mode.mapIntToValue(bundle.getInt(STATE_CURRENT_MODE, 0));
            this.mScrollingWhileRefreshingEnabled = bundle.getBoolean(STATE_SCROLLING_REFRESHING_ENABLED, false);
            this.mShowViewWhileRefreshing = bundle.getBoolean(STATE_SHOW_REFRESHING_VIEW, DEBUG);
            super.onRestoreInstanceState(bundle.getParcelable(STATE_SUPER));
            State mapIntToValue = State.mapIntToValue(bundle.getInt(STATE_STATE, 0));
            if (mapIntToValue == State.REFRESHING || mapIntToValue == State.MANUAL_REFRESHING) {
                setState(mapIntToValue, DEBUG);
            }
            onPtrRestoreInstanceState(bundle);
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected final Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        onPtrSaveInstanceState(bundle);
        bundle.putInt(STATE_STATE, this.mState.getIntValue());
        bundle.putInt(STATE_MODE, this.mMode.getIntValue());
        bundle.putInt(STATE_CURRENT_MODE, this.mCurrentMode.getIntValue());
        bundle.putBoolean(STATE_SCROLLING_REFRESHING_ENABLED, this.mScrollingWhileRefreshingEnabled);
        bundle.putBoolean(STATE_SHOW_REFRESHING_VIEW, this.mShowViewWhileRefreshing);
        bundle.putParcelable(STATE_SUPER, super.onSaveInstanceState());
        return bundle;
    }

    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        Log.d(LOG_TAG, String.format("onSizeChanged. W: %d, H: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
        super.onSizeChanged(i, i2, i3, i4);
        refreshLoadingViewsSize();
        refreshRefreshableViewSize(i, i2);
        post(new Runnable() {
            public void run() {
                PullToRefreshBase.this.requestLayout();
            }
        });
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPullToRefreshEnabled()) {
            return false;
        }
        if (!this.mScrollingWhileRefreshingEnabled && isRefreshing()) {
            return DEBUG;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case a.i /*0*/:
                if (!isReadyForPull()) {
                    return false;
                }
                float y = motionEvent.getY();
                this.mInitialMotionY = y;
                this.mLastMotionY = y;
                y = motionEvent.getX();
                this.mInitialMotionX = y;
                this.mLastMotionX = y;
                return DEBUG;
            case l.a /*1*/:
            case a.l /*3*/:
                if (!this.mIsBeingDragged) {
                    return false;
                }
                this.mIsBeingDragged = false;
                if (this.mState == State.RELEASE_TO_REFRESH && (this.mOnRefreshListener != null || this.mOnRefreshListener2 != null)) {
                    setState(State.REFRESHING, DEBUG);
                    return DEBUG;
                } else if (isRefreshing()) {
                    smoothScrollTo(0);
                    return DEBUG;
                } else {
                    setState(State.RESET, new boolean[0]);
                    return DEBUG;
                }
            case a.k /*2*/:
                if (!this.mIsBeingDragged) {
                    return false;
                }
                this.mLastMotionY = motionEvent.getY();
                this.mLastMotionX = motionEvent.getX();
                pullEvent();
                return DEBUG;
            default:
                return false;
        }
    }

    protected final void refreshLoadingViewsSize() {
        int i;
        int maximumPullScroll = (int) (((float) getMaximumPullScroll()) * 1.2f);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int i2;
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                if (this.mMode.showHeaderLoadingLayout()) {
                    this.mHeaderLayout.setWidth(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.mMode.showFooterLoadingLayout()) {
                    paddingRight = paddingTop;
                    paddingTop = i;
                    i = paddingBottom;
                    paddingBottom = 0;
                    break;
                }
                this.mFooterLayout.setWidth(maximumPullScroll);
                i2 = paddingBottom;
                paddingBottom = -maximumPullScroll;
                paddingRight = paddingTop;
                paddingTop = i;
                i = i2;
                break;
            case a.k /*2*/:
                if (this.mMode.showHeaderLoadingLayout()) {
                    this.mHeaderLayout.setHeight(maximumPullScroll);
                    i = -maximumPullScroll;
                } else {
                    i = 0;
                }
                if (!this.mMode.showFooterLoadingLayout()) {
                    paddingBottom = paddingRight;
                    paddingTop = paddingLeft;
                    paddingRight = i;
                    i = 0;
                    break;
                }
                this.mFooterLayout.setHeight(maximumPullScroll);
                paddingTop = paddingLeft;
                i2 = paddingRight;
                paddingRight = i;
                i = -maximumPullScroll;
                paddingBottom = i2;
                break;
            default:
                i = paddingBottom;
                paddingBottom = paddingRight;
                paddingRight = paddingTop;
                paddingTop = paddingLeft;
                break;
        }
        Log.d(LOG_TAG, String.format("Setting Padding. L: %d, T: %d, R: %d, B: %d", new Object[]{Integer.valueOf(paddingTop), Integer.valueOf(paddingRight), Integer.valueOf(paddingBottom), Integer.valueOf(i)}));
        setPadding(paddingTop, paddingRight, paddingBottom, i);
    }

    protected final void refreshRefreshableViewSize(int i, int i2) {
        LayoutParams layoutParams = (LayoutParams) this.mRefreshableViewWrapper.getLayoutParams();
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                return;
            case a.k /*2*/:
                if (layoutParams.height != i2) {
                    layoutParams.height = i2;
                    this.mRefreshableViewWrapper.requestLayout();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void setDisableScrollingWhileRefreshing(boolean z) {
        setScrollingWhileRefreshingEnabled(!z ? DEBUG : false);
    }

    public final void setFilterTouchEvents(boolean z) {
        this.mFilterTouchEvents = z;
    }

    protected final void setHeaderScroll(int i) {
        Log.d(LOG_TAG, "setHeaderScroll: " + i);
        int maximumPullScroll = getMaximumPullScroll();
        maximumPullScroll = Math.min(maximumPullScroll, Math.max(-maximumPullScroll, i));
        if (this.mLayoutVisibilityChangesEnabled) {
            if (maximumPullScroll < 0) {
                this.mHeaderLayout.setVisibility(0);
            } else if (maximumPullScroll > 0) {
                this.mFooterLayout.setVisibility(0);
            } else {
                this.mHeaderLayout.setVisibility(4);
                this.mFooterLayout.setVisibility(4);
            }
        }
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$Orientation[getPullToRefreshScrollDirection().ordinal()]) {
            case l.a /*1*/:
                scrollTo(maximumPullScroll, 0);
                return;
            case a.k /*2*/:
                scrollTo(0, maximumPullScroll);
                return;
            default:
                return;
        }
    }

    public void setLastUpdatedLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setLastUpdatedLabel(charSequence);
    }

    public void setLoadingDrawable(Drawable drawable) {
        getLoadingLayoutProxy().setLoadingDrawable(drawable);
    }

    public void setLoadingDrawable(Drawable drawable, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setLoadingDrawable(drawable);
    }

    public void setLongClickable(boolean z) {
        getRefreshableView().setLongClickable(z);
    }

    public final void setMode(Mode mode) {
        if (mode != this.mMode) {
            Log.d(LOG_TAG, "Setting mode to: " + mode);
            this.mMode = mode;
            updateUIForMode();
        }
    }

    public void setOnPullEventListener(OnPullEventListener<T> onPullEventListener) {
        this.mOnPullEventListener = onPullEventListener;
    }

    public final void setOnRefreshListener(OnRefreshListener2<T> onRefreshListener2) {
        this.mOnRefreshListener2 = onRefreshListener2;
        this.mOnRefreshListener = null;
    }

    public final void setOnRefreshListener(OnRefreshListener<T> onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
        this.mOnRefreshListener2 = null;
    }

    public void setPullLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setPullLabel(charSequence);
    }

    public void setPullLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setPullLabel(charSequence);
    }

    public final void setPullToRefreshEnabled(boolean z) {
        setMode(z ? Mode.getDefault() : Mode.DISABLED);
    }

    public final void setPullToRefreshOverScrollEnabled(boolean z) {
        this.mOverScrollEnabled = z;
    }

    public final void setRefreshing() {
        setRefreshing(DEBUG);
    }

    public final void setRefreshing(boolean z) {
        if (!isRefreshing()) {
            setState(State.MANUAL_REFRESHING, z);
        }
    }

    public void setRefreshingLabel(CharSequence charSequence) {
        getLoadingLayoutProxy().setRefreshingLabel(charSequence);
    }

    public void setRefreshingLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setRefreshingLabel(charSequence);
    }

    public void setReleaseLabel(CharSequence charSequence) {
        setReleaseLabel(charSequence, Mode.BOTH);
    }

    public void setReleaseLabel(CharSequence charSequence, Mode mode) {
        getLoadingLayoutProxy(mode.showHeaderLoadingLayout(), mode.showFooterLoadingLayout()).setReleaseLabel(charSequence);
    }

    public void setScrollAnimationInterpolator(Interpolator interpolator) {
        this.mScrollAnimationInterpolator = interpolator;
    }

    public final void setScrollingWhileRefreshingEnabled(boolean z) {
        this.mScrollingWhileRefreshingEnabled = z;
    }

    public final void setShowViewWhileRefreshing(boolean z) {
        this.mShowViewWhileRefreshing = z;
    }

    final void setState(State state, boolean... zArr) {
        this.mState = state;
        Log.d(LOG_TAG, "State: " + this.mState.name());
        switch (AnonymousClass4.$SwitchMap$com$handmark$pulltorefresh$library$PullToRefreshBase$State[this.mState.ordinal()]) {
            case l.a /*1*/:
                onReset();
                break;
            case a.k /*2*/:
                onPullToRefresh();
                break;
            case a.l /*3*/:
                onReleaseToRefresh();
                break;
            case a.aQ /*4*/:
            case a.X /*5*/:
                onRefreshing(zArr[0]);
                break;
        }
        if (this.mOnPullEventListener != null) {
            this.mOnPullEventListener.onPullEvent(this, this.mState, this.mCurrentMode);
        }
    }

    protected final void smoothScrollTo(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration());
    }

    protected final void smoothScrollTo(int i, OnSmoothScrollFinishedListener onSmoothScrollFinishedListener) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDuration(), 0, onSmoothScrollFinishedListener);
    }

    protected final void smoothScrollToLonger(int i) {
        smoothScrollTo(i, (long) getPullToRefreshScrollDurationLonger());
    }

    protected void updateUIForMode() {
        ViewGroup.LayoutParams loadingLayoutLayoutParams = getLoadingLayoutLayoutParams();
        if (this == this.mHeaderLayout.getParent()) {
            removeView(this.mHeaderLayout);
        }
        if (this.mMode.showHeaderLoadingLayout()) {
            addViewInternal(this.mHeaderLayout, 0, loadingLayoutLayoutParams);
        }
        if (this == this.mFooterLayout.getParent()) {
            removeView(this.mFooterLayout);
        }
        if (this.mMode.showFooterLoadingLayout()) {
            addViewInternal(this.mFooterLayout, loadingLayoutLayoutParams);
        }
        refreshLoadingViewsSize();
        this.mCurrentMode = this.mMode != Mode.BOTH ? this.mMode : Mode.PULL_FROM_START;
    }
}
